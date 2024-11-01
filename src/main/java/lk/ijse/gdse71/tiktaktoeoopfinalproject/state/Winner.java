package lk.ijse.gdse71.tiktaktoeoopfinalproject.state;

// Get the Winning Piece using this Winner class
public class Winner {

    private Piece winningPiece; // stores the winning Piece
    private int row1;
    private int row2;
    private int row3;
    private int col1;
    private int col2;
    private int col3;


    // initialize the winning piece and get the cells of the winning line using Constructor
    public Winner(Piece winningPiece, int row1, int col1, int row2, int col2, int row3, int col3) {
        this.winningPiece = winningPiece;
        this.col1 = col1;
        this.row1 = row1;
        this.col2 = col2;
        this.row2 = row2;
        this.col3 = col3;
        this.row3 = row3;
    }


    // Provide access to winning Piece X or O
    public Piece getWinningPiece() {
        return winningPiece;
    }
}
