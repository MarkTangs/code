package Queue;

public class Main {
	public static void main(String[] args) {
		CircleDeque<Integer> queue = new CircleDeque<Integer>();
		
		queue.enQueueFront(11);
		queue.enQueueFront(22);
		queue.enQueueFront(33);
		queue.enQueueRear(44);
		
//		for (int i = 0; i <2; i++) {
//			queue.deQueueFront();
//		}
		
//		while (!queue.isEmpty()) {
//			System.out.println(queue.deQueue());
//		}
		System.out.println(queue);
	}
}
