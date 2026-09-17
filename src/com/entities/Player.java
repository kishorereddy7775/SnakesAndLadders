package com.entities;

public class Player {

	private String name;
	private int currentPosition;
	private int rank;
	public Player(String name) {
		this.name=name;
	}
	public void updatePosition(int pos) {
		currentPosition=pos;
	}
	public int getCurrentPosition() {
		return currentPosition;
	}
	public String getName() {
		return name;
	}
	public void upadateRank(int rank) {
		this.rank=rank;
	}
	public int getRank() {
		return rank;
	}
}
