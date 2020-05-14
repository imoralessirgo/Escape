/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package escape;

import java.util.*;
import escape.board.coordinate.*;
import escape.exception.EscapeException;
import escape.piece.*;
import escape.util.PieceTypeInitializer;
import escape.util.PieceTypeInitializer.PieceAttribute;
import escape.rule.*;

/**
 * Description
 * 
 * @version May 12, 2020
 */
public abstract class GameController<C extends Coordinate> {
	
	protected HashMap<PieceName, PieceTypeInitializer> pieceAttributes;
	protected HashMap<RuleID, Integer> gameRules = new HashMap<RuleID, Integer>();
	protected LinkedList<GameObserver> obs = new LinkedList<GameObserver>();
	protected int currentTurn = 0; 
	protected HashMap<Player, Integer> scoreboard = new HashMap<Player, Integer>(){{
		put(Player.PLAYER1, 0);
		put(Player.PLAYER2, 0);
	}}; // scoreboard starts at 0
	protected Player currentPlayer = Player.PLAYER1; // first move always player 1
	protected boolean gameEnded = false;

	
	/**
	 * build and set piece attribute hashmap
	 * 
	 * @param pt
	 */
	protected void setPieceAttributes(PieceTypeInitializer[] pt) {
		if (pt != null) {
			this.pieceAttributes = new HashMap<PieceName, PieceTypeInitializer>();
			for (PieceTypeInitializer p : pt) {
				if (!Arrays.asList(PieceName.values()).contains(p.getPieceName()))
					throw new EscapeException("GameController: invalid pieceName");
				else
					pieceAttributes.put(p.getPieceName(), p);
			}
		} else {
			throw new EscapeException(
					"GameController: No piece attributes provided");
		}
	}

	/**
	 * build and set game rules hashmap
	 * 
	 * @param rules
	 */
	protected void setGameRules(Rule[] rules) {
		if (rules != null) {
			for (Rule r : rules) {
				if (!Arrays.asList(RuleID.values()).contains(r.getId()))
					throw new EscapeException("GameController: invalid ruleID");
				else
					gameRules.put(r.getId(), r.getIntValue());
			}
			if (hasRule(RuleID.REMOVE) && hasRule(RuleID.POINT_CONFLICT)) {
				throw new EscapeException(
						"game Controller: Remove and Point Conflict are mutually exclusive");
			}
		} else {
			return;
		}
	}

	/**new EscapePiece(li.player, li.pieceName)
	 * build and set game rules hashmap
	 * 
	 * @param rules
	 */
	protected void notifyObservers(String msg) {
		if (obs.isEmpty()) {
			return;
		}
		for (GameObserver go : obs) {
			go.notify(msg);
		}
	}

	protected EscapePiece pointConflict(EscapePiece ep1, EscapePiece ep2) {
		if(ep1.getValue() > ep2.getValue()) {
			ep1.setValue(ep1.getValue() - ep2.getValue());
			return ep1;
		}else if(ep1.getValue() < ep2.getValue()) {
			ep2.setValue(ep1.getValue() - ep2.getValue());
			return ep2;
		}else {
			return null;
		}
	} 
	
	protected boolean checkGameStatus() {
		if(!hasRule(RuleID.SCORE) && !hasRule(RuleID.TURN_LIMIT)) {
			return false;
		}
		
		if(hasRule(RuleID.SCORE)) {
			int maxScore = gameRules.get(RuleID.SCORE);
			if(scoreboard.get(Player.PLAYER1) >= maxScore)
				notifyObservers("Game Over: Player 1 wins!");
			if(scoreboard.get(Player.PLAYER2) >= maxScore)
				notifyObservers("Game Over: Player 2 wins!");
			return false;
		}
		
		if(hasRule(RuleID.TURN_LIMIT)) {
			if(currentTurn == gameRules.get(RuleID.TURN_LIMIT)) {
				if(scoreboard.get(Player.PLAYER1) > scoreboard.get(Player.PLAYER2)) 
					notifyObservers("Game Over: Player 1 wins!");
				else if(scoreboard.get(Player.PLAYER1) < scoreboard.get(Player.PLAYER2))
					notifyObservers("Game Over: Player 2 wins!");
				else 
					notifyObservers("Game Over: It's a tie!");
			}
			return false;
		}
		return true;
	}
	
	protected void nextMove() {
		if(currentPlayer == Player.PLAYER1) {
			currentPlayer = Player.PLAYER2;
		}else {
			currentPlayer = Player.PLAYER1;
			currentTurn++;
		}
		checkGameStatus();
	}
	protected boolean hasRule(RuleID id) {
		if (!gameRules.isEmpty() && gameRules.get(id) != null)
			return true;
		return false;
	}
	
	protected int getValue(PieceName pn) {
		for(PieceAttribute pa : pieceAttributes.get(pn).getAttributes()) {
			if(pa.getId() == PieceAttributeID.VALUE) 
				return pa.getIntValue();
		}
		return 1;
	}

}
