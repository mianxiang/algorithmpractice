package Stack;

public class ArrayStack {
	
	private String[] array;
	private final int DEFAULT_CAPACITY = 5;
	private int capacity;
	private int count;
	
	public ArrayStack() {
		this.capacity = DEFAULT_CAPACITY;
		this.array = new String[capacity];
		this.count = 0;
	}
	
	public String pop() {
		if(count == 0) {
			return null;
		}
		
		String temp = array[count - 1];
		count--;
		return temp;
	}
	
	public void push(String item) {
		if(count == capacity) {
			return;
		}
		
		array[count] = item;
		count++;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayStack arrayStack = new ArrayStack();
		arrayStack.push("1");
		arrayStack.push("2");
		arrayStack.push("3");
		arrayStack.push("4");
		arrayStack.push("5");
		arrayStack.push("6");
		
		for(int i = 0; i < arrayStack.capacity; i++) {
			System.out.print(arrayStack.pop() + " ");
		}
		
		System.out.println();
	
	}

}
