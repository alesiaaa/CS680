package edu.umb.cs.cs680;

import java.util.Map;

//FIFO, First-in, First-out

public class FIFO implements CacheReplacementPolicy {
	
	private int lastUpdated = 0;
	private int capacity;
	private static FIFO instance = null; 
	
	private FIFO (){
		capacity = FileCache.getCacheCapacity();
	}
	
	public static FIFO getInstance(){
		
		if (instance == null){
			instance = new FIFO();
		}
		return instance;
		
	}
	
	
	public void replace(Map <Integer,String> map, String file) {
		
		// Retrieve key of item to be updated
		lastUpdated++;
		
		//Make sure last updated is not greater than capacity
		if (lastUpdated > capacity){
			lastUpdated = 1;
		}
		
		// Removes element in the collection
		map.remove(lastUpdated);
		
		// Place new element at the end of the collection
		map.put(lastUpdated,file);

	}
	

}
