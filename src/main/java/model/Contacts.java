package model;

import java.time.LocalDate;


/**
 * Todo.java
 * This is a model class represents a Todo entity
 * @author Ramesh Fadatare
 *
 */
public class Contacts {

    private Long id;
    private String firstName;
    private String lastName;

    private LocalDate targetDate;
    private int mobileNo;

    protected Contacts() {

    }

    public Contacts(long id, String firstName, String lastName,LocalDate targetDate, int mobileNo) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.targetDate = targetDate;
        this.mobileNo = mobileNo;
    }

    public Contacts(String firstName, String lastName,LocalDate targetDate, int mobileNo) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.targetDate = targetDate;
        this.mobileNo = mobileNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)(id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contacts other = (Contacts) obj;
        if (id != other.id)
            return false;
        return true;
    }
}