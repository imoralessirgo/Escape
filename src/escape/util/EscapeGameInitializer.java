/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Gary F. Pollice
 *******************************************************************************/

package escape.util;

import javax.xml.bind.annotation.XmlRootElement;
import escape.board.coordinate.CoordinateID;
import escape.rule.Rule;

/**
 * An example of reading a game configuration file and the board and piece initializers
 * that it
 * 
 * @version Apr 22, 2020
 */
@XmlRootElement
public class EscapeGameInitializer {
	private CoordinateID coordinateType;

	// Board items
	private int xMax, yMax;
	private LocationInitializer[] locationInitializers;

	// Piece items
	private PieceTypeInitializer[] pieceTypes; // At least one
	private Rule[] rules;
	
	public EscapeGameInitializer() {
		// Needed for JAXB
	}

	/**
	 * @return the coordinateType
	 */
	public CoordinateID getCoordinateType() {
		return coordinateType;
	}

	/**
	 * @param coordinateType
	 *            the coordinateType to set
	 */
	public void setCoordinateType(CoordinateID coordinateType) {
		this.coordinateType = coordinateType;
	}

	/**
	 * @return the xMax
	 */
	public int getxMax() {
		return xMax;
	}

	/**
	 * @param xMax
	 *            the xMax to set
	 */
	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

	/**
	 * @return the yMax
	 */
	public int getyMax() {
		return yMax;
	}

	/**
	 * @param yMax
	 *            the yMax to set
	 */
	public void setyMax(int yMax) {
		this.yMax = yMax;
	}

	/**
	 * @return the locationInitializers
	 */
	public LocationInitializer[] getLocationInitializers() {
		return locationInitializers;
	}

	/**
	 * @param locationInitializers
	 *            the locationInitializers to set
	 */
	public void setLocationInitializers(
			LocationInitializer... locationInitializers) {
		this.locationInitializers = locationInitializers;
	}

	/**
	 * @return the types
	 */
	public PieceTypeInitializer[] getPieceTypes() {
		return pieceTypes;
	}

	/**
	 * @param types
	 *            the types to set
	 */
	public void setPieceTypes(PieceTypeInitializer... types) {
		this.pieceTypes = types;
	}

	/**
	 * @return the rules
	 */
	public Rule[] getRules() {
		return rules;
	}

	/**
	 * @param rules the rules to set
	 */
	public void setRules(Rule[] rules) {
		this.rules = rules;
	}


}
