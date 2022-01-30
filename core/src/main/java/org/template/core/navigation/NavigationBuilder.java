package org.template.core.navigation;

import org.template.core.strategy.IStrategy;
import org.template.domain.IEntity;

public class NavigationBuilder<T extends IEntity> {

	private Navigation<T> navigation;

	public NavigationBuilder() {
		this.navigation = new Navigation<T>();
	}

	public NavigationBuilder<T> next(IStrategy<T> activity) {
		navigation.addActivity(activity);
		return this;
	}

	public Navigation<T> build() {
		return navigation;
	}
}