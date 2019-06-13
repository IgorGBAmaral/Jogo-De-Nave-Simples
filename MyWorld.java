import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld extends World
{
    private int score;
    private int time;
    
    SuperShots ss = new SuperShots();
    Ship ship = new Ship();
    EnemySmall es = new EnemySmall();
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(670, 800, 1); 
        populate();
        //apresentacao de textos e setagem inicial
        es.setScore(0);
        score = 0;
        score();
        time = 12000;
        timer();        
        superShots();
        ss.setAmmo(0);
        life();
        //polir a apresentacao das imagens
        setPaintOrder(Border.class , Ship.class, Enemy.class, Projectile.class,
        SuperShots.class, WorldObjects.class);
    }
    
    public void act()
    {
        if (Greenfoot.getRandomNumber(1000) < 1)
        {
            addObject(new SuperShots(), Greenfoot.getRandomNumber(800), 0);
        }
        
        if (Greenfoot.getRandomNumber(15) < 1)
        {
            addObject(new Star(), Greenfoot.getRandomNumber(800), 0);
        }
        
        if (Greenfoot.getRandomNumber(200) < 1)
        {
            addObject(new EnemySmall(), Greenfoot.getRandomNumber(800), 0);
        }
        
        //consantemente atualizar as informacoes dos textos
        superShots();
        score();
        timer();
        life();
    }
    
    //popula o mundo com a nave, a borda e o sol
    private void populate()
    {
        addObject(ship, 335, 700);
        
        Border border = new Border();
        addObject(border, 350,710);
        
        addObject(new Sun(), 50,100);
        
        for (int i=0; i<40; i++)
        {
            addObject(new Star(), Greenfoot.getRandomNumber(670),Greenfoot.getRandomNumber(800));
        }
    }
    
    private void superShots()
    {
        //pega a municao da classe SuperShots
        showText("Super Ammo: " + ss.getAmmo(), 585 , 780);
    }
    
    private void score()
    {
        score = es.getScore();
        
        showText("Score: " + score, 50 , 780);
        
        if (score >= 200)
        {
            removeObjects(getObjects(null));
            addObject(new Victory(), getWidth()/2, getHeight()/2);
            Greenfoot.playSound("applause6.wav");
            //score = 0;
            Greenfoot.stop();
        }
    }
    
    private void timer()
    {
        //timeC de cortado (dividido por 10)
        int timeC;
        
        if (time != 0)
        {
            //polir o contador dividindo em 100
            timeC = time/100;
            showText(("Time: " + timeC), 170 , 780);
            time--;
        }
        
        if (time == 0)
        {
             removeObjects(getObjects(null));
             addObject(new GameOver(), getWidth()/2, getHeight()/2);
             Greenfoot.playSound("GameOver.wav");
             //nao coloquei o stop de proposito
        }    
    }
    
    private void life()
    {
        showText("HP: " + ship.getHealthPoints(), 470 , 780);
    }
}
