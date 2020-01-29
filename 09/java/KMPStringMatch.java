public class KMPStringMatch extends StringMatch {
	//OpCounter counter = new OpCounter();

    public int match(String text, String pattern) {

    	

    	int n = text.length();
    	int m = pattern.length();

    	if (m ==0)
    	{
    		//counter.add(1);
    		//counter.report();
    		return 0;
    	}

    	if(n ==0)
    	{
    		//counter.add(2);
    		//counter.report();
    		return -1;
    	}

    	//Student ID
    	//33546642

    	//Moodle id
    	//59396



    	int [] pI = computePrefix(pattern);

    	int q = 0;

    	for(int i=0; i<n; i++)
    	{
    		//if(q>0)
    		//counter.add(2);
    		while (q>0 && pattern.charAt(q) != text.charAt(i))
    		{
    			
    			q = pI[q-1];
    			//counter.add(2);
    		}

    		 //counter.add(2);
    		if(pattern.charAt(q) == text.charAt(i))
    		{
    			q = q+1;

    		}
    		//counter.add(1);
    		if(q==m)
    		{
    			//counter.report();
    			return i - m + 1;
    		}

    	}

    	//counter.report();
        return -1;
    }

    public int []computePrefix(String pattern)
    {
    	int m= pattern.length();
    	int [] pI = new int [m];
    	pI[0]=0;
    	int k = 0;

    	
    		//counter.add(2);
    	for(int q = 1; q<m; q++)
    	{
    		// if(k>0)
    		// 	counter.add(2);
    		while(k > 0 && pattern.charAt(k) != pattern.charAt(q))
    		{
    			counter.add(2);
                k = pI[k-1];
    			
    		}
            if(k>0)
                counter.add(2);
    		counter.add(2);
    		if(pattern.charAt(k)== pattern.charAt(q))
    		{
    			k = k+1;

    		}
    		pI[q] = k;

    	}
    	return pI;

    }
}

