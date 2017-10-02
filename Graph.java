import java.util.*;

public class Graph{
	private ArrayList<Vertex> vertexArrayList;
	private ArrayList<Edge> minTree;
	private int nverts = 20;
	private int [][] minEdges = new int [20][20];
	private ArrayList<Edge> edgeArrayList;
	private Queue<Vertex> QueMe;
	
	public Graph(){
		QueMe = new LinkedList<Vertex>();
		edgeArrayList = new ArrayList<Edge>();
		vertexArrayList = new ArrayList<Vertex>();
		minTree = new ArrayList<Edge>();
		for(int i=0; i<nverts; i++){
			for(int j=0; j<nverts; j++){
				minEdges[i][j]=0;
			}
		}
	}
	
	public void addVertex(int label){
		if(vertexArrayList.size()<nverts){
			Vertex addMe = new Vertex(label);
			vertexArrayList.add(addMe);
		}
		else{
			System.out.println("Max capacity reached");
		}
	}
	
	
	public void addEdge (int start, int end, int weight){
		if(vertexArrayList.get(start)!=null&&vertexArrayList.get(end)!=null){
			Edge addMe = new Edge(vertexArrayList.get(start),vertexArrayList.get(end),weight);
			edgeArrayList.add(addMe);
		}
	}
	
	public void sortEdges(){
		for(int i=0; i<edgeArrayList.size(); i++){
			for(int j=i; j<edgeArrayList.size(); j++){
				if(edgeArrayList.get(i).getWeight()>edgeArrayList.get(j).getWeight()){
					Edge temp=edgeArrayList.get(i);
					edgeArrayList.set(i,edgeArrayList.get(j));
					edgeArrayList.set(j,temp);
				}
			}
		}
	}
	
	public void displayVertices(){
		System.out.println("Here are the vertices: ");
		for(int i = 0; i<vertexArrayList.size(); i++){
			System.out.println(vertexArrayList.get(i).getLabel());
		}
	}
	
	public void displayEdges (){
		System.out.println("The edges are: ");
		for(int i=0; i<edgeArrayList.size(); i++){
			System.out.println(edgeArrayList.get(i).getStart().getLabel()+"-"+edgeArrayList.get(i).getEnd().getLabel()+" , "+edgeArrayList.get(i).getWeight());
		}
	}
	
	public void displayTree(){
		System.out.println("The Tree's edges are: ");
		for(int i=0; i<minTree.size(); i++){
			System.out.println(minTree.get(i).getStart().getLabel()+"-"+minTree.get(i).getEnd().getLabel()+" , "+minTree.get(i).getWeight());
		}
	}
	
	
	
	//Kruskal's handy work.
	public void algorithm(){
		sortEdges();
		int i=0;
		
		while(i<edgeArrayList.size()){
			//Try one edge at a time to see if you can add it.
			Edge question = edgeArrayList.get(i);
			
			//Make sure the Queue is clear
			QueMe.clear();
			if(breadth(question.getStart(),question.getEnd()) == true){
				
				//Add it to your new Tree.
				minTree.add(question);	
				int first = vertexArrayList.indexOf(question.getStart());
				int last = vertexArrayList.indexOf(question.getEnd());
				minEdges[first][last]=minEdges[last][first]=1;
			}
			i++;
		}
	}
	
	
	//Used this to check for cycles before inserting into the minimal tree.
	public boolean breadth(Vertex root, Vertex cycle){
		
		//My Queue of Vertices
		QueMe.add(root);
		
		//Keep track what has been visited
		boolean[]visited=new boolean[nverts];
		while(!QueMe.isEmpty()){
			
			//Remove the first in Queue
			Vertex i = QueMe.poll();
			for(int j=0; j<nverts; j++){
				//If this vertex is connected to the root vertex in the minimal tree...
				if(minEdges[vertexArrayList.indexOf(i)][j]>0){
					//And if the vertex has yet to be visited
					if(visited[j]==false){
						//Return false if it would make a cycle
						if(vertexArrayList.get(j)==cycle){
							return false;
						}
						//Else, add it to the queue, mark visited, and start again.
						else{
							QueMe.add(vertexArrayList.get(j));
							visited[j]=true;
						}
					}
				}
			}
		}
		return true;
	}
}