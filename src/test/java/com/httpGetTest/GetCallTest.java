package com.httpGetTest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.httpGet.GetCall;
import com.httpGet.PostCall;


public class GetCallTest {
	GetCall getCall;
	PostCall postCall;
	
	
	@Test
	public void getTest() throws ClientProtocolException, IOException {
		getCall=new GetCall();
		CloseableHttpResponse response=getCall.getCall();
		getCall.responseValidation(response);
	}
	
	@Test
	public void getcallwithheader() throws ClientProtocolException, IOException {
		getCall= new GetCall();
		CloseableHttpResponse res=getCall.getCallWithHeader();
		getCall.responseValidation(res);
		
	}

	@Test
	public void postcall() throws JsonGenerationException, JsonMappingException, IOException {
		postCall=new PostCall();
		CloseableHttpResponse response=postCall.postCall();
		getCall=new GetCall();
		getCall.responseValidation(response);
		postCall.responsebody(response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
