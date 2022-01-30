package org.template.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.template.core.facade.IFacade;
import org.template.domain.IEntity;
import org.template.domain.util.Result;
import org.template.rest.response.ResponseMessage;

@RequestMapping("/")
@CrossOrigin(origins = "*")
public abstract class DomainEntityController<T extends IEntity, R extends Object> {

	private Logger LOG;

	@Autowired
	@Qualifier("appFacade")
	protected IFacade<T, R> applicationFacade;

	protected Class<? extends T> clazz;

	public DomainEntityController(Class<? extends T> clazz) {
		this.clazz = clazz;
	}

	protected Logger getLogger(Class<?> clazz) {
		if (LOG == null) {
			LOG = LoggerFactory.getLogger(clazz);
		}
		return LOG;
	}

	@PostMapping
	public @ResponseBody ResponseEntity<?> postEntity(@RequestBody T entity) {
		try {
			Result<T> result = applicationFacade.save(entity);

			return proccessSingleResult(result);

		} catch (Exception e) {
			return proccessError(e);
		}
	}

	@PutMapping
	public @ResponseBody ResponseEntity<?> putEntity(@RequestBody T entity) {
		try {
			Result<T> result = applicationFacade.update(entity);

			return proccessSingleResult(result);

		} catch (Exception e) {
			return proccessError(e);
		}
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody ResponseEntity<?> getEntityById(@PathVariable R id) {
		try {
			Result<T> result = applicationFacade.findById(id, clazz);

			return proccessSingleResult(result);

		} catch (Exception e) {
			return proccessError(e);
		}
	}

	@GetMapping
	public @ResponseBody ResponseEntity<?> getEntities() {
		try {
			Result<T> result = applicationFacade.findAll(clazz);

			return proccessResultList(result);

		} catch (Exception e) {
			return proccessError(e);
		}
	}

	@DeleteMapping
	public @ResponseBody ResponseEntity<?> delete(R id) {
		try {

			Result<T> result = applicationFacade.delete(id, clazz);

			return proccessSingleResult(result);

		} catch (Exception e) {
			return proccessError(e);
		}
	}

	protected ResponseEntity<?> proccessSingleResult(Result<T> result) {
		IEntity resultEntity = result.getResultEntity();

		if (result.isError())
			return ResponseMessage.serverError(result.getMessage());
		else if (resultEntity != null)
			return ResponseEntity.ok(resultEntity);
		else
			return ResponseEntity.noContent().build();
	}

	protected ResponseEntity<?> proccessResultList(Result<T> result) {
		if (result.isError())
			return ResponseMessage.serverError(result.getMessage());
		else if (!CollectionUtils.isEmpty(result.getResultEntities()))
			return ResponseEntity.ok(result.getResultEntities());
		else
			return ResponseEntity.noContent().build();
	}

	protected ResponseEntity<?> proccessError(Exception e) {
		getLogger(clazz).error(e.getMessage(), e);
		return ResponseMessage.serverError("Ocorreu um erro ao realizar a operação.");
	}
}
