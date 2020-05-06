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

package escape.exception;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import org.junit.jupiter.api.*;
import escape.*;
import escape.board.LocationType;
import escape.piece.*;
import escape.util.LocationInitializer;

/**
 * Description
 * @version May 6, 2020
 */
public class ExceptionTests {

	/**
	 * test proper controller for board
	 * 
	 * @throws Exception
	 */
	@Test
	void squareTest() throws Exception {
		LocationInitializer li = new LocationInitializer(1, 1, LocationType.BLOCK,
				Player.PLAYER1, PieceName.FOX);
		EscapeGameBuilder egb = new EscapeGameBuilder(
				new File("config/Exceptions/SampleEscapeGame.xml"));
		Assertions.assertThrows(EscapeException.class,
				() -> {egb.makeGameManager();});
	}

	/**
	 * test proper controller for board
	 * 
	 * @throws Exception
	 */
	@Test
	void orthoTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(
				new File("config/Exceptions/SampleEscapeGame3.xml"));
		Assertions.assertThrows(EscapeException.class,
				() -> {egb.makeGameManager();});
	}

	/**
	 * test proper controller for board
	 * 
	 * @throws Exception
	 */
	@Test
	void hexTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(
				new File("config/Exceptions/SampleEscapeGame2.xml"));

		Assertions.assertThrows(EscapeException.class,
				() -> {egb.makeGameManager();});
	}
	
	/**
	 * invalid piecename
	 * 
	 * @throws Exception
	 */
	@Test
	void square2Test() throws Exception {
		LocationInitializer li = new LocationInitializer(1, 1, LocationType.BLOCK,
				Player.PLAYER1, PieceName.FOX);
		EscapeGameBuilder egb = new EscapeGameBuilder(
				new File("config/Exceptions/SampleEscapeGame4.xml"));
		Assertions.assertThrows(EscapeException.class,
				() -> {egb.makeGameManager();});
	}

	/**
	 * invalid piecename
	 * 
	 * @throws Exception
	 */
	@Test
	void ortho2Test() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(
				new File("config/Exceptions/SampleEscapeGame6.xml"));
		Assertions.assertThrows(EscapeException.class,
				() -> {egb.makeGameManager();});
	}

	/**
	 * invalid piecename
	 * 
	 * @throws Exception
	 */
	@Test
	void hex2Test() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(
				new File("config/Exceptions/SampleEscapeGame5.xml"));

		Assertions.assertThrows(EscapeException.class,
				() -> {egb.makeGameManager();});
	}
}
