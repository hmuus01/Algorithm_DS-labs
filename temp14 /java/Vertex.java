import java.util.ArrayList;

public class Vertex {
    public String name;
    public ArrayList<Edge> adjlist;
    public Double distanceFromPrev;
    public Vertex pastVertex;


    public Vertex(String _name) {
    	this.name = _name;
    	this.adjlist = new ArrayList<Edge>();
    	this.distanceFromPrev = Double.POSITIVE_INFINITY;
    	this.pastVertex = null;
    }
    public String getName()
    {
    	return this.name;
    }
}

