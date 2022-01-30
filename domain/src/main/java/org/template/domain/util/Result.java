package org.template.domain.util;

import java.util.List;

import org.template.domain.IEntity;

public class Result<T extends IEntity> {

	private T resultEntity;
	private List<T> resultEntities;
	private String message;
	private boolean error;

	public Result() {
		this.error = false;
	}

	public T getResultEntity() {
		return resultEntity;
	}

	public void setResultEntity(T resultEntity) {
		this.resultEntity = resultEntity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public List<T> getResultEntities() {
		return resultEntities;
	}

	public void setResultEntities(List<T> resultEntities) {
		this.resultEntities = resultEntities;
	}

}
