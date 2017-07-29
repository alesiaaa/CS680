package edu.umb.cs.cs680;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


import org.junit.Test;

import edu.umb.cs.cs680.CacheReplacementPolicyException;
import edu.umb.cs.cs680.FIFO;
import edu.umb.cs.cs680.FileCache;
import edu.umb.cs.cs680.NullReplacement;

public class fifoTest {

	FileCache cut = FileCache.getInstance();
	
	
	@Test
	public void initilizeFifoCacheTest() {
		
		assertThat(cut.getCacheReplacementPolicy() instanceof NullReplacement, is(true));
		
		cut.setCacheReplacementPolicy(FIFO.getInstance());
		assertThat(cut.getCacheReplacementPolicy() instanceof FIFO, is(true));
		
	}
	
	@Test
	public void addItemsFifoCacheTest() throws CacheReplacementPolicyException {
		cut.setCacheReplacementPolicy(FIFO.getInstance());
		cut.clearCache();
		
		String item1 = "Hello";
		String item2 = "HelloAgain";
		String item3 = "GoodBye";
		
		cut.fetch(item1);
		cut.fetch(item2);
		cut.fetch(item3);
		
		assertThat(cut.getCurrentCacheCapacity(), is(3));
	}
	
	@Test
	public void addMaxItemsFifoCacheTest() throws CacheReplacementPolicyException {
		cut.setCacheReplacementPolicy(FIFO.getInstance());
		cut.clearCache();
		
		String item1 = "A";
		String item2 = "B";
		String item3 = "C";
		String item4 = "D";
		String item5 = "E";
		String item6 = "F";
		String item7 = "G";
		String item8 = "H";
		String item9 = "I";
		String item10 = "J";
		String item11 = "K";
		String item12 = "L";
		
		cut.fetch(item1);
		cut.fetch(item2);
		cut.fetch(item3);
		cut.fetch(item4);
		cut.fetch(item5);
		cut.fetch(item6);
		cut.fetch(item7);
		cut.fetch(item8);
		cut.fetch(item9);
		cut.fetch(item10);
		cut.fetch(item11);
		cut.fetch(item12);
		
		assertThat(cut.getCurrentCacheCapacity(), is(FileCache.getCacheCapacity()));
	}

	@Test
	public void checkFifoOrderTest() throws CacheReplacementPolicyException {
		cut.setCacheReplacementPolicy(FIFO.getInstance());
		cut.clearCache();
		
		String item1 = "A";
		String item2 = "B";
		String item3 = "C";
		String item4 = "D";
		String item5 = "E";
		String item6 = "F";
		String item7 = "G";
		String item8 = "H";
		String item9 = "I";
		String item10 = "J";
		String item11 = "K";
		String item12 = "L";
		String item13 = "M";
		String item14 = "N";
		String item15 = "O";
		String item16 = "P";
		String item17 = "Q";
		String item18 = "R";
		String item19 = "S";
		String item20 = "T";
		String item21 = "U";
		
		cut.fetch(item1);
		cut.fetch(item2);
		cut.fetch(item3);
		cut.fetch(item4);
		cut.fetch(item5);
		cut.fetch(item6);
		cut.fetch(item7);
		cut.fetch(item8);
		cut.fetch(item9);
		cut.fetch(item10);
		cut.fetch(item11);
		cut.fetch(item12);
		cut.fetch(item13);
		cut.fetch(item14);
		cut.fetch(item15);
		cut.fetch(item16);
		cut.fetch(item17);
		cut.fetch(item18);
		cut.fetch(item19);
		cut.fetch(item20);
		cut.fetch(item21);
		
		//System.out.println(cut.getCacheContent());
		
		assertThat(cut.getCacheContent().get(1), is("U"));
		assertThat(cut.getCacheContent().get(2), is("L"));
		assertThat(cut.getCacheContent().get(3), is("M"));
		assertThat(cut.getCacheContent().get(4), is("N"));
		assertThat(cut.getCacheContent().get(5), is("O"));
		assertThat(cut.getCacheContent().get(6), is("P"));
		assertThat(cut.getCacheContent().get(7), is("Q"));
		assertThat(cut.getCacheContent().get(8), is("R"));
		assertThat(cut.getCacheContent().get(9), is("S"));
		assertThat(cut.getCacheContent().get(10), is("T"));
	}
	
	
	@Test (expected=CacheReplacementPolicyException.class)
	public void checkExceptionFifoCacheTest() throws CacheReplacementPolicyException {
		
		//set to default replacement policy
		cut.setCacheReplacementPolicy(NullReplacement.getInstance());
		
		cut.clearCache();
		
		String item1 = "A";
		String item2 = "B";
		String item3 = "C";
		String item4 = "D";
		String item5 = "E";
		String item6 = "F";
		String item7 = "G";
		String item8 = "H";
		String item9 = "I";
		String item10 = "J";
		String item11 = "K";
		
		cut.fetch(item1);
		cut.fetch(item2);
		cut.fetch(item3);
		cut.fetch(item4);
		cut.fetch(item5);
		cut.fetch(item6);
		cut.fetch(item7);
		cut.fetch(item8);
		cut.fetch(item9);
		cut.fetch(item10);
		cut.fetch(item11);

		assertThat(cut.getCacheContent().size(), is(10));
	}
}
