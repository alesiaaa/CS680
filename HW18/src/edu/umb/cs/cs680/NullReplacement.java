package edu.umb.cs.cs680;

import java.util.Map;

public class NullReplacement implements CacheReplacementPolicy {
	
	private static NullReplacement instance = new NullReplacement ();

	private NullReplacement() {
		getInstance();
	}
	
	public static NullReplacement getInstance(){
			return instance;
	}
	
	
	public void replace(Map <Integer,String> map, String file) {
	
		//Policy does not replace anything
		
	}

}
