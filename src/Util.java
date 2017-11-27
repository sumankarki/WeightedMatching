import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Util {
	
	public static MaxWeightedEdge findMaximumWeightedEdge(int[][] adjMat, int size){
		int x=0, y=0, w=0;
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if(adjMat[i][j] > w){
					x=i;
					y=j;
					w=adjMat[i][j];
				}
			}
		}
		return new MaxWeightedEdge(x, y, w);
	}
	
	public static MaxWeightedEdge findHeviestEdgeForVertex(int[][] adjMat, int size, int vertex){
		int x=0, y=0, w=0;
		for(int i=0; i<size; i++){			
			if(adjMat[i][vertex] > w){
				x=i;
				y=vertex;
				w=adjMat[i][vertex];
			}
			if(adjMat[vertex][i] > w){
				x=vertex;
				y=i;
				w=adjMat[vertex][i];
			}
		}
		return new MaxWeightedEdge(x, y, w);
	}
	
	public static void removeAllEdgeAlongTheIndex(int[][] adjMat, int size, int vertex){
		for(int i=0; i<size; i++){
			adjMat[vertex][i] = 0;
			adjMat[i][vertex] = 0;
		}
	}
	
	public static boolean isAllEdgeWeightZero(int[][] adjMat, int size){
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(adjMat[i][j] > 0){
					return false;
				}
			}
		}		
		return true;
	}
	
	public static boolean hasNeighbor(int[][] adjMat, int size, int vertex){
		for(int i=0; i<size; i++) {
			if(adjMat[i][vertex] > 0){
				return true;
			}
			
			if(adjMat[vertex][i] > 0){
				return true;
			}
		}		
		return false;
	}
	
	public static void readFromFile(int[][] adjMat, String fileName) throws IOException{
		FileInputStream fis = new FileInputStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
		String line = null;		
		while ((line = br.readLine()) != null) {
			int x=0, y=0, w=0;
			String[] values = line.split(",");
			if(values.length == 3){
				x=Integer.parseInt(values[0]);
				y=Integer.parseInt(values[1]);
				w=Integer.parseInt(values[2]);
				
				adjMat[x-1][y-1] = w;  //Reducing one because the node index in array starts from 0
			}
		}
		br.close();
		fis.close();
	}
	
	public static boolean isDegreeAtLeastOne(int[][] adjMat, int size, int vertex) {
		
		for(int i=0; i<size; i++) {
			if(adjMat[i][vertex] > 0)
				return true;
			if(adjMat[vertex][i] > 0)
				return true;
		}
		return false;
	}

}

class MaxWeightedEdge{
	int indexX;
	int indexY;
	int weight;
	
	public MaxWeightedEdge(){}
	
	public MaxWeightedEdge(int x, int y, int w){
		indexX=x; indexY=y; weight=w;
	}
}