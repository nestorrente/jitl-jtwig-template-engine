# JITL Jtwig Template Engine

## Table of contents
+ **[What is JITL Jtwig Template Engine?](#what-is-jitl-jtwig-template-engine)**
+ **[Usage example](#usage-example)**
+ **[Maven](#maven)**
+ **[Related projects](#related-projects)**

## What is JITL Jtwig Template Engine?

JITL Jtwig Template Engine plugin enhances [JITL](https://github.com/nestorrente/jitl-core) templates, allowing to use the thirty-party template engine [Jtwig](http://jtwig.org/).

## Usage example
**HtmlViews.java:**
```java
package com.example;

public interface HtmlViews {
    String friendsList(User user);
}
```
**User.java:**
```java
package com.example;

public class User {

    private String name;
    private List<User> friends;
    /* other fields... */

    /* getters and setters... */

}
```
**friends_list.tpl:**
```html
<html>
    <head>
        <title>{{ user.name }} friends</title>
    </head>
    <body>

        {% if(empty(user.friends)) %}

            <p>{{ user.name }} has no friends yet.</p>

        {% else %}

            <ul>
                {% for friend in user.friends %}
                    <li>{{ friend.name }}</li>
                {% endfor %}
            </ul>

        {% endif %}

    </body>
</html>
```
**Main.java:**
```java
/* package and imports... */

public class Main {
    public static void main(String[] args) {
        User user = /* whatever... */;

        Jitl jitl = Jitl.builder()
            .setTemplateEngine(new JtwigTemplateEngine())
            .build();

        HtmlViews views = jitl.getInstance(HtmlViews.class);
        String renderedHtml = views.friendsList(user);

    }
}
```
The result of the rendering process of this example would be something like:
```html
<html>
    <head>
        <title>John friends</title>
    </head>
    <body>
        <ul>
            <li>Sandy</li>
            <li>Nick</li>
            <li>Mary</li>
        </ul>
    </body>
</html>
```
**Learn more about JITL in [jitl-core GitHub page](https://github.com/nestorrente/jitl-core).**

## Maven

```xml
<repositories>
	<repository>
		<id>jcenter</id>
		<url>https://jcenter.bintray.com/</url>
	</repository>
</repositories>

<dependencies>
	<dependency>
		<groupId>com.nestorrente</groupId>
		<artifactId>jitl-jtwig-template-engine</artifactId>
		<version>2.0.0</version>
	</dependency>
</dependencies>
```

## Related projects
+ [```jitl-core```](https://github.com/nestorrente/jitl-core)
+ [```jitl-sql-module```](https://github.com/nestorrente/jitl-sql-module)
