package assignment52210;

import java.util.List;
/**
 * 
 * @author aaronsarkar and oby bkkourh 
 * student# 251146627 and 251074890
 *
 */

public class Path {
	// we use public fields fields here since this very simple class is
	// used only for returning multiple results from shortestPath
	public final List<Vertex> vertices;
	public final int cost;

	public Path(List<Vertex> vertices, int cost) {
		this.vertices = vertices;
		this.cost = cost;
	}
}