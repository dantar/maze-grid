package it.dantar.games.maze.grid;

public class MazeElement {

	protected int x;
	protected int y;

	public MazeElement() {
		super();
	}
	
	public MazeElement(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MazeElement other = (MazeElement) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}