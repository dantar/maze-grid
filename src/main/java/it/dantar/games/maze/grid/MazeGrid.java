package it.dantar.games.maze.grid;

import java.util.ArrayList;
import java.util.List;

public class MazeGrid {

	private int sizeX;
	private int sizeY;
	private List<MazeWall> walls = new ArrayList<MazeWall>();
	
	public MazeGrid(int sizeX, int sizeY) {
		super();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public List<MazeWall> getWalls() {
		return walls;
	}

	public void setWalls(List<MazeWall> walls) {
		this.walls = walls;
	}

	public void addWall(MazeWall wall) {
		this.walls.add(wall);
	}

	public boolean hasWall(MazeElement mazeWall) {
		return this.walls.contains(mazeWall);
	}

	public void removeWall(MazeElement wall) {
		this.walls.remove(wall);
	}

	public boolean hasRoom(MazeRoom room) {
		return room.getX()>=0 && room.getX()/2<sizeX && room.getY()>=0 && room.getY()/2<sizeY;
	}

	public MazeWall wall(int x, int y) {
		return new MazeWall(x, y);
	}

	public MazeRoom room(int x, int y) {
		return new MazeRoom(x, y);
	}

}
