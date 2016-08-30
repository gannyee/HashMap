package com.hashMap;

public class Main {

	public static void main(String[] args) {
		
		HashMapDIY<String, String> map = new HashMapDIY<String,String>();
		map.put("001", "James");  
		map.put("002", "Antony");
		map.put("003", "Bosh");
		map.put("004", "WestBrook");
		map.put("004", "Wade");
		
		map.put("005", "James");  
		map.put("006", "Antony");
		map.put("007", "Bosh");
		map.put("008", "WestBrook");
		map.put("009", "Wade");
		
		map.put("0010", "James");  
		map.put("0011", "Antony");
		map.put("0012", "Bosh");
		map.put("0013", "WestBrook");
		map.put("0014", "Wade");
		
		map.put("0015", "James");  
		map.put("0016", "Antony");
		map.put("0017", "Bosh");
		map.put("0018", "WestBrook");
		map.put("0019", "Wade");
		
		
//		System.out.println("all value: " + map);
		System.out.println("size: " + map.size());
		System.out.println(map.get("004"));
		System.out.println(map.get("004"));
		System.out.println("is empty: " + map.isEmpty());
		map.remove("003");
		map.remove("0019");
//		System.out.println("all value: " + map);
		System.out.println("size: " + map.size());
		
	}

}
