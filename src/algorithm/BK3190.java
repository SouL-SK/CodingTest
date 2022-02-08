package algorithm;

import java.util.*;

/**
 * 백준
 * 3190번 뱀
 * @author shuai
 *
 */
public class BK3190 {
	LinkedList<Integer> snake = new LinkedList<>();
	static Scanner sc = new Scanner(System.in);
	private Node<Integer> head;
	private Node<Integer> tail;
	private static int size;
	private static int[][] map;
	private static int n, l;
	
	public static void main(String[] agrs) {
		map = new int[101][101];
		n = Integer.parseInt( sc.next());
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			//사과 갯수, 위치 정하기
		}
		
	}

	class Node<Integer> {
		Node<Integer> head;
		Node<Integer> tail;
		public Object data;
		
		public int data() {
			int[][] res;
			int str = 0;
			
			return str;
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object o) {
		for (Node<Integer> n = head; n != null; n = n.tail) {
			if (o.equals(n.data())) {
				return true;
			}
		}
		return false;
	}

	public void clear() {
		for (Node<Integer> n = head; n != null;) {
			Node<Integer> next = n.tail;
			n.data = null;
			n.tail = null;
			n = next;
		}
		size = 0;
		head = tail = null;
	}

	public boolean add(Integer e) {
		Node<Integer> newNode = new Node<Integer>();

		return false;
	}

	public boolean offer(Integer e) {
		Node<Integer> newNode = new Node<Integer>();
		if (size == 0) {
			head = newNode;
		} else {
			tail.tail = newNode;
		}
		tail = newNode;
		size++;
		return true;
	}

	public Integer remove() {
		Integer temp = poll();
		if (temp == null) {
			throw new NoSuchElementException();
		}
		return temp;
	}

	public Integer poll() {
		if (size == 0) {
			return null;
		}
		Integer temp = (java.lang.Integer) head.data;

		Node<Integer> nextNode = head.tail;

		head.data = null;
		head.tail = null;
		head = nextNode;
		size--;

		return temp;
	}

	public Integer element() {
		Integer temp = peek();
		if (temp == null) {
			throw new NoSuchElementException();
		}
		return temp;
	}

	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return (java.lang.Integer) head.data;
	}
}
