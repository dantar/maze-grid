package it.dantar.games.maze.grid;

public class MazePrinter {

	static final String WALL=" ";
	static final String DOOR="#";
	static final String ROOM="2";
	static final String CR="\n";
	
	MazeGrid maze;
	
	public MazePrinter(MazeGrid maze) {
		super();
		this.maze = maze;
	}

	void print() {
		p("   ");
		fullLine();
		for (int y = 0; y < maze.getSizeY()-1; y++) {
			p("%02d ", y*2);
			roomLine(y*2);
			p("%02d ", y*2+1);
			doorLine(y*2+1);
		}
		p("%02d ", (maze.getSizeY()-1)*2);
		roomLine((maze.getSizeY()-1)*2);
		p("   ");
		fullLine();
	}

	private void roomLine(int line) {
		p(WALL);
		for (int i = 0; i < maze.getSizeX()-1; i++) {
			r(i*2, line);
//			p(ROOM);
			if (maze.hasWall(new MazeWall(i*2+1, line))) p(WALL);
			else p(DOOR);
		}
		r((maze.getSizeX()-1)*2, line);
//		p(ROOM);
		p(WALL);
		p(CR);
	}

	private void r(int x, int y) {
		MazeMap map = new MazeMap(maze);
		int exits = map.connectedRooms(new MazeRoom(x, y)).size();
		p("%s", exits==2 ? ROOM: exits);
	}

	private void doorLine(int line) {
		p(WALL);
		for (int i = 0; i < maze.getSizeX(); i++) {
			if (maze.hasWall(new MazeWall(i*2, line))) p(WALL);
			else p(DOOR);
			p(WALL);
		}
		p(CR);
	}

	private void fullLine() {
		for (int i = 0; i < maze.getSizeX()*2+1; i++) {
			p(WALL);
		}
		p(CR);
	}

	private void p(String what, Object... args) {
		System.out.print(String.format(what, args));
	}
	
}
