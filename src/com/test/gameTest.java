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
			game = new SnakeAndLadders.Builder(100).addPlayer(p1).addPlayer(p2).addPlayer(p3).build();
			for(int i=0;i<100;i++) {
				Random rand = new Random();
		        int min = 1;
		        int max = 6;
		        int rangedInt = rand.nextInt((max - min) + 1) + min;
		        game.move(rangedInt);
			}
			game.getGameResult();
		} catch (SnakeAndLadderException e) {
			System.out.println(e.getMessage());
		}
	
		
	}

}
