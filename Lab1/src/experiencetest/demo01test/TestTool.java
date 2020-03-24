package experiencetest.demo01test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import experience.demo01.Tool;

public class TestTool {

	@Test
	public void testFindout() {
//		fail("Not yet implemented");
		Tool tool=new Tool();
		boolean ans1=Tool.findout(2);
		boolean ans2=Tool.findout(4);
		assertThat(ans1,is(true));
		assertThat(ans2,is(false));
	}

}
