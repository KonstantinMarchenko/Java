package Advertiser.model;


import org.springframework.stereotype.Component;

@Component
public class Advertiser {
	
	private int id;
	private String name;
	private String contactname;
	private int creditlimit;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactName) {
		this.contactname = contactName;
	}
	public int getCreditlimit() {
		return creditlimit;
	}
	public void setCreditlimit(int creditLimit) {
		this.creditlimit = creditLimit;
	}
}