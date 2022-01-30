package org.template.core.navigator;

import org.template.domain.IEntity;
import org.template.domain.util.Result;

public interface INavigator<E extends IEntity> {

	public Result<E> run(E entity, String operation);

}