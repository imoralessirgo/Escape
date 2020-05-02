/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package escape.rule;

import java.util.*;
import escape.board.*;
import escape.board.coordinate.*;
import escape.exception.EscapeException;
import escape.piece.PieceAttributeID;
import escape.util.PieceTypeInitializer;
import escape.util.PieceTypeInitializer.PieceAttribute;

/**
 * Description
 * 
 * @version May 2, 2020
 */
public class pathFind {
	private static HashMap<Integer, LinkedList<Coordinate>> path;
	private static final List<int[]> ortho = Arrays.asList(new int[] {
			0, 1
	}, new int[] {
			0, -1
	}, new int[] {
			1, 0
	}, new int[] {
			-1, 0
	});
	private static final List<int[]> diagonal = Arrays.asList(new int[] {
			1, 1
	}, new int[] {
			1, -1
	}, new int[] {
			-1, 1
	}, new int[] {
			-1, -1
	});
	private static Board board;
	private static PieceAttribute[] pieceAtt;

	static boolean canMove(Coordinate from, Coordinate to, PieceTypeInitializer pt,
			Board b) {
		path = new HashMap<Integer, LinkedList<Coordinate>>();
		LinkedList<Coordinate> nodes = new LinkedList<Coordinate>();
		nodes.add(from);
		path.put(0, nodes);
		board = b;
		pieceAtt = pt.getAttributes();
		int distance = from.distanceTo(to);
		for (int i = 0; i <= distance; i++) {
			if (path.get(i) == null) {
				return false;
			}
			switch (pt.getMovementPattern()) {
				case DIAGONAL:
					break;
				case LINEAR: // problematic
					break;
				case OMNI:
					break;
				case ORTHOGONAL:

					break;
				default:
					throw new EscapeException("Invalid Movement Pattern found");
			}

		}

		return false;
	}

	private LinkedList<Coordinate> orthoPath(Coordinate dest,
			Coordinate... coordinates) {
		LinkedList<Coordinate> validCoords = new LinkedList<Coordinate>();
		for (Coordinate c : coordinates) {
			SquareCoordinate sc = (SquareCoordinate) c;
			for (int[] n : ortho) {
				SquareCoordinate neighbour = SquareCoordinate.makeCoordinate(sc.getX() + n[0], sc.getY() + n[1]);
				if(isValid(neighbour)) {
					validCoords.add(neighbour);
				}
			}
		}
		return validCoords;
	}

	private LinkedList<Coordinate> diagonalPath(Coordinate dest,
			Coordinate... coordinates) {
		LinkedList<Coordinate> validCoords = new LinkedList<Coordinate>();
		for (Coordinate c : coordinates) {
			SquareCoordinate sc = (SquareCoordinate) c;
			for (int[] n : diagonal) {
				SquareCoordinate neighbour = SquareCoordinate.makeCoordinate(sc.getX() + n[0], sc.getY() + n[1]);
				if(isValid(neighbour)) {
					validCoords.add(neighbour);
				}
			}
		}
		return validCoords;
	}

	private boolean isValid(SquareCoordinate sc) {
		SquareBoard sb = (SquareBoard) board;
		if(sb.getPieceAt(sc) != null ) {
			if(canJump() || canFly()) {
				
			}
		}
		return true;
	}

	private boolean canJump() {
		for(PieceAttribute p : pieceAtt) {
			if(p.getId() == PieceAttributeID.JUMP) {return true;}
		}
		return false;
	}

	private boolean canFly() {
		for(PieceAttribute p : pieceAtt) {
			if(p.getId() == PieceAttributeID.FLY) {return true;}
		}
		return false;
	}
}
