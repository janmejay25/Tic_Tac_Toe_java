package projects.Tic_Tac_Toe;
public class tic_tac_toe {

    public static void printboard(char[][] board) {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }
    public static boolean checkwin(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                System.out.println("Player " + board[i][0] + " wins!");
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                System.out.println("Player " + board[0][i] + " wins!");
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            System.out.println("Player " + board[0][0] + " wins!");
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            System.out.println("Player " + board[0][2] + " wins!");
            return true;
        }
        return false;
    }
    public static boolean checktie(char[][] board) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != ' ') {
                    count++;
                }
            }
        }
        if (count == 9) {
            System.out.println("It's a tie!");
            return true;
        }
        return false;
    }
    

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        System.out.println("Welcome to Tic Tac Toe!");

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                board[i][j] = ' ';
            }
        }

        char player = 'X';
        while (true) {
            printboard(board);
            System.out.println("Player " + player + "'s turn.");
            System.out.println("Enter the number of the square you want to place your piece: ");
            int move = Integer.parseInt(System.console().readLine());
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            if (board[row][col] == ' ') {
                board[row][col] = player;
            }
            else {
                System.out.println("Invalid move. Try again.");
                continue;  
            }
            if(checkwin(board)){
                // System.out.println("Player " + player + " wins!");
                printboard(board);
                break;
            }
            else if(checktie(board)){
                // System.out.println("It's a tie!");
                printboard(board);
                break;
            }
            if (player == 'X') {
                player = 'O';
            } else {
                player = 'X';
            }
        }
    }
}

