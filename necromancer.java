import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class necromancer extends Enemies implements canCollide{
        private static final String[] Necromancer_throw_img_right = new String[17];
        private static final String[] Necromancer_throw_img_left = new String[17];

        private static final String[] Necromancer_Appear_right = {"sprites/necromancer/Appear/Appear1.png","sprites/necromancer/Appear/Appear2.png","sprites/necromancer/Appear/Appear3.png","sprites/necromancer/Appear/Appear4.png","sprites/necromancer/Appear/Appear5.png","sprites/necromancer/Appear/Appear6.png","sprites/necromancer/Appear/Appear7.png","sprites/necromancer/Appear/Appear8.png","sprites/necromancer/Appear/Appear9.png"};
        private static final String[] Necromancer_Appear_left = {"sprites/necromancer/AppearLeft/Appear1.png","sprites/necromancer/AppearLeft/Appear2.png","sprites/necromancer/AppearLeft/Appear3.png","sprites/necromancer/AppearLeft/Appear4.png","sprites/necromancer/AppearLeft/Appear5.png","sprites/necromancer/AppearLeft/Appear6.png","sprites/necromancer/AppearLeft/Appear7.png","sprites/necromancer/AppearLeft/Appear8.png","sprites/necromancer/AppearLeft/Appear9.png"};
        //Location of image file to be drawn for an AvoidEntity
        //Dimensions of the AvoidEntity    
        private static final int AVOID_WIDTH = (int)(42*2.3);
        private static final int AVOID_HEIGHT =  (int)(52*2.3);
        public static Random rand = new Random();
        private double scrollSpeed;
        private double startingX ;
        private double startingY;
        private double Yrange = 20;
        private boolean left = false;
        private boolean right = false;
        private int counter;
        private int downOrUp;
        private boolean skullSpawn;
        
        //Speed that the avoid moves each time the game scrolls
        public double AVOID_SCROLL_SPEED = 5;
        
        public necromancer(){
            this(50, 500);   
        }
        
        public necromancer(int x, int y){
            super(x, y, AVOID_WIDTH, AVOID_HEIGHT, Necromancer_Appear_right[0]);  
            startingX = (double)x;
            startingY=(double)y;
            scrollSpeed = 1;
            counter = 0;
            downOrUp  = rand.nextInt(0,2);
            skullSpawn = false;
            for (int i =1; i<Necromancer_throw_img_right.length+1;i++){
                Necromancer_throw_img_right[i-1] = "sprites/necromancer/Throw/Throw" + i + ".png";
                Necromancer_throw_img_left[i-1] = "sprites/necromancer/ThrowLeft/Throw" + i + ".png";
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
                setImageName(Necromancer_Appear_right[0]);
            }
            else{
                setImageName(Necromancer_Appear_left[0]);
            }
        }
        
        public boolean floats (boolean isDashing){
            skullSpawn = false;
            if (downOrUp == 0){
                setY(30*Math.sin((Math.PI/150)*counter)+(double)startingY);
            } 
            else{
                setY((-30*Math.sin((Math.PI/150)*counter)+(double)startingY));
            }
            if (counter==7||counter==633){
                setWidth((int)(57*2.3));
                setHeight((int)(62*2.3));
                if (right){
                    setImageName(Necromancer_Appear_right[0]);
                }
                else{
                    setImageName(Necromancer_Appear_left[0]);
                }
            }
            else if(counter==14||counter==626){
                setWidth((int)(53*2.3));
                setHeight((int)(60*2.3));
                if (right){
                    setImageName(Necromancer_Appear_right[1]);
                }
                else{
                    setImageName(Necromancer_Appear_left[1]);
                }
            }
            else if(counter==21||counter==619){
                setWidth((int)(50*2.3));
                setHeight((int)(67*2.3));
                if (right){
                    setImageName(Necromancer_Appear_right[2]);
                }
                else{
                    setImageName(Necromancer_Appear_left[2]);
                }
            }
            else if(counter==28||counter==612){
                setWidth((int)(44*2.3));
                setHeight((int)(51*2.3));
                if (right){
                    setImageName(Necromancer_Appear_right[3]);
                }
                else{
                    setImageName(Necromancer_Appear_left[3]);
                }
            }
            else if(counter==35||counter==605){
                setWidth((int)(51*2.3));
                setHeight((int)(47*2.3));
                if (right){
                    setImageName(Necromancer_Appear_right[4]);
                }
                else{
                    setImageName(Necromancer_Appear_left[4]);
                }
            }
            else if(counter==42||counter==598){
                setWidth((int)(48*2.3));
                setHeight((int)(47*2.3));
                if (right){
                    setImageName(Necromancer_Appear_right[5]);
                }
                else{
                    setImageName(Necromancer_Appear_left[5]);
                }
            }
            else if(counter==49||counter==591){
                setWidth((int)(46*2.3));
                setHeight((int)(45*2.3));
                if (right){
                    setImageName(Necromancer_Appear_right[6]);
                }
                else{
                    setImageName(Necromancer_Appear_left[6]);
                }
            }
            else if(counter==56||counter==584){
                setWidth((int)(44*2.3));
                setHeight((int)(46*2.3));
                if (right){
                    setImageName(Necromancer_Appear_right[7]);
                }
                else{
                    setImageName(Necromancer_Appear_left[7]);
                }
            }
            else if(counter==63||counter==577){
                setWidth((int)(40*2.3));
                setHeight((int)(46*2.3));
                if (right){
                    setImageName(Necromancer_Appear_right[8]);
                }
                else{
                    setImageName(Necromancer_Appear_left[8]);
                }
            }
            else if(counter==70||counter ==240||counter ==410){
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
                if (right){
                    setImageName(Necromancer_throw_img_right[0]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[0]);
                }
            }
            else if(counter==80||counter ==250||counter ==420){
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
                if (right){
                    setImageName(Necromancer_throw_img_right[1]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[1]);
                }
            }
            else if(counter==90||counter ==260||counter ==430){
                if (right){
                    setImageName(Necromancer_throw_img_right[2]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[2]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
            }
            else if(counter==100||counter ==270||counter ==440){
                if (right){
                    setImageName(Necromancer_throw_img_right[3]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[3]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
            }
            else if(counter==110||counter ==280||counter ==450){
                if (right){
                    setImageName(Necromancer_throw_img_right[4]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[4]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
            }
            else if(counter==120||counter ==290||counter == 460){
                if (right){
                    setImageName(Necromancer_throw_img_right[5]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[5]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
            }
            else if(counter==130||counter ==300||counter ==470){
                if (right){
                    setImageName(Necromancer_throw_img_right[6]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[6]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
            }
            else if(counter==140||counter ==310||counter ==480){
                if (right){
                    setImageName(Necromancer_throw_img_right[7]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[7]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
            }
            else if(counter==150||counter ==320||counter ==490){
                if (right){
                    setImageName(Necromancer_throw_img_right[8]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[8]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
            }
            else if(counter==160||counter ==330||counter ==500){
                if (right){
                    setImageName(Necromancer_throw_img_right[9]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[9]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
            }
            else if(counter==170||counter ==340||counter ==510){
                if (right){
                    setImageName(Necromancer_throw_img_right[10]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[10]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
            }
            else if(counter==180||counter ==350||counter ==520){
                if (right){
                    setImageName(Necromancer_throw_img_right[11]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[11]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
                
            }
            else if(counter==190||counter ==360||counter ==530){
                if (right){
                    setImageName(Necromancer_throw_img_right[12]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[12]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
                skullSpawn = true;
            }
            else if(counter==200||counter ==370||counter ==540){
                if (right){
                    setImageName(Necromancer_throw_img_right[13]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[13]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
            }
            else if(counter==210||counter ==380||counter ==550){
                if (right){
                    setImageName(Necromancer_throw_img_right[14]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[14]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
            }
            else if(counter==220||counter ==390||counter ==560){
                if (right){
                    setImageName(Necromancer_throw_img_right[15]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[15]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
            }
            else if(counter==230||counter ==400||counter ==570){
                if (right){
                    setImageName(Necromancer_throw_img_right[16]);
                }
                else{
                    setImageName(Necromancer_throw_img_left[16]);
                }
                setWidth((int)(42*2.3));
                setHeight((int)(45*2.3));
            }
            if (counter>=640){
                setX(2000);
            }

            counter++;
            return skullSpawn;
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