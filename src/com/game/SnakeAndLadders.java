package com.game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.board.Board;
import com.entities.Player;
import com.exception.SnakeAndLadderException;

public class SnakeAndLadders {
	private Board board; 
	List<Player> players;
	Queue<Player> turn;
	
	private SnakeAndLadders(Builder builder) {
		board=builder.board;
		players=builder.players;
		turn=builder.turn;
	}
	
	public static class Builder{
		private Board board;
		List<Player> players;
		Queue<Player> turn;
		
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
		public SnakeAndLadders build() throws SnakeAndLadderException {
			if(players.size()<2)
				throw new SnakeAndLadderException("Atleast 2 players are required");
			return new SnakeAndLadders(this);
		}
	}
	
	public void move(int moves) {
		Player p=turn.peek();
		if(turn.size()==1) {
			System.out.println("Game Already Completed");
			return;
		}
		if(!board.validMoves(p.getCurrentPosition(), moves)) {
			System.out.println("Invalid Move");
			turn.poll();
			turn.add(p);
			return;
		}
		int finalPosition = board.move(p.getCurrentPosition(), moves);
		System.out.println(p.getName()+"-->"+p.getCurrentPosition()+"-->"+finalPosition);
		p.updatePosition(finalPosition);
		turn.poll();
		if(board.isWin(finalPosition)) {
			System.out.println(p.getName()+" Won!!");
			p.upadateRank(getRank());
			return;
		}
		turn.add(p);
	}
	public int getRank() {
		return players.size()-turn.size();
	}
	
	public void getGameResult() {
		System.out.println("| Rank | Name |");
		for(Player p:players) {
			System.out.println("| "+p.getRank()+" | "+p.getName()+" |");
		}
	}

}
