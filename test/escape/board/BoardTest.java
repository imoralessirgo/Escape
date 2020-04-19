/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ Copyright ©2016-2020 Gary F. Pollice
 *******************************************************************************/
package escape.board;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.jupiter.api.*;
import escape.board.coordinate.*;
import escape.exception.EscapeException;
import escape.piece.*;

/**
 * Description
 * 
 * @version Apr 2, 2020
 */
class BoardTest {

	/** SQUARE BOARD TESTS **/
	@Test
	void buildBoard1() throws Exception {
		BoardBuilder bb = new BoardBuilder(
				new File("config/board/BoardConfig1.xml"));
		Board b = bb.makeBoard();
		assertNotNull(b);
		assertTrue(b instanceof SquareBoard);
		SquareBoard sb = (SquareBoard) b;
		assertNull(sb.getPieceAt(SquareCoordinate.makeCoordinate(3, 3)));
		EscapePiece ep = sb.getPieceAt(SquareCoordinate.makeCoordinate(2, 2));
		assertNotNull(ep);
		assertEquals(ep.getName(), PieceName.HORSE);
		assertEquals(ep.getPlayer(), Player.PLAYER1);
		Assertions.assertThrows(EscapeException.class,
				() -> sb.getPieceAt(SquareCoordinate.makeCoordinate(9, 9)));
		Assertions.assertThrows(EscapeException.class,
				() -> sb.putPieceAt(null, SquareCoordinate.makeCoordinate(9, 9)));
		Assertions.assertThrows(EscapeException.class, () -> sb
				.setLocationType(SquareCoordinate.makeCoordinate(9, 9), null));
		Assertions.assertThrows(EscapeException.class,
				() -> sb.putPieceAt(null, SquareCoordinate.makeCoordinate(3, 5)));
	}

	//
	// /** ORTHOSQUARE BOARD TESTS **/
	@Test
	void orthoSquareBoard() throws Exception {
		BoardBuilder bb = new BoardBuilder(new File("config/board/OrthoTest.xml"));
		Board b = bb.makeBoard();
		assertNotNull(b);
		assertTrue(b instanceof OrthoSquareBoard);
		OrthoSquareBoard sb = (OrthoSquareBoard) b;
		assertNull(sb.getPieceAt(OrthoSquareCoordinate.makeCoordinate(3, 3)));
		EscapePiece ep = sb.getPieceAt(OrthoSquareCoordinate.makeCoordinate(2, 2));
		assertNotNull(ep);
		assertEquals(ep.getName(), PieceName.HORSE);
		assertEquals(ep.getPlayer(), Player.PLAYER1);
		Assertions.assertThrows(EscapeException.class,
				() -> sb.getPieceAt(OrthoSquareCoordinate.makeCoordinate(9, 9)));
		Assertions.assertThrows(EscapeException.class, () -> sb.putPieceAt(null,
				OrthoSquareCoordinate.makeCoordinate(9, 9)));
		Assertions.assertThrows(EscapeException.class, () -> sb
				.setLocationType(OrthoSquareCoordinate.makeCoordinate(9, 9), null));
		Assertions.assertThrows(EscapeException.class,
				() -> sb.putPieceAt(null, OrthoSquareCoordinate.makeCoordinate(3, 5)));
	}

	/** HEX BOARD TESTS **/
	@Test
	void hexBoard() throws Exception {
		BoardBuilder bb = new BoardBuilder(new File("config/board/HexTest.xml"));
		Board b = bb.makeBoard();
		assertNotNull(b);
		assertTrue(b instanceof HexBoard);
		HexBoard sb = (HexBoard) b;
		assertNull(sb.getPieceAt(HexCoordinate.makeCoordinate(3, 3)));
		EscapePiece ep = sb.getPieceAt(HexCoordinate.makeCoordinate(2, 2));
		assertNotNull(ep);
		assertEquals(ep.getName(), PieceName.HORSE);
		assertEquals(ep.getPlayer(), Player.PLAYER1);
		Assertions.assertThrows(EscapeException.class,
				() -> sb.putPieceAt(null, HexCoordinate.makeCoordinate(3, 5)));

	}

	/** FAKE BOARD TESTS **/
	@Test
	void fakeBoard() throws Exception {
		BoardBuilder bb = new BoardBuilder(
				new File("config/board/BoardConfig2.xml"));
		Assertions.assertThrows(NullPointerException.class, () -> bb.makeBoard());
	}

}
