

//implements the Comparable interface
public class DistNode implements Comparable<DistNode>{
	
	private String label;
	private double distance;
	
	public DistNode(String label, double distance) {
		super();
		this.label = label;
		this.distance = distance;
	}
	
	

	
	public DistNode() {
		super();
	}




	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}


	//override the compareTo function in Comparable interface
	@Override
	public int compareTo(DistNode o) {
		// TODO Auto-generated method stub
		
		Double temp = this.distance-o.getDistance();
		return  temp==0?this.label.compareTo(o.label):temp.intValue();
	}
	
	//define by myself
	public boolean bigger(DistNode o){
		double temp = this.distance-o.getDistance();
		if (temp>=0){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("the DistNode is:[label:");
		sb.append(this.label).append(",distance:");
		sb.append(this.distance).append("]");
		
		
		
		return sb.toString();
	}

	
	

}
