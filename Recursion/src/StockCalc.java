import java.util.concurrent.RecursiveAction;

public class StockCalc extends RecursiveAction {
    //define problem
    private double[] prices;
    private int lo;
    private int hi;
    
    //defines answers to computes
    private double minProfit;
    
    private double maxProfit;
    private int whereBuy;
    private int whereSell;
    
    private double maxPrice;
    private int maxIndex;
    
    private double minPrice;
    private int minIndex;
    
    public StockCalc(double[] arr, int l, int h) {
        prices = arr;
        lo = l;
        hi = h;
        minPrice = 10000.0;
    }
      
    @Override
    public void compute() {
        if(hi-lo == 1) {
            //base case
            minProfit = 0.0;
            maxProfit = 0.0;
            minPrice = prices[lo];
            maxPrice = prices[lo];
            
            whereBuy = lo;
            whereSell = lo;
            maxIndex = lo;
            minIndex = lo;
        }else {
            StockCalc left = new StockCalc(prices, lo, (lo+hi)/2);
            StockCalc right = new StockCalc(prices,(lo+hi)/2, hi);
            
            left.fork();
            right.compute();
            left.join();
            
            minPrice = minOfTwo(left.minPrice, right.minPrice);
            
            maxPrice = maxOfTwo(left.maxPrice, right.maxPrice);
            maxProfit = maxOfThree(left.maxProfit, right.maxProfit, right.maxPrice - left.minPrice);
            
            
            minProfit = minOfThree(left.minProfit, right.minProfit, right.minPrice - left.maxPrice);

            
            
            
            
            if(left.minPrice == minPrice) {
                minIndex = left.minIndex;
            }else {
                minIndex = right.minIndex;
            }
            
            
            if(left.maxPrice == maxPrice) {
                maxIndex = left.maxIndex;
            }else {
                maxIndex = right.maxIndex;
            }
            
            
            if(left.maxProfit == maxProfit) {
                whereBuy = left.whereBuy;
                whereSell = left.whereSell;
            }else if(right.maxProfit == maxProfit) {
                whereBuy = right.whereBuy;
                whereSell = right.whereSell;

            }else {
                whereBuy = left.minIndex;
                whereSell = right.maxIndex;
            }
            
        }
        
    }
    
    public int getWhereBuy() {
        return whereBuy;
    }
    
    public int getWhereSell() {
        return whereSell;
    }
    
    public double getMaxProfit() {
        return maxProfit;
    }
    
    public double getMinProfit() {
        return minProfit;
    }
    
    private double minOfTwo(double x, double y) {
        if(x<y) {
            return x;
        }
        return y;
        
        
    }
    private double maxOfTwo(double x, double y) {
        if(x>y) {
            return x;
        }
        return y;
        
        
    }
    private double maxOfThree(double x, double y, double z) {
        return maxOfTwo(x, maxOfTwo(y, z));
    }
    
    private double minOfThree(double x, double y, double z) {
        return minOfTwo(x, minOfTwo(y, z));

    }

}
