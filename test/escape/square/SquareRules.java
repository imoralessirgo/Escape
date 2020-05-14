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

import static org.junit.Assert.*;
import java.io.File;
import org.junit.jupiter.api.Test;
import escape.*;
import escape.observer.TestObserver;


/**
 * Description
 * @version May 14, 2020
 */
public class SquareRules {
	@Test
	void scorePointConflictTest() {
		GameObserver go = new TestObserver();
		EscapeGameBuilder egb;
		try {
			
			egb = new EscapeGameBuilder(
					new File("config/SquareBoards/SquareRule.xml"));
			EscapeGameManager emg = egb.makeGameManager();
			emg.addObserver(go);
			assertTrue(emg.move(emg.makeCoordinate(20,1), emg.makeCoordinate(21, 1))); // player 1 move
			assertFalse(emg.move(emg.makeCoordinate(22,2), emg.makeCoordinate(21, 1))); // player 1 not their turn
			assertNull(emg.getPieceAt(emg.makeCoordinate(20,1))); // both pieces removed
			assertNull(emg.getPieceAt(emg.makeCoordinate(21, 1))); // both pieces removed
			assertFalse(emg.move(emg.makeCoordinate(1,2), emg.makeCoordinate(2, 4))); // player 2 invalid move
			assertFalse(emg.move(emg.makeCoordinate(1,1), emg.makeCoordinate(2, 4))); // player 2 invalid move
			assertFalse(emg.move(emg.makeCoordinate(2,4), emg.makeCoordinate(2, 4))); // player 2 invalid move
			assertTrue(emg.move(emg.makeCoordinate(2,4), emg.makeCoordinate(2, 5))); // player 2 move
			//print it's a tie
			emg.removeObserver(go);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
