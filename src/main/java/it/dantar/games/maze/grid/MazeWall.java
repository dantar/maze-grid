package it.dantar.games.maze.grid;

public class MazeWall extends MazeElement {

	public MazeWall(int x, int y) {
		super(x, y);
	}

	public MazeRoom getRoomA() {
		int wallX = this.getX();
		int wallY = this.getY();
		if (wallX % 2 == 1) {
			return new MazeRoom(wallX-1, wallY);
		} else {
			return new MazeRoom(wallX, wallY-1);
		}
	}
	
	public MazeRoom getRoomB() {
		int wallX = this.getX();
		int wallY = this.getY();
		if (wallX % 2 == 1) {
			return new MazeRoom(wallX+1, wallY);
		} else {
			return new MazeRoom(wallX, wallY+1);
		}
	}
	
}
