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
public class PathFind {
	private static HashMap<Integer, LinkedList<Coordinate>> path;
	private static final List<int[]> ortho = Arrays.asList(new int[] {
			0, 1 // NORTH
	}, new int[] {
			0, -1 // SOUTH
	}, new int[] {
			1, 0 // EAST
	}, new int[] {
			-1, 0 // WEST
	});
	private static final List<int[]> diagonal = Arrays.asList(new int[] {
			1, 1 // NORTHEAST
	}, new int[] {
			1, -1 // NORTHWEST
	}, new int[] {
			-1, 1 // SOUTHEAST
	}, new int[] {
			-1, -1 // SOUTHWEST
	});
	private static Board board;
	private static PieceAttribute[] pieceAtt;

	public static boolean canMove(Coordinate from, Coordinate to, PieceTypeInitializer pt,
			Board b) {
		path = new HashMap<Integer, LinkedList<Coordinate>>();
		LinkedList<Coordinate> nodes = new LinkedList<Coordinate>();
		nodes.add(from);
		path.put(0, nodes);
		board = b;
		pieceAtt = pt.getAttributes();
		int distance = getMaxTravelDistance();
		for (int i = 0; i < distance; i++) {
			nodes = path.get(i);
			if (nodes == null) {
				return false;
			}
			LinkedList<Coordinate> validCoords = new LinkedList<Coordinate>();
			switch (pt.getMovementPattern()) {
				case DIAGONAL:					
				validCoords.addAll(diagonalPath(path.get(i)));
				if (validCoords.contains(to)) {
					return true;
				} // made it to destination
				path.put(i + 1, validCoords);
				break;
				case LINEAR: // problematic
					break;
				case OMNI:
					break;
				case ORTHOGONAL:
					validCoords.addAll(orthoPath(path.get(i)));
					if (validCoords.contains(to)) {
						return true;
					} // made it to destination
					path.put(i + 1, validCoords);
					break;
				default:
					throw new EscapeException("Invalid Movement Pattern found");
			}
		}

		return false;
	}

	static private LinkedList<Coordinate> orthoPath(LinkedList<Coordinate> coordinates) {
		LinkedList<Coordinate> validCoords = new LinkedList<Coordinate>();
		for (Coordinate c : coordinates) {
			SquareCoordinate sc = (SquareCoordinate) c;
			for (int[] n : ortho) {
				SquareCoordinate neighbour = SquareCoordinate
						.makeCoordinate(sc.getX() + n[0], sc.getY() + n[1]);
				if (isValid(neighbour)) {
					validCoords.add(neighbour);
				}
			}
		}
		return validCoords;
	}

	static private LinkedList<Coordinate> diagonalPath(LinkedList<Coordinate> coordinates) {
		LinkedList<Coordinate> validCoords = new LinkedList<Coordinate>();
		for (Coordinate c : coordinates) {
			SquareCoordinate sc = (SquareCoordinate) c;
			for (int[] n : diagonal) {
				SquareCoordinate neighbour = SquareCoordinate
						.makeCoordinate(sc.getX() + n[0], sc.getY() + n[1]);
				if (isValid(neighbour)) {
					validCoords.add(neighbour);
				}
			}
		}
		return validCoords;
	}

	private static boolean isValid(SquareCoordinate sc) {
		SquareBoard sb = (SquareBoard) board;
		if(!sb.inBounds(sc)) {
			return false;
		}
		if (sb.getPieceAt(sc) != null
				|| sb.getLocationType(sc) == LocationType.BLOCK) {
			if (canJump() || canFly()) {
				return true;
			}
		}
		if (sb.getLocationType(sc) == LocationType.EXIT) {
			// trying to move over an exit is invalid
			return false;
		} 
		if (sb.getLocationType(sc) == LocationType.BLOCK && !canUnblock()) {
			// trying to move to a blocked position without unblock capabilities
			// is invalid
			return false;
		}
		return true;
	}

	private static boolean canJump() {
		for (PieceAttribute p : pieceAtt) {
			if (p.getId() == PieceAttributeID.JUMP) {
				return true;
			}
		}
		return false;
	}

	private static boolean canFly() {
		for (PieceAttribute p : pieceAtt) {
			if (p.getId() == PieceAttributeID.FLY) {
				return true;
			}
		}
		return false;
	}

	private static boolean canUnblock() {
		for (PieceAttribute p : pieceAtt) {
			if (p.getId() == PieceAttributeID.UNBLOCK && p.isBooleanValue()) {
				return true;
			}
		}
		return false;
	}
	
	private static int getMaxTravelDistance() {
		for (PieceAttribute p : pieceAtt) {
			if (p.getId() == PieceAttributeID.FLY || p.getId() == PieceAttributeID.DISTANCE) {
				return p.getIntValue();
			}
		}
		throw new EscapeException("This piece has no distance or fly attribute");
	}
}
