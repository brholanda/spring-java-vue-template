package org.template.core.dao;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.template.domain.IEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public abstract class GenericDAO<T extends IEntity, R extends Object> implements IDAO<T, R> {

	final static Logger LOG = LoggerFactory.getLogger(GenericDAO.class);

	private Class<T> persistentClass;

	@Autowired
	private BeanFactory beanFactory;

	@PersistenceContext
	protected EntityManager em;

	private JpaRepository<T, R> repository;

	public GenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		StringBuffer stringBuffer = new StringBuffer();
		String qualifier = persistentClass.getSimpleName().concat("Repository");
		if (qualifier.length() > 1) {
			stringBuffer.append(qualifier.substring(0, 1).toLowerCase());
			stringBuffer.append(qualifier.subSequence(1, qualifier.length()));
		}
		qualifier = stringBuffer.toString();
		repository = beanFactory.getBean(qualifier, JpaRepository.class);
	}

	@Override
	public Optional<T> findById(R id) {
		return repository.findById(id);
	}

	@Override
	public Optional<List<T>> saveAll(List<T> collection) {
		List<T> resultList = repository.saveAll(collection);
		Optional<List<T>> optionalList = Optional.of(resultList);
		return optionalList;
	}

	@Override
	public Optional<List<T>> findAll() {
		List<T> resultList = repository.findAll();
		return Optional.ofNullable(resultList);
	}

	@Override
	public Optional<T> save(T entity) {
		entity = repository.save(entity);
		return Optional.of(entity);
	}

	@Override
	public Optional<T> update(T entity) {
		return save(entity);
	}

	@Override
	public Optional<T> delete(T entity) {
		repository.delete(entity);
		return Optional.of(entity);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	public JpaRepository<T, R> getRepository() {
		return repository;

	}
}
