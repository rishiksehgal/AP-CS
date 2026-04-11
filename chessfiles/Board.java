import java.awt.*;
import java.util.*;

// Represesents a rectangular game board, containing Piece objects.
public class Board extends BoundedGrid<Piece>
{
	// Constructs a new Board with the given dimensions
	public Board()
	{
		super(8, 8);
	}

	// Precondition:  move has already been made on the board
	// Postcondition: piece has moved back to its source,
	//                and any captured piece is returned to its location
	public void undoMove(Move move)
	{
		Piece piece = move.getPiece();
		Location source = move.getSource();
		Location dest = move.getDestination();
		Piece victim = move.getVictim();

		piece.moveTo(source);
		piece.undoRecordedMove();

		if (move.isCastleMove())
		{
			Piece rook = get(move.getCastleRookDestination());
			rook.moveTo(move.getCastleRookSource());
			rook.undoRecordedMove();
		}

		if (victim != null)
			victim.putSelfInGrid(piece.getBoard(), dest);
	}

	// Returns every legal move for pieces of the given color.
	public ArrayList<Move> allMoves(Color color)
	{
		ArrayList<Move> moves = new ArrayList<Move>();

		for (Location loc : getOccupiedLocations())
		{
			Piece piece = get(loc);
			if (piece.getColor().equals(color))
			{
				for (Location dest : piece.destinations())
				{
					Move move = new Move(piece, dest);
					if (move.getVictim() instanceof King)
						continue;
					executeMove(move);
					if (!inCheck(color))
						moves.add(move);
					undoMove(move);
				}
			}
		}

		return moves;
	}

	// Executes the given move on this board.
	public void executeMove(Move move)
	{
		if (move == null)
			return;

		if (move.isCastleMove())
		{
			Piece rook = get(move.getCastleRookSource());
			rook.moveTo(move.getCastleRookDestination());
			rook.recordMove();
		}

		move.getPiece().moveTo(move.getDestination());
		move.getPiece().recordMove();
	}

	public boolean inCheck(Color color)
	{
		King king = findKing(color);
		return king != null && isUnderAttack(king.getLocation(), oppositeColor(color));
	}

	public boolean isCheckmate(Color color)
	{
		return inCheck(color) && allMoves(color).isEmpty();
	}

	public boolean isStalemate(Color color)
	{
		return !inCheck(color) && allMoves(color).isEmpty();
	}

	public boolean canCastle(King king, boolean kingSide)
	{
		if (king == null || king.hasMoved() || inCheck(king.getColor()))
			return false;

		Location kingLoc = king.getLocation();
		int row = kingLoc.getRow();
		int rookCol = kingSide ? 7 : 0;
		Location rookLoc = new Location(row, rookCol);
		Piece rookPiece = get(rookLoc);

		if (!(rookPiece instanceof Rook) || rookPiece.hasMoved() ||
			!rookPiece.getColor().equals(king.getColor()))
		{
			return false;
		}

		int step = kingSide ? 1 : -1;
		for (int col = kingLoc.getCol() + step; col != rookCol; col += step)
		{
			if (get(new Location(row, col)) != null)
				return false;
		}

		for (int col = kingLoc.getCol() + step; col != kingLoc.getCol() + 3 * step; col += step)
		{
			Location square = new Location(row, col);
			if (isUnderAttack(square, oppositeColor(king.getColor())))
				return false;
		}

		return true;
	}

	public boolean isUnderAttack(Location loc, Color attackingColor)
	{
		for (Location pieceLoc : getOccupiedLocations())
		{
			Piece piece = get(pieceLoc);
			if (piece.getColor().equals(attackingColor) &&
				piece.attackLocations().contains(loc))
			{
				return true;
			}
		}

		return false;
	}

	private King findKing(Color color)
	{
		for (Location loc : getOccupiedLocations())
		{
			Piece piece = get(loc);
			if (piece instanceof King && piece.getColor().equals(color))
				return (King) piece;
		}

		return null;
	}

	private Color oppositeColor(Color color)
	{
		return color.equals(Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
}
