package com.nestorrente.jitl.template.jtwig;

import java.util.Map;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.jtwig.environment.DefaultEnvironmentConfiguration;
import org.jtwig.environment.EnvironmentConfiguration;

import com.nestorrente.jitl.template.TemplateEngine;

public class JtwigTemplateEngine implements TemplateEngine {

	private final EnvironmentConfiguration config;

	public JtwigTemplateEngine() {
		this(new DefaultEnvironmentConfiguration());
	}

	public JtwigTemplateEngine(EnvironmentConfiguration config) {
		this.config = config;
	}

	@Override
	public String renderString(String templateContents, Map<String, Object> parameters) {
		return this.render(JtwigTemplate.inlineTemplate(templateContents, this.config), parameters);
	}

	private String render(JtwigTemplate template, Map<String, Object> parameters) {
		return template.render(JtwigModel.newModel(parameters));
	}

}
