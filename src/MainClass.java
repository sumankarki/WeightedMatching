import java.io.IOException;

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
		String fileName;
		if(args.length > 1)
			fileName = args[0];
		else
			fileName = "graph.txt";
		
		int size=5;
		int[][] adjMat = new int[size][size];
		Util.readFromFile(adjMat, fileName);
		int max = GreedyMatching.performGreedyMatching(adjMat, size);
		System.out.println("Max: " +max);
	}

}
