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
 * PathFinding helper for HexBoards
 * 
 * @version May 3, 2020
 */
public class HexPathFind {
	private static HashMap<Integer, HashSet<Coordinate>> path; // store valid paths
	private static Board board; // current game board
	private static PieceAttribute[] pieceAtt; // pieceAttributes for current piece
	private static int i; // current dsistance from origin
	private static Coordinate dest;
	private static int[] currDir;

	// movement directions for hex boards
	private static final List<int[]> hex = Arrays.asList(new int[] {
			0, 1 // NORTH
	}, new int[] {
			0, -1 // SOUTH
	}, new int[] {
			1, 0 // NEAST
	}, new int[] {
			1, -1 // SEAST
	}, new int[] {
			-1, 1 // NWESt
	}, new int[] {
			-1, 0 // SWEST
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
		// initialize all required values
		dest = to;
		path = new HashMap<Integer, HashSet<Coordinate>>();
		HashSet<Coordinate> nodes = new HashSet<Coordinate>();
		nodes.add(from);
		path.put(0, nodes);
		path.put(1, new HashSet<Coordinate>());
		board = b;
		pieceAtt = pt.getAttributes();
		int distance = getMaxTravelDistance();
		
		
		// search for path
		for (i = 0; i < distance; i++) {
			nodes = path.get(i);
			path.put(i + 2, new HashSet<Coordinate>());
			if (nodes.isEmpty() && path.get(i + 1).isEmpty()) {
				// if no valid neighbours found exit early
				return false;
			}
			if (nodes.isEmpty()) {
				// skip to next level
				i++;
				nodes = path.get(i);
				path.put(i + 2, new HashSet<Coordinate>());
			}
			if (nodes.contains(to)) {
				return true;
			}
			HashSet<Coordinate> validCoords = new HashSet<Coordinate>();
			switch (pt.getMovementPattern()) {

				case LINEAR: 
					// search linear in all directions
					for (int[] dir : hex) {
						if (checkLinear((HexCoordinate) from, dir,
								distance) == true) {
							return true;
						}
					}
					return false;

				case OMNI:
					// look at all neighbours
					validCoords.addAll(hexPath(path.get(i)));
					if (validCoords.contains(to)) {
						return true;
					} // made it to destination
					validCoords.addAll(path.get(i + 1));
					path.put(i + 1, validCoords);
					break;

				default:
					throw new EscapeException(
							"hexPathFind: Invalid Movement Pattern found");
			}
		}
		// destination node was not found within pieces travel distance
		return false;
	}

	/**
	 * Checks hexagonal neighbours of the given coordinates
	 * 
	 * @param coordinates
	 * @return set of valid neighbours
	 */
	static private HashSet<Coordinate> hexPath(HashSet<Coordinate> coordinates) {
		HashSet<Coordinate> validCoords = new HashSet<Coordinate>();
		for (Coordinate c : coordinates) {
			HexCoordinate sc = (HexCoordinate) c;
			for (int[] n : hex) {
				currDir = n;
				HexCoordinate neighbour = HexCoordinate
						.makeCoordinate(sc.getX() + n[0], sc.getY() + n[1]);
				if (isValid(neighbour)) {
					validCoords.add(neighbour);
				}
			}
		}
		return validCoords;
	}

	/**
	 * checks if given coordinate is a valid movement based on the current piece's
	 * specific attributes
	 * 
	 * @param sc
	 * @return boolean
	 */
	private static boolean isValid(HexCoordinate sc) {
		HexBoard sb = (HexBoard) board;
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

	/**
	 * This function will add the valid landing position
	 * if any ehwn jumping from the given coordinate
	 * 
	 * @param c coordinate to be jumped over
	 */
	private static void jumpFrom(Coordinate c) {
		HexCoordinate curr = (HexCoordinate) c;
		HexCoordinate neighbour = HexCoordinate
				.makeCoordinate(curr.getX() + currDir[0], curr.getY() + currDir[1]);
		HexBoard sb = (HexBoard) board;
		HashSet<Coordinate> hs = path.get(i + 2);
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
			if (!neighbour.equals(dest))  // jump onto a piece
				return;
			hs.add(neighbour); // capture 
			path.put(i + 2, hs);
			return;
		}
		hs.add(neighbour); // empty coord
		path.put(i + 2, hs);
		return;
	}

	/**
	 * linear path find
	 *
	 * Description
	 * @param sc
	 * @param direction
	 * @param maxDistance
	 * @return boolean for path found
	 */
	private static boolean checkLinear(HexCoordinate sc, int[] direction,
			int maxDistance) {
		for (int j = 0; j < maxDistance; j++) {
			sc = HexCoordinate.makeCoordinate(sc.getX() + direction[0],
					sc.getY() + direction[1]);
			if (sc.equals(dest)) {
				return true;
			}
			if (linearIsValid(sc, direction) != true) {
				break;
			}
		}
		return false;
	}

	/**
	 * Linear version of is valid function
	 * 
	 * Description
	 * @param sc
	 * @param dir
	 * @return
	 */
	private static boolean linearIsValid(HexCoordinate sc, int[] dir) {
		HexBoard sb = (HexBoard) board;
		if (sb.getPieceAt(sc) != null) {
			if (canFly()) {
				return true;
			} else if (canJump()) {
				HexCoordinate next = HexCoordinate.makeCoordinate(sc.getX() + dir[0],
						sc.getY() + dir[1]);
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
	 * linear version of jumpFrom
	 * 
	 * @param c
	 */
	private static boolean jumpFromLinear(HexCoordinate curr,
			HexCoordinate neighbour) {
		HexBoard sb = (HexBoard) board;
		if (sb.getLocationType(curr) == LocationType.EXIT) {
			// only valid to fly over or end at an exit
			if (canFly() || dest.equals(neighbour)) {
				return true;
			} else
				return false;
		} else if (sb.getLocationType(neighbour) == LocationType.BLOCK) {
			// trying to move to a blockeOrthoSquareCoordinated position without unblock
			// capabilities
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

	/**
	 * PRIVATE STATIC HELPER METHODS
	 **/

	private static boolean canJump() {
		for (PieceAttribute p : pieceAtt) {
			if (p.getId() == PieceAttributeID.JUMP) {
				return p.isBooleanValue();
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
			if (p.getId() == PieceAttributeID.FLY
					|| p.getId() == PieceAttributeID.DISTANCE) {
				return p.getIntValue();
			}
		}
		throw new EscapeException("This piece has no distance or fly attribute");
	}

}
