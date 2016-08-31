package com.hashmap;

import java.util.Map.Entry;

public class Node<K,V> implements Entry<K, V>{

	private K key;
	private V value;
	private int hash;
	private Node<K,V> next;
	
	public Node(int hash,K key,V value, Node<K, V> next) {
		this.key = key;
		this.value = value;
		this.hash = hash;
		this.next = next;
	}
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

	public void setKey(K key) {
		this.key = key;
	}

	public Node<K,V> getNext() {
		return next;
	}

	public void setNext(Node<K,V> next) {
		this.next = next;
	}
	/**
	 * @return the hash
	 */
	public int getHash() {
		return hash;
	}
	/**
	 * @param hash the hash to set
	 */
	public void setHash(int hash) {
		this.hash = hash;
	}

	
}
