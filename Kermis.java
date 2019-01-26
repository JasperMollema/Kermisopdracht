import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kermis {
	private Scanner lezer = new Scanner (System.in);
	private static List<Attractie> attracties = new ArrayList<>();
	
	
	void voegAttractieToe(Attractie attractie) {
		if(!(attracties.contains(attractie)))
		attracties.add(attractie);
	}
	
	String printKeuzes() {
		System.out.println("Wat wil je doen? \r"
				+ "Kies d voor attractie draaien, \r"
				+ "Kies o voor omzet tonen. \r"
				+ "Kies k voor verkochte kaartjes tonen. \r"
				+ "Kies m om monteur te laten komen \r"
				+ "Kies b om belasting te betalen \r"
				+ "Kies s om te stoppen");	
		return lezer.nextLine().toLowerCase();
	}
	
	void leesInput(String keuze){
		if (keuze.equals("d")) {
			attractieKiezen(kiesAttractie());
		}
		else if(keuze.equals("o")) {
			new Kassa().omzetTonen(attracties);
		}
		else if(keuze.equals("k")) {
			new Kassa().kaartjesTonen(attracties);
		}
		else if(keuze.equals("m")){
			monteurHalen();
		}
		else if(keuze.equals("s")) {
			stoppen();
		}
		else {
			System.out.println("dat is geen optie, kies opniew");
			leesInput(lezer.nextLine().toLowerCase());
		}
	}
	
	void monteurHalen() {
		for(Attractie attractie : attracties) {
			if(attractie instanceof RisicoRijkeAttracties)
			new Monteur().inpecteren((RisicoRijkeAttracties) attractie);
			}		
	}
	

	String kiesAttractie() {
		System.out.println("Welke attractie? \r"
				+ "Kies 1 voor botsauto's \r"
				+ "Kies 2 voor spin \r"
				+ "Kies 3 voor spiegelPaleis \r"
				+ "Kies 4 voor spookhuis \r"
				+ "Kies 5 voor hawaii \r"
				+ "Kies 6 voor ladderklimmen \r");
		return lezer.nextLine();
	}
	
	void attractieKiezen(String keuze) {
		switch(keuze){
		case "1" :	attractieDraaien(new Botsautos());
			break;
		case "2" : 	attractieDraaien(new Spin());
			break;
		case "3" :	attractieDraaien(new SpiegelPaleis());
			break;
		case "4" : 	attractieDraaien(new Spookhuis());
			break;
		case "5" :	attractieDraaien(new Hawaii());
			break;
		case "6" : 	attractieDraaien(new Ladderklimmen());
			break;
		default : 	leesInput(printKeuzes());		
			break;
		}
	}
	
	void attractieDraaien(Attractie attractie) {
		System.out.println("");
		attractie.draaien(attractie);
		System.out.println("");
	}
	
	void stoppen() {
		System.exit(0);
	}

}
