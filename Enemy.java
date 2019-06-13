import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int i;
    private int direction;
    private int healthPoints;
    static int score;
    
    public void act() 
    {
        // Add your action code here.
    }
    
    public Enemy()
    {
        i = 0;
    }
    
    public void movement(int x, int y)
    {        
        setLocation(getX()+x, getY()+y);
        if (getY() == 790) 
        {
            getWorld().removeObject(this);
        }
    }
    
    public void movement(int x, int y, int move)
    {
        if(i >= move)
        {
            setLocation(getX()+x, getY()+y);
        }
        i++;
    }
    
    public int direction()
    {
        int aux;
        aux = Greenfoot.getRandomNumber(2);
        direction = 0;
        if (aux == 0)
            direction = 1;
        if (aux == 1)
            direction = -1;
        
        return direction;
    }
    
    public int changeDirection()
    {
        if (isAtEdge() == true)
            direction = direction * -1;
        return direction;
    }
    
    public void setHealthPoints(int hp)
    {
        healthPoints = hp;
    }
    
    public int getHealthPoints()
    {
        return healthPoints;
    }
    
    public void damage()
    {
        if (isTouching(ShipShotN.class))
        {
            removeTouching(ShipShotN.class);
            healthPoints = healthPoints-1;
        }
        
        if (isTouching(ShipShotS.class))
        {
            //removeTouching(ShipShotS.class);
            healthPoints = healthPoints-10;
        }       
        
    }
        
    public void increaseScore(int points)
    {
        score = score + points;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setScore(int aux)
    {
        score = aux;
    }
}

