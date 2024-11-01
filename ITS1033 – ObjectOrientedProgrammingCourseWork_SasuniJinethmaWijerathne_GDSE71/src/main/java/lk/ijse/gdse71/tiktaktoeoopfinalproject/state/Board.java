package lk.ijse.gdse71.tiktaktoeoopfinalproject.state;

public interface Board {
    void initializeBoard();
    // cells okkoma empty karanwa... new game ekak gnn udw wenw

    boolean isLegalMove(int row,int col);
    // cell eka empty da blnwa.. balala empty nam move eka legal ehm nattam true krnwa

    void updateMove(int row , int col,Piece piece);
    //  board eka update krnwa.. Piece eka use krla

    Winner checkWinner();
    // board eke winner knk innwd check krla blnwa

    void printBoard();
    // console eke board eka print krnwa
}
