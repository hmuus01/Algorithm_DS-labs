public class KMPStringMatch extends StringMatch {
    public int match(String text, String pattern) {

    	

    	int n = text.length();
    	int m = pattern.length();

    	if (m ==0)
    	{
    		return 0;
    	}

    	if(n ==0)
    	{
    		return -1;
    	}



    	int [] pI = computePrefix(pattern);

    	int q = 0;

    	for(int i=0; i<n; i++)
    	{
    		while (q>0 && pattern.charAt(q) != text.charAt(i))
    		{
    			q = pI[q-1];
    		}

    		if(pattern.charAt(q) == text.charAt(i))
    		{
    			q = q+1;
    		}
    		if(q==m)
    		{
    			return i - m + 1;
    		}

    	}


        return -1;
    }

    public int []computePrefix(String pattern)
    {
    	int m= pattern.length();
    	int [] pI = new int [m];
    	pI[0]=0;
    	int k = 0;

    	for(int q = 1; q<m; q++)
    	{
    		while(k > 0 && pattern.charAt(k) != pattern.charAt(q))
    		{
    			k = pI[k-1];
    		}
    		if(pattern.charAt(k)== pattern.charAt(q))
    		{
    			k = k+1;
    		}
    		pI[q] = k;

    	}
    	return pI;

    }
}

