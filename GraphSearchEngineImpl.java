import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

/**
 * Implements the GraphSearchEngine interface.
 */
public class GraphSearchEngineImpl implements GraphSearchEngine {

	public GraphSearchEngineImpl () {
	}

	public List<Node> findShortestPath (Node s, Node t) {
		if(s == null || t == null) return null;
		return bfs(s, t);
	}

	private List<Node> bfs(Node s, Node t) {
		ArrayDeque<Node> queue = new ArrayDeque<>();
		Map<Node, Node> visited = new HashMap<>();

		queue.addFirst(s);
		visited.put(s, null);
		while(!queue.isEmpty()) {
			Node first = queue.pollFirst();
			if(first == t) break;
			for(Node n : first.getNeighbors()) {
				if(!visited.containsKey(n)) {
					queue.addLast(n);
					visited.put(n, first);
				}
			}
		}

		// review connections to create shortest path
		List<Node> path = new LinkedList<>();
		path.add(t);
		Node prev = visited.get(t);
		while(prev != null) {
			path.add(prev);
			prev = visited.get(prev);
		}

		// if we did not connect back to s we do not have a path
		if(path.get(path.size() - 1) != s) {
			path = null;
		} else {
			Collections.reverse(path);
		}

		return path;
	}
}
