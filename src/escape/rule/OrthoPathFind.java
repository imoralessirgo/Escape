/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Copyright ©2016 Gary F. Pollice
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
 * @version May 3, 2020
 */
public class OrthoPathFind {
	private static HashMap<Integer, HashSet<Coordinate>> path; // store valid paths
	private static Board board; // current game board
	private static PieceAttribute[] pieceAtt; // pieceAttributes for current piece
	private static int i; // current dsistance from origin
	private static Coordinate dest;
	private static int[] currDir;

	private static final List<int[]> ortho = Arrays.asList(new int[] {
			0, 1 // NORTH
	}, new int[] {
			0, -1 // SOUTH
	}, new int[] {
			1, 0 // EAST
	}, new int[] {
			-1, 0 // WEST
	});

	/**
	 * Description
	 * 
	 * @param from
	 * @param to
	 * @param pt
	 * @param b
	 * @return
	 */
	public static boolean canMove(Coordinate from, Coordinate to,
			PieceTypeInitializer pt, Board b) {
		dest = to;
		path = new HashMap<Integer, HashSet<Coordinate>>();
		HashSet<Coordinate> nodes = new HashSet<Coordinate>();
		nodes.add(from);
		path.put(0, nodes);
		path.put(1, new HashSet<Coordinate>());
		board = b;
		pieceAtt = pt.getAttributes();
		int distance = getMaxTravelDistance();
		for (i = 0; i < distance; i++) {
			nodes = path.get(i);
			path.put(i + 2, new HashSet<Coordinate>());
			if (nodes.isEmpty() && path.get(i + 1).isEmpty()) {
				return false;
			}
			if (nodes.isEmpty()) {
				i++;
				nodes = path.get(i);
				path.put(i + 2, new HashSet<Coordinate>());
			}
			if (nodes.contains(to)) {
				return true;
			}
			HashSet<Coordinate> validCoords = new HashSet<Coordinate>();
			switch (pt.getMovementPattern()) {
					
				case LINEAR: // problematic
					for(int[] dir : ortho) {
						if(checkLinear((OrthoSquareCoordinate) from, dir, distance) == true) {
							return true;
						}
					}
					return false;
					
				case OMNI: case ORTHOGONAL:
					// look at both ortho and diagonal
					validCoords.addAll(orthoPath(path.get(i)));
					if (validCoords.contains(to)) {
						return true;
					} // made it to destination
					validCoords.addAll(path.get(i + 1));
					path.put(i + 1, validCoords);
					break;
					
				default:
					throw new EscapeException(
							"orthoPathFind: Invalid Movement Pattern found");
			}
		}

		return false;

	}

	/**
	 * Description
	 * 
	 * @param coordinates
	 * @return
	 */
	static private HashSet<Coordinate> orthoPath(HashSet<Coordinate> coordinates) {
		HashSet<Coordinate> validCoords = new HashSet<Coordinate>();
		for (Coordinate c : coordinates) {
			OrthoSquareCoordinate sc = (OrthoSquareCoordinate) c;
			for (int[] n : ortho) {
				currDir = n;
				OrthoSquareCoordinate neighbour = OrthoSquareCoordinate
						.makeCoordinate(sc.getX() + n[0], sc.getY() + n[1]);
				if (isValid(neighbour)) {
					validCoords.add(neighbour);
				}
			}
		}
		return validCoords;
	}


	/**
	 * Description
	 * 
	 * @param sc
	 * @return
	 */
	private static boolean isValid(OrthoSquareCoordinate sc) {
		OrthoSquareBoard sb = (OrthoSquareBoard) board;
		if (!sb.inBounds(sc)) {
			return false;
		}
		if (sb.getPieceAt(sc) != null) {
			if (dest.equals(sc)) {
				return true;
			}
			if (canFly()) {
				return true;
			} else if (canJump()) {
				jumpFrom(sc);
				return false;
			} else
				return false;
		}
		if (sb.getLocationType(sc) == LocationType.EXIT) {
			// only valid to fly over or end at an exit
			if (canFly() || dest.equals(sc))
				return true;
			else
				return false;
		}
		if (sb.getLocationType(sc) == LocationType.BLOCK) {
			// trying to move to a blocked position without unblock capabilities
			// is invalid
			if ((canFly() || canUnblock()) && !dest.equals(sc))
				return true;
			else
				return false;
		}
		return true;
	}

	private static boolean canJump() {
		for (PieceAttribute p : pieceAtt) {
			if (p.getId() == PieceAttributeID.JUMP) {
				return p.isBooleanValue();
			}
		}
		return false;
	}

	/**
	 * This function will ad the
	 * 
	 * @param c
	 */
	private static void jumpFrom(Coordinate c) {
		OrthoSquareCoordinate curr = (OrthoSquareCoordinate) c;
		OrthoSquareCoordinate neighbour = OrthoSquareCoordinate
				.makeCoordinate(curr.getX() + currDir[0], curr.getY() + currDir[1]);
		OrthoSquareBoard sb = (OrthoSquareBoard) board;
		HashSet<Coordinate> hs = path.get(i + 2);
		if (!sb.inBounds(neighbour)) {
			return;
		}
		if (sb.getLocationType(curr) == LocationType.EXIT) {
			// only valid to fly over or end at an exit
			if (canFly() || dest.equals(neighbour)) {
				hs.add(neighbour);
				path.put(i + 2, hs);
				return;
			} else
				return;
		} else if (sb.getLocationType(neighbour) == LocationType.BLOCK) {
			// trying to move to a blocked position without unblock capabilities
			// is invalid
			if ((canFly() || canUnblock()) && !dest.equals(neighbour)) {
				hs.add(neighbour);
				path.put(i + 2, hs);
				return;
			} else
				return;
		} else if (sb.getPieceAt(neighbour) != null) {
			if (!neighbour.equals(dest))
				return;
			hs.add(neighbour);
			path.put(i + 2, hs);
			return;
		}
		hs.add(neighbour);
		path.put(i + 2, hs);
		return;
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
			if (p.getId() == PieceAttributeID.FLY
					|| p.getId() == PieceAttributeID.DISTANCE) {
				return p.getIntValue();
			}
		}
		throw new EscapeException("This piece has no distance or fly attribute");
	}

	private static boolean checkLinear(OrthoSquareCoordinate sc, int[] direction,
			int maxDistance) {
		for (int j = 0; j < maxDistance; j++) {
			sc = OrthoSquareCoordinate.makeCoordinate(sc.getX() + direction [0], sc.getY() + direction[1]);
			if(sc.equals(dest)) {return true;}
			if(linearIsValid(sc, direction) != true) {
				break;
			}
		}
		return false;
	}

	private static boolean linearIsValid(OrthoSquareCoordinate sc, int[] dir) {
		OrthoSquareBoard sb = (OrthoSquareBoard) board;
		if (!sb.inBounds(sc)) {
			return false;
		}
		if (sb.getPieceAt(sc) != null) {
			if (canFly()) {
				return true;
			} else if (canJump()) {
				OrthoSquareCoordinate next = OrthoSquareCoordinate.makeCoordinate(sc.getX() + dir [0], sc.getY() + dir[1]);
				return jumpFromLinear(sc, next);
			} else
				return false;
		}
		if (sb.getLocationType(sc) == LocationType.EXIT) {
			// only valid to fly over or end at an exit
			if (canFly() || dest.equals(sc))
				return true;
			else
				return false;
		}
		if (sb.getLocationType(sc) == LocationType.BLOCK) {
			// trying to move to a blocked position without unblock capabilities
			// is invalid
			if ((canFly() || canUnblock()) && !dest.equals(sc))
				return true;
			else
				return false;
		}
		return true;
	}
	
	
	/**
	 * This function will ad the
	 * 
	 * @param c
	 */
	private static boolean jumpFromLinear(OrthoSquareCoordinate curr, OrthoSquareCoordinate neighbour) {
		OrthoSquareBoard sb = (OrthoSquareBoard) board;
		if (!sb.inBounds(neighbour)) {
			return false;
		}
		if (sb.getLocationType(curr) == LocationType.EXIT) {
			// only valid to fly over or end at an exit
			if (canFly() || dest.equals(neighbour)) {
				return true;
			} else
				return false;
		} else if (sb.getLocationType(neighbour) == LocationType.BLOCK) {
			// trying to move to a blocked position without unblock capabilities
			// is invalid
			if ((canFly() || canUnblock()) && !dest.equals(neighbour)) {
				return true;
			} else
				return false;
		} else if (sb.getPieceAt(neighbour) != null) {
			if (!neighbour.equals(dest))
				return false;
			return true;
		}
		return true;
	}
}
