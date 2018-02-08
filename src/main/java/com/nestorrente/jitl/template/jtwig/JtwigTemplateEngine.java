package com.nestorrente.jitl.template.jtwig;

import com.nestorrente.jitl.template.TemplateEngine;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.jtwig.environment.DefaultEnvironmentConfiguration;
import org.jtwig.environment.EnvironmentConfiguration;

import java.util.Map;

public class JtwigTemplateEngine implements TemplateEngine {

	private final EnvironmentConfiguration config;

	public JtwigTemplateEngine() {
		this(new DefaultEnvironmentConfiguration());
	}

	public JtwigTemplateEngine(EnvironmentConfiguration config) {
		this.config = config;
	}

	@Override
	public String render(String templateContents, Map<String, Object> parameters) {

		JtwigTemplate template = JtwigTemplate.inlineTemplate(templateContents, this.config);
		JtwigModel model = JtwigModel.newModel(parameters);

		return template.render(model);

	}

}
