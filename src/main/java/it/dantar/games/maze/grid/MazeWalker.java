package it.dantar.games.maze.grid;

import java.util.ArrayList;
import java.util.List;

public class MazeWalker {

	private MazeMap map;
	List<MazeRoom> visited = new ArrayList<MazeRoom>();

	public MazeWalker(MazeMap map) {
		super();
		this.map = map;
	}

	public void walkAllRooms(MazeRoom start, RoomVisitor visitor) {
		if (visited.contains(start)) return;
		visitor.visit(start);
		visited.add(start);
		List<MazeRoom> a = map.connectedRooms(start);
		for (MazeRoom mazeRoom : a) {
			walkAllRooms(mazeRoom, visitor);
		}
		visitor.leave(start);
	}

	public interface RoomVisitor {
		public void visit(MazeRoom room);
		public void leave(MazeRoom room);
	}
	
}
