package com.board;

import java.util.HashMap;

public class Board {
	int size;
	HashMap<Integer, Integer> snakes;
	HashMap<Integer, Integer> ladders;
	public Board(int size) {
		this.size=size;
		loadSnakes();
		loadLadders();
	}
	public void loadSnakes() {
		snakes=new HashMap<>();
		snakes.put(47, 26);
		snakes.put(49, 11);
		snakes.put(58,41);
		snakes.put(61, 19);
		snakes.put(86, 24);
		snakes.put(93, 73);
		snakes.put(95, 25);
		snakes.put(98, 28);
	}
	public void loadLadders() {
		ladders=new HashMap<>();
		ladders.put(4, 14);
		ladders.put(9, 31);
		ladders.put(20, 37);
		ladders.put(21, 42);
		ladders.put(28, 84);
		ladders.put(36, 57);
		ladders.put(51, 73);
		ladders.put(71, 92);
		ladders.put(80, 99);
		
		
		
		
		
		
	}
	
	public int move(int curPosition, int diceValue) {
		int finalPosition=curPosition+diceValue;
		if(snakes.containsKey(finalPosition)) {
			finalPosition=snakes.get(finalPosition);
		}else if(ladders.containsKey(finalPosition)) {
			finalPosition=ladders.get(finalPosition);
		}
		return finalPosition;
	}
	public boolean isValidMove(int curPosition, int diceValue) {
		return (curPosition+diceValue)<=size;
	}
	public boolean isWin(int curPosition) {
		return curPosition==size;
	}
	
}
