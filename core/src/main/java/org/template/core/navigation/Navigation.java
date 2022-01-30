package org.template.core.navigation;

import java.util.ArrayList;
import java.util.List;

import org.template.core.strategy.IStrategy;
import org.template.domain.IEntity;

public class Navigation<T extends IEntity> {

	private List<IStrategy<T>> strategyList;

	public Navigation() {
		this.strategyList = new ArrayList<>();
	}

	public void addActivity(IStrategy<T> strategy) {
		this.strategyList.add(strategy);
	}

	public List<IStrategy<T>> getStrategyList() {
		return strategyList;
	}

}