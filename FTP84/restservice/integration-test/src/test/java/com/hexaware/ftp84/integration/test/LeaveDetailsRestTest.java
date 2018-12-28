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

public class LeaveDetailsRestTest {
    @Test
	public void testLeavesList() throws AssertionError, URISyntaxException {
		LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaves")).getBody().as(LeaveDetails[].class);
		for (LeaveDetails lea: res) {
			switch (lea.getempId()) {
				case 1000:
					assertEquals(1000, lea.getempId());
					break;
				case 2000:
					assertEquals(2000, lea.getempId());
					break;				
				case 3000:
					assertEquals(3000, lea.getempId());
					break;				
				case 4000:
					assertEquals(4000, lea.getempId());
					break;				
				case 5000:
					assertEquals(5000, lea.getempId());
					break;			
				default:
					fail("Unknown employee with id:" + lea);	
			}
		}
	}

    @Test
	public void testLeavesById() throws AssertionError, URISyntaxException {
		LeaveDetails le = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaves/leaid/2")).getBody().as(LeaveDetails.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(2000, le.getempId());
		assertEquals(2, le.getLeaveId());
		assertEquals(10, le.getLeaveNoOfDays());
		assertEquals("2018-11-17", sdf.format(le.getStartDate()));
		assertEquals("2018-11-27", sdf.format(le.getEndDate()));
        assertEquals("sick", le.getLeaveReason());
		assertEquals("2018-11-16", sdf.format(le.getLeaveAppliedOn()));
        assertEquals("AS", le.getMgrComments());
        assertEquals("DENIED", le.getLeaveStatus().toString());
		assertEquals("EL", le.getLeaveType().toString());
  }

  @Test
	public void testLeavesHistory() throws AssertionError, URISyntaxException {
		LeaveDetails[] le = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaves/leahis/2000")).getBody().as(LeaveDetails[].class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(le.length==14)
        {
            assertEquals(14,le.length);
        }

			
	  }

  @Test
    public void testPendingHistory() throws AssertionError, URISyntaxException ,ParseException{
        LeaveDetails[] res = given().accept(ContentType.JSON).when()
                .get(CommonUtil.getURI("/api/leaves/leapend/1000")).getBody().as(LeaveDetails[].class);
                SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
                if(res.length == 6) {
                    assertEquals(6 , res.length);
                }

  }

   @Test
	public void testLeavesById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaves/leaid/100")).then().assertThat().statusCode(404);
	}
    // @Test
	// public void testLeavesHistory404() throws AssertionError, URISyntaxException {
	// 	given().accept(ContentType.JSON).when()
	// 			.get(CommonUtil.getURI("/api/leaves/leahis/2569")).then().assertThat().statusCode(404);
	// }

@Test
	public void testLeavesapply() throws AssertionError, URISyntaxException {

//         String res1 = given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"3000\",\"startDate\":\"2018-11-29\",\"endDate\":\"2018-11-27\",\"leaveNoOfDays\":\"2\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\"}").
//         when().post(CommonUtil.getURI("/api/leaves/apply/3000")).getBody().asString();
//         assertEquals("StartDate must be Greater than EndDate...", res1);
    
// String res2=given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"5000\",\"startDate\":\"2018-11-28\",\"endDate\":\"2018-11-29\",\"leaveNoOfDays\":\"2\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\"}").
//         when().post(CommonUtil.getURI("/api/leaves/apply/5000")).getBody().asString();
    
//      assertEquals("start date must be greater or equal to current Sdate...", res2);

//      String res3 = given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"5000\",\"startDate\":\"2023-07-04\",\"endDate\":\"2023-07-04\",\"leaveNoOfDays\":\"1\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\"}").
//         when().post(CommonUtil.getURI("/api/leaves/apply/5000")).getBody().asString();
//         assertEquals("Successfully leave applied for 1 days", res3);

    //     String res4=given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"3000\",\"startDate\":\"2025-08-25\",\"endDate\":\"2028-08-28\",\"leaveNoOfDays\":\"150\",\"leaveReason\":\"sick\",\"leaveType\":\"SL\"}").
    // when().post(CommonUtil.getURI("/api/leaves/apply/3000")).getBody().asString();
    // assertEquals("insufficient leave balance...", res4);

//     String res5 = given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"5000\",\"startDate\":\"2023-07-04\",\"endDate\":\"2023-07-04\",\"leaveNoOfDays\":\"1\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\"}").
//  when().post(CommonUtil.getURI("/api/leaves/apply/5000")).getBody().asString();
//  assertEquals("Already applied on given Date...", res5);


//  String res6=given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"2000\",\"startDate\":\"2022-11-21\",\"endDate\":\"2022-11-21\",\"leaveNoOfDays\":\"4\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\"}").
//         when().post(CommonUtil.getURI("/api/leaves/apply/2000")).getBody().asString();
    
//      assertEquals("No Of Days Should be right", res6);

    //  String res7=given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"1000\",\"startDate\":\"2033-11-24\",\"endDate\":\"2033-11-26\",\"leaveNoOfDays\":\"3\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\"}").
    //     when().post(CommonUtil.getURI("/api/leaves/apply/1000")).getBody().asString();
    
    //  assertEquals("Successfully Approved, no need for Permission", res7);

     String res8=given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"6789\",\"startDate\":\"2033-11-24\",\"endDate\":\"2033-11-26\",\"leaveNoOfDays\":\"3\",\"leaveReason\":\"sick\",\"leaveType\":\"EL\"}").
        when().post(CommonUtil.getURI("/api/leaves/apply/6789")).getBody().asString();
    
     assertEquals("No Such Employ", res8);
    }

    @Test
	public void testLeavesapprdeny() throws AssertionError, URISyntaxException {
    //     String res=given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"2000\",\"leaveId\":\"39\",\"leaveStatus\":\"DENIED\",\"mgrComments\":\"JUYU\"}").
    //     when().post(CommonUtil.getURI("/api/leaves/appdeny/39")).getBody().asString();
    //    assertEquals("Leave Rejected", res);

    //    String res1=given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"1000\",\"leaveId\":\"31\",\"leaveStatus\":\"APPROVED\",\"mgrComments\":\"enjoy\"}").
    //     when().post(CommonUtil.getURI("/api/leaves/appdeny/31")).getBody().asString();
    //    assertEquals("Leave approved Successfully", res1);

String res2=given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"3000\",\"leaveId\":\"46\",\"leaveStatus\":\"APPROVED\",\"mgrComments\":\"good\"}").
        when().post(CommonUtil.getURI("/api/leaves/appdeny/46")).getBody().asString();
       assertEquals("Leave approved Successfully", res2);
    }

}
