import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sun extends WorldObjects
{
    private int count;
    public void act() 
    {
        
        if (count == 16)
        {
            movement(0,1);
            count = 0;
        }
        count++;
    }
    
    public Sun()
    {
        count = 0;
    }
}
