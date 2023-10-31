//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

public class JavaMap {
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
        HashMap<String, Integer> temp = new HashMap<>();
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
            temp.put(name, phone);
			in.nextLine();
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
            if (temp.containsKey(s)) System.out.println(s + "=" + temp.get(s));
            else System.out.println("Not found");
		}
	}
}