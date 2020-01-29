import java.util.ArrayList;
import java.util.List;

class Heap {
    // public for JUnit testing purposes
    public ArrayList<Integer> array;
    public int heap_size;
    public static int counter;

    public Heap(int size) {

       this.heap_size = size;
       this.array = new ArrayList<Integer>(size);
    }
    public Heap(List<Integer> source) {
        this(source, false);
    }
    public Heap(List<Integer> source, boolean incremental) {
       
        if(incremental)
        {

            array = new ArrayList<Integer>();
            for(int i = 0; i< source.size(); i++)
            {
                insert(source.get(i));
            }    
        }
        else{
            array = new ArrayList<Integer>(source);
            buildMaxHeap();
        }

    }

    public static int parent(int index) {
        //int parent_floor = ((index) -1);
        int parent_floor = (index -1)/2;
        return parent_floor;
    }
    public static int left(int index) {
        //int left_child = (index) +1;
        int left_child = (2*index) +1;

        return left_child;
    }
    public static int right(int index) {
        //int right_child = (index)+2;
        int right_child = (2*index) +2;
        return right_child;
    }
    
    public void maxHeapify(int i) {
       
        int left = left(i);
        int right = right(i);

        int largest = i;

        if((left<heap_size) && (array.get(left)) >array.get(largest))
        {
            largest = left;
        }
        if(((right < heap_size)) && (array.get(right)) > array.get(largest))
        {
            largest = right;
        }
        if(largest != i)
        {
            SwapElements(i,largest);
            maxHeapify(largest);
        }


    }
    public void buildMaxHeap() {
         heap_size = array.size();
         int store_num = array.size()/2;
        for(int i = store_num; i >= 0; i --)
        {
            maxHeapify(i);
        }
    }
    public void SwapElements(int firstElement,int secondElement)
    {

        int tempElement = array.get(firstElement);
        array.set(firstElement,array.get(secondElement));
        array.set(secondElement,tempElement);
        counter++;

        //counter++;
    }
    public void insert(Integer k) {
        //int s = heap_size;
         array.add(k);
        int current_pos = heap_size;
       
        heap_size = heap_size +1;
        //int parent = parent(current_pos);

        while(current_pos >0 && array.get(parent(current_pos)) < array.get(current_pos))
        {
            SwapElements(parent(current_pos),current_pos);
            current_pos = parent(current_pos);
        }
    }
    public Integer maximum() {
        if(array.size() == 0)
        {
            return -1;
        }
        else{
        return array.get(0);
        }
    }

    public Integer extractMax() {
        int max = maximum();
        array.set(0,array.get(heap_size-1));
        heap_size --;
        maxHeapify(0);


        return max;
    }

    public ArrayList<Integer> sort()
    {
        buildMaxHeap();

        while(heap_size >0)
        {
            int index = heap_size -1;

            array.set(index,extractMax());
        }
        return array;
    }

    public static void main(String [] args)
    {
        ArrayList<Integer> test = new ArrayList<Integer>(59396);
        Heap test_num = new Heap(test,true);

        for(int i = 0;i<59396; i++)
        {
            test_num.insert(i);
            counter ++;
        }
        
        System.out.println(counter);
    }

}
