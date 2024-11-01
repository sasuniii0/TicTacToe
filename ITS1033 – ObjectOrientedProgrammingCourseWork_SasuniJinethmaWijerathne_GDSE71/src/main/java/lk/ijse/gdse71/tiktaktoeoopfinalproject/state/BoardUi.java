package lk.ijse.gdse71.tiktaktoeoopfinalproject.state;

// interface eka update krnwa
public interface BoardUi {
    void update(int row, int col,Piece piece);
    // board ek update krnwa UI eke

    void notifyWinner(Piece winner);
    // notify krnwa winner
}
