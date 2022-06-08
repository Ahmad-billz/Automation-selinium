
public class Methodsdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		methods m = new methods();
		//m.getUerData();
		String name = m.getUerData();
		System.out.println(name);
		
		Methodsdemo pclass = new Methodsdemo();
		pclass.getData();
		getData2();
		methods.getUerData41();
		

	}
	public void getData()
	{
		System.out.println("same class method");
	}

	public static void getData2()
	{
		System.out.println("same class method22");
	}

}
