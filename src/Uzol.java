import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;


	
public class Uzol {


	private int xsur;
	private int ysur;
	private List<Vozidlo> vozpark;
	private List<Prikaz> zoznam;
	private HashSet<Long> hashset;
	
	private int[][] matica;
	
	public Uzol (List<Vozidlo> importuj,int xi,int yi,HashSet<Long> hashset_i)
	{	
	xsur= xi;
	ysur= yi;
	vozpark = importuj;	
	zoznam = new ArrayList<Prikaz>();
	hashset=hashset_i;
	long hash=0;
	for(Vozidlo n : vozpark) 
{			
		hash = hash+n.hash();
}
	hashset.add(hash);
	
	}
	
	public Uzol (List<Vozidlo> importuj,List<Prikaz> zoznamimp,int xi,int yi,HashSet<Long> hashset_i)
	{
	xsur= xi;
	ysur= yi;
	vozpark = importuj;	
	zoznam = zoznamimp;
	hashset=hashset_i;
	}

	public boolean hladaj(List<Uzol> imp_uzle,int sposob)  //metoda na analyzu uzla
	{
		
		matica = new int[ysur][xsur];   		// pri analyze vytvorenie matice kde zistujem stav
		
			for(Vozidlo n : vozpark) 			//prechadzam kazde vozidlo
		{			
			
				// zapis vozidiel do matice
				
				matica[n.getYsur()][n.getXsur()]=n.getId();
				for (int i=1;i<n.getTyp();i++)
				{

					if (n.getSmer()==0) // vodorovne
					{
						matica[n.getYsur()][n.getXsur()+i]=n.getId();	
					}
					else  // zvysle
					{
						matica[n.getYsur()+i][n.getXsur()]=n.getId();		
					}
				}
				
				
				
			
				
		}

			
			
			//overenie ci nase "hlavne" auto sa vie dostat von
		for (int i=vozpark.get(0).getXsur()+vozpark.get(0).getTyp();i<xsur;i++)
		{
			if (matica[vozpark.get(0).getYsur()][i]!= 0) //ci by nabural
			{
				
				// ak sa nevie dostat von skusam kazde vozidlo kazdu moznu poziciu
				for(Vozidlo n : vozpark) // posunutie kazdeho vozdla 
				{					
					int x=n.getXsur();
					int y=n.getYsur();
				
					// ak je vozidlo vodorovne
					if (n.getSmer()==0)
					{
						// smer vodorovne vlavo
						
						
						x=x-1;  //posun vlavo
						while (x >=0 &&matica[y][x]==0)
						{
							
							// vytvorenie kopie zoznamov (nemoze byt vozpark=vozpark_exp)
							List<Vozidlo> vozpark_exp;
							vozpark_exp =new ArrayList<Vozidlo>();
							
							for (Vozidlo nn : vozpark) {
						        vozpark_exp.add(new Vozidlo(nn));
						    }
							List<Prikaz> zoznam_exp;
							zoznam_exp =new ArrayList<Prikaz>();
							
							for (Prikaz nn : zoznam) {
						        zoznam_exp.add(new Prikaz(nn));
						    }
							
							
							vozpark_exp.get(n.getId()-1).setXsur(n.getXsur()-(n.getXsur()-x));   // prepisanie suradnic 	
							
							// hash stavu
							long hashnovy=0;
							for(Vozidlo nhash : vozpark_exp) 
							{			
								hashnovy = hashnovy+nhash.hash();
							}
							
							// test ci taky stav je
								if (hashset.contains(hashnovy)==false)
								{
									// dany stav nieje a teda vytvor novy uzol a prikaz
									Prikaz exp = new Prikaz(n.getId(),n.getXsur()-x,2);    
									zoznam_exp.add(exp);
									Uzol expuzol = new Uzol(vozpark_exp,zoznam_exp,xsur,ysur,hashset);
									if (sposob==0)
									{
									imp_uzle.add(expuzol);
									}
									else
									{
									imp_uzle.add(1, expuzol);
									}
									hashset.add(hashnovy);
								}
								else   // dany uzol uz sme riesili a teda zmenu zahodime
								{
									//System.out.println("tento stav uz bol");
								}
							x = x-1;   // cyklicke posuvanie vlavo
							
						}
						
											
						// vodorovne vpravo vpravo
						
						
						
						x=n.getXsur(); // vrat x na miesto
						while (x+n.getTyp() <xsur && matica[y][x+n.getTyp()]==0) 
						{
							
							// vytvorenie kopie zoznamov (nemoze byt vozpark=vozpark_exp)
							List<Vozidlo> vozpark_exp;
							vozpark_exp =new ArrayList<Vozidlo>();
							
							for (Vozidlo nn : vozpark) {
						        vozpark_exp.add(new Vozidlo(nn));
						    }
							List<Prikaz> zoznam_exp;
							zoznam_exp =new ArrayList<Prikaz>();
							
							for (Prikaz nn : zoznam) {
						        zoznam_exp.add(new Prikaz(nn));
						    }

							vozpark_exp.get(n.getId()-1).setXsur(n.getXsur()+(x-n.getXsur()+1));	 // prepisanie suradnic 	
						
							// hash stavu
							long hashnovy=0;
							for(Vozidlo nhash : vozpark_exp) 
							{			
								hashnovy = hashnovy+nhash.hash();
							}
							
								// test ci taky stav je
								if (hashset.contains(hashnovy)==false)
								{
									// dany stav nieje a teda vytvor novy uzol a prikaz
									Prikaz exp = new Prikaz(n.getId(),x-n.getXsur()+1,0);
									zoznam_exp.add(exp);
									Uzol expuzol = new Uzol(vozpark_exp,zoznam_exp,xsur,ysur,hashset);
									if (sposob==0)
									{
									imp_uzle.add(expuzol);
									}
									else
									{
									imp_uzle.add(1, expuzol);
									}
									hashset.add(hashnovy);
								}
								else   // dany uzol uz sme riesili a teda zmenu zahodime
								{
									//System.out.println("tento stav uz bol");
								}
							x = x+1; // cyklicke posuvanie vpravo
					
						}
					}
					else
					{
				
						
						
						
						// zvyslo hore
					
						y=y-1;
						while (y >=0 &&matica[y][x]==0)
						{
							
							
							// vytvorenie kopie zoznamov (nemoze byt vozpark=vozpark_exp)
							List<Vozidlo> vozpark_exp;
							vozpark_exp =new ArrayList<Vozidlo>();
							
							for (Vozidlo nn : vozpark) {
						        vozpark_exp.add(new Vozidlo(nn));
						    }
							List<Prikaz> zoznam_exp;
							zoznam_exp =new ArrayList<Prikaz>();
							
							for (Prikaz nn : zoznam) {
						        zoznam_exp.add(new Prikaz(nn));
						    }

							vozpark_exp.get(n.getId()-1).setYsur(n.getYsur()-(n.getYsur()-y));	   // prepisanie suradnic 	
							
							// hash stavu
							long hashnovy=0;
							for(Vozidlo nhash : vozpark_exp) 
							{			
								hashnovy = hashnovy+nhash.hash();
							}
							
							// test ci taky stav je
							if (hashset.contains(hashnovy)==false)
								{
									// dany stav nieje a teda vytvor novy uzol a prikaz
									Prikaz exp = new Prikaz(n.getId(),n.getYsur()-y,3);
									zoznam_exp.add(exp);
									Uzol expuzol = new Uzol(vozpark_exp,zoznam_exp,xsur,ysur,hashset);
									if (sposob==0)
									{
									imp_uzle.add(expuzol);
									}
									else
									{
									imp_uzle.add(1, expuzol);
									}
									hashset.add(hashnovy);
								}
								else   // dany uzol uz sme riesili a teda zmenu zahodime
								{
									//System.out.println("tento stav uz bol");
								}
							y = y-1;  // cyklicke posuvanie hore
					
							
						}
					
						
						
						// zvslo dole
						
						y=n.getYsur();
						x=n.getXsur();
						while (y+n.getTyp() <ysur && matica[y+n.getTyp()][x]==0)
						{
							
							
							// vytvorenie kopie zoznamov (nemoze byt vozpark=vozpark_exp)
							List<Vozidlo> vozpark_exp;
							vozpark_exp =new ArrayList<Vozidlo>();
							
							for (Vozidlo nn : vozpark) {
						        vozpark_exp.add(new Vozidlo(nn));
						    }
							List<Prikaz> zoznam_exp;
							zoznam_exp =new ArrayList<Prikaz>();
							
							for (Prikaz nn : zoznam) {
						        zoznam_exp.add(new Prikaz(nn));
						    }
							vozpark_exp.get(n.getId()-1).setYsur(n.getYsur()+(y-n.getYsur()+1));	 // prepisanie suradnic 	
							
							// hash stavu						
							long hashnovy=0;
							for(Vozidlo nhash : vozpark_exp) 
							{			
								hashnovy = hashnovy+nhash.hash();
							}
						
							// test ci taky stav je
							if (hashset.contains(hashnovy)==false)
								{
									// dany stav nieje a teda vytvor novy uzol a prikaz
									Prikaz exp = new Prikaz(n.getId(),y-n.getYsur()+1,1);													
									zoznam_exp.add(exp);
									Uzol expuzol = new Uzol(vozpark_exp,zoznam_exp,xsur,ysur,hashset);
									if (sposob==0)
									{
									imp_uzle.add(expuzol);
									}
									else
									{
									imp_uzle.add(1, expuzol);
									}
									hashset.add(hashnovy);
								}
								else   // dany uzol uz sme riesili a teda zmenu zahodime
								{
									//System.out.println("tento stav uz bol");
								}
							y = y+1;   	// cyklicke posuvanie dole
							
						}
					}
				}
				// odstran aktualny uzol zo zoznamu uzlov
		
				
				imp_uzle.remove(0);
				
				
				return (false);	
			}
			
		}
		
		
		
		//vysledna matica vypis
		System.out.println("vysledna matica ");
		int [][] matica = new int[ysur][xsur];
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
		for(int i=0; i<ysur;i++)      
		{
			for(int o=0; o<xsur;o++) 
			{
			System.out.print(matica[i][o]+" ");
			}
			System.out.println();
		}
		
		// vrat ze si nasiel cestu
		return (true);	
	
		

	}
	
	// vypise cestu od zacitku do konca
	void vypiscestu()
	{
		int poc=0;
		for(Prikaz zoz: zoznam) 
		{			
			poc=poc+1;
			System.out.println(poc+". vozidlo c. "+zoz.getId()+" pohni smerom "+zoz.getSmer()+" o "+zoz.getPocet());
		}		
		System.out.println(poc+1+". vozidlo c. 1 pohni smerom 0 o "+(xsur-(vozpark.get(0).getXsur())-vozpark.get(0).getTyp()));
	}
}
