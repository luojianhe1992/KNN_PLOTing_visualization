
public class KnnNode {
	
	private String label;
	private double [] feature;
	
	
	public KnnNode() {
		super();
		this.feature = new double [5];
	}

	public KnnNode(String label, double[] feature) {
		super();
		this.label = label;	
		this.feature = feature;
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
	
	//distances between all features
	public double distCal(KnnNode node){
		double dist;
		double sum = 0;
		
		for (int i=0;i<4;i++){
			sum = sum + (this.feature[i]-node.feature[i])*(this.feature[i]-node.feature[i]);
		}
		
		dist = Math.sqrt(sum);
		
		return dist;
	}
	
	//distances between two features
	public double distCal(KnnNode node, int feature1, int feature2){
		double dist;
		double sum = 0;
			
		sum = sum + (feature[feature1]-node.feature[feature1])*(feature[feature1]-node.feature[feature1]);
		sum = sum + (feature[feature2]-node.feature[feature2])*(feature[feature2]-node.feature[feature2]);
		
		dist = Math.sqrt(sum);
		
		return dist;
	}
	
	//distances between three features
	public double disCal(KnnNode node, int feature1,int feature2, int feature3){
		double dist;
		double sum = 0;
		
		sum = sum + (feature[feature1]-node.feature[feature1])*(feature[feature1]-node.feature[feature1]);
		sum = sum + (feature[feature2]-node.feature[feature2])*(feature[feature2]-node.feature[feature2]);
		sum = sum + (feature[feature3]-node.feature[feature3])*(feature[feature3]-node.feature[feature3]);
		
		dist = Math.sqrt(sum);
		
		return dist;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[label:").append(this.getLabel()).append(",features:");
		
		for (int i=0;i<4;i++){
			sb.append(feature[i]).append(" ");
		
		}
		
//		for (double f : feature)
//			sb.append(f).append(", ");
//		
//		sb.delete(sb.length() - 2, sb.length());
		
		sb.append("]");
		
		return sb.toString();
	}
	
	
	

}
