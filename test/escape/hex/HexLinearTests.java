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

package escape.hex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import escape.*;
import escape.exception.EscapeException;

/**
 * Description
 * @version May 4, 2020
 */
public class HexLinearTests {
	EscapeGameManager emg;

	@BeforeEach
	public void resetBoard() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(
				new File("config/HexBoards/HexLinear.xml"));
		emg = egb.makeGameManager();
	}

	/**
	 * test Orthogonal movement
	 *
	 */
	@ParameterizedTest
	@MethodSource("linearProvider")
	void linearTests(boolean expected, int x1, int y1, int x2, int y2) {
		assertEquals(expected,
				emg.move(emg.makeCoordinate(x1, y1), emg.makeCoordinate(x2, y2)));
	}

	static Stream<Arguments> linearProvider() {
		return Stream.of(
				
				// Frog
				Arguments.of(false, 2, -3, 2, 0),
				Arguments.of(true, 2,-2, 2, 0),
				Arguments.of(true, 2, -2, 2, 2),
				Arguments.of(false, 2, -2, 2, -1), // adj
				Arguments.of(false, 2, -3, 2, -1), // adj
				Arguments.of(false, 2,-3,1,-3),
				Arguments.of(false, 2, -3, 0,-3),
				// Horse
				Arguments.of(true, -3, -2, -5, 0),
				Arguments.of(true, -3, -2, 0, -5),
				// Snail
				Arguments.of(false, 2, -1, 3, -1),
				Arguments.of(true, 2, -1, 0, -1),
				// Fox
				Arguments.of(true, 0, 1, -3, 4),
				Arguments.of(true, 0, 1, 0, -1),
				Arguments.of(false, 0, 1, -3, 8),
				Arguments.of(false, 0, 1, -3, 5)
				
				);
	}
	

}
