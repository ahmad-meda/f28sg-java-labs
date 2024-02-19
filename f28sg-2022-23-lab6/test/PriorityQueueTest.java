import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Ahmad Meda
 *
 */
public class PriorityQueueTest {

	/*
	 * Part 1: complete
	 */
	
	PriorityQueue pq;
	
	@Before
	public void setup(){
		pq = new PriorityQueue(20);
	}
	
	@Test
	public void insertTestMin() {
		// insert a few numbers then test pq.min()
		pq.insert(10);
		pq.insert(40);
		pq.insert(30);
		pq.insert(20);
		//test
		assertEquals(10,pq.min());
	}
	
	@Test
	public void insertTestSize() {
		// insert a few numbers then test pq.size()
		pq.insert(12);
		pq.insert(41);
		pq.insert(34);
		pq.insert(26);
		//test
		assertEquals(4,pq.size());
	}

	@Test
	public void removeMinTest() {
		// step 1: add a few numbers to pq
		pq.insert(1);
		pq.insert(2);
		pq.insert(3);
		pq.insert(4);
		// step 2: call pq.removeMin() a few times to check
		//         numbers are returned in ascending order 
		assertEquals(1,pq.removeMin());
		assertEquals(2,pq.removeMin());
		assertEquals(3,pq.removeMin());
		
	}
	
	
	@Test(expected=PriorityQueueException.class)
	public void removeMinEmptyTest() {
		pq.removeMin();
	}
}	
