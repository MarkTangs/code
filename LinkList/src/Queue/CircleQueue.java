package Queue;

public class CircleQueue<E> {
	private int front;
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public CircleQueue() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[index(i)] = null;
		}
		front = 0;
		size = 0;
	}
	
	public void enQueue(E element) {
		ensureCapacity(size + 1);
		elements[index(size)] = element;
		size++;
	}
	
	public E deQueue() {
		E frontElementE = elements[front];
		elements[front] = null;
		front = index(1);
		size--;
		return frontElementE;
	}
	
	public E front() {
		return elements[front];
	}
	
	private int index(int index) {
		index += front;
		return index - (index >= elements.length ? elements.length : 0);
	}
	
	private void ensureCapacity(int capacity) {
		
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E [] newElements = (E[])new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[index(i)];
		}
		elements = newElements;
		
		front = 0;
		
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("capacity=").append(elements.length)
		.append(" size=").append(size)
		.append(" front=").append(front)
		.append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(elements[i]);
		}
		string.append("]");
		
		return string.toString();
	}
	
}
