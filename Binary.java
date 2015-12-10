//Jason Dong
//APCS1 pd5
//Homework43 -- This or That
//2015-12-07

/******************************/

//skeleton file for class Binary
public class Binary implements Comparable {

/******************************/

    private int _decNum;
    private String _binNum;

/******************************/

    public Binary() { 
	_decNum = 0;
	_binNum = "0";
    }//End Binary

/******************************/

    public Binary( int n ) {
	if ( n >= 0 ) {
	    _decNum = n;
	    _binNum = decToBin(n);
	}	
	else {
	    System.out.println("Integer must be a non-negative");
	}
    }//End Binary

/******************************/

    public Binary( String s ) {
	_binNum = s;
	_decNum = binToDec(s);
    }//End Binary

/******************************/

    public String toString() { 
	String returnString;
	returnString = "_decNum | " + _binNum;

	return returnString;
    }

/******************************/

    public static String decToBin( int n ) {
	if ( n >= 0 ) {   
	    String baseTwo = "";
	    int baseTen = n;
	    int quotient;
	    int remainder; 
	    while ( baseTen / 2 > 1 ) {
		quotient = baseTen / 2;
		remainder = baseTen % 2;
		baseTwo = remainder + baseTwo;
		baseTen = quotient;
	    }
	    baseTwo = baseTen + baseTwo;
	    return baseTwo;
	}
	else {
	    String error = "Integer must be non-negative";
	    return error;
	}   
    }//End decToBin

/******************************/

    public static String decToBinR( int n ) {   
	String baseTwo = "";
	int baseTen = n;
	int quotient = baseTen / 2;
	int remainder = baseTen % 2;

	if ( baseTen == 1 )
	    return "10";

	else
	    return decToBinR( quotient ) + Integer.toString(remainder);

    }//End decToBinR

/******************************/

    public static int binToDec( String s ) {

	String baseTwo = s;
	int baseTen = 0;
	int length = baseTwo.length();
	int binaryDigit;

	for ( int index = 0 ; index < length ; index++ ) {
	    
	    binaryDigit = Integer.parseInt( baseTwo.substring( index , index + 1 ) );

	    baseTen = baseTen + ( binaryDigit * (int)( Math.pow( 2 , ( length - 1 ) - index ) ) );

	}

	return baseTen;

    }//End binToDec

/******************************/

    public static int binToDecR( String s ) { 
  	String baseTwo = s;
	int baseTen = 0;
	int length = baseTwo.length();
	int binaryDigit;

	if ( length == 0 )
	    return baseTen;

	else {
	    
	    binaryDigit = Integer.parseInt ( baseTwo.substring( 0 , 1 ) );

	    baseTen = baseTen + ( binaryDigit * (int)( Math.pow( 2 , length - 1 ) ) );

	    return baseTen + binToDecR( baseTwo.substring(1) );

	}

    }

/******************************/

    public boolean equals( Object other ) { 
	
	Binary binOther = (Binary)other;
	String otherBin = binOther._binNum;
	int otherDec = binOther._decNum;

	if ( !( other instanceof Binary ) )
	    return false;

	if ( _binNum == otherBin && _decNum == otherDec )
	    return true;
	else
	    return false;
  
    }//End equals

/******************************/

    public int compareTo( Object other ) {
	
	Binary binOther = (Binary)other;
	int otherDec = binOther._decNum;

	if ( _decNum == otherDec )
	    return 0;

	if ( _decNum < otherDec )
	    return -1;

	else       
	    return 1;
	    
    }

/******************************/

    //main method for testing
    public static void main( String[] args ) {


	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(7);


	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );       
	
	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos

    }//end main()

/******************************/

}//end class
