package com.zyz;

public class LinkList<E> extends AbstractList<E>{

	
	private static class Node<E> {
		E element;
		Node<E> next;
		public Node(E element,Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}
	
	private Node<E> head;
	
	@Override
	public void clear() {
		size = 0;
		head = null;
	}

	@Override
	public void add(int index, E element) {
		if (index == 0) {
			head = new Node<E>(element,head);
		}else {
			Node<E> prev = node(index - 1);
			prev.next = new Node<E>(element, prev.next);
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
		Node<E> oldNode = node(index);
		if (index == 0) {
			head = head.next;
		}else {
			Node<E> prev = node(index - 1);
			oldNode = prev.next;
			prev.next = oldNode.next;
		}
		size--;
		return oldNode.element;
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
		Node<E> node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
}
