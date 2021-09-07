package org.kavita.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@ComponentScan("org.kavita.controller")
public class WheatherReportController {

	@RequestMapping(value = "/Test", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<String> getwheatherreport(@QueryParam("key")String key) throws Exception {
		key = "t";

		List<String> data = new ArrayList<>();
		final String uri = "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22";

		RestTemplate restTemplate = new RestTemplate();

		String result = restTemplate.getForObject(uri, String.class);

		JSONParser parser = new JSONParser();


		JSONObject jo = new JSONObject(result);


		JSONArray arr = jo.getJSONArray("list");
		List<String> names = new ArrayList<>();
		for (int i = 0; i < arr.length(); i++) {
			String name = arr.getJSONObject(i).getString("name");
			names.add(name);
		}
		for(String i : names) {
			if(i.startsWith(key)) data.add(i);
				System.out.println(i);
		}
		return data;
	}


}
