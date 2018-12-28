package com.hexaware.ftp84.persistence;

import com.hexaware.ftp84.model.LeaveDetails;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;


/**
 * The DAO class for LeaveDetails.
 */
public interface LeaveDAO  {
  /**
   * return all the details of all the LeaveDetailss.
   * @return the LeaveDetails array
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS")
  @Mapper(LeaveMapper.class)
  List<LeaveDetails> list();

  /**
   * return all the details of the selected LeaveDetails.
   * @param leaveid the id of the LeaveDetails
   * @return the LeaveDetails object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEA_ID = :leaveid")
  @Mapper(LeaveMapper.class)
  LeaveDetails find(@Bind("leaveid") int leaveid);

  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @param startDate leaveStartDate of employee
   * @param endDate leaveEndDate of employee.
   * @return the total record count
   */
  @SqlQuery("SELECT COUNT(*) FROM LEAVE_DETAILS "
      +    " WHERE EMP_ID = :empId AND (LEA_STARTDATE BETWEEN :startdate AND :enddate "
      +    " OR LEA_ENDDATE BETWEEN :startdate AND :enddate )"
      )
  int count(@Bind("empId") int empId, @Bind("startdate") String startDate,
      @Bind("enddate") String endDate);

  /**
   * return all the details of the Leave History.
   * @param empId the id of the EmployeeDetails.
   * @return the LeaveDetails object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empId")
  @Mapper(LeaveMapper.class)
  List<LeaveDetails> empHistory(@Bind("empId") int empId);

  /**
   * @param mgrComments Updated Manager Response data.
   * @param leavStatus Updated Manager Status data.
   * @param leaveid the id of the LeaveDetails
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEA_MGRCOMMENTS = :mgrComments, LEA_STATUS = :leavStatus WHERE "
      + "LEA_ID = :leaveid")
  void comment(@Bind("mgrComments") String mgrComments, @Bind("leavStatus") String leavStatus,
      @Bind("leaveid") int leaveid);


/**
 * insert all the details of the employee leave.
 * @param empId the employee id of the employee.
 * @param leavenoofdays the number of days of the employee.
 * @param startdate the start date of the employee.
 * @param enddate the end date of the employee.
 * @param leavereason the reason for applying.
 * @param leaveappliedon the applied date of the employee.
 * @param leastatus the leaveType details of employee.
 * @param leatype the LeaveStatus details of employee.
 */

  @SqlUpdate("INSERT INTO LEAVE_DETAILS "
        +
        "            (EMP_ID, "
        +
        "            LEA_NOOFDAYS, "
        +
        "            LEA_STARTDATE, "
        +
        "            LEA_ENDDATE, "
        +
        "            LEA_REASON, "
        +
        "            LEA_APPLIEDON, "
        +
        "            LEA_STATUS, "
        +
        "            LEA_LEAVETYPE )"
        +
        "values      ( "
        +
        "              :empId, "
        +
        "              :leavenoofdays, "
        +
        "              :startdate, "
        +
        "              :enddate, "
        +
        "              :leavereason, "
        +
        "              :leaveappliedon, "
        +
        "              :leastatus, "
        +
        "              :leatype)")

  void insert(@Bind("empId") int empId,
              @Bind("leavenoofdays") int leavenoofdays,
              @Bind("startdate") String startdate,
              @Bind("enddate") String enddate,
              @Bind("leavereason") String leavereason,
              @Bind("leaveappliedon") String leaveappliedon,
              @Bind("leastatus") String leastatus,
              @Bind("leatype") String leatype);

  /**
   * return all the details of the Pending LeaveDetails.
   * @param empid the id of the LeaveDetails
   * @return the LeaveDetails Array object
   */

  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID IN "
      + " (SELECT E2.EMP_ID FROM "
      + " EMPLOYEE_DETAILS E1 INNER JOIN "
      + " EMPLOYEE_DETAILS E2 ON E1.EMP_ID = E2.EMP_MGRID  WHERE E1.EMP_ID=:empid) AND "
      + " LEA_STATUS='PENDING'")
  @Mapper(LeaveMapper.class)
  List<LeaveDetails> pending(@Bind("empid") int empid);



  /**
   * @param leaveid the id of the LeaveDetails
   * @return returns the manager id.
   */
  @SqlQuery("SELECT E1.EMP_ID FROM EMPLOYEE_DETAILS E1 "
      + " JOIN EMPLOYEE_DETAILS E2 ON E1.EMP_ID = E2.EMP_MGRID "
      + " WHERE E2.EMP_ID = (SELECT EMP_ID FROM LEAVE_DETAILS WHERE LEA_ID = :leaveid)")
  int manager(@Bind("leaveid") int leaveid);
  /**
  * close with no args is used to close the connection.
  */
  void close();
}
