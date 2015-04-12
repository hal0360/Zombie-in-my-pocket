package com.example.helloworldd;

public class tile {
	private int ir;
	private tile north;
	private tile south;
	private tile east;
	private tile west;
	private String nn;
	
    public tile(int r, String n){
    	ir = r;
    	nn = n;
    	north = null;
    	south = null;
    	west = null;
    	east = null;
    }
    
    public void set_north(tile t){
    	north = t;
    }
    
    public void set_south(tile t){
    	south = t;
    }
    
    public void set_east(tile t){
    	east = t;
    }
    
    public void set_west(tile t){
    	west = t;
    }
    
    public tile get_north(){
    	return north;
    }
    
    public tile get_south(){
    	return south;
    }
    
    public tile get_east(){
    	return east;
    }
    
    public tile get_west(){
    	return west;
    }
    
    public int image(){
    	return ir;
    }
    
    public String name(){
    	return nn;
    }
}
