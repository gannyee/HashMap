package com.hashmap.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.hashmap.HashMapDIY;

public class HashMapDIYTest {

	HashMapDIY<Integer, String> hashMap = new HashMapDIY<>();

	@Test
	public void testSize() {
		hashMap.put(1, "a");
		hashMap.put(2, "b");
		hashMap.put(3, "c");
		hashMap.put(4, "d");
		hashMap.put(5, "e");
		hashMap.put(6, "f");
		assertEquals(6,hashMap.size());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true,hashMap.isEmpty());
		hashMap.put(1, "a");
		hashMap.put(2, "b");
		hashMap.put(3, "c");
		hashMap.put(4, "d");
		hashMap.put(5, "e");
		hashMap.put(6, "f");
		assertEquals(false,hashMap.isEmpty());
	}

	@Test
	public void testContainsKey() {
		hashMap.put(1, "a");
		hashMap.put(2, "b");
		hashMap.put(3, "c");
		hashMap.put(4, "d");
		hashMap.put(5, "e");
		hashMap.put(6, "f");
		assertEquals(false,hashMap.containsKey(8));
		assertEquals(true,hashMap.containsKey(6));
	}

	@Test
	public void testContainsValue() {
		hashMap.put(1, "a");
		hashMap.put(2, "b");
		hashMap.put(3, "c");
		hashMap.put(4, "d");
		hashMap.put(5, "e");
		hashMap.put(6, "f");
		assertEquals(true, hashMap.containsValue("a"));
		assertEquals(false, hashMap.containsValue("aa"));
	}

	@Test
	public void testGet() {
		hashMap.put(1, "a");
		hashMap.put(2, "b");
		hashMap.put(3, "c");
		hashMap.put(4, "d");
		hashMap.put(5, "e");
		hashMap.put(6, "f");
		assertEquals("e",hashMap.get(5));
	}

	@Test
	public void testPut() {
		hashMap.put(6, "f");
		assertEquals(true, hashMap.containsKey(6));
		assertEquals(true, hashMap.containsValue("f"));
	}

	@Test
	public void testRemove() {
		hashMap.put(1, "a");
		hashMap.put(2, "b");
		hashMap.put(3, "c");
		hashMap.put(4, "d");
		hashMap.put(5, "e");
		hashMap.put(6, "f");
		hashMap.remove(2);
		assertEquals(false, hashMap.containsKey(2));
		assertEquals(false, hashMap.containsValue("b"));
	}

	@Test
	public void testPutAll() {
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "asd");
		map.put(2, "sds");
		map.put(3, "dvs");
		map.put(4, "gsa");
		map.put(5, "oup");
		hashMap.putAll(map);
		assertEquals(5,hashMap.size());
		assertEquals(true,hashMap.containsKey(1));
		assertEquals(true,hashMap.containsValue("asd"));
	}

	@Test
	public void testClear() {
		hashMap.put(1, "a");
		hashMap.put(2, "b");
		hashMap.put(3, "c");
		hashMap.put(4, "d");
		hashMap.put(5, "e");
		hashMap.put(6, "f");
		hashMap.clear();
		assertEquals(true, hashMap.isEmpty());
	}

}
