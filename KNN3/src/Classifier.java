import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class Classifier {
	
	public static void main(String []args){
		
		/*
		double [] feature1 = {5.1,3.5,1.4,0.2};
		String label1 = "I. setosa";
		
		KnnNode n1 = new KnnNode(label1,feature1);
		
		double [] feature2 = {7,3.2,4.7,1.4};
		String label2 = "I. versicolor";
		
		KnnNode n2 = new KnnNode(label2,feature2);
		
		double [] feature3 = {4.9,3,1.4,0.2};
		String label3 = "I. setosa";
		
		KnnNode n3 = new KnnNode(label3, feature3);
		
		System.out.println("node1:"+n1);
		
		System.out.println("node2:"+n2);
		
		System.out.println("node3:"+n3);
		
		System.out.println("distance between n1 and n2:"+n1.distCal(n2));
		
		KnnNodeList nl1 = new KnnNodeList();
		
		KnnNodeList nl2 = new KnnNodeList();
		
		nl1.getNodeList().add(n1);
		
		nl1.getNodeList().add(n2);
		
		nl2.getNodeList().add(n3);
		
		System.out.println("node list1:"+'\n'+nl1);
		System.out.println("node list2:"+'\n'+nl2);
		
		
		ArrayList<Double> distances = nl1.distCal_group(n3);
		
		Iterator<Double> it = distances.iterator();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("the distances are:[");
		
		while (it.hasNext()){
			sb.append(it.next()).append(" ");
		}
		
		sb.append("]");
		
		System.out.println(sb.toString());
		*/
		
		System.out.println("Starting");
		
		KnnNodeList raw_list = new KnnNodeList();
		String path_trainingdata = "data/IrisTrain.csv";
		
		//invoke the static function parse in class KnnReader to read the IrisFull.csv file into Arraylist<KnnNode>
		ArrayList<KnnNode> list = KnnReader.parse(path_trainingdata);
		
		//iterate the ArrayList<KnnNode> and use HashSet to store the labels of the training data without repetition
		Set<String> keySet = new HashSet<String>();
		for(KnnNode n : list)
			keySet.add(n.getLabel());
		
		//print out the size of the labels in training data
		System.out.println("there are "+keySet.size()+" types of label.");
		
		//use the ArrayList<String> to store the labels instead of HashSet
		ArrayList<String> label_list = new ArrayList<String>();
		Iterator<String> it_label = keySet.iterator();
		while(it_label.hasNext()){
			label_list.add(it_label.next());
		}
		
		//print out the labels
		System.out.println("the label list is:"+label_list);
		
		//use the KnnNodeList raw_list to store the raw data
		raw_list.setNodeList(list);
		
		//printout the raw data
		System.out.println("the raw training data are:"+'\n'+raw_list);
		
		
		//According to the size of the labels, define several node list to respectively store the KnnNodes according to its label
		KnnNodeList [] nl = new KnnNodeList[label_list.size()];
		
		//for each nl, use new to new a KnnNodeList() to involve its constructor function
		for(int i=0;i<label_list.size();i++){
			nl[i] = new KnnNodeList();
		}

		for (int i=0;i<label_list.size();i++){
			nl[i].setGroup_label(label_list.get(i));
		}
		
		
		Iterator<KnnNode> it = raw_list.getNodeList().iterator();
		//classify the raw data
		while(it.hasNext()){
			KnnNode obj = it.next();
			for (int i=0;i<label_list.size();i++){
				if(obj.getLabel().equals(label_list.get(i))){
					nl[i].getNodeList().add(obj);
				}
			}
			
		}
		//print out several node lists
		System.out.println("print out "+label_list.size()+" node lists");
		for (int i=0;i<label_list.size();i++){
			System.out.println(nl[i]);
		}
		
		//I suppose that the default k is 5
		int default_k = 5;
		
//		//I define the new node
//		KnnNode new_node = new KnnNode(null,new double [] {4,4,4,4});
//		
//		//print out the new node
//		System.out.println("the new node is:"+new_node);
		
//		ArrayList<Double> [] dist_list = new ArrayList<Double> [label_list.size()];
		
		
		//define KnnNodeList new_nodelist to store the testing data
		KnnNodeList new_nodelist = new KnnNodeList();
		String path_testingdata = "data/IrisTest.csv";
		ArrayList<KnnNode> list_testingdata = KnnReader.parse(path_testingdata);
		new_nodelist.setNodeList(list_testingdata);
		
		
		//print out the testing data
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println("the testing data are:"+'\n'+new_nodelist);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		
		Iterator<KnnNode> it_testingdata = new_nodelist.getNodeList().iterator();
		
		int number_testingdata = 0;
		
		System.out.println("begin to iterate the testing data");
		
		while (it_testingdata.hasNext()){
			KnnNode obj_testingdata = it_testingdata.next();
			
			ArrayList [] dist_list_testingdata = new ArrayList [label_list.size()];
			
			for(int i=0;i<label_list.size();i++){
				dist_list_testingdata[i] = nl[i].distCal_group(obj_testingdata);
			}
			
			//sorting the ArrayList dist_list_testingdata
			for(int i=0;i<label_list.size();i++){
				Collections.sort(dist_list_testingdata[i]);
			}
			
			ArrayList<DistNode> distnodelist_testingdata = new ArrayList<DistNode>();
			
			for (int i=0;i<label_list.size();i++){
				for (int j=0;j<default_k;j++){
					//new a DistNode to store the distance from new node to the k nodes in order separately
					DistNode distnode_testingdata = new DistNode();
					distnode_testingdata.setLabel(label_list.get(i));
					distnode_testingdata.setDistance((double) dist_list_testingdata[i].get(j));
					distnodelist_testingdata.add(distnode_testingdata);
				}
			}
			
			//there is some problem in sorting process
//			Collections.sort(distnodelist_testingdata);
			
			//sorting process
			for (int i=0;i<distnodelist_testingdata.size();i++){
				for (int j=i;j<distnodelist_testingdata.size();j++){
					if(distnodelist_testingdata.get(i).bigger(distnodelist_testingdata.get(j))){
						DistNode temp = new DistNode();
						temp = distnodelist_testingdata.get(i);
						distnodelist_testingdata.set(i, distnodelist_testingdata.get(j));
						distnodelist_testingdata.set(j, temp);
					}
				}
			}

			int [] label_num_testingdata = new int[label_list.size()];
			
			for(int i=0;i<label_list.size();i++){
				label_num_testingdata[i] = 0;
			}
			
			for (int i=0;i<default_k;i++){
				for (int j=0;j<label_list.size();j++){
					if (distnodelist_testingdata.get(i).getLabel().equals(label_list.get(j))){
						label_num_testingdata[j]++;
					}
				}
			}	
			
			ArrayList<Integer> label_num_list_testingdata = new ArrayList<Integer>();
			
			for(int i=0;i<label_list.size();i++){
				label_num_list_testingdata.add(label_num_testingdata[i]);
			}
			Collections.sort(label_num_list_testingdata);	
			for (int i=0;i<label_list.size();i++){
				if (label_num_list_testingdata.get(label_list.size()-1)==label_num_testingdata[i]){
					System.out.println("the #"+number_testingdata+" testing data node "+" is classified into "+label_list.get(i));
				}
			}	
			number_testingdata++;
			}
		
		
		
		
		
		
		
		
//		
//		
//		
//		
//		
//		
//		
//		//use the ArrayList [] to store the new node to each cluster's each node respectively
//		ArrayList [] dist_list = new ArrayList [label_list.size()];
//		
//		
//		//calculate the distances
//		for(int i=0;i<label_list.size();i++){
//			dist_list[i] = nl[i].distCal_group(new_node);
//		}
//		
//		/*
//		ArrayList<Double> dist1 = nl1.distCal_group(new_node);
//		ArrayList<Double> dist2 = nl2.distCal_group(new_node);
//		ArrayList<Double> dist3 = nl3.distCal_group(new_node);
//		*/
//
//		//sort the distance in ArrayList separately
//		for(int i=0;i<label_list.size();i++){
//			Collections.sort(dist_list[i]);
//		}
//		/*
//		Collections.sort(dist1);
//		Collections.sort(dist2);
//		Collections.sort(dist3);
//		*/
//		
//		//print out the distances ArrayList separately
//		System.out.println("*******************");
//		for(int i=0;i<label_list.size();i++){
//			System.out.println("distance "+i+":"+dist_list[i]);
//		}
//		
//		/*
//		System.out.println("distance 1:"+dist1);
//		System.out.println("distance 2:"+dist2);
//		System.out.println("distance 3:"+dist3);
//		 */
//		
//		System.out.println("*******************");
//		
//		//use ArrayList<DistNode> to store the k distances for each cluster
//		ArrayList<DistNode> distnodelist = new ArrayList<DistNode>();
//		
//		for (int i=0;i<label_list.size();i++){
//			for (int j=0;j<default_k;j++){
//				//new a DistNode to store the distance from new node to the k nodes in order separately
//				DistNode distnode = new DistNode();
//				distnode.setLabel(label_list.get(i));
//				distnode.setDistance((double) dist_list[i].get(j));
//				distnodelist.add(distnode);
//			}
//		}
//		/*
//		for (int i=0;i<default_k;i++){
//			DistNode distnode = new DistNode();
//			distnode.setLabel(label_list.get(0));
//			distnode.setDistance(dist1.get(i));
//			distnodelist.add(distnode);
//			
//		}
//		for (int i=0;i<default_k;i++){
//			DistNode distnode = new DistNode();
//			distnode.setLabel(label_list.get(1));
//			distnode.setDistance(dist2.get(i));
//			distnodelist.add(distnode);
//		}
//		for(int i=0;i<default_k;i++){
//			DistNode distnode = new DistNode();
//			distnode.setLabel(label_list.get(2));
//			distnode.setDistance(dist3.get(i));
//			distnodelist.add(distnode);
//		}
//		*/
//		
//		//sort the Arraylist<DistNode>, I should first implements the comparable interface and override the compareTo function
//		Collections.sort(distnodelist);
//		
//		/*
//		//use to count the number of the label
//		int label1_num = 0;
//		int label2_num = 0;
//		int label3_num = 0;
//		*/
//		
//		//define a array to store the number of label
//		int [] label_num = new int[label_list.size()];
//		
//		//use for circulation to calculate the number of label in the ArrayList<DistNode>
//		for (int i=0;i<default_k;i++){
//			for (int j=0;j<label_list.size();j++){
//				if (distnodelist.get(i).getLabel().equals(label_list.get(j))){
//					label_num[j]++;
//				}
//			}
//		}	
//		
//		/*
//		for(int i=0;i<default_k;i++){
//			if(distnodelist.get(i).getLabel().equals(label_list.get(0))){
//				label1_num++;
//			}
//			if(distnodelist.get(i).getLabel().equals(label_list.get(1))){
//				label2_num++;
//			}
//			if(distnodelist.get(i).getLabel().equals(label_list.get(2))){
//				label3_num++;
//			}
//			
//		}
//		*/
//		
//		ArrayList<Integer> label_num_list = new ArrayList<Integer>();
//		
//		for(int i=0;i<label_list.size();i++){
//			label_num_list.add(label_num[i]);
//		}
//		
//		//sort the ArrayList<Integer> label_num_list
//		Collections.sort(label_num_list);
//		
//		//find out the most label and classify the new node into that label
//		for (int i=0;i<label_list.size();i++){
//			if (label_num_list.get(label_list.size()-1)==label_num[i]){
//				System.out.println("the new node is classified into "+label_list.get(i));
//			}
//		}
//		
//		
//		
//		
		
		
		
		
		/*
		if(label1_num>label2_num&&label1_num>label3_num){
			System.out.println("the new node is classified into "+label_list.get(0));
		}
		if(label2_num>label1_num&&label2_num>label3_num){
			System.out.println("the new node is classified into "+label_list.get(1));
		}
		if(label3_num>label1_num&&label3_num>label2_num){
			System.out.println("the new node is classified into "+label_list.get(2));
		}
		if(label2_num==label1_num&&label2_num==label3_num){
			System.out.println("the new node is classified into "+label_list.get(0)+" or "+label_list.get(1)+" or "+label_list.get(2));
		}
		
		if(label2_num==label1_num&&label2_num>label3_num){
			System.out.println("the new node is classified into "+label_list.get(0)+" or "+label_list.get(1));
		}
		if(label2_num==label3_num&&label2_num>label1_num){
			System.out.println("the new node is classified into "+label_list.get(1)+" or "+label_list.get(2));
		}
		if(label3_num==label1_num&&label3_num>label2_num){
			System.out.println("the new node is classified into "+label_list.get(0)+" or "+label_list.get(2));
		}
		*/
	
	
	}
	

}
