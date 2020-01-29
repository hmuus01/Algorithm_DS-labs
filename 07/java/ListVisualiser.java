//import java.lang.*;
//import java.util.*;
//import java.io.*;

public class ListVisualiser {
	public SLList start;
    public ListVisualiser(SLList l) { 
    	start = l;
    }
    public void visualise() {
    	System.out.println();
    	int l = start.length();
    	SLList temp = start;
    	SLList temp2 = start;
    	SLList temp3 = start;
    	String thing = "[*|*]->";
    	String thing2 = "[*|/]  ";
        String thing3 = "[/|/]";
    	String middle = "|";
        //to show empty list if list is empty
        if (temp.first() != SLList.NIL){
            //to display the boxes
        	for(int i=0;i<l;i++){
                // if(temp.first() == SLList.NIL){
                //     System.out.println(thing3);

                // }
        		if(temp.rest() != SLList.NIL){
        			//System.out.format("[*|*]->");
        			//System.out.print("[*|*]->");
        			//System.out.println();
        			//System.out.print(temp.first());
        			System.out.format("%10s", thing);
        		}
        		else{
        			//System.out.print("[*|/] ");
        			System.out.format("%10s", thing2);
        			//System.out.println();
        		}
    			temp = temp.rest();
        		
        	}

        	System.out.println();
            //to display the lines
        	for(int i=0;i<l;i++){
                // if(temp.first() == SLList.NIL){
                //     break;

                // }
        		if(i == 0){
        			System.out.format("%5s", middle);
        		}
        		else if(temp2.rest() != SLList.NIL)
        			System.out.format("%10s", middle);
        		else
        			System.out.format("%10s", middle);
    			temp2 = temp2.rest();
        		
        	}



         	System.out.println();
       //  	for(int i=0;i<l;i++){
       //  		if(temp3.rest() != SLList.NIL)
       //  			System.out.print(" " + temp3.first() + "    ");
       //  		else
       //  			System.out.print(temp3.first() + "");
    			// temp3 = temp3.rest();
        		
       //  	}
       //  	System.out.println();
            // to display the numbers
         	for(int i=0;i<l;i++){
                // if(temp.first() == SLList.NIL){
                //     break;

                // }
        		if(i == 0){
        			System.out.format("%5s", temp3.first());
        		}
        		else if(temp3.rest() != SLList.NIL){
        			System.out.format("%10s", temp3.first());
                }
        		else{
        			System.out.format("%10s", temp3.first());
                }
    			temp3 = temp3.rest();
        		
        	}
        	System.out.println();
        	System.out.println();
    }
    else{
        System.out.println(thing3);
        System.out.println();
    }
	}
}
