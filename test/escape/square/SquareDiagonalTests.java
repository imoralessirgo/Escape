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

package escape.square;

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
public class SquareDiagonalTests {
	EscapeGameManager emg;

	@BeforeEach
	public void resetBoard() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(
				new File("config/SquareBoards/SquareDiagonal.xml"));
		emg = egb.makeGameManager();
	}

	
	
	/**
	 * test diagonal movement
	 *
	 */
	@ParameterizedTest
	@MethodSource("diagonalProvider")
	void diagonalTests(boolean expected, int x1, int y1, int x2, int y2) {
		assertEquals(expected,
				emg.move(emg.makeCoordinate(x1, y1), emg.makeCoordinate(x2, y2)));
	}

	static Stream<Arguments> diagonalProvider() {
		return Stream.of(
				// frog
				Arguments.of(false, 5,4,4,3),
				Arguments.of(true, 5,4,3,2),
				Arguments.of(true, 5,4,7,6),
				Arguments.of(true, 5,4,9,8),
				Arguments.of(false, 5,4,13,12),
				// horse
				Arguments.of(false, 18,15,10,7),
				Arguments.of(false, 18,15,19,15)
//				Arguments.of(false, 18,15,25,22)
//				Arguments.of(false, 18,15,13,12)
				);
	}
	
	@Test
	public void exceptionTests() {

		Assertions.assertThrows(EscapeException.class,
				() -> {emg.move(emg.makeCoordinate(18, 15), emg.makeCoordinate(25, 22));});
	}
	

}
