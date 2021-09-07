
public class Scores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] scores = {
				  //History, Math, java, Chem
				  {75,80,90,100},             //Student A
				  {65, 95, 70, 90},           //Student B
				  {55, 60,80,70}              //Student C
			};
		
		/*
		ArrayList<int> scoreSese = new ArrayList(5);
		
		scoreSese.add(70);
		scoreSese.add(65);
		scoreSese.add(55);
		scoreSese.add(95);
		scoreSese.add(80);
        */
      
		
		total_sum = 0;
		double total_max = 0;
		double total_min = 100;
		
		double history = 0;
		double math = 0;
		double java = 0;
		double chem = 0;
		
		for(int i = 0; i < scores.length; i++){
			double sum = 0;
			double max = 0;
			history += scores[i][0];
			math += scores[i][1];
			java += scores[i][2];
			chem += scores[i][3];
			for(int j = 0; j < scores[i].length; j++){
				sum += scores[i][j];
				total_sum += scores[i][j];
				if (scores[i][j] > max){
					max = scores[i][j];
				}
				if (scores[i][j] > total_max){
					total_max = scores[i][j];
				}
				if (scores[i][j] < total_min){
					total_min = scores[i][j];
				}
				
			}
			double avg = sum / scores[i].length;
			System.out.print("Average : " + avg + " ");
			System.out.println("Max : " + max);
		}
		
		System.out.println("Average of history : " + history / scores.length);
		System.out.println("Average of math : " + math / scores.length);
		System.out.println("Average of java : " + java / scores.length);
		System.out.println("Average of chem : " + chem / scores.length);
		
		
		System.out.println("Average of all the scores : " + total_sum / (scores.length * scores[0].length));
		System.out.println("Max of all the scores : " + total_max);
		System.out.println("Min of all the scores : " + total_min);

	}

}
