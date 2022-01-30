package org.template.core.navigation.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.template.core.navigation.Navigation;
import org.template.core.navigation.NavigationBuilder;
import org.template.domain.ExampleEntity;

@Configuration
public class ExampleEntityNavigation {

	@Bean(name = "SAVE_EXAMPLE_ENTITY")
	public Navigation<ExampleEntity> alugarLivro() {
		return new NavigationBuilder<ExampleEntity>().build();
	}

}
