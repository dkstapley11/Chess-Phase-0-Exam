package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KingMoveCalculator implements ChessPieceMoveCalculator {
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        Collection<ChessMove> moves = new ArrayList<>();
        ChessGame.TeamColor color = board.getPiece(position).getTeamColor();

        int [][] potentialMoves = {{1,1}, {1,0}, {1,-1}, {0,1}, {0,-1}, {-1,1}, {-1,0}, {-1,-1}};



        return moves;
    }

    public boolean validateMove(ChessBoard board, ChessPosition position, int[] move, ChessGame.TeamColor color) {
        int targetRow = position.getRow() + move[0];
        int targetCol = position.getColumn() + move[1];
        if (outOfBounds(targetRow, targetCol)) {
            return false;
        }
        // if enemy
        if (!squareEmpty(board, position) && board.getPiece(new ChessPosition(targetRow, targetCol)).getTeamColor() != color) {

        }
        return false;
    }

    public boolean outOfBounds(int row, int col) {
        if (row > 8) return true;
        if (col > 8) return true;
        if (row < 1) return true;
        if (col < 1) return true;
        return false;
    }

    public boolean squareEmpty(ChessBoard board, ChessPosition position) {
        return board.getPiece(position) == null;
    }
}
