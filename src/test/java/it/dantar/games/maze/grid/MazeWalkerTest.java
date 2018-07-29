package it.dantar.games.maze.grid;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MazeWalkerTest {

	@Test
	public void testWalkableEmptyMaze() {
		MazeGrid maze = new MazeGrid(2, 2);
		MazeWalker walker = new MazeWalker(new MazeMap(maze));
		final List<MazeRoom> visited = new ArrayList<MazeRoom>();
		walker.walkAllRooms(new MazeRoom(0, 0), new MazeWalker.RoomVisitor() {
			public void visit(MazeRoom room) {
				visited.add(room);
			}
		});
		assertEquals(4, visited.size());
	}

	@Test
	public void testWalkableClosed() {
		MazeGrid maze = new MazeGrid(2, 2);
		maze.addWall(new MazeWall(1, 0));
		maze.addWall(new MazeWall(1, 2));
		MazeWalker walker = new MazeWalker(new MazeMap(maze));
		final List<MazeRoom> visited = new ArrayList<MazeRoom>();
		walker.walkAllRooms(new MazeRoom(0, 0), new MazeWalker.RoomVisitor() {
			public void visit(MazeRoom room) {
				visited.add(room);
			}
		});
		assertEquals(2, visited.size());
	}

}

