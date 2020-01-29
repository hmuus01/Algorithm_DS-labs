class DynamicArray {

    private int num_items;

    private int[] v_storage;

    public OpCounter counter = new OpCounter();
    
    public DynamicArray(int size) {
        num_items = 0;
        v_storage =  new int[size];

    }
    public int length() {
        return num_items;
    }
    public int select(int k) {
        return v_storage[k];
    }
    public void store(int o, int k) {
        v_storage[k]= o;
    }
    public void push(int o) {
        if (num_items == v_storage.length)
        {
            extend();
        }
        v_storage[num_items] = o;
        num_items++;
         counter.add(1);
    }
    public int pop() {
        num_items --;
        return v_storage[num_items];
    }
    private void extend()
    {
        int newLength = v_storage.length * v_storage.length ;
        int[] newVector = new int[newLength];
        for (int i = 0; i < v_storage.length; i++)
        {
            newVector[i] = v_storage[i];
            counter.add(1);
        }
        v_storage = newVector;

    }
    public int wastedSpace(){
        return v_storage.length - num_items;
    }
}
