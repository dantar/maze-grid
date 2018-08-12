package it.dantar.games.maze.grid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MazeGridLayoutServiceTest {

	@Autowired
	MazeGridLayoutService service;
	
	@Test
	public void test() {
		MazeGrid maze = service.mazeGrid(10, 10);
	}

    @SpringBootApplication
    static class TestConfiguration {
    }

}
