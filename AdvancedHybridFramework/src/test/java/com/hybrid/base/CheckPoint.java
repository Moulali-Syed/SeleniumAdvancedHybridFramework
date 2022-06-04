package com.hybrid.base;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;

public class CheckPoint {

	//this will store result of every checkpoint which used to be assert statement
	public static HashMap<String,String> resultMap = new HashMap<String,String>();
	private static String PASS = "PASS";
	private static String FAIL = "FAIL";
	
	public static void clearHashMap() {
		System.out.println("Clearing results of HashMap");
		resultMap.clear();
	}
	
	private static void setStatus(String mapKey,String status) {
		resultMap.put(mapKey, status);
		System.out.println(mapKey + "->" + resultMap.get(mapKey));
	}
	
	public static void mark(String testName,boolean result,String resultMessage) {
		testName = testName.toLowerCase();
		String mapKey = testName+"."+resultMessage;
		try {
			if(result) {
				setStatus(mapKey,PASS);
			}else {
				setStatus(mapKey,FAIL);
			}
		}catch(Exception e) {
			setStatus(mapKey,FAIL);
			e.printStackTrace();
		}
	}
	
	public static void markFinal(String testName,boolean result,String resultMessage) {
		testName = testName.toLowerCase();
		String mapKey = testName+"."+resultMessage;
		try {
			if(result) {
				setStatus(mapKey,PASS);
			}else {
				setStatus(mapKey,FAIL);
			}
		}catch(Exception e) {
			setStatus(mapKey,FAIL);
			e.printStackTrace();
		}
		ArrayList<String> resultList = new ArrayList<String>();
		for(String key:resultMap.keySet()) {
			resultList.add(resultMap.get(key));
		}
		for(int i=0;i<resultList.size();i++) {
			if(resultList.contains(FAIL)) {
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
	}
	
//	In every test method if there are morethan one assertions call mark() in place of every assertion
//	and in place of last assertion call markFinal
}
