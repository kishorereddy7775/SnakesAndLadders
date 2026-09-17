package com.test;

import java.util.Random;

import com.entities.Player;
import com.exception.SnakeAndLadderException;
import com.game.SnakeAndLadders;

public class gameTest {

	public static void main(String[] args) {
		Player p1=new Player("Suresh");
		Player p2=new Player("Mukesh");
		Player p3=new Player("Ramesh");
		
		SnakeAndLadders game;
		try {
			game = new SnakeAndLadders.Builder(100).addPlayer(p1).addPlayer(p2).addPlayer(p3).addDice(6,1).build();
			while(!game.isGameOver()) {
				game.nextRoll();
			}
			game.getGameResult();
		} catch (SnakeAndLadderException e) {
			System.out.println(e.getMessage());
		}
	
		
	}

}
