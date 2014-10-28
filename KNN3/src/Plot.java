import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.math.plot.Plot2DPanel;
import org.math.plot.Plot3DPanel;


public class Plot {
	
	//the function to print out the scatter points of the training data.
	public static void plot_2d (ArrayList<KnnNode> list, int feature1, int feature2 ){
		
		
		System.out.println(":):):):):):):):):):):):):):):):):):):)");
		
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
		
		
		System.out.println(":):):):):):):):):):):):):):):):):):):)");
		
		
		
	}
	
	//print out the scatter of the three type in red, green and blue
	public static void plot_2d_inthreecolor(KnnNodeList [] nl, int feature1, int feature2){
		
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
	}
	
	
	//print out the three type and use a node to connect with all of them
	public static void plot_2d(KnnNode node, KnnNodeList [] nl,  int feature1, int feature2){
			
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
	}
	
	
	//2d connect line, three type, all the testing data
	public static void plot_2d(KnnNodeList test_nl, KnnNodeList[] nl,int feature1,int feature2){
		
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
		
	
	
	}
	
	
	
	
	
	//print out the scatter of the three type in red, green and blue in three dimension panel
	public static void plot_3d(ArrayList<KnnNode> list, int feature1, int feature2, int feature3){
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
	}
	
	//print out the scatter points in three types and 
	public static void plot_3d_inthreecolor(KnnNodeList [] nl, int feature1, int feature2, int feature3){
		
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
		plot3d.addScatterPlot("scatterpointblue", color_blue, x2, y2, z2);
		plot3d.addScatterPlot("scatterpointgreen", color_green, x3, y3, z3);
		
		JFrame frame = new JFrame();
		frame.setContentPane(plot3d);
		frame.setVisible(true);
		                           
		                        		   
	}
	
	
	
	//connect line, three type, one node
	public static void plot_3d(KnnNode node, KnnNodeList[] nl, int feature1, int feature2, int feature3){
		
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

	
	}
	
	
	
	//3d connect line, three type, all the testing data
	public static void plot_3d(KnnNodeList test_nl, KnnNodeList[] nl,int feature1,int feature2, int feature3){
			
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
			
	}
	
		

}
