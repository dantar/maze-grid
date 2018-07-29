package it.dantar.games.maze.grid;

import java.io.Reader;
import java.util.ArrayList;

import com.opencsv.CSVReader;

public class MazeFile {

	private MazeGrid maze;

	public MazeFile(MazeGrid maze) {
		super();
		this.maze = maze;
	}

	public void loadMaze(Reader reader) {
		maze.setWalls(new ArrayList<MazeWall>());
		CSVReader csv = new CSVReader(reader);
//		csv.
//		maze.addWall(wall);
	}
	
}
