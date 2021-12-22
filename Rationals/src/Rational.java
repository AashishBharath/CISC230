
public class Rational implements Comparable<Rational> {
    
    //Class Variables
    public static final Rational ZERO = new Rational(0,1);
    public static final Rational ONE = new Rational(1,1);
    
    
    
    //Instance Variables   
    private int numerator;
    private int denominator;
    
    
    //constructors
    public Rational(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);
        
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;
    }
    
    /*
    public Rational(String divideString) {
        
    }
    
    public Rational(String decimalString) {
        
    }
    */
    
    //Constructs Rational without actually using a constructor
    public static Rational fromDivideString(String divideString) {
        //divide String = "5/8"
        String[] parts = divideString.split("/");
        //parts = ["5","8"]
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);
        return new Rational(numerator,denominator);
    }
    
    public static Rational fromDecimalString(String decimalString) {
        // decimalString = 3.25
        // 3/1 + 25/100
        String[] parts = decimalString.split("\\.");
        // parts = ["3", "25"]
        int whole = Integer.parseInt(parts[0]);
        int fractional = Integer.parseInt(parts[1]);
        Rational left = new Rational(whole, 1);
        Rational right = new Rational(fractional, (int)Math.pow(10, parts[1].length()));
        return left.add(right);
        
    }
    
    public static Rational fromWholeNumberString(String wholeNumber) {
        // wholeNumber = "52";
        int wholeNumberAsInteger = Integer.parseInt(wholeNumber);
        
        return new Rational(wholeNumberAsInteger, 1);
        
    }
    
    
    //Greatest Common Divisor
    public static int gcd(int x, int y) {
        //Brute Force Method(Try every number)
        int answer = 1;
        if(x==0) {
            return y;
        }else if(y==0){
            return x;
        }
        
        for(int i = 1; i<=Math.min(x, y);i++) {
            if(x%i == 0 && y%i == 0) {
                answer = i;
            }
        }
        return answer;
        
    }
    //methods - add, multiply, divide
    public Rational multiply(Rational other) {
        //this times other
        //MAKES RATIONAL OBJECT IMMUTABLE
        return new Rational(this.numerator*other.numerator, this.denominator*other.denominator);
    }
    
    public Rational divide(Rational other) {
        return new Rational(this.numerator*other.denominator,this.denominator*other.numerator);
         
    }
    
    public Rational add(Rational other) {
        int newNumerator;
        int newDenominator;
        newDenominator = this.denominator * other.denominator;
        newNumerator = this.numerator*other.denominator +  other.numerator*this.denominator;
        return new Rational(newNumerator, newDenominator);
           
    }
    
    
    @Override
    public boolean equals(Object other) {
        if(other==null) {
            return false;
        }else if(other.getClass() != this.getClass()) {
            return false;
        }
        //We now know that we have a Rational Object
        Rational otherAsRational = (Rational) other;
        if(this.numerator == otherAsRational.numerator && this.denominator == otherAsRational.denominator) {
            return true;
            
        }
        return false;
        
    }
    
    
    @Override
    public String toString() {
        
        if(denominator == 1) {
            return numerator +"";
        }
        
        return numerator+"/"+denominator;
    }
    
    

    @Override
    public int compareTo(Rational other) {
        //this vs other
        //return -1 if this < other
        //return 0 if this == other
        //return 1 if this > other
        
        int thisNewNumerator = this.numerator * other.denominator;
        int otherNewNumerator = other.numerator * this.denominator;
        
        if(thisNewNumerator < otherNewNumerator) {
            return -1;
        }else if(thisNewNumerator > otherNewNumerator) {
            return 1;
        }
        return 0;
    }

}
