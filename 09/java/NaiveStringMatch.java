public class NaiveStringMatch extends StringMatch {
	//OpCounter counter = new OpCounter();
    public int match(String text, String pattern) {



    	int m = pattern.length();

    	if(m ==0)
    	{
    		return 0;
    	}
    	else if(text == "")
    	{
    		return -1;
    	}
    	for (int s=0; s<= text.length() -m;s++)
    	{
    		boolean found = true;
    		for(int j=0;j<m;j++)
    		{
    			counter.add(2);
    			if(text.charAt(s+j) != pattern.charAt(j))
    			{
    				found = false;
    				break;
    			}
    		}
    		if(found)
    		{
    			return s;
    		}
    	}

        return -1;
    }
}
