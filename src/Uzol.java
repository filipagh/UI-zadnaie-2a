import java.util.List;


	
public class Uzol {

	private int hlbka;
	private int xsur;
	private int ysur;
	private List<Vozidlo> vozpark;
	private List<Prikaz> zoznam;
	private int[][] matica;
	
	public Uzol (List<Vozidlo> importuj,int xi,int yi)
	{
	xsur= xi;
	ysur= yi;
	vozpark = importuj;	
	hladaj();
	}
	
	public Uzol (List<Vozidlo> importuj,List<Prikaz> zoznamimp,int xi,int yi)
	{
	xsur= xi;
	ysur= yi;
	vozpark = importuj;	
	zoznam = zoznamimp;
	hladaj();
	}

	public void hladaj()
	{
		// KONTROLA HASH
		// SEEEEEEEEEEEEEEEEEEEEEEEEEMMMMMMMMMMMMMMMMMM
		
		matica = new int[xsur][ysur];
		//TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU
		for(Vozidlo n : vozpark) 
		{
			for (int k = 0; k < n.getTyp(); k++)
			{
				matica[n.getXsur()][n.getYsur()]=n.getId()
			}
			
		}
		

	}
}
