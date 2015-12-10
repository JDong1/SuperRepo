//Janet Zhang & Jason dong
//APCS1 pd5
//Class Rational
//2015-12-10

//==============================\\
//Class: Rational
//Interface: Comparable
//==============================\\

public class Rational implements Comparable {

//==============================\\
//Attributes
//==============================\\

    private int numerator;
    private int denominator;

//==============================\\
//Constructors
//==============================\\

    public Rational () {
	numerator = 0;
	denominator = 1;
    }//End Rational

    public Rational ( int numerator , int denominator ) {
	if ( denominator == 0) {
	    numerator = 0;
	    denominator = 1;
	}
	this.numerator = numerator;
	this.denominator = denominator;
    }//End Rational

//==============================\\
//Methods
//==============================\\

    public String toString () {
	String message;
	message = numerator + "/" + denominator;
	return message;
    }//End toString

    public double floatValue ( int numerator , int denominator ) {
	double doubleNumerator;
	double doubleDenominator;   
	doubleNumerator = (double)numerator;
	doubleDenominator = (double)denominator;
	double quotient;
	quotient = doubleNumerator / doubleDenominator;
	return quotient;
    }//End floatValue

    public void multiply ( Rational other ) {
	String otherString = other.toString();
	int otherSign = otherString.indexOf("/");
	int otherLength = otherString.length();
	int otherNumerator = Integer.parseInt( otherString.substring( 0 , otherSign ) );
	int otherDenominator = Integer.parseInt( otherString.substring( otherSign + 1 , otherLength ) );
	numerator = numerator * otherNumerator;
	denominator = denominator * otherDenominator;
    }//End multiply

    public void divide ( Rational other ) {
	String otherString = other.toString();
	int otherSign = otherString.indexOf("/");
	int otherLength = otherString.length();
	int otherNumerator = Integer.parseInt( otherString.substring( 0 , otherSign ) );
	int otherDenominator = Integer.parseInt( otherString.substring( otherSign + 1 , otherLength ) );
	numerator = numerator / otherNumerator;
	denominator = denominator / otherDenominator;
    }//End divide

    public static int max ( int integer1 , int integer2 ) {
	if ( integer1 > integer2 )
	    return integer1;
	else
	    return integer2;
    }//end max

    public void add (Rational other ) {
	String otherString = other.toString();
	int otherSign = otherString.indexOf("/");
	int otherLength = otherString.length();
	int otherNumerator = Integer.parseInt( otherString.substring( 0 , otherSign ) );
	int otherDenominator = Integer.parseInt( otherString.substring( otherSign + 1 , otherLength ) );
	otherNumerator = otherNumerator * denominator;
	numerator = (numerator * otherDenominator) + otherNumerator; 
	denominator = denominator * otherDenominator;
    }//End add

    public void subtract(Rational other){
	String otherString = other.toString();
	int otherSign = otherString.indexOf("/");
	int otherLength = otherString.length();
	int otherNumerator = Integer.parseInt( otherString.substring( 0 , otherSign ) );
	int otherDenominator = Integer.parseInt( otherString.substring( otherSign + 1 , otherLength ) );
	otherNumerator = otherNumerator * denominator;
	numerator = (numerator * otherDenominator) - otherNumerator; 
	denominator = denominator * otherDenominator;
    }//End subtract

    public int gcd () {
	if ( numerator == denominator || numerator == 0 || denominator == 0)
	    return max( numerator , denominator );
	return gcd( numerator % denominator , denominator % numerator);
    }//End gcd

    public void reduce () {
        int GCDenominator;
	GCDenominator = gcd();
	numerator = numerator / GCDenominator;
	denominator = denominator / GCDenominator;
    }//End reduce
    
    public static double maxN ( double double1 , double double2) {
	if ( double1 > double2)
	    return double1;
	else
	    return double2;
    }//End maxN

    public static int gcd ( int integer1 , int integer2 ){
	if ( integer1 == integer2 || integer1 == 0 || integer2 == 0 )
	    return max( integer1 , integer2 );
	return gcd( integer1 % integer2 , integer2 % integer1 );
    }//End gcd

    public int compareTo(Object other){
	String otherString = other.toString();
	int otherSign = otherString.indexOf("/");
	int otherLength = otherString.length();
	int otherNumerator = Integer.parseInt( otherString.substring( 0 , otherSign ) );
	int otherDenominator = Integer.parseInt( otherString.substring( otherSign + 1 , otherLength ) );
	double floatOther = floatValue( otherNumerator , otherDenominator );
        double floatThis = floatValue( numerator , denominator );
	if ( floatOther == floatThis ) 
	    return 0;
	else if ( floatOther == maxN( floatOther , floatThis ) ) 
	    return 1;
	else 
	    return -1;
    }//End compareTo
    
    //equals helper to check equivalence of Rational objects
    public boolean equalsHelper ( Rational other ) {
	String otherString = other.toString();
	int otherSign = otherString.indexOf("/");
	int otherLength = otherString.length();
	int otherNumerator = Integer.parseInt( otherString.substring( 0 , otherSign ) );
	int otherDenominator = Integer.parseInt( otherString.substring( otherSign + 1 , otherLength ) );
      	return ( floatValue( numerator , denominator ) == floatValue( this.numerator , this.denominator ) );
    }//End equalsHelper

    //overwritten equals method to check equivalence
    public boolean equals(Object o){
      	if ( !( o instanceof Rational) )
	    return false;
      	return equalsHelper((Rational)o);
    }//End equals

//==============================\\
//Main
//==============================\\
   	
    public static void main(String[] args) {
	Rational goose = new Rational(2,0); //Stores the rational number 0/1 bc invalid params
	Rational t = new Rational(4,18); //Stores the rational number 4/18
	Rational r = new Rational(2,3); //Stores the rational number 2/3
	Rational s = new Rational(1,2); //Stores the rational number 1/2
	System.out.println("r: "+r);
	System.out.println("s: "+s);
	System.out.println("t: "+t);
	//Part1
	System.out.println("\nMultiplying r by s...");
	r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains ½
	System.out.println("r now equals: "+ r);
	System.out.println("s now equals: "+ s);
	System.out.println("\nDividing r by s...");
	r.divide(s); //Multiplies r by s, changes r to 2/6.  s remains ½
	//Part2
	System.out.println("r now equals: "+ r);
	System.out.println("s now equals: "+ s);
	System.out.println("\nAdding s to r...");
	r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
	System.out.println("r now equals: "+ r);
	System.out.println("s now equals: "+ s);
	System.out.println("\nSubtracting s from r...");
	r.subtract(s);
	System.out.println("r now equals: "+ r);
	System.out.println("s now equals: "+ s);
	t.reduce(); //Changes t to 2/9
	System.out.println("t now equals: "+ t);
		
	//Part3
	System.out.println("\nComparing t to s...");
	System.out.println("if t is greater than s: return 1 \nif t is less than s: return -1 \nif t is equal to s: return 0");
	System.out.println(t.compareTo(s));
		
	//Part4
	System.out.println("\nis t .equals to s?");
	System.out.println(t.equals(s));//false
	System.out.println("\nis t .equals to t?");
	System.out.println(t.equals(t));//true
	System.out.println("\nis t .equals to 4/18?");
	System.out.println(t.equals(4/18));//false
	System.out.println("\nis t .equals to 2/9?");
	System.out.println(t.equals(2/9));//false
    }//End Main

//==============================\\
}//End Rational
//==============================\\




