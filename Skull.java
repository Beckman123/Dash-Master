import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Skull extends Enemies implements canCollide{
        private static final String[] LeftSkull = new String[32];
        private static final String[] RightSkull = new String[32];
        private static final String[] RightSkullDash = new String[32];
        private static final String[] LeftSkullDash = new String[32];

        
        //Location of image file to be drawn for an AvoidEntity
        //Dimensions of the AvoidEntity    
        private static final int AVOID_WIDTH = (int)(320*.3);
        private static final int AVOID_HEIGHT =  (int)(140*.3);
        public static Random rand = new Random();
        private double scrollSpeed;
        private double startingX ;
        private double startingY;
        private double Yrange = 20;
        private boolean left = false;
        private boolean right = false;
        private int counter;
        private int downOrUp;
        private int imageCounter = 0;
        private int upOne =0;
        
        //Speed that the avoid moves each time the game scrolls
        public double AVOID_SCROLL_SPEED = 5;
        
        public Skull(){
            this(50, 500);   
        }
        
        public Skull(int x, int y){
            super(x, y, AVOID_WIDTH, AVOID_HEIGHT, "sprites/necromancer/SkullLeft/fireball1.png");  
            startingX = (double)x;
            startingY=(double)y;
            scrollSpeed = 3.6;
            counter = 0;
            downOrUp  = rand.nextInt(0,2);
            for (int i =1; i<LeftSkull.length+1;i++){
                LeftSkull[i-1] = "sprites/necromancer/SkullLeft/fireball" + i + ".png";
                RightSkull[i-1] = "sprites/necromancer/SkullRight/fireball" + i + ".png";
                RightSkullDash[i-1] = "sprites/necromancer/SkullRight/Dash/fireball" + i + ".png";
                LeftSkullDash[i-1] = "sprites/necromancer/SkullLeft/Dash/fireball" + i + ".png";
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
                setImageName(RightSkull[0]);
            }
            else{
                setImageName(LeftSkull[0]);
            }
        }
        public void scroll(boolean isDashing){
            if (downOrUp == 0){
                setY((65*Math.sin((Math.PI/90)*counter)+(double)startingY)+(double)upOne*.5);
                } 
            else{
                setY((-65*Math.sin((Math.PI/90)*counter)+(double)startingY)+(double)upOne*.5);
            }
            if(imageCounter==32){
                imageCounter = 0;
            }
            if (right){
                setX(getX()+scrollSpeed);
            }
            else{
                setX(getX()-scrollSpeed);
            }
            if (imageCounter==0){
                upOne = 0;
                setWidth((int)(320*.3));
                setHeight((int)(140*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==1){
                setWidth((int)(320*.3));
                setHeight((int)(140*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==2){
                setWidth((int)(320*.3));
                setHeight((int)(120*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==3){
                setWidth((int)(300*.3));
                setHeight((int)(120*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==4){
                setWidth((int)(320*.3));
                setHeight((int)(140*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==5){
                setWidth((int)(340*.3));
                setHeight((int)(160*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==6){
                setWidth((int)(340*.3));
                setHeight((int)(160*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==7){
                setWidth((int)(340*.3));
                setHeight((int)(160*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==8){
                upOne = 1;
                setWidth((int)(320*.3));
                setHeight((int)(160*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==9){
                setWidth((int)(300*.3));
                setHeight((int)(160*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==10){
                setWidth((int)(300*.3));
                setHeight((int)(140*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==11){
                setWidth((int)(320*.3));
                setHeight((int)(160*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==12){
                setWidth((int)(340*.3));
                setHeight((int)(180*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==13){
                setWidth((int)(340*.3));
                setHeight((int)(160*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==14){
                setWidth((int)(340*.3));
                setHeight((int)(160*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==15){
                setWidth((int)(320*.3));
                setHeight((int)(160*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==16){
                upOne = 0;
                setWidth((int)(300*.3));
                setHeight((int)(140*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==17){
                setWidth((int)(320*.3));
                setHeight((int)(140*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==18){
                setWidth((int)(300*.3));
                setHeight((int)(140*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==19){
                setWidth((int)(320*.3));
                setHeight((int)(120*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==20){
                setWidth((int)(340*.3));
                setHeight((int)(140*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==21){
                setWidth((int)(340*.3));
                setHeight((int)(120*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==22){
                setWidth((int)(340*.3));
                setHeight((int)(120*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==23){
                setWidth((int)(320*.3));
                setHeight((int)(120*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==24){
                setWidth((int)(300*.3));
                setHeight((int)(120*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==25){
                upOne=1;
                setWidth((int)(320*.3));
                setHeight((int)(120*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==26){
                setWidth((int)(300*.3));
                setHeight((int)(120*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==27){
                setWidth((int)(320*.3));
                setHeight((int)(120*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==28){
                setWidth((int)(340*.3));
                setHeight((int)(140*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==29){
                setWidth((int)(340*.3));
                setHeight((int)(120*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==30){
                setWidth((int)(340*.3));
                setHeight((int)(120*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (imageCounter==31){
                setWidth((int)(300*.3));
                setHeight((int)(120*.3));
                if (right){
                    if(isDashing){
                        setImageName(RightSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(RightSkull[imageCounter]);
                    }
                }
                else{
                    if(isDashing){
                        setImageName(LeftSkullDash[imageCounter]);
                    }
                    else{
                        setImageName(LeftSkull[imageCounter]);
                    }
                }
            }
            if (counter%6 == 0){
                imageCounter++;
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