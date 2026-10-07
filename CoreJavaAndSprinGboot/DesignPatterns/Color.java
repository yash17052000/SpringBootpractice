import java.util.ArrayList;
import java.util.List;

public enum Color {
    White, Black;
}

class Position {
    int row;
    int col;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    boolean isValid() {
        return row >= 0 && col >= 0 && row < 8 && col < 8;
    }
}

abstract class Piece {
    Color color;
    Position position;
    boolean hasMoved;

    public Color getColor() {
        return color;
    }
    public void setMove(Position pos){
        this.position=pos;

    }
    public void setHasMoved( boolean hasMoved ){
        this.hasMoved=hasMoved;

    }

    public abstract List<Position> getValidMoves(Board board);

    public abstract char getSymbol();

    public boolean canMove(Position position, Board board) {
        if (!position.isValid())
            return false;
        Piece target = board.getPiece(position);
        return target == null || target.getColor() != this.color;
    }

}

class King extends Piece {
    Color color;

    public King(Color black, Position position) {
        //TODO Auto-generated constructor stub
    }

    public char getSymbol() {
        return color == color.White ? 'K' : 'k';
    }

    public List<Position> getValidMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
        for (int i = 0; i < 8; i++) {
            Position position = new Position(position.row + dr[i], position.col + dc[i]);
            if (canMove(position, board)) {
                moves.add(position);
            }
        }
        if (!hasMoved) {
            // castalling
        }
        return moves;
    }

}
class Queen extends Piece{
    public List<Position> getValidMoves(Board board){
       List<Position> moves = new ArrayList<>();
       
       addStraightMoves(moves,board);
       addDiagonalMoves(moves,board);
       return moves;
    }
}

class Rook extends Piece{
    public Rook(Color Black, Position position) {
        //TODO Auto-generated constructor stub
        
    }
    public List<Position> getValidMoves(Board board){
       List<Position> moves = new ArrayList<>();
       
       addStraightMoves(moves,board);
       
       return moves;
    }
    private void addStraightMoves(List<Position> moves, Board board) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            addMovesInDirection(moves, board, dir[0], dir[1]);
        }
    }
}
class Knight extends Piece{
    public Knight(Color black, Position position) {
        //TODO Auto-generated constructor stub
    }

    public List<Position> getValidMoves(Board board){
         List<Position> moves = new ArrayList<>();
     int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};

        for(int i=0;i<8;i++){
            Position p= new Position(position.row+dr[i], position.col+dc[i]);
            if(canMove(p, board)){
                moves.add(p);
            }
        }
        return moves;
    }
}
class Pawn extends Piece{
    public Pawn(Color black, Position position) {
        //TODO Auto-generated constructor stub
    }

    public List<Position> getValidMoves(Board board){
     List<Position> moves= new ArrayList<>();
     int direction=Color.White==color?-1:1;

     int startrow=Color.White==color?6:1;
     Position onestep= new Position(position.row+direction, position.col);
     if(onestep.isValid()&&board.getPiece(onestep)==null){
        moves.add(onestep);
     }
     Position twostep =
    new Position(position.row + 2 * direction, position.col);
     if(twostep.isValid()&&board.getPiece(twostep)==null){
        moves.add(twostep);
     }
     int row=position.row;
     int col=position.col;
      Position left = new Position(row + direction, col - 1);

        if (left.isValid()) {
            Piece target = board.getPiece(left);

            if (target != null && target.getColor() != color) {
                moves.add(left);
            }
        }

        // Diagonal right
        Position right = new Position(row + direction, col + 1);

        if (right.isValid()) {
            Piece target = board.getPiece(right);

            if (target != null && target.getColor() != color) {
                moves.add(right);
            }
        }

        return moves;
    
    }
}


class Board{
    Piece grid[][];
    Board(){
        grid= new Piece[8][8];
        intializeBoard();
    }
    public Piece getPiece(Position pos) {
        return grid[pos.row][pos.col];
    }

    public void intializeBoard(){
        grid[0][0] = new Rook(Color.Black, new Position(0, 0));
        grid[0][1] = new Knight(Color.Black, new Position(0, 1));
        grid[0][4] = new King(Color.Black, new Position(0, 4));
        
        grid[7][0] = new Rook(Color.White, new Position(7, 0));
        grid[7][4] = new King(Color.White, new Position(7, 4));
        
        for (int i = 0; i < 8; i++) {
            grid[1][i] = new Pawn(Color.Black, new Position(1, i));
            grid[6][i] = new Pawn(Color.White, new Position(6, i));
        }
    }
    public boolean movePiece(Position from,Position to ){
        Piece piece= getPiece(from);
        if(piece==null) return false;

        List<Position> validmoves=piece.getValidMoves(this);
         if (!validmoves.contains(to)) return false;
         grid[to.row][to.col]=piece;
         grid[from.row][from.col]=null;
         piece.setMove(to);
        piece.setHasMoved(true);
        
        return true;
    }
    public boolean isInCheck(Color color) {
        Position kingPos = findKing(color);
        Color opponent = (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
        
        for (Piece piece : getAllPieces(opponent)) {
            if (piece.getValidMoves(this).contains(kingPos)) {
                return true;
            }
        }
        return false;
    }
}
class ChessGame {
 private Board board;
    private Color currentTurn;
    private GameStatus status;
    private List<Move> moveHistory;
    
    public ChessGame() {
        board = new Board();
        currentTurn = Color.WHITE;
        status = GameStatus.IN_PROGRESS;
        moveHistory = new ArrayList<>();
    }
    public boolean makeMove(Position from, Position to) {
        Piece piece = board.getPiece(from);
        if (piece == null || piece.getColor() != currentTurn) {
            return false;
        }
        
        if (board.movePiece(from, to)) {
            moveHistory.add(new Move(from, to, piece));
            
            Color opponent = (currentTurn == Color.WHITE) ? Color.BLACK : Color.WHITE;
            if (isCheckmate(opponent)) {
                status = (currentTurn == Color.WHITE) ? GameStatus.WHITE_WINS : GameStatus.BLACK_WINS;
            } else if (isStalemate(opponent)) {
                status = GameStatus.DRAW;
            }
            
            currentTurn = opponent;
            return true;
        }
        return false;
    }
    
    private boolean isCheckmate(Color color) {
        if (!board.isInCheck(color)) return false;
        return !hasAnyValidMove(color);
    }
}