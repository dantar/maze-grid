package it.dantar.games.maze.grid;

import java.util.Collections;
import java.util.List;

public class MazeGenerator {

	MazeGrid maze;

	public MazeGenerator(MazeGrid maze) {
		super();
		this.maze = maze;
		MazeBuilder builder = new MazeBuilder(maze);
		List<MazeWall> walls = new MazeMap(maze).walls();
		Collections.shuffle(walls);
		for (MazeWall wall : walls) {
			try {
				builder.addWall(wall);
				System.out.print(".");
			} catch (MazeBuilder.CannotPlaceWallException e) {
				System.out.print("!");
			}
		}
		System.out.println("ok");
	}

	public static void main(String[] args) {
		MazeGenerator generator = new MazeGenerator(new MazeGrid(20, 20));
		MazePrinter printer = new MazePrinter(generator.getMaze());
		printer.print();
	}

	public MazeGrid getMaze() {
		return maze;
	}
	
	
}
