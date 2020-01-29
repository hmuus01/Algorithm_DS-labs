import java.util.Map;
import java.util.*;
import java.util.HashMap.*;

public class CompressedTrie {
    public Map<String, CompressedTrie> children;

    public CompressedTrie() {
        System.out.println("Constructing new Trie");
         children = new HashMap<String, CompressedTrie>();
    }
    public static CompressedTrie compressTrie(Trie t) {
        if(t == null)
            return null;
        CompressedTrie c = new CompressedTrie();
        
        String prefix = "";
        for(int i =0; i<t.children.length;i++)
        {
            if(t.children[i] !=null)
            {
                prefix = "" + (char)('a'+i);
                //System.out.println(prefix);
                Trie child;
                child = t.children[i];            
            //if(counter(child) == 1)
            //{
                
                while(counter(child)==1){
                     prefix += "" + (char)('a'+onlyOneChild(child));
                    child = child.children[onlyOneChild(child)];
                }
            //}
                c.children.put(prefix,compressTrie(child));
           }
        }
        System.out.println(prefix);
        return c;
	//return new CompressedTrie();
    }
    public static int counter(Trie t)
    {
        int count = 0;
        for(int i=0;i<t.children.length;i++)
        {   
            if(t.children[i] != null)
            {
                count++;
            }
        }
        return count;
    }
    public static int onlyOneChild(Trie t)
    {
        for(int i=0; i<t.children.length; i++)
        {
            if(t.children[i] != null)
            {
                return i;
            }
        }
        return 0;
    }
    public boolean query(String s) {
        // if(s.length() == 0)
        //     return false;
        // {
        //     if(children[26]==null)
        //         return false;
        //     else
        //         return true;
        // }
        // else
        //     {
        //         int indx = s.charAt(0) - 'a';
        //         if(children[indx]== null)
        //         {
        //         System.out.println("not found");
        //         return false;
        //         }
        //         else
        //         {
        //             return children[indx].query(s.substring(1));
        //         }
        //     }
        s = s+"{";
        if(s == null||s.length()==0)
            return false;
        boolean checkChildren = this.children.containsKey(s);
        if(checkChildren)
            return true;
        else{
            for(int j=0; j<s.length();j++)
            {
                if(this.children.containsKey(s.substring(0, s.length() - j)))
                {
                    if(this.children.get(s.substring(0,s.length() -j)) != null)
                        return this.children.get(s.substring(0,s.length() -j)).query(s.substring(s.length() -j,s.length() -1));
                }
            }
        }
        return false;
   
    }
    public void insert(String s) {
    }
}
