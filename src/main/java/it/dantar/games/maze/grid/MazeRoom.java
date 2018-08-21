package it.dantar.games.maze.grid;

public class MazeRoom extends MazeElement {

	public MazeRoom(int x, int y) {
		super(x, y);
	}

	public MazeRoom northRoom() {
		return new MazeRoom(getX(), getY()-2);
	}

	public MazeRoom southRoom() {
		return new MazeRoom(getX(), getY()+2);
	}
	
	public MazeRoom eastRoom() {
		return new MazeRoom(getX()+2, getY());
	}
	
	public MazeRoom westRoom() {
		return new MazeRoom(getX()-2, getY());
	}
	
	public MazeWall northWall() {
		return new MazeWall(getX(), getY()-1);
	}

	public MazeWall southWall() {
		return new MazeWall(getX(), getY()+1);
	}
	
	public MazeWall eastWall() {
		return new MazeWall(getX()+1, getY());
	}
	
	public MazeWall westWall() {
		return new MazeWall(getX()-1, getY());
	}

	public MazeWall wallTo(MazeRoom next) {
		if (this.northRoom().equals(next)) return this.northWall();
		if (this.southRoom().equals(next)) return this.southWall();
		if (this.eastRoom().equals(next)) return this.eastWall();
		if (this.westRoom().equals(next)) return this.westWall();
		throw new RuntimeException("rooms are not connected");
	}
	
}
