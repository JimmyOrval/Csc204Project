package Project;

public class Customer {
	private String name,gender;
	private int age;
	private Address Address;
	public Customer(String name, String gender, int age, Project.Address address) {
		this.name = name;
		this.gender = gender;
		setAge(age);
		Address = address;
	}
	public Customer(Customer c) {
		super();
		this.name = c.name;
		this.gender = c.gender;
		this.age = c.age;
		Address = c.Address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age<18) {
			this.age=18;
		}
		else {
		this.age = age;
		}
	}
	public Address getAddress() {
		return Address;
	}
	public void setAddress(Address address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "Customer [name=" + getName()  + ", age=" + getAge() + ", Address=" + Address.getCity()+" "+Address.getCountry() + ", gender=" + getGender()+ "]";
	}
	
	
	

}
