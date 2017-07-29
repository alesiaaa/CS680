package edu.umb.cs.cs680;

import java.util.Map;

public interface CacheReplacementPolicy {

	public void replace (Map<Integer, String> cache, String file);
	
}
