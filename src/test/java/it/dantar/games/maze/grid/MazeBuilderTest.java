package it.dantar.games.maze.grid;

import org.junit.Test;

public class MazeBuilderTest {

	@Test(expected=MazeBuilder.CannotPlaceWallException.class)
	public void testTryWall() {
		MazeGrid maze = new MazeGrid(2, 2);
		MazeBuilder builder = new MazeBuilder(maze);
		builder.addWall(new MazeWall(1, 0));
		builder.addWall(new MazeWall(0, 1));
	}

}
