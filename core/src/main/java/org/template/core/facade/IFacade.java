package org.template.core.facade;

import org.template.domain.IEntity;
import org.template.domain.util.Result;

public interface IFacade<T extends IEntity, R extends Object> {

	Result<T> save(T entity) throws Exception;

	Result<T> update(T entity) throws Exception;

	Result<T> delete(R id, Class<? extends T> entityClass) throws Exception;

	Result<T> findAll(Class<? extends T> clazz) throws Exception;

	Result<T> findById(R id, Class<? extends T> clazz) throws Exception;

	Result<T> executeOperation(T entity, String operation) throws Exception;

}