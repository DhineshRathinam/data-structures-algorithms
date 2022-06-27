package stack;

public class CustomStack {

	protected int[] data;
	int ptr = -1;

	public CustomStack(int size) {
		this.data = new int[size];
	}

	public void push(int val) {
		if (isFull()) {
			System.out.println("Stack is full: ");
			return;
		}
		data[++ptr] = val;
	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty: ");
			return;
		}
		data[ptr--] = 0;
		
	}
	
	public int peek() {
		return data[ptr];
	}

	public boolean isEmpty() {
		return ptr == 0;
	}

	public boolean isFull() {
		return (data.length - 1) == ptr;
	}

	public void display() {
		for (int i = 0; i <= data.length - 1; i++) {
			if(data[i] != 0)  
			System.out.print(data[i] + " -> ");
		}
		System.out.print("END ");
	}

	public static void main(String[] args) {
		CustomStack stack = new CustomStack(5);
		stack.push(9);
		stack.push(19);
		stack.push(99);
		stack.pop();
		stack.display();
		System.out.println(stack.peek());
		stack.pop();
		stack.display();
		System.out.println(stack.peek());
	}

}
