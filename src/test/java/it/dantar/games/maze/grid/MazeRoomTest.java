package it.dantar.games.maze.grid;

import static org.junit.Assert.*;

import org.junit.Test;

public class MazeRoomTest {

	@Test
	public void testNorth() {
		MazeRoom room = new MazeRoom(2, 2).northRoom();
		assertEquals(2, room.getX());
		assertEquals(0, room.getY());
	}
	@Test
	public void testSouth() {
		MazeRoom room = new MazeRoom(2, 2).southRoom();
		assertEquals(2, room.getX());
		assertEquals(4, room.getY());
	}
	@Test
	public void testEast() {
		MazeRoom room = new MazeRoom(2, 2).eastRoom();
		assertEquals(4, room.getX());
		assertEquals(2, room.getY());
	}
	@Test
	public void testWest() {
		MazeRoom room = new MazeRoom(2, 2).westRoom();
		assertEquals(0, room.getX());
		assertEquals(2, room.getY());
	}

	@Test
	public void testWallToNorth() {
		MazeRoom room = new MazeRoom(2, 2);
		assertEquals(room.wallTo(room.northRoom()), room.northWall());
	}
	
	@Test
	public void testWallToSouth() {
		MazeRoom room = new MazeRoom(2, 2);
		assertEquals(room.wallTo(room.southRoom()), room.southWall());
	}

	@Test
	public void testWallToEast() {
		MazeRoom room = new MazeRoom(2, 2);
		assertEquals(room.wallTo(room.eastRoom()), room.eastWall());
	}
	
	@Test
	public void testWallToWest() {
		MazeRoom room = new MazeRoom(2, 2);
		assertEquals(room.wallTo(room.westRoom()), room.westWall());
	}
	
}
