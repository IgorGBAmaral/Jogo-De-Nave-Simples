import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{  
    private int reload;
    private int reloadDelay;
    
    private int reloadS;
    private int reloadDelayS;
    
    SuperShots ss = new SuperShots();
    
    private int healthPoints;
    
    public void act() 
    {
        // Add your action code here.
        movement();
        reload++;
        reloadS++;
        touchingAmmo();
        damage();
        checkHealthPoints();
    }
    
    public Ship()
    {
        reloadDelay = 20;
        reloadDelayS = 50;
        
        healthPoints = 5;
    }
    
    public void movement()
    {
        if (Greenfoot.isKeyDown("up") && getY() > 600 ) 
        {
            setLocation(getX(), getY()-4);
        }
        
        if (Greenfoot.isKeyDown("down") && getY() < 700) 
        {
            setLocation(getX(), getY()+4);
        }
        
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+6, getY());
        }
        
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-6, getY());
        }
        
        if (Greenfoot.isKeyDown("space")) 
        {
            shot();
        }
        
        if (Greenfoot.isKeyDown("v")) 
        {
            shotSuper();
        }
    }

    public void shot()
    {
         if (reload >= reloadDelay)
         {
                ShipShotN shot = new ShipShotN();
                getWorld().addObject(shot, getX(),getY());
                reload = 0;
                Greenfoot.playSound("pew.wav");
         }      
    }
    
    public void shotSuper()
    {
        SuperShots count = new SuperShots(); 
        if (reloadS >= reloadDelayS)
        {
            if (count.getAmmo() > 0)
            {
                    ShipShotS shots = new ShipShotS();
                    getWorld().addObject(shots, getX(),getY());
                    count.setAmmo(count.getAmmo() - 1);
                    reloadS = 0;
            }
        }   
    }
    
    public void touchingAmmo()
    {
        if (isTouching(SuperShots.class) == true)
        {
            int ammo;
            ammo = ss.getAmmo();
            
            
            if (ammo <= 2)
            {
                ammo = ammo + 1; 
                removeTouching(SuperShots.class);
                ss.setAmmo(ammo);
            }
        }
    }
    
    public void damage()
    {
        if (isTouching(EnemySmallShot.class))
        {
            removeTouching(EnemySmallShot.class);
            healthPoints = healthPoints-1;
        }
        
        /* Fazer medium
        if (isTouching(EnemyMediumShot.class))
        {
            removeTouching(EnemyMediumShot.class);
            healthPoints = healthPoints-3;
        }       
        */
    }
    
    public void checkHealthPoints()
    {
        if (healthPoints <= 0)
            {                         
                World world = getWorld(); 
                if (world != null) {
                    world.removeObjects(world.getObjects(null));
                    world.addObject(new GameOver(), world.getWidth()/2, world.getHeight()/2);
                    Greenfoot.playSound("GameOver.wav");
                }
             }      
    }
    
    public int getHealthPoints()
    {
        return healthPoints;
    }
}
