/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Copyright ©2016-2020 Gary F. Pollice
 *******************************************************************************/
package escape.board;

/**
 * Every location (e.g., square) on an Escape board has a type. This enumeration
 * identifies the valid types.
 * @version Mar 27, 2020
 */
public enum LocationType
{
	CLEAR, BLOCK, EXIT;
}
