import java.util.ArrayList;

import javafx.application.Platform;


public class MyThreadThing extends Thread
 {
   Square square;
   int k;
   int count = 0;

   private final Object mutex;
   protected volatile boolean isPaused=false;
  

   public MyThreadThing(Square square, int k, Object mutex){
    
    this.square = square;
    this.k = k;
    this.mutex = mutex;
    square.setRandomColor();
   } 

//    public void pauseThread() {
        
//             isPaused = true;
           
//     }
    
//     public void resumeThread() {
        
//             isPaused = false;
//             notify();
        
        
//     }

    synchronized public void setBlocked() 
    {
        synchronized(square.getMyMutex())
        {
            System.out.println("Zmieniam aktywność");
            this.isPaused = !this.isPaused;
            notify();
        }
    }


    

   @Override
   public void run() {
        while (true) {
            
                try {

                    if(isPaused){

                        synchronized(this){
                            while(isPaused){
                                wait();
                            }
                        }

                    }
                } catch (InterruptedException e) {}

                synchronized(mutex){
                    try {

                    
                        System.out.println("Start: " + count);
                        square.doTaskAction();
                        System.out.println("End: " + count);
                    
                    
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
               
            try {
                Thread.sleep(RandomGenerator.sleepTime(k));
                
            } catch (Exception e) {
                e.printStackTrace();
            }
  
            
        }
   }

   

}
