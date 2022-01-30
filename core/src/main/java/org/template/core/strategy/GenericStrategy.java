package org.template.core.strategy;

import org.template.domain.IEntity;
import org.template.domain.util.Result;

public abstract class GenericStrategy<T extends IEntity> implements IStrategy<T> {

	protected void setError(Result<T> result, String message) {
		result.setError(true);
		result.setMessage(message);
	}
}
