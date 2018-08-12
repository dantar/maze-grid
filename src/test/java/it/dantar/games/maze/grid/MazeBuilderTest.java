package it.dantar.games.maze.grid;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MazeBuilderTest {

	MazeBuilder builder;
	
	@Autowired
	ApplicationContext context;
	
	@Before
	public void testPrototype() {
		this.builder = context.getBean(MazeBuilder.class);
	}
	
	@Test(expected=MazeBuilder.CannotPlaceWallException.class)
	public void testTryWall() {
		MazeGrid maze = new MazeGrid(2, 2);
		builder.setMaze(maze);
		builder.addWall(new MazeWall(1, 0));
		builder.addWall(new MazeWall(0, 1));
	}

    @SpringBootApplication
	static class TestContext {}
	
}
