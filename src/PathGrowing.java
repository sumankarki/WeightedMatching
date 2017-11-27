import java.util.ArrayList;
import java.util.Collections;

public class PathGrowing {
	
	public static int performPathGrouwing(int[][] adjMat, int size){
		ArrayList<MaxWeightedEdge> M1 = new ArrayList<MaxWeightedEdge>();
		ArrayList<MaxWeightedEdge> M2 = new ArrayList<MaxWeightedEdge>();
		
		//For random pick of vertex later
		ArrayList<Integer> vertices = new ArrayList<Integer>();
        for (int i=1; i<11; i++) {
        	vertices.add(i);
        }
        Collections.shuffle(vertices);		
		
        int vertexCounter = -1, set=1;
		while(Util.isAllEdgeWeightZero(adjMat, size)) {
			
			vertexCounter++;
			
			//Choose an edge arbitrarily
			int vertex = vertices.get(vertexCounter);
			if(!Util.isDegreeAtLeastOne(adjMat, size, vertex)) {
				continue;
			}
			
			while(Util.hasNeighbor(adjMat, size, vertex)){
				
				//Find the heaviest edge incident on vertex chosen randomly
				MaxWeightedEdge heaviestEdge = Util.findHeviestEdgeForVertex(adjMat, size, vertex);
				if(set == 1)
					M1.add(heaviestEdge);
				else
					M2.add(heaviestEdge);
				set=3-set;
				
				//Removing vertex from the graph. i.e., removing all the edge that touches the vertex
				Util.removeAllEdgeAlongTheIndex(adjMat, size, vertex);
				
				vertex = (heaviestEdge.indexX == vertex)? heaviestEdge.indexY : heaviestEdge.indexX;
			}
		}
		
		int maxSum1 = 0;
		for(MaxWeightedEdge edge : M1){
			maxSum1 += edge.weight;
		}
		
		int maxSum2=0;
		for(MaxWeightedEdge edge : M2){
			maxSum2 += edge.weight;
		}
		
		return Math.max(maxSum1, maxSum2);
	}
	
}
