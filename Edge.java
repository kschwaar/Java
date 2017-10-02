public class Edge{
	private Vertex start;
	private Vertex end;
	private int weight;
	
	public Edge (Vertex start, Vertex end, int weight){
		setStart(start);
		setEnd(end);
		setWeight(weight);
	}
	public Edge(){
		setWeight(-1);
	}
	
	public void setStart(Vertex s){
		start=s;
	}
	public Vertex getStart(){
		return start;
	}
	
	public void setEnd(Vertex s){
		end=s;
	}
	public Vertex getEnd(){
		return end;
	}
	
	public void setWeight(int w){
		if(w<0){
			weight=5;
		}
		else{
			weight=w;
		}
	}
	public int getWeight(){
		return weight;
	}
}