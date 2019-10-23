package LinkList;

public class Main {
	public static void main(String[] args) {
//		circleLinkList<Object> array = new circleLinkList<Object>();
//		array.add(1);     //1
//		array.add(1,2);    //1 2
//		for (int i = 3; i < 5; i++) {
//			array.add(i);
//		}
//		//1 2 3 4 
//		array.add(3,2); //1 2 3 2 4
//		array.remove(0); // 2 3 2 4
//		System.out.println(array);
		
		
		
		circleLinkListForHafuman<Object> array = new circleLinkListForHafuman<Object>();
		
		for (int i = 1; i <= 8; i++) {
			array.add(i);
		}
		System.out.println(array);
		array.reset();
		
		while (!array.isEmpty()) {
			array.next();
			array.next();
			array.remove();
		}
//		System.out.println(array);
		
	}
}
