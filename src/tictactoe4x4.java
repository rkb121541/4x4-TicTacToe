import java.util.Scanner;
import java.util.Random;

public class tictactoe4x4{

    public static void main(String args[]) {

        while (true) {
            System.out.println("Welcome to a game of 4x4 tic tac toe!");
            String[] board = {" 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", "11", "12", "13", "14", "15", "16"};
            printBoard(board);
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            while (true) {
                System.out.println("Where would you like to place your marker 'X'? (1-16)");
                String userInput = scanner.nextLine().trim();

                while (makeMove(board, " X", userInput) == false) {
                    System.out.println("Invalid input.");
                    System.out.println("Please choose an available slot to place your marker 'X' (1-16)");
                    printBoard(board);
                    System.out.println("Where would you like to place your marker 'X'? (1-9)");
                    userInput = scanner.nextLine().trim();
                }
                printBoard(board);

                if (checkWinner(board) == true) {
                    System.out.println("Congratulations, you won!");
                    break;
                } else if (checkDone(board)) {
                    System.out.println("It's a tie!");
                    break;
                }

                int computerInput = random.nextInt(1,17);
                while (makeMove(board, " O", String.valueOf(computerInput)) == false) {
                    computerInput = random.nextInt(1,17);
                }
                System.out.println("The computer has placed its marker 'O'");
                printBoard(board);
                if (checkWinner(board) == true) {
                    System.out.println("You lost!");
                    break;
                } else if (checkDone(board)) {
                    System.out.println("It's a tie!");
                    break;
                }        
            }

            System.out.println("Would you like to play again? (y/n)");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            while (!playAgain.equals("y") && !playAgain.equals("n")) {
                System.out.println("Would you like to play again? (y/n)");
                playAgain = scanner.nextLine().trim().toLowerCase();
            }

            if (playAgain.equals("n")) {
                System.out.println("Thanks for playing!");
                // Scanner scanner = new Scanner(System.in);
                // https://stackoverflow.com/questions/58244954/why-cant-i-just-create-another-scanner-object-after-using-scanner-close
                // You can't recreate the new scanner object in the next iteration of the while loop because it closes System.in
                scanner.close();
                break;
            }
        }
    }

    public static void printBoard(String[] board) {
        System.out.println(board[0] + "|" + board[1] + "|" + board[2] + "|" + board[3]);
        System.out.println(board[4] + "|" + board[5] + "|" + board[6] + "|" + board[7]);
        System.out.println(board[8] + "|" + board[9] + "|" + board[10] + "|" + board[11]);
        System.out.println(board[12] + "|" + board[13] + "|" + board[14] + "|" + board[15]);
    }

    public static boolean checkWinner(String[] board) {
        if (
                (board[0] == board[1] && board[1] == board[2] && board[2] == board[3]) ||
                (board[4] == board[5] && board[5] == board[6] && board[6] == board[7]) ||
                (board[8] == board[9] && board[9] == board[10] && board[10] == board[11]) ||
                (board[12] == board[13] && board[13] == board[14] && board[14] == board[15]) ||
                (board[0] == board[4] && board[4] == board[8] && board[8] == board[12]) ||
                (board[1] == board[5] && board[5] == board[9] && board[9] == board[13]) ||
                (board[2] == board[6] && board[6] == board[10] && board[10] == board[14]) ||
                (board[3] == board[7] && board[7] == board[11] && board[11] == board[15]) ||
                (board[0] == board[5] && board[5] == board[10] && board[10] == board[15]) ||
                (board[3] == board[6] && board[6] == board[9] && board[9] == board[12])
                ) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkDone(String[] board) {
        // iterates through "board" to see if any of the elements in it are 'X' or 'O'
        for (int i = 0; i < 16; i++) {
            if (board[i] != " X" && board[i] != " O") {
                return false;
            }
        }
        return true;
    }

    public static boolean makeMove(String[] board, String turn, String position) {

        if (position.length() > 2 || Integer.parseInt(position) > 16 || Integer.parseInt(position) < 1 ||
            board[Integer.parseInt(position) - 1] == " X" || board[Integer.parseInt(position) - 1] == " O") {
            return false;
        }

        // https://www.youtube.com/watch?v=fjUG_y5ZaL4 -> switch is faster than if
        // when it gets translated to assembly, all the if statements will be CMP
        // so the computer will need to run through all the CMP instructions for each if statement
        // in assembly, the switch statement is O(1) so it can access the desired one immediately by doing some smart arithmetic
        // hence, switch > if for runtime

        switch(position) {
            case "1":
                board[0] = turn;
                return true;
            case "2":
                board[1] = turn;
                return true;
            case "3":
                board[2] = turn;
                return true;
            case "4":
                board[3] = turn;
                return true;
            case "5":
                board[4] = turn;
                return true;
            case "6":
                board[5] = turn;
                return true;
            case "7":
                board[6] = turn;
                return true;
            case "8":
                board[7] = turn;
                return true;
            case "9":
                board[8] = turn;
                return true;
            case "10":
                board[9] = turn;
                return true;
            case "11":
                board[10] = turn;
                return true;
            case "12":
                board[11] = turn;
                return true;
            case "13":
                board[12] = turn;
                return true;
            case "14":
                board[13] = turn;
                return true;
            case "15":
                board[14] = turn;
                return true;
            case "16":
                board[15] = turn;
                return true;
            default:
                return false;
        }
    }


}