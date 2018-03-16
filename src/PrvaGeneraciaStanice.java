package objekty;

import java.util.ArrayList;
import java.util.List;

import ai.GUI;
import ai.Sledovatel;
import nadrze.Nadrz;
import nadrze.NadrzBenzin;
import nadrze.NadrzNafta;


public class  PrvaGeneraciaStanice extends CerpaciaStanica 
{

	//nadrze v zozname
		private List<Nadrz> nadrze = new ArrayList<Nadrz>();
		
		//observer
		List<Sledovatel> sledovatelia;
		
		//nadrze jednotlivo
		NadrzBenzin benzin;
		NadrzNafta nafta;
		
		
		//prisluzny centralny sklad k danej cerpacej stanici
		CentralnySklad centralnysklad;
	public PrvaGeneraciaStanice (String mesto,int generacia,CentralnySklad centralsklad, List<Sledovatel> sled)
	{
		//vytvorenie nadrze || priradenie centralnehop skladu || maximalna velkost
		benzin = new NadrzBenzin(centralsklad,20000); 
		nafta = new NadrzNafta(centralsklad,20000); 
		
	
		//pridanie nadrzi do zoznamu 
		nadrze.add(benzin);
		nadrze.add(nafta);
		
	
		//inicializacia mesta a generacie a prislusnehpo skladu
		centralnysklad=centralsklad;
		this.setGeneracia(generacia);
		this.setMesto(mesto);
		
		//prvotne napustenie nadrzi
		benzin.setVelkost(20000);
		nafta.setVelkost(20000);
		
		 sledovatelia = sled;
}

	
	public void predajpalivo()	 //metoda na predaj paliva abstraktnim zakaznikom // "kriticka uroven" je upozornenie nizskeho obsahu PHM ktora sa nesmie odcerpat lebo by doslo k podtlaku v cerpadlach co by si vyzadovalo nakladnu opravu 
	 {
		 GUI.Napis("Cerpacia Stanica v obci/meste "+this.getMesto());
		 GUI.Napis("Je to benzinka " +this.getGeneracia()+". generacie");
	 		System.out.println("toto je benzinka v obci/meste "+this.getMesto());
			System.out.println("je to benzinka " +this.getGeneracia()+". generacie");
			

			
			//volanie observera 
			for(Sledovatel s : sledovatelia) {
			s.pozrisa(nadrze);
			}
			GUI.Napis("");
			 GUI.Napis("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
			System.out.println("");
			System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
			

	 }
		
			
		
	
		
		
		
		
	

}

