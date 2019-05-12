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
	
	
//	@Test
//	public void get_suitEquals_test() {
//		PlayPoke inst = new PlayPoke();
//		List<String> suits = new ArrayList<String>();
//		suits.add("H");
//		suits.add("H");
//		suits.add("H");
//		suits.add("H");
//		suits.add("H);
//		Assert.assertEquals(true,inst.suitEquals(suits));		
//		
//	}

//	@Test
//	public void get_isConsecutive_test() {
//		PlayPoke inst = new PlayPoke();
//		List<Integer> numlist = new ArrayList<Integer>();
//		numlist.add(2);
//		numlist.add(3);
//		numlist.add(4);
//		numlist.add(5);
//		numlist.add(6);
//		Assert.assertEquals(true,inst.isConsecutive(numlist));
//	}
//	@Test
//	public void get_numCount_test() {
//		PlayPoke inst = new PlayPoke();
//		Map<Integer,Integer> numCount = new HashMap<Integer,Integer>();
//		numCount.put(2, 2);
//		numCount.put(3, 2);
//		numCount.put(6, 1);
//		List<Integer> numlist = new ArrayList<Integer>();
//		numlist.add(2);
//		numlist.add(2);
//		numlist.add(3);
//		numlist.add(3);
//		numlist.add(6);
//		Assert.assertEquals(numCount,inst.numCount(numlist));
//	}
//	@Test
//	public void get_rank_test() {
//		PlayPoke inst = new PlayPoke();
//		List<String> suits = new ArrayList<String>();
//	    suits.add("H");
//	    suits.add("H");
//		suits.add("H");
//		suits.add("H");
//		suits.add("H");
//		List<Integer> numlist = new ArrayList<Integer>();
//		numlist.add(2);
//		numlist.add(3);
//		numlist.add(4);
//		numlist.add(5);
//		numlist.add(6);
//        Assert.assertEquals(9,inst.rank(suits,numlist).intValue());
//	}
	@Test
	public void get_playPoke_test() {
		PlayPoke inst = new PlayPoke();
		String blk = "Black: 2H 3D 5S 9C KD";
		String wht = "White: 2C 3H 4S 8C AH";
	    Assert.assertEquals("White wins",inst.playPoke(blk,wht));
}
	
}
