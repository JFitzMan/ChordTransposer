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
	 public void testASharpNote() {
	   assertEquals("F#", Transposer.trans("A#", -4));
	 }
	
	@Test
	 public void testRegularFlatNote() {
	   assertEquals("E", Transposer.trans("Db", 3));
	 }
	
	@Test
	 public void testReturnFlat() {
	   assertEquals("Bb", Transposer.trans("C", -2));
	 }
	
	@Test
	 public void testExtraInfo1() {
	   assertEquals("Emin", Transposer.trans("C#min", 3));
	 }
	
	@Test
	 public void testExtraInfo2() {
	   assertEquals("Gmaj7", Transposer.trans("Amaj7", -2));
	 }
	
}
