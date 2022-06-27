package queue;

public class CustomQueue {

	int size;
	int[] data;
	int front = -1;
	int rear = -1;

	public CustomQueue(int size) {
		data = new int[size];
	}

	private void addElement(int val) throws Exception {
		if (isFull()) {
			throw new Exception("Queue is full: ");
		}
		if (front == -1 && rear == -1) {
			data[++rear] = val;
			front++;
			return;
		}
		data[++rear] = val;
	}

	private void removeElement() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty: ");
		}

		for (int i = 1; i <= rear; i++) {
			data[i - 1] = data[i];
		}
		data[rear] = 0;
		rear--;
	}

	private boolean isEmpty() {
		return front == -1 && rear == -1;
	}

	private boolean isFull() {
		if (data.length == rear + 1) {
			return true;
		}
		return false;
	}

	public void display() {
		for (int i = 0; i <= data.length - 1; i++) {
			if (data[i] != 0) {
				System.out.print(data[i] + " <- ");
			}
		}
		System.out.print("END ");
	}

	public static void main(String[] args) throws Exception {
		CustomQueue queue = new CustomQueue(5);
		queue.addElement(9);
		queue.addElement(99);
		queue.addElement(97);
		queue.addElement(197);
		queue.removeElement();
		queue.addElement(108);
		queue.removeElement();
		queue.display();
	}

}
