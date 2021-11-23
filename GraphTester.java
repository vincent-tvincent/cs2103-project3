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


	@Test
	public void testNullStartNode(){
		List<Node> path = searchEngine.findShortestPath(null,graph.getActor("Kris"));
		assertNull(path);
	}

	@Test
	public void testNullTargetNode(){
		List<Node> path = searchEngine.findShortestPath(graph.getActor("Kris"),null);
		assertNull(path);
	}

	@Test
	// test the nodes with no path between them
	public void testNoPath(){
		List<Node> path = searchEngine.findShortestPath(graph.getActor("Sandy"), graph.getActor("rua?"));
		assertNull(path);
	}

	@Test
	// test if findShortestPath return the shortest path between two nodes
	public void testShortestPath(){
		List<Node> path = searchEngine.findShortestPath(graph.getActor("Kris"),graph.getActor("Gampel"));
		for(Node n: path){
			System.out.print(n.getName() + " ");
		}

		assertTrue(path.size() == 3);
	}

	@Test
	// test the path between two same nodes (should be null)
	public void sameNodeTest(){
		List<Node> path = searchEngine.findShortestPath(graph.getActor("Kris"),graph.getActor("Kris"));
		assertTrue(path == null);
	}
}
