
public class GraphEdgeNode {
	private int value;
	private GraphEdgeNode nextedge;
	private boolean isVisited;
	
	
	
	//constructor function
	public GraphEdgeNode() {
		super();
		nextedge = null;
		isVisited = false;
	}
	
	

	public GraphEdgeNode(int value) {
		super();
		this.value = value;
		nextedge = null;
		isVisited = false;
	}



	//constructor function
	public GraphEdgeNode(int value, GraphEdgeNode nextedge) {
		super();
		this.value = value;
		this.nextedge = nextedge;
		this.isVisited = false;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}



	public GraphEdgeNode getNextedge() {
		return nextedge;
	}

	public void setNextedge(GraphEdgeNode nextedge) {
		this.nextedge = nextedge;
	}

	//override the equals function
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		GraphEdgeNode node = (GraphEdgeNode) obj;
		
		
		return node.getValue()==this.getValue();
	}
	
	
	

}
