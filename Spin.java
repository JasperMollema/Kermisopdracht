
public class Spin extends RisicoRijkeAttracties{
	protected String naam;
	protected double prijs;
	protected int oppervlakte;
	protected static int kaartjesVerkocht;
	protected static double omzet;
	protected int draaiLimiet;
	private int laatsteOnderhoud;
	private boolean onderhoudNodig;
		
	Spin(){
		this.prijs = 2.25;
		this.draaiLimiet = 5;
		this.naam = "Spin";
	}
	
	@Override String keuren(Attractie attractie){
		laatsteOnderhoud = 0;
		return naam;
	}

	@Override
	void draaien(Attractie attractie) {
		opstellingsKeuring();
		if(onderhoudNodig) {
			System.out.println("Draailimiet bereikt, eerst monteur bellen!");
			return;
		}
		kaartjeKopen(attractie);
		System.out.println(this.naam + " draait!");
		laatsteOnderhoud++;
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
	
	void kaartjeKopen(Attractie attractie) {
			omzet += this.prijs;
			kaartjesVerkocht++;
			new Kassa().kaartjeKopen(this.prijs);
			}
	
	@Override
	void opstellingsKeuring() {
		if(laatsteOnderhoud == draaiLimiet)
			onderhoudNodig = true;
	}


}
