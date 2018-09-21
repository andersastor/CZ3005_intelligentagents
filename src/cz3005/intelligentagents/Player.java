/*
 * TODO: repeating code (sensorFront-sensorRight-agentMove
 */
package cz3005.intelligentagents;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author andjo574
 */
class Player {

    private boolean isPlaying = false; //controls game loop
    Box location; //current box which the player is located in
    String[] symbol = new String[4]; // array of size 4 holding all possible directions the player can face
    int status = 0; // the direction the player is facing, 0 = north, 1 = east, 2 = south, 3 = west
    String playerSymbol; // the player symbol which will be printed @ the player's location
    boolean memoryFront; //used in playerDecision3(), stores the previous state
    boolean memoryRight; //-II-

    public Player() {       // constructor, sets the initial direction the player is facing
        symbol[0] = "A";
        symbol[1] = ">";
        symbol[2] = "V";
        symbol[3] = "<";
        int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);  //generates a random direction
        playerSymbol = symbol[randomNum];
        
        int randomNum2;
        randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        switch (randomNum) {                                                    //generates a random position
            case 0:
                randomNum2 = ThreadLocalRandom.current().nextInt(8, 14 + 1);
                break;
            case 1:
                randomNum2 = ThreadLocalRandom.current().nextInt(8, 14 + 1);
                break;
            case 2:
                randomNum2 = ThreadLocalRandom.current().nextInt(8, 14 + 1);
                break;
            case 3: 
                randomNum2 = ThreadLocalRandom.current().nextInt(8, 14 + 1);
                break;
            default:
                break;
        }
    }
    
    public void setPlaying(boolean b) { //setter for isPlaying
        this.isPlaying = b;
    }
    
    public boolean isPlaying() {
        return isPlaying;
    }
    
    
    public void move(String cmd) { //takes commands deciding how to move
        if (cmd.equals("turn left")) {
            turnLeft();
        } else if (cmd.equals("turn right")) {
            turnRight();
        }
        
        if (cmd.equals("move")) {
            agentMove();
        }
        this.location.symbol = playerSymbol;
    }
    
    public void turnLeft() { // turns left NOTE: does not change the symbol
        status--;
            if (status < 0) {
                status = 3;
            }
    }
    
    public void turnRight() { // turns right NOTE: does not change the symbol
        status++;
            if (status > 3) {
                status = 0;
            }
    }
    
    public void agentMove() { //moves forward, prints message if the player attempts to walk into a wall
        this.location.symbol = " ";
            switch (status) {
                case 0:
                    if (this.location.north.getWall()) {
                        System.out.println("there is a wall");
                    } else {
                        this.location = this.location.north;
                    }   break;
                case 1:
                    if (this.location.east.getWall()) {
                        System.out.println("there is a wall");
                    } else {
                        this.location = this.location.east;
                    }   break;
                case 2:
                    if (this.location.south.getWall()) {
                        System.out.println("there is a wall");
                    } else {
                        this.location = this.location.south;
                    }   break;
                default:
                    if (this.location.west.getWall()) {
                        System.out.println("there is a wall");
                    } else {
                        this.location = this.location.west;
                    }   break;
            }
    }
    
    public boolean sensorFront() { // AI component, returns true if the player is facing a wall
        switch (status) {
                case 0:
                    if (this.location.north.getWall()) {
                        return true;
                    } else {
                    }   break;
                case 1:
                    if (this.location.east.getWall()) {
                        return true;
                    } else {
                    }   break;
                case 2:
                    if (this.location.south.getWall()) {
                        return true;
                    } else {
                    }   break;
                default:
                    if (this.location.west.getWall()) {
                        return true;
                    } else {
                    }   break;
            }
        return false;
    }
    
    public boolean sensorRight() { //AI component, returns true if there is a wall to the right of the player
        switch (status) {
                case 0:
                    if (this.location.east.getWall()) {
                        return true;
                    } else {
                    }   break;
                case 1:
                    if (this.location.south.getWall()) {
                        return true;
                    } else {
                    }   break;
                case 2:
                    if (this.location.west.getWall()) {
                        return true;
                    } else {
                    }   break;
                default:
                    if (this.location.north.getWall()) {
                        return true;
                    } else {
                    }   break;
            }
        return false;
    }
    
        
    public void playerDecision1() { // single sensor, no memory
        if (sensorFront()) {
            turnLeft();
        } else {
            agentMove();
        }
        playerSymbol = symbol[status];          //updates the player symbol and that of the current location
        this.location.symbol = playerSymbol;
    }
    
    public void playerDecision2() { //sensor in front and to the right, no sensor
        if (sensorFront() && !sensorRight()) {
            turnLeft();
        } else if (!sensorFront() && !sensorRight()) {
            turnRight();
        } else if (!sensorFront() && sensorRight()) {
            agentMove();
        } else {
            turnLeft();
        }                   //IF conditions from tutorial
        
        playerSymbol = symbol[status];
        this.location.symbol = playerSymbol;
    }
    
    public void playerDecision3() { // two sensors, single memory of previous state
        System.out.println(memoryRight + " " + memoryFront);
        if (sensorFront()) {
            saveMemory(); //saves the current state, then proceeds to the next
            turnLeft();
        } else if (!sensorFront() && !sensorRight() && !memoryFront && memoryRight) {
            saveMemory();
            turnRight();
        } else if (!sensorFront() && sensorRight()) {
            saveMemory();
            agentMove();
        } else if (!sensorFront() && !sensorRight() && !memoryRight) {
            saveMemory();
            agentMove();
        }
        
        playerSymbol = symbol[status];
        this.location.symbol = playerSymbol;
    }
    
    public void saveMemory() {  //saves the current state
        memoryFront = sensorFront();
        memoryRight = sensorRight();
    }
    
    public Integer spawnpoint() { //chooses spawnpoint
        return 40;
    }
}
