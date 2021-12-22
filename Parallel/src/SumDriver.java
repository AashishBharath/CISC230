import java.util.Random;

public class SumDriver {

    public static void main(String[] args) throws InterruptedException{
        int[] arr = new int[1000000];
        Random genertor = new Random();
        
        for(int i = 0;i<arr.length;i++) {
            arr[i] = genertor.nextInt(5);
        }
        int total = 0;
        for(int i = 0; i< arr.length;i++) {
            total = total + arr[i];
        }
        System.out.println("Correct sum is: " + total);
        
        
      //Sum with two thread running in parallel
      SumThread summer1 = new SumThread(arr, 0, arr.length/2);
      SumThread summer2 = new SumThread(arr,arr.length/2, arr.length);
      
      summer1.start();
      summer2.start();
     
      summer1.join();
      summer2.join();
      
      System.out.println("Sum is: " +(summer1.getAns() + summer2.getAns()));

    }
    
    

}
