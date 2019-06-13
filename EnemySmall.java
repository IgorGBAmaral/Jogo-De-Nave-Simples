import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemySmall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemySmall extends Enemy
{
    private int dir;
    private int reload;
    private int reloadDelay;
    
    /**
     * Act - do whatever the EnemySmall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        shot();
        reload++;
        dir = changeDirection();
        damage();
        movement(dir,1,5);
        checkHealthPoints();        
    }
    
    public EnemySmall()
    {
        dir = direction();
        setHealthPoints(3);
        reloadDelay = 150;
        reload = 50;
    }
    
    public void shot()
    {
         if (reload >= reloadDelay)
         {
                EnemySmallShot shot = new EnemySmallShot();
                getWorld().addObject(shot, getX(),getY());
                reload = 0;
                Greenfoot.playSound("Blaster.wav");
         }      
    }
    
    public void checkHealthPoints()
    {
        int healthPoints = getHealthPoints();
        if (healthPoints <= 0)
            {
                getWorld().removeObject(this);
                Greenfoot.playSound("Explosion+1.wav");
                increaseScore(20);
            }      
    }
}
