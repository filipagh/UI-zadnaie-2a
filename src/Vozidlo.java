
public class Vozidlo {
 private int id;
 private int xsur;
 private int ysur;
 private int smer;
 private int typ;
 


public Vozidlo(int idcko,int typimp,int x,int y,int orient)
 {
	typ=typimp;
	id = idcko;
	xsur = x;
	ysur = y;
	smer = orient;
 }
public Vozidlo(Vozidlo imp)
{
	typ= imp.getTyp();
	id = imp.getId();
	xsur = imp.getXsur();
	ysur = imp.getYsur();
	smer = imp.getSmer();
}


public int getTyp() {
	return typ;
}


public int getSmer() {
	return smer;
}

public void setSmer(int smer) {
	this.smer = smer;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getXsur() {
	return xsur;
}
public void setXsur(int xsur) {
	this.xsur = xsur;
}
public int getYsur() {
	return ysur;
}
public void setYsur(int ysur) {
	this.ysur = ysur;
}
 
 
 
 
 
	
	
	
}
