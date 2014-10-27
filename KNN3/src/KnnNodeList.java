
import java.util.ArrayList;
import java.util.Iterator;


public class KnnNodeList {
	
	private ArrayList<KnnNode> nodeList;
	private String group_label;
	
	
	public KnnNodeList() {
		super();
		this.nodeList = new ArrayList<>();
		
	}


	public KnnNodeList(ArrayList<KnnNode> nodeList, String group_label) {
		super();
		this.nodeList = nodeList;
		this.group_label = group_label;
	}


	public ArrayList<KnnNode> getNodeList() {
		return nodeList;
	}


	public void setNodeList(ArrayList<KnnNode> nodeList) {
		this.nodeList = nodeList;
	}


	public String getGroup_label() {
		return group_label;
	}


	public void setGroup_label(String group_label) {
		this.group_label = group_label;
	}
	
	public ArrayList<Double> distCal_group (KnnNode node){
		ArrayList<Double> dists = new ArrayList<>();
		
		Iterator<KnnNode> it = nodeList.iterator();
		
		double temp;
		
		while(it.hasNext()){
			KnnNode obj = it.next();
			temp = node.distCal(obj);
			dists.add(temp);
		}
		
		return dists;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		

		Iterator<KnnNode> it = nodeList.iterator();
		
		while(it.hasNext()){
			sb.append(it.next().toString());
			sb.append('\n');
			
		}
		
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	

}
