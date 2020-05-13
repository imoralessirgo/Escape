/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package escape;

import java.util.*;
import escape.board.*;
import escape.board.coordinate.*;
import escape.exception.EscapeException;
import escape.pathfind.*;
import escape.piece.*;
import escape.rule.*;
import escape.util.*;

/**
 * Description
 * 
 * @version Apr 29, 2020
 */
public class SquareGameController extends GameController
		implements EscapeGameManager<SquareCoordinate> {

	private SquareBoard board;

	/**
	 * Constructor
	 * 
	 * @param board
	 * @param initializers
	 */
	SquareGameController(SquareBoard board, PieceTypeInitializer[] pt, Rule[] rules,
			LocationInitializer... initializers) {
		this.board = board;
		this.setPieceAttributes(pt);
		this.setGameRules(rules);
		this.obs = new LinkedList<GameObserver>();
		if (initializers == null) {
			return;
		}
		for (LocationInitializer li : initializers) {
			SquareCoordinate c = makeCoordinate(li.x, li.y);
			if (li.pieceName != null) {
				EscapePiece ep = new EscapePiece(li.player, li.pieceName);
				board.putPieceAt(ep, c);
				ep.setValue(this.getValue(ep.getName()));
			}
			if (li.locationType != null && li.locationType != LocationType.CLEAR) {
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
			this.notifyObservers("Piece can not move to itself");
			return false;
		}
		EscapePiece p = getPieceAt(from);
		if (p == null) { // no piece at from
			this.notifyObservers("No piece at from location");
			return false;
		}
		if (board.getLocationType(to) == LocationType.BLOCK) {
			this.notifyObservers("Destination is blocked");
			return false;
		}
		PieceTypeInitializer pt = (PieceTypeInitializer) this.pieceAttributes
				.get(p.getName());
		try {
			if (SquarePathFind.canMove(from, to, pt, board)) {
				// capture and exit check
				if (board.getLocationType(to) == LocationType.EXIT) {
					int score = (int) this.scoreboard.get(currentPlayer) + p.getValue();
					this.scoreboard.put(currentPlayer, score);
					board.removePieceAt(from);
					return true;
				} else if (board.getPieceAt(to) == null
						|| (this.hasRule(RuleID.REMOVE)
								&& board.getPieceAt(to).getPlayer() != board
										.getPieceAt(from).getPlayer())) {
					board.removePieceAt(from);
					board.putPieceAt(p, to);
					return true;
				}else if(this.hasRule(RuleID.POINT_CONFLICT)
						&& board.getPieceAt(to).getPlayer() != board
						.getPieceAt(from).getPlayer()) {
					EscapePiece winner = this.pointConflict(board.getPieceAt(to), getPieceAt(from));
					board.removePieceAt(from);
					if(winner == null) {	board.removePieceAt(to); return true; }
					board.putPieceAt(winner, to);
					return true;
				}
			}
		} catch (EscapeException e) {
			this.notifyObservers(e.getMessage());
			return false;
		}
		this.notifyObservers("Invalid move, try again");
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

	/*
	 * @see escape.EscapeGameManager#addObserver(escape.GameObserver)
	 */
	@Override
	public GameObserver addObserver(GameObserver observer) {
		this.obs.add(observer);
		return observer;
	}

	/*
	 * @see escape.EscapeGameManager#removeObserver(escape.GameObserver)
	 */
	@Override
	public GameObserver removeObserver(GameObserver observer) {
		this.obs.remove(observer);
		return observer;
	}

}
