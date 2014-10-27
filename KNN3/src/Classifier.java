import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;

import org.math.plot.Plot2DPanel;



public class Classifier {
	
	public static void main(String []args){
		
		
		
		System.out.println("Starting");
		
		
		//use KnnNodeList to store the training raw data
		KnnNodeList raw_list = new KnnNodeList();
		
		//the source file path way
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
		
		/*
		
		System.out.println(":):):):):):):):):):):):):):):):):):):)");
		
		
		double [] x = new double [list.size()];
		
		double [] y = new double [list.size()];
		
		for(int i=0;i<list.size();i++){
			x[i] = list.get(i).getFeature()[0];
					}
		
		for(int j=0;j<list.size();j++){
			y[j] = list.get(j).getFeature()[2];
		}
		
		System.out.print("x=");
		for(int i=0;i<list.size();i++){
			System.out.print(x[i]+" ");
		}
		
		System.out.println();
		
		System.out.print("y=");
		for(int j=0;j<list.size();j++){
			System.out.print(y[j]+" ");
		}
		
		
		Plot2DPanel plot_2D = new Plot2DPanel();
		
		//print out the scatter plot
		plot_2D.addScatterPlot("scatter",x,y);
		
		JFrame frame = new JFrame("jianhe luo panel"); 
		
		frame.setContentPane(plot_2D);
		
		frame.setVisible(true);
		
		
		System.out.println(":):):):):):):):):):):):):):):):):):):)");
		
		*/
		
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
		

		
		//print out the scatter of the three type in red, green and blue
		/*
		
		double[] x1 = new double[nl[0].getNodeList().size()];
		double[] y1 = new double[nl[0].getNodeList().size()];
		for(int i=0;i<nl[0].getNodeList().size();i++){
			x1[i] = nl[0].getNodeList().get(i).getFeature()[0];
		}
		for(int j=0;j<nl[0].getNodeList().size();j++){
			y1[j] = nl[0].getNodeList().get(j).getFeature()[1];
		}
		
		
		double[] x2 = new double[nl[1].getNodeList().size()];
		double[] y2 = new double[nl[1].getNodeList().size()];
		for(int i=0;i<nl[1].getNodeList().size();i++){
			x2[i] = nl[1].getNodeList().get(i).getFeature()[0];
		}
		for(int j=0;j<nl[1].getNodeList().size();j++){
			y2[j] = nl[1].getNodeList().get(j).getFeature()[1];
		}
		
		
		double[] x3 = new double[nl[2].getNodeList().size()];
		double[] y3 = new double[nl[2].getNodeList().size()];
		for(int i=0;i<nl[2].getNodeList().size();i++){
			x3[i] = nl[2].getNodeList().get(i).getFeature()[0];
		}
		for(int j=0;j<nl[2].getNodeList().size();j++){
			y3[j] = nl[2].getNodeList().get(j).getFeature()[1];
		}
		
		Color color1 = new Color(255,0,0);
		Color color2 = new Color(0,255,0);
		Color color3 = new Color(0,0,255);
		
		Plot2DPanel plot_2D = new Plot2DPanel();
		
		//print out the scatter plot
		plot_2D.addScatterPlot("scatter1",color1,x1,y1);
		
		//print out the scatter plot
		plot_2D.addScatterPlot("scatter2",color2,x2,y2);
				
		//print out the scatter plot
		plot_2D.addScatterPlot("scatter3",color3,x3,y3);
		
		
		JFrame frame = new JFrame("jianhe luo panel"); 
		frame.setContentPane(plot_2D);
		frame.setVisible(true);
		
		*/	
		
				
		//print out the three type and use a node(5.7,3.5) to connect with all of them
		
		System.out.println(":):):):):):):):):):):):):):):):):):):):):):):):)");
		
		double [] node = new double [2];
		
		node[0] = 5.7;
		node[1] = 3.5;
		
		Color color_red = new Color(255,0,0);
		Color color_green =new Color(0,255,0);
		Color color_blue = new Color(0,0,255);
		
		Plot2DPanel plot2d = new Plot2DPanel();
		
		
		
		double [][] a = new double [nl[0].getNodeList().size()][2];
		double [][] b = new double [nl[1].getNodeList().size()][2];
		double [][] c = new double [nl[2].getNodeList().size()][2];
		
		for(int i = 0;i<nl[0].getNodeList().size();i++){
			a[i][0] = nl[0].getNodeList().get(i).getFeature()[0];
			a[i][1] = nl[0].getNodeList().get(i).getFeature()[1];
		}
		
		for(int i = 0;i<nl[1].getNodeList().size();i++){
			b[i][0] = nl[1].getNodeList().get(i).getFeature()[0];
			b[i][1] = nl[1].getNodeList().get(i).getFeature()[1];
		}
		
		for(int i = 0;i<nl[2].getNodeList().size();i++){
			c[i][0] = nl[2].getNodeList().get(i).getFeature()[0];
			c[i][1] = nl[2].getNodeList().get(i).getFeature()[1];
		}
		
		for (int i=0;i<nl[0].getNodeList().size();i++){
			plot2d.addLinePlot("class1",color_red,node,a[i]);
		}
		
		for (int i=0;i<nl[1].getNodeList().size();i++){
			plot2d.addLinePlot("class1",color_green,node,b[i]);
		}
		
		for (int i=0;i<nl[2].getNodeList().size();i++){
			plot2d.addLinePlot("class1",color_blue,node,c[i]);
		}
		
		JFrame frame = new JFrame("jianhel plot panel");
		frame.setContentPane(plot2d);
		frame.setVisible(true);
		
		System.out.println(":):):):):):):):):):):):):):):):):):):):):):):):)");
		
		
		
		
		
		
				
		//I suppose that the default k is 5
		int default_k = 5;
		

		
		
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
		
		
		
		
		
		
		
		

	
	
	}
	

}
