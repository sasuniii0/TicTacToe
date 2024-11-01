package lk.ijse.gdse71.tiktaktoeoopfinalproject.state;

// common structure for represent normal player in tac-tac-toe
// Abstract nisa kelinma PlayerClass eken instance hadanna ba.. e nisa Aiplayer and Human Player hadanwa Player class eken extend krla
public abstract class Player {

    protected  BoardImpl board;
    // Protected walin player kyna class eke subclasses walata board eka direct access krnn puluwan

    public Player(BoardImpl board) {
        this.board = board;
    }
    // ekama board ekaka play krnn puluwn okkoma playerslata

    public abstract void move(int row, int col); // subclasses wala behaviours define krnwa
}
