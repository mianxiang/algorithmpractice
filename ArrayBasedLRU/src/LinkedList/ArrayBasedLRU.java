package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class ArrayBasedLRU<T> {
	
	private static final int DEFAULT_CAPACITY = 10;
	private int capacity;
	private int count;
	private T[] array;
	private Map<T, Integer> holder;
	
	public ArrayBasedLRU(int capacity) {
		this.capacity = capacity;
		array = (T[])new Object[capacity];
		count = 0;
		holder = new HashMap<T, Integer>(capacity);
	}
	
	public ArrayBasedLRU() {
		this(DEFAULT_CAPACITY);
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isContain(T object) {
		return holder.containsKey(object);
	}
	
	public boolean isFull() {
		return count == capacity;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count; i++) {
			sb.append(array[i]);
			sb.append(" ");
		}
		return sb.toString();		
	}
	
	private void rightShift(int end) {
		for(int i = end - 1; i >= 0; i--) {
			array[i + 1] = array[i];
			holder.put(array[i], i + 1);
		}
	}
	
	public void cache(T object, int end) {
		rightShift(end);
		array[0] = object;
		holder.put(object, 0);
		count++;
	}
	
	public void removeAndCache(T object) {
		T key = array[--count];
		holder.remove(key);
		cache(object, count);
	}
	
	public void update(int end) {
		T target = array[end];
		rightShift(end);
		array[0] = target;
		holder.put(target, 0);	
	}
	
	public void offer(T object) {
		if(object == null) {
			throw new IllegalArgumentException("Null is not supported.");
		}
		
		Integer index = holder.get(object);
		if(index == null) {
			if(isFull()) {
				removeAndCache(object);
			}
			else {
				cache(object, count);
			}		
		}
		else {
			update(index);
			
		}
	}
	
	static class TestArrayBasedLRU{
		public static void main(String[] args) {
			testDefaultConstructor();
			testSpecifiedConstructor(4);
		}
		
		public static void testDefaultConstructor() {
			System.out.println("Test the default constructor");
			ArrayBasedLRU<Integer> lru = new ArrayBasedLRU<Integer>();
			lru.offer(1);
			lru.offer(2);
			lru.offer(3);
			lru.offer(4);
			lru.offer(5);
			System.out.println(lru);
			lru.offer(6);
			lru.offer(7);
			lru.offer(8);
			lru.offer(9);
			lru.offer(10);
			System.out.println(lru);
		}
		
		public static void testSpecifiedConstructor(int capacity) {
			System.out.println("Test with parameters");
            ArrayBasedLRU<Integer> lru = new ArrayBasedLRU<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
		}
	}

}
