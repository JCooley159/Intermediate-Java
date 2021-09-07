
public class ArrayTestScores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		int[][] scores = {
				{75,80,90,100},
				{65,95,70,90},
				{55,60,80,70},
		};
		
		// export excel file into .csv file 
	
		
		for (int i = 0; i <= scores.length - 1; i++) {
			
			double sum = 0;
			double max = 0;
			
				for (int j = 0; j <= scores[i].length - 1; j++) {
					
					sum += scores[i][j];
							
						if (scores[i][j] >= max ) {
							max = scores[i][j];
						}
				}
				
			double avg = sum/scores[i].length;
			
			
			System.out.println("The average score of row " + i + " is " + avg + ".");
			System.out.println("The max score of row " + i + " is " + max + "." + "\n");
		}
		
		
		
		
		
		
		
	}

}
