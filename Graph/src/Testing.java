import org.w3c.dom.NodeList;


public class Testing {
	
	public static void main (String[] args){
		
		GraphEdgeNode node1 = new GraphEdgeNode (1,null);
		GraphEdgeNode node2 = new GraphEdgeNode (2,null);
		GraphEdgeNode node3 = new GraphEdgeNode (3,null);
		GraphEdgeNode node4 = new GraphEdgeNode (4,null);
		GraphEdgeNode node5 = new GraphEdgeNode (5,null);
		
		
		Graph graph = new Graph();
		
		graph.getNodelist().add(node1);
		graph.getNodelist().add(node2);
		graph.getNodelist().add(node3);
		graph.getNodelist().add(node4);
		graph.getNodelist().add(node5);
		
		
		GraphEdgeNode edgenode1 = new GraphEdgeNode(3);
		graph.getNodelist().get(0).setNextedge(edgenode1);
		GraphEdgeNode edgenode2 = new GraphEdgeNode(2);
		edgenode1.setNextedge(edgenode2);
		
		GraphEdgeNode edgenode3 = new GraphEdgeNode(4);
		graph.getNodelist().get(2).setNextedge(edgenode3);
		
		
		GraphEdgeNode edgenode4 = new GraphEdgeNode(1);
		graph.getNodelist().get(3).setNextedge(edgenode4);
		
		GraphEdgeNode edgenode5 = new GraphEdgeNode(1);
		graph.getNodelist().get(4).setNextedge(edgenode5);
		
		
		System.out.println("********************************");
		
		//invoke the display_DFS function
		graph.display_DFS();
		System.out.println("********************************");
		
		
		
		System.out.println("construct a new graph2.");
		
		
		
		
		
		Graph graph2 = new Graph();
		
		GraphEdgeNode node6 = new GraphEdgeNode(1,null);
		GraphEdgeNode node7 = new GraphEdgeNode(2,null);
		GraphEdgeNode node8 = new GraphEdgeNode(3,null);
		GraphEdgeNode node9 = new GraphEdgeNode(4,null);
		GraphEdgeNode node10 = new GraphEdgeNode(5,null);
		
		graph2.getNodelist().add(node6);
		graph2.getNodelist().add(node7);
		graph2.getNodelist().add(node8);
		graph2.getNodelist().add(node9);
		graph2.getNodelist().add(node10);
		
		GraphEdgeNode edgenode6 = new GraphEdgeNode(3);
		graph2.getNodelist().get(0).setNextedge(edgenode6);
		GraphEdgeNode edgenode7 = new GraphEdgeNode(5);
		edgenode6.setNextedge(edgenode7);
		
		GraphEdgeNode edgenode8 = new GraphEdgeNode(1);
		graph2.getNodelist().get(1).setNextedge(edgenode8);

		GraphEdgeNode edgenode9 = new GraphEdgeNode(4);
		graph2.getNodelist().get(2).setNextedge(edgenode9);
		
		GraphEdgeNode edgenode10 = new GraphEdgeNode(1);
		graph2.getNodelist().get(3).setNextedge(edgenode10);
		
		

		
		
		
		
		System.out.println("********************************");
		
		//invoke the display_DFS function
		graph2.display_DFS();
		System.out.println("********************************");
		
		
		
		System.out.println("construct a new graph3.");
		
		Graph graph3 = new Graph();
		
		GraphEdgeNode node11 = new GraphEdgeNode(1,null);
		GraphEdgeNode node12 = new GraphEdgeNode(2,null);
		GraphEdgeNode node13 = new GraphEdgeNode(3,null);
		GraphEdgeNode node14 = new GraphEdgeNode(4,null);
		GraphEdgeNode node15 = new GraphEdgeNode(5,null);
		
		graph3.getNodelist().add(node11);
		graph3.getNodelist().add(node12);
		graph3.getNodelist().add(node13);
		graph3.getNodelist().add(node14);
		graph3.getNodelist().add(node15);
		
		GraphEdgeNode edgenode11 = new GraphEdgeNode(1,null);
		graph3.getNodelist().get(1).setNextedge(edgenode11);
		
		GraphEdgeNode edgenode12 = new GraphEdgeNode(2,null);
		graph3.getNodelist().get(2).setNextedge(edgenode12);
		
		GraphEdgeNode edgenode13 = new GraphEdgeNode(5,null);
		graph3.getNodelist().get(3).setNextedge(edgenode13);
		
		GraphEdgeNode edgenode14 = new GraphEdgeNode(3,null);
		graph3.getNodelist().get(4).setNextedge(edgenode14);
		
		System.out.println("********************************");
		
		//invoke the display_DFS function
		graph3.display_DFS();
		System.out.println("********************************");
		
		
		System.out.println("construct a new graph graph4.");
		
		Graph graph4 = new Graph();
		
		GraphEdgeNode node16 = new GraphEdgeNode(1,null);
		GraphEdgeNode node17 = new GraphEdgeNode(2,null);
		GraphEdgeNode node18 = new GraphEdgeNode(3,null);
		GraphEdgeNode node19 = new GraphEdgeNode(4,null);
		GraphEdgeNode node20 = new GraphEdgeNode(5,null);
		
		graph4.getNodelist().add(node16);
		graph4.getNodelist().add(node17);
		graph4.getNodelist().add(node18);
		graph4.getNodelist().add(node19);
		graph4.getNodelist().add(node20);
	
		GraphEdgeNode edgenode16 = new GraphEdgeNode(3,null);
		graph4.getNodelist().get(0).setNextedge(edgenode16);
		GraphEdgeNode edgenode17 = new GraphEdgeNode(5,null);
		edgenode16.setNextedge(edgenode17);
		GraphEdgeNode edgenode18 = new GraphEdgeNode(4,null);
		edgenode17.setNextedge(edgenode18);
		GraphEdgeNode edgenode19 = new GraphEdgeNode(2,null);
		edgenode19.setNextedge(edgenode19);
		
		GraphEdgeNode edgenode20 = new GraphEdgeNode(5,null);
		graph4.getNodelist().get(2).setNextedge(edgenode20);
		
		GraphEdgeNode edgenode21 = new GraphEdgeNode(2,null);
		graph4.getNodelist().get(3).setNextedge(edgenode21);
		
		GraphEdgeNode edgenode22 = new GraphEdgeNode(4,null);
		graph4.getNodelist().get(4).setNextedge(edgenode22);
		
		
		
		
		System.out.println("********************************");
		
		//invoke the display_DFS function
		graph4.display_DFS();
		System.out.println("********************************");
		
	}

}
