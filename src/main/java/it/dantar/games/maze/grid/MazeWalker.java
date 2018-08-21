package it.dantar.games.maze.grid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MazeWalker {

	List<MazeRoom> visited = new ArrayList<MazeRoom>();

	public MazeWalker() {
		super();
	}
	
	public void walkAllRooms(MazeMap map, MazeRoom start, RoomVisitor visitor) {
		if (visited.contains(start)) return;
		visitor.visit(start);
		visited.add(start);
		List<MazeRoom> a = map.connectedRooms(start);
		for (MazeRoom mazeRoom : a) {
			walkAllRooms(map, mazeRoom, visitor);
		}
		visitor.leave(start);
	}

	public interface RoomVisitor {
		public class AbortVisit extends RuntimeException {
			/**
			 * Default serial version UID
			 */
			private static final long serialVersionUID = 1L;}
		public void visit(MazeRoom room);
		public void leave(MazeRoom room);
	}
	
}
