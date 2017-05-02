package com.wbl.rest;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.log4j.Logger;

import com.wbl.base.BaseRestApi;


import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;




public class TwitterRestApi extends BaseRestApi {
	private static Logger logger=Logger.getLogger(TwitterRestApi.class);
	public HttpResponse getAccountSetting(String resource){
		HttpResponse response=null;
		
		HttpGet get=httpGet(resource);
		get.addHeader("content-type","application/json;charset=utf-8");
			
		
		try {
			consumer.sign(get);
			response=client.execute(get);
		} catch (ClientProtocolException e) {
			 logger.error("There is ClientProtocolException");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("There is IOException");
			e.printStackTrace();}
		catch (OAuthMessageSignerException e) {
			logger.error("There is OAuthMessageSignerException");
			e.printStackTrace();
		} catch (OAuthExpectationFailedException e) {
			logger.error("There is OAuthExpectationFailedException");
			e.printStackTrace();
		} catch (OAuthCommunicationException e) {
			logger.error("There is OAuthCommunicationException");
			e.printStackTrace();
		}

		return response;
	}
	
	public HttpResponse postData(String resource,HttpEntity postentity) 
	{
		HttpResponse response=null;
		
		HttpPost post= httpPost(resource);
		try {		
				
		post.setEntity(postentity);
		//post.addHeader("content-type","application/json;charset=utf-8");
		consumer.sign(post);
			
			response=client.execute(post);
		} catch (ClientProtocolException e) {
			 logger.error("There is ClientProtocolException");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("There is IOException");
			e.printStackTrace();}
		catch (OAuthMessageSignerException e) {
			logger.error("There is OAuthMessageSignerException");
			e.printStackTrace();
		} catch (OAuthExpectationFailedException e) {
			logger.error("There is OAuthExpectationFailedException");
			e.printStackTrace();
		} catch (OAuthCommunicationException e) {
			logger.error("There is OAuthCommunicationException");
			e.printStackTrace();
		}
		
		
		return response;
	}

}