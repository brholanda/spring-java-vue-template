package org.template.rest.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.template.domain.ExampleEntity;
import org.template.rest.controller.DomainEntityController;

@Controller
@RequestMapping("${server.controller.prefix}example")
public class ExampleEntityController extends DomainEntityController<ExampleEntity, Long> {

	public ExampleEntityController() {
		super(ExampleEntity.class);
	}

}
