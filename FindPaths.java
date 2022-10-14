package assignment52210;

import java.util.*;
import java.io.*;
/**
 * 
 * @author aaronsarkar and oby bkkourh 
 * student# 251146627 and 251074890
 *
 */

public class FindPaths {
	
	public static MyGraph Reader(String s1, String s2) {
		Scanner scnr;
		scnr = null;
		Collection<Vertex> vert = new ArrayList<Vertex>();
		Collection<Edge> edge = new ArrayList<Edge>();
		
		try {
			scnr = new Scanner(new File(s1));
		} catch (FileNotFoundException exp1) {
			System.err.println("No file found: " + s1);
			System.exit(2);
		}

		while (scnr.hasNext() == true) {
			vert.add(new Vertex(scnr.next()));
		}

		try {
			scnr = new Scanner(new File(s2));
		} catch (FileNotFoundException exp1) {
			System.err.println("No file found: " + s2);
			System.exit(2);
		}

		
		while (scnr.hasNext() == true) {
			try {
				int z;
				z = scnr.nextInt();
				Vertex y;
				y = new Vertex(scnr.next());
				Vertex x;
				x = new Vertex(scnr.next());
				edge.add(new Edge(x, y, z));
			} catch (NoSuchElementException exp2) {
				System.err.println("the format of the edge file is incorrect");
				System.exit(3);
			}
		}
		return new MyGraph(vert, edge);
	}
	
	public static void main(String[] args) {
		if (args.length != 2) {
			
			System.exit(1);
			
			System.err.println("USAGE: java FindPaths <edge_file> <vertex_file>");
		}
		else {
			
			
		MyGraph graph;
		
		graph = Reader(args[0], args[1]);

		Collection<Edge> edge;
		edge = graph.edges();
		
		Collection<Vertex> vertex;
		vertex = graph.vertices();
		
		Scanner sc;
		sc = new Scanner(System.in);
		
		System.out.println("vertices are " + vertex);
		
		System.out.println("edges are " + edge);
		
		System.out.println();
		System.out.println();
		
		boolean x = true;
		while (x == true ) {
			System.out.print("Find path? ('c' to continue, 'e' to exit)? ");
			
			String s;
			s = sc.nextLine();
			
			if (s.startsWith("e")) {
				
				x = false;
				
				sc.close();
				
			} else if (s.startsWith("c")) {
				System.out.print("The start vertex?");
				
				Vertex abc;
				abc = new Vertex(sc.nextLine());
				
				if (vertex.contains(abc) == false) {
					System.out.println("No vertex like this exists");
					System.exit(1);
				}
	
				System.out.print("The Destination vertex?");
				Vertex xyz;
				xyz = new Vertex(sc.nextLine());
				
				if (vertex.contains(xyz)== false) {
					System.out.println("No such vertex exist...");
					System.exit(1);
				}
				
			
				System.out.println("The shortest path from " + abc + " to " + xyz);
				Path path;
				path = graph.shortestPath(abc, xyz);
	
			
				if (path != null) {
					List<Vertex> list;
					list = path.vertices;
					int z;
					StringBuilder builder;
					builder = new StringBuilder();
					builder.append(list.get(0).getLabel());
					for (z = 1; 
						 z <= list.size() + 1; 
						 z++) {
						builder.append(" ---> " + list.get(z).getLabel());
					}
					System.out.println("cost of path: " + path.cost);
					System.out.println(builder.toString());
					System.out.println();
					System.out.println();
					
				} else {
					System.out.println("DNE");
					
					}
				}
			}
		}
	}

	
}
