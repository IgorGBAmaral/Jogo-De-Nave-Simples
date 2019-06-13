import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //movement(0, -4);
    }
    
    public void movement(int x, int y)
    {
        setLocation(getX()+x, getY()+y);
        if ( (getY() == 0) || (getY() == 800)) 
        {
            getWorld().removeObject(this);
        }
    }
    
    
}
