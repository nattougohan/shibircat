package com.animal.shibircat.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	// APIの実行
	public String apiExecute(String animal) {
		return restTemplate.getForObject("http://shibe.online/api/{animal}?count=1&urls=true&httpsUrls=true", String.class, animal);
	}

}
