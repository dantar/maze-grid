package it.dantar.games.maze.grid;

import org.springframework.stereotype.Service;

@Service
public class MazeGridLayoutService {

	public MazeGrid mazeGrid(int sizeX, int sizeY) {
		return new MazeGrid(sizeX, sizeY);
	}


}
