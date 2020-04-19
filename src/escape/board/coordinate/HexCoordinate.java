/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package escape.board.coordinate;

import java.util.Objects;
import escape.exception.EscapeException;

/**
 * Description
 * 
 * @version Apr 13, 2020
 */
public class HexCoordinate implements Coordinate {

	private final int x;
	private final int y;

	private HexCoordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static HexCoordinate makeCoordinate(int x, int y) {
		return new HexCoordinate(x, y);
	}

	/*
	 * Formula retrieved from https://www.redblobgames.com/grids/hexagons/
	 */
	@Override
	public int distanceTo(Coordinate c) {
		int result = 0;
		if (c instanceof HexCoordinate) {
			HexCoordinate to = (HexCoordinate) c;
			result = (Math.abs(this.x - to.getX())
					+ Math.abs(this.x + this.y - to.getX() - to.getY())
					+ Math.abs(this.y - to.getY()));
			result /= 2;
		} else {
			throw new EscapeException("Incompatible coordinate types");
		}
		return result;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof HexCoordinate)) {
			return false;
		}
		HexCoordinate other = (HexCoordinate) obj;
		return x == other.x && y == other.y;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
