package ai;

import objekty.CerpaciaStanica;

import java.util.ArrayList;
import java.util.List;


import objekty.CentralnySklad;
import objekty.PrvaGeneraciaStanice;
import objekty.Rafineria;
import objekty.DruhaGeneraciaStanice;
import objekty.TretiaGeneraciaStanice;
import objekty.DialnicnaGeneraciaStanice;

//import java.io.*;
//import java.util.*;



public class AI   {
	
	public AI (){
		vytvor();
	}
	
	private List<Sledovatel> sledovatelia ;
	private List<CentralnySklad> centsklad;
	private List<CerpaciaStanica> cs ;
	Rafineria raf;
	
	
	

	void pridajcentralnysklad(CentralnySklad cent)
	{	
		centsklad.add(cent);
	}
	
	void pridajcerpaciustanicu(CerpaciaStanica cerps)
	{	
		cs.add(cerps);
	}
	
	
	
 void pridajsledovatela(Sledovatel sled)
{	
	sledovatelia.add(sled);
}
    
    public void vytvor ()
    {
    	sledovatelia = new ArrayList<Sledovatel>();
		pridajsledovatela(new KontrolaKritickejhladinyNadrze());
		pridajsledovatela(new KontrolaHladinyNadrze());
    	
		 centsklad = new ArrayList<CentralnySklad>();
		// pridajcentralnysklad(new CentralnySklad("bratislava"));
		// pridajcentralnysklad(new CentralnySklad("kosice"));
		

		
		cs = new ArrayList<CerpaciaStanica>();
		
//	pridajcerpaciustanicu(new DialnicnaGeneraciaStanice("kosice",4,centsklad.get(1),sledovatelia));
		//pridajcerpaciustanicu(new TretiaGeneraciaStanice("bratislava",3,centsklad.get(0),sledovatelia));
		//pridajcerpaciustanicu(new PrvaGeneraciaStanice("dunajska luzna",1,centsklad.get(0),sledovatelia));
	//	pridajcerpaciustanicu(new DruhaGeneraciaStanice("rovinka",2,centsklad.get(0),sledovatelia));
	//	pridajcerpaciustanicu(new PrvaGeneraciaStanice("kalinkovo",1,centsklad.get(0),sledovatelia));
	//	pridajcerpaciustanicu(new PrvaGeneraciaStanice("hamuliakovo",1,centsklad.get(0),sledovatelia));
	//	pridajcerpaciustanicu(new DruhaGeneraciaStanice("kosice",2,centsklad.get(1),sledovatelia));
	//	pridajcerpaciustanicu(new DialnicnaGeneraciaStanice("kisak",4000,centsklad.get(1),sledovatelia));


	
	
		
		

		 raf = new Rafineria(centsklad,sledovatelia);
    }
 
//	public static void main (String[] args)
	public void mainn ()
	{	
		
		
		
		
		
		int pocetdni = 1;    //// tu sa urcuje kolko dni ma simulovat proces 
		
		
		
		
		
		
		

		for (int k = 0; k < pocetdni; k++)
		{                          
			System.out.println("----------------------------");
			
			for (int i = 0; i < cs.size(); i++) 
			{
				cs.get(i).predajpalivo();
			
			}
			
			raf.spocitajpaliva();
		}
		
		
			
	}

	public Rafineria getRaf() {
		return raf;
	}


	
	public List<CentralnySklad> getCentsklad() {
		return centsklad;
	}

	public List<Sledovatel> getSledovatelia() {
		return sledovatelia;
	}


	


	


	

}

