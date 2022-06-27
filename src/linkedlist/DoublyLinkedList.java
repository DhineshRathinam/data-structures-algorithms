package linkedlist;

class DLLNode {
	int val;
	DLLNode next;
	DLLNode prev;

	public DLLNode(int val) {
		this.val = val;
		next = null;
		prev = null;
	}

}

public class DoublyLinkedList {

	DLLNode head;
	DLLNode tail;
	int size = 0;

	private void insertAtBegin(int val) {
		DLLNode newNode = new DLLNode(val);

		if (head == null) {
			head = newNode;
			tail = newNode;
			size += 1;
			return;
		}

		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		size += 1;
	}

	private void insertAtlast(int val) {

		if (head == null) {
			insertAtBegin(val);
			return;
		}
		DLLNode newNode = new DLLNode(val);
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		size += 1;
	}

	private void insertAfter(int pos, int val) {
		if (pos > size) {
			System.out.println("Cannot be inserted: ");
			return;
		}
		DLLNode newNode = new DLLNode(val);
		DLLNode currentNode = head;
		for (int i = 0; i < pos; i++) {
			currentNode = currentNode.next;
		}
		if (currentNode == null) {
			insertAtlast(val);
			return;
		}
		newNode.next = currentNode.next;
		newNode.prev = currentNode;
		currentNode.next = newNode;

		size += 1;
	}

	private void deleteFirst() {
		if (head == null) {
			return;
		}
		head = head.next;
		head.prev = null;
		size -= 1;
	}

	private void deleteLast() {
		if (head == null) {
			return;
		}
		DLLNode currentNode = head;
		for (int i = 0; i < size - 2; i++) {
			currentNode = currentNode.next;
		}
		currentNode.next = null;
		size -= 1;
	}
	
	private void deleteAfter(int pos) {
		if(pos > size || head == null) {
			return;
		}
		if(pos == 0) {
			deleteFirst();
			return;
		}
		if(pos == size-1) {
			deleteLast();
			return;
		}
		
		DLLNode currentNode = head;
		for(int i = 0; i<pos; i++) {
			currentNode= currentNode.next;
		}
		
	}

	private void display() {
		DLLNode currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.val + " -> ");
			currentNode = currentNode.next;
		}
		System.out.print("END");
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtBegin(9);
		list.insertAtBegin(19);
		list.insertAtBegin(29);
		list.insertAtlast(100);
		list.insertAfter(1, 3);
		list.deleteFirst();
		list.deleteLast();
		list.display();
	}

}
