import static org.junit.Assert.*;

import org.junit.Test;




public class TransposerTest {

	@Test
	  public void testBasicTrans() {
	    assertEquals("G", Transposer.trans("A", 10));
	  }
}
