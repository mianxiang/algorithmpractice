package Queue;

public class ArrayQueue {
	private int capacity;
	private String[] array;
	private int head = 0, tail = 0;
	
	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		this.array = new String[capacity];
	}
	
	public boolean enqueue(String item) {
		if(tail == capacity) {
			return false;
		}
		
		array[tail] = item;
		tail++;
		return true;
	}
	
	public String dequeue() {
		if(head == tail) {
			return null;
		}
		
		String tmp = array[head];
		head++;
		return tmp;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue arrayQueue = new ArrayQueue(5);
		arrayQueue.enqueue("Hello");
		arrayQueue.enqueue("World");
		arrayQueue.enqueue("I");
		arrayQueue.enqueue("Like");
		arrayQueue.enqueue("this");
		arrayQueue.enqueue("Way");
		String item = arrayQueue.dequeue();
		while(item != null) {
			System.out.print(item + " ");
			item = arrayQueue.dequeue();		
		}
		
		
		

	}

}
