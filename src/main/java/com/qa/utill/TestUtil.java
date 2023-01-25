package com.qa.utill;


	import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONArray;
	import org.json.JSONObject;

	public class TestUtil {
		
		
		public static String getValueByJPath(CloseableHttpResponse response, String jpath){
			Object obj = response;
			for(String s : jpath.split("/")) 
				if(!s.isEmpty()) 
					if(!(s.contains("[") || s.contains("]")))
						obj = ((JSONObject) obj).get(s);
					else if(s.contains("[") || s.contains("]"))
						obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
			return obj.toString();
		}
		
		
		
		

	}


