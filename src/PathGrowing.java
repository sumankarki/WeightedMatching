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
		
        int vertexCounter = 0;
		while(Util.isAllEdgeWefightZero(adjMat, size)) {
			
			//Choose an edge arbitrarily
			int vertex = vertices.get(vertexCounter);
			if(!Util.isDegreeAtLeastOne(adjMat, size, vertex)) {
				vertexCounter++;
				continue;
			}
			
			//Find the edge with maximum weight that is incident to x
			MaxWeightedEdge maxEdge = Util.findMaximumWeightedEdge(adjMat, size);
			if(maxEdge != null && maxEdge.weight > 0){
				//Remove all the incident edge 
				Util.removeAllEdgeAlongTheIndex(adjMat, size, maxEdge.indexX);
				Util.removeAllEdgeAlongTheIndex(adjMat, size, maxEdge.indexY);
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
