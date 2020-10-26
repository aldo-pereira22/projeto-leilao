package util;

public class Utilitarios {
	
	public static boolean isNumeric (String s) {
	    try {
	        Long.parseLong (s); 
	        return true;
	    } catch (NumberFormatException ex) {
	        return false;
	    }
	}

}
