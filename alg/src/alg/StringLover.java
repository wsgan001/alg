/**
 * 
 */
package alg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cvv
 *
 */
public class StringLover
{
	public static void findFirstRepeating (String str)
	{
		for (int i =0; i < str.length (); i ++)
		{
			if (str.indexOf (str.charAt (i)) < i)
			{
				System.out.println (str.charAt (i));
				break;
			}
		}
	}
	public static void findFirstRepeating2 (String str)
	{
		Set <String> set = new HashSet <String> ();
		for (int i =0; i < str.length (); i ++)
		{
			if (set.contains (String.valueOf(str.charAt (i))))
			{
				System.out.println (str.charAt (i));
				break;
			}
			else
			{
				set.add (String.valueOf (str.charAt (i)));
			}
		}
	}
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
        {
            return 0;
        }
        else if (s.length() == 1)
        {
            return 1;
        }
        Set <Character> set = new HashSet<Character>();
        int maxlen = 0;
        for (int i = 0; i < s.length(); i ++)
        {
            for (int j = i; j < s.length(); j ++)
            {
                char c = s.charAt (j);
                if (set.contains(c))
                {
                    break;
                }
                set.add (c);
            }
        	if (set.size() > maxlen)
        	{
        		maxlen = set.size();
        	}
            set.clear();
        }
        if (set.size() > maxlen)
        {
        	maxlen = set.size();
        }
        return maxlen;
    }
    
    public static int lengthOfLongestSubstring2 (String s) {
        if (s == null || s.length() == 0)
        {
            return 0;
        }
        else if (s.length() == 1)
        {
            return 1;
        }
        int maxlen = 0;
        int [] dic = new int [65535];
        for (int i = 0, head = 0; i < s.length(); i ++)
        {
            char c = s.charAt (i);
            head = Math.max (head, dic [c]);
            maxlen = Math.max(maxlen, i - head + 1);
            dic [c] = i + 1;
        }
        return maxlen;
    }
    /**
     * O(N!)
     * @param source
     * @param key
     * @return
     */
    public static int indexOf (String source, String key)
    {
    	//deal with extreme
    	if (source == null || key == null)
    	{
    		
    	}
    	
    	char [] src = source.toCharArray();
    	char [] k = key.toCharArray();
    	int i = 0;
    	for (;i < src.length; i ++)
    	{
        	int j = 0;
    		for (;j < k.length && src[i+j] == k[j] && (i + j) < src.length; j ++) {}
    		if (j == k.length)
    		{
    			return i;
    		}
    	}
    	return -1;
    }
	public static void main (String [] args)
	{
		/*String s = "1234567890qwertyuiopasdfghjklzxcvbnm,.2";
		long i = System.currentTimeMillis ();
		for (int x = 0; x < 1000; x ++)
		{			
			findFirstRepeating (s);
		}
		long j = System.currentTimeMillis ();
		for (int x = 0; x < 1000; x ++)
		{			
			findFirstRepeating2 (s);
		}
		long k = System.currentTimeMillis ();
		System.out.println (j - i);
		System.out.println (k - j );*/
		System.out.println(lengthOfLongestSubstring2 ("abcabcbb"));
		String s = "System.currentTimeMillis ()";
		System.out.printf ("%d %d", s.indexOf("rren"), indexOf (s, "rren"));
	}
}
