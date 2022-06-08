import java.util.ArrayList;

public class CoreJava {

	public static void main(String[] args) {
	
		int[] arr2 = {1,2,4,5,7,10,122};
		for (int i =0;i<arr2.length; i++)
		{
			if(arr2[i]%2==0)
			{
				System.out.println(arr2[i]);
			}
		}
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Ahmad");
		a.add("Bilal");
		a.add("Sohail"); 
		System.out.print(a.get(2));
		
		
		
		
	}
}
