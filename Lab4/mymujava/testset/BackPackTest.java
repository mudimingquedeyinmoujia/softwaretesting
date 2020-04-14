import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;

public class BackPackTest {
	public BackPack b;
	public int expected[][];
	public int m;
	public int n;
	public int w[];
	public int p[];
	
	@Before
	public void setUp() throws Exception{
		b=new BackPack();
		m=10;
		n=3;
		w=new int[] {3,4,5};
		p=new int[] {4,5,6};
		expected=new int[][] {{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,4,4,4,4,4,4,4,4},
			{0,0,0,4,5,5,5,9,9,9,9},
			{0,0,0,4,5,6,6,9,10,11,11}};
	}
	@After
	public void tearDown() throws Exception{
		b=null;
	}

	@Test
	public void backPack_Solution() {
		assertArrayEquals(expected,b.BackPack_Solution(m,n,w,p));
	}

}
