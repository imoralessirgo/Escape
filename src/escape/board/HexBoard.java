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
 * This board has hexagonal coordinates. This board can be both infinite and finite, xMax
 * and YMax are set to define boundries. For this implementation, the board will be
 * infinite.
 * 
 * @version Apr 18, 2020
 */
public class HexBoard implements Board<HexCoordinate> {
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
		return pieces.get(coord);
	}

	/*
	 * @see escape.board.Board#putPieceAt(escape.piece.EscapePiece,
	 * escape.board.coordinate.Coordinate)
	 */
	@Override
	public void putPieceAt(EscapePiece p, HexCoordinate coord) {
		if (hexagons.get(coord) == LocationType.BLOCK) {
			throw new EscapeException("putPiece: Coordinate blocked");
		} else if (hexagons.get(coord) != LocationType.EXIT) {
			pieces.put(coord, p);
			setLocationType(coord, LocationType.CLEAR);
		}
	}

	public void setLocationType(HexCoordinate c, LocationType lt) {
		hexagons.put(c, lt);
	}

}
