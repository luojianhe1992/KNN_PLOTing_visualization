import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

import org.math.plot.Plot2DPanel;
import org.math.plot.Plot3DPanel;


public class Plot {
	
	//the function to print out the scatter points of the training data.
	public static Plot2DPanel plot_2d (ArrayList<KnnNode> list, int feature1, int feature2 ){
		
		
		System.out.println("invoke the function to plot the scatter points of the training data.");
		
		double [] x = new double [list.size()];
		
		double [] y = new double [list.size()];
		
		for(int i=0;i<list.size();i++){
			x[i] = list.get(i).getFeature()[feature1];
					}
		
		for(int j=0;j<list.size();j++){
			y[j] = list.get(j).getFeature()[feature2];
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
		
		return plot_2D;
	}
	
	//print out the scatter of the three type in red, green and blue
	public static Plot2DPanel plot_2d_inthreecolor(KnnNodeList [] nl, int feature1, int feature2){
		
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
		
		
		
		JFrame frame = new JFrame("jianhe luo panel2"); 
		frame.setContentPane(plot_2D);
		frame.setVisible(true);
		
		return plot_2D;
	}
	
	
	//print out the three type and use a node to connect with all of them
	public static Plot2DPanel plot_2d(KnnNode node, KnnNodeList [] nl,  int feature1, int feature2){
			
		//use array to store the features of the node.
		double [] node_array = new double [2];
		node_array[0] = node.getFeature()[feature1];
		node_array[1] = node.getFeature()[feature2];
		
		Color color_red = new Color(255,0,0);
		Color color_green =new Color(0,255,0);
		Color color_blue = new Color(0,0,255);
		
		Plot2DPanel plot2d = new Plot2DPanel();
		
		//use two dimension array to store the features of three KnnNodeLists' nodes' features.
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
			plot2d.addLinePlot("class1",color_red,node_array,a[i]);
		}
		
		for (int i=0;i<nl[1].getNodeList().size();i++){
			plot2d.addLinePlot("class1",color_green,node_array,b[i]);
		}
		
		for (int i=0;i<nl[2].getNodeList().size();i++){
			plot2d.addLinePlot("class1",color_blue,node_array,c[i]);
		}
		
		JFrame frame = new JFrame("jianhel plot panel");
		frame.setContentPane(plot2d);
		frame.setVisible(true);
		
		return plot2d;
	}
	
	
	//2d connect line, three type, all the testing data
	public static Plot2DPanel plot_2d(KnnNodeList test_nl, KnnNodeList[] nl,int feature1,int feature2){
		
		Color color_red = new Color(255,0,0);
		Color color_green =new Color(0,255,0);
		Color color_blue = new Color(0,0,255);
		
		double [] [] test_array = new double [test_nl.getNodeList().size()][2];
		
		for(int i=0;i<test_nl.getNodeList().size();i++){
			test_array [i] [feature1] = test_nl.getNodeList().get(i).getFeature()[feature1];
			test_array [i] [feature2] = test_nl.getNodeList().get(i).getFeature()[feature2];
		
		}
		
		double a [] [] = new double [nl[0].getNodeList().size()] [2];
		double b [] [] = new double [nl[1].getNodeList().size()] [2];
		double c [] [] = new double [nl[2].getNodeList().size()] [2];
		
		for(int i=0; i<nl[0].getNodeList().size();i++){
			a [i] [feature1] = nl[0].getNodeList().get(i).getFeature()[feature1];
			a [i] [feature2] = nl[0].getNodeList().get(i).getFeature()[feature2];	
		}
		
		for(int i=0; i<nl[1].getNodeList().size();i++){
			b [i] [feature1] = nl[1].getNodeList().get(i).getFeature()[feature1];
			b [i] [feature2] = nl[1].getNodeList().get(i).getFeature()[feature2];	
		}
		
		for(int i=0; i<nl[2].getNodeList().size();i++){
			c [i] [feature1] = nl[2].getNodeList().get(i).getFeature()[feature1];
			c [i] [feature2] = nl[2].getNodeList().get(i).getFeature()[feature2];	
		}
		
		Plot2DPanel plot2d = new Plot2DPanel();
		
		for(int i=0;i<test_nl.getNodeList().size();i++){
			for(int j=0;j<nl[0].getNodeList().size();j++){
				plot2d.addLinePlot("connectline", color_red, test_array[i], a[j]);
			}
		}
		
		for(int i=0;i<test_nl.getNodeList().size();i++){
			for(int j=0;j<nl[1].getNodeList().size();j++){
				plot2d.addLinePlot("connectline", color_blue, test_array[i], b[j]);
			}
		}
		
		for(int i=0;i<test_nl.getNodeList().size();i++){
			for(int j=0;j<nl[2].getNodeList().size();j++){
				plot2d.addLinePlot("connectline", color_green, test_array[i], c[j]);
			}
		}
		
		JFrame frame = new JFrame("jianhel plot panel");
		frame.setContentPane(plot2d);
		frame.setVisible(true);
		return plot2d;
		
	}
	
	
	
	
	
	//given a node and can print out the nearest k nodes.
	public static Plot2DPanel plot_2d_thenearestpoint(KnnNode node, KnnNodeList[] nl,ArrayList<String> label_list,int feature1,int feature2, int nearest){
	
		//define the color
		Color color_red = new Color(255,0,0);
		Color color_green =new Color(0,255,0);
		Color color_blue = new Color(0,0,255);
		
		//use a array to store the node point
		double [] node_array = new double [2];
		node_array[0] = node.getFeature()[feature1];
		node_array[1] = node.getFeature()[feature2];
		
		//define a ArrayList<ArrayList<PlotNode>> to store the training data's plotnode
		ArrayList<ArrayList<PlotNode>> plotnodelist = new ArrayList<ArrayList<PlotNode>>();
		
		for (int i=0;i<nl.length;i++){
			plotnodelist.add(new ArrayList<PlotNode>());
		}
		
		for(int i=0;i<nl.length;i++){ 
			for (int j=0;j<nl[i].getNodeList().size();j++){
				plotnodelist.get(i).add(new PlotNode());
				
				//set value
				plotnodelist.get(i).get(j).setLabel(nl[i].getNodeList().get(j).getLabel());
				plotnodelist.get(i).get(j).setFeature(nl[i].getNodeList().get(j).getFeature());
				
				//calculate the distance
				plotnodelist.get(i).get(j).setDistances(nl[i].getNodeList().get(j).distCal(node,feature1,feature2));
			}
		}
		
		//define a ArrayList<PlotNode> to store the whole plotnode to sort
		ArrayList<PlotNode> dist_compare = new ArrayList<PlotNode>();
		
		for (int i=0;i<nl.length;i++){
			dist_compare.addAll(plotnodelist.get(i));
		}
		
//		Collections.sort(dist_compare);//问问鄢神为什么不能实现
		
		//sorting process
		for(int i=0;i<dist_compare.size();i++){
			for(int j=i;j<dist_compare.size();j++){
				if(dist_compare.get(j).getDistances()<dist_compare.get(i).getDistances()){
					PlotNode temp = new PlotNode();
					temp.setLabel(dist_compare.get(i).getLabel());
					temp.setDistances(dist_compare.get(i).getDistances());
					temp.setFeature(dist_compare.get(i).getFeature());
					
					dist_compare.set(i, dist_compare.get(j));
					
					dist_compare.set(j, temp);
				}
			}
		}
		
		//define a ArrayList<PlotNode> to just store the first k plot node
		ArrayList<PlotNode> nearestdistnode = new ArrayList<PlotNode> ();
		
		for (int i=0;i<nearest;i++){
			nearestdistnode.add(dist_compare.get(i));
		}
		
		
		int label1_num = 0;
		int label2_num = 0;
		int label3_num = 0;

		for (int i=0;i<nearest;i++){
			if(nearestdistnode.get(i).getLabel()==label_list.get(0)){
				label1_num++;
			}
			if(nearestdistnode.get(i).getLabel().equals(label_list.get(1))){
				label2_num++;
			}
			if(nearestdistnode.get(i).getLabel().equals(label_list.get(2))){
				label3_num++;
			}
		}
		
		double [][] a = new double [label1_num][2];
		double [][] b = new double [label2_num][2];
		double [][] c = new double [label3_num][2];
		
		
		for (int i=0,num1=0;i<nearest;i++){
			if (nearestdistnode.get(i).getLabel().equals(label_list.get(0))){
				a [num1][0] = nearestdistnode.get(i).getFeature()[feature1];
				a [num1][1] = nearestdistnode.get(i).getFeature()[feature2];
				num1++;
			}
		}
		
		for (int i=0,num2=0;i<nearest;i++){
			if (nearestdistnode.get(i).getLabel().equals(label_list.get(1))){
				b [num2][0] = nearestdistnode.get(i).getFeature()[feature1];
				b [num2][1] = nearestdistnode.get(i).getFeature()[feature2];
				num2++;
			}
		}
		
		for (int i=0,num3=0;i<nearest;i++){
			if (nearestdistnode.get(i).getLabel().equals(label_list.get(2))){
				c [num3][0] = nearestdistnode.get(i).getFeature()[feature1];
				c [num3][1] = nearestdistnode.get(i).getFeature()[feature2];
				num3++;
			}
		}
		
		//define a new Plot2DPanel
		Plot2DPanel plot2d = new Plot2DPanel();
		
		//invoke the function to plot all the training data
		plot2d = Plot.plot_2d_inthreecolor(nl, feature1, feature2);
		
		
		//plot the line
		for (int i=0;i<label1_num;i++){
			plot2d.addLinePlot("line", color_red, node_array, a[i]);
		}
		
		for (int i=0;i<label2_num;i++){
			plot2d.addLinePlot("line", color_green, node_array, b[i]);
		}
		
		for (int i=0;i<label3_num;i++){
			plot2d.addLinePlot("line", color_blue, node_array, c[i]);
		}
		
		JFrame frame = new JFrame();
		frame.setContentPane(plot2d);
		frame.setVisible(true);
		
		return plot2d;
	}
	
	
	//print out the scatter of training data
	public static Plot3DPanel plot_3d(ArrayList<KnnNode> list, int feature1, int feature2, int feature3){
		//use three arrays to store the three features of the node list.
		double [] a = new double [list.size()];
		double [] b = new double [list.size()];
		double [] c = new double [list.size()];
		
		for(int i=0; i<list.size();i++){
			a [i] = list.get(i).getFeature()[feature1];
			b [i] = list.get(i).getFeature()[feature2];
			c [i] = list.get(i).getFeature()[feature3];
		}
		
		Plot3DPanel plot3d = new Plot3DPanel();
		plot3d.addScatterPlot("scatter point 3d", a, b, c);
		
		JFrame frame = new JFrame("jianhel plot panel");
		frame.setContentPane(plot3d);
		frame.setVisible(true);
		
		return plot3d;
	}
	
	//print out the scatter points in three types
	public static Plot3DPanel plot_3d_inthreecolor(KnnNodeList [] nl, int feature1, int feature2, int feature3){
		
		Color color_red = new Color(255,0,0);
		Color color_green =new Color(0,255,0);
		Color color_blue = new Color(0,0,255);
		
		//each class of training nodes use three array to store the three features
		double [] x1 = new double [nl[0].getNodeList().size()];
		double [] y1 = new double [nl[0].getNodeList().size()];
		double [] z1 = new double [nl[0].getNodeList().size()];
		
		double [] x2 = new double [nl[1].getNodeList().size()];
		double [] y2 = new double [nl[1].getNodeList().size()];
		double [] z2 = new double [nl[1].getNodeList().size()];
		
		double [] x3 = new double [nl[2].getNodeList().size()];
		double [] y3 = new double [nl[2].getNodeList().size()];
		double [] z3 = new double [nl[2].getNodeList().size()];
		
		for (int i=0 ; i<nl[0].getNodeList().size();i++){
			x1 [i] = nl[0].getNodeList().get(i).getFeature()[feature1];
			y1 [i] = nl[0].getNodeList().get(i).getFeature()[feature2];
			z1 [i] = nl[0].getNodeList().get(i).getFeature()[feature3];
		}
		
		for (int i=0 ; i<nl[1].getNodeList().size();i++){
			x2 [i] = nl[1].getNodeList().get(i).getFeature()[feature1];
			y2 [i] = nl[1].getNodeList().get(i).getFeature()[feature2];
			z2 [i] = nl[1].getNodeList().get(i).getFeature()[feature3];
		}
		
		for (int i=0 ; i<nl[2].getNodeList().size();i++){
			x3 [i] = nl[2].getNodeList().get(i).getFeature()[feature1];
			y3 [i] = nl[2].getNodeList().get(i).getFeature()[feature2];
			z3 [i] = nl[2].getNodeList().get(i).getFeature()[feature3];
		}
		
		Plot3DPanel plot3d = new Plot3DPanel();
		
		plot3d.addScatterPlot("scatterpointred", color_red , x1, y1, z1);
		plot3d.addScatterPlot("scatterpointblue", color_green, x2, y2, z2);
		plot3d.addScatterPlot("scatterpointgreen", color_blue, x3, y3, z3);
		
		JFrame frame = new JFrame();
		frame.setContentPane(plot3d);
		frame.setVisible(true);
		
		return plot3d;                  		   
	}
	
	
	//connect line, three type, one node
	public static Plot3DPanel plot_3d(KnnNode node, KnnNodeList[] nl, int feature1, int feature2, int feature3){
		
		Color color_red = new Color(255,0,0);
		Color color_green =new Color(0,255,0);
		Color color_blue = new Color(0,0,255);
		
		double [] x = new double [2];
		double [] y = new double [2];
		double [] z = new double [2];
		x[0] = node.getFeature()[feature1];
		y[0] = node.getFeature()[feature2];
		z[0] = node.getFeature()[feature3];
		
		Plot3DPanel plot3d = new Plot3DPanel();
		
		for(int i=0;i<nl[0].getNodeList().size();i++){
			x[1] = nl[0].getNodeList().get(i).getFeature()[feature1];
			y[1] = nl[0].getNodeList().get(i).getFeature()[feature2];
			z[1] = nl[0].getNodeList().get(i).getFeature()[feature3];
			
			plot3d.addLinePlot("connect line", color_red, x, y, z);
		}
		
		for(int i=0;i<nl[1].getNodeList().size();i++){
			x[1] = nl[1].getNodeList().get(i).getFeature()[feature1];
			y[1] = nl[1].getNodeList().get(i).getFeature()[feature2];
			z[1] = nl[1].getNodeList().get(i).getFeature()[feature3];
			
			plot3d.addLinePlot("connect line", color_blue, x, y, z);
		}
		
		for(int i=0;i<nl[2].getNodeList().size();i++){
			x[1] = nl[2].getNodeList().get(i).getFeature()[feature1];
			y[1] = nl[2].getNodeList().get(i).getFeature()[feature2];
			z[1] = nl[2].getNodeList().get(i).getFeature()[feature3];
			
			plot3d.addLinePlot("connect line", color_green, x, y, z);
		}
		
		JFrame frame = new JFrame();
		frame.setContentPane(plot3d);
		frame.setVisible(true);

		return plot3d;
	
	}

	//3d connect line, three type, all the testing data
	public static Plot3DPanel plot_3d(KnnNodeList test_nl, KnnNodeList[] nl,int feature1,int feature2, int feature3){
			
		Color color_red = new Color(255,0,0);
		Color color_green =new Color(0,255,0);
		Color color_blue = new Color(0,0,255);
		
		
		double [] x = new double [2];
		double [] y = new double [2];
		double [] z = new double [2];
		
		Plot3DPanel plot3d = new Plot3DPanel();
		
		for(int j=0;j<test_nl.getNodeList().size();j++){
			x[0] = test_nl.getNodeList().get(j).getFeature()[feature1];
			y[0] = test_nl.getNodeList().get(j).getFeature()[feature2];
			z[0] = test_nl.getNodeList().get(j).getFeature()[feature3];
			
			for(int i=0;i<nl[0].getNodeList().size();i++){
				x[1] = nl[0].getNodeList().get(i).getFeature()[feature1];
				y[1] = nl[0].getNodeList().get(i).getFeature()[feature2];
				z[1] = nl[0].getNodeList().get(i).getFeature()[feature3];
				
				plot3d.addLinePlot("connect line", color_red, x, y, z);
			}
		}
		
		for(int j=0;j<test_nl.getNodeList().size();j++){
			x[0] = test_nl.getNodeList().get(j).getFeature()[feature1];
			y[0] = test_nl.getNodeList().get(j).getFeature()[feature2];
			z[0] = test_nl.getNodeList().get(j).getFeature()[feature3];
			
			for(int i=0;i<nl[1].getNodeList().size();i++){
				x[1] = nl[1].getNodeList().get(i).getFeature()[feature1];
				y[1] = nl[1].getNodeList().get(i).getFeature()[feature2];
				z[1] = nl[1].getNodeList().get(i).getFeature()[feature3];
				
				plot3d.addLinePlot("connect line", color_blue, x, y, z);
			}
		}
		
		for(int j=0;j<test_nl.getNodeList().size();j++){
			x[0] = test_nl.getNodeList().get(j).getFeature()[feature1];
			y[0] = test_nl.getNodeList().get(j).getFeature()[feature2];
			z[0] = test_nl.getNodeList().get(j).getFeature()[feature3];
			
			for(int i=0;i<nl[2].getNodeList().size();i++){
				x[1] = nl[2].getNodeList().get(i).getFeature()[feature1];
				y[1] = nl[2].getNodeList().get(i).getFeature()[feature2];
				z[1] = nl[2].getNodeList().get(i).getFeature()[feature3];
				
				plot3d.addLinePlot("connect line", color_green, x, y, z);
			}
		}
		
		JFrame frame = new JFrame();
		frame.setContentPane(plot3d);
		frame.setVisible(true);
		
		return plot3d;
			
	}
	
	public static Plot3DPanel plot_3d_thenearestpoint(KnnNode node, KnnNodeList[] nl,ArrayList<String> label_list,int feature1,int feature2,int feature3, int nearest){
		
		//define the Color
		Color color_red = new Color(255,0,0);
		Color color_green =new Color(0,255,0);
		Color color_blue = new Color(0,0,255);
		
		//use a array to store the node point
		double [] node_array = new double [3];
		node_array[0] = node.getFeature()[feature1];
		node_array[1] = node.getFeature()[feature2];
		node_array[2] = node.getFeature()[feature3];
				
		//define a ArrayList<ArrayList<PlotNode>> to store the training data's plotnode
		ArrayList<ArrayList<PlotNode>> plotnodelist = new ArrayList<ArrayList<PlotNode>>();
		
		for (int i=0;i<nl.length;i++){		
			plotnodelist.add(new ArrayList<PlotNode>());
		}
		
		for(int i=0;i<nl.length;i++){ 
			for (int j=0;j<nl[i].getNodeList().size();j++){
				//define a new PlotNode
				plotnodelist.get(i).add(new PlotNode());
				
				//set value
				plotnodelist.get(i).get(j).setLabel(nl[i].getNodeList().get(j).getLabel());
				plotnodelist.get(i).get(j).setFeature(nl[i].getNodeList().get(j).getFeature());
						
				//calculate the distance
				plotnodelist.get(i).get(j).setDistances(nl[i].getNodeList().get(j).disCal(node, feature1, feature2, feature3));
			}
		}
		
		
		//define a ArrayList<PlotNode> to store the whole plot node to sort
		ArrayList<PlotNode> dist_compare = new ArrayList<PlotNode>();
				
		for (int i=0;i<nl.length;i++){
			dist_compare.addAll(plotnodelist.get(i));
		}

		//		Collections.sort(dist_compare);//问问鄢神为什么不能实现
				
		//sorting process
		for(int i=0;i<dist_compare.size();i++){
			for(int j=i;j<dist_compare.size();j++){
				if(dist_compare.get(j).getDistances()<dist_compare.get(i).getDistances()){
					PlotNode temp = new PlotNode();
					
					temp.setLabel(dist_compare.get(i).getLabel());
					temp.setDistances(dist_compare.get(i).getDistances());
					temp.setFeature(dist_compare.get(i).getFeature());
					dist_compare.set(i, dist_compare.get(j));
					dist_compare.set(j, temp);
				}
			}
		}
		
		System.out.println("dist_compare is:"+dist_compare);
		
		
		
		//define a ArrayList<PlotNode> to just store the first k plot node
		ArrayList<PlotNode> nearestdistnode = new ArrayList<PlotNode> ();
		for (int i=0;i<nearest;i++){
			nearestdistnode.add(dist_compare.get(i));
		}
		int label1_num = 0;
		int label2_num = 0;
		int label3_num = 0;
		
		//judge the label of the plot node
		for (int i=0;i<nearest;i++){
			if(nearestdistnode.get(i).getLabel()==label_list.get(0)){
				label1_num++;
			}
			if(nearestdistnode.get(i).getLabel().equals(label_list.get(1))){
				label2_num++;
			}
			if(nearestdistnode.get(i).getLabel().equals(label_list.get(2))){
				label3_num++;
			}
		}
		
		//define three arrays to store the three types plot node
		double [][] a = new double [label1_num][3];
		double [][] b = new double [label2_num][3];
		double [][] c = new double [label3_num][3];
		
		
		for (int i=0,num1=0;i<nearest;i++){
			if (nearestdistnode.get(i).getLabel().equals(label_list.get(0))){
				a [num1][0] = nearestdistnode.get(i).getFeature()[feature1];
				a [num1][1] = nearestdistnode.get(i).getFeature()[feature2];
				a [num1][2] = nearestdistnode.get(i).getFeature()[feature3];
				num1++;
			}
		}
		
		for (int i=0,num2=0;i<nearest;i++){
			if (nearestdistnode.get(i).getLabel().equals(label_list.get(1))){
				b [num2][0] = nearestdistnode.get(i).getFeature()[feature1];
				b [num2][1] = nearestdistnode.get(i).getFeature()[feature2];
				b [num2][2] = nearestdistnode.get(i).getFeature()[feature3];
				num2++;
			}
		}
		
		for (int i=0,num3=0;i<nearest;i++){
			if (nearestdistnode.get(i).getLabel().equals(label_list.get(2))){
				c [num3][0] = nearestdistnode.get(i).getFeature()[feature1];
				c [num3][1] = nearestdistnode.get(i).getFeature()[feature2];
				c [num3][2] = nearestdistnode.get(i).getFeature()[feature3];
				num3++;
			}
		}
		
		
		Plot3DPanel plot3d = new Plot3DPanel();
		
		plot3d = Plot.plot_3d_inthreecolor(nl, feature1, feature2, feature3);
		
		
		for (int i=0;i<label1_num;i++){
			double [] x = new double [2];
			double [] y = new double [2];
			double [] z = new double [2];
			
			x[0] = node_array[0];
			x[1] = a[i][0];
			y[0] = node_array[1];
			y[1] = a[i][1];
			z[0] = node_array[2];
			z[1] = a[i][2];
			plot3d.addLinePlot("line", color_red, x, y, z);
		}
		
		for (int i=0;i<label2_num;i++){
			double [] x = new double [2];
			double [] y = new double [2];
			double [] z = new double [2];
			
			x[0] = node_array[0];
			x[1] = b[i][0];
			y[0] = node_array[1];
			y[1] = b[i][1];
			z[0] = node_array[2];
			z[1] = b[i][2];
			plot3d.addLinePlot("line", color_green, x, y, z);
		}
		
		for (int i=0;i<label3_num;i++){
			double [] x = new double [2];
			double [] y = new double [2];
			double [] z = new double [2];
			
			x[0] = node_array[0];
			x[1] = c[i][0];
			y[0] = node_array[1];
			y[1] = c[i][1];
			z[0] = node_array[2];
			z[1] = c[i][2];
			plot3d.addLinePlot("line", color_blue, x, y, z);
		}
		
		
		JFrame frame = new JFrame();
		frame.setContentPane(plot3d);
		frame.setVisible(true);
		
		return plot3d;
		
	}
	
		

}
