package no.hvl.dat110.ac.rest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.gson.Gson;

public class AccessLog {
	
	private AtomicInteger cid;
	protected ConcurrentHashMap<Integer, AccessEntry> log;
	
	public AccessLog () {
		this.log = new ConcurrentHashMap<Integer,AccessEntry>();
		cid = new AtomicInteger(0);
	}

	// TODO: add an access entry for the message and return assigned id DONE
	public int add(String message) {
		int id = cid.getAndIncrement();
		AccessEntry accessEntry = new AccessEntry(id, message);
		log.put(id, accessEntry);
		return id;
	}
		
	// TODO: retrieve a specific access entry DONE
	public AccessEntry get(int id) {
		
		return log.get(id);
		
	}
	
	// TODO: clear the access entry log DONE
	public void clear() {
		log.clear();
		
	}
	
	// TODO: JSON representation of the access log DONE
	public String toJson () {
    	
		String json = new Gson().toJson(log.values().toArray());
    	
    	return json;
    }
}
