import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class lavaProjectile extends Enemies implements canCollide{
    
        //Location of image file to be drawn for an AvoidEntity
        private static final String []DASH_IMG = {"sprites/FireBall/1blue.png","sprites/FireBall/2blue.png","sprites/FireBall/3blue.png","sprites/FireBall/4blue.png","sprites/FireBall/5blue.png"};
        private static final String []AVOID_IMAGE_FILE = {"sprites/FireBall/1.png","sprites/FireBall/2.png","sprites/FireBall/3.png","sprites/FireBall/4.png","sprites/FireBall/5.png"};
        private static final String []Crash = {"sprites/FireBall/Crash1.PNG","sprites/FireBall/Crash2.PNG","sprites/FireBall/Crash3.PNG"};
        private static final String []Crash_Dash = {"sprites/FireBall/Crash1Blue.png","sprites/FireBall/Crash2Blue.png","sprites/FireBall/Crash3Blue.png"};
        //Dimensions of the AvoidEntity    
        private static final int AVOID_WIDTH = 300/5;
        private static final int AVOID_HEIGHT = 300/5;
        public static Random rand = new Random();
        private double startingX;
        private double startingY;// = 500;
        private double endingX;
        private double verticyX;
        private double verticyY;
        private double variableInFront;
        private static double scrollSpeed = 1.65;
        private int fireballCounter = 0;
        private int fireballSplash = 0;
        private boolean splashTime = false;
        
        //Speed that the avoid moves each time the game scrolls
        public double AVOID_SCROLL_SPEED = 5;
        
        public lavaProjectile(){
            this(50, 500);   
        }
        
        public lavaProjectile(int x, int y){
            super(x, y, AVOID_WIDTH, AVOID_HEIGHT, AVOID_IMAGE_FILE[0]);  
            this.startingX = x;
            this.startingY = y;
            verticyY = rand.nextInt(90,110);
            if(startingX<450){
                endingX = (double)rand.nextInt(580,850);
            }
            else{
                endingX = (double)rand.nextInt(50,320);
            }
            verticyX = ((double)startingX + (double)endingX)/2;
            double bottomSquared = ((double)startingX-(double)verticyX)*((double)startingX-(double)verticyX);
            variableInFront = ((double)startingY-(double)verticyY)/bottomSquared;
        }
        
        
        public double getScrollSpeed(){
            return scrollSpeed;
        }
    
        public void setScrollSpeed(int i){
            this.scrollSpeed = i;
        }
        
        //Move the avoid left by the scroll speed
        public void shoot(int ticksElap, boolean isDashing){
            if(splashTime== false){
                if(fireballCounter == 5){
                    fireballCounter =0;
                }
                if(startingX<endingX){
                    setX(getX()+(double)scrollSpeed); 
                }
                else {
                    setX(getX()-(double)scrollSpeed); 
                }
           
                setY(((variableInFront*((getX()-verticyX)*(getX()-verticyX)))+verticyY));
            
                if(isDashing){
                    if (isVisible()){
                        setImageName(DASH_IMG[fireballCounter]);
                    }
                }
                else{
                    if (isVisible()){
                        setImageName(AVOID_IMAGE_FILE[fireballCounter]);
                    }
                }

                if(ticksElap%9==0){  
                    fireballCounter++;
                }
            }
            
            if (startingX<endingX&&isVisible()){
                if(getX()>=verticyX){
                    if(getY()>=320){
                        splashTime = true;
                    }
                }
            }
            else if (isVisible()){
                if(getX()<verticyX){
                    if(getY()>=320){
                        splashTime = true;
                    }
                }
            }
            if (splashTime){
                if(fireballSplash == 0){
                    setWidth(465/5);
                    setHeight(260/5);
                }
                if (fireballSplash == 1){
                    setWidth(450/5);
                    setHeight(240/5);
                }
                if (fireballSplash == 2){
                    setWidth(510/5);
                    setHeight(210/5);
                }
                if (fireballSplash == 3){
                    fireballSplash =0;
                    setVisible(false);
                    if (!isVisible()){
                        setImageName(null);
                    }
                    setY(800);
                }
                else if (isDashing){
                    setImageName(Crash_Dash[fireballSplash]);
                }
                else{
                    setImageName(Crash[fireballSplash]);
                }
                
                if(ticksElap%7==0){  
                    fireballSplash++;
                }
                
            }
        }
        
        //Colliding with an AvoidEntity does not affect the player's score
        public int getPointsValue(){
           return 0;
        }
        
        //Colliding with an AvoidEntity Reduces players HP by 1
        public int getDamageValue(){
            return -1;
        }
        
    }