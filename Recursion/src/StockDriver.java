 import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class StockDriver {

    public static void main(String[] args) {
    List<String> lines;
    double[] prices;
    
    try {
        lines = Files.readAllLines(Paths.get("GE.csv"), StandardCharsets.UTF_8);
    }catch(IOException e) {
        System.out.println("Problem reading file");
        return;
    }
    
    //First row of csv are column headers, so minus one is used
    prices = new double[lines.size()-1];
    
    for(int i = 1; i< lines.size(); i++) {
        String[] parts = lines.get(i).split(",");
        //i-1 because of header in CSV
        prices[i-1] = Double.parseDouble(parts[4]);
    }
    
    StockCalc initial = new StockCalc(prices, 0, prices.length);
    initial.compute();
    ForkJoinPool.commonPool().invoke(initial);

    System.out.println("Max profit was " + initial.getMaxProfit());
    
    int buy = initial.getWhereBuy();
    int sell = initial.getWhereSell();
    System.out.println("Buy on " + lines.get(buy+1).split(",")[0] + "\nSell on " + lines.get(sell+1).split(",")[0]);
    
    System.out.println("Min profit could have been: " + initial.getMinProfit());

}
}
