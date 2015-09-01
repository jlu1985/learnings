package jlu;

public class SimplePojo {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void delegateSayHello() {
		System.out.println(StaticClass.sayHello());
	}
	
	private String name;
	private String message;
}
