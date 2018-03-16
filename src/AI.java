import java.util.List;
import java.util.Scanner;

public class AI {

	private int xmax;
	private int ymax;
	private int poc_vozidel;
	private List<Vozidlo> vozpark ;
	
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
	       
	       xmax=6;
	       ymax=6;
	       pridajvozidlo(new Vozidlo(0,2,2,3,0)); //cislo , dlzka , x, y, vodorvne 0 zvyslo 1
	       pridajvozidlo(new Vozidlo(1,3,5,3,1));
	       Uzol zac_uzol = new Uzol(vozpark,xmax,ymax);
	       
	
	       
	       
	       
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

	void pridajvozidlo(Vozidlo voz)
	{	
		vozpark.add(voz);
	}
	
	    
	   	 
	  
	 
	
}
