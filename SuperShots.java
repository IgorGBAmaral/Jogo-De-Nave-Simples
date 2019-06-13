import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperShots here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperShots extends Actor
{
    static int ammo;
    private int angle;
        
    public void act() 
    {
        //increaseAmmo();
        movement();
    }
    
    public SuperShots()
    {
        angle = 1;
    }
    
    public int getAmmo()
    {
        return ammo;
    }
    
    public void setAmmo(int x)
    {
        ammo = x;
    }
    
    public void increaseAmmo()
    {
        
    }
    
    public void movement()
    {
        //setLocation(getX()+0, getY()+5);
        
        if (angle > 0)
        {
            turn(5);
            move(5);
            angle++;
            
            if (angle == 35)
            {
                angle = -1;
            }
        }
        if (angle < 0)
        {
            turn(-5);
            move(5);
            angle--;
            
            if (angle == -35)
            {
                angle = 1;
            }
        }
        
        if (getY() > 790) 
        {
            getWorld().removeObject(this);
        }
    }
}
