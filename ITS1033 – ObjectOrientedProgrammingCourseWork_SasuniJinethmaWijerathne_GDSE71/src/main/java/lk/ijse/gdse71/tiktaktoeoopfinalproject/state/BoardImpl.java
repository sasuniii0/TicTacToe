package lk.ijse.gdse71.tiktaktoeoopfinalproject.state;

public class BoardImpl implements Board {

    public BoardImpl(){
        initializeBoard();
    }
    // initialize krgnnwa EMPTY Piece eka board ekta

    private Piece[][] pieces = new Piece[3][3];
    // store krnwa Pieces array ekaka


    // EMPTY kyna piece eken board eka initialize krnwa
    @Override
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }

    // Empty cells tiynwda kyla check krnwa.. cell eka empty nam legalMove widihta boolean value eka yes krnwa
    @Override
    public boolean isLegalMove(int row, int col) {
        return pieces[row][col] == Piece.EMPTY;
    }

    // X hri O hri Piece eka dala cell eka update krnwa
    @Override
    public void updateMove(int row, int col, Piece piece) {
        pieces[row][col] = piece;
    }

    // check krnwa winningLines (rows / cols / diagonals)
    @Override
    public Winner checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (pieces[0][i] == pieces[1][i] && pieces[1][i] == pieces[2][i] && pieces[0][i] != Piece.EMPTY){
                //System.out.println("returned H");
                return new Winner(pieces[0][i], 0,i,1,i,2,i);
            }
            if(pieces[i][0] == pieces[i][1] && pieces[i][0] == pieces[i][2] && pieces[i][0] != Piece.EMPTY){
               // System.out.println("returned V");
                return new Winner(pieces[i][0], 0,i,1,i,2,i);
            }
        }
        if (pieces[0][0] == pieces[1][1] && pieces[0][0] == pieces[2][2] && pieces[0][0] != Piece.EMPTY){
           // System.out.println("returned diagonal");
            return new Winner(pieces[0][0],0,0,1,1,2,2);
        }
        if (pieces[2][0] == pieces[1][1] && pieces[2][0] == pieces[0][2] && pieces[2][0] != Piece.EMPTY){
            //System.out.println("returned diagonal");
            return new Winner(pieces[2][0] ,2,0,1,1,0,2);
        }
        return null;
    }

    // colsole eke board eke Piece eka print krnwa
    @Override
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print( pieces[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // return the pieces to array
    public Piece[][] getPieces() {
        return pieces;
    }

    // board eka full the blnwa ... cell ekak hari availableda balanwa ...cell empty nam
    public boolean isBoardFull() {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == Piece.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    //  board eke empty cell eka hoyagena eke coordinates array ekakta dagnnwa
    public int[] nextAvailableSpot() {
        for (int row = 0; row < pieces.length; row++) {
            for (int col = 0; col < pieces[row].length; col++) {
                if (pieces[row][col] == Piece.EMPTY) {
                    return new int[]{row, col}; // Return the coordinates of the first available spot
                }
            }
        }
        return null; // Return null if no available spots are found
    }
}
