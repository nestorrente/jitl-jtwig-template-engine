package com.nestorrente.jitl.template.jtwig;

import java.util.Map;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.jtwig.environment.DefaultEnvironmentConfiguration;
import org.jtwig.environment.EnvironmentConfiguration;

import com.nestorrente.jitl.template.TemplateProcessor;

public class JtwigTemplateProcessor implements TemplateProcessor {

	private final EnvironmentConfiguration config;

	public JtwigTemplateProcessor() {
		this(new DefaultEnvironmentConfiguration());
	}

	public JtwigTemplateProcessor(EnvironmentConfiguration config) {
		this.config = config;
	}

	@Override
	public String renderString(String templateContents, Map<String, Object> parameters) {
		return this.render(JtwigTemplate.inlineTemplate(templateContents, this.config), parameters);
	}

	@Override
	public String renderResource(String templateResource, Map<String, Object> parameters) {
		return this.render(JtwigTemplate.classpathTemplate(templateResource, this.config), parameters);
	}

	private String render(JtwigTemplate template, Map<String, Object> parameters) {
		return template.render(JtwigModel.newModel(parameters));
	}

}
