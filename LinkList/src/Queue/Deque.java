package Queue;

import LinkList.LinkList;

public class Deque<E> {

	private LinkList<E> list = new LinkList<E>();
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void clear() {
		list.clear();
	}
	
	public void enQueueRear(E Element) {
		list.add(Element);
	}
	
	public E deQueueRear() {
		return list.remove(list.size() - 1);
	}
	
	public E front() {
		return list.get(0);
	}
	
	public E rear() {
		return list.get(list.size() - 1);
	}
	
	
	
	
}
