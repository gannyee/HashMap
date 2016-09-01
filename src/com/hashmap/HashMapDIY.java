package com.hashmap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDIY<K,V> implements Map<K, V>{

	private int size = 0;
	private int capacity = 1;
	private static final int  DEFAULT_CAPACITY = 16;
	private static double A = (Math.pow(5, 0.5) - 1) / 2;
	Node<K, V>[] buckets;
	
	public HashMapDIY() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public HashMapDIY(int capacity){
		if(capacity <= 0){
			throw new IllegalArgumentException("capacity can not be negative or zero");
		}
		
		int temp = 1;
		while(temp < capacity){
			temp <<= 2;
		}
		this.capacity = temp;
		buckets = new Node[this.capacity];
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		if(key == null || buckets.length == 0)
			return false;
		
		int hash = hash(key.hashCode());
		int index = index(hash, buckets.length);
		
		for(Node<K, V> node = buckets[index];node != null;node = node.getNext()){
			if(node.getHash() == hash && (key == node.getKey() || key.equals(node.getKey()))){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {

		for(Node<K, V> node : buckets){
			for(;node != null;node = node.getNext()){
				if(node.getValue().equals(value) || node.getValue() == value){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		if(key == null)
			return null;
		
		int hash = hash(key.hashCode());
		int index = index(hash, buckets.length);
		
		for(Node<K, V> node = buckets[index];node != null;node = node.getNext()){
			if(node.getHash() == hash && (key == node.getKey() || key.equals(node.getKey()))){
				return node.getValue();
			}
		}
		return null;
		
	}

	@Override
	public V put(K key, V value) {
		if(key == null)
			return null;
		
		int hash = hash(key.hashCode());
		int index = index(hash, buckets.length);
		
		for(Node<K, V> node = buckets[index];node != null;node = node.getNext()){
			if(node.getHash() == hash && (key == node.getKey() || key.equals(node.getKey()))){
				V oldValue = node.getValue();
				node.setValue(value);
				return oldValue;
			}
		}
		
		addEntry(hash, key, value, index);
		size ++;
		return null;
	}

	@Override
	public V remove(Object key) {
		if(key == null)
			return null;
		
		V value = null;

		int hash = hash(key.hashCode());
		int index = index(hash, buckets.length);
		
		Node<K, V> node = buckets[index];
		
		if(node == null){
			return null;
		}
		
		if (node.getKey() == key) {
			buckets[index] = node.getNext();
			size--;
		}
		
		
		while (node.getNext() != null) {
			if (node.getNext().getKey() == key) {
				value = node.getNext().getValue();
				node.setNext(node.getNext().getNext());
				size--;
				break;
			}
			node = node.getNext();
		}
		return value;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		Iterator<?> iterator = m.entrySet().iterator();
		if(iterator.hasNext()){
			Node<K, V> node = (Node<K, V>) iterator.next();
			put(node.getKey(), node.getValue());
		}
		
	}

	@Override
	public void clear() {
		if(buckets != null && size > 0){
			size = 0;
			for(int i = 0;i < buckets.length;i ++){
				buckets[i] = null;
			}
		}
	}

	@Override
	public Set<K> keySet() {
		Set<K> keySet = null;
		for(int i = 0;i < buckets.length;i ++){
			for(Node<K, V> node = buckets[i];node != null;node = node.getNext()){
				keySet.add(node.getKey());
			}
		}
		return keySet;
	}

	@Override
	public Collection<V> values() {
		Collection<V> values = null;
		for(int i = 0;i < buckets.length;i ++){
			for(Node<K, V> node = buckets[i];node != null;node = node.getNext()){
				values.add(node.getValue());
			}
		}
		return values;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<java.util.Map.Entry<K, V>> entrySet = null;
		for(int i = 0;i < buckets.length;i ++){
			for(Node<K, V> node = buckets[i];node != null;node = node.getNext()){
				entrySet.add(node);
			}
		}
		return entrySet;
	}

	//hash
	public int hash(int h){
		double temp =  h * A;
		double digit = temp - Math.floor(temp);
		return (int) Math.floor(digit * capacity);
	}
	
	//index for buckets
	public int index(int h,int length){
		return h & (length - 1);
	}
	
	private void addEntry(int hash,K key,V value,int index){
		Node<K, V> node = buckets[index];
		
		buckets[index] = new Node<K,V>(hash,key,value,node);
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{\n");
		
		for(int i = 0;i < buckets.length;i ++){
			
			for(Node<K, V> node = buckets[i];node != null;node = node.getNext()){
				buffer.append("	" + node.getKey() + " : " + node.getValue() + "\n");
			}
		}
		
		buffer.append("}");
		return buffer.toString();
	}
	
	
}
