package assignment52210;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


/**
 * 
 * @author aaronsarkar and oby bkkourh 
 * student# 251146627 and 251074890
 *
 */
public class MyGraph implements Graph {
	// you will need some private fields to represent the graph
	// you are also likely to want some private helper methods

	// YOUR CODE HERE
	
	/**
	 * Set to stored those edges in an adject way.
	 */
	private Map<Vertex, Set<Edge>> Graph;

	/** set edges. */
	private Set<Edge> Eds;
	
	/** set vertexes. */
	private Set<Vertex> Vert;

	

	/**
	 * create the edges for the graph 
	 * 
	 * @param ver a collection of the vertices in this graph
	 * @param ed a collection of the edges in this graph
	 * @exception IllegalArgumentException if either of input collections are empty or null.
	 */
	public MyGraph(Collection<Vertex> ver, Collection<Edge> ed) {
		
		if (ver == null) 
			if(ed == null) {
			throw new IllegalArgumentException();
		}

		// YOUR CODE HERE
		Graph = new HashMap<Vertex, Set<Edge>>();
		Vert = new HashSet<Vertex>();
		Eds = new HashSet<Edge>();
		

		
		

		// put all the vertex into myGraphs with new a set of edges.
		for (Vertex vertex : ver) {
			Graph.put(vertex, new HashSet<Edge>());
		}
		
		for(Vertex vertex: ver){
			Vert.add(vertex);
		}

		/*
		 * check the edges, If the edges are appropriate then add into myGraps
		 * and collection of edges.
		 */
		check_Ed(ed);


	}
	

	

	/**
	 * Return the collection of edges of this graph.
	 * 
	 * @return the edges as a collection (which is anything iterable)
	 */
	@Override
	public Collection<Edge> edges() {
		// YOUR CODE HERE
		return Eds;

	}
	
	/**
	 * Return the collection of vertices of this graph.
	 * 
	 * @return the vertices as a collection (which is anything iterable)
	 */
	@Override
	public Collection<Vertex> vertices() {
		// YOUR CODE HERE
		return Vert;

	}
	

	/**
	 * Return a collection of vertices adjacent to a given vertex v. i.e., the
	 * set of all vertices w where edges v -> w exist in the graph. Return an
	 * empty collection if there are no adjacent vertices.
	 * 
	 * @param ver
	 *            one of the vertices in the graph
	 * @return an iterable collection of vertices adjacent to v in the graph
	 * @throws IllegalArgumentException
	 *             if v does not exist.
	 */
	@Override
	public Collection<Vertex> adjacentVertices(Vertex ver) {

		// YOUR CODE HERE
		
		// Using a set to avoid duplicates
				Set<Vertex> Adjacent_V = new HashSet<Vertex>();
				
		// If v does not exist.
		if (!Graph.containsKey(ver)) {
			throw new IllegalArgumentException();
		}

		

		//  find all adjacent vertices 
		for (Edge edge : Graph.get(ver)) {

			
			Adjacent_V.add(edge.getDestination());
		}
		return Adjacent_V;
	}

	/**
	 * Test whether vertex b is adjacent to vertex a (i.e. a -> b) in a directed
	 * graph. Assumes that we do not have negative cost edges in the graph.
	 * 
	 * @param a
	 *            one vertex
	 * @param b
	 *            another vertex
	 * @return cost of edge if there is a directed edge from a to b in the
	 *         graph, return -1 otherwise.
	 * @throws IllegalArgumentException
	 *             if a or b do not exist.
	 */
	@Override
	public int edgeCost(Vertex a, Vertex b) {

		// YOUR CODE HERE
		// If a or b do not exist, throw an exception.
		if (!Graph.containsKey(a) || !Graph.containsKey(b)) {
			throw new IllegalArgumentException();
		}
		int theWeight = -1;
		for (Edge edge : Graph.get(a)) {
			// if the Vertex that is the destination of the edge is equal to b
			if (edge.getDestination().equals(b)) {
				theWeight = edge.getWeight();
			}
		}
		return theWeight;
	}

	/**
	 * Returns the shortest path from a to b in the graph, or null if there is
	 * no such path. Assumes all edge weights are nonnegative. Uses Dijkstra's
	 * algorithm.
	 * 
	 * @param a
	 *            the starting vertex
	 * @param b
	 *            the destination vertex
	 * @return a Path where the vertices indicate the path from a to b in order
	 *         and contains a (first) and b (last) and the cost is the cost of
	 *         the path. Returns null if b is not reachable from a.
	 * @throws IllegalArgumentException
	 *             if a or b does not exist.
	 */
	public Path shortestPath(Vertex a, Vertex b) {

		// YOUR CODE HERE 
		
		
		//If vertices dont are not there then return exeption 
		if (!Graph.containsKey(a) )
			if(!Graph.containsKey(b)) {
			throw new IllegalArgumentException();
		}
		
		List<Vertex> vert = new ArrayList<Vertex>();
		
		//if it is edge then it is 0
		if(a.equals(b)){
			vert.add(a);
			return new Path(vert,0);
		}
		
		//loop for each vertex
		for(Vertex vertex: vertices()){
			vertex.change_cost(Integer.MAX_VALUE);

			vertex.change_status(false);
		}

		PriorityQueue<Vertex> mQ_v =new PriorityQueue<Vertex>();
		// Set to the start of cost 
		a.change_cost(0);
		mQ_v.add(a);
		
		// Build_heap with all vertexes
		while(!mQ_v.isEmpty()){  // heap is not empty
			Vertex target = mQ_v.poll(); // smallest cost.
			target.change_status(true); // Set known.
			
			//find each adjecent Vertex
			for(Vertex adjacent_Vertice : this.adjacentVertices(target)){
				//add them to the list if found 
				for(Vertex vertex: vertices()){
					if(vertex.equals(adjacent_Vertice)){
						adjacent_Vertice =vertex;
						break;
					}
				}
				// If not found 
				if(!adjacent_Vertice.get_Status()){
					int newCost=target.get_Cost()+edgeCost(target,adjacent_Vertice);
					int oldCost=adjacent_Vertice.get_Cost();

					if(newCost<oldCost){
						// update it
						mQ_v.remove(adjacent_Vertice);
						adjacent_Vertice.change_cost(newCost);
						adjacent_Vertice.upwardPath(target);
						mQ_v.add(adjacent_Vertice);

						
						// check b
						if(adjacent_Vertice.equals(b)){
							b.change_cost(adjacent_Vertice.get_Cost());
							b.upwardPath(adjacent_Vertice.get_Path());
						}
					}
				}
			}			
		}
		
		
		List<Vertex> final_ans = new ArrayList<Vertex>();
		final_ans.add(b);
		Vertex node_v = b;
		
		
		while(node_v.get_Path()!=null){
			final_ans.add(node_v.get_Path());
			node_v= node_v.get_Path();
		}
		
		
		Collections.reverse(final_ans);
		return new Path(final_ans, b.get_Cost());
	}

	/**
	 * The is a helper method to check edges. If the edges are appropriate then
	 * add into myGraps and collection of edges.
	 * 
	 * @param theE
	 *            a collection of the edges in this graph.
	 * @throws IllegalArgumentException
	 *             If edge weights is negative, the edges involve vertices
	 *             without labels, or the same directed edge more than once with
	 *             a different weight.
	 * 
	 */
	private void check_Ed(Collection<Edge> theE) {
		for (Edge Edg : theE) {

			
			// check edge if negative
						if (Edg.getWeight() <= -1) {
							throw new IllegalArgumentException("edge " + Edg.getSource() + "'s weight is not there.");
						}
			
			//check if vetix 
			if (!Graph.containsKey(Edg.getSource()))
				if(!Graph.containsKey(Edg.getDestination())) {
				throw new IllegalArgumentException("edge " + Edg.getSource() + " is not in there.");
			}

			

			
			for (Edge thatE : theE) {
				if (Edg.getSource().equals(thatE.getSource())
						&& Edg.getWeight() != thatE.getWeight()&& Edg.getDestination().equals(thatE.getDestination())) {
					throw new IllegalArgumentException();
				}
				Eds.add(Edg);
				Graph.get(Edg.getSource()).add(Edg);
			}
		}
	}
	
	@Override
	public String toString() {
		return Graph.toString();
	}
	

}
