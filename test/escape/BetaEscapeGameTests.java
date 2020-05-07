package escape;

/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Gary F. Pollice
 *******************************************************************************/

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import org.junit.jupiter.api.*;
import escape.*;
import escape.board.LocationType;
import escape.exception.EscapeException;
import escape.piece.*;
import escape.util.LocationInitializer;

/**
 * Description
 * 
 * @version Apr 24, 2020
 */
class BetaEscapeGameTests {

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
				new File("config/SampleEscapeGame.xml"));
		EscapeGameManager emg = egb.makeGameManager();
		assertTrue(emg instanceof SquareGameController);
		Assertions.assertThrows(EscapeException.class,
				() -> {emg.move(emg.makeCoordinate(3,2), emg.makeCoordinate(2, 2));});
		Assertions.assertThrows(EscapeException.class,
				() -> {emg.move(emg.makeCoordinate(3,3), emg.makeCoordinate(2, 2));});
	}

	/**
	 * test proper controller for board
	 * 
	 * @throws Exception
	 */
	@Test
	void orthoTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(
				new File("config/SampleEscapeGame3.xml"));
		EscapeGameManager emg = egb.makeGameManager();
		assertTrue(emg instanceof OrthoGameController);
		Assertions.assertThrows(EscapeException.class,
				() -> {emg.move(emg.makeCoordinate(3,2), emg.makeCoordinate(2, 2));});
		Assertions.assertThrows(EscapeException.class,
				() -> {emg.move(emg.makeCoordinate(3,3), emg.makeCoordinate(2, 2));});
	}

	/**
	 * test proper controller for board
	 * 
	 * @throws Exception
	 */
	@Test
	void hexTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(
				new File("config/SampleEscapeGame2.xml"));
		EscapeGameManager emg = egb.makeGameManager();
		assertTrue(emg instanceof HexGameController);
		Assertions.assertThrows(EscapeException.class,
				() -> {emg.move(emg.makeCoordinate(3,2), emg.makeCoordinate(2, 2));});
		Assertions.assertThrows(EscapeException.class,
				() -> {emg.move(emg.makeCoordinate(3,3), emg.makeCoordinate(2, 2));});
	}
	
}
