
public class Hawaii extends RisicoRijkeAttracties {
	private String naam;
	private double prijs;
	private int oppervlakte;
	private int laatsteOnderhoud; 
	private static int kaartjesVerkocht;
	private static double omzet;
	private int draaiLimiet;
	private boolean onderhoudNodig;

	Hawaii(){
		this.prijs = 2.9;
		this.draaiLimiet = 10;
		this.naam = "Hawaii";
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
		laatsteOnderhoud++;
		new Kassa().kaartjeKopen(this.prijs);
		}
	
	
	@Override
	void opstellingsKeuring() {
		if(laatsteOnderhoud < draaiLimiet)
			onderhoudNodig = true;
	}


}
