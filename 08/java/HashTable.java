import java.util.*;
public class HashTable {
    // public for testing purposes
    public int buckets[];

    /*
    Instance variables
    */
    private long a;
    private long c;
    private long m;
    /*
    Instance variables
    */


    public HashTable(long _a, long _c, long _m) {
        this.a =_a;
        this.c =_c;
        this.m =_m;
        buckets = new int [(int)this.m];
        for(int i=0; i<m; i++){
        	buckets[i] = 0;
        }
        //Question 3 Optional
        // long hx =   (33546642L * 11342L + 11630L ) % 59396L;
        // .out.println("Answer is: " + hx);

         long hx =   (33551570L * 11342L + 11630L ) % 60954L;
        System.out.println("Answer is: " + hx);
    }
    public int hash(int key){
    	int num =  (int)((this.a*key + this.c) % this.m);
    	return num;
    }
    public void insert(int key) {
        int index = hash(key);
        //System.out.println("index: " + index);
        int k = 0;
        int j = (int)(probe(index, k, (int)m));
        //System.out.println("j: " + j);
        while(buckets[j] !=0)
        {
            k++;
        	j= probe(index,k,(int)m);
            if(k>m)
            {
                extendingAndRehashing(key);
                return;
            }
        	
        }
        //System.out.println("j: " + j);
        buckets[j] =  key;

        // if(j-index > 2){
        // 	extendingAndRehashing();
        // }

    }

    public void remove(int key)
    {
    	int index = hash(key);
    	int k = 0;
    	int j = probe(index,k,(int)m);
    	while(buckets[j] != key && j < m)
    	{
    		j = probe(index,k,(int)m);
    		k++;
    	}
    	if (j != m)
    		buckets[j]= 0;
    }
    public boolean find(int key) {

    	int index = hash(key);
    	int k=0;
    	int j = probe(index,k,(int)m);
    	while (k<m){

    		if (j<0) 
    		{
    			k++;
    			j = probe(index,k,(int)m);
    			continue;

    		}
    		if(buckets[j] == key)
    		{
    			return true;
    		}
    		k++;
    		j = probe(index,k,(int)m);
    	}

        return false;
    }

    void extendingAndRehashing(int key){
    	int[] oldBuckets = new int[(int)m];
    	oldBuckets = buckets;
    	buckets = new int[(int)m*(int)m];
    	m = m*m;
    	
    	for (int element:oldBuckets){
    		if (element !=0){
    			insert(element);
    		}
            insert(key);
    	}
    }
    

    // hx =   (33546642 * 11342 + 11630 ) % 59396
    public double loadFactor() {
    	int counter = 0;

    	for(int i = 0; i<buckets.length; i++)
    	{
    		if(buckets[i] !=0)
    		{
    			counter++;
    		}
    	}
        return (double) counter/(double)m;
    }
    //LinearProbing
    // public int probe(int i, int k, int h){

    //      return (i+k) % h;
    // }
    public int probe(int i, int k, int h){
    	long lk = (long)k;
    	long lh = (long)h;
		long li = (long)i;

         return (int)((li  + (lk*lk)) % lh);
    }

  
    
}
