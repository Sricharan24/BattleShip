import java.util.Scanner;

class Main {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	System.out.print("How tall should the board be? ");
      int tall = in.nextInt();
      System.out.print("How wide should the board be? ");
      int wide = in.nextInt();
      System.out.print("How two unit ships? ");
      int two = in.nextInt();
      System.out.print("How three unit ships? ");
      int three = in.nextInt();
      System.out.print("How four unit ships? ");
      int four = in.nextInt();
      boolean[][] player1ships = setupGame(tall,wide,two,three,four);
      int total = (two*2) + (three*3) + (four*4);
      System.out.println("You will now create a grid for player 2");
      boolean[][] player2ships = setupGame(tall,wide,two,three,four);
      boolean[][] player1guess = new boolean[tall][wide];
      boolean[][] player2guess = new boolean[tall][wide];
      int numHits1 = 0;
      int numHits2 = 0;
  
      System.out.println("The game begins!");
      while (true) {
        System.out.println("Player 1, here's your board:");
        printGrid(player1guess);
        
        System.out.print("Player 1, pick a row: ");
        int row = in.nextInt();
        System.out.print("Player 1, pick a column: ");
        int col = in.nextInt();
        
        if (row < 0 || row >= tall || col < 0 || col >= wide) {
            System.out.println("out of bounds!");
        } else if (player2ships[row][col] && !player1guess[row][col]) {
          System.out.println("hit!");
          player1guess[row][col] = true;
          numHits1++;
        } else if (player1guess[row][col]) {
          System.out.println("You already found a ship here!");
        } else {
          System.out.println("miss!");
        }
  
        if (numHits1 == total) {
          System.out.println("Player 1 sank all the ships! Player 1 wins!");
          break;
        }
  
        System.out.println("Player 2, here's your board:");
        printGrid(player2guess);
        
        System.out.print("Player 2, pick a row: ");
        row = in.nextInt();
        System.out.print("Player 2, pick a column: ");
        col = in.nextInt();
        
        if (row < 0 || row >= tall || col < 0 || col >= wide) {
            System.out.println("out of bounds!");
        } else if (player1ships[row][col] && !player2guess[row][col]) {
          System.out.println("hit!");
          player2guess[row][col] = true;
          numHits2++;
        } else if (player2guess[row][col]) {
          System.out.println("You already found a ship here!");
        } else {
          System.out.println("miss!");
        }
  
        if (numHits2 == total) {
          System.out.println("Player 2 sank all the ships! Player 2 wins!");
          break;
        }
      }
    }
      
  // Make sure that you print out the player's board in between setting up different ships
/* Handle a few possible errors 
  - Out of bounds coordinates (setup and game)
  - placing a ship where there is already a ship
*/
   public static boolean[][] setupGame(int tall, int wide, int two, int three, int four){
    Scanner in = new Scanner(System.in);
    boolean[][] playerships = new boolean[tall][wide];
    System.out.println("you will now pick coordinates for your two-unit ships.");
      for(int k = 0; k<two; k++){
        for(int i = 0; i<2; i++){
        System.out.print("Pick a row ");
        int row = in.nextInt();
        System.out.print("pick a column ");
        int col = in.nextInt();
        playerships[row][col] = true;
        printGrid(playerships);
        }
      }
      System.out.println("you will now pick coordinates for your three-unit ships.");
      for(int k = 0; k<three; k++){
        for(int i = 0; i<3; i++){
        System.out.print("Pick a row ");
        int row3 = in.nextInt();
        System.out.print("pick a column ");
        int col3 = in.nextInt();
        playerships[row3][col3] = true;
        printGrid(playerships);
        }
      }
      System.out.println("you will now pick coordinates for your four-unit ships.");
      for(int k = 0; k<four; k++){
        for(int i = 0; i<4; i++){
        System.out.print("Pick a row ");
        int row4 = in.nextInt();
        System.out.print("pick a column ");
        int col4 = in.nextInt();
        playerships[row4][col4] = true;
        printGrid(playerships);
        }
      }
     return playerships; 
   }
   public static void printGrid(boolean[][] grid) {
    System.out.print("  ");
    for (int i = 0; i < grid[0].length; i++) {
      System.out.print(" " + i + " ");
    }
    System.out.println();

    for (int i = 0; i < grid.length; i++) {
      System.out.print(i + " ");
      for (int j = 0; j < grid[0].length; j++){
        if (grid[i][j]) {
          System.out.print(" x ");
        } else {
          System.out.print(" - ");
        }
      }
      System.out.println();
    }
  } 
}
