package com.situ.mall.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackIndexController {
	
	@RequestMapping("/indexBack")
	public String indexBack() {
		return "/index_back";
	}
}
