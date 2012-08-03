package com.tps.eppic.mobile.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.tps.eppic.mobile.bean.CardAndBalance;
import com.tps.eppic.mobile.cache.MobileClientPortalCache;

public class CardAndBalanceInquiryManager {
	
	private static CardAndBalanceInquiryManager instance = new CardAndBalanceInquiryManager();
	
	private CardAndBalanceInquiryManager(){
		
	}
	
	public static CardAndBalanceInquiryManager getInstance(){
		return instance;
	}
	
	public CardAndBalance getCardAndBalance(boolean forceRefresh){
		Integer personId = (Integer)MobileClientPortalCache.getInstance().getElement(MobileClientPortalCache.KEY_PERSON_ID);
		if(personId == null){
			return null;
		}
		
		CardAndBalance cardholder = (CardAndBalance)MobileClientPortalCache.getInstance().getElement(MobileClientPortalCache.KEY_CARD_AND_BALANCE);
		if(forceRefresh || cardholder==null){
			String url = "http://10.237.88.108:8080/MobilePlatformDemo/ClientCardAndBalanceServlet?personId="+personId;
			String json = getJsonFromServer(url);
			cardholder = convertJson2CardAndBalance(json);
			MobileClientPortalCache.getInstance().setElement(MobileClientPortalCache.KEY_CARD_AND_BALANCE, cardholder);
		}
		
		return cardholder;
	}
	
	private String getJsonFromServer(String url){
		HttpURLConnection conn = null;
		String response = null;
		try {
			URL console = new URL(url);
			conn = (HttpURLConnection) console.openConnection();
			conn.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			response = reader.readLine();
			
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private CardAndBalance convertJson2CardAndBalance(String json){
		CardAndBalance cardholder = new CardAndBalance();
		JSONTokener jsonParser = new JSONTokener(json);
		JSONObject personJson;
		try {
			personJson = (JSONObject) jsonParser.nextValue();
			cardholder.setPersonId(personJson.getInt("personId"));
			cardholder.setFirstName(personJson.getString("firstName"));
			cardholder.setLastName(personJson.getString("lastName"));
			cardholder.setAddress1(personJson.getString("address1"));
			cardholder.setAddress2(personJson.getString("address2"));
			cardholder.setCity(personJson.getString("city"));
			cardholder.setState(personJson.getString("state"));
			cardholder.setZip(personJson.getString("zip"));
			cardholder.setPan(personJson.getString("pan"));
			cardholder.setBalance(personJson.getString("balance"));
			cardholder.setNotifMethod(personJson.getString("notifMethod"));
			cardholder.setNotif(personJson.getString("notif"));
			
			return cardholder;
			
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
