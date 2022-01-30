package org.template.core.navigator.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.template.core.navigation.Navigation;
import org.template.core.navigator.INavigator;
import org.template.core.strategy.IStrategy;
import org.template.domain.IEntity;
import org.template.domain.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Navigator<T extends IEntity> implements INavigator<T> {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Map<String, Navigation<T>> navigationMap = new HashMap<String, Navigation<T>>();

	@PostConstruct
	public void init() {
		LOG.info("==============================OPERATIONS==============================");
		navigationMap.keySet().forEach(LOG::info);
		LOG.info("=======================================================================");
	}

	@Override
	public Result<T> run(T entity, String operation) {
		return navigate(entity, operation);
	}

	public Result<T> navigate(T entity, String operation) {

		Result<T> result = new Result<T>();
		Navigation<T> navigation = (Navigation<T>) navigationMap.get(operation);

		if (navigation != null) {

			List<IStrategy<T>> strategyList = navigation.getStrategyList();

			for (IStrategy<T> strategy : strategyList) {
				strategy.process(entity, result);
				if (result.isError())
					break;
			}
		} else {
			result.setError(true);
			result.setMessage("Ocorreu um erro ao realizar a operação.");
			LOG.error("NAVEGAÇÃO " + operation + " NÃO ENCONTRADA");
		}

		return result;

	}
}
