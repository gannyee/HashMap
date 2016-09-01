package com.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) {
		HashMapDIY<String, String> hashMap = new HashMapDIY<>();
		
		Map<String,String> map = new HashMap<>();
		map.put("a", "asd");
		map.put("b", "sds");
		map.put("c", "dvs");
		map.put("d", "gsa");
		map.put("e", "oup");
		map.put("f", "qdn");
		map.put("g", "zhi");
		map.put("h", "akr");
		map.put("i", "uan");
		map.put("j", "asd");
		map.put("k", "sds");
		map.put("l", "dvs");
		map.put("m", "gsa");
		map.put("n", "oup");
		map.put("o", "qdn");
		map.put("p", "zhi");
		map.put("q", "akr");
		map.put("r", "uan");
		map.put("s", "asd");
		map.put("t", "sds");
		map.put("u", "dvs");
		map.put("v", "gsa");
		map.put("w", "oup");
		map.put("x", "qdn");
		map.put("y", "zhi");
		map.put("z", "akr");
		map.put("12", "uan");
		map.put("13", "asd");
		map.put("21", "sds");
		map.put("31", "dvs");
		
		
		hashMap.putAll(map);
		System.out.println("size: " + hashMap.size());
		System.out.println("hash: " + hashMap);
		System.out.println("keySet: " + hashMap.keySet().size());
		System.out.println("values: " + hashMap.values().size());
		
		hashMap.remove("00sad4");
		
		System.out.println("contains? " + hashMap.containsKey("00sad4"));
		System.out.println("contains? " + hashMap.containsKey("034dasd3"));
		System.out.println("contains? " + hashMap.containsValue("121321"));
		System.out.println("size: " + hashMap.size());
		
		System.out.println("get: " + hashMap.get("00sad4"));
		System.out.println("get: " + hashMap.get("wewsde"));
		System.out.println("get: " + hashMap.get("00asda7"));
		hashMap.put("00sad4", "gsa");
		hashMap.put("adsssd", "oup");
		hashMap.put("wqads", "qdn");
		hashMap.put("00asda7", "zhi");
		hashMap.put("0ad08", "akr");
		hashMap.put("2sad3432ds", "uan");
		hashMap.put("0dds01", "asd");
		hashMap.put("00sadsad2", "sds");
		hashMap.put("0asadasd3", "dvs");
		hashMap.put("0aad4", "gsa");
		hashMap.put("asasd", "oup");
		hashMap.put("wqads", "qdn");
		hashMap.put("0asda7", "zhi");
		hashMap.put("0ass08", "akr");
		hashMap.put("2asas432ds", "uan");
		
		System.out.println("entrySet: " + hashMap.entrySet().size());
		Iterator<Entry<String, String>> iterator = hashMap.entrySet().iterator();
		int i = 1;
		while(iterator.hasNext()){
			Entry<String, String> node = iterator.next();
			System.out.println(i + " >>> "  + node.getKey() + " : " + node.getValue());
			i ++;
		}
		hashMap.clear();
		System.out.println("size: " + hashMap.size());
		System.out.println("hash: " + hashMap);
	}
}
