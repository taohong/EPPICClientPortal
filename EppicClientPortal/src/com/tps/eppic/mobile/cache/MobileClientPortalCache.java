package com.tps.eppic.mobile.cache;

import java.util.HashMap;
import java.util.Map;

public class MobileClientPortalCache {
	
	//support field
	//CardAndBalance, personId
	
	public static final String KEY_CARD_AND_BALANCE = "CardAndBalance";
	public static final String KEY_PERSON_ID = "personId";
	

	private Map<String, Object> cache = new HashMap<String, Object>();
	
	private static MobileClientPortalCache instance = new MobileClientPortalCache();
	
	private MobileClientPortalCache(){
		
	}
	
	public static MobileClientPortalCache getInstance(){
		return instance;
	}
	
	public Object getElement(String key){
		return cache.get(key);
	}
	
	public void setElement(String key, Object value){
		cache.put(key,  value);
	}
}
