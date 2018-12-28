package com.hexaware.ftp84.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Date;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "ftp84");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

class Employee {
   
     /**
   * empId to store employee id.
   * empFullName to store the employee FullName.
   * empEmailId to store the employee Email.
   * empMobileNo to store the employee Mobile number.
   * empDateJoined to store the Date of Joining.
   * empleaveAvail to store the available Leave Balance.
   * empMgrId to store the manager Id.
   */

  private int empId;
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
    if (Objects.equals(empId, emp.empId)
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

    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
}

enum LeaveStatus {
      /**
     * Approved FOR approved.
    */
     APPROVED,

     /**
     * Pending for pending.
    */
     PENDING,

     /**
     * Denied for denied.
    */
     DENIED
}


enum LeaveType {
  /**
     * Earned for EL.
     */
    EL,

    /**
     * Earned for SL.
     */
     SL,

     /**
      * Earned for PL.
      */
     PL
}

class LeaveDetails {
  /**
   * empId to store employee id.
   */
  private int empId;
  /**
   * empId to store employee leaveid.
   */
  private int leaveid;
  /**
   * empId to store employee no of leave days.
   */
  private int leavenoofdays;
  /**
   * empId to store employee leave start date.
   */
  private Date startdate;
  /**
   * empId to store employee leave end date.
   */
  private Date enddate;
  /**
   * empId to store employee leave reason.
   */
  private String leavereason;
  /**
   * empId to store employee applied date.
   */
  private Date leaveappliedon;
  /**
   * empId to store employee manager comments.
   */
  private String mgrcomments;
  /**
   * empId to store employee Leave Status.
   */
  private LeaveStatus leastatus;
  /**
   * empId to store employee Leave Type.
   */
  private LeaveType leatype;

  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails ld = (LeaveDetails) obj;
    if (Objects.equals(empId, ld.empId)
        && Objects.equals(leaveid, ld.leaveid)
        && Objects.equals(leavenoofdays, ld.leavenoofdays)
        && Objects.equals(startdate, ld.startdate)
        && Objects.equals(enddate, ld.enddate)
        && Objects.equals(leavereason, ld.leavereason)
        && Objects.equals(leaveappliedon, ld.leaveappliedon)
        && Objects.equals(mgrcomments, ld.mgrcomments)
        && Objects.equals(leastatus, ld.leastatus)
        && Objects.equals(leatype, ld.leatype)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, leaveid, leavenoofdays, startdate, enddate, leavereason,
            leaveappliedon, mgrcomments, leastatus, leatype);
  }

  @Override
  public final String toString() {
    return "Emp ID :" + empId + "Leave ID :" + leaveid
        + "Leave No of Days :" + leavenoofdays
        + "Start Date :" + startdate + "End Date :"
        + enddate + "Leave Reason :" + leavereason
        + "Leave Applied On :" + leaveappliedon
        + "Manager Comments :" + mgrcomments
        + "Leave Status :" + leastatus
        + "Leave Type :" + leatype;
  }
  /**
   * Default Constructor for leave details.
   */
  public LeaveDetails() {

  }
  /**
   * @param argempId to initialize employee id.
   * @param argleaveid to initialize employee leave id.
   * @param argleavenoofdays to initialize employee no of leave days.
   * @param argstartdate to initialize employee startdate.
   * @param argenddate to initialize employee enddate.
   * @param argleavereason to initialize employee leavereason.
   * @param argleaveappliedon to initialize employee leaveappliedon.
   * @param argmgrcomments to initialize employee manager comments.
   * @param argleastatus to initialize employee leave status.
   * @param argleatype to initialize employee leave type.
   */
  public LeaveDetails(final int argempId, final int argleaveid,
        final int argleavenoofdays, final Date argstartdate,
        final Date argenddate,
        final String argleavereason, final Date argleaveappliedon, final String argmgrcomments,
        final LeaveStatus argleastatus, final LeaveType argleatype) {
    this.empId = argempId;
    this.leaveid = argleaveid;
    this.leavenoofdays = argleavenoofdays;
    this.startdate = argstartdate;
    this.enddate = argenddate;
    this.leavereason = argleavereason;
    this.leaveappliedon = argleaveappliedon;
    this.mgrcomments = argmgrcomments;
    this.leastatus = argleastatus;
    this.leatype = argleatype;
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
   * Gets the LeaveId.
   * @return this Employee's leaveID.
   */
  public final int getLeaveId() {
    return leaveid;
  }

  /**
   *
   * @param argleaveid to set employee leaveid.
   */
  public final void setLeaveId(final int argleaveid) {
    this.leaveid = argleaveid;
  }
  /**
   * Gets the Leavenoofdays.
   * @return this Employee's leavenoofdays.
   */
  public final int getLeaveNoOfDays() {
    return leavenoofdays;
  }

  /**
   *
   * @param argleavenoofdays to set employee leavenoofdays.
   */
  public final void setLeaveNoOfDays(final int argleavenoofdays) {
    this.leavenoofdays = argleavenoofdays;
  }
  /**
   * Gets the leave startdate.
   * @return this Employee's leave startdate.
   */
  public final Date getStartDate() {
    return startdate;
  }

  /**
   *
   * @param argstartdate to set employee leave startdate.
   */
  public final void setStartDate(final Date argstartdate) {
    this.startdate = argstartdate;
  }
  /**
   * Gets the enddate.
   * @return this Employee's leave enddate.
   */
  public final Date getEndDate() {
    return enddate;
  }

  /**
   *
   * @param argenddate to set employee leave enddate.
   */
  public final void setEndDate(final Date argenddate) {
    this.enddate = argenddate;
  }
  /**
   * Gets the leavereason.
   * @return this Employee's leavereason.
   */
  public final String getLeaveReason() {
    return leavereason;
  }

  /**
   *
   * @param argleavereason to set employee leavereason.
   */
  public final void setLeaveReason(final String argleavereason) {
    this.leavereason = argleavereason;
  }
  /**
   * Gets the leaveappliedon.
   * @return this Employee's leaveappliedon.
   */
  public final Date getLeaveAppliedOn() {
    return leaveappliedon;
  }

  /**
   *
   * @param argleaveappliedon to set employee leaveappliedon.
   */
  public final void setLeaveAppliedOn(final Date argleaveappliedon) {
    this.leaveappliedon = argleaveappliedon;
  }
  /**
   * Gets the mgrcomments.
   * @return this Employee's manager comments.
   */
  public final String getMgrComments() {
    return mgrcomments;
  }

  /**
   *
   * @param argmgrcomments to set employee's manager comments.
   */
  public final void setMgrComments(final String argmgrcomments) {
    this.mgrcomments = argmgrcomments;
  }

  /**
   * Gets the LeaveStatus.
   * @return this Employee's LeaveStatus.
   */
  public final LeaveStatus getLeaveStatus() {
    return leastatus;
  }

  /**
   *
   * @param argleastatus to set employee's LeaveStatus.
   */
  public final void setLeaveStatus(final LeaveStatus argleastatus) {
    this.leastatus = argleastatus;
  }

  /**
   * Gets the LeaveType.
   * @return this Employee's LeaveType.
   */
  public final LeaveType getLeaveType() {
    return leatype;
  }

  /**
   *
   * @param argleatype to set employee's LeaveStatus.
   */
  public final void setLeaveType(final LeaveType argleatype) {
    this.leatype = argleatype;
  }
}
