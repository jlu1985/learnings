package jlu.concurrency;

public class LearnThreads implements Runnable{

    @Override
    public void run() {
        
        for (int i = 0; i < 40;i++) {
            try {
                Thread.sleep(400);
                System.out.println("sleeping 4 sec");
            }catch (InterruptedException e){
                System.out.println("interrupted");
                return;
            }
            
        }
        System.out.println("Hello world in run method");
        
    }
    
    public static void main(String[] args) throws InterruptedException {
       Thread t =  new Thread(new LearnThreads());
       t.start();
       Thread.sleep(7000);
//       t.interrupt();
    }
    
}
