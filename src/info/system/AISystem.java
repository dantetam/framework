package info.system;

import info.entity.Entity;
import info.level.Grid;
import info.render.Main;

public class AISystem extends BaseSystem {

	public AISystem(Main m)
	{
		super(m);
	}

	public void tick()
	{
		Grid g = main.level.grids.get(main.level.levelNum);
		for (int r = 0; r < g.occupants.length; r++)
		{
			for (int c = 0; c < g.occupants[0].length; c++)
			{
				//Find the entity and access Processing functions to render it
				Entity en = g.occupants[r][c];
				if (en != null && Math.random() < 0.15)
				{
					int rDis = (int)(Math.random()*3) - 1;
					int cDis = (int)(Math.random()*3) - 1;
					if (en.r+rDis >= 0 && en.r+rDis < g.occupants.length && en.c+cDis >= 0 && en.c+cDis < g.occupants[0].length)
					{
						g.occupants[r][c] = null;
						en.move(rDis,cDis);
						g.occupants[en.r][en.c] = null;
						g.occupants[en.r][en.c] = en;
					}
				}
			}
		}
	}

}
