package it.dantar.games.maze.grid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MazeGeneratorServiceTest {

	@Autowired
	MazeGeneratorService service;
	
	@Test
	public void test() {
		MazeGrid maze = new MazeGrid(5, 5);
		service.shuffleMaze(maze);
	}

	@SpringBootApplication
	static class TestConfiguration {
		
	}
	
}
