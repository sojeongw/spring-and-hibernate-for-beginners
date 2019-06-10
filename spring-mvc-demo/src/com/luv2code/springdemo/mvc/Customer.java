package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Customer {

	private String firstName;
	
	@NotNull(message="is required") 
	@Size(min=1, message="is required")	// error에 걸릴 때 text box 옆에 생길 메시지
	private String lastName;
	
	@NotNull(message="is required") 
	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=10, message="must be less than or equl to ten")
	private Integer freePasses;	// null일 경우 String으로 취급되는 것을 처리하기 위해 int에서 Integer로 변경 
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
	private String postalCode;
	
	// @CourseCode(value="LUV", message="must start with LUV") 와 같은 의미. CourseCode에서 설정해줬기 때문.
	@CourseCode
	// @CourseCode(value="TOPS", message="must start with TOPS") 이렇게 덮어쓰기 할 수도 있다.
	// customize 한 annotation을 사용하기 위한 field 생성. 이름은 아무거나 해도 됨.
	private String courseCode;
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
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
	
	
}
