package org.template.core.strategy;

import org.template.domain.IEntity;
import org.template.domain.util.Result;

public interface IStrategy<T extends IEntity> {

	void process(T entity, Result<T> result);

}
