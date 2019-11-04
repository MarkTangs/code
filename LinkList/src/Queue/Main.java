package Queue;

public class Main {
	public static void main(String[] args) {
		CircleQueue<Integer> queue = new CircleQueue<Integer>();
		
		queue.enQueue(11);
		queue.enQueue(22);
		queue.enQueue(33);
		queue.enQueue(44);
		for (int i = 0; i < 9; i++) {
			queue.enQueue(i);
		}
		for (int i = 0; i < 4; i++) {
			queue.deQueue();
		}
		
//		while (!queue.isEmpty()) {
//			System.out.println(queue.deQueue());
//		}
		System.out.println(queue);
	}
}
