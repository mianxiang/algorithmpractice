package ArrayQueue;

public class ArrayQueue {
	private String[] array;
	private int count;
	private int head = 0, tail = 0;
	
	public ArrayQueue(int capacity) {
		this.count = capacity;
		this.array = new String[capacity];
	}
	
	public String dequeue() {
		if(head == tail) {
			return null;
		}
		String item = array[head];
		head++;
		return item;
	}
	
	public boolean enqueue(String item) {
		if(tail == count) {
			if(head == 0) {
				return false;
			}
			for(int i = head; i < tail; ++i) {
				array[i-head] = array[i];
			}
			tail = tail - head;		
			head = 0;
		}
		array[tail] = item;
		tail++;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue arrayQueue = new ArrayQueue(5);
		arrayQueue.enqueue("Hello");
		arrayQueue.enqueue("World");
		arrayQueue.enqueue("I");
		arrayQueue.enqueue("Like");
		arrayQueue.enqueue("This");
		arrayQueue.enqueue("Way");
		String item = arrayQueue.dequeue();
		while(item != null) {
			System.out.print(item + " ");
			item = arrayQueue.dequeue();
		}
		System.out.println();
		
		
		arrayQueue.enqueue("Shangcheng");
		item = arrayQueue.dequeue();
		while(item != null) {
			System.out.print(item + " ");
			item = arrayQueue.dequeue();
		}
		System.out.println();
		
		arrayQueue.enqueue("Hangzhou");
		arrayQueue.enqueue("ZHejiang");
		arrayQueue.enqueue("China");
		arrayQueue.enqueue("Asia");
		arrayQueue.enqueue("Sun");
		item = arrayQueue.dequeue();
		while(item != null) {
			System.out.print(item + " ");
			item = arrayQueue.dequeue();
		}

	}

}
