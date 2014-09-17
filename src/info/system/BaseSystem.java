package info.system;

import info.render.Main;

public abstract class BaseSystem {

	public Main main; //The PApplet that the system will refer to
	
	public BaseSystem(Main m)
	{
		main = m;
	}
	
	//An abstract method that all systems must overwrite with unique behaviors. It will be called once per frame.
	public abstract void tick();
	
}
