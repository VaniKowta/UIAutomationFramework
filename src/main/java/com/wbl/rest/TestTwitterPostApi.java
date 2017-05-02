package com.wbl.rest;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.wbl.Helper.Constant;
import com.wbl.Helper.ExcelHelper;

public class TestTwitterPostApi {
	TwitterRestApi twitter=new TwitterRestApi();
	
	@DataProvider(name="postData")
	public Object[][] postData(){
		return ExcelHelper.getData(Constant.PATH+"/rest-data/rest-data.xlsx");
	}

	@Test(dataProvider="postData")
	public void testPostAccountSetting(String resource,String name,String location,String expectedName,String expectedLocation) throws JSONException, IllegalStateException, IOException{
		
	/*JSONObject postObject=new JSONObject();
		postObject.put("name", name);
		postObject.put("location", location);
		StringEntity entity=new StringEntity(postObject.toString());*/
		
		
	List<NameValuePair> nv=new ArrayList<NameValuePair>();
		nv.add(new BasicNameValuePair("name",name));
		nv.add(new BasicNameValuePair("location",location));
		HttpEntity entity=new UrlEncodedFormEntity(nv);
		
		HttpResponse response=twitter.postData(resource,entity);
			System.out.println(response.getStatusLine().getStatusCode());
	
		
			JSONObject jsonresponse=new JSONObject(IOUtils.toString(response.getEntity().getContent()));
			System.out.println(jsonresponse.get("screen_name"));
			System.out.println(jsonresponse.get("name"));
			System.out.println(jsonresponse.get("location"));
			assertEquals(200,(response.getStatusLine().getStatusCode()));
			 assertEquals(expectedName, jsonresponse.get("name"));
			assertEquals("Vani_7782",jsonresponse.get("screen_name"));
			 assertEquals(expectedLocation,jsonresponse.get("location"));
	
		
	}


}