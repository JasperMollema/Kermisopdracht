import java.util.List;

public class Kassa {
	private static double totaleOmzet;
	private static int verkochteKaartjes;
	
	
	void omzetTonen(List<Attractie> attracties) {
		System.out.println("");
		for (Attractie attractie : attracties) {
			attractie.omzetTonen(attractie);
		}
		String omzet1  = String.format("%.2f", totaleOmzet);
		System.out.println("Totale omzet: " + omzet1);
		System.out.println("");
	}
	
	void kaartjesTonen(List<Attractie> attracties) {
		System.out.println("");
		for (Attractie attractie : attracties) {
			attractie.kaartjesTonen(attractie);
		}
		System.out.println("Totaal verkochte kaartjes " + verkochteKaartjes);
		System.out.println("");
	}
	
	void kaartjeKopen(double prijs) {
		verkochteKaartjes++;
		totaleOmzet += prijs;
	}

}
