import java.math.*;

//BigInt class
public class BigInt {
    //initialise a first value
    public int startVal;
    //inititalize number of digits
    public int ndigits;
    // public for test purposes
    public char data[];
    //Constructor with integer constructor
    public BigInt(int _ndigits) 
    {   //set number of digits
        this.ndigits = _ndigits;
        //set the data array to the number of digits
        data = new char[_ndigits];
    }
    public BigInt(String s) {
        //set the number of digits to the length of the string
        ndigits = s.length();
        //initialize an array to store the characters of the string s. 
        char arrayC []=s.toCharArray();
        //initalize a for loop, looping through half the size of the array. 
        for(int i = 0; i< arrayC.length/2; i++)
        {
            //initalize a temporary character value to store the first index of the string 
            char interim = arrayC[i];
            //change the character array index to the previous
            arrayC[i] = arrayC[arrayC.length -i -1];
            //assign the previous to the the temporary character value
            arrayC[arrayC.length -i-1]= interim;
        }
        //loop through the number of digits
        for(int j =0; j< ndigits; j++)
        {
            //set the data array to equal the character array which stores the string characters
            data = arrayC;
            //initialize a variable to store the numeric value of the character at index j
            int nVal = Character.getNumericValue(arrayC[j]);
            //type cast the integer at index j to a character
            data[j] = (char)nVal;
        }
        //set the data to the character array
        data = arrayC;
    }
    //Method get
    public char get(int i) 
    {
        //store the length of array
        int length = data.length;
        //if the input argument is not a valid one retur 0
        if(i>=length) return 0;
        //else return the content of the array in that position
        return data[i];
    }
    //Method add
    /* This method receives a big integer y (BigInt data type) as an input argument and returns the sum of that big integer (y) and the num */
    public BigInt Add(BigInt y) {

        int number =1;
        int carry = 0;
        int tempStorageArray[];

        if (y.ndigits > this.ndigits) {
            number = number + y.ndigits;
        }
        else {
            number = number + this.ndigits;
        }

        BigInt storeResult = new BigInt(number);
        tempStorageArray = new int [number];
        for ( int i = 0; i < number; i++) {
            tempStorageArray[i] += this.get(i) + y.get(i) + carry;

            if (tempStorageArray[i] > 9) {
                carry = 1;
                tempStorageArray[i] %= 10;
            }else {
                carry = 0;
            }
            storeResult.data[i] = (char)tempStorageArray[i];
        }

        return storeResult;
    }
    //Method sub
    //This function returns the result of (data[]-y) (where y is the input argument)
    /* 
     This function returns the result of (data[]-y) (where y is the input argument). You might assume that y is always smaller than or equal to data[]. 
     This method has to:
     Create a variable where to store the result
     Perform the subtraction, digit by digit (the i-th digit of y minus the i-th digit of data[] minus any borrow).  
     For example, if you are calculating 3-5 you are going to get -2. Of course, you should not store -2 in result, 
     because it is a negative number and you only store positive digits. 
     So, you store the number 8 (you borrow one ten for 3 so instead of performing 3-5 you perform 13-5) and take the 1 as a borrow for the next single-digit subtraction. 
     Remember that you are operating with char data types, thus, the borrow variable and the 
     variable where you store the digit-by-digit subtraction must be of char data type as well.
     Return the result
*/  
    public BigInt Sub(BigInt y) {
        //variable to store the result
        BigInt storage = new BigInt (data.length);
        //check if the length of the input is less than the length of the array
        if(y.data.length < data.length) 
        {
            //if so create a temp Big Integer the size of the array
            BigInt tempStorage = new BigInt(data.length);
            //loop through the y
            for(int i = 0; i < y.data.length; i++) 
            {
                //add it ti to the temp Big integer
                tempStorage.data[i] = y.data[i];
            }
            //make y and temp storage equal
            y.data = tempStorage.data;
        }
        //initialize a carry
        int carry = 0;
        //borrow
        int borrow =10;
        //loop through the data array
        for (int i = 0; i < data.length; i++)
         {
            //perform the subtraction
            int v = data[i] - y.data[i] - carry;
            //if the the result after the subtraction is less than 0
            if(v < 0) 
            {
                //borrow 10
                v+= borrow;
                //carry is equal to 1
                 carry= 1;
            }
            else
                //else the carry is 0
                carry = 0;

            //type cast the value at the at storage index to a character
            storage.data[i] = Character.valueOf((char) v);
        }
        //return storage
        return storage;
    }
    //Method shift
    /*     
        Implement Shift(), which returns a new big integer with the digits of the given Big Integer shifted bythe specified number of places, 
        effectively multiplying the original number by a power of 10. Run the tests to check your implementation
    
    */
    public BigInt Shift(int n) 
    {
        BigInt storeShift = new BigInt(this.data.length + n);
        performShift(storeShift,n);
        return storeShift;
    }

    public BigInt performShift(BigInt shift, int n)
    {
        for(int i =0; i< this.data.length; i++)
        {
            shift.data[i+n] = data[i];
        }
        return shift;
    }
    //Method MulByDigit
    /*  
    This method returns the multiplication of the number stored in datat[] and the single-digit entered as input argument (c).
    To implement this method you must:
    Create a big integer where to store the result 
    Perform the digit-by-digit multiplication (remember to include the carry bit)
    Return the result
    */
    public BigInt MulByDigit(char c) {
        BigInt multi = new BigInt(data.length + 1);

        int n = 0;

        calcMulByDigit(multi,c,n);
        return multi;
    }
    public BigInt calcMulByDigit(BigInt mul, char c,int n)
    {
        for(int i = 0; i< data.length;i++)
        {
            int t = data[i] * c + n;
            mul.data[i] = (char)(t % 10);
            n = t/10;
        }
        mul.data[mul.data.length-1] = (char) n;
            return mul;
    }
    //Method Multiply
    /* 
    This method returns the result of multiplying the number stored in data[] with the number entered as an input (y).
    To implement this method you must:
    Create a big integer where to store the result 
    Use the shift, multiply-by-digit and addition operations to find the result 
    Return the result

    */
    public BigInt Mul(BigInt y) 
    {
         BigInt n = new BigInt(1);

        String storeY = new String(y.data);
        String reverse_one1 = new StringBuilder(storeY).reverse().toString();
        int reverseL = reverse_one1.length();

        char [] temporary = new char[reverseL];
        for (int i = 0; i < reverseL; i++) 
        {
            temporary[i] = (char)(reverse_one1.charAt(i) + '0');
        }
        String a= new String(temporary);
        BigInteger c = new BigInteger(a);

        while (c.compareTo(BigInteger.ZERO) > 0) 
        {
            n = n.Add(this);
            c = c.subtract(BigInteger.ONE);
        }

        return n;
    }
    //Method Div
    public BigInt Div(BigInt d) {
        
    return this;
    }
    //Method Rem
    public BigInt Rem(BigInt d) 
    {

    return this;
    }
}
