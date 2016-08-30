package com.hashMap;

import java.util.HashMap;

public interface HashMapInterface<K,V> {
	//Put new entry
	public void put(K key,V value);
	//Alter specify entry via assigned key parameter
	public V alter(K key,V value);
	//Delete specify entry via assigned key parameter
	public void delete(K key);
	//Get specify entry value
	public V get(K key);
	//Clean the hashMap
	public void clean();
	//Whether contains specify value or not
	public boolean contains(V value);
	//Hash function for key hash calculation
	public int hash(K key);
	//Key validate
	public void validateKey(K key);
	//hashMap size
	public int size();
	//Is empty hashMap or not
	public boolean isEmpty();
}
