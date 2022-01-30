package org.template.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.template.domain.ExampleEntity;

public interface ExampleEntityRepository extends JpaRepository<ExampleEntity, Long> {

}
