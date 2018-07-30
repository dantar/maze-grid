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
		int wallX = wall.getX();
		int wallY = wall.getY();
		MazeRoom room1;
		MazeRoom room2;
		if (wallX % 2 == 1) {
			room1 = new MazeRoom(wallX-1, wallY);
			room2 = new MazeRoom(wallX+1, wallY);
		} else {
			room1 = new MazeRoom(wallX, wallY-1);
			room2 = new MazeRoom(wallX, wallY+1);
		}
		maze.addWall(wall);
		if (!checkFullReach(room1, room2)) {
			maze.removeWall(wall);
			throw new CannotPlaceWallException();
		};
	}
	
	private boolean checkFullReach(MazeRoom room1, final MazeRoom room2) {
		MazeWalker walker = new MazeWalker(new MazeMap(maze));
		try {
			walker.walkAllRooms(room1, new MazeWalker.RoomVisitor() {
				public void visit(MazeRoom room) {
					if (room.equals(room2)) throw new FoundPathConnectingRooms();
				}
				public void leave(MazeRoom room) {}
			});
		} catch (FoundPathConnectingRooms e) {
			return true;
		}
		return false;
	}

	class CannotPlaceWallException extends RuntimeException {private static final long serialVersionUID = 1L;}
	class FoundPathConnectingRooms extends RuntimeException {private static final long serialVersionUID = 1L;}
	
}
