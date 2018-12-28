package com.hexaware.ftp84.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.ParseException;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class EmployeeRestTest {

	@Test
	public void testEmployeesList() throws AssertionError, URISyntaxException {
		Employee[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees")).getBody().as(Employee[].class);
		for (Employee e: res) {
			switch (e.getempId()) {
				case 1000:
					assertEquals(1000, e.getempId());
					break;
				case 2000:
					assertEquals(2000, e.getempId());
					break;				
				case 3000:
					assertEquals(3000, e.getempId());
					break;				
				case 4000:
					assertEquals(4000, e.getempId());
					break;				
				case 5000:
					assertEquals(5000, e.getempId());
					break;			
				default:
					fail("Unknown employee with id:" + e);	
			}
		}
	}

	@Test
	public void testEmployeeById() throws AssertionError, URISyntaxException, ParseException {
		Employee res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/1000")).getBody().as(Employee.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(1000, res.getempId());
		assertEquals("Anshuman Mishra", res.getEmpName());
		assertEquals("mishraanshuman1705@gmail.com", res.getEmpEmailId());
		assertEquals(9337575732L, res.getEmpMobileNo());
		assertEquals("2017-05-04", sdf.format(res.getEmpDateJoined()));
		assertEquals("JAVA Developer", res.getEmpDept());
		assertEquals(91, res.getEmpLeaveAvail());
		assertEquals(0, res.getEmpMgrId());

  }

  @Test
	public void testEmployeeById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/9999")).then().assertThat().statusCode(404);
	}
}
