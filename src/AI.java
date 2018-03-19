import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Scanner;

public class AI {

	private int xmax;
	private int ymax;
	private int poc_vozidel;
	private List<Vozidlo> vozpark ;
	private List<Uzol> uzle;
	
	public AI() {
		long zaciatok_cas=System.nanoTime();
	/*
		System.out.println("zadaj x dlzku mriezky : ");

	     
	       Scanner scanIn = new Scanner(System.in);
	       xmax = scanIn.nextInt();

	       System.out.println("zadaj y dlzku mriezky : ");
	
	       ymax = scanIn.nextInt();
	       
	       System.out.println("zadaj pocet vozidiel : ");
	       
	       poc_vozidel = scanIn.nextInt();
    
	       System.out.println("mriezka je "+xmax+" : "+ymax+"    a pocet vozidel je "+poc_vozidel);
	   */    
		vozpark = new ArrayList<Vozidlo>();
		uzle = new ArrayList<Uzol>();
	       xmax=6;
	       ymax=6;
	       pridajvozidlo(new Vozidlo(1,2,1,2,0)); //cislo , dlzka , x, y, vodorvne 0 zvyslo 1
	       pridajvozidlo(new Vozidlo(2,2,0,0,0));
	       pridajvozidlo(new Vozidlo(3,3,0,1,1));
	       pridajvozidlo(new Vozidlo(4,3,3,1,1));
	       pridajvozidlo(new Vozidlo(5,3,5,0,1));
	       pridajvozidlo(new Vozidlo(6,2,0,4,1));
	       pridajvozidlo(new Vozidlo(7,2,4,4,0));
	       pridajvozidlo(new Vozidlo(8,3,2,5,0));
	       
	        HashSet<Long> hashset = new HashSet<Long>();
	       Uzol zac_uzol = new Uzol(vozpark,xmax,ymax,hashset);    
	       uzle.add(zac_uzol);
	     
	       ries();
	       
	       long koniec_cas=System.nanoTime();
	       
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
	Boolean ries()
	{
		Boolean pokus=false;
		while (uzle.isEmpty()== false )
		{
			pokus=uzle.get(0).hladaj(uzle);
			if (pokus == true)
			{
				 System.out.println("nasla sa cesta");
				return true;
			}
			
		}
	
		   System.out.println("nenasiel sa vysledok");
		   return false;
	}
	

	void pridajvozidlo(Vozidlo voz)
	{	
		vozpark.add(voz);
	}
	
	    
	   	 
	  
	 
	
}
