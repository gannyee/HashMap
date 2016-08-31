package com.hashmap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDIY<K,V> implements Map<K, V>{

	private int size = 0;
	private int capacity = 1;
	private int initialCapacity = 16;
	Node<K, V>[] buckets;
	
	public HashMapDIY() {
		
		while(capacity < initialCapacity){
			capacity <<= 1;
		}
		buckets = new Node[capacity];
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
		
		Iterator<K> iterator = keySet().iterator();
		if(iterator.hasNext()){
			K k = iterator.next();
			if(k.equals(key) || k == key)
				return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		Iterator<V> iterator = values().iterator();
		if(iterator.hasNext()){
			V v = iterator.next();
			if(v.equals(value) || v == value)
				return true;
		}
		return false;
	}

	@Override
	public V get(Object key) {
		if(key == null)
			return null;
		
		int hash = hash(key.hashCode());
		int index = index(hash, buckets.length);
		
		for(Node<K, V> node = buckets[index];node != null;node.setNext(node.getNext())){
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
		
		for(Node<K, V> node = buckets[index];node != null;node.setNext(node.getNext())){
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
		
		int hash = hash(key.hashCode());
		int index = index(hash, buckets.length);
		
		for(Node<K, V> node = buckets[index];node.getNext() != null;node.setNext(node.getNext())){
			if(node.getNext().getHash() == hash && (key == node.getNext().getKey() || key.equals(node.getNext().getKey()))){
				V value = node.getNext().getValue();
				node.setNext(node.getNext().getNext());
				return value;
			}
		}
		size --;
		return null;
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
		size = 0;
	}

	@Override
	public Set<K> keySet() {
		Set<K> keySet = null;
		for(int i = 0;i < buckets.length;i ++){
			for(Node<K, V> node = buckets[i];node != null;node.setNext(node.getNext())){
				keySet.add(node.getKey());
			}
		}
		return keySet;
	}

	@Override
	public Collection<V> values() {
		Collection<V> values = null;
		for(int i = 0;i < buckets.length;i ++){
			for(Node<K, V> node = buckets[i];node != null;node.setNext(node.getNext())){
				values.add(node.getValue());
			}
		}
		return values;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<java.util.Map.Entry<K, V>> entrySet = null;
		for(int i = 0;i < buckets.length;i ++){
			for(Node<K, V> node = buckets[i];node != null;node.setNext(node.getNext())){
				entrySet.add(node);
			}
		}
		return entrySet;
	}

	//hash
	public int hash(int h){
		 h ^= (h >>> 20) ^ (h >>> 12);
		    return h ^ (h >>> 7) ^ (h >>> 4);
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
				buffer.append(node.getKey() + " : " + node.getValue() + "\n");
			}
		}
		
		buffer.append("\n}");
		return buffer.toString();
	}
	
	
}
