package com.hashMap;

import java.util.Map.Entry;

public class MyEntry<K,V> implements Entry<K, V> {
	
	private K key;
	private V value;
	private MyEntry<K, V> next;
	
	@Override
	public K getKey() {
		return key;
	}
	@Override
	public V getValue() {
		return value;
	}
	@Override
	public V setValue(V value) {
		this.value = value;
		return value;
	}
	public MyEntry<K, V> getNext() {
		return next;
	}
	public void setNext(MyEntry<K, V> next) {
		this.next = next;
	}
	public void setKey(K key) {
		this.key = key;
	}
	
	
}
