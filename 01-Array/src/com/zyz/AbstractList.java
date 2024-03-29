package com.zyz;

public abstract class AbstractList<E> implements List<E> {

	/**
	 * 元素的数量
	 */
	protected int size;
	
	/**
	 * 元素的数量
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 是否为空
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * 是否包含某个元素
	 * @param elelent
	 * @return
	 */
	public boolean contains(E elelent) {
		return indexOf(elelent) != ELEMENT_NOT_DOUND;
	}
	
	/**
	 * 添加到元素尾部
	 * @param element
	 */
	public void add(E element) {
		add(size, element);
	}
	
	/**
	 * 检查边界
	 * @param index
	 */
	protected void rangCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	/**
	 * 检查添加边界
	 * @param index
	 */
	protected void rangCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}
	
	/**
	 * Exception
	 * @param index
	 */
	protected void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" +index + ",Size:" + size);
	}
	
}
