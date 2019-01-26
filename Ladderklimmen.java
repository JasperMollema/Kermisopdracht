
public class Ladderklimmen extends Attractie implements GokAttractie{
	double gereserveerdeBelasting;
	double brutoOmzet;
	protected String naam;
	protected double prijs;
	protected int oppervlakte;
	protected static int kaartjesVerkocht;
	protected static double omzet;

	Ladderklimmen(){
		this.prijs = 5;
		this.naam = "Ladderklimmen";
	}
	@Override
	void kaartjeKopen(Attractie attractie){
		double nettoOpbrengst = this.prijs*(1-percentage);
		kaartjesVerkocht++;
		omzet += nettoOpbrengst;
		brutoOmzet += this.prijs;
		new Kassa().kaartjeKopen(nettoOpbrengst);
		gereserveerdeBelasting += this.prijs*percentage;
	}

	
	@Override
	public void kansspelBelastingBetalen() {
		String belasting  = String.format("%.2f", gereserveerdeBelasting);
		System.out.println("Er is " + belasting + " betaald over " + brutoOmzet 
				+ " omzet voor de gokattracties");
		gereserveerdeBelasting = 0;
		brutoOmzet = 0;
		
	}
	@Override
	void draaien(Attractie attractie) {
		kaartjeKopen(attractie);
		System.out.println(this.naam + " draait!");
	}

	@Override
	void omzetTonen(Attractie attractie) {
		String omzet1  = String.format("%.2f", omzet);
		System.out.println("Omzet " + this.naam + ": " + omzet1 + " euro");
		}

	@Override
	void kaartjesTonen(Attractie attractie) {
		 System.out.println("Verkochte kaartjes " + this.naam + ": " + kaartjesVerkocht);
	}

}
