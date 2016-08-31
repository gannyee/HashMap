package com.hashmap;

public class Main {
	public static void main(String[] args) {
		HashMapDIY<String, String> hashMap = new HashMapDIY<>();
		
		hashMap.put("001", "asd");
		hashMap.put("002", "sds");
		hashMap.put("003", "dvs");
		hashMap.put("004", "gsa");
		hashMap.put("005", "oup");
		hashMap.put("006", "qdn");
		hashMap.put("007", "zhi");
		hashMap.put("008", "akr");
		hashMap.put("009", "uan");
		System.out.println("hashMap:\n" + hashMap);
		System.out.println("size: " + hashMap.size());
		System.out.println("is empty? " + hashMap.isEmpty());
		System.out.println("get: " + hashMap.get("003"));
		hashMap.remove("001");
		System.out.println("size: " + hashMap.size());
		System.out.println("hashMap:\n" + hashMap);
	}
}
