package assignment52210;

import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

/**
 * 
 * @author aaronsarkar and oby bkkourh 
 * student# 251146627 and 251074890
 *
 */

public class TestGraph {
	//this main fucntion to test our program 
	public static void main(String[] args) {
    
	    //this shows the results of AVA to MGH
	    System.out.println("**Tests two paths with equal weight**");
		MyGraph graph1 = tester(new String[] {"AVA", "EEB", "HUB", "MGH"}, new String[] {"AVA", "EEB", "3", "AVA", "HUB", "3", "EEB", "MGH", "1", "HUB", "MGH", "1"});
		Test_the_graph(new Vertex("AVA"), new Vertex("MGH"), graph1); 
	    	    
		//this shows the results of AVA to MGH
	    System.out.println("**Tests two paths with different weights**");
		MyGraph graph2 = tester(new String[] {"AVA", "EEB", "HUB", "MGH"}, new String[] {"AVA", "EEB", "3", "AVA", "HUB", "3", "EEB", "MGH", "1", "HUB", "MGH", "9"});
		Test_the_graph(new Vertex("AVA"), new Vertex("MGH"), graph2); 
		
	    //this shows the results of AVA to MGH which is 0
	    System.out.println("**Tests self-edge vertex**");
		MyGraph graph3 = tester(new String[] {"AVA", "EEB"}, new String[] {"AVA", "EEB", "3", "AVA", "AVA", "4"});
		Test_the_graph(new Vertex("AVA"), new Vertex("AVA"), graph3);
	    
		//if it is not there
	    System.out.println("**Tests an non-existing edge**");
		MyGraph graph4 = tester(new String[] {"AVA", "EEB", "HUB"}, new String[] {"AVA", "EEB", "3", "EEB", "HUB", "1"});
		Test_the_graph(new Vertex("HUB"), new Vertex("AVA"), graph4); 
		
	    // to chech edges 
	    System.out.println("Given 4 vertices: AVA, EEB, HUB, MGH");
	    Collection<Vertex> v = new HashSet<Vertex>();
	    Collection<Edge> e = new HashSet<Edge>();
	    
	    Vertex A = new Vertex("AVA");
	    Vertex B = new Vertex("EEB");
	    Vertex C = new Vertex("HUB");
	    Vertex D = new Vertex("MGH");
	    
	    Edge a = new Edge(A, B, 15);
		Edge b = new Edge(A, C, 20);
		Edge c = new Edge(A, D, 3);
		Edge d = new Edge(D, B, 5);
		Edge f = new Edge(B, C, 9);
			
		e.add(a); e.add(b); e.add(c); e.add(d); e.add(f);
		v.add(A); v.add(B); v.add(C); v.add(D);
		
		MyGraph graph5 = new MyGraph(v, e);
		
		Collection<Edge> ed = graph5.edges();
		Collection<Vertex> vr = graph5.vertices();
		
		Path path = graph5.shortestPath(A, B);
		
		// chech adj_ver	
		System.out.println("Adjacent vertices of AVA: "+ graph5.adjacentVertices(A));
		System.out.println("How many adjacent vertices of AVA: "+ graph5.adjacentVertices(A).size() + " vertice(s)");	
		
		System.out.println("Adjacent vertices of MGH: "+ graph5.adjacentVertices(D));
		System.out.println("How many adjacent vertices of MGH: "+ graph5.adjacentVertices(D).size() + " vertice(s)");
		
		System.out.println("Adjacent vertices of HUB: "+ graph5.adjacentVertices(C));
		System.out.println("How many adjacent vertices of HUB: "+ graph5.adjacentVertices(C).size() + " vertice(s)");
				
		System.out.println("Adjacent vertices of EEB: "+ graph5.adjacentVertices(B));
		System.out.println("How many adjacent vertices of EEB: "+ graph5.adjacentVertices(B).size() + " vertice(s)");		
		
		System.out.println("Shortest path: " + path.vertices);
		System.out.println("Smallest cost: " + graph5.edgeCost(A, B));
		
		// test vetex 
		System.out.println("Size of the graph: "+ vr.size());
		System.out.println("Edges are: "+ ed);
	}
	
	
	
	//to test the graph build 
	public static MyGraph graph_test(String[] inputVertex, String[] inputEdge) {
		
		Collection<Edge> edg = new ArrayList<Edge>();
		
		for (int count = 0; count < inputEdge.length; count = count + 3) {
			
			Vertex first = new Vertex(inputEdge[count + 1]);
			
			
			Vertex second = new Vertex(inputEdge[count]);
			
			int all = Integer.parseInt(inputEdge[count + 2]);
			
			edg.add(new Edge(second,first,all));
		}
		
		Collection<Vertex> the_vert = new ArrayList<Vertex>();
		
		for (int j = 0; j < inputVertex.length; j++) {
			the_vert.add(new Vertex(inputVertex[j]));
		}
		
		return new MyGraph(the_vert, edg); 
	}
//	
public static void Test_the_graph(Vertex a, Vertex b, MyGraph g) {
		
		Path path_1 = g.shortestPath(a, b);
		
		System.out.print("The shortest path "
				+ "is " + a.toString() + " to"
						+ " the  " + b.toString() + ",");
		
		// return null if no path 
		if (path_1 == null) { 
			System.out.println("It does not exist");
		}
		
		else { 
			for (Vertex m: path_1.vertices) {
				System.out.print(m.getLabel() + " ");
			}
			System.out.println("The cost "
					+ "is " + path_1.cost);
		}	
		System.out.println("*********************************************");
	}
	
	
	public static MyGraph tester (String[] inputVertex, String[] inputEdge) {
		
		MyGraph g = graph_test(inputVertex, inputEdge);		
		
       
        Collection<Vertex> vx = g.vertices();
        Collection<Edge> e = g.edges();
       		
		System.out.println("Edge"
				+ " is " + e);
		System.out.println("Vertex"
				+ " is " + vx);
		
		return g; 
	}
	
	
}
