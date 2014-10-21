import java.util.ArrayList;


public class Testingdatadistnode {

	private ArrayList [] dist_list;

	
	
	public Testingdatadistnode(int label_num) {
		super();
		this.dist_list = new ArrayList [label_num];
	}



	public Testingdatadistnode(ArrayList[] dist_list) {
		super();
		this.dist_list = dist_list;
	}



	public ArrayList[] getDist_list() {
		return dist_list;
	}



	public void setDist_list(ArrayList[] dist_list) {
		this.dist_list = dist_list;
	}
	
	
	
	
}
