
public class BelastingInspecteur {
	
	void hefBelasting(GokAttractie attractie) {
		attractie.kansspelBelastingBetalen();
	}
	
	void checkGokAttractie(Attractie attractie) {
		if(attractie instanceof GokAttractie) {
			hefBelasting((GokAttractie)attractie);
		}
	}
}
