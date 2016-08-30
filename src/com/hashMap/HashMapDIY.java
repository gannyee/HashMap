package com.hashMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import com.hashMap.MyEntry;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
/**
 * 
 * @author ganyi
 *
 * @param <K> general data type : Object or inherit Object 
 * @param <V> the same as above mention
 */
public class HashMapDIY<K,V> implements Map<K, V> {

	//
	private static int DEFAULT_CAPACITY = 16;
	//Useful factor to calculate key hash
	private static double A = (Math.pow(5, 0.5) - 1) / 2;
	
	//Length of buckets array
	private int capacity;
	//
	private int size = 0;
	
	private MyEntry<K, V>[] buckets;
	
	public HashMapDIY() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public HashMapDIY(int capacity){
		if(capacity <= 0){
			throw new IllegalArgumentException("capacity can not be negative or zero");
		}
		
		//guarantee capacity is 2^n  
		int temp = 1;
		while(temp < capacity){
			temp <<= 2;
		}
		this.capacity = temp;
		buckets = new MyEntry[this.capacity];
	}
	
	
	
	/*public V alter(K key, V value) {
		validateKey(key);
		
		int index = hash(key);
		Entry<K, V> entry = new Entry<K,V>(key, value);
		
		for(entry = buckets[index]; entry != null; entry = entry.getNext()){
			
			if(entry.getKey().hashCode() == key.hashCode() && (key == entry.getKey() || key.equals(entry.getKey()))){
				V oldeValue = entry.getValue();
				entry.setValue(value);
				return oldeValue;
			}
		}
		
		return null;
	}*/

	
	public int size() {
		return size;
	}

	
	public boolean isEmpty() {
		return size == 0;
	}

	
	public int hash(Object key) {
		int hashCode = key.hashCode();
		//return hashCode & buckets.length;
		double temp = hashCode * A;
		double digit = temp - Math.floor(temp);
		return (int) Math.floor(digit * capacity);
	}

	
	public void validateKey(Object key) {
		if(key == null){
			throw new IllegalArgumentException("key can not be null");
		}
		
	}
	
	@Override
	public boolean containsKey(Object key) {
		Iterator<Entry<K, V>> iterator = entrySet().iterator();
		if(iterator.hasNext()){
			if(iterator.next().getKey().equals(key) || iterator.next().getKey() == key){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		if(isEmpty()){
			return false;
		}
		
		Iterator<Entry<K, V>> iterator = entrySet().iterator();
		if(iterator.hasNext()){
			if(iterator.next().getValue() == value || value.equals(iterator.next().getValue())){
					return true;
			}
		}
		
		return false;
	}

	@Override
	public V get(Object key) {
		validateKey(key);
		int index = hash(key);
		MyEntry<K, V> entry = buckets[index];
		while (entry != null) {
			System.out.println(entry.getKey() + " : " + key);
			if (key.equals(entry.getKey())) {
				
				return entry.getValue();
			}
			entry = entry.getNext();
		}

		return null;
	}

	@Override
	public V put(K key, V value) {
		validateKey(key);

		int index = hash(key);
		MyEntry<K, V> entry = new MyEntry<K,V>();

		if (buckets[index] != null) {
			entry.setNext(buckets[index]);
		}
		buckets[index] = entry;
		size++;
		System.out.println(key + " : "  + value);
		return value;
	}

	@Override
	public V remove(Object key) {
		validateKey(key);
		V value = null;
		int index = hash(key);
		
		MyEntry<K, V> entry = buckets[index];
		
		if(entry == null){
			return null;
		}
		
		if (entry.getKey() == key) {
			buckets[index].setNext(entry.getNext());
			size--;
		}
		
		while (entry.getNext() != null) {
			if (entry.getNext().getKey() == key) {
				value = entry.getNext().getValue();
				entry.setNext(entry.getNext().getNext());
				size--;
				break;
			}
			entry = entry.getNext();
		}
		return value;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		Iterator<?> iterator = m.entrySet().iterator();
		if(iterator.hasNext()){
			MyEntry<K, V> entry = (MyEntry<K, V>) iterator.next();
			put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void clear() {
		if(isEmpty()){
			return;
		}
		
		buckets = null;
		size = 0;
		
	}

	@Override
	public Set<K> keySet() {
		Set<K> keySet = null;
		Iterator<Entry<K, V>> iterator = entrySet().iterator();
		if(iterator.hasNext()){
			keySet.add(iterator.next().getKey());
		}
		
		return keySet;
	}

	@Override
	public Collection<V> values() {
		Collection<V> valueCollection = null;
		Iterator<Entry<K, V>> iterator = entrySet().iterator();
		if(iterator.hasNext()){
			valueCollection.add(iterator.next().getValue());
		}
		
		return valueCollection;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set entrySet = null;
		for(MyEntry<K,V> entrys : buckets){
			for(MyEntry<K,V> entry = entrys;entry != null;entry = entry.getNext()){
				entrySet.add(entry);
			}
		}
		return entrySet;
	}
	
	

}
