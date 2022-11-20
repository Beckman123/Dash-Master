import java.awt.*;
import java.awt.event.*;
import java.util.*;

//A Simple version of the scrolling game, featuring Avoids, Gets, and RareGets
//Players must reach a score threshold to win
//If player runs out of HP (via too many Avoid collisions) they lose
public class OneGame extends GameEngine {
    public boolean jumping = false;
    //Dimensions of game window
    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 600;  
    
    //Starting PlayerEntity coordinates
    private static final int STARTING_PLAYER_X = 430;
    private static final int STARTING_PLAYER_Y = 300;
    
    //Score needed to win the game
    private static final int SCORE_TO_WIN = 150;
    private static final int GROUND = 305;
    //Maximum that the game speed can be increased to
    //(a percentage, ex: a value of 300 = 300% speed, or 3x regular speed)
    private static final int MAX_GAME_SPEED = 300;
    //Interval that the speed changes when pressing speed up/down keys
    private static int SPEED_CHANGE = 5;    
    
    private static final String INTRO_SPLASH_FILE = "sprites/Splashimg.gif";        
    //Key pressed to advance past the splash screen
    public static final int ADVANCE_SPLASH_KEY = KeyEvent.VK_ENTER;
    
    //Interval that Entities get spawned in the game window
    //ie: once every how many ticks does the game attempt to spawn new Entities
    private static int SPAWN_INTERVAL = 60;
    private static boolean  isDashing = false;
    //A Random object for all your random number generation needs!
    public static final Random rand = new Random();
    public boolean right = true;
    public boolean left = false;
    public double vely;
    public double velx=0;
    public double gravity = 25;
    public double jumpVelocity = 8;
    public int backrndCounter = 0;
    private static final String Dashing_left [] = {"Player1animations/dash/dash1left.png","Player1animations/dash/dash2left.png","Player1animations/dash/dash3left.png","Player1animations/dash/dash4left.png","Player1animations/dash/dash5left.png","Player1animations/dash/dash6left.png"};
    private static final String Dashing_right [] = {"Player1animations/dash/dash1right.png","Player1animations/dash/dash2right.png","Player1animations/dash/dash3right.png","Player1animations/dash/dash4right.png","Player1animations/dash/dash5right.png","Player1animations/dash/dash6right.png"};
    private static final String Jumping_Image_File_right [] = {"Player1animations/jump/jump1right.png","Player1animations/jump/jump2right.png", "Player1animations/jump/jump3right.png", "Player1animations/jump/jump4right.png"};
    private static final String Jumping_Image_File_left [] = {"Player1animations/jump/jump1left.png","Player1animations/jump/jump2left.png", "Player1animations/jump/jump3left.png", "Player1animations/jump/jump4left.png"};
    private static final String Running_Image_File_idle_right [] = {"Player1animations/idle/idle1right.png","Player1animations/idle/idle2right.png", "Player1animations/idle/idle3right.png", "Player1animations/idle/idle4right.png"};
    private static final String Running_Image_File_idle_left [] = {"Player1animations/idle/idle1left.png","Player1animations/idle/idle2left.png", "Player1animations/idle/idle3left.png", "Player1animations/idle/idle4left.png"};
    private static final String Running_Image_File_right [] = {"Player1animations/run/run1right.png","Player1animations/run/run2right.png","Player1animations/run/run3right.png","Player1animations/run/run4right.png"};
    private static final String Running_Image_File_left [] = {"Player1animations/run/run1left.png","Player1animations/run/run2left.png","Player1animations/run/run3left.png","Player1animations/run/run4left.png"};
    private static final String backgroundImages [] = {"sprites/Background/Backdrop1.png","sprites/Background/Backdrop2.png","sprites/Background/Backdrop3.png","sprites/Background/Backdrop4.png"};
    private static final String backgroundImagesDash [] = {"sprites/Background/Backdrop1Dash.png","sprites/Background/Backdrop2Dash.png","sprites/Background/Backdrop3Dash.png","sprites/Background/Backdrop4Dash.png"};
    //Player's current score
    private int score;
    public boolean dashOnCooldown = false;
    //Stores a reference to game's PlayerEntity object for quick reference
    //(This PlayerEntity will also be in the displayList)
    private Player player;
    private Timer timer_dash;
    //private Backdrop background;
    int runningcouter =0;
    int idleCounter =0;
    int jumpCounter = 2;
    int dashCounter =0;
    int dashTimer = 0;
    
    
    public OneGame(){
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    
    public OneGame(int gameWidth, int gameHeight){
        super(gameWidth, gameHeight);
    }
    
    
    //Performs all of the initialization operations that need to be done before the game starts
    protected void preGame(){
        setTitleText("Super Scrolling Game");
        this.setBackgroundColor(Color.BLACK);
        player = new Player(STARTING_PLAYER_X, STARTING_PLAYER_Y);
        timer_dash = new Timer();
        super.setSplashImage(INTRO_SPLASH_FILE);
        setBackgroundImage("sprites/Background/Backdrop1.png");
        displayList.add(timer_dash);
        displayList.add(player);
        vely = 0.0; 
        score = 0;
    }
    
    
    //Called on each game tick
    protected boolean updateGame(){
        if (isGameOver()==false){
            ArrayList<Enemies> collisionsList = checkCollision(player);
        if (score ==50){
            SPAWN_INTERVAL= 50;
        }
        if (score ==100){
            SPAWN_INTERVAL=45;
        }
        if (backrndCounter == 4){
            backrndCounter = 0;
        }
        if (isDashing){
            setBackgroundImage(backgroundImagesDash[backrndCounter]);
        }  
        else{
            setBackgroundImage(backgroundImages[backrndCounter]);
        }   
        if (ticksElapsed % 10 == 0){
            backrndCounter++;
        }
        
        for (int i = 0; i < collisionsList.size(); i++){
            if (!isDashing){
                if ((collisionsList.get(i) instanceof canCollide)){
                    handlePlayerCollision((canCollide)collisionsList.get(i));
                    displayList.remove(collisionsList.get(i));
                }
            }
        }
        //scroll all scrollable Entities on the game board
        scrollEntities();   
        //Spawn new entities only at a certain interval 

        if (vely< gravity){
            vely = vely+.19;
        }
        if (player.getY()+vely>GROUND){
            vely = GROUND-player.getY();
            jumping =false;
        }
        if (player.getY()<GROUND){
            player.setY(player.getY()+vely);
        }
        else if(vely<0){
            player.setY(player.getY()+vely);
        }
        else{
            vely =0;
        }
        
        
        if(leftTrue==false && rightTrue==false){
            if (velx<0){
                velx=velx/1.12;
            }
            if (velx>0){
                velx=velx/1.12;
            }
        }
        if (((player.getX()+player.getWidth())>=DEFAULT_WIDTH)){
            player.setX(DEFAULT_WIDTH-player.getWidth()-1);
            velx =0;
        }
        if (((player.getX()+player.getWidth())<=DEFAULT_WIDTH)&&(player.getX()>=0)){
            if(player.getX()+velx<0){
                velx = 0;
            }
            
            player.setX(player.getX()+velx);
        }
        if (velx>7){
            isDashing = true;
            velx = velx-1.24;
            
        }
        else if (velx<-7){
            isDashing = true;
            velx = velx+1.24;
        }
        else{
            isDashing = false;
        }
        if (leftTrue){
            left = true;
            right = false;
        }
        else if(rightTrue){
            left = false;
            right = true;
        }
        
        if (isDashing){
            runningcouter =0;
            idleCounter =0;
            jumpCounter = 2;
            if (dashCounter==0){
                player.setWidth(10*5);
                player.setHeight(16*5);
            }
            else if (dashCounter==1){
                player.setWidth(20*5);
                player.setHeight(15*5);
            }
            else if (dashCounter==2){
                player.setWidth(23*5);
                player.setHeight(14*5);
            }
            else if (dashCounter==3){
                player.setWidth(24*5);
                player.setHeight(14*5);
            }
            else if (dashCounter==4){
                player.setWidth(22*5);
                player.setHeight(14*5);
            }
            else if (dashCounter==5){
                player.setWidth(22*5);
                player.setHeight(14*5);
            }
            
            if (right){
                player.setImageName(Dashing_right[dashCounter]);
            }
            if (left){
                player.setImageName(Dashing_left[dashCounter]);
            }
            if(ticksElapsed%4==0){
                if(dashCounter<5){
                    dashCounter++;
                }
                
            }

        }
        else if (jumping){ 
            player.setWidth(50);
            dashCounter =0;
            runningcouter =0;
            idleCounter =0;
            if (vely< -.05){
                if (rightTrue||leftTrue){
                    if (right){
                        player.setImageName(Jumping_Image_File_right[0]);
                        player.setWidth(10*5);
                        player.setHeight(16*5);
                    }
                    if (left){
                        player.setImageName(Jumping_Image_File_left[0]);
                        player.setWidth(10*5);
                        player.setHeight(16*5);
                    }
                }
                else if (!rightTrue&&!leftTrue){
                    if (right){
                        player.setWidth(6*5);
                        player.setHeight(14*5);
                        player.setImageName(Jumping_Image_File_right[1]);
                    }
                    if (left){
                        player.setWidth(6*5);
                        player.setHeight(14*5);
                        player.setImageName(Jumping_Image_File_left[1]);
                    }
                }
            }
            else if (vely>=-.05){
                if (jumpCounter == 4){
                    jumpCounter = 2;
                }
                if (jumpCounter==2){
                    player.setWidth(11*5);
                }
                else{
                    player.setWidth(10*5);
                }
                player.setHeight(15*5);
                if (right){
                    player.setImageName(Jumping_Image_File_right[jumpCounter]);
                }
                if (left){
                    player.setImageName(Jumping_Image_File_left[jumpCounter]);
                }
                if(ticksElapsed%6==0){
                    jumpCounter++;
            }
            }
        }
        else if (leftTrue){
            left = true;
            right = false;
            if (runningcouter == 4){
                runningcouter = 0;
            }
            if(runningcouter == 0){
                player.setWidth(12*5);
                player.setHeight(15*5);
            }
            else if(runningcouter == 1){
                player.setWidth(10*5);
                player.setHeight(16*5);
            }
            else if(runningcouter == 2){
                player.setWidth(9*5);
                player.setHeight(16*5);
            }
            else{
                player.setWidth(10*5);
                player.setHeight(16*5);
            }
            player.setImageName(Running_Image_File_left[runningcouter]);
            if(ticksElapsed%7==0){
                runningcouter++;
            }
            jumpCounter=2;
            dashCounter =0;
            idleCounter =0;
        }
        else if (rightTrue){
            player.setWidth(10*5);
            right = true;
            left = false;
            if (runningcouter == 4){
                runningcouter = 0;
            }
            if(ticksElapsed%7==0){
                player.setImageName(Running_Image_File_right[runningcouter]);
                runningcouter++;
            }
            jumpCounter=2;
            dashCounter =0;
            idleCounter =0;
        }
        else if (right||left){
            player.setWidth(10*5);
            runningcouter=0;
            dashCounter =0;
            jumpCounter = 2;
            if (idleCounter == 4){
                idleCounter = 0;
            }
            if (idleCounter == 0){
                player.setWidth(8*5);
                player.setHeight(16*5);
            }
            else{
                player.setWidth(8*5);
                player.setHeight(15*5);
            }
            if (right){
                player.setImageName(Running_Image_File_idle_right[idleCounter]);
            }
            else{
                player.setImageName(Running_Image_File_idle_left[idleCounter]);
            }
            
            if(ticksElapsed%7==0){
                idleCounter++;
            }
        }
        if (((player.getX()+player.getWidth())>=DEFAULT_WIDTH)){
            player.setX(DEFAULT_WIDTH-player.getWidth()-1);
            velx =0;
        }
        if (ticksElapsed % SPAWN_INTERVAL == 0){  
            score++;          
            spawnNewEntities();
            garbageCollectEntities();
        }
        if (dashOnCooldown ==true){
            dashTimer++;
        }
        
        if (dashTimer == 165){
            dashOnCooldown=false;
            dashTimer = 0;
        }
        timer_dash.tellTime(dashTimer,dashOnCooldown);
        //Update the title text on the top of the window
        setTitleText("HP: "+ player.getHP() + ", Score: " + score); 
    }
    return (isDashing);
} 
    
    
    
    //Scroll all scrollable entities per their respective scroll speeds
    protected void scrollEntities(){
        for (int i = 0; i < displayList.size(); i++){
            if (displayList.get(i) instanceof canCollide){
                if (displayList.get(i) instanceof lavaProjectile){
                    ((lavaProjectile)displayList.get(i)).shoot(ticksElapsed,isDashing);
                }
                if (displayList.get(i) instanceof slime){
                    ((slime)displayList.get(i)).scroll(ticksElapsed,isDashing);
                }
                if (displayList.get(i) instanceof Skull){
                    ((Skull)displayList.get(i)).scroll(isDashing);
                }
                if (displayList.get(i) instanceof necromancer){
                    boolean skull = ((necromancer)displayList.get(i)).floats(isDashing);
                    if (skull){
                        Enemies skullProjectile = new Skull((int)(((necromancer)displayList.get(i)).getX()),(int)(((necromancer)displayList.get(i)).getY()));
                        displayList.add(skullProjectile);
                        //System.out.println(displayList);
                    }
                }
                
                
            }
        }
    }
    
    
    //Handles "garbage collection" of the displayList
    //Removes entities from the displayList that are no longer relevant
    //(i.e. will no longer need to be drawn in the game window).
    protected void garbageCollectEntities(){
        for (int i = 0; i < displayList.size(); i++){   
            if ((displayList.get(i) instanceof canCollide)){
                if (displayList.get(i).getX()>DEFAULT_WIDTH+displayList.get(i).getWidth()+60){
                    displayList.remove(i);
                }
                else if(displayList.get(i).getY()<0-displayList.get(i).getHeight()-60){
                    displayList.remove(i);
                }
                else if(displayList.get(i).getX()<0-displayList.get(i).getWidth()-60){
                    displayList.remove(i);
                }
                else if(displayList.get(i).getY()>DEFAULT_HEIGHT+displayList.get(i).getHeight()+60){
                    displayList.remove(i);
                }
            }    
        }
        //System.out.println(displayList);
    }
    
    
    //Called whenever it has been determined that the PlayerEntity collided with a consumable
    private void handlePlayerCollision(canCollide collidedWith){
            int damage = collidedWith.getDamageValue();
            int points = collidedWith.getPointsValue();
            score += points;
            boolean gameEnd = player.modifyHP(damage);
            if (gameEnd== false){
                isGameOver();
            }
    }
    
    
    //Spawn new Entities on the right edge of the game board
    private void spawnNewEntities(){
        int value = rand.nextInt(0,101);
        int startingX;
        if (value <=18){
            int oneHalf = rand.nextInt(0,2);
            if (oneHalf ==1){
                startingX = rand.nextInt(590,850);
            }
            else{
                startingX = rand.nextInt(50,310);
            }
            int startingY = 600;
            Enemies lava = new lavaProjectile(startingX,startingY);
            displayList.add(lava);
       }
        else if (value<=30){
            int oneHalf = rand.nextInt(0,2);
            if (oneHalf ==1){
                startingX = -30;
            }
            else{
                startingX = 900;
            }
            int startingY = GROUND;
            Enemies slime = new slime(startingX,startingY+78);
            displayList.add(slime);
        }
        else if (value<=35){
            int oneHalf = rand.nextInt(0,2);
            if (oneHalf ==1){
                startingX = 1;
            }
            else{
                startingX = 900-97;
            }
            int startingY = rand.nextInt(100,260);
            Enemies necromancer = new necromancer(startingX,startingY);
            displayList.add(necromancer);
        }

            
    }

    
    //Called once the game is over, performs any end-of-game operations
    protected void postGame(){
        if (score >=SCORE_TO_WIN){
            super.setTitleText("GAME OVER - You Won!");
        }
        if (player.getHP()<=0){
            super.setTitleText("GAME OVER - You Lose!");
        }
    }
    
    
    //Determines if the game is over or not
    //Game can be over due to either a win or lose state
    protected boolean isGameOver(){
        if (score >=SCORE_TO_WIN){
            postGame();
            return true;
        }
        else if(player.getHP()<=0){
            postGame();
            return true;
        }
        else{
            return false;
        }
    }
    
    private void upKey(int key){
        if (vely == 0){
            jumping = true;
            vely = -(double)(jumpVelocity);
        }
        
    }
    private void rightKey(int key){
            if(velx<6){
                velx++;
            }
            

    }
    private void leftKey(int key){
            if(velx>-6){
                velx--;
            }
        
    }
    private void spaceKey(){
        if (dashOnCooldown == false){
            if (rightTrue){
                velx = (double)(23);
                vely=.05;
                dashOnCooldown = true;
                dashTimer = 0;
            }
            if (leftTrue){
                velx = -(double)(25);
                vely = .05;
                dashOnCooldown = true;
                dashTimer = 0;
            }

        }
    }
    // private void plus(){
    //     SPEED_CHANGE += 1;
    //     Entity.scrollSpeed ++;
    //     if (SPAWN_INTERVAL>5){
    //         SPAWN_INTERVAL = SPAWN_INTERVAL-5;
    //     }
    // }
    
    // private void minus(){
    //     if (SPEED_CHANGE>0){
    //     SPEED_CHANGE += -1;
    //     if (SPAWN_INTERVAL<100){
    //         SPAWN_INTERVAL = SPAWN_INTERVAL+5;
    //     }
    //     }
    //     if (Entity.scrollSpeed>0){
    //         Entity.scrollSpeed --;
    //     }
    // }
    
    
    //Reacts to a single key press on the keyboard
    protected void handleKeyPress(int key){
        
        setDebugText("Key Pressed!: " + KeyEvent.getKeyText(key));
        if (key == UP_KEY){
            upKey(key);
        }
        if (key == RIGHT_KEY){
            rightKey(key);
        }
        if (key == LEFT_KEY){
            leftKey(key);
        }
        if (key==SPACE_KEY){
            spaceKey();
        }
        // if (key == SPEED_UP_KEY){
        //     plus();
        // }
        // if (key == SPEED_DOWN_KEY){
        //     minus();
        // }
        if (key == KEY_PAUSE_GAME){
            if (isPaused == true){
                isPaused = false;
            }
            else if (isPaused ==false){
                isPaused = true;
            }
        }

        //if a splash screen is active, only react to the "advance splash" key... nothing else!
        if (getSplashImage() != null){
            if (key == ADVANCE_SPLASH_KEY)
                super.setSplashImage(null);
            
            return;
        }
    }    
    
    
    //Handles reacting to a single mouse click in the game window
    //Won't be used in Simple Game... you could use it in Creative Game though!
    protected MouseEvent handleMouseClick(MouseEvent click){
        if (click != null){ //ensure a mouse click occurred
            int clickX = click.getX();
            int clickY = click.getY();
            setDebugText("Click at: " + clickX + ", " + clickY);
        }
        return click;//returns the mouse event for any child classes overriding this method
    }
    
}
