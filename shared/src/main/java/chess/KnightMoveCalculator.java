package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightMoveCalculator implements ChessPieceMoveCalculator {
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        Collection<ChessMove> moves = new ArrayList<>();
        ChessGame.TeamColor color = board.getPiece(position).getTeamColor();
        int row = position.getRow();
        int col = position.getColumn();

        int[][] potentialMoves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {-1, 2}, {-1, -2}, {1, -2}};

        for (int[] move : potentialMoves) {
            int targetRow = row + move[0];
            int targetCol = col + move[1];
            ChessPosition target = new ChessPosition(targetRow, targetCol);
            if (validateMove(board, target, color)) {
                moves.add(new ChessMove(position, target, null));
            }

        }

        return moves;
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

    public boolean validateMove(ChessBoard board, ChessPosition target, ChessGame.TeamColor color) {
        if (outOfBounds(target.getRow(), target.getColumn())) {
            return false;
        }
        if (squareEmpty(board, target)) {
            return true;
        } else { // friendly or enemy piece there
            // if enemy
            return board.getPiece(target).getTeamColor() != color;
        }
    }
}
