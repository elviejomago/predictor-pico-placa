import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Prueba {

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		
		try {
			System.out.println(format.parse("15:24"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
