package GenericArray;

public class GenericArray<T> {
	private T[] data;
	private int size;
	
	public GenericArray(int capacity) {
		data = (T[])new Object[capacity];
		size = 0;
	}
	
	public GenericArray() {
		this(10);
	}
	
	public int getCapacity() {
		return data.length;
	}
	
	public int count() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void set(int index, T e) {
		if(index < 0 || index > size) {
			System.out.println("Invalid index");
			return;
		}	
		data[index] = e;		
	}
	
	public T get(int index) {
		if(index < 0 || index >= size) {
			System.out.println("Invalid index");
			return null;
		}
		return data[index];
	}
	
	public boolean contains(T e) {
		for(int i=0; i < size; i++) {
			if(data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}
	
	public int find(T e) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
	
	public void add(int index, T e) {
		if(index < 0 || index > size) {
			System.out.println("Invalid index");
			return;
		}
		
		if(size == data.length) {
			resize(2*data.length);
		}
		
		for(int i = size-1; i >= index; i--) {
			data[i+1] = data[i];			
		}
		
		data[index] = e;
		size++;
	}
	
	public void addFirst(T e) {
		add(0, e);
	}
	
	public void addLast(T e) {
		add(size, e);
	}
	
	public T remove(int index) {
		if(index < 0 || index >= size) {
			System.out.println("invalid index");
			return null;
		}
		
		T removedElement = data[index];
		
		for(int i = index + 1; i < size; i++) {
			data[i-1] = data[i];
		}
		size--;
		data[size] = null;
		
		if(size == data.length/4 && data.length / 2 != 0) {
			resize(data.length / 2);
		}
		
		return removedElement;
	}
	
	public T removeFirst() {
		return remove(0);
	}
	
	public T removeLast() {
		return remove(size - 1);
	}
	
	public void removeElement(T e) {
		int index = find(e);
		if(index != -1) {
			remove(index);
		}
	} 
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("Array size = %d, capacity = %d\n", size, data.length));
		builder.append("[");
		for(int i = 0; i < size; i++) {
			builder.append(data[i]);
			if(i != size - 1) {
				builder.append(",");
			}
		}
		builder.append("]");
		return builder.toString();
		
	}
	
	private void resize(int capacity) {
		T[] newdata = (T[])new Object[capacity];
		
		for(int i = 0; i < size; i++) {
			newdata[i] = data[i];
		}
		
		data = newdata;
	}

	
}
