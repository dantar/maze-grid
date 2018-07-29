package it.dantar.games.maze.grid;

import static org.junit.Assert.*;

import org.junit.Test;

public class MazePrinterTest {

	@Test
	public void test() {
		MazeGrid maze = new MazeGrid(2, 2);
		maze.addWall(new MazeWall(2,1));
		MazePrinter printer = new MazePrinter(maze);
		printer.print();
	}

}
