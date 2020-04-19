/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2020 Gary F. Pollice
 *******************************************************************************/

package escape.board.coordinate;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import escape.exception.EscapeException;

/**
 * Tests for various coordinates
 * 
 * @version Mar 28, 2020
 */
class CoordinateTest {
	
	
	
	/** SQUARE BOARD TESTS **/
	@ParameterizedTest
	@MethodSource("squareBoardTestProvider")
	void squareBoardTests(Coordinate from, Coordinate to, int r, boolean expected) {
		assertEquals(expected, from.distanceTo(to) == r);
	}
	
	static Stream<Arguments> squareBoardTestProvider() {
		return Stream.of(
				Arguments.of(SquareCoordinate.makeCoordinate(1,1), SquareCoordinate.makeCoordinate(3,3), 2, true),
				Arguments.of(SquareCoordinate.makeCoordinate(1,1), SquareCoordinate.makeCoordinate(4,2), 3, true),
				Arguments.of(SquareCoordinate.makeCoordinate(4,2), SquareCoordinate.makeCoordinate(1,1), 3, true),
				Arguments.of(SquareCoordinate.makeCoordinate(3,3), SquareCoordinate.makeCoordinate(1,1), 2, true) 
				);
	}
		
	/** ORTHOSQUARE BOARD TESTS **/
	@ParameterizedTest
	@MethodSource("orthoSquareBoardTestProvider")
	void orthoSquareBoardTests(Coordinate from, Coordinate to, int r, boolean expected) {
	
		assertEquals(expected, from.distanceTo(to) == r);
	}
	
	static Stream<Arguments> orthoSquareBoardTestProvider() {
		return Stream.of(
				Arguments.of(OrthoSquareCoordinate.makeCoordinate(1,1), OrthoSquareCoordinate.makeCoordinate(3,3), 4, true),
				Arguments.of(OrthoSquareCoordinate.makeCoordinate(1,1), OrthoSquareCoordinate.makeCoordinate(4,2), 4, true),
				Arguments.of(OrthoSquareCoordinate.makeCoordinate(4,2), OrthoSquareCoordinate.makeCoordinate(1,1), 4, true),
				Arguments.of(OrthoSquareCoordinate.makeCoordinate(3,3), OrthoSquareCoordinate.makeCoordinate(1,1), 4, true) 
				);
	}

	/** HEX BOARD TESTS **/
	@ParameterizedTest
	@MethodSource("HexBoardTestProvider")
	void HexBoardTests(Coordinate from, Coordinate to, int r, boolean expected) {
		assertEquals(expected, from.distanceTo(to) == r);
	}
	
	static Stream<Arguments> HexBoardTestProvider() {
		return Stream.of(
				Arguments.of(HexCoordinate.makeCoordinate(0,0), HexCoordinate.makeCoordinate(-1,2), 2, true),
				Arguments.of(HexCoordinate.makeCoordinate(-1,2), HexCoordinate.makeCoordinate(2,-2), 4, true),
				Arguments.of(HexCoordinate.makeCoordinate(4,2), HexCoordinate.makeCoordinate(1,1), 4, true),
				Arguments.of(HexCoordinate.makeCoordinate(3,3), HexCoordinate.makeCoordinate(1,1), 4, true) 
				);
	}
	
	@FunctionalInterface
	interface calculateDistance{
		int execute(Coordinate from, Coordinate to);
	}
	
	
	@Test
	void invalidDistance() {
		SquareCoordinate square = SquareCoordinate.makeCoordinate(1,1);
		OrthoSquareCoordinate ortho = OrthoSquareCoordinate.makeCoordinate(2,2);
		HexCoordinate hex = HexCoordinate.makeCoordinate(3,3);

		Assertions.assertThrows(EscapeException.class,  () -> hex.distanceTo(square) );
		Assertions.assertThrows(EscapeException.class,  () -> square.distanceTo(ortho) );
		Assertions.assertThrows(EscapeException.class,  () -> ortho.distanceTo(square) );
	}
}
