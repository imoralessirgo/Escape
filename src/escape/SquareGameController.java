/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package escape;

import static escape.board.LocationType.CLEAR;
import escape.board.SquareBoard;
import escape.board.coordinate.*;
import escape.piece.EscapePiece;
import escape.util.*;

/**
 * Description
 * 
 * @version Apr 29, 2020
 */
public class SquareGameController implements EscapeGameManager<SquareCoordinate> {

	private SquareBoard board;
	PieceTypeInitializer[] pt;

	/**
	 * Constructor
	 * 
	 * @param board
	 * @param initializers
	 */
	SquareGameController(SquareBoard board, PieceTypeInitializer[] pt,
			LocationInitializer... initializers) {
		this.board = board;
		this.pt = pt;
		if (initializers == null) {
			return;
		}
		for (LocationInitializer li : initializers) {
			SquareCoordinate c = makeCoordinate(li.x, li.y);
			if (li.pieceName != null) {
				board.putPieceAt(new EscapePiece(li.player, li.pieceName), c);
			}
			if (li.locationType != null && li.locationType != CLEAR) {
				board.setLocationType(c, li.locationType);
			}
		}
	}

	/*
	 * @see escape.EscapeGameManager#move(escape.board.coordinate.Coordinate,
	 * escape.board.coordinate.Coordinate)
	 */
	@Override
	public boolean move(SquareCoordinate from, SquareCoordinate to) {
		int distance = from.distanceTo(to);
		EscapePiece p = board.getPieceAt(from);
		
		return false;
	}

	/*
	 * @see escape.EscapeGameManager#getPieceAt(escape.board.coordinate.Coordinate)
	 */
	@Override
	public EscapePiece getPieceAt(SquareCoordinate coordinate) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see escape.EscapeGameManager#makeCoordinate(int, int)
	 */
	@Override
	public SquareCoordinate makeCoordinate(int x, int y) {
		return SquareCoordinate.makeCoordinate(x, y);
	}

}