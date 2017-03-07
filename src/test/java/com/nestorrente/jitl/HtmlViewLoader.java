package com.nestorrente.jitl;

import java.util.List;

import com.nestorrente.jitl.annotation.Param;

public interface HtmlViewLoader {

	String getUsersView(@Param("users") List<String> userList);

}
