import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AI {

	private int xmax;
	private int ymax;
	private int poc_vozidel;
	private List<Vozidlo> vozpark ;
	private List<Uzol> uzle;
	
	public AI() {
		
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
	       xmax=10;
	       ymax=6;
	       pridajvozidlo(new Vozidlo(1,2,2,3,0)); //cislo , dlzka , x, y, vodorvne 0 zvyslo 1
	       pridajvozidlo(new Vozidlo(2,3,7,3,1));
	      
	       Uzol zac_uzol = new Uzol(vozpark,xmax,ymax);    
	       uzle.add(zac_uzol);
	       
	       ries();
	       
	
	
	       
	       
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
