import java.util.ArrayList;

public class Graph {
    public ArrayList<Vertex> vlist;

    //public Graph t1;

    public Graph() {
        vlist = new ArrayList<Vertex>();
    }

    public void addVertex(String name) {
        Vertex v = new Vertex(name);
        vlist.add(v);
    }

    public Vertex getVertex(String name) {
        // int j = vlist.indexOf(name);
        // for(int i = 0; i<vlist.size(); i++)
        // {
        //     Vertex v = vlist.get(i);
        //     if(v.name == name)
        //     {
        //         return vlist.get(i);
        //     }
        // }
        // return null;
        Vertex v= null;
        for(int j = 0; j< vlist.size(); j++)
        {
            if(vlist.get(j).name == name)
            {
                v = vlist.get(j);
            }
        }
        return v;
    }
    public void addEdge(String from, String to, int weight) {
        // Vertex _from = getVertex(from);
        // Vertex _to = getVertex(to);

        // Edge e1 = new Edge(_from,_to,weight);

        // _from.adjlist.add(e1);
        // _to.adjlist.add(e1);
        // Edge edge1;
        // edge1 = new Edge(getVertex(from),getVertex(to),weight);
        // Edge edge2;
        // edge2 = new Edge(getVertex(from),getVertex(to),weight);

        // getVertex(from).adjlist.add(edge1);
        // getVertex(to).adjlist.add(edge2);

        if(from.equals(to))
        {
            getVertex(to).adjlist.add(new Edge (getVertex(to), getVertex(from),weight));
        }
        else{
            getVertex(from).adjlist.add(new Edge(getVertex(from),getVertex(to),weight));
            getVertex(to).adjlist.add(new Edge (getVertex(to), getVertex(from),weight));
        }
    }

    public Edge getEdge(String from, String to) {
        Vertex from2 = getVertex(from);
        Vertex to2 = getVertex(to);
        Edge e;


        if(from2 == null && to2 == null) 
        {
         return null;   
        }
        // if(!from2.adjlist.contains(to2))
        // {
        //     return null;
        // }
            for(int k = 0; k< vlist.size();k++)
            {
                Vertex v = vlist.get(k);
                for(int j = 0; j< v.adjlist.size(); j++)
                {
                    e = v.adjlist.get(j);
                    if(e.from == from2 && e.to == to2 || e.to == from2 && e.from == to2)
                    {
                        return e;
                    }
                }
            }
            return null;
    }

    
    public int MSTCost() {
        
        if(this.vlist.isEmpty())
        {
            return 0;
        } 

        Graph t1 = new Graph();
        
        t1.addVertex(vlist.get(0).name);
        int totalWeight = 0;
        ArrayList<Edge> listOfEdges = new ArrayList<Edge>();
        //lookForEdge(vlist.get(0),t1);
        while(t1.vlist.size() < this.vlist.size())
        {
            listOfEdges = lookForEdge(this,t1);
            Edge cheapestEdge = null;
            
            if(listOfEdges.size()==0)
            {
                return 0;
            }
            cheapestEdge = lookForCheapest(listOfEdges);
            if(cheapestEdge != null)
            {
                totalWeight += cheapestEdge.weight;
                t1.addVertex(cheapestEdge.to.name);
                t1.addEdge(cheapestEdge.from.name,cheapestEdge.to.name,cheapestEdge.weight);
                
            }
        }
 
        return totalWeight;
    }

      public ArrayList<Edge> lookForEdge(Graph originalGraph, Graph tempGraph)
      {
        // ArrayList<Edge> tempEdgeList = new ArrayList<Edge>();
        // for(int i = 0; i< v1.adjlist.size(); i++)
        // {
        //     if(v1.adjlist.get(i).from != v1.adjlist.get(i).to && !vertexVisited(t1,v1.adjlist.get(i).to.name))
        //     {
        //         tempEdgeList.add(v1.adjlist.get(i));
        //     }

        // }
        // return tempEdgeList;
        ArrayList<Edge> edgeTemp = new ArrayList<Edge>();
        for(int i =0; i< tempGraph.vlist.size(); i++)
        {
            for(int j = 0; j< originalGraph.vlist.size(); j++)
            {
                for(int k = 0; k< originalGraph.vlist.get(j).adjlist.size();k++)
                {
                    if(originalGraph.vlist.get(j).adjlist.get(k).from.name.equals(tempGraph.vlist.get(i).name) && vertexVisited(tempGraph,originalGraph.vlist.get(j).adjlist.get(k))== false)
                    {
                        edgeTemp.add(originalGraph.vlist.get(j).adjlist.get(k));
                    }
                }
            }
        }
        return edgeTemp;
    }

    public Edge lookForCheapest(ArrayList<Edge> edges)
    {
        Edge cheapEdge = null;
        Double infinityValue = Double.POSITIVE_INFINITY;

        for(int i =0; i< edges.size(); i++)
        {
            if(edges.get(i).weight< infinityValue)
            {
                infinityValue = (double) edges.get(i).weight;
                cheapEdge = edges.get(i);
            }
        }
        return cheapEdge;
    }

        public boolean vertexVisited(Graph t1, Edge e)
        {
            for(int j = 0; j< t1.vlist.size(); j++)
            {
                if(e.to.name.equals(t1.vlist.get(j).name))
                {
                    return true;
                }
            }
            return false;
        }


    public Graph MST() {
        Graph t1 = new Graph();

         if(this.vlist.isEmpty())
        {
            return t1;
        } 

        // Graph t1 = new Graph();
        t1.addVertex(vlist.get(0).name);
        int totalWeight = 0;

        ArrayList<Edge> listOfEdges = new ArrayList<Edge>();
        //lookForEdge(vlist.get(0),t1);
        
        while(t1.vlist.size() < this.vlist.size())
        {
            listOfEdges = lookForEdge(this,t1);
            Edge cheapestEdge = null;
            if(listOfEdges.size()==0)
            {
                return null;
            }
            //Edge cheapestEdge = null;
            cheapestEdge = lookForCheapest(listOfEdges);
            if(cheapestEdge != null)
            {
                totalWeight += cheapestEdge.weight;
                t1.addVertex(cheapestEdge.to.name);
                t1.addEdge(cheapestEdge.from.name,cheapestEdge.to.name,cheapestEdge.weight);
                
            }
        }
 
        return t1;
    }

    public int SPCost(String from, String to) {
        
        if(from == null|| to == null)
        {
            return 0;
        }
        Vertex finishingPoint = getVertex(to);
        Vertex startingPointV = getVertex(from);

        startingPointV.distanceFromPrev = 0.0;

        ArrayList<Vertex> checkedV = new ArrayList<Vertex>(vlist);
        ArrayList<Vertex> testingVertex = new ArrayList<Vertex>();//priorityQ

        testingVertex.add(startingPointV);

        while (!testingVertex.isEmpty()){
            Vertex interimV = testingVertex.get(0);
            testingVertex.remove(0);

            for(int i =0; i< interimV.adjlist.size();i++)
            {
                if(checkedV.contains(interimV.adjlist.get(i).to))
                {
                    //interimV.add(interimV.adjlist.get(i).to);
                    testingVertex.add(interimV.adjlist.get(i).to);
                    checkedV.remove(interimV.adjlist.get(i).to);
                }
                //double storeInterimDistance = interimV.distanceFromPrev; 
                double storeInterimDist = interimV.distanceFromPrev;
                //if((interimV.distanceFromPrev + (double) interimV.adjlist.get(i).weight) < (interimV.adjlist.get(i).to.distanceFromPrev))

                if((interimV.adjlist.get(i).to.distanceFromPrev)>(storeInterimDist +(double) interimV.adjlist.get(i).weight))
                {
                    interimV.adjlist.get(i).to.distanceFromPrev = interimV.distanceFromPrev + (double) interimV.adjlist.get(i).weight;
                    interimV.adjlist.get(i).to.pastVertex = interimV;
                }
            }
        }

	return (int)(double) getVertex(to).distanceFromPrev;
    }

    public Graph SP(String from, String to) {

        Vertex previousVertex = getVertex(from);
        Graph g = new Graph();
        g.addVertex(previousVertex.getName());



        if(from == null|| to == null)
        {
            return null;
        }
        Vertex finishingPoint = getVertex(to);
        

        previousVertex.distanceFromPrev = 0.0;

        ArrayList<Vertex> checkedV = new ArrayList<Vertex>(vlist);
        ArrayList<Vertex> testingVertex = new ArrayList<Vertex>();//priorityQ

        testingVertex.add(previousVertex);

        while (!testingVertex.isEmpty()){
            Vertex interimV = testingVertex.get(0);
            testingVertex.remove(0);

            for(int i =0; i< interimV.adjlist.size();i++)
            {
                if(checkedV.contains(interimV.adjlist.get(i).to))
                {
                    //interimV.add(interimV.adjlist.get(i).to);
                    testingVertex.add(interimV.adjlist.get(i).to);
                    checkedV.remove(interimV.adjlist.get(i).to);
                }
                //double storeInterimDistance = interimV.distanceFromPrev; 
                double storeInterimDist = interimV.distanceFromPrev;
                //if((interimV.distanceFromPrev + (double) interimV.adjlist.get(i).weight) < (interimV.adjlist.get(i).to.distanceFromPrev))

                if((interimV.adjlist.get(i).to.distanceFromPrev)>(storeInterimDist +(double) interimV.adjlist.get(i).weight))
                {
                    interimV.adjlist.get(i).to.distanceFromPrev = interimV.distanceFromPrev + (double) interimV.adjlist.get(i).weight;
                    interimV.adjlist.get(i).to.pastVertex = interimV;
                    g.addVertex(interimV.getName());
                    Edge current = this.getEdge(previousVertex.getName(), interimV.getName());
                    g.addEdge( previousVertex.getName(), interimV.getName(), current.getWeight());
                    previousVertex = interimV;
                
            }
        }

}
        return g;
}

    public static void main(String []args)
    {
        // Graph g = new Graph();
        // g.addVertex("A");
        // g.addVertex("B");
        // g.addVertex("C");
        // g.addVertex("D");

        // g.addEdge("A","D",25);
        // g.addEdge("D","B",7);
        // g.addEdge("A","C",1);
        // g.addEdge("A","B",50);
        // g.addEdge("D","C",57);
        // g.addEdge("C","B",70);

        Graph t = new Graph();

        t.addVertex("A");
        t.addVertex("B");
        t.addVertex("C");
        t.addVertex("D");
        t.addVertex("F");

        t.addEdge("A","B",6);
        t.addEdge("A","F",97);
        t.addEdge("A","C",8);
        t.addEdge("C","D",2);
        t.addEdge("D","F",1);

        t.SPCost("A","B");

        int test = t.SPCost("A","F");
        System.out.println(test);

        Graph shortestPath = t.SP("A","F");
        System.out.println(shortestPath);



        // g.addVertex("A");
        // g.addVertex("B");
        // g.addVertex("C");
        // g.addVertex("E");

        // g.addEdge("A","E",25);
        // g.addEdge("E","B",7);
        // g.addEdge("A","C",1);
        // g.addEdge("A","B",50);
        // g.addEdge("E","C",57);
        // g.addEdge("C","B",70);

    }
}

