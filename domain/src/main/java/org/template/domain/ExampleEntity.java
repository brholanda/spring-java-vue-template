package org.template.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EXAMPLE_ENTITY")
public class ExampleEntity extends DomainEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}