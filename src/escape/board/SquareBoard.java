/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ Copyright ©2016-2020 Gary F. Pollice
 *******************************************************************************/
package escape.board;

import java.util.*;
import escape.board.coordinate.SquareCoordinate;
import escape.exception.EscapeException;
import escape.piece.EscapePiece;

/**
 * This board has square coordinates and finite bounds, represented by xMax and yMax. All
 * methods required by the Board interface have been implemented.
 * 
 * @version Apr 2, 2020
 */
public class SquareBoard implements Board<SquareCoordinate> {
	Map<SquareCoordinate, LocationType> squares;
	Map<SquareCoordinate, EscapePiece> pieces;

	private final int xMax, yMax;

	public SquareBoard(int xMax, int yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
		pieces = new HashMap<SquareCoordinate, EscapePiece>();
		squares = new HashMap<SquareCoordinate, LocationType>();
	}

	/*
	 * @see escape.board.Board#getPieceAt(escape.board.coordinate.Coordinate)
	 */
	@Override
	public EscapePiece getPieceAt(SquareCoordinate coord) throws EscapeException {
		if (inBounds(coord)) {
			return pieces.get(coord);
		} else {
			throw new EscapeException("getPiece: Coordinate out of board bounds");
		}
	}

	/*
	 * @see escape.board.Board#putPieceAt(escape.piece.EscapePiece,
	 * escape.board.coordinate.Coordinate)
	 */
	@Override
	public void putPieceAt(EscapePiece p, SquareCoordinate coord)
			throws EscapeException {
		if (inBounds(coord)) {
			if (squares.get(coord) == LocationType.BLOCK) {
				throw new EscapeException("putPiece: Coordinate blocked");
			} else if (squares.get(coord) != LocationType.EXIT) {
				pieces.put(coord, p);
				setLocationType(coord, LocationType.CLEAR);
			}
		} else {
			throw new EscapeException("putPiece: Coordinate out of board bounds");
		}
	}

	public void setLocationType(SquareCoordinate c, LocationType lt) {
		if (inBounds(c)) {
			squares.put(c, lt);
		} else {
			throw new EscapeException("setType: Coordinate out of board bounds");
		}
	}

	private boolean inBounds(SquareCoordinate c) {
		return c.getX() <= xMax && c.getY() <= yMax && c.getX() > 0 && c.getY() > 0;
	}
}
