package queue;

public class CircularQueue {
	
	private String[] items;
	private int capacity;
	private int head;
	private int tail;
	
	public CircularQueue(int capacity) {
		this.capacity = capacity;
		this.items = new String[capacity];
		this.head = 0;
		this.tail = 0;
	}
	
	public String dequeue() {
		if(head == tail) {
			return null;
		}
		
		String item = items[head];
		head = (head + 1)%capacity;
		return item;
	}
	
	public void enqueue(String item) {
		if((tail + 1) % capacity == head) {
			return;
		}
		
		items[tail] = item;
		tail = (tail + 1)%capacity;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularQueue circularQueue = new CircularQueue(5);
		circularQueue.enqueue("Hello");
		circularQueue.enqueue("Shangcheng");
		circularQueue.enqueue("Hangzhou");
		circularQueue.enqueue("Zhejiang");
		circularQueue.enqueue("China");
		circularQueue.enqueue("Asia");
		
		String item = circularQueue.dequeue();
		while(item != null) {
			System.out.print(item + " ");
			item = circularQueue.dequeue();
		}
		System.out.println();
		
		circularQueue.enqueue("I");
		circularQueue.enqueue("am");
		circularQueue.enqueue("in");
		circularQueue.enqueue("the");
		circularQueue.enqueue("earth");
		circularQueue.enqueue("world");
		
		item = circularQueue.dequeue();
		while(item != null) {
			System.out.print(item + " ");
			item = circularQueue.dequeue();
		}
		System.out.println();
		
		
	}

}
