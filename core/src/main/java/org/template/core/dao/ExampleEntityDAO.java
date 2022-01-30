package org.template.core.dao;

import org.template.domain.ExampleEntity;

public abstract class ExampleEntityDAO extends GenericDAO<ExampleEntity, Long> {

	public ExampleEntityDAO() {
		super(ExampleEntity.class);
	}

}
