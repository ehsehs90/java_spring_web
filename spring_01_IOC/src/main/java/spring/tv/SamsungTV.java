package spring.tv;

public class SamsungTV implements TV{

	public SamsungTV(){
		System.out.println("SamsungTV construct");
	}
	
	@Override
	public void on() {
		System.out.println("SamsungTV on");
	}

	@Override
	public void off() {
		System.out.println("SamsungTV off");
	}

}
