import java.util.*;

/**
 * Implements the GraphSearchEngine interface.
 */
public class GraphSearchEngineImpl implements GraphSearchEngine {
	private Queue<Node> unvisited;
	private List<Node> visited  = new LinkedList<>();

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
	public List<Node> bfs(Node start, Node target){
		return null;
	}
	public List<Node> findShortestPath (Node s, Node t) {
		return ;  // TODO implement me.
	}
}
