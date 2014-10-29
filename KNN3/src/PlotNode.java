
public class PlotNode implements Comparable<PlotNode> {

	
	private String label;
	private double [] feature;
	private double distances;
	
	
	
	//constructor function
	public PlotNode() {
		
		super();
		feature = new double [2];
	}




	//constructor function
	public PlotNode(String label, double[] feature, double distances) {
		super();
		this.label = label;
		this.feature = feature;
		this.distances = distances;
	}




	public String getLabel() {
		return label;
	}




	public void setLabel(String label) {
		this.label = label;
	}




	public double[] getFeature() {
		return feature;
	}




	public void setFeature(double[] feature) {
		this.feature = feature;
	}




	public double getDistances() {
		return distances;
	}




	public void setDistances(double distances) {
		this.distances = distances;
	}
	
	
	
	@Override
	public int compareTo(PlotNode o) {
		// TODO Auto-generated method stub
		int temp;
		
		if(distances>this.getDistances()){
			temp = 1;
		}
		else if(distances<this.getDistances()){
			temp = -1;
		}
		else{
			temp = 0;
		}
		
		return temp;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		sb.append("the label is:"+label+" "+"the distance is:"+distances+" "+"the feature1 is:"+feature[0]+" "+"the feature2 is:"+feature[1]+" ");
		sb.append('\n');
		
		return sb.toString();
	}
	
	
	
}
