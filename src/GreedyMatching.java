import java.util.ArrayList;


public class GreedyMatching {
	
	public static int performGreedyMatching(int[][] adjMat, int size){
		ArrayList<MaxWeightedEdge> M = new ArrayList<MaxWeightedEdge>();
		
		while(!Util.isAllEdgeWeightZero(adjMat, size)) {
			MaxWeightedEdge maxEdge = Util.findMaximumWeightedEdge(adjMat, size);
			if(maxEdge != null && maxEdge.weight > 0){
				//Add the edge to the result
				M.add(maxEdge);
				
				//Remove all the incident edge 
				Util.removeAllEdgeAlongTheIndex(adjMat, size, maxEdge.indexX);
				Util.removeAllEdgeAlongTheIndex(adjMat, size, maxEdge.indexY);
			}
		}
		int maxSum=0;
		for(MaxWeightedEdge edge : M){
			maxSum += edge.weight;
		}
		return maxSum;
	}

}
