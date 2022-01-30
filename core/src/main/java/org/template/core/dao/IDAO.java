package org.template.core.dao;

import java.util.List;
import java.util.Optional;

import org.template.domain.IEntity;

public interface IDAO<T extends IEntity, R extends Object> {

	Optional<List<T>> saveAll(List<T> colection);

	Optional<List<T>> findAll();

	Optional<T> findById(R id);

	Optional<T> save(T entity);

	Optional<T> update(T entity);

	Optional<T> delete(T entity);

	void deleteAll();
}