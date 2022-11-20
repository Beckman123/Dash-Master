public class Timer extends Enemies{
        private static String Timer_Images [] = new String [56];
        //Location of image file to be drawn for an AvoidEntity
        //Dimensions of the AvoidEntity    
        private static final int Width = 100;
        private static final int Height = 100;
        
        public Timer(){
            this(402, 100);   
        }
        
        public Timer(int x, int y){
            super(x, y, Width, Height, Timer_Images[54]);  
            for (int i =0; i<Timer_Images.length;i++){
                if (i<10){
                    Timer_Images[i] = "sprites/Timer/0" + i + ".png";
                }
                else{
                    Timer_Images[i] = "sprites/Timer/" + i + ".png";
                }
                
            }
        }
        public void tellTime (int counter, boolean dashOnCooldown){
            if (dashOnCooldown==false){
                setImageName(Timer_Images[55]); 
            }
            else if (counter%3 == 0){
                setImageName(Timer_Images[counter/3]); 
            }
        }
        
    }