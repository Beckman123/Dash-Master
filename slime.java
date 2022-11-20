import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class slime extends Enemies implements canCollide{
    private static final String []Slime_Img_left = {"sprites/Slime/left/Slime1left.png","sprites/Slime/left/Slime2left.png","sprites/Slime/left/Slime3left.png","sprites/Slime/left/Slime4left.png","sprites/Slime/left/Slime5left.png","sprites/Slime/left/Slime6left.png","sprites/Slime/left/Slime7left.png","sprites/Slime/left/Slime8left.png"};
    private static final String []Slime_Img_right = {"sprites/Slime/Slime1.png","sprites/Slime/Slime2.png","sprites/Slime/Slime3.png","sprites/Slime/Slime4.png","sprites/Slime/Slime5.png","sprites/Slime/Slime6.png","sprites/Slime/Slime7.png","sprites/Slime/Slime8.png"};
    private static final String []Dash_Slime_Img_right = {"sprites/Slime/DashSlime1.png","sprites/Slime/DashSlime2.png","sprites/Slime/DashSlime3.png","sprites/Slime/DashSlime4.png","sprites/Slime/DashSlime5.png","sprites/Slime/DashSlime6.png","sprites/Slime/DashSlime7.png","sprites/Slime/DashSlime8.png"};
    private static final String []Dash_Slime_Img_left = {"sprites/Slime/left/DashSlimeLeft1.png","sprites/Slime/left/DashSlimeLeft2.png","sprites/Slime/left/DashSlimeLeft3.png","sprites/Slime/left/DashSlimeLeft4.png","sprites/Slime/left/DashSlimeLeft5.png","sprites/Slime/left/DashSlimeLeft6.png","sprites/Slime/left/DashSlimeLeft7.png","sprites/Slime/left/DashSlimeLeft8.png"};
        //Location of image file to be drawn for an AvoidEntity
        //Dimensions of the AvoidEntity    
        private static final int AVOID_WIDTH = 20*2;
        private static final int AVOID_HEIGHT =  17*2;
        public static Random rand = new Random();
        private double scrollSpeed;
        private double startingX ;
        private double startingY;
        private int slimeCounter = 0;
        private boolean left = false;
        private boolean right = false;

        
        //Speed that the avoid moves each time the game scrolls
        public double AVOID_SCROLL_SPEED = 5;
        
        public slime(){
            this(50, 500);   
        }
        
        public slime(int x, int y){
            super(x, y, AVOID_WIDTH, AVOID_HEIGHT, Slime_Img_right[0]);  
            startingX = x;
            startingY=y;
            scrollSpeed = rand.nextDouble(2,3.5);
        }
        
        public void scroll(int ticksElapsed,boolean isDashing){
            if(slimeCounter == 8){
                slimeCounter=0;
            }
            if (startingX>450){
                left=true;
                right = false;
            }
            else{
                left=false;
                right = true;
            }
            if(slimeCounter==0){
                setWidth(20*2);
                setHeight(17*2);
            }
            else if (slimeCounter==1){
                setWidth(24*2);
                setHeight(13*2);
            }
            else if (slimeCounter==2){
                setWidth(26*2);
                setHeight(12*2);

            }
            else if (slimeCounter==3){
                setWidth(28*2);
                setHeight(11*2);
            }
            else if (slimeCounter==4){
                setWidth(26*2);
                setHeight(12*2);
            }
            else if (slimeCounter==5){
                setWidth(24*2);
                setHeight(13*2);
            }
            else if (slimeCounter==6){
                setWidth(20*2);
                setHeight(17*2);
            }
            else if (slimeCounter==7){
                setWidth(20*2);
                setHeight(18*2);
            }
            if(right){
                if(isDashing){
                    setImageName(Dash_Slime_Img_right[slimeCounter]);
                }
                else{
                    setImageName(Slime_Img_right[slimeCounter]);
                }
                
                setX(getX()+scrollSpeed);
                setY(startingY-getHeight());
            }
            else if(left){
                if(isDashing){
                    setImageName(Dash_Slime_Img_left[slimeCounter]);
                }
                else{
                    setImageName(Slime_Img_left[slimeCounter]);
                }
                setX(getX()-scrollSpeed);
                setY(startingY-getHeight());
            }
           
            if (ticksElapsed%7==0){
                slimeCounter++;
            }
        }
        
        public double getScrollSpeed(){
            return scrollSpeed;
        }
    
        public void setScrollSpeed(int i){
            this.scrollSpeed = i;
        }
        
        //Move the avoid left by the scroll speed
        
        //Colliding with an AvoidEntity does not affect the player's score
        public int getPointsValue(){
           return 0;
        }
        
        //Colliding with an AvoidEntity Reduces players HP by 1
        public int getDamageValue(){
            return -1;
        }
        
    }