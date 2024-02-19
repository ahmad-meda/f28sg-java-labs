import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Ahmad Meda
 *
 */
public class LQueueTest {

	LQueue q;
	@Before
	public void setup()
	{
		q = new LQueue();
	}
	
	/*
	 * 2: complete the following test methods as specified. 
	 */
	
	@Test
	public void testIsEmpty() {
		// test that q.isEmpty returns true
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void testIsEmptyFalse() {
		// add an element to the queue "q"
		q.enqueue(70);
		// then test that q is not an empty queue.
//		fail("not implemented yet");
		assertFalse(q.isEmpty());
	}

	@Test
	public void testSizeEmpty() {
		// test the size of an empty queue is 0
		assertEquals(0, q.size());
	}
	
	@Test
	public void testSizeNonEmpty() {
		// add an element(s) to the queue
		q.enqueue(5);
		// then test the size of the queue
		assertEquals(1, q.size());
	}

	@Test
	public void testEnqueue() {
		// enqueue an element(s) to the queue
		q.enqueue(10);
		// then test that the correct element is at the front
		assertEquals(10,q.front());
	}
	
	@Test
	public void testDequeue() {
		// enqueue multiple elements to the queue
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		// then check that they are returned in the
		// correct order with dequeue.
		assertEquals(10,q.dequeue());
		assertEquals(20,q.dequeue());
		assertEquals(30,q.dequeue());
		assertEquals(40,q.dequeue());
		assertEquals(50,q.dequeue());
		
	}
	
	@Test(expected = QueueException.class)  
	public void testEmptyDequeue() {  
		// try to dequeue an empty queue
		q.dequeue();
	}
	
	@Test(expected = QueueException.class)  
	public void testEmptyFront() {
		// try to get the front value of an empty queue
		q.front();
	}
}
