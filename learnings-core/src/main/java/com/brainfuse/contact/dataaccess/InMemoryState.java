package com.brainfuse.contact.dataaccess;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.brainfuse.contact.dataaccess.BasicAccess;
import com.branfuse.contact.models.State;

public class InMemoryState implements BasicAccess<State>,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4723396783272807497L;
	private static final Logger logger = LoggerFactory.getLogger(InMemoryState.class);
	private Map<Long,State> states;
	
	public InMemoryState() {
		states = new HashMap<Long, State>();
		
		addMocks();
	}
	
	private void addMocks() {
		State ny = new State();
		State nj = new State();
		State ct = new State();
		
		states.put(1L,ny);
		states.put(2L,nj);
		states.put(3L,ct);
	}
	
	@Override
	public boolean create(State t) {
		return false;
	}

	@Override
	public int update(State t) {
		return 0;
	}

	@Override
	public List<State> find() {
		logger.debug("find states {}",states);
		return new ArrayList<State>(states.values());
	}

	@Override
	public int delete(long id) {
		return 0;
	}

	@Override
	public int delete(long... ids) {
		return 0;
	}
	
	@PostConstruct
	public void init(){
		logger.debug("{} created by container",this);
	}

	@Override
	public State findById(long id) {
		return states.get(id);
	}

	

}
