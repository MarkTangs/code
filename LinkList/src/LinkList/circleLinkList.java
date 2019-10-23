package LinkList;

public class circleLinkList<E> extends AbstractList<E>{

	
	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> prev;
		public Node(Node<E> prev,E element,Node<E> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		@Override
		public String toString() {
			StringBuffer str = new StringBuffer();
			if (prev != null) {
				str.append(prev.element).append("_");
			}else {
				str.append("null_");
			}
			str.append(element).append("_");
			if (next != null) {
				str.append(next.element);
			}else {
				str.append("null");
			}
			return str.toString();
		}
	}
	
	private Node<E> head;
	private Node<E> last;
	@Override
	public void clear() {
		size = 0;
		head = null;
		last = null;
	}

	@Override
	public void add(int index, E element) {
		rangCheckForAdd(index);
		
		if (index == size) { //size == 0 || index == 0
			Node<E> oldLastNode = last;
			last = new Node<E>(oldLastNode, element, head);
			if (oldLastNode == null) {  //添加第一个元素
				head = last;
				head.next = head;
				head.prev = head;
			}else {
				oldLastNode.next = last;
				head.prev = last;
			}
		}else {
			
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> newNode = new Node<E>(prev, element, next);
			next.prev = newNode;
			prev.next = newNode;
			if (next == head) {
				head = newNode;
			}
		}
		size++;
	}

	@Override
	public E get(int index) {
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> oldNode = node(index);
		node(index).element = element;
		return oldNode.element;
	}

	@Override
	public E remove(int index) {
		rangCheck(index);

		Node<E> node = node(index);
		if (size == 1) {
			head = null;
			last = null;
		}else {
			Node<E> prev = node.prev;
			Node<E> next = node.next;
			prev.next = next;
			next.prev = prev;
			if (node == head) {
				head = next;
			}
			if (node == last) {
				last = prev;
			}
		}
		size--;
		return node.element;
	}

	@Override
	public int indexOf(E elemeent) {
		if (elemeent == null) {
			Node<E> node = head;
			for (int i = 0; i < size; i++) {
				if (node.element == null) {
					return i;
				}
				node = node.next;
			}
		}else {
			Node<E> node = head;
			for (int i = 0; i < size; i++) {
				if (elemeent.equals(node.element)) {
					return i;
				}
				node = node.next;
			}
		}
		return ELEMENT_NOT_DOUND;
	}
	
	/**
	 * 获取index位置的对象
	 * @param index
	 * @return
	 */
	private Node<E> node(int index) {
		rangCheck(index);
		if (index < (size >> 1)) {
			Node<E> node = head;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		}else {
			Node<E> node = last;
			for (int i = size - 1; i > index ; i--) {
				node = node.prev;
			}
			return node;
		}
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("[size = ").append(size).append(" | ");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				str.append(" , ");
			}
			str.append(node(i));
		}
		str.append("]");
		return str.toString();
	}
	
	
}
