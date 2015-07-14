import static org.junit.Assert.*;

import org.junit.Test;




public class TransposerTest {

	@Test
	  public void testBasicTrans() {
	    assertEquals("G", Transposer.trans("A", 10));
	  }
	
	@Test
	 public void testForwardWrap() {
	   assertEquals("A", Transposer.trans("F", 4));
	 }
	
	@Test
	 public void testBackwardsWrap() {
	   assertEquals("G", Transposer.trans("B", -4));
	 }
	
	@Test
	 public void testBbFlatNote() {
	   assertEquals("F#", Transposer.trans("Bb", -4));
	 }
	
	@Test
	 public void testRegularFlatNote() {
	   assertEquals("E", Transposer.trans("Db", 3));
	 }
	
}
