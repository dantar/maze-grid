package it.dantar.games.maze.grid;

import java.util.ArrayList;
import java.util.List;

public class MazeMap {

	MazeGrid maze;
	
	public MazeMap(MazeGrid maze) {
		super();
		this.maze = maze;
	}

	public MazeRoom room(int i, int j) {
		if (isOutOfBounds(i, j))
			throw new OutOfMazeBoundsException();
		return new MazeRoom((i-1)*2, (j-1)*2);
	}

	private boolean isOutOfBounds(int i, int j) {
		return i<1 || i>maze.getSizeX() || j<1 || j > maze.getSizeY();
	}

	class OutOfMazeBoundsException extends RuntimeException {private static final long serialVersionUID = 1L;}

	private void appendIfWithinBounds(List<MazeRoom> rooms, MazeRoom room) {
		if (isWithinBounds(1+room.getX()/2, 1+room.getY()/2)) rooms.add(room);
	}
	
	private boolean isWithinBounds(int i, int j) {
		return !isOutOfBounds(i, j);
	}

	public List<MazeRoom> connectedRooms(MazeRoom room) {
		List<MazeRoom> result = new ArrayList<MazeRoom>();
		if (maze.hasRoom(room.northRoom()) && !maze.hasWall(room.northWall())) result.add(room.northRoom());
		if (maze.hasRoom(room.southRoom()) && !maze.hasWall(room.southWall())) result.add(room.southRoom());
		if (maze.hasRoom(room.eastRoom()) && !maze.hasWall(room.eastWall())) result.add(room.eastRoom());
		if (maze.hasRoom(room.westRoom()) && !maze.hasWall(room.westWall())) result.add(room.westRoom());
		return result ;
	}

	public List<MazeRoom> adjacentRooms(MazeRoom room) {
		List<MazeRoom> result = new ArrayList<MazeRoom>();
		appendIfWithinBounds(result, room.northRoom());
		appendIfWithinBounds(result, room.southRoom());
		appendIfWithinBounds(result, room.eastRoom());
		appendIfWithinBounds(result, room.westRoom());
		return result ;
	}

	public List<MazeWall> walls() {
		List<MazeWall> walls = new ArrayList<MazeWall>();
		for (int i = 1; i <= maze.getSizeX(); i++) {
			for (int j = 1; j <= maze.getSizeY(); j++) {
				MazeRoom room = room(i, j);
				if (maze.hasRoom(room.southRoom()) && !maze.hasWall(room.southWall())) walls.add(room.southWall());
				if (maze.hasRoom(room.eastRoom()) && !maze.hasWall(room.eastWall())) walls.add(room.eastWall());
			}
		}
		return walls;
	};

}
