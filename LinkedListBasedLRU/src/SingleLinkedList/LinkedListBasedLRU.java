package SingleLinkedList;

import java.util.Scanner;

public class LinkedListBasedLRU<T> {
	
	private final static Integer DEFAULT_CAPACITY = 10;
	private SNode headNode;
	private Integer length;
	private Integer capacity;
	
	public LinkedListBasedLRU() {
		this.headNode = new SNode<>();
		this.capacity = DEFAULT_CAPACITY;
		this.length = 0;
	}
	
	public LinkedListBasedLRU(Integer capacity) {
		this.headNode = new SNode<>();
		this.capacity = capacity;
		this.length = 0;
		
	}
	
	private SNode findPreNode(T data) {
		SNode node = headNode;
		while(node.getNext() != null) {
			if(data.equals(node.getNext().getElement())) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}
	
	private void insertElemAtBegin(T data) {
		SNode node = headNode.getNext();
		headNode.setNext(new SNode(data, node));
		length++;
	}
	
	private void deleteElemOptim(SNode preNode) {
		SNode temp = preNode.getNext();
		preNode.setNext(temp.getNext());
		temp = null;
		--length;
	}
	
	private void deleteElemAtEnd() {
		SNode ptr = headNode;
		
		if(ptr.getNext() == null) {
			return;
		}
		
		while(ptr.getNext().getNext() != null) {
			ptr = ptr.getNext();
		}
		
		SNode temp = ptr.getNext();
		ptr.setNext(null);
		temp = null;
		--length;
	}
	
	public void add(T data) {
		SNode preNode = findPreNode(data);
		
		if(preNode != null) {
			deleteElemOptim(preNode);
			insertElemAtBegin(data);
		}else {
			if(length >= capacity) {
				deleteElemAtEnd();
			}
			insertElemAtBegin(data);
		}
	}
	
	private void printAll() {
		SNode node = headNode.getNext();
		while(node != null) {
			System.out.print(node.getElement() + ",");
			node = node.getNext();
		}
		System.out.println();
	}
	
	public class SNode<T>{
		private T element;
		private SNode next;
		
		public SNode(T element, SNode next) {
			this.element = element;
			this.next = next;
		}
		
		public SNode(T element) {
			this.element = element;
		}
		
		public SNode() {
			this.next = null;
		}
		
		public T getElement() {
			return element;
		}
		
		public void setElement(T element) {
			this.element = element;
		}
		
		public SNode getNext() {
			return next;
		}
		
		public void setNext(SNode next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListBasedLRU list = new LinkedListBasedLRU();
		Scanner sc = new Scanner(System.in);
		while(true) {
			list.add(sc.nextInt());
			list.printAll();
		}

	}

}
 