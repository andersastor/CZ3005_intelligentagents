/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz3005.intelligentagents;

/**
 * This is a test.
 * Don't mind me.
 * @author User
 */
class Box {
    
    private final boolean isWall;
    boolean isGoal;
    Box north;
    Box east;
    Box south;
    Box west;
    
    String symbol;
    
    public Box(boolean isWall) {
        this.isGoal = false;
        this.isWall = isWall;
        
        if (this.isWall) {
            this.symbol = "X";
        } else {
            this.symbol = " ";
        }
    }
    
    public boolean getWall() {
        return isWall;
    }
    
    public void setNeighbors(Box north, Box east, Box south, Box west) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }
    
}
