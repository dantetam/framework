package info.level;

import java.util.ArrayList;

import info.entity.Entity;

public class Grid {

	public Entity[][] occupants;
	//For a gridless "level"
	//public ArrayList<Entity> occupants;
	
	//For multiple units on one tile
	//public ArrayList<Entity>[][] occupants;
	
	public Grid(int rows, int cols)
	{
		occupants = new Entity[rows][cols];
	}
	
	//Add an entity to the specified location
	public void addUnit(Entity en, int r, int c)
	{
		occupants[r][c] = en;
	}
	
	
	
}
