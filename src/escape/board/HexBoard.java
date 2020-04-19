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
 * @version Apr 18, 2020
 */
public class HexBoard implements Board {
	Map<HexCoordinate, LocationType> hexagons;
	Map<HexCoordinate, EscapePiece> pieces;

	private final int xMax, yMax;

	public HexBoard(int xMax, int yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
		pieces = new HashMap<HexCoordinate, EscapePiece>();
		hexagons = new HashMap<HexCoordinate, LocationType>();
	}

	/*
	 * @see escape.board.Board#getPieceAt(escape.board.coordinate.Coordinate)
	 */
	@Override
	public EscapePiece getPieceAt(HexCoordinate coord) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see escape.board.Board#putPieceAt(escape.piece.EscapePiece,
	 * escape.board.coordinate.Coordinate)
	 */
	@Override
	public void putPieceAt(EscapePiece p, HexCoordinate coord) {
		// TODO Auto-generated method stub

	}

	public void setLocationType(SquareCoordinate c, LocationType lt) {
		squares.put(c, lt);
	}

	/*
	 * @see escape.board.Board#getPieceAt(escape.board.coordinate.Coordinate)
	 */
	@Override
	public EscapePiece getPieceAt(Coordinate coord) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see escape.board.Board#putPieceAt(escape.piece.EscapePiece,
	 * escape.board.coordinate.Coordinate)
	 */
	@Override
	public void putPieceAt(EscapePiece p, Coordinate coord) {
		// TODO Auto-generated method stub

	}
}
