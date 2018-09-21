/*
 * TODO: edge cases (handling memory on the first turn
 *       wiping output each turn
 *       Random spawnpoint
 */
package cz3005.intelligentagents;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author andjo574
 */
public class Game {
    
    ArrayList<Box> board = new ArrayList<>();       //stores the game board

    public Game() {     //constructor, build the game board
        
        Box box1 = new Box(true); //r1, 1
        Box box2 = new Box(true); //r1, 2
        Box box3 = new Box(true); //r1, 3
        Box box4 = new Box(true); //on top of goal
        Box box5 = new Box(true); //r1, 5
        Box box6 = new Box(true); //r1, 6
        Box box7 = new Box(true); //r1, 7
        Box box8 = new Box(true); //r2, 1
        Box box9 = new Box(false); //r2, 2
        Box box10 = new Box(false); //r2, 3
        Box box11 = new Box(false); //r2, 4
        Box box12 = new Box(false); //r2, 5
        Box box13 = new Box(false); //r2, 6
        Box box14 = new Box(false); //r2, 7
        Box box15 = new Box(false); //r2, 8
        Box box16 = new Box(true); //r2, 9
        Box box17 = new Box(true); //r3, 1
        Box box18 = new Box(false); //r3, 2
        Box box19 = new Box(false); //r3, 3
        Box box20 = new Box(false); //r3, 4
        Box box21 = new Box(false); //r3, 5
        Box box22 = new Box(false); //r3, 6
        Box box23 = new Box(false); //r3, 7
        Box box24 = new Box(false); //r3, 8
        Box box25 = new Box(true); //r3, 9
        Box box26 = new Box(true); //r4, 1
        Box box27 = new Box(false); //r4, 2
        Box box28 = new Box(false); //r4, 3
        Box box29 = new Box(false); //r4, 4
        Box box30 = new Box(false); //r4, 5
        Box box31 = new Box(false); //r4, 6
        Box box32 = new Box(false); //r4, 7
        Box box33 = new Box(false); //r4, 8
        Box box34 = new Box(true); //r4, 9
        Box box35 = new Box(true); //r5, 1
        Box box36 = new Box(false); //r5, 2
        Box box37 = new Box(false); //r5, 3
        Box box38 = new Box(false); //r5, 4
        Box box39 = new Box(false); //r5, 5
        Box box40 = new Box(false); //r5, 6
        Box box41 = new Box(false); //r5, 7
        Box box42 = new Box(false); //r5, 8
        Box box43 = new Box(true); //r5, 9
        Box box44 = new Box(true); //r6, 1
        Box box45 = new Box(false); //r6, 2
        Box box46 = new Box(false); //r6, 3
        Box box47 = new Box(false); //r6, 4
        Box box48 = new Box(false); //r6, 5
        Box box49 = new Box(false); //r6, 6
        Box box50 = new Box(false); //r6, 7
        Box box51 = new Box(false); //r6, 8
        Box box52 = new Box(true); //r6, 9
        Box box53 = new Box(true); //r7, 1
        Box box54 = new Box(true); //r7, 2
        Box box55 = new Box(true); //r7, 3
        Box box56 = new Box(true); //r7, 4
        Box box57 = new Box(true); //r7, 5
        Box box58 = new Box(true); //r7, 6
        Box box59 = new Box(true); //r7, 7
        Box box60 = new Box(false); //goal
        
        box60.isGoal = true;
        
        box1.setNeighbors(null, box2, box25, null); 
        box2.setNeighbors(null, box3, box26, box1); 
        box3.setNeighbors(null, box60, box27, box2);
        box4.setNeighbors(null, null, box60, null); 
        box5.setNeighbors(null, box6, box29, box60);
        box6.setNeighbors(null, box7, box30, box5); 
        box7.setNeighbors(null, null, box25, box6); 
        box8.setNeighbors(null, box9, box17, null); 
        box9.setNeighbors(box1, box10, box18, box8); 
        box10.setNeighbors(box2, box11, box19, box9);
        box11.setNeighbors(box3, box12, box20, box10);
        box12.setNeighbors(box60, box13, box21, box11);
        box13.setNeighbors(box5, box14, box22, box12);
        box14.setNeighbors(box6, box15, box23, box13);
        box15.setNeighbors(box7, box16, box24, box14);
        box16.setNeighbors(null, null, box25, box15);
        box17.setNeighbors(box8, box18, box26, null);
        box18.setNeighbors(box9, box19, box27, box17);
        box19.setNeighbors(box10, box20, box28, box18);
        box20.setNeighbors(box11, box21, box29, box19);
        box21.setNeighbors(box12, box22, box30, box20);
        box22.setNeighbors(box13, box23, box31, box21);
        box23.setNeighbors(box14, box24, box32, box22);
        box24.setNeighbors(box15, box25, box33, box23);
        box25.setNeighbors(box16, null, box34, box24);
        box26.setNeighbors(box17, box27, box35, null);
        box27.setNeighbors(box18, box28, box36, box26);
        box28.setNeighbors(box19, box29, box37, box27);
        box29.setNeighbors(box20, box30, box38, box28);
        box30.setNeighbors(box21, box31, box39, box29);
        box31.setNeighbors(box22, box32, box40, box30);
        box32.setNeighbors(box23, box33, box41, box31);
        box33.setNeighbors(box24, box34, box42, box32);
        box34.setNeighbors(box25, null, box43, box33);
        box35.setNeighbors(box26, box36, box44, null);
        box36.setNeighbors(box27, box37, box45, box35);
        box37.setNeighbors(box28, box38, box46, box36);
        box38.setNeighbors(box29, box39, box47, box37);
        box39.setNeighbors(box30, box40, box48, box38);
        box40.setNeighbors(box31, box41, box49, box39);
        box41.setNeighbors(box32, box42, box50, box40);
        box42.setNeighbors(box33, box43, box51, box41);
        box43.setNeighbors(box34, null, box52, box42);
        box44.setNeighbors(box35, box45, null, null);
        box45.setNeighbors(box36, box46, box53, box44);
        box46.setNeighbors(box37, box47, box54, box45);
        box47.setNeighbors(box38, box48, box55, box46);
        box48.setNeighbors(box39, box49, box56, box47);
        box49.setNeighbors(box40, box50, box57, box48);
        box50.setNeighbors(box41, box51, box58, box49);
        box51.setNeighbors(box42, box52, box59, box50);
        box52.setNeighbors(box43, null, null, box51);
        box53.setNeighbors(box45, box54, null, null);
        box54.setNeighbors(box46, box55, null, box53);
        box55.setNeighbors(box47, box56, null, box54);
        box56.setNeighbors(box48, box57, null, box55);
        box57.setNeighbors(box49, box58, null, box56);
        box58.setNeighbors(box50, box59, null, box57);
        box59.setNeighbors(box51, null, null, box58);
        box60.setNeighbors(box4, box5, box12, box3);
        
        box4.symbol = "    X    "; //special cases - corners, top box
        box1.symbol = " X";
        box7.symbol = "X ";
        box53.symbol = " X";
        box59.symbol = "X ";
        
        board.add(box1);
        board.add(box2);
        board.add(box3);
        board.add(box4);
        board.add(box5);
        board.add(box6);
        board.add(box7);
        board.add(box8);
        board.add(box9);
        board.add(box10);
        board.add(box11);
        board.add(box12);
        board.add(box13);
        board.add(box14);
        board.add(box15);
        board.add(box16);
        board.add(box17);
        board.add(box18);
        board.add(box19);
        board.add(box20);
        board.add(box21);
        board.add(box22);
        board.add(box23);
        board.add(box24);
        board.add(box25);
        board.add(box26);
        board.add(box27);
        board.add(box28);
        board.add(box29);
        board.add(box30);
        board.add(box31);
        board.add(box32);
        board.add(box33);
        board.add(box34);
        board.add(box35);
        board.add(box36);
        board.add(box37);
        board.add(box38);
        board.add(box39);
        board.add(box40);
        board.add(box41);
        board.add(box42);
        board.add(box43);
        board.add(box44);
        board.add(box45);
        board.add(box46);
        board.add(box47);
        board.add(box48);
        board.add(box49);
        board.add(box50);
        board.add(box51);
        board.add(box52);
        board.add(box53);
        board.add(box54);
        board.add(box55);
        board.add(box56);
        board.add(box57);
        board.add(box58);
        board.add(box59);
        board.add(box60);
        
    }
    
    public void printBoard() {  //prints the game board
        System.out.println(board.get(3).symbol); //top
        
        for(int i = 0; i < 3; i++) {               //r1
            System.out.print(board.get(i).symbol);
        }
        System.out.print(board.get(59).symbol);
        for(int i = 4; i < 7; i++) {
            System.out.print(board.get(i).symbol);
        }
        System.out.println();
        
        for(int i = 7; i < 16; i++) {               //r2
            System.out.print(board.get(i).symbol);
        }
        System.out.println();
        
        for(int i = 16; i < 25; i++) {               //r3
            System.out.print(board.get(i).symbol);
        }
        System.out.println();
        
        for(int i = 25; i < 34; i++) {               //r4
            System.out.print(board.get(i).symbol);
        }
        System.out.println();
        
        for(int i = 34; i < 43; i++) {               //r5
            System.out.print(board.get(i).symbol);
        }
        System.out.println();
        
        for(int i =43; i < 52; i++) {               //r6
            System.out.print(board.get(i).symbol);
        }
        System.out.println();
        
        for(int i = 52; i < 59; i++) {               //r7
            System.out.print(board.get(i).symbol);
        }
        System.out.println();
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Game game = new Game();         //initializes game
        Player player = new Player();   //initializes player
        player.setPlaying(true);        // starts game loop
        player.location = game.board.get(player.spawnpoint());
        
        player.location.symbol = player.playerSymbol;
        
        Scanner scan = new Scanner(System.in);  // initializes scanner for player commands
        String cmd;
        
        System.out.println("Human or AI?");
        if (scan.nextLine().equals("human")) { //user in control
            while(player.isPlaying()) {
                game.printBoard();

                cmd = scan.nextLine();
            
                if (cmd.equals("exit")) {
                    player.setPlaying(false);
                } else {
                    player.move(cmd);
                }
            
                if (player.location.isGoal) { //win condition
                    player.setPlaying(false);
                    System.out.println("Congratulations!");
                }
            
            } 
        } else {            // AI in control
            while(player.isPlaying()) {
                game.printBoard();
                
//                player.playerDecision1();
//                player.playerDecision2();
                player.playerDecision3();
                sleep(500);     //sleeps the software to enhance UX
                
                if (player.location.isGoal) {  //win condition 
                    player.setPlaying(false);
                    game.printBoard();
                    System.out.println("Congratulations!");
                }
            }  
        }
    }
        

}
    
    
    

