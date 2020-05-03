/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Copyright ©2020 Gary F. Pollice
 *******************************************************************************/



import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import org.junit.jupiter.api.Test;
import escape.*;
import escape.board.coordinate.HexCoordinate;
import escape.board.coordinate.SquareCoordinate;
import escape.piece.EscapePiece;

/**
 * Description
 * @version Apr 24, 2020
 */
class BetaEscapeGameTests
{
    
//    /**
//     * Example of how the game manager tests will be structured.
//     * @throws Exception
//     */
//    @Test
//    void test() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/SampleEscapeGame.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertTrue(emg.move(SquareCoordinate.makeCoordinate(7, 8), SquareCoordinate.makeCoordinate(9, 10)));
//    }
//    
//    @Test
//    void DiagonalTest() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/DiagonalMove.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertTrue(emg.move(SquareCoordinate.makeCoordinate(2, 2), SquareCoordinate.makeCoordinate(8, 8)));
//    }
//    
//    @Test
//    void LinearTest() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/LinearMove.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertFalse(emg.move(SquareCoordinate.makeCoordinate(2, 2), SquareCoordinate.makeCoordinate(8, 8)));
//    }
//    
//    @Test
//    void LinearTest2() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/LinearMove.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertTrue(emg.move(SquareCoordinate.makeCoordinate(2, 2), SquareCoordinate.makeCoordinate(7, 2)));
//    }
//    
//    @Test
//    void LinearTest3() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/LinearMove.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertTrue(emg.move(SquareCoordinate.makeCoordinate(2, 2), SquareCoordinate.makeCoordinate(2, 1)));
//    }
//    
//    @Test
//    void LinearTest4() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/LinearMove.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertTrue(emg.move(SquareCoordinate.makeCoordinate(2, 2), SquareCoordinate.makeCoordinate(2, 5)));
//    }
//    
//    @Test
//    void LinearTest5() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/LinearMove.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertTrue(emg.move(SquareCoordinate.makeCoordinate(2, 2), SquareCoordinate.makeCoordinate(3, 1)));
//    }
//    
//    @Test
//    void LinearTest6() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/LinearMove.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertTrue(emg.move(SquareCoordinate.makeCoordinate(2, 2), SquareCoordinate.makeCoordinate(1, 3)));
//    }
//    
//    
//    @Test
//    void OrthoTest() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/OrthoMove.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertTrue(emg.move(SquareCoordinate.makeCoordinate(2, 2), SquareCoordinate.makeCoordinate(8, 8)));
//    }
//    
//    @Test
//    void HexTestFuckEmUp() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/HexMove.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//       
//        assertNotNull(emg.getPieceAt(emg.makeCoordinate(-1, 1)));
//    }
//    
//    @Test
//    void HexTestFuckEmUpAGAIN() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/HexMove.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//       
//        assertNull(emg.getPieceAt(emg.makeCoordinate(2, 2)));
//    }
//    
//    @Test
//    void HexTest() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/HexMove.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertTrue(emg.move(HexCoordinate.makeCoordinate(0, 0), HexCoordinate.makeCoordinate(0,3)));
//    }
//    
//    @Test
//    void HexTest2() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/HexMove.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertTrue(emg.move(HexCoordinate.makeCoordinate(0, 0), HexCoordinate.makeCoordinate(-2,2)));
//    }
//    
//    @Test
//    void Diagional2Test() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/DiagonalMove2.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertTrue(emg.move(SquareCoordinate.makeCoordinate(2, 2), SquareCoordinate.makeCoordinate(8, 8)));
//    }
//    
//    @Test
//    void OrthoBoardTest() throws Exception
//    {
//    EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/OrthoOrtho.xml"));
//    EscapeGameManager emg = egb.makeGameManager();
//    // Exercise the game now: make moves, check the board, etc.
//    assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(7, 7)));
//    }
//    
//    @Test
//    void SqaureBoardTest() throws Exception
//    {
//    EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/SquareOrtho2.xml"));
//    EscapeGameManager emg = egb.makeGameManager();
//    // Exercise the game now: make moves, check the board, etc.
//    assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(7, 7)));
//    }
//    
//    @Test
//    void OrthoBoardLinearTest() throws Exception
//    {
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/OrthoLinear.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertFalse(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(8, 8)));
//    }
//    
//    @Test
//    void OrthoBoardOmniTest() throws Exception
//    {
//    	
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/OrthoOmni.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(8, 8)));
//    }
//    
//    @Test
//    void HexBoardOmniTest() throws Exception
//    {
//    
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/HexOmni2.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertTrue(emg.move(emg.makeCoordinate(0,0), emg.makeCoordinate(2, 2)));
//    }
//    
//    @Test
//    void HexBoardLinearTest() throws Exception
//    {
//   
//        EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/HexLinear2.xml"));
//        EscapeGameManager emg = egb.makeGameManager();
//        // Exercise the game now: make moves, check the board, etc.
//        assertFalse(emg.move(emg.makeCoordinate(0,0), emg.makeCoordinate(2, 2)));
//    }
//    
//    
//	@Test
//	void EndOnEnemyPlayerPieceOthroOmni() throws Exception {
//		EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/OrthoOmni.xml"));
//		EscapeGameManager emg = egb.makeGameManager();
//		// Exercise the game now: make moves, check the board, etc.
//		EscapePiece StartPiece = emg.getPieceAt(emg.makeCoordinate(2, 2));
//		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(6, 6)));
//		assertEquals(StartPiece, emg.getPieceAt(emg.makeCoordinate(6, 6)));
//	}
//
//	@Test 
//	void EndOnSamePlayerPieceOthroOmni() throws Exception {
//		EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/OrthoOmni.xml"));
//		EscapeGameManager emg = egb.makeGameManager();
//		// Exercise the game now: make moves, check the board, etc.
//		assertFalse(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(5, 5)));
//	}
	
	@Test
	void SquareOmniMasterTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/SquareOmni.xml"));
		EscapeGameManager emg = egb.makeGameManager();
		// Exercise the game now: make moves, check the board, etc.
		
		//jump over two pieces -> false
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(4, 2)));
		
		//jump over one piece at time -> true
		assertNull(emg.getPieceAt(emg.makeCoordinate(4, 2)));
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(4, 2)));
		assertNotNull(emg.getPieceAt(emg.makeCoordinate(4, 2)));
		emg = egb.makeGameManager();//reset board
		
		//jump over one piece at time, multi times -> true
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(6, 2)));
		
		emg = egb.makeGameManager();//reset board
		//capture enemy piece ->
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(3, 2)));
		
		emg = egb.makeGameManager();//reset board
		//unblock false -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(1, 3)));
		
		//unblock false -> can't pass over block
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(1, 4)));
		
		//jump over one piece to then capture enemy piece -> true
	 	assertTrue(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(3, 2)));
		
		emg = egb.makeGameManager();//reset board
		//unblock true -> can't end on block
		assertFalse(emg.move(emg.makeCoordinate(3, 2), emg.makeCoordinate(3, 3)));
		
		//unblock true -> can pass over  block
		assertTrue(emg.move(emg.makeCoordinate(3, 2), emg.makeCoordinate(3, 5)));
		
		//jump false -> can't jump
		assertFalse(emg.move(emg.makeCoordinate(2, 7), emg.makeCoordinate(4, 7)));
		
		//Fly -> can't end on block
		assertFalse(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(1, 6)));
		
		//Fly -> can jump many pieces 
	    assertTrue(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(4, 7)));
		
	    emg = egb.makeGameManager();//reset board
	    //Fly -> can't go past distance set (5)
	    assertFalse(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(8, 2)));
	    
	    //Fly -> can go to max distance set (5)
	    assertTrue(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(6, 2)));
	    
	    //Distance -> can't go past distance set (4)
	    assertFalse(emg.move(emg.makeCoordinate(6, 1), emg.makeCoordinate(8, 8)));
	    
	    //Distance -> can go to max distance set (4)
	    assertTrue(emg.move(emg.makeCoordinate(6, 1), emg.makeCoordinate(8, 5)));
	    //Exit removes piece
	    assertNull(emg.getPieceAt(emg.makeCoordinate(8, 5)));
	    
	    //can't pass over an exit
	    assertFalse(emg.move(emg.makeCoordinate(11, 1), emg.makeCoordinate(11, 5)));
	    
	    //FLY -> can pass over an exit
	    assertTrue(emg.move(emg.makeCoordinate(9, 1), emg.makeCoordinate(9, 6)));
	    
	}
	
	@Test
	void SquareLinearMasterTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/SquareLinear.xml"));
		EscapeGameManager emg = egb.makeGameManager();
		// Exercise the game now: make moves, check the board, etc.
		
		//jump over two pieces -> false
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(4, 2)));
		
		//jump over one piece at time -> true
		assertNull(emg.getPieceAt(emg.makeCoordinate(4, 2)));
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(4, 2)));
		assertNotNull(emg.getPieceAt(emg.makeCoordinate(4, 2)));
		emg = egb.makeGameManager();//reset board
		
		//jump over one piece at time, multi times -> true
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(6, 2)));
		
		emg = egb.makeGameManager();//reset board
		//capture enemy piece ->
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(3, 2)));
		
		emg = egb.makeGameManager();//reset board
		//unblock false -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(1, 3)));
		
		//unblock false -> can't pass over block
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(1, 4)));
		
		//jump over one piece to then capture enemy piece -> true
	 	assertTrue(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(3, 2)));
		
		emg = egb.makeGameManager();//reset board
		//unblock true -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(3, 2), emg.makeCoordinate(3, 3)));
		
		//unblock true -> can pass over  block
		assertTrue(emg.move(emg.makeCoordinate(3, 2), emg.makeCoordinate(3, 5)));
		
		//jump false -> can't jump
		assertFalse(emg.move(emg.makeCoordinate(2, 7), emg.makeCoordinate(4, 7)));
		
		//Fly -> can't end on block
		assertFalse(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(1, 6)));
		
		//Fly -> can jump many pieces 
	    assertTrue(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(4, 7)));
		
	    emg = egb.makeGameManager();//reset board
	    //Fly -> can't go past distance set (5)
	    assertFalse(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(8, 7)));
	    
	    //Fly -> can go to max distance set (5)
	    assertTrue(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(6, 2)));
	   
	    //Distance -> can't go past distance set (4)
	    assertFalse(emg.move(emg.makeCoordinate(8, 1), emg.makeCoordinate(8, 8)));
	    
	    //Distance -> can go to max distance set (4)
	    assertTrue(emg.move(emg.makeCoordinate(8, 1), emg.makeCoordinate(8, 5)));
	    //Exit removes piece
	    assertNull(emg.getPieceAt(emg.makeCoordinate(8, 5)));
	    
	    //cant do multi directions
	    assertFalse(emg.move(emg.makeCoordinate(8, 1), emg.makeCoordinate(6, 4)));
	    assertFalse(emg.move(emg.makeCoordinate(8, 6), emg.makeCoordinate(4, 5)));
	    
	    //can move diagonal
	    assertTrue(emg.move(emg.makeCoordinate(4, 4), emg.makeCoordinate(8, 8)));
	    
	    //can't pass over an exit
	    assertFalse(emg.move(emg.makeCoordinate(10, 1), emg.makeCoordinate(10, 5)));
	    
	    //FLY -> can pass over an exit
	    assertTrue(emg.move(emg.makeCoordinate(9, 1), emg.makeCoordinate(9, 6)));
	}
	
	@Test
	void SquareOrthoMasterTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/SquareOrtho.xml"));
		EscapeGameManager emg = egb.makeGameManager();
		// Exercise the game now: make moves, check the board, etc.
		
		//jump over two pieces -> false
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(4, 2)));
		
		//jump over one piece at time -> true
		assertNull(emg.getPieceAt(emg.makeCoordinate(4, 2)));
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(4, 2)));
		assertNotNull(emg.getPieceAt(emg.makeCoordinate(4, 2)));
		emg = egb.makeGameManager();//reset board
		
		//jump over one piece at time, multi times -> true
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(6, 2)));
		
		emg = egb.makeGameManager();//reset board
		//capture enemy piece ->
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(3, 2)));
		
		emg = egb.makeGameManager();//reset board
		//unblock false -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(1, 3)));
		
		//unblock false -> can't pass over block
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(1, 4)));
		
		//jump over one piece to then capture enemy piece -> true
	 	assertTrue(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(3, 2)));
		
		emg = egb.makeGameManager();//reset board
		//unblock true -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(3, 2), emg.makeCoordinate(3, 3)));
		
		//unblock true -> can pass over  block
		assertTrue(emg.move(emg.makeCoordinate(3, 2), emg.makeCoordinate(3, 5)));
		
		//jump false -> can't jump
		assertFalse(emg.move(emg.makeCoordinate(2, 7), emg.makeCoordinate(4, 7)));
		
		//Fly -> can't end on block
		assertFalse(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(1, 6)));
		
		//Fly -> can jump many pieces 
	    assertTrue(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(4, 7)));
		
	    emg = egb.makeGameManager();//reset board
	    //Fly -> can't go past distance set (5)
	    assertFalse(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(8, 7)));
	    
	    //Fly -> can go to max distance set (5)
	    assertTrue(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(3, 5)));
	   
	    //Distance -> can't go past distance set (4)
	    assertFalse(emg.move(emg.makeCoordinate(6, 3), emg.makeCoordinate(8, 8)));
	    
	    //Distance -> can go to max distance set (4)
	    assertTrue(emg.move(emg.makeCoordinate(6, 3), emg.makeCoordinate(8, 5)));
	    
	    //Exit removes piece
	    assertNull(emg.getPieceAt(emg.makeCoordinate(8, 5)));
	    
	    //can't move diagonal
	    assertFalse(emg.move(emg.makeCoordinate(4, 4), emg.makeCoordinate(8, 8)));
	    
	    //can't pass over an exit
	    assertFalse(emg.move(emg.makeCoordinate(10, 1), emg.makeCoordinate(10, 5)));
	    
	    //FLY -> can pass over an exit
	    assertTrue(emg.move(emg.makeCoordinate(9, 1), emg.makeCoordinate(9, 6)));
	}
    
	@Test
	void SquareDiagonalMasterTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/SquareDiagonal.xml"));
		EscapeGameManager emg = egb.makeGameManager();
		// Exercise the game now: make moves, check the board, etc.
		
		//jump over two pieces -> false
		assertFalse(emg.move(emg.makeCoordinate(1, 1), emg.makeCoordinate(4, 4)));
		
		//jump over one piece at time -> true
		assertNull(emg.getPieceAt(emg.makeCoordinate(4, 4)));
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(4, 4)));
		assertNotNull(emg.getPieceAt(emg.makeCoordinate(4, 4)));
		emg = egb.makeGameManager();//reset board
		
		emg = egb.makeGameManager();//reset board
		//capture enemy piece ->
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(3, 3)));
		
		emg = egb.makeGameManager();//reset board
		
		//jump over one piece to then capture enemy piece -> true
	 	assertTrue(emg.move(emg.makeCoordinate(1, 1), emg.makeCoordinate(3, 3)));
	 	
	 	emg = egb.makeGameManager();//reset board
	 	
	 	//jump over one piece at time, multi times -> true
	 	assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(7, 3)));
		
		emg = egb.makeGameManager();//reset board
		//unblock false -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(1, 3)));
		
		//unblock false -> can't pass over block
		assertFalse(emg.move(emg.makeCoordinate(2, 6), emg.makeCoordinate(4, 8)));
		
		emg = egb.makeGameManager();//reset board
		//unblock true -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(3, 3), emg.makeCoordinate(2, 4)));
		
		//unblock true -> can pass over block
		assertTrue(emg.move(emg.makeCoordinate(3, 3), emg.makeCoordinate(1, 5)));
		
		emg = egb.makeGameManager();//reset board
		//jump false -> can't jump
		assertFalse(emg.move(emg.makeCoordinate(9, 9), emg.makeCoordinate(11, 11)));
		
		//Fly -> can't end on block
		assertFalse(emg.move(emg.makeCoordinate(8, 8), emg.makeCoordinate(7, 9)));
		
		//Fly -> can jump many pieces 
	    assertTrue(emg.move(emg.makeCoordinate(8, 8), emg.makeCoordinate(10, 12)));
		
	    emg = egb.makeGameManager();//reset board
	    //Fly -> can't go past distance set (5)
	    assertFalse(emg.move(emg.makeCoordinate(8, 8), emg.makeCoordinate(14, 14)));
	    
	    //Fly -> can go to max distance set (5)
	    assertTrue(emg.move(emg.makeCoordinate(8, 8), emg.makeCoordinate(13, 13)));
	  
	    //Distance -> can't go past distance set (4)
	    assertFalse(emg.move(emg.makeCoordinate(16, 1), emg.makeCoordinate(21, 6)));
	    
	    //Distance -> can go to max distance set (4)
	    assertTrue(emg.move(emg.makeCoordinate(16, 1), emg.makeCoordinate(20, 5)));
	    //Exit removes piece
	    assertNull(emg.getPieceAt(emg.makeCoordinate(20, 5)));
	    
	    emg = egb.makeGameManager();//reset board
	    //can't move non-diagonal
	    assertFalse(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(2, 1)));
	    assertFalse(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(1, 2))); 
	    assertFalse(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(2, 3)));
	    assertFalse(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(3, 2)));
	    
	    //can't pass over an exit
	    assertFalse(emg.move(emg.makeCoordinate(30, 1), emg.makeCoordinate(34, 5)));
	    
	    //FLY -> can pass over an exit
	    assertTrue(emg.move(emg.makeCoordinate(22, 1), emg.makeCoordinate(27, 6)));
	  
	}
	
	@Test
	void OrthoSquareOrthoMasterTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/OrthoSquareOrtho.xml"));
		EscapeGameManager emg = egb.makeGameManager();
		// Exercise the game now: make moves, check the board, etc.
		
//		//jump over two pieces -> false
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(4, 2)));
		
		//jump over one piece at time -> true
		assertNull(emg.getPieceAt(emg.makeCoordinate(4, 2)));
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(4, 2)));
		assertNotNull(emg.getPieceAt(emg.makeCoordinate(4, 2)));
		emg = egb.makeGameManager();//reset board
		
		//jump over one piece at time, multi times -> true
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(6, 2)));
		
		emg = egb.makeGameManager();//reset board
		//capture enemy piece ->
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(3, 2)));
		
		emg = egb.makeGameManager();//reset board
		//unblock false -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(1, 3)));
		
		//unblock false -> can't pass over block
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(1, 4)));
		
		//jump over one piece to then capture enemy piece -> true
	 	assertTrue(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(3, 2)));
		
		emg = egb.makeGameManager();//reset board
		//unblock true -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(3, 2), emg.makeCoordinate(3, 3)));
		
		//unblock true -> can pass over  block
		assertTrue(emg.move(emg.makeCoordinate(3, 2), emg.makeCoordinate(3, 5)));
		
		//jump false -> can't jump
		assertFalse(emg.move(emg.makeCoordinate(2, 7), emg.makeCoordinate(4, 7)));
		
		//Fly -> can't end on block
		assertFalse(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(1, 6)));
		
		//Fly -> can jump many pieces 
	    assertTrue(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(4, 7)));
		
	    emg = egb.makeGameManager();//reset board
	    //Fly -> can't go past distance set (5)
	    assertFalse(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(8, 7)));
	    
	    //Fly -> can go to max distance set (5)
	    assertTrue(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(3, 5)));
	   
	    //Distance -> can't go past distance set (4)
	    assertFalse(emg.move(emg.makeCoordinate(6, 3), emg.makeCoordinate(8, 8)));
	    
	    //Distance -> can go to max distance set (4)
	    assertTrue(emg.move(emg.makeCoordinate(6, 3), emg.makeCoordinate(8, 5)));
	    
	    //Exit removes piece
	    assertNull(emg.getPieceAt(emg.makeCoordinate(8, 5)));
	    
	    //can't move diagonal
	    assertFalse(emg.move(emg.makeCoordinate(4, 4), emg.makeCoordinate(8, 8)));
	    
	    //can't pass over an exit
	    assertFalse(emg.move(emg.makeCoordinate(10, 1), emg.makeCoordinate(10, 5)));
	    
	    //FLY -> can pass over an exit
	    assertTrue(emg.move(emg.makeCoordinate(9, 1), emg.makeCoordinate(9, 6)));
	}
	
	@Test
	void OrthoSquareOmniMasterTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/OrthoSquareOmni.xml"));
		EscapeGameManager emg = egb.makeGameManager();
		// Exercise the game now: make moves, check the board, etc.
		
		//jump over two pieces -> false
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(4, 2)));
		
		//jump over one piece at time -> true
		assertNull(emg.getPieceAt(emg.makeCoordinate(4, 2)));
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(4, 2)));
		assertNotNull(emg.getPieceAt(emg.makeCoordinate(4, 2)));
		emg = egb.makeGameManager();//reset board
		
		//jump over one piece at time, multi times -> true
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(6, 2)));
		
		emg = egb.makeGameManager();//reset board
		//capture enemy piece ->
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(3, 2)));
		
		emg = egb.makeGameManager();//reset board
		//unblock false -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(1, 3)));
		
		//unblock false -> can't pass over block
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(1, 4)));
		
		//jump over one piece to then capture enemy piece -> true
	 	assertTrue(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(3, 2)));
		
		emg = egb.makeGameManager();//reset board
		//unblock true -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(3, 2), emg.makeCoordinate(3, 3)));
		
		//unblock true -> can pass over  block
		assertTrue(emg.move(emg.makeCoordinate(3, 2), emg.makeCoordinate(3, 5)));
		
		//jump false -> can't jump
		assertFalse(emg.move(emg.makeCoordinate(2, 7), emg.makeCoordinate(4, 7)));
		
		//Fly -> can't end on block
		assertFalse(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(1, 6)));
		
		//Fly -> can jump many pieces 
	    assertTrue(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(4, 7)));
		
	    emg = egb.makeGameManager();//reset board
	    //Fly -> can't go past distance set (5)
	    assertFalse(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(8, 7)));
	    
	    //Fly -> can go to max distance set (5)
	    assertTrue(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(3, 5)));
	   
	    //Distance -> can't go past distance set (4)
	    assertFalse(emg.move(emg.makeCoordinate(6, 3), emg.makeCoordinate(8, 8)));
	    
	    //Distance -> can go to max distance set (4)
	    assertTrue(emg.move(emg.makeCoordinate(6, 3), emg.makeCoordinate(8, 5)));
	    
	    //Exit removes piece
	    assertNull(emg.getPieceAt(emg.makeCoordinate(8, 5)));
	    
	    //can't move diagonal
	    assertFalse(emg.move(emg.makeCoordinate(4, 4), emg.makeCoordinate(8, 8)));
	    
	    emg = egb.makeGameManager();//reset board
	    //can't pass over an exit
	    assertFalse(emg.move(emg.makeCoordinate(10, 1), emg.makeCoordinate(10, 5)));
	    
	    //FLY -> can pass over an exit
	    assertTrue(emg.move(emg.makeCoordinate(9, 1), emg.makeCoordinate(9, 6)));
	    
	}
	
	@Test
	void OrthoSquareLinearMasterTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/OrthoSquareLinear.xml"));
		EscapeGameManager emg = egb.makeGameManager();
		// Exercise the game now: make moves, check the board, etc.
		
		//jump over two pieces -> false
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(4, 2)));
		
		//jump over one piece at time -> true
		assertNull(emg.getPieceAt(emg.makeCoordinate(4, 2)));
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(4, 2)));
		assertNotNull(emg.getPieceAt(emg.makeCoordinate(4, 2)));
		emg = egb.makeGameManager();//reset board
		
		//jump over one piece at time, multi times -> true
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(6, 2)));
		
		emg = egb.makeGameManager();//reset board
		//capture enemy piece ->
		assertTrue(emg.move(emg.makeCoordinate(2, 2), emg.makeCoordinate(3, 2)));
		
		emg = egb.makeGameManager();//reset board
		//unblock false -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(1, 3)));
		
		//unblock false -> can't pass over block
		assertFalse(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(1, 4)));
		
		//jump over one piece to then capture enemy piece -> true
	 	assertTrue(emg.move(emg.makeCoordinate(1, 2), emg.makeCoordinate(3, 2)));
		
		emg = egb.makeGameManager();//reset board
		//unblock true -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(3, 2), emg.makeCoordinate(3, 3)));
		
		//unblock true -> can pass over  block
		assertTrue(emg.move(emg.makeCoordinate(3, 2), emg.makeCoordinate(3, 5)));
		
		//jump false -> can't jump
		assertFalse(emg.move(emg.makeCoordinate(2, 7), emg.makeCoordinate(4, 7)));
		
		//Fly -> can't end on block
		assertFalse(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(1, 6)));
		
		//Fly -> can jump many pieces 
	    assertTrue(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(4, 7)));
		
	    emg = egb.makeGameManager();//reset board
	    //Fly -> can't go past distance set (5)
	    assertFalse(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(8, 7)));
	    
	    //Fly -> can go to max distance set (5)
	    assertTrue(emg.move(emg.makeCoordinate(1, 7), emg.makeCoordinate(6, 7)));
	   
	    //Distance -> can't go past distance set (4)
	    assertFalse(emg.move(emg.makeCoordinate(8, 1), emg.makeCoordinate(8, 8)));
	    
	    //Distance -> can go to max distance set (4)
	    assertTrue(emg.move(emg.makeCoordinate(8, 1), emg.makeCoordinate(8, 5)));
	    
	    //Exit removes piece
	    assertNull(emg.getPieceAt(emg.makeCoordinate(8, 5)));
	    
	    //cant do multi directions
	    assertFalse(emg.move(emg.makeCoordinate(8, 1), emg.makeCoordinate(6, 4)));
	    assertFalse(emg.move(emg.makeCoordinate(8, 6), emg.makeCoordinate(4, 5)));
	    assertFalse(emg.move(emg.makeCoordinate(8, 1), emg.makeCoordinate(4, 5)));
	    
	    //can't move diagonal
	    assertFalse(emg.move(emg.makeCoordinate(4, 4), emg.makeCoordinate(8, 8)));
	    
	    emg = egb.makeGameManager();//reset board
	    //can't pass over an exit
	    assertFalse(emg.move(emg.makeCoordinate(10, 1), emg.makeCoordinate(10, 5)));
	    
	    //FLY -> can pass over an exit
	    assertTrue(emg.move(emg.makeCoordinate(9, 1), emg.makeCoordinate(9, 6)));
	    
	}
	
	@Test
	void HexOmniMasterTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/HexOmni.xml"));
		EscapeGameManager emg = egb.makeGameManager();
		// Exercise the game now: make moves, check the board, etc.
		
		//jump over two pieces -> false
		assertFalse(emg.move(emg.makeCoordinate(2, -3), emg.makeCoordinate(2, 0)));
		
		//jump over one piece at time -> true
		assertNull(emg.getPieceAt(emg.makeCoordinate(2, 0)));
		assertTrue(emg.move(emg.makeCoordinate(2, -2), emg.makeCoordinate(2, 0)));
		assertNotNull(emg.getPieceAt(emg.makeCoordinate(2, 0)));
		emg = egb.makeGameManager();//reset board
		
		//jump over one piece at time, multi times -> true
		assertTrue(emg.move(emg.makeCoordinate(2, -2), emg.makeCoordinate(2, 2)));
		
		emg = egb.makeGameManager();//reset board
		//capture enemy piece ->
		assertTrue(emg.move(emg.makeCoordinate(2, -2), emg.makeCoordinate(2, -1)));
		
		emg = egb.makeGameManager();//reset board
		//jump over one piece to then capture enemy piece -> true
	 	assertTrue(emg.move(emg.makeCoordinate(2, -3), emg.makeCoordinate(2, -1)));
		
		emg = egb.makeGameManager();//reset board
		//unblock false -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(2, -3), emg.makeCoordinate(1, -3)));
		
		//unblock false -> can't pass over block
		assertFalse(emg.move(emg.makeCoordinate(2, -3), emg.makeCoordinate(0, -3)));
		
		
		emg = egb.makeGameManager();//reset board
		//unblock true -> can't end on block
		assertFalse(emg.move(emg.makeCoordinate(2, -1), emg.makeCoordinate(3, -1)));
		
		//unblock true -> can pass over  block
		assertTrue(emg.move(emg.makeCoordinate(2, -1), emg.makeCoordinate(0, -1)));
		
		
		//jump false -> can't jump
		assertFalse(emg.move(emg.makeCoordinate(-1, 2), emg.makeCoordinate(-3, 4)));
		
		//Fly -> can't end on block
		assertFalse(emg.move(emg.makeCoordinate(0, 1), emg.makeCoordinate(1, 0)));
		
		//Fly -> can jump many pieces 
	    assertTrue(emg.move(emg.makeCoordinate(0, 1), emg.makeCoordinate(-3, 4)));
		
	    emg = egb.makeGameManager();//reset board
	    
	    //Fly -> can jump block pieces 
	    assertTrue(emg.move(emg.makeCoordinate(0, 1), emg.makeCoordinate(0, -1)));
	    
	    emg = egb.makeGameManager();//reset board
	    
	    //Fly -> can't go past distance set (5)
	    assertFalse(emg.move(emg.makeCoordinate(0, 1), emg.makeCoordinate(-3, 8)));
	    
	    //Fly -> can go to max distance set (5)
	    assertTrue(emg.move(emg.makeCoordinate(0, 1), emg.makeCoordinate(-3, 5)));
	    
	    //Distance -> can't go past distance set (4)
	    assertFalse(emg.move(emg.makeCoordinate(-1, 0), emg.makeCoordinate(-6, 5)));
	    
	    //Distance -> can go to max distance set (4)
	    assertTrue(emg.move(emg.makeCoordinate(-1, 0), emg.makeCoordinate(-5, 0)));
	    //Exit removes piece
	    assertNull(emg.getPieceAt(emg.makeCoordinate(-5, 0)));
	    
	    //can't pass over an exit
	    assertFalse(emg.move(emg.makeCoordinate(0, 1), emg.makeCoordinate(6, 2)));
	    
	    //FLY -> can pass over an exit
	    assertTrue(emg.move(emg.makeCoordinate(0, 3), emg.makeCoordinate(5, 3)));
	}
	
	@Test
	void HexLinearMasterTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/HexLinear.xml"));
		EscapeGameManager emg = egb.makeGameManager();
		// Exercise the game now: make moves, check the board, etc.
		
		//jump over two pieces -> false
		assertFalse(emg.move(emg.makeCoordinate(2, -3), emg.makeCoordinate(2, 0)));
		
		//jump over one piece at time -> true
		assertNull(emg.getPieceAt(emg.makeCoordinate(2, 0)));
		assertTrue(emg.move(emg.makeCoordinate(2, -2), emg.makeCoordinate(2, 0)));
		assertNotNull(emg.getPieceAt(emg.makeCoordinate(2, 0)));
		emg = egb.makeGameManager();//reset board
		
		//jump over one piece at time, multi times -> true
		assertTrue(emg.move(emg.makeCoordinate(2, -2), emg.makeCoordinate(2, 2)));
		
		emg = egb.makeGameManager();//reset board
		//capture enemy piece ->
		assertTrue(emg.move(emg.makeCoordinate(2, -2), emg.makeCoordinate(2, -1)));
		
		emg = egb.makeGameManager();//reset board
		//jump over one piece to then capture enemy piece -> true
	 	assertTrue(emg.move(emg.makeCoordinate(2, -3), emg.makeCoordinate(2, -1)));
		
		emg = egb.makeGameManager();//reset board
		//unblock false -> can't land on block
		assertFalse(emg.move(emg.makeCoordinate(2, -3), emg.makeCoordinate(1, -3)));
		
		//unblock false -> can't pass over block
		assertFalse(emg.move(emg.makeCoordinate(2, -3), emg.makeCoordinate(0, -3)));
		
		
		emg = egb.makeGameManager();//reset board
		//unblock true -> can't end on block
		assertFalse(emg.move(emg.makeCoordinate(2, -1), emg.makeCoordinate(3, -1)));
		
		//unblock true -> can pass over  block
		assertTrue(emg.move(emg.makeCoordinate(2, -1), emg.makeCoordinate(0, -1)));
		
		
		//jump false -> can't jump
		assertFalse(emg.move(emg.makeCoordinate(-1, 2), emg.makeCoordinate(-3, 4)));
		
		//Fly -> can't end on block
		assertFalse(emg.move(emg.makeCoordinate(0, 1), emg.makeCoordinate(1, 0)));
		
		//Fly -> can jump many pieces 
	    assertTrue(emg.move(emg.makeCoordinate(0, 1), emg.makeCoordinate(-3, 4)));
		
	    emg = egb.makeGameManager();//reset board
	    
	    //Fly -> can jump block pieces 
	    assertTrue(emg.move(emg.makeCoordinate(0, 1), emg.makeCoordinate(0, -1)));
	    
	    emg = egb.makeGameManager();//reset board
	    
	    //Fly -> can't go past distance set (5)
	    assertFalse(emg.move(emg.makeCoordinate(0, 1), emg.makeCoordinate(-6, 7)));
	    
	    //Fly -> can go to max distance set (5)
	    assertTrue(emg.move(emg.makeCoordinate(0, 1), emg.makeCoordinate(-5, 6)));
	    
	    //Distance -> can't go past distance set (4)
	    assertFalse(emg.move(emg.makeCoordinate(-1, 0), emg.makeCoordinate(-6, 5)));
	    
	    //Distance -> can go to max distance set (4)
	    assertTrue(emg.move(emg.makeCoordinate(-1, 0), emg.makeCoordinate(-5, 0)));
	    //Exit removes piece
	    assertNull(emg.getPieceAt(emg.makeCoordinate(-5, 0)));
	    
	    //can't pass over an exit
	    assertFalse(emg.move(emg.makeCoordinate(0, 1), emg.makeCoordinate(6, 2)));
	    
	    //FLY -> can pass over an exit
	    assertTrue(emg.move(emg.makeCoordinate(0, 3), emg.makeCoordinate(5, 3)));
	    
	    emg = egb.makeGameManager();//reset board
	    
	    //can't go multi directions
	    assertFalse(emg.move(emg.makeCoordinate(-2, -1), emg.makeCoordinate(-1, 0)));
	    assertFalse(emg.move(emg.makeCoordinate(-2, -1), emg.makeCoordinate(-3, 1)));
	    assertFalse(emg.move(emg.makeCoordinate(-2, -1), emg.makeCoordinate(-3, -2)));
	    assertFalse(emg.move(emg.makeCoordinate(-2, -1), emg.makeCoordinate(-1, -3)));
		
	}
	
	@Test
	void HexChangeDirTest() throws Exception {
		EscapeGameBuilder egb = new EscapeGameBuilder(new File("config/HexChangeDir.xml"));
		EscapeGameManager emg = egb.makeGameManager();
		
		assertFalse(emg.move(emg.makeCoordinate(2, -2), emg.makeCoordinate(4, 0)));
	}
	
}