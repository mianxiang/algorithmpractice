package stack;

public class LinkedListBasedStack {
	
	private Node top = null;
	
	public void push(int value) {
		Node newNode = new Node(value, null);
		
		if(top == null) {
			top = newNode;
		}
		else {
			newNode.next = top;
			top = newNode;
		}
	}
	
	public int pop() {
		if(top == null) return -1;
		int value = top.data;
		top = top.next;
		return value;
	}
	
	public void printAll() {
		Node p = top;
		while(p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
	}
	
	private static class Node{
		private int data;
		private Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public int getData() {
			return data;
		}
	}
	
	public static void main(String[] args) {
		LinkedListBasedStack linkedListBasedStack = new LinkedListBasedStack();
		linkedListBasedStack.push(0);
		linkedListBasedStack.push(1);
		linkedListBasedStack.push(2);
		linkedListBasedStack.push(3);
		linkedListBasedStack.printAll();
			
	}


}
