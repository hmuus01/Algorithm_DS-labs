public class StackQueue {
    private static Stack s;
    private static Queue q;
    public static void main(String[] args) {
	prepare();
	System.out.print(q.dequeue());
	System.out.print(s.pop());
	System.out.print(s.pop());
	System.out.print(q.dequeue());
	s.pop();
	q.dequeue();
	System.out.print(s.pop());
	System.out.print(q.dequeue());
	System.out.print(s.pop());
	System.out.println(q.dequeue());
	s.pop();
	q.dequeue();
    }
    private static void prepare() {
    	s = new Stack();
    	s.push(1);
    	s.push(4);
    	s.push(6);
    	s.push(1);
    	s.push(5);
    	s.push(3);
    	q = new Queue();
    	q.enqueue(3);
    	q.enqueue(4);
    	q.enqueue(1);
    	q.enqueue(6);
    	q.enqueue(2);
    	q.enqueue(1);
    }
}
