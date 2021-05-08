package queue;

public class LinkedListBasedQueue {
	private Node head = null;
	private Node tail = null;
	
	public String dequeue() {
		if(head == null) {
			return null;
		}
		
		Node tmpNode = head;
		head = head.next;
		if(head == null) {
			tail = null;
		}
		return tmpNode.data;
	}
	
	public void enqueue(String data) {
		if(tail == null) {
			Node newNode = new Node(data, null);
			head = newNode;
			tail = newNode;		
		}
		else {
			tail.next = new Node(data, null);
			tail = tail.next;
		}
	}
	
	public void printAll() {
		Node node = head;
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
		

	
	private static class Node{
		private String data;
		private Node next;
		
		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public String getData() {
			return this.data;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListBasedQueue queue = new LinkedListBasedQueue();
		queue.enqueue("Hello");
		queue.enqueue("Hangzhou");
		queue.enqueue("Zhejiang");
		queue.printAll();

	}

}
