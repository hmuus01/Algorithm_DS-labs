public class LCG {
	long a1,c1,m1,seed;
    public LCG(long _a, long _c, long _m, long seed) { 
    	this.a1 = _a;
    	this.c1= _c;
    	this.m1= _m;
    	this.seed = seed;
    }
    public long next() {
    	long next = (a1*seed +c1) % m1;
    	seed = next;
        return next;
    }
    public void seed(long seed) { 
    	this.seed = seed;
    }
}
