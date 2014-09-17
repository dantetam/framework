package info.entity;

public class Entity {

	public int r,c; //Location stored in row,col form. For simplicity, there is no location class
	public int red, green, blue;
	
	//There is no reference to the grid. Everything should be top down (i.e. the grid has access to all its entities, and the level 
	//has access to its grids and the PApplet has access to the level)
	
	public Entity()
	{
		
	}
	
	//Displace by a certain amount
	public void move(int rDis, int cDis)
	{
		r += rDis;
		c += cDis;
	}
	
	//Move to exact location
	public void moveTo(int x, int y)
	{
		r = x;
		c = y;
	}
	
}
