class SLList {
    Object first;
    SLList rest;
    public SLList(Object f, SLList r) {
        first = f;
        rest =r;

     }
    public static final SLList NIL = new SLList(0, null);

    public Object first() {
        return first;
    }
    public SLList rest() {
        return rest;
    }
    public void setFirst(Object f) {
        first = f;
    }
    public void setRest(SLList r) {
        rest = r;
    }

    public Object nth(int i) {
        if (i == 0)
        {
            return first;
        }
        else if (rest == NIL)
        {
            return null;

        }
        else {
            return rest.nth(i-1);
        }
    }
    public SLList nthRest(int i) {
        if (i == 0)
        {
            return this;
        }
        else
        {
            return rest.nthRest(i-1);
        }
    }
    // no such thing as `unsigned' in Java
    public int length() {
        if (this == NIL)
        {
            return 0;
        }
        else 
        {
            return 1+rest.length();
        }

    }

    public SLList remove(Object o) {
        if (NIL == this)
        {
            return NIL;
        }
        else if(o == first)
        {
            return rest().remove(o);
        }
        else
        {
            return new SLList(first, rest().remove(o));
        }

    }
    public SLList reverse() {
        if (NIL ==this)
        {
            return NIL;
        }
        else
        {
            SLList n = rest().reverse();
            if (n ==  NIL)
            {
                return new SLList (first, NIL);
            }
            n.lastRest().rest = new SLList (first, NIL);
            return n;

        }
    }

    public Integer sum()
    {
        if (NIL == this)
        {
            return 0;
        }
        else 
        {
            int i = (int) first;
            return i + rest().sum();
        }
    }
    public SLList lastRest()
    {
        if (rest() == NIL)
        {
            return this;
        }
        else 
        {
            return rest().lastRest();
        }
    }

   //check to see if the start if the SLList is  equal to the end of the list 
    public SLList sublist(int start, int end) 
    {
        if (start == end)
     {
        //if the list is empty, return NIL
        return NIL;
     }
        else
     {
        //else return a new Sllist with the nth being the start of the sllist and the sublist start+1 to the end)
        return new SLList(nth(start), sublist(start +1,end));
     }


    }
    public SLList merge(SLList b) 
    {       
        //if the object is empty return the sllist b
            if (this == NIL)
        {
            return b;
        }
        //else if the sllist b is empty return the object
            else if (b == NIL)
        {
            return this;
        }
        //check to see if the first element of the object is less or equal to the first element of the sllist b
            else if ((Integer) this.first <= (Integer)b.first)
        {
        //if so return a new sllist with the first element of the of object merged with the rest of sllist b
             return new SLList (this.first, b.merge(this.rest));
        }
        //if the other condition is not true return a new sllist with the first element of b merged with the rest of rest of the object
             else 
        {
            return new SLList(b.first, this.merge(b.rest));
        }

    }

    public SLList mergesort() 
    {

    //initalize the sublist of type int which contains the length of the object
        int sll = this.length();
    //if the length of the sublist is less or equal to 1 return the object
            if (sll <= 1)
        {
            return this;
        }
            else
        {
    //else initialze middle which containts the length of the sublist divided by 2
        int middle = sll/2;

    //intitalize an sllist L (left) which contains the object from index 0 to the middle
        SLList l = this.sublist(0,middle).mergesort();

    //initialze an sslist R (right) which contains the object starting from the middle to the end
        SLList r = this.sublist(middle,sll).mergesort();

    // Merge the two sllists
        return l.merge(r);
    }
    }
    
}
