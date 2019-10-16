package com.zyz;

public class Main {
	public static void main(String[] args) {
		DynamicArray<Object> array = new DynamicArray<Object>();
		array.add(1);
		array.add(1,2);
		for (int i = 3; i < 30; i++) {
			array.add(i);
		}
//		array.remove(0);
		System.out.println(array);
		
	}
}
