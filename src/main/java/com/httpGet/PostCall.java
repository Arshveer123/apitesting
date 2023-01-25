package com.httpGet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostCall {
	String url = "https://reqres.in/";
	String serviceUrl = "/api/users";
	String uri = url + serviceUrl;

	public CloseableHttpResponse postCall() throws JsonGenerationException, JsonMappingException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(uri);
		postBody p = new postBody("Arshveer123", "Engineer");
		ObjectMapper obj = new ObjectMapper();
		//obj.writeValue(new File("C:\\Users\\HH\\eclipse-workspace\\HttpClientLib\\bodyfile.json"), p);

		String body = obj.writeValueAsString(p);
		System.out.println(body);
		post.setEntity(new StringEntity(body));
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Content-Type", "application/json");
		for (Map.Entry<String, String> e : map.entrySet()) {
			
			post.addHeader(e.getKey(),e.getValue());

		}
		return httpClient.execute(post);

	}
	
	
	
	public void responsebody(CloseableHttpResponse response) throws ParseException, IOException {
	String res=EntityUtils.toString(response.getEntity(),"UTF-8");
	
		JSONObject json=new JSONObject(res);
		ObjectMapper map=new ObjectMapper();
		
		postBody output=map.readValue(res, postBody.class);
		//postBody output=new postBody();
		System.out.println("value of id is-----------------------"+output.getJob());
		System.out.println("value of date is----------------->"+output.getCreatedAt());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
