package stack;

public class DynamicStack extends CustomStack {

	public DynamicStack(int size) {
		super(size);
	}

	int[] temp;

	@Override
	public void push(int val) {
		if (isFull()) {
			temp = new int[data.length * 2];

			for (int i = 0; i < data.length; i++) {
				temp[i] = data[i];
			}

			data = temp;
		}

		data[++ptr] = val;
	}

	public static void main(String[] args) {
		DynamicStack dynamicStack = new DynamicStack(3);
		dynamicStack.push(1);
		dynamicStack.push(2);
		dynamicStack.push(3);
		dynamicStack.push(4);
		dynamicStack.push(5);
		dynamicStack.push(6);
		dynamicStack.push(7);
		dynamicStack.pop();
		dynamicStack.pop();
		dynamicStack.display();
	}

}
