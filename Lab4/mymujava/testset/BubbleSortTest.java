import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
public class BubbleSortTest{
	public BubbleSort b;
	public int[] expected;
	
	@Before
	public void setUp() throws Exception{
		b=new BubbleSort();
		expected=new int[]{1,2,2,5,6};
		
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	@Test
	public void bubbleSort(){
		assertArrayEquals(expected,b.BubbleSort(new int[]{1,6,2,2,5}));
	}
}