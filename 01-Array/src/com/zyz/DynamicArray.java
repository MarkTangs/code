package com.zyz;

@SuppressWarnings("unchecked")
public class DynamicArray<E> extends AbstractList<E>{
	
	/**
	 * 所有的元素
	 */
	private E[] elements;
	
	/**
	 * 默认容量
	 */
	private static int DEFAULT_CAPACITY = 10;
	

	
	public DynamicArray(int capacity) {
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = (E[])new Object[capacity];
	}
	public DynamicArray() {
		this(DEFAULT_CAPACITY);
	}
	/**
	 * 清除所有元素
	 */
	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		size = 0;
	}
	
	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		rangCheck(index);
		return elements[index];
	}
	
	
	/**
	 * 设置index位置新元素
	 * @param index
	 * @param element
	 * @return 原来的元素
	 */
	public E set(int index,E element) {
		rangCheck(index);
		E old = elements[index];
		elements[index] = element;
		return old;
	}
	
	
	/**
	 * 添加元素
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		rangCheckForAdd(index);
		ensureCapacity(size + 1);
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	}
	/**
	 * 添加元素在尾部
	 * @param element
	 */
	public void add(E element) {
		add(size, element);
	}
	/**
	 * 删除元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		rangCheck(index);
		E oldE = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		size--;
		elements[size] = null;
		return oldE;
	}
	
	/**
	 * 查找某个元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) {
					return i;
				}
			}
		}
		return ELEMENT_NOT_DOUND;
	}
	
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) {
			return;
		}
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[])new Object [newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + "扩容为" + newCapacity);
	}
	
	
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("Size = ").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				string.append(elements[i]);
			}else {
				string.append(",").append(elements[i]);
			}
		}
		string.append("]");
		
		return string.toString();
	}
	
}
