public class Vertex{
	private int label;
	private Object obj;
	
	public Vertex(int s){
		setLabel(s);
	}
	
	public Vertex(int label, Object obj){
		setLabel(label);
		setObj(obj);
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}