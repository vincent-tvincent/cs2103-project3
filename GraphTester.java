import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

/**
 * Test suite for Project 3.
 */
public class GraphTester {
	final GraphSearchEngineImpl searchEngine = new GraphSearchEngineImpl();
	final IMDBGraph graph = new IMDBGraphImpl("Data/testActors.tsv",
			"Data/testMovies.tsv");

	public GraphTester() throws IOException {
	}

	/**
	 * Verifies that there is no shortest path between a specific pair of actors.
	 */
	@Test
//	@Timeout(5)  // 5sec timeout on the test, in case there's a bug during search.
	public void findShortestPathWhenNoneExists () {

	}

	//TODO: write tests..

    //TODO: null node test
	@Test
	public void testNullNode(){
		List<Node> path = searchEngine.findShortestPath(null,null);
		assertNull(path);
	}
	//TODO: no path test
	@Test
	public void testNoPath(){
		List<Node> path = searchEngine.findShortestPath(graph.getActor("Sandy"), graph.getActor("Kris"));
		assertNull(path);
	}
	//TODO: shortest test
	@Test
	public void testShortestPath(){
		List<Node> path = searchEngine.findShortestPath(graph.getActor("Sara"),graph.getActor("Sandy"));
		for(Node n: path){
			System.out.print(n.getName() + " ");
		}

		assertTrue(new Node[]{graph.getActor("Sara"),graph.getMovie("Blah3"), graph.getActor("Sandy")}.equals(path));
	}
	//TODO: same node test
	//TODO: ???
	@Test
	public void test(){
		for(Node n: graph.getActors()){
			System.out.print(n.getName() + " ");
		}
	}
}
