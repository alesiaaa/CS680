package edu.umb.cs.cs680;

import java.util.HashMap;
import java.util.Map;

public class FileCache {
	
	private static final int maxCapacity = 10;
	private static FileCache instance;
	private Map <Integer,String> cache = new HashMap <Integer,String> ();
	private CacheReplacementPolicy cacheReplacementPolicy = null;
	
	
	private FileCache(){}
	
	public static FileCache getInstance(){
		if (instance == null){
			instance = new FileCache ();
		}
			return instance;
	}
	
	
	private String findValue (String value){
		String foundValue = null;
		if (cache.containsValue(value)){
			foundValue  = value;
		}
		return foundValue;
	}
	
	public String fetch (String targetFile) throws CacheReplacementPolicyException{
		
		String output = null;
		
		
		
		if (findValue(targetFile) != null){
			output  = findValue(targetFile);
		
		} else {
			
			
			// if cache is equal to 10 entries
			if (cache.size() == maxCapacity){
				
				
				if (this.cacheReplacementPolicy == null){
					
					// no policy chosen, cannot complete replacement
					throw new CacheReplacementPolicyException ("Please set the cache replacement policy "
							+ "identifier before proceeding. Cache at capacity.");
				
				} else {
					
					// replace using identified policy
					replace(targetFile);
					
					
				}
				
			} else {
				
				//if not at max capacity, add value
				cache.put(cache.size()+1, targetFile);
			
				
			}
		
			//check for saved value
			if (findValue(targetFile) != null){
				output  = findValue(targetFile);
			}
			
		}
		
		
		return output;
		
	}
	
	public void setCacheReplacementPolicy(CacheReplacementPolicy c){
			this.cacheReplacementPolicy = c;
	}
	
	public CacheReplacementPolicy getCacheReplacementPolicy(){
		return this.cacheReplacementPolicy;
}
	
	private void replace (String targetFile){
		cacheReplacementPolicy.replace(this.cache, targetFile);
		
	}
	
	public Map <Integer,String> getCacheContent (){
		return cache;
	}
	
	public static int getCacheCapacity(){
		return maxCapacity;
	}
	
	public int getCurrentCacheCapacity(){
		return cache.size();
	}
	
	public void clearCache(){
		cache.clear();
	}
	
	//override toString() method
    @Override 
    public String toString(){
        return "(" + cache + ")";
    }
    
    public static void main(String[] args) throws CacheReplacementPolicyException {
		
    	System.out.println("Get instance of File Cache.");
		FileCache fc = FileCache.getInstance();
		System.out.println("Set policy to FIFO. Capacity is 10.");
		fc.setCacheReplacementPolicy(new FIFO());
		fc.clearCache();
		
		System.out.println("Add all of the following items: ");
		
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
		
		System.out.print(item1 + ", " +
				item2 + ", " +
				item3 + ", " +
				item4 + ", " +
				item5 + ", " +
				item6 + ", " +
				item7 + ", " +
				item8 + ", " +
				item9 + ", " +
				item10 + ", " +
				item11 + ", " +
				item12);
		
		fc.fetch(item1);
		fc.fetch(item2);
		fc.fetch(item3);
		fc.fetch(item4);
		fc.fetch(item5);
		fc.fetch(item6);
		fc.fetch(item7);
		fc.fetch(item8);
		fc.fetch(item9);
		fc.fetch(item10);
		fc.fetch(item11);
		fc.fetch(item12);
		
		System.out.println("\nThe following was saved in the cache: ");
		System.out.println(fc);
		
		System.out.println("First two elements were replaced.");
		
		
	}
	
}
