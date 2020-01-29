import java.util.*;
import java.io.*;
public class Trie {
    public Trie[] children;
    public Trie() {
    	children = new Trie[27];
    }
    public void insert(String s)throws IOException {
    	//for(int j =0; j< s.length; j++)
    	//{
    	if(s.length() == 0)
    		children[26] = new Trie();
    	else
    	{
    		int indx =s.charAt(0) - 'a';
    		if(children[indx] == null)
    			children[indx]= new Trie();

    		children[indx].insert(s.substring(1));
    	}
    	//}
    }
    public boolean query(String s)throws IOException {
    	// int indx = s.charAt(0) - 'a';
    	if(s.length() == 0)
    	{
    		if(children[26]==null)
    			return false;
    		else
    			return true;
    	}
    	else
    		{
    			int indx = s.charAt(0) - 'a';
    			if(children[indx]== null)
    			{
    			System.out.println("not found");
    			return false;
    			}
    			else
    			{
    				return children[indx].query(s.substring(1));
    			}
    		}

    	
    }
    public static void main(String[] args)
    {
  //   	Trie t = new Trie();
		// t.insert("one");
		// t.insert("two");
		// t.query("ones");
		// t.query("two");
		int storeCounter = 0;
		ArrayList<String> dictionary = new ArrayList<String>();
		try{
			File dictionaryA = new File("/Users/h/is52038b-labs/18/java/dictionary.txt");
			Scanner scanner = new Scanner(dictionaryA);
			while(scanner.hasNextLine())
			{
				dictionary.add(scanner.nextLine());
			}
			Trie t = new Trie();
			for(int i = 0; i<59396; i++)
			{
				t.insert(dictionary.get(i));
			}
			for(int h=0;h<27; h++)
			{
				if(t.children[h] != null)
				{
					for(int l=0; l<27;l++)
					{
						if(t.children[h].children[l]!=null)
						{
							for(int m = 0;m< 27; m++)
							{
								if(t.children[h].children[l].children[m] !=null)
								{
									storeCounter++;
								}
							}
						}
					}
				}
			}
		}
			catch(Exception e)
			{

			}
			System.out.println(storeCounter);
			//Answer = 661
    
}

}
