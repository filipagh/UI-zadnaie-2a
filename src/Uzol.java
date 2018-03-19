import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import static java.util.stream.Collectors.toList;

	
public class Uzol {

	private int hlbka;
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

	public boolean hladaj(List<Uzol> imp_uzle)
	{
		
		
		
		long hash=0;
		
		matica = new int[ysur][xsur];
		//TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU
			for(Vozidlo n : vozpark) 
		{			
				if (n.getId()==3)
				{		
				System.out.println(n.getYsur()+" "+n.getXsur()+" "+n.getId()+"teeeeest");
				}
				
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
				
				
				
			//	matica[n.getXsur()][n.getYsur()]=n.getId()	
		}
			for(int i=0; i<ysur;i++)      
			{
				for(int o=0; o<xsur;o++) 
				{
				System.out.print(matica[i][o]+" ");
				}
				System.out.println();
			}
			
		
			// KONTROLA HASH
			// SEEEEEEEEEEEEEEEEEEEEEEEEEMMMMMMMMMMMMMMMMMM
			
		for (int i=vozpark.get(0).getYsur()+1;i<xsur;i++)
		{
			if (matica[vozpark.get(0).getYsur()][i]!= 0)
			{
				System.out.println("buuuum"+i);
				for(Vozidlo n : vozpark) 
				{
					
					
					List<Prikaz> zoznam_exp=zoznam;
					
					int x=n.getXsur();
					int y=n.getYsur();
					
					if (n.getSmer()==0)
					{
						x=x-1;
						while (x >=0 &&matica[y][x]==0)
						{
							List<Vozidlo> vozpark_exp;
							vozpark_exp =new ArrayList<Vozidlo>();
							
							for (Vozidlo nn : vozpark) {
						        vozpark_exp.add(new Vozidlo(nn));
						    }

							vozpark_exp.get(n.getId()-1).setXsur(n.getXsur()-(n.getXsur()-x));	
							long hashnovy=0;
							for(Vozidlo nhash : vozpark_exp) 
							{			
								hashnovy = hashnovy+nhash.hash();
							}
								if (hashset.contains(hashnovy)==false)
								{
									Prikaz exp = new Prikaz(n.getId(),n.getXsur()-x,2);
									zoznam_exp.add(exp);
									Uzol expuzol = new Uzol(vozpark_exp,zoznam_exp,xsur,ysur,hashset);
									imp_uzle.add(expuzol);
									hashset.add(hashnovy);
								}
								else
								{
									System.out.println("tento stav uz bol");
								}
							x = x-1;
							
						}
						
						
						
						
						
						// vodorovne vpravo vpravo
						
						
						
						x=n.getXsur();
						while (x+n.getTyp() <xsur && matica[y][x+n.getTyp()]==0)
						{
							List<Vozidlo> vozpark_exp;
							vozpark_exp =new ArrayList<Vozidlo>();
							
							for (Vozidlo nn : vozpark) {
						        vozpark_exp.add(new Vozidlo(nn));
						    }

							vozpark_exp.get(n.getId()-1).setXsur(n.getXsur()+(x-n.getXsur()+1));	
						
							long hashnovy=0;
							for(Vozidlo nhash : vozpark_exp) 
							{			
								hashnovy = hashnovy+nhash.hash();
							}
								if (hashset.contains(hashnovy)==false)
								{
									Prikaz exp = new Prikaz(n.getId(),x-n.getXsur(),0);
									zoznam_exp.add(exp);
									Uzol expuzol = new Uzol(vozpark_exp,zoznam_exp,xsur,ysur,hashset);
									imp_uzle.add(expuzol);
									hashset.add(hashnovy);
								}
								else
								{
									System.out.println("tento stav uz bol");
								}
							x = x+1;
					
						}
					}
					else
					{
				
						
						
						
						// zvyslo hore
					
						y=y-1;
						while (y >=0 &&matica[y][x]==0)
						{
							List<Vozidlo> vozpark_exp;
							vozpark_exp =new ArrayList<Vozidlo>();
							
							for (Vozidlo nn : vozpark) {
						        vozpark_exp.add(new Vozidlo(nn));
						    }

							vozpark_exp.get(n.getId()-1).setYsur(n.getYsur()-(n.getYsur()-y));	
							
							if (n.getId()==3)
							{
								System.out.println(vozpark_exp.get(3).getYsur()+" "+n.getId()+"hore");
								}
							
							if (n.getId()==3)
							{
								System.out.println(vozpark_exp.get(3).getYsur()+" "+n.getId());
								}
							long hashnovy=0;
							for(Vozidlo nhash : vozpark_exp) 
							{			
								hashnovy = hashnovy+nhash.hash();
							}
								if (hashset.contains(hashnovy)==false)
								{
									Prikaz exp = new Prikaz(n.getId(),n.getYsur()-y,2);
									zoznam_exp.add(exp);
									Uzol expuzol = new Uzol(vozpark_exp,zoznam_exp,xsur,ysur,hashset);
									imp_uzle.add(expuzol);
									hashset.add(hashnovy);
								}
								else
								{
									System.out.println("tento stav uz bol");
								}
							y = y-1;
					
							
						}
						if (n.getId()==3)
						{
						System.out.println(n.getYsur()+" "+n.getXsur()+" "+n.getId());
						}
						
						
						// zvslo dole
						
						y=n.getYsur();
						x=n.getXsur();
						while (y+n.getTyp() <ysur && matica[y+n.getTyp()][x]==0)
						{
							List<Vozidlo> vozpark_exp;
							vozpark_exp =new ArrayList<Vozidlo>();
							
							for (Vozidlo nn : vozpark) {
						        vozpark_exp.add(new Vozidlo(nn));
						    }

							vozpark_exp.get(n.getId()-1).setYsur(n.getYsur()+(y-n.getYsur()+1));	//y-n.getTyp()-1);//
							
							if (n.getId()==3)
							{
								System.out.println(vozpark_exp.get(3).getYsur()+" "+n.getId()+"dole");
								}
						
							long hashnovy=0;
							for(Vozidlo nhash : vozpark_exp) 
							{			
								hashnovy = hashnovy+nhash.hash();
							}
								if (hashset.contains(hashnovy)==false)
								{
									Prikaz exp = new Prikaz(n.getId(),x-n.getYsur(),0);													
									zoznam_exp.add(exp);
									Uzol expuzol = new Uzol(vozpark_exp,zoznam_exp,xsur,ysur,hashset);
									imp_uzle.add(expuzol);
									hashset.add(hashnovy);
								}
								else
								{
									System.out.println("tento stav uz bol");
								}
							y = y+1;
							
						}
					}
				}
				
				imp_uzle.remove(0);
				
				
				return (false);	
			}
			
		}
				
		return (true);	
	
		

	}
}
