package it.dantar.games.maze.grid;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class MazeGeneratorService {

	@Autowired
	ApplicationContext context;
	
	public void shuffleMaze(MazeGrid maze) {
		MazeBuilder builder = context.getBean(MazeBuilder.class);
		builder.setMaze(maze);
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

}
