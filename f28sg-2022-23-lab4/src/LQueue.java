
/**
 * @author Ahmad Meda
 *
 */
public class LQueue {
	
	private class Node{
		Object element;
		Node next;
		
		public Node(Object e, Node n){
			element = e;
			next = n;
		}
		
		public Node(Object e){
			element = e;
			next = null;
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public LQueue(){
		head = null;
		tail = null;	
	}
	/**
	 * checks if the list is empty or not
	 *@return returns if the list is empty
	 */
	public boolean isEmpty(){
		//When head address is null ,the list is empty
		return head == null && tail == null;
	}
	
	public int size(){
		return size;
	}
	
	/** Part 3: complete
	 * adds an element to the queue and increments the size
	 *
	 */
	public void enqueue(Object o){
		Node add_obj = new Node(o, tail);
		if (head == null) {
			head = add_obj;
			tail = add_obj;
		}
		else {
			tail.next = add_obj;
			tail = add_obj;
		}
		size++;
	}
	
	/** Part 3: complete	
	 *pops the first element of the queue
	 *@return the popped element of the queue
	 */
	public Object dequeue() throws QueueException{
		if (isEmpty()) {
			throw new QueueException("The queue is Empty");
		}else {
			Object popped_element = head.element;
			head = head.next;
			size--;
			return popped_element; 
		}
	}
	/**
	 *checks the first element of the queue
	 *@return the first element of the queue
	 */
	public Object front() throws QueueException{
		if (isEmpty()) {
			throw new QueueException("The queue is empty");
		}else {
			Object first_element = head.element;
			return first_element;
		}
	}
	
}
