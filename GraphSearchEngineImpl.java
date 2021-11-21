import java.util.*;

/**
 * Implements the GraphSearchEngine interface.
 */
public class GraphSearchEngineImpl implements GraphSearchEngine {
	//private Queue<Node> unvisited;
	//private List<Node> visited  = new LinkedList<>();

	private class Queue<T>{
		private LinkedList<T> items;
		public Queue(T firstItem){
			items = new LinkedList<>();
			items.add(firstItem);
		}
		public boolean contains(T item){
			return items.contains(item);
		}
		public boolean isEmpty(){
			return items.isEmpty();
		}
		public void enqueue(T item){
			items.add(item);
		}
		public T dequeue(){
			return items.removeFirst();
		}
	}

	public GraphSearchEngineImpl () {
	}
//	public List<Node> bfs(List<Node> path,Node start, Node target){
//		if(!visited.isEmpty()){
//			List<Node> currentPath = path;
//			currentPath.add(start);
//			if(start == target){return currentPath;}
//			Node node = unvisited.dequeue();
//			visited.add(node);
//			for(Node n: node.getNeighbors()){
//				if(!visited.contains(n)){
//					unvisited.enqueue(n);
//				}
//				bfs(currentPath, n,target);
//			}
//		}
//		return null;
//	}
	private List<Node> bfs(Node start, Node target){
		ArrayDeque<Node> unvisited = new ArrayDeque<>();
		Map<Node, Node> fund = new HashMap<>();

		unvisited.addLast(start);
		fund.put(start, null);
		while(!unvisited.isEmpty()){
			Node currentNode = unvisited.pollFirst();
			if(currentNode == target) break;
			for(Node n: currentNode.getNeighbors()){
				if(!fund.containsKey(n)){
					unvisited.addLast(n);
					fund.put(n, currentNode);
				}
			}
		}

		List<Node> path = new LinkedList<>();
		path.add(target);
		Node tracker = target;
		while(tracker != null){
			path.add(fund.get(tracker));
		}
		path.add(start);
		return path;
	}

	public List<Node> findShortestPath (Node s, Node t) {
		return bfs(s, t);
	}
}
