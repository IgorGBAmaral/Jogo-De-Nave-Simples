import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends WorldObjects
{
    private String[] stars = {"star1","star2","star3","star4","star5","star6"};
    private String image;
    
    public void act() 
    {
        movement(0, 1);
    }
    
    public Star()
    {
        image = (stars[Greenfoot.getRandomNumber(5)] + ".png");
        setImage(image);
    }
}
