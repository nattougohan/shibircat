package com.animal.shibircat.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.animal.shibircat.domain.service.RestService;

@Controller
public class ResultController {
	
	@Autowired
	RestService service;
	
	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}
	
	@PostMapping("/index")
	public String getResult(@RequestParam("animal")String animal, Model model) {
		
		// 受け取った文字列を使ってAPIを実行して返ってきたURLを取得する
		// 返ってくるときはJSON形式のため、不要な[]と""を取り除く。
		String resUrl = service.apiExecute(animal).replace("[", "").replace("]", "").replace("\"", "");
		
		// APIの実行結果をmodelに格納
		model.addAttribute("resUrl", resUrl);
		System.out.println(resUrl);
		
		return "index";
	}

}
