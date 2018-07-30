package it.dantar.games.maze.grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazeBuilder {

	private MazeGrid maze;
	private List<MazeWall> allWalls = new ArrayList<MazeWall>();

	public MazeBuilder(MazeGrid grid) {
		super();
		this.maze = grid;
		for (int x = 0; x < maze.getSizeX(); x++) {
			for (int y = 0; y < maze.getSizeY(); y++) {
				if (x<maze.getSizeX()-1) this.allWalls.add(new MazeWall(x*2+1, y*2));
				if (y<maze.getSizeY()-1) this.allWalls.add(new MazeWall(x*2, y*2+1));
			}
		}
	}

	public void build() {
		Collections.shuffle(allWalls);
		for (int i = 0; i < allWalls.size() /2; i++) {
			maze.addWall(allWalls.get(i));
		}
	}

	public void addWall(MazeWall wall) {
		maze.addWall(wall);
		if (!checkFullReach()) {
			maze.removeWall(wall);
			throw new CannotPlaceWallException();
		};
	}
	
	private boolean checkFullReach() {
		MazeWalker walker = new MazeWalker(new MazeMap(maze));
		final List<MazeRoom> visited = new ArrayList<MazeRoom>();
		walker.walkAllRooms(new MazeRoom(0, 0), new MazeWalker.RoomVisitor() {
			public void visit(MazeRoom room) {
				visited.add(room);
			}
			public void leave(MazeRoom room) {}
		});
		return visited.size() == maze.getSizeX()*maze.getSizeY();
	}

	class CannotPlaceWallException extends RuntimeException {private static final long serialVersionUID = 1L;}
	
}
