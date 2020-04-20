/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package escape.board;

import java.util.*;
import escape.board.coordinate.*;
import escape.exception.EscapeException;
import escape.piece.EscapePiece;

/**
 * Description
 * 
 * @version Apr 19, 2020
 */
public class OrthoSquareBoard implements Board<OrthoSquareCoordinate> {
	Map<OrthoSquareCoordinate, LocationType> squares;
	Map<OrthoSquareCoordinate, EscapePiece> pieces;

	private final int xMax, yMax;

	public OrthoSquareBoard(int xMax, int yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
		pieces = new HashMap<OrthoSquareCoordinate, EscapePiece>();
		squares = new HashMap<OrthoSquareCoordinate, LocationType>();
	}

	/*
	 * @see escape.board.Board#getPieceAt(escape.board.coordinate.Coordinate)
	 */
	@Override
	public EscapePiece getPieceAt(OrthoSquareCoordinate coord) {
		if (inBounds(coord)) {
			EscapePiece p = pieces.get(coord);
			return p;
		} else {
			throw new EscapeException("getPiece: Coordinate out of board bounds");
		}
	}

	/*
	 * @see escape.board.Board#putPieceAt(escape.piece.EscapePiece,
	 * escape.board.coordinate.Coordinate)
	 */
	@Override
	public void putPieceAt(EscapePiece p, OrthoSquareCoordinate coord) {
		if (inBounds(coord)) {
			if(p == null) {
				squares.remove(coord);
				pieces.remove(coord);
			}else if (squares.get(coord) == LocationType.BLOCK) {
				throw new EscapeException("putPiece: Coordinate blocked");
			}else if (squares.get(coord) != LocationType.EXIT) {
				pieces.put(coord, p);
				setLocationType(coord, LocationType.CLEAR);
			}
		} else {
			throw new EscapeException("putPiece: Coordinate out of board bounds");
		}
	}

	/**
	 * maps location type to coordinate
	 * 
	 * @param c
	 *            coordinate
	 * @param lt
	 *            location type
	 */
	public void setLocationType(OrthoSquareCoordinate c, LocationType lt) {
		if (inBounds(c)) {
			squares.put(c, lt);
		} else {
			throw new EscapeException("setType: Coordinate out of board bounds");
		}
	}

	private boolean inBounds(OrthoSquareCoordinate c) {
		return c.getX() <= xMax && c.getY() <= yMax && c.getX() > 0 && c.getY() > 0;
	}
}
