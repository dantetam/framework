package info.render;

import java.util.ArrayList;

import processing.core.PApplet;
import info.system.*;
import info.entity.Entity;
import info.level.Grid;
import info.level.Level;

public class Main extends PApplet {

	public ArrayList<BaseSystem> systems;
	public InputSystem inputSystem;
	public AISystem aiSystem;
	public RenderSystem renderSystem;
	
	public Level level;
	
	public Player player;
	
	public void setup()
	{
		size(500,500,P3D);
		
		//A test level
		level = new Level();
		Grid grid1 = new Grid(50,50);
		for (int i = 0; i < 50; i++)
		{
			Entity en = new Entity();
			en.red = (int)(Math.random()*255);
			en.green = (int)(Math.random()*255);
			en.blue = (int)(Math.random()*255);
			int r = (int)(Math.random()*50);
			int c = (int)(Math.random()*50);
			en.moveTo(r,c);
			grid1.addUnit(en, r, c);
		}
		level.grids.add(grid1);
		
		player = new Player();
		
		systems = new ArrayList<BaseSystem>();
		//Make new systems and point them to the PApplet
		//The order they are added in actually matters
		//RenderSystem is always last
		inputSystem = new InputSystem(this);
		aiSystem = new AISystem(this);
		renderSystem = new RenderSystem(this);
		systems.add(inputSystem);
		systems.add(aiSystem);
		systems.add(renderSystem);
	}
	
	public void draw()
	{
		//Loop through the systems in order
		//The point of the systems is to organize and order that would normally be stuffed into this function
		for (int i = 0; i < systems.size(); i++)
		{
			systems.get(i).tick();
		}
	}
	
	public void keyPressed()
	{
		inputSystem.keyQueue.add(0,key);
		if (key == 'w')
		{
			inputSystem.wP = true;
		}
		else if (key == 'a')
		{
			inputSystem.aP = true;
		}
		else if (key == 's')
		{
			inputSystem.sP = true;
		}
		else if (key == 'd')
		{
			inputSystem.dP = true;
		}
	}
	
	public void keyReleased()
	{
		if (key == 'w')
		{
			inputSystem.wP = false;
		}
		else if (key == 'a')
		{
			inputSystem.aP = false;
		}
		else if (key == 's')
		{
			inputSystem.sP = false;
		}
		else if (key == 'd')
		{
			inputSystem.dP = false;
		}
	}
	
}
