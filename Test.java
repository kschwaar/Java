
public class Test{
	public static void main(String [] args){
		Graph myGraph = new Graph();
			
		for(int i=0; i<6; i++){
			myGraph.addVertex(i);	
		}
		
		myGraph.addEdge(1,2,3);
		myGraph.addEdge(1,5,1);
		myGraph.addEdge(2,3,5);
		myGraph.addEdge(2,5,4);
		myGraph.addEdge(3,4,2);
		myGraph.addEdge(3,5,6);
		myGraph.addEdge(4,5,7);
		
		
		
		myGraph.displayVertices();
		myGraph.displayEdges();
		myGraph.sortEdges();
		myGraph.displayEdges();
		myGraph.algorithm();
		myGraph.displayTree();
	}
}