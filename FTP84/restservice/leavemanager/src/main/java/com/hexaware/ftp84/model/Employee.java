package com.hexaware.ftp84.model;

import com.hexaware.ftp84.persistence.DbConnection;
import com.hexaware.ftp84.persistence.EmployeeDAO;

import java.util.Date;
import java.util.Objects;
import java.util.List;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   * empFullName to store the employee FullName.
   * empEmailId to store the employee Email.
   * empMobileNo to store the employee Mobile number.
   * empDateJoined to store the Date of Joining.
   * empleaveAvail to store the available Leave Balance.
   * empMgrId to store the manager Id.
   */

  private int empid;
  private String empFullName;
  private String empEmailId;
  private long empMobileNo;
  private Date empDateJoined;
  private String empDept;
  private int empLeaveAvail;
  private int empMgrId;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empid, emp.empid)
        && Objects.equals(empFullName, emp.empFullName)
        && Objects.equals(empEmailId, emp.empEmailId)
        && Objects.equals(empMobileNo, emp.empMobileNo)
        && Objects.equals(empDateJoined, emp.empDateJoined)
        && Objects.equals(empDept, emp.empDept)
        && Objects.equals(empLeaveAvail, emp.empLeaveAvail)
        && Objects.equals(empMgrId, emp.empMgrId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empFullName, empEmailId, empMobileNo, empDateJoined, empDept, empLeaveAvail, empMgrId);
  }

  @Override
  public final String toString() {
    return "empId:" + empId + " EmpFullName:" + empFullName + " EmpEmailId:" + empEmailId
            + " EmpMobileNo.:" + empMobileNo + " EmpDateJoined:" + empDateJoined
            + " EmpDept:" + empDept + " EmpLeaveAvail:" + empLeaveAvail
            + " EmpMgrId:" + empMgrId;

  }

  /**
   * Default Constructor for Employee.
   */
  public Employee() {

  }
  /**
   * @param argempId to initialize emp id.
   * @param argEmpFullName to initialize emp Full name.
   * @param argEmpEmailId to initialize emp email id.
   * @param argEmpMobileNo to initialize emp Mobile Number.
   * @param argEmpDateJoined to initailize the Joining date.
   * @param argEmpDept to initialize the emp Department.
   * @param argEmpLeaveAvail to initialize the Leave left.
   * @param argEmpMgrId to initialize themanager Id.
   */
  public Employee(final int argempId, final String argEmpFullName,
        final String argEmpEmailId, final long argEmpMobileNo,
        final Date argEmpDateJoined, final String argEmpDept,
        final int argEmpLeaveAvail,
        final int argEmpMgrId) {
    this.empId = argempId;
    this.empFullName = argEmpFullName;
    this.empEmailId = argEmpEmailId;
    this.empMobileNo = argEmpMobileNo;
    this.empDateJoined = argEmpDateJoined;
    this.empDept = argEmpDept;
    this.empLeaveAvail = argEmpLeaveAvail;
    this.empMgrId = argEmpMgrId;
  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getempId() {
    return empId;
  }

  /**
   *
   * @param argempId to set employee id.
   */
  public final void setempId(final int argempId) {
    this.empId = argempId;
  }

  /**
   *
   * @param argEmpName to set employee Name.
   */
  public final void setEmpName(final String argEmpName) {
    this.empFullName = argEmpName;
  }

  /**
   * Gets the EmpName.
   * @return this Employee's FullName.
   */
  public final String getEmpName() {
    return empFullName;
  }

  /**
   *  Gets the EmpEmail.
   *  @return this Employee's Email.
   */
  public final String getEmpEmailId() {
    return empEmailId;
  }
  /**
   *
   * @param argEmpEmail to set Employee Email.
   */
  public final void setEmpEmailId(final String argEmpEmail) {
    this.empEmailId = argEmpEmail;
  }

  /**
   * Gets the Employee MobileNo.
   * @return the Employee MobileNumber.
   */
  public final long getEmpMobileNo() {
    return empMobileNo;
  }

  /**
   *
   * @param argMobileNo to set Employee MobileNo.
   */
  public final void setEmpMobileNo(final long argMobileNo) {
    this.empMobileNo = argMobileNo;
  }

  /**
   * Gets the Emp date Joined.
   * @return the Date Joined.
   */
  public final Date getEmpDateJoined() {
    return empDateJoined;
  }

  /**
   *
   * @param argDateJoined to set Employee Date of Joining.
   */
  public final void setEmpDateJoined(final Date argDateJoined) {
    this.empDateJoined = argDateJoined;
  }

  /**
   * Gets the Emp Dept Joined.
   * @return the Emp Dept.
   */
  public final String getEmpDept() {
    return empDept;
  }

  /**
   *
   * @param argDept to set Employee Department.
   */
  public final void setEmpDept(final String argDept) {
    this.empDept = argDept;
  }

  /**
   * Gets the Emp Leave balance.
   * @return the Emp leave balance.
   */
  public final int getEmpLeaveAvail() {
    return empLeaveAvail;
  }

  /**
   *
   * @param argempLeaveAvail to set Employee Leave balance.
   */
  public final void setEmpLeaveAvail(final int argempLeaveAvail) {
    this.empLeaveAvail = argempLeaveAvail;
  }

  /**
   * Gets the Emp Manager Id.
   * @return the Emp Manager Id.
   */
  public final int getEmpMgrId() {
    return empMgrId;
  }

  /**
   *
   * @param argMgrId to set Employee manager Id.
   */
  public final void setEmpMgrId(final int argMgrId) {
    this.empMgrId = argMgrId;
  }


  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details.
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empId id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empId) {
    return dao().find(empId);
  }

  /**
   * Update employee LeaveBalance.
   * @param empId id to get employee id.
   * @param leavenoofdays to get employee leavenoofdays.
   * @return String.
   */
  public static String increment(final int empId, final int leavenoofdays) {
    dao().increment(empId, leavenoofdays);
    return "Leave Balance Updated";
  }



}
