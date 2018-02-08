package com.nestorrente.jitl;

import com.nestorrente.jitl.annotation.param.Param;

import java.util.List;

public interface HtmlViewLoader {

	String getUsersView(@Param("users") List<String> userList);

}
