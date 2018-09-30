package com.situ.mall.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontIndexController {

	@RequestMapping("/indexFront")
	public String indexBack() {
		return "/index_front";
	}
}
