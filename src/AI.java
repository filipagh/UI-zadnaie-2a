
import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Scanner;

public class AI {
	private long koniec_cas;
	private int xmax;
	private int ymax;
	private int poc_vozidel;
	private List<Vozidlo> vozpark ;
	private List<Uzol> uzle;
	private int sposob;
	public AI() {
		// pocitanie casu
		
		 xmax=6;
	     ymax=6;
		 vozpark = new ArrayList<Vozidlo>();
	   	 uzle = new ArrayList<Uzol>();
	   	 
		 Scanner scanIn = new Scanner(System.in);
		 System.out.println("zadaj nazov suboru vstupu");
		 String fileName = scanIn.nextLine();
		 System.out.println("zadaj sposob hladania do sirky / hlbky (zdaj cislo)   ----- >  0/1   ");
		 sposob=scanIn.nextInt();
		 File f = new File(fileName);
		 Scanner scanfile = null;
		try {
			scanfile = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		poc_vozidel= scanfile.nextInt();
		xmax= scanfile.nextInt();
		ymax= scanfile.nextInt();
		
	
		 
		 for (int l=1;l<=poc_vozidel;l++)
		 {
			 pridajvozidlo(new Vozidlo(scanfile.nextInt(),scanfile.nextInt(),scanfile.nextInt(),scanfile.nextInt(),scanfile.nextInt()));
		 }
		 
		 
		 scanfile.close();
		long zaciatok_cas=System.nanoTime();
		
		scanIn.close();
		
		
	/*
		
	     
	    
	    
	
	 /*
	       pridajvozidlo(new Vozidlo(1,2,1,2,0)); //cislo , dlzka , x, y, vodorvne 0 zvyslo 1
	       pridajvozidlo(new Vozidlo(2,2,0,0,0));
	       pridajvozidlo(new Vozidlo(3,3,0,1,1));
	       pridajvozidlo(new Vozidlo(4,3,3,1,1));
	       pridajvozidlo(new Vozidlo(5,3,5,0,1));
	       pridajvozidlo(new Vozidlo(6,2,0,4,1));
	       pridajvozidlo(new Vozidlo(7,2,4,4,0));
	       pridajvozidlo(new Vozidlo(8,3,2,5,0));
*/
	       // def hashset
	       HashSet<Long> hashset = new HashSet<Long>();
	       
	       // vytvorenie 1. uzla a zapisanie
	       Uzol zac_uzol = new Uzol(vozpark,xmax,ymax,hashset);    
	       uzle.add(zac_uzol);
	     
	       
	       
	       // pusti metodu ries
	       if (sposob == 1)
	    	   System.out.println("prehldavanie do hlbky");
	       else
	    	   System.out.println("prehldavanie do sirky");
	       
	       
	       // vykresli uvodnu maticu (parkovisko)
	       System.out.println("uvodna matica ");
			int [][] matica = new int[ymax][xmax];
				for(Vozidlo n : vozpark) 
			{			
					matica[n.getYsur()][n.getXsur()]=n.getId();
					for (int i=1;i<n.getTyp();i++)
					{

						if (n.getSmer()==0)
						{
							matica[n.getYsur()][n.getXsur()+i]=n.getId();	
						}
						else
						{
							matica[n.getYsur()+i][n.getXsur()]=n.getId();		
						}
					}
			}	
				for(int i=0; i<ymax;i++)      
				{
					for(int o=0; o<xmax;o++) 
					{
					System.out.print(matica[i][o]+" ");
					}
					System.out.println();
				}
	       
	       ries(sposob);
	       // koniec ratania casu
	
	       
	       
	       // spracovanie vysleku
	       
	      
				
				
	      
	       // vypis dlzku trvania
	       System.out.println("hladanie riesenia trvalo "+(float)(koniec_cas-zaciatok_cas)/1000000000+" sekund" );
	       
	
	
	     
	       
	      /*
	       for (int i = 0; i < poc_vozidel; i++) 
			{
			   if (i == 0) 
			   {
				   System.out.println(" : ");
			   }					   
	    	   pridajvozidlo();
			
			}
		    */   
		       
		       
	       	//scanIn.close();   
	}
	Boolean ries(int sposob)
	{
		// pokus - miesto kde sa zapise vysledok t/f hladania
		int poc_ries=1;
		Boolean pokus=false;
		while (uzle.isEmpty() == false)  // kym mam v zozname uzle tak hladaj
		{
			poc_ries=poc_ries+1;
			pokus=uzle.get(0).hladaj(uzle,sposob);  
			if (pokus == true)                   // ak sa najde riesenie vypis nasla sa cesta a ukonci hladanie
			{
			       koniec_cas=System.nanoTime();
				System.out.println("nasla sa cesta a prehladalo sa "+poc_ries+" uzlov celkovo uzlov "+(uzle.size()+poc_ries) );
				// uzle.get(0).vypiscestu();
				return true;
			}
			
		}
	       koniec_cas=System.nanoTime();	
		// nenasla sa cest 
		   System.out.println("nenasiel sa vysledok a prehladalo sa "+poc_ries+" uzlov");
		   return false;
	}
	
// metoda na pridatie vodizla do zoznamu 
	void pridajvozidlo(Vozidlo voz)
	{	
		vozpark.add(voz);
	}
	
	    
	   	 
	  
	 
	
}
