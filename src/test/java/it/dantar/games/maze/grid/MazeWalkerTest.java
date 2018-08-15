package it.dantar.games.maze.grid;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MazeWalkerTest {

	MazeWalker walker;

	@Autowired
	ApplicationContext context;
	
	@Before
	public void before() {
		this.walker = context.getBean(MazeWalker.class);
	}
	
	@Test
	public void testWalkableEmptyMaze() {
		MazeGrid maze = new MazeGrid(2, 2);
		final List<MazeRoom> visited = new ArrayList<MazeRoom>();
		walker.walkAllRooms(new MazeMap(maze), new MazeRoom(0, 0), new MazeWalker.RoomVisitor() {
			public void visit(MazeRoom room) {
				visited.add(room);
			}
			public void leave(MazeRoom room) {}
		});
		assertEquals(4, visited.size());
	}

	@Test
	public void testWalkableClosedVisit() {
		MazeGrid maze = new MazeGrid(2, 2);
		maze.addWall(new MazeWall(1, 0));
		maze.addWall(new MazeWall(1, 2));
		final List<MazeRoom> visited = new ArrayList<MazeRoom>();
		walker.walkAllRooms(new MazeMap(maze), new MazeRoom(0, 0), new MazeWalker.RoomVisitor() {
			public void visit(MazeRoom room) {
				visited.add(room);
			}
			public void leave(MazeRoom room) {}
		});
		assertEquals(2, visited.size());
	}
	
	@Test
	public void testWalkableClosedLeave() {
		MazeGrid maze = new MazeGrid(2, 2);
		maze.addWall(new MazeWall(1, 0));
		maze.addWall(new MazeWall(1, 2));
		final List<MazeRoom> visited = new ArrayList<MazeRoom>();
		walker.walkAllRooms(new MazeMap(maze), new MazeRoom(0, 0), new MazeWalker.RoomVisitor() {
			public void visit(MazeRoom room) {}
			public void leave(MazeRoom room) {
				visited.add(room);
			}
		});
		assertEquals(2, visited.size());
	}

	@SpringBootApplication
	static class TestConfiguration {}
	
}

