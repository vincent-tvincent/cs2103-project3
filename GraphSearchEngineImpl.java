import java.util.*;

/**
 * Implements the GraphSearchEngine interface.
 */
public class GraphSearchEngineImpl implements GraphSearchEngine {
	/**
	 * appling breadth first search to an given node and return the shortest path from this node to the target node
	 * @param start the node which the searching start from
	 * @param target the target node which is searched for
	 * @return a linkedList which contain the nodes on the shortest path from the start node to the target node
	 */
	private List<Node> bfs(Node start, Node target){
		ArrayDeque<Node> unvisited = new ArrayDeque<>(); //the queue of the nodes await to be visited
		Map<Node, Node> found = new HashMap<>(); // the nodes been found by the bfs search and their parent nodes,
												 // they will be put in in format <this node, this node's parent>

		//initialize the first node
		unvisited.addLast(start);
		found.put(start, null);

		// do bfs on current node
		while(!unvisited.isEmpty()){
			Node currentNode = unvisited.pollFirst();
			if(currentNode == target) break;
			// match the nodes been visited with their parent nodes
			for(Node n: currentNode.getNeighbors()){
				if(!found.containsKey(n)){
					unvisited.addLast(n);
					found.put(n, currentNode);
				}
			}
		}
		//trace back from the target to the start
		List<Node> path = new LinkedList<>();
		Node tracker = target;
		while(tracker != null){
			path.add(tracker);
			tracker = found.get(tracker);
		}

		// reverse
		if(path.get(path.size() -1) != start) {
			path = null;
		} else {
			Collections.reverse(path);
		}
		return path;
	}

	/**
	 * return the shortest path from start node to target node by specific algorithm or return null if this path does not exist
	 * @param s the start node.
	 * @param t the target node.
	 * @return a linkList object which contain the nodes on the shortest path from the start node to the target node
	 */
	public List<Node> findShortestPath (Node s, Node t) {
		if(s == null || t == null){
			return null;
		}else return bfs(s,t);
	}
}
