package Brugerautorisation.transport;

import Brugeraut.Diverse;
import Brugerautorisation.data.Bruger;
import Brugerautorisation.data.Brugerdatabase;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.jws.WebService;



@WebService(endpointInterface = "brugerautorisation.transport.soap.Brugeradmin")
public class BrugeradminImpl implements Brugeradmin {
	public Brugerdatabase db;

	@Override
	public Bruger hentBruger(String brugernavn, String adgangskode) {
		return db.hentBruger(brugernavn, adgangskode);
	}

	@Override
	public Bruger ∆ndrAdgangskode(String brugernavn, String adgangskode, String nyAdgangskode) {
		Bruger b = db.hentBruger(brugernavn, adgangskode);
		b.adgangskode = nyAdgangskode;
		db.gemTilFil(false);
		return b;
	}

	@Override
	public void sendEmail(String brugernavn, String adgangskode, String emne, String tekst) {
		Bruger b = db.hentBruger(brugernavn, adgangskode);
		try {
			Diverse.sendMail("DIST: "+emne, tekst, b.email);
		} catch (MessagingException ex) {
			ex.printStackTrace();
			throw new RuntimeException("fejl", ex);
		}
	}

	@Override
	public void sendGlemtAdgangskodeEmail(String brugernavn, String supplerendeTekst) {
		Bruger b = db.brugernavnTilBruger.get(brugernavn);
		try {
			Diverse.sendMail("DIST: Din adgangskode ",
					"K√¶re "+b.fornavn+",\n\nDit brugernavn er "+b.brugernavn+" og din adgangskode er: "+b.adgangskode
					+(b.sidstAktiv>0?"":"\n\nDu skal skifte adgangskoden for at bekr√¶fte at du f√∏lger kurset.\nSe hvordan p√• https://docs.google.com/document/d/1ZtbPbPrEKwSu32-SSmtcSWSQaeFid8YQI5FpI35Jkb0/edit?usp=sharing \n")
					+"\n"+supplerendeTekst,
					b.email);
		} catch (MessagingException ex) {
			ex.printStackTrace();
			throw new RuntimeException("fejl", ex);
		}
	}

	@Override
	public Object getEkstraFelt(String brugernavn, String adgangskode, String feltnavn) {
		return db.hentBruger(brugernavn, adgangskode).ekstraFelter.get(feltnavn);}
	


	@Override
	public void setEkstraFelt(String brugernavn, String adgangskode, String feltnavn, Object vÊrdi) {
		db.hentBruger(brugernavn, adgangskode).ekstraFelter.put(feltnavn, vÊrdi);
		db.gemTilFil(false);
	}
}

