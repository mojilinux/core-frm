package com.core.framework.web.controller.enums;

import com.core.framework.web.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("enum")
public class EnumController extends BaseController {

	@GetMapping("list")
	public static String[] getNames(String className) throws ClassNotFoundException {
		Class<? extends Enum<?>> aClass = (Class<? extends Enum<?>>) Class.forName(className);
		return Arrays.stream(aClass.getEnumConstants()).map(Enum::name).toArray(String[]::new);
	}

	@GetMapping("roles")
	public static String[] getRoles() throws ClassNotFoundException {
		return null;
	}

}
