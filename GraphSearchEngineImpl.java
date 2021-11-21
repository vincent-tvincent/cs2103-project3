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
		return bfs(s, t);
	}

	private List<Node> bfs(Node s, Node t) {
		List<Node> queue = new ArrayList<>();
		List<Node> visited = new ArrayList<>();
		Map<Node, Node> parents = new HashMap<>();
		boolean targetFound = false;

		queue.add(s);

		if(s == t) {
			return queue;
		}

		while (!queue.isEmpty() && !targetFound) {
			Node first = queue.get(0);
			queue.remove(0);
			visited.add(first);
			for (Node n : first.getNeighbors()) {
				if(!visited.contains(n)) {
					queue.add(n);
					parents.put(n, first);
					if(n == t) {
						targetFound = true;
						break;
					}
				}
			}
		}
		return getPath(s, t, parents);
	}

	private List<Node> getPath(Node s, Node t, Map<Node, Node> parents) {
		List<Node> path = new ArrayList<>();
		Node prev = parents.get(t);
		while(prev != null) {
			path.add(prev);
			System.out.println("Path: " + prev.getName());
			prev = parents.get(prev);
		}

		// check that the path connects s and t

		if(path != null) {
			Collections.reverse(path);
		}

		return path;
	}
}
