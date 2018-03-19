
public class Prikaz {
	 private int id;
	 private int pocet;
	 private int smer;
	 
	 public Prikaz(int idcko,int kolko,int smerr)
	 {
		 id=idcko;
		 pocet=kolko;
		 smer = smerr;
	 }
	 public Prikaz(Prikaz p)
	 {
		 id=p.getId();
		 pocet=p.getPocet();
		 smer = p.getSmer();
	 }

	public int getId() {
		return id;
	}

	public int getPocet() {
		return pocet;
	}

	public int getSmer() {
		return smer;
	}
	 
	 
	 
}
