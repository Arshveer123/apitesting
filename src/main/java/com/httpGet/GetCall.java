package com.httpGet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;



import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class GetCall {
	String url = "https://reqres.in/";
	String resource = "/api/users?page=2";
	String serviceUrl = url + resource;
	

	public CloseableHttpResponse getCall() throws ClientProtocolException, IOException {
//httpgetcall
		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpGet httpGet = new HttpGet(serviceUrl);
		CloseableHttpResponse response = httpClient.execute(httpGet);
		return response;

	}
 public void responseValidation(CloseableHttpResponse response) throws ParseException, IOException {
	int statusCode= response.getStatusLine().getStatusCode();
	System.out.println(statusCode);
	String stringResponse =EntityUtils.toString(response.getEntity(),"UTF-8");
	 JSONObject jsonObj= new JSONObject(stringResponse);
	 System.out.println(jsonObj);
	 
	Header[] headers= response.getAllHeaders();
	for(Header h:headers) {
		System.out.println("Headers are------>"+h.getName()+" and "+h.getValue());
	}
	 
 }

 public CloseableHttpResponse getCallWithHeader() throws ClientProtocolException, IOException  {
	 
	 CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpGet httpGet = new HttpGet(serviceUrl);
		HashMap<String,String>	map =new HashMap<String,String>();
		map.put("Content-Type", "application/json");
	
	for(Map.Entry<String, String> e:map.entrySet()) {
		httpGet.addHeader(e.getKey(),e.getValue());
	}
		return httpClient.execute(httpGet);
	
 }



















}
