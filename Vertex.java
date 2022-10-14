package assignment52210;

/**
 * Representation of a graph vertex
 */
/**
 * 
 * @author aaronsarkar and oby bkkourh 
 * student# 251146627 and 251074890
 *
 */
public class Vertex implements Comparable<Vertex>{
	// label attached to this vertex
	private String l; private Vertex path; private boolean stat; private int cost;
	public void upwardPath(Vertex thePath){path = thePath;}
	public void change_status(boolean status){stat = status;}
	public int get_Cost(){return cost;}
	public void change_cost(int Cost){cost = Cost;}
	public boolean get_Status(){return stat;}
	public Vertex get_Path(){return path;}
	public int compareTo(Vertex vertex) {return (int) Math.signum(this.cost - vertex.cost);}
	/**
	 * Get a vertex label
	 * 
	 * @return the label attached to this vertex
	 */
	public String getLabel() {return l;}

	/**
	 * A string representation of this object
	 * 
	 * @return the label attached to this vertex
	 */
	public String toString() {return l;}

	/**
	 * Construct a new vertex
	 * 
	 * @param label
	 *            the label attached to this vertex
	 */
	public Vertex(String label) {
		if (label == null)
			throw new IllegalArgumentException("null");
		this.l = label;
	}

	

	// auto-generated: hashes on label
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((l == null) ? 0 : l.hashCode());
		return result;
	}

	// auto-generated: compares labels
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Vertex other = (Vertex) obj;
		if (l == null) {
			return other.l == null;
		} else {
			return l.equals(other.l);
		}
	}
	
	
	

}