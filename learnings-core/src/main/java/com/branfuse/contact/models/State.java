package com.branfuse.contact.models;

import com.branfuse.contact.models.City;
import com.branfuse.contact.models.ModelConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class State implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4940796393128467866L;

	@Override
	public String toString() {
		return String.format(
				"State [stateId=%s, name=%s, shortName=%s, cities=%s]",
				stateId, name, shortName, cities);
	}

	private  int stateId;
	private  String name;
	private  String shortName;
	
	private List<City> cities;

	public State() {
		cities = new ArrayList<>();
	}
	public List<City> getCities(){
		return Collections.unmodifiableList(cities);
	}

	public boolean isNew() {
		return stateId == ModelConstants.DEFAULT_ID;
	}

	public int getStateId() {
		return stateId;
	}

	public  String getName() {
		return name;
	}

	public  String getShortName() {
		return shortName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((shortName == null) ? 0 : shortName.hashCode());
		result = prime * result + stateId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (stateId != other.stateId)
			return false;
		return true;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
