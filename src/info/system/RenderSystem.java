package info.system;

import info.entity.Entity;
import info.level.*;
import info.render.Main;

public class RenderSystem extends BaseSystem {

	public RenderSystem(Main m)
	{
		super(m);
	}

	public void tick() 
	{
		main.background(255);
		main.camera(main.player.posX,main.player.posY,main.player.posZ,
				main.player.tarX,main.player.tarY,main.player.tarZ,
				0,-1,0);
		int width = 15;
		//Find the grid and loop through its rows and columns
		Grid g = main.level.grids.get(main.level.levelNum);
		for (int r = 0; r < g.occupants.length; r++)
		{
			for (int c = 0; c < g.occupants[0].length; c++)
			{
				//Find the entity and access Processing functions to render it
				Entity en = g.occupants[r][c];
				if (en != null)
				{
					main.pushMatrix();
					main.fill(en.red, en.green, en.blue);
					main.translate(en.r*width, 0, en.c*width);
					main.box(width,width,width);
					main.popMatrix();
				}
			}
		}
	}

}
