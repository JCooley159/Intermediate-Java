import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class T1_Gradebook implements T1_GradeBookInterface {

	private ArrayList<Double> gradeAL;
	
	public static void main(String[] args) {
		
		ArrayList<Double> gradeAL = new ArrayList<Double>();		
		Scanner input = new Scanner(System.in);
		T1_Gradebook gdbk = new T1_Gradebook();
		int i = 1;
		boolean valid = true;
		
		
		while (valid) {			
			System.out.println("Enter grade number " + i + ". Enter a negative number to quit.");
			Double loopDouble = input.nextDouble();
			i++;
			gdbk.enterGrade(loopDouble);
			if (loopDouble < 0) {
				valid = false;
			}
		}
		
		
		System.out.print(gdbk.getMaxScore(gradeAL));
		System.out.print(gdbk.getMinScore(gradeAL));
		System.out.printf("%.2f", gdbk.getAverage(gradeAL));
		input.close();
	}
	
	@Override
	public double getMaxScore(ArrayList<Double> gradeAL) {
		return Collections.max(gradeAL);		
	}
	
	@Override
	public double getMinScore(ArrayList<Double> gradeAL) {
		return Collections.min(gradeAL);
	}


	@Override
	public double getAverage(ArrayList<Double> gradeAL) {
		double sum = 0;
		for (int i = 0; i < gradeAL.size(); i++) {
			sum = sum + gradeAL.get(i);
		}
		double average = sum / gradeAL.size();
		return average;
	}


	@Override
	public void enterGrade(double grade) {
		gradeAL.add(grade);		
	}

}
