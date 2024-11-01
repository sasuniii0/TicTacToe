package lk.ijse.gdse71.tiktaktoeoopfinalproject.state;

public class AiPlayer extends Player {

    public AiPlayer(BoardImpl board) {
        super(board);
    }
    // AiPlayer extend wela tiyna superclass eka mkkd balala eka load krnwa

    // move eka valid d nadda balala eka update krnwa
    @Override
    public void move(int row, int col) {
        int[] spot = board.nextAvailableSpot();
        if(board.isLegalMove(row, col) && spot != null) {
            board.updateMove(row,col,Piece.O);
        }
    }

    // Ai player walata best move eka thoragnnwa adu kalayakadi win krnna puluwn widihta
    public void findBestMove() {
        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;
        Piece[][] pieces = board.getPieces();

        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == Piece.EMPTY){
                    pieces [i][j] =Piece.O;
                    int moveValue = minimax(pieces,0,false);
                    pieces[i][j] = Piece.EMPTY;

                    if (moveValue > bestScore){
                        bestRow = i;
                        bestCol = j;
                        bestScore = moveValue;
                    }
                }
            }
        }
        if (bestRow != -1 && bestCol != -1){
            move(bestRow,bestCol);
        }
    }

    // move wala result eka minimax algo eka use krla recuresive widihta check krnwa
    private int minimax(Piece[][] pieces, int dep, boolean isMaximizing) {
        Winner winner = board.checkWinner();
        if(winner != null) {
            if (winner.getWinningPiece() == Piece.O){
                return  10 - dep;
            } else if (winner.getWinningPiece() == Piece.X) {
                return dep - 10;
            }
        }
        if (board.isBoardFull()){
            return 0;
        }
        if (isMaximizing){
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i< pieces.length;i++){
                for (int j = 0; j<pieces[i].length;j++){
                    if (pieces[i][j] == Piece.EMPTY){
                        pieces [i][j] =Piece.O;
                        bestScore = Math.max(bestScore,minimax(pieces,dep + 1,false));
                        pieces [i][j] =Piece.EMPTY;
                    }
                }
            }
            return bestScore;
        }else{
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i< pieces.length;i++){
                for (int j = 0; j<pieces[i].length;j++){
                    if (pieces[i][j] == Piece.EMPTY){
                        pieces [i][j] =Piece.X;
                        bestScore = Math.min(bestScore,minimax(pieces,dep + 1,true));
                        pieces [i][j] =Piece.EMPTY;
                    }
                }
            }
            return bestScore;
        }
    }
}
