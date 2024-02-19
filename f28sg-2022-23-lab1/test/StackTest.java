import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class StackTest {

	Stack st;
	@Before
	public void setup()
	{
		st = new Stack(2);
	}
	
	/*
	 * Part1: complete the following test methods as specified. 
	 * Note that you will need to add new methods in order to test that exceptions are thrown
	 */
	
	@Test
	public void testPushEmptySize() {
		// test the size of an empty stack (hint: test st.size() )

        assertEquals(0,st.size());

		//fail("not implemented yet");
	}
	
	@Test
	public void testPushNonEmptySize() {
		st.push("A");
		st.push("B");
		// test the size of a non-empty stack
		assertEquals(2,st.size());
//		fail("not implemented yet");
	}
	
	@Test
	public void testPopTwo() {
		st.push("A");
		st.push("B");
		// step 1: test what st.pop() returns
		assertEquals("B",st.pop());
		assertEquals(1,st.size());
	//	fail("not implemented yet");
		// step 2: test what st.pop() returns
		assertEquals("A",st.pop());
		assertEquals(0,st.size());
	//	fail("not implemented yet");
	}
	
	@Test
	public void testTopTwo() {
		st.push("A");
		st.push("B");
		// step 1: test what st.top() returns
		st.top();
		assertEquals("B",st.top());
//		fail("not implemented yet");

		// step 2: test what st.top() returns
		st.top();
		assertEquals("B",st.top());
//		fail("not implemented yet");
	}
	
	
	@Test(expected = StackException.class)
	public void testEmptyPop() {
		// try popping from an empty stack
		assertEquals("stack is empty", st.pop());
//		fail("not implemented yet");
	}

	@Test(expected = StackException.class)
	public void testFullPush() {
		// try pushing too many elements to the stack
		st.push("1");
		st.push("2");
		st.push("3");
		// (which has a capacity of 2 elements)
//		fail("not implemented yet");
	}

}
