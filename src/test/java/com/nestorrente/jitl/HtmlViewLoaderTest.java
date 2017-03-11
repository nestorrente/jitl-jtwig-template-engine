package com.nestorrente.jitl;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import com.nestorrente.jitl.template.jtwig.JtwigTemplateEngine;

public class HtmlViewLoaderTest {

	private static HtmlViewLoader INSTANCE;

	@BeforeClass
	public static void createRepository() throws ClassNotFoundException, SQLException {

		Jitl jitl = new JitlBuilder()
			.setTemplateEngine(new JtwigTemplateEngine())
			.addFileExtension("html")
			.build();

		INSTANCE = jitl.getInstance(HtmlViewLoader.class);

	}

	@Test
	public void getNameReturnsUno() {

		String renderedHtml = INSTANCE.getUsersView(Arrays.asList("harry.potter", "lord.voldemort", "mundungus", "alastor.moody"));

		String expectedHtml = new StringBuilder("<html>\n")
			.append("<head>\n")
			.append("<title>Users</title>\n")
			.append("</head>\n")
			.append("<body>\n")
			.append("\t<h1>Users</h1>\n")
			.append("\t<ul>\n")
			.append("\t\t<li>harry.potter</li>\n")
			.append("\t\n")
			.append("\t\t<li>lord.voldemort</li>\n")
			.append("\t\n")
			.append("\t\t<li>mundungus</li>\n")
			.append("\t\n")
			.append("\t\t<li>alastor.moody</li>\n")
			.append("\t</ul>\n")
			.append("</body>\n")
			.append("</html>")
			.toString();

		assertEquals(expectedHtml, renderedHtml);

	}

}
