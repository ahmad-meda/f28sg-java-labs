
/**
 * @author Ahmad Meda
 *
 */
public class ReverseStack {


	/*
	 * 1: complete implementation
	 */
	/**
	 * reverses the queue
	 * @param st
	 */
	public static void reverseStack(Stack st){
			
		//Use a queue (queue.java)
		Queue reverse_stack = new Queue(st.size() + 1);
		//From stack st , pop out the element
		int size_no = st.size();
		//enqueue from the Q and push to the stack
		for (int i = 0; i < size_no; i++) {
			reverse_stack.enqueue(st.pop());
		}
		//Dequeue from the Q and push to the stack
		for (int i = 0; i <size_no; i++){
			st.push(reverse_stack.dequeue());
		}
		
	}
	
	
	
	
}
