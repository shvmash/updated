package com.hexaware.ftp84.model;
import com.hexaware.ftp84.persistence.EmployeeDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;

import java.text.SimpleDateFormat;


/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {
  /**
   * To test the getters of the Employee class.
   * @throws ParseException throws
   */
  @Test
  public final void testEmployee() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Employee obj1 = new Employee(1, "Anshuman Mishra", "mishraanshuman1705@gmail.com",
        9337575732L, sdf.parse("2018-10-04"),
        "Full Stack Developer", 24, 12);

    assertEquals(1, obj1.getempId());
    assertEquals("Anshuman Mishra", obj1.getEmpName());
    assertEquals("mishraanshuman1705@gmail.com", obj1.getEmpEmailId());
    assertEquals(9337575732L, obj1.getEmpMobileNo());
    assertEquals(sdf.parse("2018-10-04"), obj1.getEmpDateJoined());
    assertEquals("Full Stack Developer", obj1.getEmpDept());
    assertEquals(24, obj1.getEmpLeaveAvail());
    assertEquals(12, obj1.getEmpMgrId());
    Employee e2 = null;
    assertFalse(obj1.equals(e2));
    LeaveDetails ld1 = new LeaveDetails();
    assertFalse(obj1.equals(ld1));
  }

  /**
   * Testing the Setters of the Employee Class.
   * @throws ParseException throws
   */
  @Test
  public final void testEmployeeSetters() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Employee obj1 = new Employee();
    obj1.setempId(1);
    obj1.setEmpName("Anshuman Mishra");
    obj1.setEmpEmailId("mishraanshuman1705@gmail.com");
    obj1.setEmpMobileNo(9337575732L);
    obj1.setEmpDateJoined(sdf.parse("2018-10-04"));
    obj1.setEmpDept("Full Stack Developement");
    obj1.setEmpLeaveAvail(24);
    obj1.setEmpMgrId(12);

    assertEquals(1, obj1.getempId());
    assertEquals("Anshuman Mishra", obj1.getEmpName());
    assertEquals("mishraanshuman1705@gmail.com", obj1.getEmpEmailId());
    assertEquals(9337575732L, obj1.getEmpMobileNo());
    assertEquals(sdf.parse("2018-10-04"), obj1.getEmpDateJoined());
    assertEquals("Full Stack Developement", obj1.getEmpDept());
    assertEquals(24, obj1.getEmpLeaveAvail());
    assertEquals(12, obj1.getEmpMgrId());
  }
  /**
   * To test the hashCode of Employees Class.
   * @throws ParseException throws
   */
  @Test
  public final void testHashCode() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Employee obj1 = new Employee(1, "Anshuman Mishra", "mishraanshuman1705@gmail.com",
        9337575732L, sdf.parse("2018-10-04"),
        "Full Stack Developer", 24, 12);
    Employee obj2 = new Employee(1, "Anshuman Mishra", "mishraanshuman1705@gmail.com",
        9337575732L, sdf.parse("2018-10-04"),
        "Full Stack Developer", 24, 12);
    Employee obj3 = new Employee(2, "Paji", "pajiPunjabi@gmail.com",
        9337575756L, sdf.parse("2018-10-09"),
        "Full Stack", 12, 13);
    assertEquals(obj1.hashCode(), obj2.hashCode());
    assertNotEquals(obj2.hashCode(), obj3.hashCode());
    assertNotEquals(obj1.hashCode(), obj3.hashCode());
  }
  /**
   * To test the Equals() for Employee class.
   * @throws ParseException throws
   */
  @Test
  public final void testEquals() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Employee obj1 = new Employee(1, "Anshuman Mishra", "mishraanshuman1705@gmail.com",
        9337575732L, sdf.parse("2018-10-04"),
        "Full Stack Developer", 24, 12);
    Employee obj2 = new Employee(1, "Anshuman Mishra", "mishraanshuman1705@gmail.com",
        9337575732L, sdf.parse("2018-10-04"),
        "Full Stack Developer", 24, 12);
    Employee obj3 = new Employee(2, "Paji", "pajiPunjabi@gmail.com",
        9337575756L, sdf.parse("2018-10-09"),
        "Full Stack", 12, 13);
    assertTrue(obj1.equals(obj2));
    assertFalse(obj1.equals(obj3));
    assertFalse(obj2.equals(obj3));

  }


  /**
   * To test the toString in Employee Class.
   * @throws ParseException throws
   */
  @Test
  public final void testtoString() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Employee obj = new Employee(1, "Anshuman Mishra", "mishraanshuman1705@gmail.com",
        9337575732L, sdf.parse("2018-10-04"),
        "Full Stack Developer", 24, 12);
    Employee obj1 = new Employee();
    String s1 = "empId:" + obj1.getempId() + " EmpFullName:" + obj1.getEmpName()
        + " EmpEmailId:" + obj1.getEmpEmailId() + " EmpMobileNo.:" + obj1.getEmpMobileNo()
        + " EmpDateJoined:" + obj1.getEmpDateJoined() + " EmpDept:" + obj1.getEmpDept()
        + " EmpLeaveAvail:" + obj1.getEmpLeaveAvail() + " EmpMgrId:" + obj1.getEmpMgrId();

    assertEquals(s1, obj1.toString());

  }

  /**
   * setup method.
   */

  @Before
  public void initInput() {

  }
/**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list();
        result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }

  /**
  * To test that a list with some employees is handled correctly.
  * @param dao mocking dao class.
  * @throws ParseException throws.
  */

  public final void testListAllSome(@Mocked final EmployeeDAO dao) throws ParseException {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    new Expectations() {
          {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ArrayList<Employee> es = new ArrayList<Employee>();
            es.add(new Employee(1000, "Rashmi", "gaurijadhav007@gmail.com", 8451915505L,
                    sdf.parse("2018-10-01"), "java", 24, 2000));
            es.add(new Employee(2000, "Shyam", "shyamgore@gmail.com", 9819497292L,
                    sdf.parse("2018-09-20"), "DotNet", 10, 1000));
            es.add(new Employee(3000, "sonal", "sonalsurya@gmail.com", 9833624402L,
                    sdf.parse("2018-04-13"), "Angular", 19, 1000));
            dao.list();
            result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1000, "Rashmi", "gaurijadhav007@gmail.com", 8451915505L,
                    sd.parse("2018-10-01"), "java", 24, 2000), es[0]);
    assertEquals(new Employee(2000, "Shyam", "shyamgore@gmail.com", 9819497292L,
                    sd.parse("2018-09-20"), "DotNet", 10, 1000), es[1]);
    assertEquals(new Employee(3000, "sonal", "sonalsurya@gmail.com", 9833624402L,
                    sd.parse("2018-04-13"), "Angular", 19, 1000), es[2]);
  }


/**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws.
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e1 = new Employee(2000, "Shyam", "shyamgore@gmail.com", 9819497292L,
                    sdf.parse("2018-09-20"), "DotNet", 10, 1000);
    new Expectations() {
      {
        dao.find(2000);
        result = e1;
        dao.find(-1);
        result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };

    Employee e = Employee.listById(2000);
    assertEquals(e1, e);

    e = Employee.listById(-1);
    assertNull(e);
  }

  /**
  * test for increment function.
  * @param dao mocking the dao class.
  * @throws ParseException throws.
   */
  @Test
  public final void testIncrement(@Mocked final EmployeeDAO dao) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e1 = new Employee(1, "Shyam", "shyamgore@gmail.com", 9819497292L,
                    sdf.parse("2018-09-20"), "DotNet", 2, 3);
    new Expectations() {
      {
        dao.increment(1, 2);
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    String res = Employee.increment(1, 2);
    assertEquals("Leave Balance Updated", res);
  }
}
