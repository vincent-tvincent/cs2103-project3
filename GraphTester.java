import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
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
		assertTrue(path == null);
	}
	//TODO: no path test
	@Test
	public void testNoPath(){

	}
	//TODO: shortest test
	//TODO: same node test
	//TODO: ???
}
