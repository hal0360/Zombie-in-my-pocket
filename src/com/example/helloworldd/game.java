package com.example.helloworldd;

import java.util.Random;

public class game {
	private int health, attack, zombie;
	private tile cur_tile;
	private card[] cards;
	private double time;
	public game(){
		time = 9.00;
		cards = new card[4];
		cards[0] = new card(3,5,R.drawable.card1);
		cards[1] = new card(0,2,R.drawable.card2);
		cards[2] = new card(4,4,R.drawable.card3);
		cards[3] = new card(0,3,R.drawable.card4);
		health = 6;
		attack = 2;
		zombie = 0;
		cur_tile = new tile(R.drawable.foyer, "foyer");
		tile dinning = new tile(R.drawable.dinning, "dinning");
		tile bathroom = new tile(R.drawable.bathroom, "bathroom");
		tile storage = new tile(R.drawable.storage, "storage");
		tile temple = new tile(R.drawable.temple, "temple");
		tile patio = new tile(R.drawable.patio, "patio");
		tile garage = new tile(R.drawable.garage, "garage");
		tile garage2 = new tile(R.drawable.garage2, "garage2");
		tile grave = new tile(R.drawable.grave, "grave");
		cur_tile.set_north(dinning);
		dinning.set_west(bathroom);
		dinning.set_east(temple);
		dinning.set_south(cur_tile);
		dinning.set_north(patio);
		patio.set_south(dinning);
		patio.set_north(garage2);
		patio.set_west(garage);
		garage.set_east(patio);
		garage2.set_south(patio);
		garage2.set_west(grave);
		garage.set_north(grave);
		grave.set_east(garage2);
		grave.set_south(garage);
		bathroom.set_east(dinning);
		temple.set_west(dinning);
		temple.set_east(storage);
		storage.set_west(temple);
	}
	
	public boolean go_north(){
		boolean ta = cur_tile.get_north() != null;
		if(ta) {
			cur_tile = cur_tile.get_north();
			time = time + 0.25;
		}
		return ta;		
	}
	
	public boolean go_south(){
		boolean ta = cur_tile.get_south() != null;
		if(ta) {
			cur_tile = cur_tile.get_south();
			time = time + 0.25;
		}
		return ta;
	}
	
	public boolean go_east(){
		boolean ta = cur_tile.get_east() != null;
		if(ta) {
			cur_tile = cur_tile.get_east();
			time = time + 0.25;
		}
		return ta;
	}
	
	public boolean go_west(){
		boolean ta = cur_tile.get_west() != null;
		if(ta) {
			cur_tile = cur_tile.get_west();
			time = time + 0.25;
		}
		return ta;
	}
	
	public int draw_card(){		
		Random rand = new Random();
		int n = rand.nextInt(4);		
		zombie = cards[n].zombie;
		return cards[n].img;
	}
	
	public int image(){
		return cur_tile.image();
	}
	
	public String name(){
		return cur_tile.name();
	}
	
	public int zombie(){
		return zombie;
	}
	
	public int att(){
		return attack;
	}
	
	public int hp(){
		return health;
	}
	
	public boolean kill(){
		health = health + attack - zombie;
		zombie = 0;
		if(health <= 0){
			return true;
		}
		else{
			return false;
		}
	}
}
