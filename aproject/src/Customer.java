
public class Customer {
	String username;
	String password;
	String email;
	String fname;
	String mname;
	String lname;
	String phoneno;
	String dob;
	String gender;
	Float balance;

	//constructor
	public Customer(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}


	public Customer(String username, String fname, String lname, String phoneno, String email, String dob, String gender, Float balance) {
		this.username = username;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.phoneno = phoneno;
		this.email = email;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.balance = balance;
	}

	public Customer(String username, String password, String email, String fname, String lname,
					String phoneno, String dob, String gender) {
		this(username, password, email);
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.phoneno = phoneno;
		this.dob = dob;
		this.gender = gender;
		this.balance = 0f;
	}


	//getters
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getFname() {
		return fname;
	}

	public String getMname() {
		return mname;
	}

	public String getLname() {
		return lname;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public String getDob() {
		return dob;
	}

	public String getGender() {
		return gender;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}


}
