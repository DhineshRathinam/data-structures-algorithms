package linkedlist;

class Node {

	int val;
	Node next;

	public Node(int val) {
		this.val = val;
		this.next = null;
	}

}

public class SinglyLinkedList {

	Node head;
	Node tail;
	int size = 0;

	private void insertBegin(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			tail = newNode;
			size += 1;
			return;
		}
		newNode.next = head;
		head = newNode;
		size += 1;
	}

	private void insertlast(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			insertBegin(val);
			return;
		}
		tail.next = newNode;
		tail = newNode;
		size += 1;
	}

	private void insertAfter(int pos, int val) {
		if (pos > size) {
			System.out.println("Cannot be inserted: ");
			return;
		}
		Node newNode = new Node(val);
		Node currentNode = head;
		for (int i = 0; i < pos; i++) {
			currentNode = currentNode.next;
		}
		if (currentNode == null) {
			insertlast(val);
			return;
		}
		newNode.next = currentNode.next;
		currentNode.next = newNode;
		size += 1;
	}

	private void deleteAtFirst() {
		if (head == null) {
			System.out.println("Node not found: ");
		}

		head = head.next;
		size -= 1;
	}

	private void deleteAtLast() {
		if (head == null) {
			System.out.println("Node not found: ");
		}
		Node currentNode = head;
		for (int i = 0; i < size - 2; i++) {
			currentNode = currentNode.next;
		}

		currentNode.next = null;
		size -= 1;
	}

	private void deleteAfter(int pos) {

		if (pos > size) {
			System.out.println("Cannot be deleted: ");
			return;
		}
		if (pos == 1) {
			deleteAtFirst();
			return;
		}

		if (pos == size) {
			deleteAtLast();
			return;
		}
		Node currentNode = head;
		for (int i = 0; i < pos; i++) {
			currentNode = currentNode.next;
		}
		currentNode.next = currentNode.next.next;
		size -= 1;
	}

	private void display() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.val + " -> ");
			currentNode = currentNode.next;
		}
		System.out.print("END");
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertBegin(9);
		list.insertlast(11);
		list.insertBegin(21);
		list.insertAfter(4, 100);
		list.insertBegin(99);
		list.insertAfter(2, 1);
		list.insertlast(77);
		list.display();
		list.deleteAtFirst();
		list.display();
		list.deleteAtLast();
		list.display();
		list.deleteAfter(1);
		list.display();
	}

}
