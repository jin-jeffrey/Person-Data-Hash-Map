package homework6;
import java.util.Comparator;
public class NameComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if (o1.compareTo(o2)>0) {
			return -1;
		}
		if (o1.compareTo(o2)<0) {
			return 1;
		}
		return 0;
	}

}
