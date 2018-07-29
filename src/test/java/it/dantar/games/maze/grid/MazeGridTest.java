package it.dantar.games.maze.grid;

import static org.junit.Assert.*;

import org.junit.Test;

public class MazeGridTest {

	@Test
	public void testInitEmpty() {
		MazeGrid grid = new MazeGrid(2, 2);
		assertFalse(grid.hasWall(new MazeWall(0, 1)));
	}
	
	@Test
	public void testAdd() {
		MazeGrid grid = new MazeGrid(2, 2);
		grid.addWall(new MazeWall(0, 1));
		assertTrue(grid.hasWall(new MazeWall(0, 1)));
	}

	@Test
	public void testRemove() {
		MazeGrid grid = new MazeGrid(2, 2);
		grid.addWall(new MazeWall(0, 1));
		grid.removeWall(new MazeWall(0, 1));
		assertFalse(grid.hasWall(new MazeWall(0, 1)));
	}

}
