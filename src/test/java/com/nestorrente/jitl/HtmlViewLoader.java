package com.nestorrente.jitl;

import com.nestorrente.jitl.annotation.param.ParamName;

import java.util.List;

public interface HtmlViewLoader {

	String getUsersView(@ParamName("users") List<String> userList);

}
