package ai;


import java.util.List;

import nadrze.Nadrz;
import objekty.Rafineria;


public class KontrolaKritickejhladinyNadrze implements Sledovatel{
private List<Nadrz> nadrze;

	
	public void pozrisa(List<Nadrz> nadrzeinp) 
	{
		nadrze= nadrzeinp;
		for(Nadrz n : nadrze) {
			
			if ( n.getVelkost() < 1000 ){
				GUI.Napis("stav nadrze "+n.getPalivo() +" je na KRITICKEJ UROVNI :"+n.getVelkost());
				System.out.println("stav nadrze "+n.getPalivo() +" je na KRITICKEJ UROVNI :"+n.getVelkost());			
				}
				else
				{
				n.setVelkost(n.getVelkost()-(int)(Math.random()*1000));
				GUI.Napis("stav nadrze nafty :"+n.getVelkost());
				System.out.println("stav nadrze nafty :"+n.getVelkost());	
				}
			
			 
		}
	}



	public void pozrisavcentralnomskade(List<Nadrz> nadrzeinp, Rafineria raf) {
		nadrze= nadrzeinp;
		for(Nadrz n : nadrze) {
			
			

			
			if ( n.getVelkost() == 0 ){
				GUI.Napis("Velkosklad stav nadrze "+n.getPalivo() +" je na KRITICKEJ UROVNI :"+n.getVelkost());
				System.out.println("Velkosklad stav nadrze "+n.getPalivo() +" je na KRITICKEJ UROVNI :"+n.getVelkost());			
				}
		
				
			
			 
		}	
		
	}
}
