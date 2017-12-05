import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;


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
			String[] values = line.split(" ");
			if(values.length == 3){
				x=Integer.parseInt(values[0]);
				y=Integer.parseInt(values[1]);
				w=(int) Float.parseFloat(values[2]);
				adjMat[x][y] = w;  
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
	
	public static int[][] createGraph(int nodes){
		Random rand = new Random(Integer.MAX_VALUE);
		int[][] adjMat = new int[nodes][nodes];
		//while(nodes <= 1000) {
			
			/*String fileName = "graph-"+nodes+".txt";		
			File fout = new File(fileName);
			FileOutputStream fos = new FileOutputStream(fout);	 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));*/
			
			for(int i=0; i < nodes; i++){
				for(int j=i+1; j < nodes; j++){
					if(i==j)
						continue;
					int weight = Math.abs(rand.nextInt()%100);
					adjMat[i][j] = weight;
					/*bw.write(""+i+"\t"+j+"\t"+weight);
					bw.newLine();*/
				}
			}
			//nodes += 200;
			
			//bw.close();
		//}
			
		return adjMat;
	}
	
	public static int[][] copyValues(int[][] adjMat, int size){
		int[][] newAdjMat = new int[size][size];
		
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				newAdjMat[i][j] = adjMat[i][j];
			}
		}
		
		return newAdjMat;
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