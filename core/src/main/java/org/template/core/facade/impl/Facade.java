package org.template.core.facade.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.transaction.Transactional;

import org.template.core.dao.IDAO;
import org.template.core.facade.IFacade;
import org.template.core.navigator.INavigator;
import org.template.domain.IEntity;
import org.template.domain.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "appFacade")
@Transactional
public class Facade<T extends IEntity, R extends Object> implements IFacade<T, R> {

	private static final String DAO = "DAOImpl";

	@Autowired
	@Qualifier("navigator")
	private INavigator<T> navigator;

	@Autowired
	private Map<String, IDAO<T, R>> mapDAO;

	private Optional<IDAO<T, R>> getDAO(T entity) throws Exception {
		IDAO<T, R> dao = null;
		for (Entry<String, IDAO<T, R>> entry : mapDAO.entrySet()) {
			if (entry.getKey().toLowerCase().equals(entity.getClass().getSimpleName().concat(DAO).toLowerCase())) {
				dao = entry.getValue();
				break;
			}
		}
		return Optional.ofNullable(dao);
	}

	@Override
	public Result<T> save(T entity) throws Exception {
		Result<T> result = navigator.run(entity, "SAVE_" + entity.getClass().getSimpleName().toUpperCase());
		if (!result.isError()) {
			Optional<IDAO<T, R>> optionalDAO = getDAO(entity);
			if (optionalDAO.isPresent()) {
				Optional<T> saved = optionalDAO.get().save(entity);
				result.setResultEntity(saved.get());
			}
		}
		return result;
	}

	@Override
	public Result<T> update(T entity) throws Exception {
		Result<T> result = navigator.run(entity, "UPDATE_" + entity.getClass().getSimpleName().toUpperCase());
		if (!result.isError()) {
			Optional<IDAO<T, R>> optionalDAO = getDAO(entity);
			if (optionalDAO.isPresent()) {
				Optional<T> updated = optionalDAO.get().update(entity);
				result.setResultEntity(updated.get());
			}
		}
		return result;
	}

	@Override
	public Result<T> delete(R id, Class<? extends T> entityClass) throws Exception {
		Result<T> result = new Result<T>();
		Optional<IDAO<T, R>> optionalDAO = getDAO(entityClass.newInstance());
		if (optionalDAO.isPresent()) {
			Optional<T> entityOpt = optionalDAO.get().findById(id);
			T entity = entityOpt.get();
			result = navigator.run(entity, "DELETE_" + entityClass.getSimpleName().toUpperCase());
			if (!result.isError()) {
				optionalDAO.get().delete(entity);
			}
		}
		return result;
	}

	@Override
	public Result<T> findAll(Class<? extends T> clazz) throws Exception {
		Result<T> result = new Result<T>();
		Optional<IDAO<T, R>> optionalDAO = getDAO(clazz.newInstance());
		if (optionalDAO.isPresent()) {
			Optional<List<T>> resultList = optionalDAO.get().findAll();
			result.setResultEntities(resultList.get());
		}
		return result;
	}

	@Override
	public Result<T> findById(R id, Class<? extends T> clazz) throws Exception {
		Result<T> result = new Result<T>();
		Optional<IDAO<T, R>> optionalDAO = getDAO(clazz.newInstance());
		if (optionalDAO.isPresent()) {
			Optional<T> found = optionalDAO.get().findById(id);
			result.setResultEntity(found.get());
		}
		return result;
	}

	@Override
	public Result<T> executeOperation(T entity, String operation) throws Exception {
		Result<T> result = navigator.run(entity, operation);
		return result;
	}

}
