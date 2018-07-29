package it.dantar.games.maze.grid;

import static org.junit.Assert.*;

import org.junit.Test;

public class MazeBuilderTest {

	@Test
	public void testPrint() {
		MazeGrid maze = new MazeGrid(10, 6);
		MazeBuilder builder = new MazeBuilder(maze);
		builder.build();
		new MazePrinter(maze).print();
	}

	@Test(expected=MazeBuilder.CannotPlaceWallException.class)
	public void testTryWall() {
		MazeGrid maze = new MazeGrid(2, 2);
		MazeBuilder builder = new MazeBuilder(maze);
		builder.addWall(new MazeWall(1, 0));
		builder.addWall(new MazeWall(0, 1));
	}

}
