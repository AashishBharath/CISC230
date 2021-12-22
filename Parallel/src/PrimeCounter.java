import java.util.concurrent.RecursiveAction;

public class PrimeCounter extends RecursiveAction{
    private int[] numbers;
    private int lo;
    private int hi;
    private int answer;
    
    public PrimeCounter(int[] arr, int l,int h) {
        numbers = arr;
        lo = l;
        hi = h;
        answer = 0;
    }
    public int getAnswer() {
        return answer;
    }
    
    private boolean isPrime(int number) {
        if(number<2) {
            return false;
        }else {
            for(int i = 2;i<Math.sqrt(number); i++) {
                if(number%i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    protected void compute() {
        if((hi-lo) <= 2000) {
            for(int i = lo;i<hi;i++) {
                if(isPrime(numbers[i])) {
                    answer = answer + 1;
                }
            }
        }else {
            PrimeCounter left = new PrimeCounter(numbers, lo, (lo+hi)/2);
            PrimeCounter right = new PrimeCounter(numbers, (lo+hi)/2, hi);
            left.fork();
            right.compute();
            left.join();
            answer = left.getAnswer() + right.getAnswer();
        }
    }
    

}
