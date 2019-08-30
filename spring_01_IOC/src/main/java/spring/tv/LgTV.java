package spring.tv;

public class LgTV implements TV{

	public LgTV(){
		System.out.println("LgTV construct");
	}
	
	@Override
	public void on() {
		System.out.println("LgTV on");
	}

	@Override
	public void off() {
		System.out.println("LgTV off");
	}
	
	public void init() {
		System.out.println("LgTV init()");
	}
	public void destroy() {
		System.out.println("LgTV destroy()");
	}
}
