import java.math.*;

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
        // ndigits = s.length();
        // //initialize an array to store the characters of the string s. 
        // char arrayC []=s.toCharArray();
        // //initalize a for loop, looping through half the size of the array. 
        // for(int i = 0; i< arrayC.length/2; i++)
        // {
        //     //initalize a temporary character value to store the first index of the string 
        //     char interim = arrayC[i];
        //     //change the character array index to the previous
        //     arrayC[i] = arrayC[arrayC.length -i -1];
        //     //assign the previous to the the temporary character value
        //     arrayC[arrayC.length -i-1]= interim;
        // }
        // //loop through the number of digits
        // for(int j =0; j< ndigits; j++)
        // {
        //     //set the data array to equal the character array which stores the string characters
        //     data = arrayC;
        //     //initialize a variable to store the numeric value of the character at index j
        //     int nVal = Character.getNumericValue(arrayC[j]);
        //     //type cast the integer at index j to a character
        //     data[j] = (char)nVal;
        // }
        // //set the data to the character array
        // data = arrayC;
        data = new char[s.length()];
        ndigits = s.length();
        int length;
        length = s.length()-1;
        int h = 0;
        while (h < ndigits) 
        {
            data[h] =(char) (s.charAt(length) - '0');
            h++;
            length--;
        }
        // this(s.length());
        
        // for(int h=this.ndigits -1; h>-1;h--)
        // {
        //     //int c = this.ndigits -1;
        //     data[this.ndigits-1-h] = (char)(s.charAt(h)-'0');
        // }
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
        // int z = 0;
        // boolean check = (i<0 ||i>this.ndigits -1);
        // if(check)
        // {
        //     return (char) z;
        // }
        // return this.data[i];
    }
    //Method add
    /* This method receives a big integer y (BigInt data type) as an input argument and returns the sum of that big integer (y) and the num */
    public BigInt Add(BigInt y) {

        int storeMAxResult = 0;
        int constant = 1;

        if(y.ndigits >= this.ndigits)
        {
            storeMAxResult = y.ndigits + constant; 
        }
        else{
            storeMAxResult = this.ndigits + constant;
        }

        BigInt storeResult = new BigInt(storeMAxResult);

        char carryVal;

        carryVal = ('0'-'0');

        char unitColumn;

        int j;

        for(j = 0; j< storeMAxResult; j++)
        {
            char doSum; 
            doSum = (char) (y.get(j) + this.get(j) + carryVal);
            if(doSum >  (char)((char)57-48))
            {
                carryVal = ('1'-'0');
                unitColumn = (char) (doSum - (58-(char) 48));
                storeResult.data[j] = unitColumn;
            }
            else{
                carryVal = (char) (48-48);
                storeResult.data[j] = doSum;
            }

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

        BigInt storeRes = new BigInt(this.ndigits);
        char doSum;
        char unitColumn;
        for(int j =0; j<this.ndigits; j++)
        {
            boolean check = (char) (this.get(j) - y.get(j) + (char) (58 - 48)) < (char)(58-48);
            if(check)
            {
                doSum = (char) (this.get(j)-y.get(j) + (':'-'0'));
                storeRes.data[j]= doSum;
                this.data[j+1]-=('1'-'0');
            }
            else{
                doSum = (char)(this.get(j) - y.get(j));
                storeRes.data[j] = doSum;
            }
        }
        return storeRes;
    }
    //Method shift
    /*     
        Implement Shift(), which returns a new big integer with the digits of the given Big Integer shifted bythe specified number of places, 
        effectively multiplying the original number by a power of 10. Run the tests to check your implementation
    
    */
    public BigInt Shift(int n) 
    {
        BigInt storeRes = new BigInt(this.ndigits + n);
        int h;
        for(h = 0;h<storeRes.ndigits; h++)
        {
            storeRes.data[h] = (char) (48-48);
        }
        int j;
        for(j = 0;j<this.ndigits;j++)
        {
            storeRes.data[j+n] = this.data[j];
        }
        return storeRes;
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

        BigInt mulbyNum = new BigInt((char)48);
        int h;
        for(h = 0; h<this.ndigits; h++)
        {
            BigInt storeSum = new BigInt(2);
            char unitColumn;
            char storeUnitCol = (char)(this.get(h)*c%10); 
            unitColumn = storeUnitCol;
            char storeTensColumn = (char)(this.get(h)*c/10);
            char tenthColumn = storeTensColumn;
            storeSum.data[0] = unitColumn;
            storeSum.data[1] = tenthColumn;
            storeSum = storeSum.Shift(h);
            mulbyNum = mulbyNum.Add(storeSum);
        }

        return mulbyNum;
    }

    // public BigInt calcMulByDigit(BigInt mul, char c,int n)
    // {
    //     for(int i = 0; i< data.length;i++)
    //     {
    //         int t = data[i] * c + n;
    //         mul.data[i] = (char)(t % 10);
    //         n = t/10;
    //     }
    //     mul.data[mul.data.length-1] = (char) n;
    //         return mul;
    // }
    
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
        BigInt multiplyNum = new BigInt((char) 48);
        for(int h=0; h<y.ndigits; h++)
        {
            BigInt storeSum = this.MulByDigit(y.get(h));
            storeSum = storeSum.Shift(h);
            multiplyNum = multiplyNum.Add(storeSum);
        }
        BigInt mul = fix(multiplyNum);
        return mul;
    }

    public BigInt fix(BigInt a)
    {
        int storeCount;
        storeCount = 0;
        for(int h = a.ndigits -1; h>-1; h--)
        {
            boolean check = a.get(h) !=(char) (48 - '0');
            if(check)
            {
                break;
            }
            storeCount++;
        }
        BigInt finish = new BigInt(a.ndigits - storeCount);

        for(int j = 0;j<finish.ndigits;j++)
        {
            finish.data[j] = a.data[j];
        }
        return finish;
    }

    //     public char[] tempStr(BigInt y)
    // {
    //     char forty8 = '0';

    //     String storeY = new String(y.data);
    //     String reverse_one1 = new StringBuilder(storeY).reverse().toString();

    //     int reverseL = reverse_one1.length();

    //     char [] temporary = new char[reverseL];
    //     for (int i = 0; i < reverseL; i++) 
    //     {
    //         temporary[i] = (char)(reverse_one1.charAt(i) + forty8);
    //     }
    //     return temporary;
    // }
   
    //Method Div
    public BigInt Div(BigInt d) {

    return this;
    }
    //Method Rem
    public BigInt Rem(BigInt d) 
    {   
        return this;
    }
//private static Map<Integer, BigInteger> memo = new HashMap<>();

// public static BigInteger fibonacci3(int n) {
//     if (n == 0) return BigInteger.ZERO;
//     if(n == 1) return BigInteger.ONE;
//     if (memo.containsKey(n)) {
//         return memo.get(n);
//     }
//      BigInteger v = fibonacci3(n - 2).add(fibonacci3(n - 1));
//     // memo.put(n, v);
//     // return v;
//     return fibonacci3(n - 2).add(fibonacci3(n - 1));
//}
// public static void main(String [] args)
// {
//     System.out.print(fibonacci3(11342));
// }
    public static void main(String [] args)
    {
        BigInt test = new BigInt("41000");
        BigInt test1 = new BigInt("55");

        test = test.Div(test1);


    }
}
