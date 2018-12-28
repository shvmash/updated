package com.hexaware.ftp84.model;
import com.hexaware.ftp84.persistence.LeaveDAO;
import com.hexaware.ftp84.persistence.EmployeeDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Before;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.Date;
import java.util.ArrayList;



/**
 * unit test for leave details.
 */
@RunWith(JMockit.class)
public class LeaveDetailsTest {
/**
 * to test the getters of leavedetails.
 * @throws ParseException throws.
 */
  @Test

    public final void testLeaveDetails() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails ld = new LeaveDetails(1000, 1, 10, sdf.parse("2018-10-19"),
                sdf.parse("2018-10-28"),
                "SICK", sdf.parse("2018-10-10"),
                "Enjoy buddy", LeaveStatus.valueOf("APPROVED"),
                LeaveType.valueOf("SL"));
<<<<<<< HEAD
    assertEquals(1000, ld.getempId());
=======
    assertEquals(1000, ld.getEmpId());
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
    assertEquals(1, ld.getLeaveId());
    assertEquals(10, ld.getLeaveNoOfDays());
    assertEquals(sdf.parse("2018-10-19"), ld.getStartDate());
    assertEquals(sdf.parse("2018-10-28"), ld.getEndDate());
    assertEquals("SICK", ld.getLeaveReason());
    assertEquals(sdf.parse("2018-10-10"), ld.getLeaveAppliedOn());
    assertEquals("Enjoy buddy", ld.getMgrComments());
    assertEquals(LeaveStatus.valueOf("APPROVED"), ld.getLeaveStatus());
    assertEquals(LeaveType.valueOf("SL"), ld.getLeaveType());
    LeaveDetails ld1 = null;
    Employee e2 = new Employee();
    assertFalse(ld.equals(ld1));
    assertFalse(ld.equals(e2));
  }

/**
 * to test the setters of leavedetails.
 * @throws ParseException throws.
 */
  @Test
  public final void testLeaveSetters() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails ld1 = new LeaveDetails();
<<<<<<< HEAD
    ld1.setempId(2000);
=======
    ld1.setEmpId(2000);
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
    ld1.setLeaveId(2);
    ld1.setLeaveNoOfDays(24);
    ld1.setStartDate(sdf.parse("2018-03-10"));
    ld1.setEndDate(sdf.parse("2018-03-19"));
    ld1.setLeaveReason("BASS AISE HI");
    ld1.setLeaveAppliedOn(sdf.parse("2018-03-01"));
    ld1.setMgrComments("jao jilo apni jindagi");
    ld1.setLeaveStatus(LeaveStatus.valueOf("APPROVED"));
    ld1.setLeaveType(LeaveType.valueOf("SL"));

<<<<<<< HEAD
    assertEquals(2000, ld1.getempId());
=======
    assertEquals(2000, ld1.getEmpId());
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
    assertEquals(2, ld1.getLeaveId());
    assertEquals(24, ld1.getLeaveNoOfDays());
    assertEquals(sdf.parse("2018-03-10"), ld1.getStartDate());
    assertEquals(sdf.parse("2018-03-19"), ld1.getEndDate());
    assertEquals("BASS AISE HI", ld1.getLeaveReason());
    assertEquals(sdf.parse("2018-03-01"), ld1.getLeaveAppliedOn());
    assertEquals("jao jilo apni jindagi", ld1.getMgrComments());
    assertEquals(LeaveStatus.valueOf("APPROVED"), ld1.getLeaveStatus());
    assertEquals(LeaveType.valueOf("SL"), ld1.getLeaveType());
  }

/**
 * to test equals method.
 * @throws ParseException throws.
 */
  @Test
  public final void testEquals() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails ld = new LeaveDetails(2000, 2, 24, sdf.parse("2018-03-10"),
                sdf.parse("2018-03-19"), "BASS AISE HI",
                sdf.parse("2018-03-01"), "jao jilo apni jindagi",
                LeaveStatus.valueOf("APPROVED"), LeaveType.valueOf("SL"));
    LeaveDetails ld1 = new LeaveDetails(2000, 2, 24, sdf.parse("2018-03-10"),
                 sdf.parse("2018-03-19"), "BASS AISE HI",
                 sdf.parse("2018-03-01"), "jao jilo apni jindagi",
                 LeaveStatus.valueOf("APPROVED"), LeaveType.valueOf("SL"));
    LeaveDetails ld2 = new LeaveDetails(3000, 6, 12, sdf.parse("2018-06-20"),
                sdf.parse("2018-06-15"), "shadi hai bhai", sdf.parse("2018-06-10"),
                "kam kro", LeaveStatus.valueOf("DENIED"), LeaveType.valueOf("PL"));
    assertTrue(ld.equals(ld1));
    assertFalse(ld.equals(ld2));
    assertFalse(ld1.equals(ld2));
  }

/**
 * to test hashcode method.
 * @throws ParseException throws.
 */
  @Test
    public final void testHashCode() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails ld1 = new LeaveDetails(2000, 2, 24, sdf.parse("2018-03-10"),
                     sdf.parse("2018-03-19"), "BASS AISE HI",
                     sdf.parse("2018-03-01"), "jao jilo apni jindagi",
                     LeaveStatus.valueOf("APPROVED"), LeaveType.valueOf("SL"));
    LeaveDetails ld2 = new LeaveDetails(2000, 2, 24, sdf.parse("2018-03-10"),
                     sdf.parse("2018-03-19"), "BASS AISE HI",
                     sdf.parse("2018-03-01"), "jao jilo apni jindagi",
                     LeaveStatus.valueOf("APPROVED"), LeaveType.valueOf("SL"));
    LeaveDetails ld3 = new LeaveDetails(3000, 6, 12, sdf.parse("2018-06-20"),
                     sdf.parse("2018-06-15"), "shadi hai bhai", sdf.parse("2018-06-10"),
                     "kam kro", LeaveStatus.valueOf("DENIED"), LeaveType.valueOf("PL"));
    assertEquals(ld1.hashCode(), ld2.hashCode());
    assertNotEquals(ld1.hashCode(), ld3.hashCode());
    assertNotEquals(ld2.hashCode(), ld3.hashCode());
  }

/**
 * to test toString method.
 * @throws ParseException throws.
 */
  @Test
  public final void testtoString() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails ld1 = new LeaveDetails(2000, 2, 24, sdf.parse("2018-03-10"),
                     sdf.parse("2018-03-19"), "BASS AISE HI",
                     sdf.parse("2018-03-01"), "jao jilo apni jindagi",
                     LeaveStatus.valueOf("APPROVED"), LeaveType.valueOf("SL"));
<<<<<<< HEAD
    String res = "Emp ID :" + ld1.getempId() + "Leave ID :" + ld1.getLeaveId()
=======
    String res = "Emp ID :" + ld1.getEmpId() + "Leave ID :" + ld1.getLeaveId()
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
        + "Leave No of Days :" + ld1.getLeaveNoOfDays()
        + "Start Date :" + ld1.getStartDate() + "End Date :"
        + ld1.getEndDate() + "Leave Reason :" + ld1.getLeaveReason()
        + "Leave Applied On :" + ld1.getLeaveAppliedOn()
        + "Manager Comments :" + ld1.getMgrComments()
        + "Leave Status :" + ld1.getLeaveStatus()
        + "Leave Type :" + ld1.getLeaveType();
    assertEquals(res, ld1.toString());
  }


  /**
   * setup method.
   */

  @Before
  public void initInput() {

  }

/**
   * tests that empty leave details list is handled correctly.
   * @param edao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final LeaveDAO edao) {
    final ArrayList alist = new ArrayList<LeaveDetails>();
    new Expectations() {
      {
        edao.list(); result = alist;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return edao;
      }
    };
    LeaveDetails[] ls1 = LeaveDetails.listAll();
    assertEquals(0, ls1.length);
  }

  /**
  * To test that a list with some employees leave details is handled correctly.
  * @param dao mocking dao class.
  * @throws ParseException throws.
  */

  public final void testListAllSome(@Mocked final LeaveDAO dao) throws ParseException {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    new Expectations() {
          {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ArrayList<LeaveDetails> es = new ArrayList<LeaveDetails>();
            es.add(new LeaveDetails(2000, 2, 24, sdf.parse("2018-03-10"),
                     sdf.parse("2018-03-19"), "diwali",
                     sdf.parse("2018-03-01"), "enjoy",
                     LeaveStatus.valueOf("APPROVED"), LeaveType.valueOf("CL")));
            es.add(new LeaveDetails(4000, 4, 12, sdf.parse("2018-08-16"),
                     sdf.parse("2018-08-18"), "BASS AISE HI",
                     sdf.parse("2018-08-10"), "jao jilo apni jindagi",
                     LeaveStatus.valueOf("APPROVED"), LeaveType.valueOf("SL")));
            es.add(new LeaveDetails(1000, 10, 23, sdf.parse("2018-01-23"),
                     sdf.parse("2018-01-25"), "new year",
                     sdf.parse("2018-01-20"), "happy new year",
                     LeaveStatus.valueOf("APPROVED"), LeaveType.valueOf("CL")));
            dao.list();
            result = es;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] es = LeaveDetails.listAll();
    assertEquals(3, es.length);
    assertEquals(new LeaveDetails(2000, 2, 24, sd.parse("2018-03-10"),
                     sd.parse("2018-03-19"), "diwali",
                     sd.parse("2018-03-01"), "enjoy",
                     LeaveStatus.valueOf("APPROVED"), LeaveType.valueOf("CL")), es[0]);
    assertEquals(new LeaveDetails(4000, 4, 12, sd.parse("2018-08-16"),
                     sd.parse("2018-08-18"), "BASS AISE HI",
                     sd.parse("2018-08-10"), "jao jilo apni jindagi",
                     LeaveStatus.valueOf("APPROVED"), LeaveType.valueOf("SL")), es[1]);
    assertEquals(new LeaveDetails(1000, 10, 23, sd.parse("2018-01-23"),
                     sd.parse("2018-01-25"), "new year",
                     sd.parse("2018-01-20"), "happy new year",
                     LeaveStatus.valueOf("APPROVED"), LeaveType.valueOf("CL")), es[2]);
  }


/**
   * Tests that a fetch of a specific employee leave details correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws.
   */
  @Test
  public final void testListById(@Mocked final LeaveDAO dao) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final LeaveDetails e1 = new LeaveDetails(4000, 4, 12, sdf.parse("2018-08-16"),
                     sdf.parse("2018-08-18"), "BASS AISE HI",
                     sdf.parse("2018-08-10"), "jao jilo apni jindagi",
                     LeaveStatus.valueOf("APPROVED"), LeaveType.valueOf("SL"));
    new Expectations() {
      {
        dao.find(4000);
        result = e1;
        dao.find(-1);
        result = null;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    LeaveDetails e = LeaveDetails.listById(4000);
    assertEquals(e1, e);

    e = LeaveDetails.listById(-1);
    assertNull(e);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException for date parsing.
   */
  @Test
  public final void testPending(@Mocked final LeaveDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails ld1 = new LeaveDetails();
    final ArrayList<LeaveDetails> es = new ArrayList<LeaveDetails>();
    new Expectations() {
      {
        es.add(new LeaveDetails(2, 1, 2, sdf.parse("2018-12-01"), sdf.parse("2018-12-02"),
            "sick", sdf.parse("2018-11-22"), "go", LeaveStatus.PENDING, LeaveType.EL));
        es.add(new LeaveDetails(4, 3, 1, sdf.parse("2019-01-02"), sdf.parse("2019-01-02"),
            "marriage", sdf.parse("2018-11-22"), "done", LeaveStatus.PENDING, LeaveType.EL));
        es.add(new LeaveDetails(6, 5, 3, sdf.parse("2018-11-28"), sdf.parse("2018-11-30"),
            "urgent", sdf.parse("2018-11-22"), "go", LeaveStatus.PENDING, LeaveType.EL));
        es.add(new LeaveDetails(7, 5, 3, sdf.parse("2018-11-28"), sdf.parse("2018-11-30"),
            "urgent", sdf.parse("2018-11-22"), "go", LeaveStatus.PENDING, LeaveType.EL));
        dao.pending(1); result = es;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] lds1 = LeaveDetails.listPending(1);
    assertEquals(4, lds1.length);
    LeaveDetails[] lds2 = LeaveDetails.listPending(2);
    assertEquals(0, lds2.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param edao mocking the EmployeeDAO class.
   * @param dao mocking the LeaveDAO class.
   * @throws ParseException for exceptions.
   */
  @Test
  public final void testinsertLeaveDetails(@Mocked final EmployeeDAO edao, @Mocked final LeaveDAO dao)
                    throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Date today = new Date();
    new Expectations() {
      {
        dao.count(200, "2018-12-26", "2018-12-27"); result = 0;
        dao.count(200, "2018-12-30", "2018-12-30"); result = 1;
      }
    };
    new Expectations() {
      {
        edao.find(100);  result = new Employee(100, "Rashmi",
            "Rashmi@gmail.com", 9949391111L, sdf.parse("2018-08-01"), "Java", 12, 0);
        edao.find(200);  result = new Employee(200, "sravanthi",
            "sravanthi@gmail.com", 9949391111L, sdf.parse("2018-08-01"), "Java", 33, 100);
<<<<<<< HEAD
        // edao.find(500);  result = new Employee(200, "Raju",
        //     "raju@gmail.com", 9949391981L, sdf.parse("2018-08-01"), "Java", 33, 200);
=======
<<<<<<< HEAD

=======
<<<<<<< HEAD
        // edao.find(500);  result = new Employee(200, "Raju",
        //     "raju@gmail.com", 9949391981L, sdf.parse("2018-08-01"), "Java", 33, 200);
=======
<<<<<<< HEAD
        // edao.find(500);  result = new Employee(200, "Raju",
        //     "raju@gmail.com", 9949391981L, sdf.parse("2018-08-01"), "Java", 33, 200);
=======
>>>>>>> fcba7d7ca3357681eb1f6ff67c2a54d97a09b9e5
>>>>>>> ba55724c23617a8ab58142ec2dd6498489ef01c5
>>>>>>> 27940c355df2ab3aeb55a4c91e92e95ae74f0b68
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
        edao.find(300); result = null;
      }
    };
    new Expectations() {
      {
        dao.insert(200, 2, "2018-12-26", "2018-12-27",
            "sick", sdf.format(today), "PENDING", "EL");
<<<<<<< HEAD
        // dao.insert(500, 2, "2018-12-14", "2018-12-17",
        //     "sick", sdf.format(today), "PENDING", "EL");
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
        // dao.insert(500, 2, "2018-12-14", "2018-12-17",
        //     "sick", sdf.format(today), "PENDING", "EL");
=======
<<<<<<< HEAD
        // dao.insert(500, 2, "2018-12-14", "2018-12-17",
        //     "sick", sdf.format(today), "PENDING", "EL");
=======
>>>>>>> fcba7d7ca3357681eb1f6ff67c2a54d97a09b9e5
>>>>>>> ba55724c23617a8ab58142ec2dd6498489ef01c5
>>>>>>> 27940c355df2ab3aeb55a4c91e92e95ae74f0b68
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    String str8 = LeaveDetails.insertLeaveDetails(300, 1, "2018-12-30", "2018-12-30", "EL",
                       "sick");
    assertEquals("No Such Employ", str8);
    String str1 = LeaveDetails.insertLeaveDetails(200, 2, "2018-12-26", "2018-12-27", "EL",
                       "sick");
<<<<<<< HEAD
    assertEquals("Successfully leave applied for 2 days", str1);
=======

    assertEquals("Successfully leave applied for 2 days", str1);
<<<<<<< HEAD

=======
=======
<<<<<<< HEAD
    assertEquals("Successfully leave applied for 2 days", str1);
=======
    assertEquals("Successfully leave applied", str1);
>>>>>>> fcba7d7ca3357681eb1f6ff67c2a54d97a09b9e5
>>>>>>> ba55724c23617a8ab58142ec2dd6498489ef01c5
>>>>>>> 27940c355df2ab3aeb55a4c91e92e95ae74f0b68
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
    String str2 = LeaveDetails.insertLeaveDetails(200, 1, "2018-12-30", "2018-12-30", "EL",
                       "sick");
    assertEquals("Already applied on given Date...", str2);
    String str3 = LeaveDetails.insertLeaveDetails(200, 2, "2018-11-25", "2018-11-26", "EL",
                       "sick");
    assertEquals("start date must be greater or equal to current Sdate...", str3);
    String str4 = LeaveDetails.insertLeaveDetails(200, 3, "2018-12-25", "2018-12-26", "EL",
                       "sick");
    assertEquals("No Of Days Should be right", str4);
    String str5 = LeaveDetails.insertLeaveDetails(200, 3, "2018-12-25", "2019-12-26", "EL",
                       "sick");
    assertEquals("insufficient leave balance...", str5);
    String str6 = LeaveDetails.insertLeaveDetails(200, 3, "2018-12-26", "2018-12-25", "EL",
                       "sick");
    assertEquals("StartDate must be Greater than EndDate...", str6);
    String str7 = LeaveDetails.insertLeaveDetails(100, 1, "2018-12-30", "2018-12-30", "EL",
                       "sick");
    assertEquals("Successfully Approved, no need for Permission", str7);
<<<<<<< HEAD
    // String str9 = LeaveDetails.insertLeaveDetails(500, 4, "2018-12-14", "2018-12-17", "EL",
    //                    "sick");
    // assertEquals("Successfully leave applied for 2 days", str9);
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
    // String str9 = LeaveDetails.insertLeaveDetails(500, 4, "2018-12-14", "2018-12-17", "EL",
    //                    "sick");
    // assertEquals("Successfully leave applied for 2 days", str9);
=======
<<<<<<< HEAD
    // String str9 = LeaveDetails.insertLeaveDetails(500, 4, "2018-12-14", "2018-12-17", "EL",
    //                    "sick");
    // assertEquals("Successfully leave applied for 2 days", str9);
=======
>>>>>>> fcba7d7ca3357681eb1f6ff67c2a54d97a09b9e5
>>>>>>> ba55724c23617a8ab58142ec2dd6498489ef01c5
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
    // String str2 = LeaveDetails.insertLeaveDetails(200, 2, "2018-12-26", "2018-12-25", "EL",
 //                      "sick");
  //  assertEquals("StartDate must be Greater than EndDate...", str2);
   /* String str4 = LeaveDetails.insertLeaveDetails(200, 1, "2018-12-30", "2018-12-30", "EL",
                       "sick");
    assertEquals("Already applied on given Date...", str4);
    String str5 = LeaveDetails.insertLeaveDetails(2, 1, "2018-12-26", "2019-12-26", "EL",
                       "sick");
    assertEquals("insufficient leave balance...", str5);
    String str6 = LeaveDetails.insertLeaveDetails(2, 2, "2018-12-26", "2018-12-27", "EL",
                       "sick");
    assertEquals("Successfully leave applied", str6);*/
<<<<<<< HEAD
=======
>>>>>>> 27940c355df2ab3aeb55a4c91e92e95ae74f0b68
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
  }

 /**
   * Test to check the functionality of Approve/Deny.
   * @param dao mocking the LeaveDAO class.
   * @throws ParseException for Date conversions.
   */
  @Test
  public final void testApproveDeny(@Mocked final LeaveDAO dao)
    throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final LeaveDetails ld1 = new LeaveDetails(200, 2, 2, sf.parse("2018-12-12"),
            sf.parse("2018-12-13"), "Sick", sf.parse("2018-11-26"), "enjoy",
            LeaveStatus.PENDING, LeaveType.EL
            );
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
    final LeaveDetails ld2 = new LeaveDetails(200, 3, 2, sf.parse("2018-12-12"),
            sf.parse("2018-12-13"), "Sick", sf.parse("2018-11-26"), "enjoy",
            LeaveStatus.APPROVED, LeaveType.EL
            );
    final LeaveDetails ld3 = new LeaveDetails(200, 4, 2, sf.parse("2018-12-12"),
            sf.parse("2018-12-13"), "Sick", sf.parse("2018-11-26"), "SORRY",
            LeaveStatus.DENIED, LeaveType.EL
            );
    new Expectations() {
      {
        dao.find(2); result = ld1;
        dao.find(3); result = ld2;
        dao.find(4); result = ld3;
<<<<<<< HEAD
=======
=======
    new Expectations() {
      {
        dao.find(2); result = ld1;
>>>>>>> ba55724c23617a8ab58142ec2dd6498489ef01c5
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
      }
    };
    new Expectations() {
      {
        dao.manager(2); result = 1;
<<<<<<< HEAD
        dao.manager(3); result = 1;
        dao.manager(4); result = 1;
=======
<<<<<<< HEAD
        dao.manager(3); result = 1;
        dao.manager(4); result = 1;
=======
>>>>>>> ba55724c23617a8ab58142ec2dd6498489ef01c5
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
      }
    };
    new Expectations() {
      {
        dao.comment("Enjoy", "APPROVED", 2);
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
    String s1 = LeaveDetails.approveDeny(2, "APPROVED", "Enjoy", 1);
    assertEquals(s1, "Leave approved Successfully");
    String s2 = LeaveDetails.approveDeny(2, "DENIED", "SORRY", 1);
    assertEquals(s2, "Leave Rejected");
    String s3 = LeaveDetails.approveDeny(3, "DENIED", "SORRY", 1);
    assertEquals(s3, "Leave Rejected");
    String s4 = LeaveDetails.approveDeny(4, "APPROVED", "Enjoy", 1);
    assertEquals(s4, "Leave approved Successfully");
<<<<<<< HEAD
=======
=======
    String s1 = LeaveDetails.approveDeny(2, "APPROVE", "Enjoy", 1);
    assertEquals(s1, "Leave approved Successfully");
    String s2 = LeaveDetails.approveDeny(2, "DENIED", "SORRY", 1);
    assertEquals(s2, "Leave Rejected");
>>>>>>> ba55724c23617a8ab58142ec2dd6498489ef01c5
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
  }

  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testleaveHis(@Mocked final LeaveDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    final ArrayList<LeaveDetails> ld1 = new ArrayList<LeaveDetails>();
    final ArrayList<LeaveDetails> ld2 = new ArrayList<LeaveDetails>();
    final ArrayList<LeaveDetails> ld3 = new ArrayList<LeaveDetails>();

    new Expectations() {
      {
        ld1.add(new LeaveDetails(100, 1, 2, sdf.parse("2018-12-01"), sdf.parse("2018-12-02"),
            "sick", sdf.parse("2018-11-22"), "go", LeaveStatus.PENDING, LeaveType.EL));
        ld1.add(new LeaveDetails(100, 3, 1, sdf.parse("2019-01-02"), sdf.parse("2019-01-02"),
            "marriage", sdf.parse("2018-11-22"), "done", LeaveStatus.PENDING, LeaveType.EL));
        ld2.add(new LeaveDetails(200, 5, 3, sdf.parse("2018-11-28"), sdf.parse("2018-11-30"),
            "urgent", sdf.parse("2018-11-22"), "go", LeaveStatus.APPROVED, LeaveType.EL));
        ld2.add(new LeaveDetails(200, 5, 3, sdf.parse("2018-11-28"), sdf.parse("2018-11-30"),
            "urgent", sdf.parse("2018-11-22"), "go", LeaveStatus.DENIED, LeaveType.EL));
        dao.empHistory(100); result = ld1;
        dao.empHistory(200); result = ld2;
        dao.empHistory(300); result = ld3;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };

    LeaveDetails[] lds1 = LeaveDetails.leaveHis(100);
    assertEquals(2, lds1.length);
    LeaveDetails[] lds2 = LeaveDetails.leaveHis(200);
    assertEquals(2, lds2.length);
    LeaveDetails[] lds3 = LeaveDetails.leaveHis(300);
    assertEquals(0, lds3.length);
  }
<<<<<<< HEAD


=======
>>>>>>> aa56220146b6451076963723b42e7d9594c6a5a8
}
