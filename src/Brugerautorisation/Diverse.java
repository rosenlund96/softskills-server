package Brugerautorisation;

import java.lang.reflect.Field;

public class Diverse {

/**
	* Tager et vilkårligt objekt og laver en streng ud af dets public variabler
	* @param obj Objektet
	* @return En streng med alle dets public variabler
	*/
	public static String toString(Object obj) {
		StringBuilder sb = new StringBuilder();
		Class k = obj.getClass();
		sb.append(k.getSimpleName()).append(':');
		for (Field felt : k.getFields()) try {
			Object værdi = felt.get(obj);
			sb.append(' ').append(felt.getName()).append('=').append('"').append(String.valueOf(værdi)).append('"');
		} catch (Exception e) { e.printStackTrace(); }
		return sb.toString();
	}

/**
	* Tager et vilkårligt objekt og laver en kommasepareret streng med dets data
	* @param obj Objektet
	* @return En streng kommasepareret streng med dets data
	*/
	public static String tilCsvLinje(Object obj) {
		StringBuilder sb = new StringBuilder();
		Class k = obj.getClass();
		for (Field felt : k.getFields()) try {
			Object værdi = felt.get(obj);
			sb.append('"').append(String.valueOf(værdi).replaceAll("\"", "\\\"").replaceAll("\n", "\\n")).append('"').append(',');
		} catch (Exception e) { e.printStackTrace(); }
		return sb.substring(0,sb.length()-1); // fjern sidste komma
	}

public static void sendMail(String string, String string2, String email) {
	// TODO Auto-generated method stub
	
}

}
