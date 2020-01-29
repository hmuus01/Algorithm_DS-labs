class OpCounter {
    private int count = 0;
    public void add(int n) {
	count += n;
    }
    public int report() {
    	System.out.println("counter: " + counter);
	return count;
    }
}
