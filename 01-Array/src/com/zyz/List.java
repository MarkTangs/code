package com.zyz;

public interface List <E>{

	static final int ELEMENT_NOT_DOUND = -1;
	
	/**
	 * 清除所有元素
	 */
	void clear();
	
	/**
	 * 元素的数量
	 * @return
	 */
	int size();
	
	/**
	 * 是否为空
	 */
	boolean isEmpty();
	
	/**
	 * 是否包含某个元素
	 * @param elelent
	 * @return
	 */
	boolean contains(E elelent);
	
	/**
	 * 添加到元素尾部
	 * @param element
	 */
	void add(E element);
	
	/**
	 * 在index位置插入元素
	 * @param index
	 * @param element
	 */
	void add(int index,E element);
	
	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	E get(int index);
	
	/**
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return
	 */
	E set(int index,E element);
	
	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	E remove(int index);
	
	/**
	 * 查看元素的索引
	 * @param elemeent
	 * @return
	 */
	int indexOf(E elemeent);
}
