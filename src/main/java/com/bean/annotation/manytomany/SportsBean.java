package com.bean.annotation.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="sports")
public class SportsBean {

	@Id
	@GeneratedValue
	int sportsId;
	
	@Column
	String name;
	
	@ManyToMany(targetEntity=PlayerBean.class,cascade=CascadeType.ALL)
	@JoinTable(name="sports_player",joinColumns= {@JoinColumn(name="sportsId")},inverseJoinColumns= {@JoinColumn(name="playerId")})
	Set<PlayerBean> players;

	
	public Set<PlayerBean> getPlayers() {
		return players;
	}

	public void setPlayers(Set<PlayerBean> players) {
		this.players = players;
	}

	public int getSportsId() {
		return sportsId;
	}

	public void setSportsId(int sportsId) {
		this.sportsId = sportsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
}
