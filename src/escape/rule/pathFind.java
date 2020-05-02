/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package escape.rule;

import java.util.*;
import escape.board.Board;
import escape.board.coordinate.Coordinate;
import escape.util.PieceTypeInitializer;

/**
 * Description
 * 
 * @version May 2, 2020
 */
public class pathFind {
	private static HashMap<Integer, LinkedList<Coordinate>> path;

	static boolean canMove(Coordinate from, Coordinate to, PieceTypeInitializer pt,
			Board b) {
		path = new HashMap<Integer, LinkedList<Coordinate>>();
		LinkedList<Coordinate> nodes = new LinkedList<Coordinate>();
		nodes.add(from);
		path.put(0, nodes);
		int distance = from.distanceTo(to);
		for (int i = 0; i <= distance; i++) {
			if (path.get(i) == null) {
				return false;
			}
			for (Coordinate c : path.get(i)) {
				switch (pt.getMovementPattern()) {
					case DIAGONAL:
						break;
					case LINEAR:
						break;
					case OMNI:
						break;
					case ORTHOGONAL:
						break;
					default:
						break;
				}
			}
		}

		return false;
	}

	// private static

}
