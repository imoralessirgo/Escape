/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package escape;

import static escape.board.LocationType.CLEAR;
import java.util.HashMap;
import escape.board.*;
import escape.board.coordinate.*;
import escape.exception.EscapeException;
import escape.piece.*;
import escape.rule.SquarePathFind;
import escape.util.*;

/**
 * Description
 * 
 * @version Apr 29, 2020
 */
public class SquareGameController implements EscapeGameManager<SquareCoordinate> {

	private SquareBoard board;
	HashMap<PieceName, PieceTypeInitializer> pieceAttributes;

	/**
	 * Constructor
	 * 
	 * @param board
	 * @param initializers
	 */
	SquareGameController(SquareBoard board, PieceTypeInitializer[] pt,
			LocationInitializer... initializers) {
		this.board = board;
		if (pt != null) {
			this.pieceAttributes = new HashMap<PieceName, PieceTypeInitializer>();
			for (PieceTypeInitializer p : pt) {
				pieceAttributes.put(p.getPieceName(), p);
			}
		}else {
			throw new EscapeException("GameController: No piece attributes provided");
		}
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
		if (distance == 0) {
			return false;
		}
		EscapePiece p = getPieceAt(from);
		if (p == null) { // no piece at from
			return false;
		}
		if(board.getLocationType(to) == LocationType.BLOCK) {return false;}
		if (SquarePathFind.canMove(from, to, pieceAttributes.get(p.getName()), board)) {
			// capture and exit check
			if(board.getLocationType(to) == LocationType.EXIT) {
				board.removePieceAt(from);
				return true;
			}else if (board.getPieceAt(to) == null || (board.getPieceAt(to)
					.getPlayer() != board.getPieceAt(from).getPlayer())) {
				board.removePieceAt(from);
				board.putPieceAt(p, to);
				return true;
			}
		}
		return false;
	}

	/*
	 * @see escape.EscapeGameManager#getPieceAt(escape.board.coordinate.Coordinate)
	 */
	@Override
	public EscapePiece getPieceAt(SquareCoordinate coordinate) {
		return board.getPieceAt(coordinate);
	}

	/*
	 * @see escape.EscapeGameManager#makeCoordinate(int, int)
	 */
	@Override
	public SquareCoordinate makeCoordinate(int x, int y) {
		return SquareCoordinate.makeCoordinate(x, y);
	}

}
