package Stack;

import LinkList.LinkList;

public class Stack<E> {

	private LinkList<E> list = new LinkList<E>();
	
	
	public int size() {
		return list.size();
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public void push(E element) {
		list.add(element);
	}
	public E pop() {
		return list.remove(size() - 1);
	}
	public E top() {
		return list.get(list.size() - 1);
	}
	public void clear() {
		list.clear();
	}
}
