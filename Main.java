
public class Main {

	public static void main(String[] args) {
		
		Kermis kermis = new Kermis();
		kermis.voegAttractieToe(new Botsautos());
		kermis.voegAttractieToe(new Spin());
		kermis.voegAttractieToe(new SpiegelPaleis());
		kermis.voegAttractieToe(new Spookhuis());
		kermis.voegAttractieToe(new Hawaii());
		kermis.voegAttractieToe(new Ladderklimmen());
		
		while (true) {
			String keuze = kermis.printKeuzes();
			kermis.leesInput(keuze);
		}
		

	}

}
