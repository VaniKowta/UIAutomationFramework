package com.wbl.base;


import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import com.wbl.Helper.Constant;
import com.wbl.Helper.HelperConfig;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;



public class BaseRestApi {
	public HttpClient client= HttpClientBuilder.create().build();
	public  final OAuthConsumer consumer;

	public BaseRestApi() {	
		
		HelperConfig.getConfig(Constant.PATH+"config.properties");
 
	 consumer=new CommonsHttpOAuthConsumer(HelperConfig.consumerKey, HelperConfig.consumerSecret);
	consumer.setTokenWithSecret(HelperConfig.tokenkey, HelperConfig.tokensecret);
	}
	

	
	public  HttpGet httpGet(String resource){
		HttpGet get= new HttpGet(HelperConfig.endpoint+resource);
				return get;
	}

	public  HttpPost httpPost(String resource){
		HttpPost post= new HttpPost(HelperConfig.endpoint+resource);
				return post;
	}

}