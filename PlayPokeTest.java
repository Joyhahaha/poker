import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.junit.Assert;
import org.junit.Test;


public class PlayPokeTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
	}
	
	@Test
	public void get_playPoke_test() {
		PlayPoke inst = new PlayPoke();
		String blk = "Black: 2H 3D 5S 9C KD";
		String wht = "White: 2C 3H 4S 8C AH";
	    Assert.assertEquals("White wins",inst.playPoke(blk,wht));
}
	
}
