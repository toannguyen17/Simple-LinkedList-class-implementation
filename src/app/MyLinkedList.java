package app;

public class MyLinkedList<E> {
	private  Node<E> head;
	private  Node<E> tail;
	private  int numNodes;

	public MyLinkedList(E data) {
		head = new Node<E>(data);
	}

	private class Node<E> {
		private Node<E> next;
		private E data;

		public Node(E data) {
			this.data = data;
		}

		public E getData() {
			return this.data;
		}
	}


	//
	public void add(E data) {
		if (tail == null){
			head = new Node<E>(data);
			tail = head;
		}else{
			Node<E> temp = tail;
			temp.next = new Node<E>(data);
			tail      = temp.next;
		}
		numNodes++;
	}

	public void add(int index, E data) {
		Node<E> temp = head;
		Node<E> holder;

		for(int i=0; i < index-1 && temp.next != null; i++) {
			temp = temp.next;
		}
		holder = temp.next;
		temp.next = new Node<E>(data);
		temp.next.next = holder;
		numNodes++;
	}

	//
	public void addFirst(E data) {
		Node<E> temp = head;
		head = new Node<E>(data);
		head.next = temp;
		numNodes++;
	}

	public Node<E> get(int index){
		Node<E> temp = head;
		for(int i=0; i<index; i++) {
			if (temp.next != null) {
				temp = temp.next;
			}
		}
		return temp;
	}

	//
	public void printList() {
		Node<E> temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
