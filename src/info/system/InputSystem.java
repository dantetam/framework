package info.system;

import java.util.ArrayList;

import info.render.Main;

public class InputSystem extends BaseSystem {

	public ArrayList<Character> keyQueue;
	
	public InputSystem(Main m)
	{
		super(m);
		keyQueue = new ArrayList<Character>();
	}

	public boolean wP, aP, sP, dP;
	public void tick() 
	{
		int dist = 10;
		//Go through the keys backwards to avoid arraylist trap
		for (int i = keyQueue.size() - 1; i >= 0; i--)
		{
			//Axis is messed up but whatever
			if (wP)
			{
				main.player.posX -= dist;
				main.player.tarX -= dist;
			}
			if (sP)
			{
				main.player.posX += dist;
				main.player.tarX += dist;
			}
			if (aP)
			{
				main.player.posZ -= dist;
				main.player.tarZ -= dist;
			}
			if (dP)
			{
				main.player.posZ += dist;
				main.player.tarZ += dist;
			}
		}
		keyQueue.clear();
	}
	
}
