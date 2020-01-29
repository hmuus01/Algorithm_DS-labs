public class NaiveStringMatch extends StringMatch {
    public int match(String text, String pattern) {

    	int m = pattern.length();
    	for (int s=0; s<= text.length() -m;s++)
    	{
    		boolean found = true;
    		for(int j=0;j<m;j++)
    		{
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
