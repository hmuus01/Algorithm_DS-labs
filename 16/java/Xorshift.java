public class Xorshift {
	long a,b,c, seed;
	long max = 4294967296L;
    public Xorshift(long _a, long _b, long _c, long seed) { 
    	this.a=_a;
    	this.b=_b;
    	this.c=_c;
    	this.seed = seed;

    }
    public long next() {
    	
    	getLeftShift();
    	getRightShift();
    	
    	seed ^= (seed<< c) %max;

        return seed;
    }
    public long getLeftShift()
    {
    	return seed ^= (seed<< a) %max;
    }
    public long getRightShift()
    {
    	return seed ^= (seed>>b) %max;
    }
    public void seed(long seed) { 
    	this.seed = seed;
    }
}
