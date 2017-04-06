package Brugeraut;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class Serialisering
{
	public static void gem(Serializable obj, String filnavn) throws IOException
	{
		System.out.println("Gemmer filen "+filnavn);
		FileOutputStream datastr�m = new FileOutputStream(filnavn);
		ObjectOutputStream objektstr�m = new ObjectOutputStream(datastr�m);
		objektstr�m.writeObject(obj);
		objektstr�m.close();
	}

	public static Serializable hent(String filnavn) throws Exception
	{
		System.out.println("Indlæser filen "+filnavn);
		FileInputStream datastr�m = new FileInputStream(filnavn);
		ObjectInputStream objektstr�m = new ObjectInputStream(datastr�m);
		Serializable obj = (Serializable) objektstr�m.readObject();
		objektstr�m.close();
		return obj;
	}
}