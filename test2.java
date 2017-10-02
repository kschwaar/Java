
public class test2{
	public static void main(String [] args){
		Graph myGraph = new Graph();
			
		for(int i=0; i<8; i++){
			myGraph.addVertex(i);	
		}
		
		myGraph.addEdge(1,2,7);
		myGraph.addEdge(1,4,5);
		myGraph.addEdge(2,3,8);
		myGraph.addEdge(2,5,7);
		myGraph.addEdge(2,4,9);
		myGraph.addEdge(3,5,5);
		myGraph.addEdge(4,5,15);
		myGraph.addEdge(4,6,6);
		myGraph.addEdge(5,6,8);
		myGraph.addEdge(5,7,9);
		myGraph.addEdge(6,7,11);
		
		
		
		myGraph.displayVertices();
		myGraph.displayEdges();
		myGraph.sortEdges();
		myGraph.displayEdges();
		myGraph.algorithm();
		myGraph.displayTree();
	}
}