package com.bean.annotation.manytomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class PlayerBean {

	@Id
	@GeneratedValue
	int playerId;
	
	@Column
	String name;

//	Set<SportsBean> sports; 
//	
//	public Set<SportsBean> getSports() {
//		return sports;
//	}
//
//	public void setSports(Set<SportsBean> sports) {
//		this.sports = sports;
//	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
