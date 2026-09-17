package com.dice;

import java.util.Random;

public class Dice {
	private int faces;
	private int count;
	public Dice(int faces,int count) {
		this.faces=faces;
		this.count=count;
	}
	public int roll() {
		Random random=new Random();
		int value=0;
		for(int i=0;i<count;i++) {
			value+=(random.nextInt(faces)+1);
		}
		return value;
	}
}
