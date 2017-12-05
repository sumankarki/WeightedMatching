import java.io.IOException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author suman
 *
 */
public class MainClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//String fileName;
		int size=10;
		
		Scanner scan = new Scanner(System.in);
		System.out.printf("Enter how many nodes: ");
		int nodes = scan.nextInt();
		
		System.out.println();
		System.out.println();
		System.out.println("Creating graph...");
		
		if(nodes > 0)
			size = nodes;
		int[][] adjMatGreedy = new int[size][size];
		
		if(nodes == 0) {
			Util.readFromFile(adjMatGreedy, "graph.txt");
		} else
			adjMatGreedy = Util.createGraph(size);
		
		int [][] adjPathGrowing = new int[size][size]; 
		adjPathGrowing = Util.copyValues(adjMatGreedy, size);
		
		System.out.println("Graph created successfully...");
		
		//Util.readFromFile(adjMat, fileName);
		/*for(int i=0; i<size;i++){
			for(int j=0; j<size; j++){
				System.out.printf(""+adjMatGreedy[i][j]+"\t");
			}
			System.out.println();
		}*/
		
		System.out.println();
		System.out.println("******************************");
		System.out.println();
		System.out.println("Performing Greedy Matching...");
		int max = GreedyMatching.performGreedyMatching(adjMatGreedy, size);
		System.out.println();
		System.out.println("Greedy Matching Completed...");
		System.out.println("The maximal matching is  " +max);
		//Util.readFromFile(adjMat, fileName);
		
		/*for(int i=0; i<size;i++){
			for(int j=0; j<size; j++){
				System.out.printf(""+adjPathGrowing[i][j]+"\t");
			}
			System.out.println();
		}*/
		
		System.out.println();
		System.out.println("******************************");
		System.out.println();
		System.out.println("Performing Path Growing Matching...");
		max = PathGrowing.performPathGrowing(adjPathGrowing, size);
		System.out.println();
		System.out.println("Path Growing Matching Completed...");
		System.out.println("The maximal matching is  " +max);
		System.out.println("******************************");
	}

}
