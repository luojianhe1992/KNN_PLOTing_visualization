
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
		
		
		System.out.println("construct a new graph.");
		
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
		
		
		System.out.println("********"+graph2.getNodelist().get(0).getNextedge().getNextedge().getValue());
		
	}

}
