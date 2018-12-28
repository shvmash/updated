package com.hexaware.ftp84.model;
import com.hexaware.ftp84.persistence.DbConnection;
import com.hexaware.ftp84.persistence.LeaveDAO;
import com.hexaware.ftp84.persistence.EmployeeDAO;
import java.util.Objects;
import java.util.List;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


  /**
   * LeaveDetails class to store employee leave details.
   * @author hexware
   */
public class LeaveDetails {
  /**
   * empid to store employee id.
   */
  private int empId;
  /**
   * empid to store employee leaveid.
   */
  private int leaveid;
  /**
   * empid to store employee no of leave days.
   */
  private int leavenoofdays;
  /**
   * empid to store employee leave start date.
   */
  private Date startdate;
  /**
   * empid to store employee leave end date.
   */
  private Date enddate;
  /**
   * empid to store employee leave reason.
   */
  private String leavereason;
  /**
   * empid to store employee applied date.
   */
  private Date leaveappliedon;
  /**
   * empid to store employee manager comments.
   */
  private String mgrcomments;
  /**
   * empid to store employee Leave Status.
   */
  private LeaveStatus leastatus;
  /**
   * empid to store employee Leave Type.
   */
  private LeaveType leatype;
  @Override
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

  /**
   * The dao for LeaveDetails.
   */
  private static LeaveDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDAO.class);
  }

  /**
   * The edao for EmployeeDetails.
   */
  private static EmployeeDAO edao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }



  /**
   * list all employee leave details.
   * @return all employees' leave details
   */
  public static LeaveDetails[] listAll() {

    List<LeaveDetails> es = dao().list();
    return es.toArray(new LeaveDetails[es.size()]);
  }


  /**
   * @param leaveid to store leave id.
   * @return to return manager id.
   */
  public static int showManager(final int leaveid) {
    return dao().manager(leaveid);
  }

  /**
   * list all employee leave details.
   * @param mgrId id to get employee leave details.
   * @return all employees' leave details
   */
  public static LeaveDetails[] listPending(final int mgrId) {

    List<LeaveDetails> es = dao().pending(mgrId);
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * list employee leave details by id.
   * @param leaveid id to get employee leave details.
   * @return LeaveDetails
   */
  public static LeaveDetails listById(final int leaveid) {
    return dao().find(leaveid);
  }

  /**
   * No of Overlapping Leaves.
   * @param empId id to get employee details.
   * @param startdate to get Start Date.
   * @param enddate to get End Date.
   * @return count of no of days between leave.
   */
  public static int countNo(final int empId, final String startdate, final String enddate) {
    int count = dao().count(empId, startdate, enddate);
    return count;
  }
  /**
   * No of Overlapping Leaves.
   * @param empId id to get employee details.
   * @return employee's leave history.
   */
  public static LeaveDetails[] leaveHis(final int empId) {
    List<LeaveDetails> es = dao().empHistory(empId);
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * Method for Approve or Deny the Leave.
   * @param leaveId to enter LeaveId to approve/deny.
   * @param leavstatus to enter status to approve/deny.
   * @param mgrcomments to get manager comments.
   * @param mgrlid to get employee id.
   * @return String.
  */
  public static String approveDeny(final int leaveId, final String leavstatus,
            final String mgrcomments, final int mgrlid) {
    LeaveDetails ld = LeaveDetails.listById(leaveId);
    String res = null;
    String dbStatus = String.valueOf(ld.getLeaveStatus());
    int mgrid = ld.showManager(leaveId);
    int empId = ld.getempId();
    if (mgrid == mgrlid && ld != null) {
      int noOfDays = ld.getLeaveNoOfDays();
      if (leavstatus.equals("APPROVED") && dbStatus.equals("PENDING")) {
        dbStatus = "APPROVED";
        System.out.println("status:" + dbStatus);
        res = "Leave approved Successfully";
      } else if (leavstatus.equals("APPROVED") && dbStatus.equals("DENIED")) {
        dbStatus = "APPROVED";
        edao().decrement(empId, noOfDays);
        res = "Leave approved Successfully";
      } else if (leavstatus.equals("DENIED") && dbStatus.equals("PENDING")) {
        dbStatus = "DENIED";
        edao().increment(empId, noOfDays);
        res = "Leave Rejected";
      } else if (leavstatus.equals("DENIED") && dbStatus.equals("APPROVED")) {
        dbStatus = "DENIED";
        edao().increment(empId, noOfDays);
        res = "Leave Rejected";
      }
      dao().comment(mgrcomments, dbStatus, leaveId);
      //}
    }
    return res;
  }

  /**
   * @param empId to initialize employee id.
   * @param leavenoofdays to initialize employee no of leave days.
   * @param startdate to initialize employee startdate.
   * @param enddate to initialize employee enddate.
   * @param leatype to initialize employee leave type.
   * @param leavereason to initialize employee leavereason.
   * @return String message.
   * @throws ParseException throws.
   */
  public static String insertLeaveDetails(final int empId,
        final int leavenoofdays, final String startdate,
        final String enddate, final String leatype,
        final String leavereason)
          throws ParseException {
    Employee employ = Employee.listById(empId);
    String s = null;
    if (employ != null) {
      int mgrNo = employ.getEmpMgrId();
      System.out.println("Manager ID  " + mgrNo);
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Date stDate = sdf.parse(startdate);
      Date enDate = sdf.parse(enddate);
      Calendar startCal = Calendar.getInstance();
      startCal.setTime(stDate);
      Calendar endCal = Calendar.getInstance();
      endCal.setTime(enDate);
      int count = 0;
      if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
        System.out.println(count);
      }
      // if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
      //   startCal.setTime(enDate);
      //   endCal.setTime(stDate);
      // }
      if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
            || startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
        do {
          startCal.add(Calendar.DAY_OF_MONTH, 1);
          if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
              || startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            ++count;
          }
        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis());
      }
      long diff = enDate.getTime() - stDate.getTime();
      long days = diff / (1000 * 60 * 60 * 24);
      Date today = new Date();
      String appliedOn = sdf.format(today);
      days = days + 1;
      long availBal = 0;
      //long dif = 0;
      System.out.println(days);
      long updLeave = 0;
      String leaStatus = null;
     //Employee employee = edao().find(empId);
      int overlap = LeaveDetails.countNo(empId, startdate, enddate);
      availBal = employ.getEmpLeaveAvail();
     // dif = availBal - days;
      System.out.println("Balance Available " + availBal + " " + days);
      updLeave = availBal - days;
      //LeaveDetails ld = new LeaveDetails();
      int leavenoofdays1 = leavenoofdays - count;
      System.out.println("leave is: " + leavenoofdays1);
      System.out.println("leave:" + leavenoofdays);
      if (updLeave <= 0) {
        s = "insufficient leave balance...";
      } else if (overlap > 0) {
        s = "Already applied on given Date...";
      } else if (days <= 0) {
        s = "StartDate must be Greater than EndDate...";
      } else if (stDate.compareTo(today) < 0) {
        s = "start date must be greater or equal to current Sdate...";
      } else if (leavenoofdays != days) {
        s = "No Of Days Should be right";
      } else {
        if (mgrNo == 0) {
          leaStatus = "APPROVED";
          s = "Successfully Approved, no need for Permission";
        } else {
          leaStatus = "PENDING";
          s = "Successfully leave applied for " + (days - count) + " days";
        }
        dao().insert(empId, leavenoofdays1, startdate, enddate, leavereason, appliedOn,
            leaStatus, leatype);
        int bal = (int) updLeave;
        System.out.println(bal);
        edao().decrement(empId, bal + count);
      }
    } else {
      s = "No Such Employ";
    }
    return s;
  }

}
