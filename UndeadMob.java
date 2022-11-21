import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class UndeadMob extends Enemies implements canCollide{
        private static final String[] Undeadmob_idle_right = new String[8];
        private static final String[] Undeadmob_idle_left = new String[8];
        private static final String[] Undeadmob__Appear_right = new String[17];
        private static final String[] Undeadmob_Appear_left = new String[17];
        //Location of image file to be drawn for an AvoidEntity
        //Dimensions of the AvoidEntity    
        private static final int AVOID_WIDTH = (int)(45*2);
        private static final int AVOID_HEIGHT =  (int)(62*2);
        public static Random rand = new Random();
        private double scrollSpeed;
        private double startingX ;
        private double startingY;
        private double Yrange = 20;
        private boolean left = false;
        private boolean right = false;
        private int counter;
        private int downOrUp;
        
        //Speed that the avoid moves each time the game scrolls
        public double AVOID_SCROLL_SPEED = 5;
        
        public UndeadMob(){
            this(50, 500);   
        }
        
        public UndeadMob(int x, int y){
            super(x, y, AVOID_WIDTH, AVOID_HEIGHT, null);  
            startingX = (double)x;
            startingY=(double)y;
            scrollSpeed = 1;
            counter = 0;
            downOrUp  = rand.nextInt(0,2);

            for (int i =0; i<Undeadmob_idle_right.length;i++){
                Undeadmob_idle_right[i] = "sprites/UndeadMob/Idle/IdleRight/idle" + i + ".png";
                Undeadmob_idle_left[i] = "sprites/UndeadMob/Idle/IdleLeft/idle" + i + ".png";
            }
            for (int i =0; i<Undeadmob__Appear_right.length;i++){
                Undeadmob__Appear_right[i] = "sprites/UndeadMob/Appear/AppearRight/Appear" + i + ".png";
                Undeadmob_Appear_left[i] = "sprites/UndeadMob/Appear/AppearLeft/Appear" + i + ".png";
            }
            if (startingX>450){
                left=true;
                right = false;
            }
            else{
                left=false;
                right = true;
            }
            if (right){
                setImageName(Undeadmob_idle_right[0]);
            }
            else{
                setImageName(Undeadmob_idle_left[0]);
            }
        }
        
        public void floats (){

            
            if (counter>=640){
                setX(2000);
            }

            counter++;
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