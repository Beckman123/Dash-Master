import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class UndeadMob extends Enemies implements canCollide{
        private static final String[] Undeadmob_idle_right = new String[8];
        private static final String[] Undeadmob_idle_left = new String[8];
        private static final String[] Undeadmob__Appear_right = new String[17];
        private static final String[] Undeadmob_Appear_left = new String[17];
        private static final String[] Summon_Right = new String[7];
        private static final String[] Summon_Left = new String[7];

        //Location of image file to be drawn for an AvoidEntity
        //Dimensions of the AvoidEntity    
        private static final int AVOID_WIDTH = (int)(12*2);
        private static final int AVOID_HEIGHT =  (int)(13*2);
        public static Random rand = new Random();
        private double scrollSpeed;
        private double startingX ;
        private double startingY;
        private double Yrange = 20;
        private boolean left = false;
        private boolean right = false;
        private int counter;
        private int downOrUp;
        private int pickAnimation;
        private int zeroOneorTwo = 0;
        
        //Speed that the avoid moves each time the game scrolls
        public double AVOID_SCROLL_SPEED = 5;
        
        public UndeadMob(){
            this(50, 500);   
        }
        
        public UndeadMob(int x, int y){
            super(x, y, AVOID_WIDTH, AVOID_HEIGHT, Undeadmob__Appear_right[0]);  
            startingX = (double)x;
            startingY=(double)y;
            scrollSpeed = 1;
            counter = 0;
            downOrUp  = rand.nextInt(0,2);
            pickAnimation = rand.nextInt(0,101);

            for (int i =0; i<Undeadmob_idle_right.length;i++){
                Undeadmob_idle_right[i] = "sprites/UndeadMob/Idle/IdleRight/idle" + i + ".png";
                Undeadmob_idle_left[i] = "sprites/UndeadMob/Idle/IdleLeft/idle" + i + ".png";
            }
            for (int i =0; i<Summon_Left.length;i++){
                Summon_Right[i] = "sprites/UndeadMob/Summon/SummonRight/summon" + i + ".png";
                Summon_Left[i] = "sprites/UndeadMob/Summon/SummonLeft/summon" + i + ".png";
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
                setImageName(Undeadmob__Appear_right[0]);
            }
            else{
                setImageName(Undeadmob_Appear_left[0]);
            }
        }
        
        public int floats (){
            setY(5*Math.sin((Math.PI/100)*counter)+(double)startingY);
            if (counter==0){
                setWidth(12*2);
                setHeight(13*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[0]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[0]);
                }
            }
            else if (counter==6){
                setWidth(14*2);
                setHeight(13*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[1]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[1]);
                }
            }
            else if (counter==12){
                setWidth(14*2);
                setHeight(13*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[2]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[2]);
                }
            }
            else if (counter==18){
                setWidth(14*2);
                setHeight(13*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[3]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[3]);
                }
            }
            else if (counter==24){
                setWidth(14*2);
                setHeight(13*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[4]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[4]);
                }
            }
            else if (counter==30){
                setWidth(15*2);
                setHeight(14*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[5]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[5]);
                }
            }
            else if (counter==36){
                setWidth(17*2);
                setHeight(17*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[6]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[6]);
                }
            }
            else if (counter==42){
                setWidth(20*2);
                setHeight(18*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[7]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[7]);
                }
            }
            else if (counter==48){
                setWidth(26*2);
                setHeight(21*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[8]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[8]);
                }
            }
            else if (counter==54){
                setWidth(26*2);
                setHeight(30*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[9]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[9]);
                }
            }
            else if (counter==60){
                setWidth(22*2);
                setHeight(39*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[10]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[10]);
                }
            }
            else if (counter==66){
                setWidth(20*2);
                setHeight(44*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[11]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[11]);
                }
            }
            else if (counter==72){
                setWidth(21*2);
                setHeight(54*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[12]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[12]);
                }
            }
            else if (counter==78){
                setWidth(31*2);
                setHeight(54*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[13]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[13]);
                }
            }
            else if (counter==84){
                setWidth(53*2);
                setHeight(60*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[14]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[14]);
                }
            }
            else if (counter==90){
                setWidth(53*2);
                setHeight(63*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[15]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[15]);
                }
            }
            else if (counter==96){
                setWidth(53*2);
                setHeight(63*2);
                if (right){
                    setImageName(Undeadmob__Appear_right[16]);
                }
                else{
                    setImageName(Undeadmob_Appear_left[16]);
                }
            }
            else if (counter==104){
                setWidth(45*2);
                setHeight(62*2);
                if (right){
                    setImageName(Summon_Right[0]);
                }
                else{
                    setImageName(Summon_Left[0]);
                }
            }
            else if (counter==112){
                setWidth(48*2);
                setHeight(67*2);
                if (right){
                    setImageName(Summon_Right[1]);
                }
                else{
                    setImageName(Summon_Left[1]);
                }
            }
            else if (counter==120){
                setWidth(53*2);
                setHeight(73*2);
                if (right){
                    setImageName(Summon_Right[2]);
                }
                else{
                    setImageName(Summon_Left[2]);
                }
            }
            else if (counter==128){
                setWidth(55*2);
                setHeight(69*2);
                if (right){
                    setImageName(Summon_Right[3]);
                }
                else{
                    setImageName(Summon_Left[3]);
                }
                if (pickAnimation<=35){
                    zeroOneorTwo = 1;
                }
                else{
                    zeroOneorTwo = 2;
                }   
            }
            else if (counter==136){
                setWidth(48*2);
                setHeight(67*2);
                if (right){
                    setImageName(Summon_Right[4]);
                }
                else{
                    setImageName(Summon_Left[4]);
                }
            }
            else if (counter==144){
                setWidth(53*2);
                setHeight(73*2);
                if (right){
                    setImageName(Summon_Right[5]);
                }
                else{
                    setImageName(Summon_Left[5]);
                }
            }
            else if (counter==152){
                setWidth(48*2);
                setHeight(67*2);
                if (right){
                    setImageName(Summon_Right[6]);
                }
                else{
                    setImageName(Summon_Left[6]);
                }
            }
            

            if (pickAnimation<=40){

            }
            else{

            }   

            if (counter>=640){
                setX(2000);
            }
            counter++;
            return zeroOneorTwo;
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