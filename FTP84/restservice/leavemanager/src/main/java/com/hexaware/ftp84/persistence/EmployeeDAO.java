package com.hexaware.ftp84.persistence;

import com.hexaware.ftp84.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM employee_details")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM employee_details WHERE EMP_ID = :empId")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empId") int empId);

  /**
   * Updated LeaveBalnce after Rejection for selected employee.
   * @param empId the id of the employee.
   * @param noOfDays for Leave Table of employee.

   */
  @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_LAVAILBAL = EMP_LAVAILBAL + :noOfDays WHERE EMP_ID = :empId")
  void increment(@Bind("empId") int empId, @Bind("noOfDays") int noOfDays);

   /**
   * Update LeaveBalance for selected employee.
   * @param empId the id of the employee.
   * @param noOfDays no of days employee applied leave.
   */
  @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_LAVAILBAL = :noOfDays WHERE EMP_ID = :empId")
  void decrement(@Bind("empId") int empId, @Bind("noOfDays") int noOfDays);

  /**
   * Updated LeaveBalnce after Rejection for selected employee.
   * @param empID the id of the employee.
   * @param noOfDays for Leave Table of employee.

   */
  @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_LAVAILBAL = EMP_LAVAILBAL + :noOfDays WHERE EMP_ID = :empID")
  void increment(@Bind("empID") int empID, @Bind("noOfDays") int noOfDays);

   /**
   * Update LeaveBalance for selected employee.
   * @param empID the id of the employee.
   * @param noOfDays no of days employee applied leave.
   */
  @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_LAVAILBAL = :noOfDays WHERE EMP_ID = :empID")
  void decrement(@Bind("empID") int empID, @Bind("noOfDays") int noOfDays);

  /**
  * close with no args is used to close the connection.
  */
  void close();
}
