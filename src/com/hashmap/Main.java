package com.hashmap;

public class Main {
	public static void main(String[] args) {
		HashMapDIY<String, String> hashMap = new HashMapDIY<>();
		
		hashMap.put("0sads01", "asd");
		hashMap.put("00sadsad2", "sds");
		hashMap.put("00sadasd3", "dvs");
		hashMap.put("00sad4", "gsa");
		hashMap.put("asasd", "oup");
		hashMap.put("wqads", "qdn");
		hashMap.put("00asda7", "zhi");
		hashMap.put("0as08", "akr");
		hashMap.put("2ssd2ds", "uan");
		hashMap.put("0sads01", "asd");
		hashMap.put("0sd2", "sds");
		hashMap.put("00ssdasd3", "dvs");
		hashMap.put("00ss", "gsa");
		hashMap.put("asasd", "oup");
		hashMap.put("wqads", "qdn");
		hashMap.put("00asda7", "zhi");
		hashMap.put("0sdf8", "akr");
		hashMap.put("2sd3432ds", "uan");
		hashMap.put("0sads01", "asd");
		hashMap.put("ssadsd2", "sds");
		hashMap.put("00sadasd3", "dvs");
		hashMap.put("00sad4", "gsa");
		hashMap.put("assdd", "oup");
		hashMap.put("wewsde", "qdn");
		hashMap.put("00asda7", "zhi");
		hashMap.put("0as08", "akr");
		hashMap.put("2sad3432ds", "uan");
		hashMap.put("0sads01", "asd");
		hashMap.put("0sd3dsad2", "sds");
		hashMap.put("034dasd3", "dvs");
		
		
		System.out.println("size: " + hashMap.size());
		System.out.println("hash: " + hashMap);
		
		
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
		
		System.out.println("entrySet : " + hashMap.entrySet().size());
		hashMap.clear();
		System.out.println("size: " + hashMap.size());
		System.out.println("hash: " + hashMap);
	}
}
