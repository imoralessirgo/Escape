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
		return pieces.get(coord);
	}

	/*
	 * @see escape.board.Board#putPieceAt(escape.piece.EscapePiece,
	 * escape.board.coordinate.Coordinate)
	 */
	@Override
	public void putPieceAt(EscapePiece p, OrthoSquareCoordinate coord) {
		pieces.put(coord, p);
	}

	public void setLocationType(OrthoSquareCoordinate c, LocationType lt) {
		squares.put(c, lt);
	}
}
