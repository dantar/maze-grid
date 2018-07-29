package it.dantar.games.maze.grid;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class MazeMapTest {

	@Test
	public void testAdjacentRooms22() {
		MazeGrid grid = new MazeGrid(3, 3);
		MazeMap map = new MazeMap(grid);
		MazeRoom room = map.room(2, 2);
		List<MazeRoom> rooms = map.adjacentRooms(room);
		assertEquals(4, rooms.size());
		assertTrue(rooms.contains(room.northRoom()));
		assertTrue(rooms.contains(room.southRoom()));
		assertTrue(rooms.contains(room.eastRoom()));
		assertTrue(rooms.contains(room.westRoom()));
	}

	@Test
	public void testAdjacentRooms11() {
		MazeGrid grid = new MazeGrid(3, 3);
		MazeMap map = new MazeMap(grid);
		MazeRoom room = map.room(1, 1);
		List<MazeRoom> rooms = map.adjacentRooms(room);
		assertEquals(2, rooms.size());
		assertTrue(rooms.contains(room.southRoom()));
		assertTrue(rooms.contains(room.eastRoom()));
	}

	@Test
	public void testAdjacentRooms33() {
		MazeGrid grid = new MazeGrid(3, 3);
		MazeMap map = new MazeMap(grid);
		MazeRoom room = map.room(3, 3);
		List<MazeRoom> rooms = map.adjacentRooms(room);
		assertEquals(2, rooms.size());
		assertTrue(rooms.contains(room.northRoom()));
		assertTrue(rooms.contains(room.westRoom()));
	}

	@Test
	public void testConnectionsEmptyMaze() {
		MazeGrid maze = new MazeGrid(2, 2);
		MazeMap map = new MazeMap(maze);
		List<MazeRoom> connections = map.connectedRooms(new MazeRoom(0, 0));
		assertEquals(2, connections.size());
		assertTrue(connections.contains(new MazeRoom(2, 0)));
		assertTrue(connections.contains(new MazeRoom(0, 2)));
	}

	@Test
	public void testAllWalls() {
		MazeGrid grid = new MazeGrid(2, 2);
		MazeMap map = new MazeMap(grid);
		List<MazeWall> walls = map.walls();
		assertEquals(4, walls.size());
		assertTrue(walls.contains(map.room(1, 1).southWall()));
		assertTrue(walls.contains(map.room(1, 1).eastWall()));
		assertTrue(walls.contains(map.room(2, 2).northWall()));
		assertTrue(walls.contains(map.room(2, 2).westWall()));
	}

}
