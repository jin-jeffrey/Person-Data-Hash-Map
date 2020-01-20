package homework6;

import java.util.Comparator;

public class WeightComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if (Integer.parseInt(o1)>Integer.parseInt(o2)) {
			return -1;
		}
		if (Integer.parseInt(o1)<Integer.parseInt(o2)) {
			return 1;
		}
		return 0;
	}

}
