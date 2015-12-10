//Jason Dong
//APCS1 pd5
//Homework44 --This or That or Fourteen Other Things
//2015-12-08

public class Hexadecimal implements Comparable {

    private String _hexDecNum;
    private int _decNum;
    private final static String HEXDIGITS = "0123456789ABCDEF";

    public Hexadecimal () {
	_hexDecNum = "0";
	_decNum = 0;
    }//End Hexadecimal

    public Hexadecimal ( int n ) {
	_decNum = n;
	_hexDecNum = decToHexDec(n);
    }//End Hexadecimal

    public Hexadecimal ( String s ) {
	_hexDecNum = s;
	_decNum  = hexDecToDec(s);
    }//End Hexadecimal

    public String toString() { 
	String returnString;
	returnString = "_decNum | " + _hexDecNum;
	return returnString;
    }//End toString

    public static String decToHexDec( int n ) {
	String base16 = "";
	int base10 = n;
	int quotient = base10 / 16;
	int remainder = base10 % 16;
	while ( base10 > 0 ) {
	    base16 = HEXDIGITS.substring(remainder,remainder+1) + base16;
	    base10 = quotient;
	    quotient = base10 / 16;
	    remainder = base10 % 16;
	}
	return base16;
    }//End decToBin

    public static int hexDecToDec ( String s ) {
	String base16 = s;
	int base10 = 0;
	int length = base16.length();
	int hexadecimalDigit;
	for ( int index = 0 ; index < length ; index++ ) {
	    hexadecimalDigit = Integer.parseInt( base16.substring( index , index + 1 ) );
	    base10 = base10 + ( hexadecimalDigit * (int)( Math.pow( 16 , ( length - 1 ) - index ) ) );
	}
	return base10;
    }//End binToDec

    public boolean equals( Object other ) { 	
	Hexadecimal hexDecOther = (Hexadecimal)other;
	String otherHexDec = hexDecOther._hexDecNum;
	int otherDec = hexDecOther._decNum;
	
	if ( ! ( other instanceof Hexadecimal ) )
	    return false;

	if ( _hexDecNum == otherHexDec && _decNum == otherDec )
	    return true;
	else
	    return false;
    }//End equals

    public int compareTo( Object other ) {
	Hexadecimal hexDecOther = (Hexadecimal)other;
	int otherDec = hexDecOther._decNum;
	if ( _decNum == otherDec )
	    return 0;
	if ( _decNum < otherDec )
	    return -1;
	else       
	    return 1;	    
    }//End compareTo

    public static void main ( String[] args ) {
	
	Hexadecimal a = new Hexadecimal();
	Hexadecimal b = new Hexadecimal(1998);
	Hexadecimal c = new Hexadecimal("199A");

	System.out.println("a");
	System.out.println("b");
	System.out.println("c");

    }

}//End Hexadecimal
