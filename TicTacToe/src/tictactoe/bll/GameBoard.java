/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{

    private int winnerId = -1;
    private  int[][] board= new int[3][3];
    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    private int playerTurn = 0;

    /**
     * Dette er en konstruktør, som går ind og fortæller at vi skal starte et newGame
     */
    public GameBoard(){
        newGame();
    }
    public int getNextPlayer()
    {
        return playerTurn;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        if (board[row][col] == -1) {
            board[row][col] = playerTurn;

            if (playerTurn == 0)
                playerTurn = 1;
            else
                playerTurn = 0;

            return true;
        }
        else{
            return false;
        }

    }

    public boolean isGameOver()
    {
        //boolean boardIsFull = boardIsFull();
        boolean winnerExist = checkForWinner();

        if (winnerExist)
            return true;
        else
            return false;
    }
    private boolean checkTie()
    {
        int counter =9;
        for (int r = 0; r < 3; r++)
        {
            for (int c = 0; c < 3; c++)
            {
                if(board[r][c] != -1)
                {
                    counter--;
                }
            }
        }
        if (counter == 0)
        {
            return true;
        }
        return  false;
    }

    private boolean checkForWinner() {
        //Horizontal win check
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != -1) {
                winnerId = board[row][0];
                return true;
            }

        }
        //Vertical win check
        for (int col = 0; col < board.length; col++)
        {
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != -1)
            {
                winnerId = board[0][col];
                return true;
            }


        }


        //Diagonal win check
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != -1) {
            winnerId = board[0][2];
            return true;
        }
                else if
            (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != -1) {
                winnerId = board[0][0];
                return true;
        }

        return false;
    }




        /**
         * Gets the id of the winner, -1 if its a draw.
         *
         * @return int id of winner, or -1 if draw.
         */
        public int getWinner() {
            if (checkForWinner())
                return winnerId;
            else return -1;
        }

        /**
         * Resets the game to a new game state.
         */
        public void newGame() {
            playerTurn = 0;
            //Den kigger efter hvor mange rows og cols vi har. går ind og fortæller at felterne skal være -1.
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board.length; col++) {
                    board[row][col] = -1;
                }
            }
        }
    }
