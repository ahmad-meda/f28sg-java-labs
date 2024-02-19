import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * @author Ahmad Meda
 *
 */
public class LinkedListTest {

	LinkedList l;
	
	@Before
	public void setup(){
		l = new LinkedList();
	}
	/*
	 * Part 1: implement these methods
	 */
	@Test
	public void testSizeEmpty() {
		// test l.size() for an empty linked list
		assertEquals(0,l.size());
	}

	@Test
	public void testSizeMany() {
		// test l.size() after adding some numbers to the linked list
		l.addAtHead(10);
		l.addAtHead(20);
		l.addAtHead(30);
		l.addAtHead(40);
		assertEquals(4,l.size());
	}
	
	@Test
	public void testSizeTwice() {
		// test l.size() twice after adding some numbers to the linked list
		l.addAtHead(50);
		l.addAtHead(60);
		assertEquals(2,l.size());
		l.addAtHead(70);
		l.addAtHead(80);
		assertEquals(4,l.size());
	}

	@Test
	public void testTotalEmpty() {
		// test l.total() for an empty linked list
		assertEquals(0,l.total());
	}

	@Test
	public void testTotalMany() {
		// test l.total() after adding some numbers to the linked list
		l.addAtHead(1);
		l.addAtHead(2);
		l.addAtHead(3);
		l.addAtHead(4);
		assertEquals(10,l.total());
	}
	
	@Test
	public void testTotalTwice() {
		// test l.total() twice after adding some numbers to the linked list
		l.addAtHead(50);
		l.addAtHead(30);
		assertEquals(80,l.total());
		l.addAtHead(20);
		l.addAtHead(30);
		assertEquals(130,l.total());
	}
	
	/*
	 * Optional part
	 */
	
//	@Test
//	public void testReverse() {
//		l.addAtHead(5);
//		l.addAtHead(2);
//		l.addAtHead(10);
//		l.reverse();
//		assertEquals(5, l.removeAtHead());
//		assertEquals(2, l.removeAtHead());	
//		assertEquals(10, l.removeAtHead());	
//	}

}
