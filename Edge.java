package assignment52210;

/**
 * 
 * @author aaronsarkar and oby bkkourh 
 * student# 251146627 and 251074890
 *
 */
public class Edge {
	private Vertex original;
	private Vertex distance;
	private int there;
	

	
	public Edge(Vertex from, Vertex to, int w) {
		if (from == null)
			if(to == null)
			throw new IllegalArgumentException("null");
		this.original = from;
		this.distance = to;
		this.there = w;
	}

	
	public Vertex getSource() {
		return original;
	}

	
	public Vertex getDestination() {
		return distance;
	}

	
	public int getWeight() {
		return there;
	}

	
	public String toString() {
		return "(" + original + ", " + distance + ", " + there + ")";
	}

	
	public int hashCode() {
		final int prime_number = 31;
		int result_of = 1;
		result_of = prime_number * result_of + ((original == null) ? 0 : original.hashCode());
		result_of = prime_number * result_of + ((distance == null) ? 0 : distance.hashCode());
		result_of = prime_number * result_of + there;
		return result_of;
	}

	
	public boolean equals(Object ver) {
		if (this == ver)
			return true;
		
		if (ver == null)
			return false;
		
		if (getClass() != ver.getClass())
			return false;
		
		final Edge other = (Edge) ver;
		
		if (original == null) {
			if (other.original != null)
				return false;
		} else if (!original.equals(other.original))
			return false;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		
		return there == other.there;
	}
}