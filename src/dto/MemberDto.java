package dto;

public class MemberDto {
	
	private int empID;
	private String name;
	private int age;
	private String birth;
	private String phoneNum;
	private int salary;
	private String deptID;
	
	public MemberDto() {
	}

	public MemberDto(int empID, String name, int age, String birth, String phoneNum, int salary, String deptID) {
		super();
		this.empID = empID;
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.phoneNum = phoneNum;
		this.salary = salary;
		this.deptID = deptID;
	}

	public MemberDto(String name, int age, String birth, String phoneNum, int salary, String deptID) {
		super();
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.phoneNum = phoneNum;
		this.salary = salary;
		this.deptID = deptID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	@Override
	public String toString() {
		return "MemberDto [empID=" + empID + ", name=" + name + ", age=" + age + ", birth=" + birth + ", phoneNum="
				+ phoneNum + ", salary=" + salary + ", deptID=" + deptID + "]";
	}
	

}
