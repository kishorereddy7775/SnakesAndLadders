package com.game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.board.Board;
import com.dice.Dice;
import com.entities.Player;
import com.exception.SnakeAndLadderException;

public class SnakeAndLadders {
	private Board board; 
	private List<Player> players;
	private Queue<Player> turn;
	private Dice dice;
	private int FinishedPlayers=0;
	
	private SnakeAndLadders(Builder builder) {
		board=builder.board;
		players=builder.players;
		turn=builder.turn;
		dice=builder.dice;
	}
	
	public static class Builder{
		private Board board;
		private List<Player> players;
		private Queue<Player> turn;
		private Dice dice;
		
		public Builder(int n) {
			board=new Board(n);
			players=new ArrayList<Player>();
			turn=new ArrayDeque<>();
		}
		public Builder addPlayer(Player p) {
			players.add(p);
			turn.add(p);
			p.updatePosition(0);
			return this;
		}
		public Builder addDice(int n, int numberOfDice) {
			dice=new Dice(n,numberOfDice);
			return this;
		}
		public SnakeAndLadders build() throws SnakeAndLadderException {
			if(players.size()<2)
				throw new SnakeAndLadderException("Atleast 2 players are required");
			return new SnakeAndLadders(this);
		}
	}
	
	public void nextRoll() {
		move(dice.roll());
	}
	
	private void move(int diceValue) {
		Player p=turn.peek();
		if(!board.isValidMove(p.getCurrentPosition(), diceValue)) {
			System.out.println("Invalid Move");
			turn.poll();
			turn.add(p);
			return;
		}
		int finalPosition = board.move(p.getCurrentPosition(), diceValue);
		System.out.println(p.getName()+"-->"+p.getCurrentPosition()+"-->"+finalPosition);
		p.updatePosition(finalPosition);
		turn.poll();
		if(board.isWin(finalPosition)) {
			System.out.println(p.getName()+" Won!!");
			p.updateRank(++FinishedPlayers);
			if(isGameOver()) {
				turn.peek().updateRank(++FinishedPlayers);
			}
			return;
		}
		turn.add(p);
	}
	
	public boolean isGameOver() {
		return turn.size()==1;
	}
	
	public void getGameResult() {
		System.out.println("| Rank | Name |");
		for(Player p:players) {
			System.out.println("| "+p.getRank()+" | "+p.getName()+" |");
		}
	}

}
