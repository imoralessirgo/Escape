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
package escape.master;

import static escape.piece.PieceName.*;
import static org.junit.Assert.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import escape.board.coordinate.Coordinate;
import escape.exception.EscapeException;
import escape.piece.PieceName;

/**
 * Description
 * @version May 7, 2020
 */
class MasterOrthoSquareTests extends AbstractMasterTest
{
    /**
     * Description
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass() throws Exception
    {
        fileName = masterTestLocation + "MasterOrthoSquareGame.xml";
    }
    
    /**
     * Valid moves
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param p
     */
    @ParameterizedTest
    @MethodSource("validMoveProvider")
    void validMove(int x1, int y1, int x2, int y2, PieceName p, String test)
    {
        Coordinate c1 = game.makeCoordinate(x1,y1);
        Coordinate c2 = game.makeCoordinate(x2, y2);
        assertEquals(test, p, game.getPieceAt(c1).getName());
        assertTrue(test, game.move(c1,  c2));
        assertEquals(test, p, game.getPieceAt(c2).getName());
        assertNull(test, game.getPieceAt(c1));
    }
    
    static Stream<Arguments> validMoveProvider()
    {
        return Stream.of (
        	// Test one in all directions
            Arguments.of(5, 6, 5, 7, FROG, "move 1"),
            Arguments.of(5, 6, 4, 6, FROG, "move 1"),
            Arguments.of(5, 6, 5, 5, FROG, "move 1"),
            Arguments.of(13, 10, 14, 10, SNAIL, "move 1"),
            Arguments.of(17, 4, 17, 5, FROG, "move 1"),
            
            // Test > 1 and limits
            Arguments.of(17, 4, 19, 5, FROG, "limit"),
            Arguments.of(15, 4, 9, 4, FOX, "limit"),
            Arguments.of(19, 2, 12, 2, HUMMINGBIRD, "limit"),
            Arguments.of(17, 6, 22, 6, HORSE, "limit"),
            // Jump
            Arguments.of(17, 4, 17, 7, FROG, "jump"),
            Arguments.of(17, 6, 12, 6, HORSE, "jump"),
            // Fly
            Arguments.of(19, 2, 19, 5, HUMMINGBIRD, "fly"),
            // UNBLOCK
            Arguments.of(19, 9, 13, 9, FOX, "unblock"),
            // Land on opponent
            Arguments.of(17, 4, 16, 4, FROG, "land on opponent")
        );
    }
    
    @ParameterizedTest
    @MethodSource("invalidMoveProvider")
    void invalidMove(int x1, int y1, int x2, int y2, String test)
    {
    	Coordinate c1 = game.makeCoordinate(x1,y1);
        Coordinate c2 = game.makeCoordinate(x2, y2);
        try {
        	assertFalse(test, game.move(c1,  c2));
        } catch (EscapeException e) {
        	assertTrue(test, true);
        }
    }
    
    static Stream<Arguments> invalidMoveProvider()
    {
    	return Stream.of(
    		Arguments.of(17, 6, 15, 6, "land on same player"),
    		Arguments.of(5, 6, 3, 8, "> limit"),
    		Arguments.of(15, 6, 14, 2, "non-linear"),
    		Arguments.of(19, 9, 18, 9, "land on block"),
    		Arguments.of(17, 4, 14, 4, "attempt double jump"),
    		Arguments.of(17, 4, 18, 6, "attempt to go over exit"),
    		Arguments.of(5, 6, 7, 7, "attempt to jump over block or exit"),
    		Arguments.of(17, 6, 12, 11, "> limit"),
    		Arguments.of(19, 2, 20, 1, "fly but diagonal"),
    		Arguments.of(13, 10, 12, 11, "limit")
            
            
    	);
    }
    
    @Test
    void escape()
    {
    	assertTrue(game.move(game.makeCoordinate(17, 6), game.makeCoordinate(18,  5)));
    	assertNull(game.getPieceAt(game.makeCoordinate(18,  5)));
    }
}
