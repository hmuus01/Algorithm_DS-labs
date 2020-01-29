public class BinarySearch {

	int opcounter= 0;

    public boolean search(int array[], int key, int lo, int hi) {


    	int mid = ((lo +hi) -1)/2;

    	if(lo == hi)
    	{
    		return false;
    	}
    	else if(array[mid] == key)
    	{
    		opcounter++;
    		return true;
    	}
    	else if(key < array[mid])
    	{
    		opcounter++;
    		return search(array,key,lo,mid);
    	}
    	else{
    		opcounter++;
    		return search(array,key,mid+1,hi);
    	}
    }

    public int count(int array[], int key, int lo, int hi)
    {
    	opcounter = 0;

    	search(array,key,lo,hi);

    	return opcounter;

    	//int mid = ((lo +hi) -1)/2;


    }

    public static void main(String [] args)
    {
    	//System.out.println(count([3,3,5,4,6,6,4,2],59396,0,33546642));

    	int [] arrayTest = new int[33546642];
    	for(int i = 0; i< arrayTest.length; i++)
    	{
    		arrayTest[i] = i;
    	}

    	BinarySearch testSearch = new BinarySearch();

    	int test = testSearch.count(arrayTest,59396,0,33546642);
    	System.out.println(test);


    }

}
