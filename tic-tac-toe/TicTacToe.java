import java.util.Scanner;

public class TicTacToe {

    public enum GameState {
        NOT_FINISHED,
        DRAW, 
        X_WINS,
        O_WINS,
        IMPOSSIBLE
    }

    public static void main(String[] args) {
        
        char[][] grid = new char[3][3];
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        int pos = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
               grid[i][j] = input.charAt(pos);
               pos++; 
            }
        }

        printGrid(grid);
        GameState state = analyzeGameState(grid);
        System.out.println(printState(state));
    }

    static void printGrid(char[][] grid) {

        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println(" |");
        }

        System.out.println("---------");
    }

    static String printState(GameState state) {
        String s = "";

        switch(state) {
            case NOT_FINISHED:
                s = "Game not finished";
                break;
            case DRAW:
                s = "Draw";
                break;
            case X_WINS:
                s = "X wins";
                break;
            case O_WINS:
                s = "O wins";
                break;
            case IMPOSSIBLE:
                s = "Impossible";
                break;
            default:
                break;
        }

        return s;
    }

    static GameState analyzeGameState(char[][] grid) {

        GameState state = null;

        if (threeInARow(grid, 'X') && threeInARow(grid, 'O')) {
            state = GameState.IMPOSSIBLE;
        } else if(Math.abs(countPlays(grid, 'X') - countPlays(grid, 'O')) >= 2){
            state = GameState.IMPOSSIBLE;
        } else if (threeInARow(grid, 'X')) {
            state = GameState.X_WINS;
        } else if (threeInARow(grid, 'O')) {
            state = GameState.O_WINS;
        } else if (!hasEmptyCells(grid) && 
                    !threeInARow(grid, 'X') && 
                    !threeInARow(grid, 'O')) {
            state = GameState.DRAW;            
        } else if (hasEmptyCells(grid) && 
                    !threeInARow(grid, 'X') && 
                    !threeInARow(grid, 'O')) {
            state = GameState.NOT_FINISHED;            
        }

        return state;
    }

    static boolean hasEmptyCells(char[][] grid) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '_') {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean threeInARow(char[][] grid, char player) {

        //Testa na diagonal principal
        if (grid[0][0] == grid[1][1] && 
            grid[1][1] == grid[2][2] && 
            grid[2][2] == player) {
            return true;

        }

        //Testa na diagonal secundária
        if (grid[0][2] == grid[1][1] && 
            grid[1][1] == grid[2][0] && 
            grid[2][0] == player) {
            return true;

        }

        //Testa 3 na mesma linha
        for(int i = 0; i < 3; i++) {
            if(grid[i][0] == grid[i][1] && 
                grid[i][1] == grid[i][2] && 
                grid[i][2] == player) {
                return true;
            }
        }

        //Testa 3 na mesma coluna
        for(int j = 0; j < 3; j++) {
            if(grid[0][j] == grid[1][j] && 
                grid[1][j] == grid[2][j] && 
                grid[2][j] == player) {
                return true;
            }
        }

        return false;
    }

    static int countPlays(char[][] grid, char player) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == player) {
                    count++;
                }
            }
        }

        return count;
    }
}