import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldObjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldObjects extends Actor
{
    /**
     * Act - do whatever the WorldObjects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public void movement(int x, int y)
    {
        setLocation(getX()+x, getY()+y);
        if (getY() == 790) 
        {
            getWorld().removeObject(this);
        }
    }
}
