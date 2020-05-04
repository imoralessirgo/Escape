/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package escape.square;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import escape.*;

/**
 * Description
 * 
 * @version May 2, 2020
 */
public class SquareOrthoTests {
	EscapeGameManager emg;

	@BeforeEach
	public void resetBoard() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(
				new File("config/SquareBoards/SquareOrtho.xml"));
		emg = egb.makeGameManager();
	}

	/**
	 * test Orthogonal movement
	 *
	 */
	@ParameterizedTest
	@MethodSource("othoProvider")
	void othoTests(boolean expected, int x1, int y1, int x2, int y2) {
		assertEquals(expected,
				emg.move(emg.makeCoordinate(x1, y1), emg.makeCoordinate(x2, y2)));
	}

	static Stream<Arguments> othoProvider() {
		return Stream.of(
				Arguments.of(true, 2, 4, 5, 4),
				Arguments.of(false, 2, 4, 2, 4),
				Arguments.of(false, 2, 4, 5, 6),
				Arguments.of(true, 2, 4, 1, 4));
	}

}
