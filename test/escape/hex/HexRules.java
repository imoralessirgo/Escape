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

import static org.junit.Assert.*;
import java.io.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import escape.*;
import escape.observer.TestObserver;
import escape.piece.Player;

/**
 * Description
 * @version May 13, 2020
 */
public class HexRules {

	
	@Test
	void scorePointConflictTest() {
		GameObserver go = new TestObserver();
		EscapeGameBuilder egb;
		try {
			egb = new EscapeGameBuilder(
					new File("config/HexBoards/HexScorePointConflict.xml"));
			EscapeGameManager emg = egb.makeGameManager();
			emg.addObserver(go);
			assertTrue(emg.move(emg.makeCoordinate(2, -3), emg.makeCoordinate(2, -1))); // player 1 move
			assertNull(emg.getPieceAt(emg.makeCoordinate(2, -3))); // both pieces removed
			assertNull(emg.getPieceAt(emg.makeCoordinate(2, -1))); // both pieces removed
			assertFalse(emg.move(emg.makeCoordinate(-3,4), emg.makeCoordinate(-2, 3))); // player 1 not their turn
			// print it's player2's turn
			assertTrue(emg.move(emg.makeCoordinate(1,2), emg.makeCoordinate(2, 2))); // player 2 move
			assertTrue(emg.move(emg.makeCoordinate(-3,4), emg.makeCoordinate(-2, 3))); // player 1 move
			assertEquals(Player.PLAYER2, emg.getPieceAt(emg.makeCoordinate(-2, 3)).getPlayer()); // proper piece removed
			assertFalse(emg.move(emg.makeCoordinate(4,-5), emg.makeCoordinate(4,-5))); // player 2 invalid
			assertFalse(emg.move(emg.makeCoordinate(5,-5), emg.makeCoordinate(6,-5))); // player 2 invalid
			assertFalse(emg.move(emg.makeCoordinate(4,-5), emg.makeCoordinate(5,-5))); // player 2 invalid
			// print invalid movement pattern
			assertTrue(emg.move(emg.makeCoordinate(2,2), emg.makeCoordinate(5,2))); // player 2 exit 
			// print player 2 wins
			assertFalse(emg.move(emg.makeCoordinate(4,-5), emg.makeCoordinate(4,-5))); // player 2 invalid

			emg.removeObserver(go);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void removePointLimitTest() {
		GameObserver go = new TestObserver();
		EscapeGameBuilder egb;
		try {
			egb = new EscapeGameBuilder(
					new File("config/HexBoards/HexTurnLimitRemove.xml"));
			EscapeGameManager emg = egb.makeGameManager();
			emg.addObserver(go);
			assertTrue(emg.move(emg.makeCoordinate(2, -3), emg.makeCoordinate(2, -1))); // player 1 move
			assertTrue(emg.move(emg.makeCoordinate(1,2), emg.makeCoordinate(5, 2))); // player 2 move
			// player 2 wins
			assertFalse(emg.move(emg.makeCoordinate(-3,4), emg.makeCoordinate(-2, 3))); // player 1 move
			// game over

			emg.removeObserver(go);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
