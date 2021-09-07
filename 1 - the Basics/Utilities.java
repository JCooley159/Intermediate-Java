import java.util.ArrayList;

public class Utilities {
	
	public static SmartTV pickExpensive(ArrayList<SmartTV> tvs){
		SmartTV expensiveOne = tvs.get(0);
		
		for(SmartTV tv: tvs){
			if(tv.getPrice() > expensiveOne.getPrice()){
				expensiveOne = tv;
			}
		}
		
		return expensiveOne;
	}

}
