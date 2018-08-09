package it.dantar.games.maze.grid;

public class MazeBuilder {

	private MazeGrid maze;

	public MazeBuilder(MazeGrid grid) {
		super();
		this.maze = grid;
	}

	public void addWall(MazeWall wall) {
		maze.addWall(wall);
		if (!checkFullReach(wall.getRoomA(), wall.getRoomB())) {
			maze.removeWall(wall);
			throw new CannotPlaceWallException();
		};
	}
	
	private boolean checkFullReach(MazeRoom room1, final MazeRoom room2) {
		MazeWalker walker = new MazeWalker(new MazeMap(maze));
		try {
			walker.walkAllRooms(room1, new MazeWalker.RoomVisitor() {
				public void visit(MazeRoom room) {
					if (room.equals(room2)) throw new FoundPathConnectingRooms();
				}
				public void leave(MazeRoom room) {}
			});
		} catch (FoundPathConnectingRooms e) {
			return true;
		}
		return false;
	}

	class CannotPlaceWallException extends RuntimeException {private static final long serialVersionUID = 1L;}
	class FoundPathConnectingRooms extends RuntimeException {private static final long serialVersionUID = 1L;}
	
}
