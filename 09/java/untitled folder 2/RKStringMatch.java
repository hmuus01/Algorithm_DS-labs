public class RKStringMatch extends StringMatch {
    int opcounter =0;
    public int match(String text, String pattern) {

        //int strLength = text.length();


    	int m= pattern.length();
    	int hm = Hash(pattern);
    	for(int s=0;s<= text.length()-m;s++)
    	{
    		if(Hash(text.substring(s,s+m)) == hm)
    		{
    			boolean found = true;
    			for(int j=0;j<m; j++)
    			{
    				if(text.charAt(s+j)!=pattern.charAt(j))
    				{
    					found = false;
    					break;
    				}
                    opcounter++;
    			}
    			if(found)
    			{
                    System.out.println("F_Counter =" +opcounter);
    				return s;
    			}
    		}
    	}
        System.out.println("N_Counter =" +opcounter);
        return -1;
    }


    public int Hash(String s){
        int h=0;
        int length=94386;
        int a=345;
        for(int i=0;i<s.length();i++){
            h=((a*h)%length+s.charAt(i))%length;
            opcounter++;

        }
        return h; 
    }



    // public int rollingHash()
    // {


    // }
}
