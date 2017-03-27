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
		FileOutputStream datastrÝm = new FileOutputStream(filnavn);
		ObjectOutputStream objektstÝm = new ObjectOutputStream(datastrÝm);
		objektstÝm.writeObject(obj);
		objektstÝm.close();
	}

	public static Serializable hent(String filnavn) throws Exception
	{
		System.out.println("Indl√¶ser filen "+filnavn);
		FileInputStream datastrÝm = new FileInputStream(filnavn);
		ObjectInputStream objektstrÝm = new ObjectInputStream(datastrÝm);
		Serializable obj = (Serializable) objektstrÝm.readObject();
		objektstrÝm.close();
		return obj;
	}
}