class SLList {
    private Object fst;
    private SLList rst;
	
    public SLList(Object f, SLList r) { fst = f; rst = r; }
    public static final SLList NIL = new SLList(0, null);

    public Object first() {
        return fst;
    }
    public SLList rest() {
        return rst;
    }
    public void setFirst(Object f) {
	fst = f;
    }
    public void setRest(SLList r) {
	rst = r;
    }

    public Object nth(int i) {
	if (i == 0) {
	    return first();
	} else {
	    return rest().nth(i-1);
	}
    }
    public SLList nthRest(int i) {
	if (i == 0) {
	    return this;
	} else {
	    return rest().nthRest(i-1);
	}
    }
    // no such thing as `unsigned' in Java
    public int length() {
	if (this == SLList.NIL) {
	    return 0;
	} else {
	    return 1 + rest().length();
	}
    }

    public SLList remove(Object o) {
        if (this == SLList.NIL)
	    return NIL;
	else if (o == first())
	    return rest().remove(o);
	else
	    return new SLList(first(), rest().remove(o));
    }
    public SLList reverse() {
        return reverseAux(SLList.NIL);
    }
    private SLList reverseAux(SLList sofar) {
	if (this == SLList.NIL)
	    return sofar;
	else
	    return rest().reverseAux(new SLList(first(), sofar));
    }
    public Integer sum() {
	if (this == SLList.NIL)
	    return 0;
	else
	    return (Integer) first() + rest().sum();
    }

    public SLList sublist(int start, int end) {
     if (start == end)
     {
        return NIL;
     }
     else
     {
        return new SLList(nth(start), sublist(start +1,end));
     }
    }
    public SLList merge(SLList b) {
        if (this == NIL)
    {
        return b;
    }
        else if (b == NIL)
    {
        return this;
    }
        else if ((Integer) this.fst <= (Integer)b.fst)
    {
        return new SLList (this.fst, b.merge(this.rst));
    }
        else 
    {
        return new SLList(b.fst, this.merge(b.rst));
    }
    }
    public SLList mergesort() {
        return NIL;
    }
}
