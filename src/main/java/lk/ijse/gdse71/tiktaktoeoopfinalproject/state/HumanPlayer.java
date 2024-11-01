package lk.ijse.gdse71.tiktaktoeoopfinalproject.state;

// encapsulating human Player behaviour
public class HumanPlayer extends Player {
    public HumanPlayer(BoardImpl board) {
        super(board);//  calls the humanplayers super class using super
    }


    // move eka valid nam HumanPlayerge move eka update krnwa...
    @Override
    public void move(int row, int col) {
        if (board.isLegalMove(row, col)) {
            board.updateMove(row,col,Piece.X);
        }
    }
}
