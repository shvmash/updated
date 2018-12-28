package com.hexaware.ftp84.util;
import java.util.Scanner;

import com.hexaware.ftp84.model.Employee;
import com.hexaware.ftp84.model.LeaveDetails;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply Leave");
    System.out.println("4. Pending Leaves");
    System.out.println("5. Approve/Deny");
    System.out.println("6. Leave History");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        applyLeave();
        break;
      case 4:
        pendingLeaves();
        break;
      case 5:
        approveDeny();
        break;
      case 6:
        leaveHistory();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1, 2 or 3");
    }
    mainMenu();
  }

  private void leaveHistory() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    LeaveDetails[] leave = LeaveDetails.leaveHis(empId);
    for (LeaveDetails e : leave) {
      System.out.println(e.getempId() + "  "
          + e.getLeaveId() + "  "
          + e.getLeaveNoOfDays() + "  "
          + e.getStartDate() + "  "
          + e.getEndDate() + "  "
          + e.getLeaveReason() + "  "
          + e.getLeaveAppliedOn() + "  "
          + e.getLeaveStatus() + "  "
          + e.getLeaveType());
    }
  }

  private void pendingLeaves() {
    int mgrId;
    System.out.println("Enter ManagerId ");
    mgrId = Integer.parseInt(option.next());
    LeaveDetails[] pending = LeaveDetails.listPending(mgrId);
    for (LeaveDetails e : pending) {
      System.out.println(e.getempId() + "  "
          + e.getLeaveId() + "  "
          + e.getLeaveNoOfDays() + "  "
          + e.getStartDate() + "  "
          + e.getEndDate() + "  "
          + e.getLeaveReason() + "  "
          + e.getLeaveAppliedOn());
    }
  }

  /**
  * For Approval and Denial.
  */
  public static void approveDeny() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a leave ID:");
    int leaveId = sc.nextInt();
    System.out.println("Enter a Manager ID:");
    int empId = sc.nextInt();
    System.out.println("Approve (APPROVED/DENIED):");
    String ch = sc.next();
    ch = ch.toUpperCase().trim();
    System.out.println("Manager Comments  ");
    String mgrCom = sc.next();
    // try {
    String res = LeaveDetails.approveDeny(leaveId, ch, mgrCom, empId);
    System.out.println(res);
    // } catch (ParseException e) {
    //   System.out.println("bhagoooo");
    // } catch (NullPointerException ae) {
    //   System.out.println("ok");
    // }
  }


  private void applyLeave() {
    int empId = 0;
    while (true) {
      System.out.println("Enter an Employee Id  ");
      String empid = option.next();
      try {
        empId = Integer.parseInt(empid);
        Employee.listById(empId).getempId();
        break;
      } catch (NumberFormatException nfe) {
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("-----Please enter correct employee id-----");
        System.out.println("------------------------------------------");
      } catch (NullPointerException e) {
        System.out.println();
        System.out.println("-------------No such employee-------------");
        System.out.println("------------------------------------------");
        System.out.println("-----Please enter correct employee id-----");
        System.out.println("------------------------------------------");
      }
    }
    String endDate = null;
    String startDate = null;
    while (true) {
      try {
        System.out.println("Enter StartDate of your leave (yyyy-MM-dd) ");
        startDate = option.next();
        SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
        sdfrmt.setLenient(false);
        sdfrmt.parse(startDate);
        System.out.println("Enter EndDate of your leave (yyyy-MM-dd) ");
        endDate = option.next();
        SimpleDateFormat sdfrm = new SimpleDateFormat("yyyy-MM-dd");
        sdfrm.setLenient(false);
        sdfrm.parse(endDate);
        break;
      } catch (ParseException ex) {
        System.out.println("----------------------------------------");
        System.out.println("Please enter date in correct date format");
        System.out.println("----------------------------------------");
      }
    }
    System.out.println("Enter No of Leave days ");
    int leavenoofdays = Integer.parseInt(option.next());
    System.out.println("Enter leave type : EL, SL, PL ");
    String leatype = option.next();
    option.nextLine();
    System.out.println("Enter leave reason");
    String leavereason = option.nextLine();
    String res = null;
    try {
      res = LeaveDetails.insertLeaveDetails(empId, leavenoofdays, startDate, endDate,
          leatype, leavereason);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
    }
    System.out.println(res);
  }


  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = 0;
    option.nextLine();
    String s = option.next();
    try {
      empId = Integer.parseInt(s);
      Employee employee = Employee.listById(empId);
      if (employee == null) {
        System.out.println("Sorry, No such employee");
      } else {
        System.out.println(employee.getempId() + " "
              + employee.getEmpName() + " " + employee.getEmpEmailId() + " "
              + employee.getEmpMobileNo() + " " + employee.getEmpDateJoined()
              + " " + employee.getEmpDept() + " " + employee.getEmpLeaveAvail()
              + " " + employee.getEmpMgrId());
      }
    } catch (NumberFormatException e) {
      System.out.println("--------------------------------");
      System.out.println("Please enter correct employee id");
      System.out.println("--------------------------------");
      listEmployeeDetail();
    }
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(e.getempId() + "  "
          + e.getEmpName() + "  "
          + e.getEmpEmailId() + "  "
          + e.getEmpMobileNo() + "  "
          + e.getEmpDateJoined() + "  "
          + e.getEmpDept() + "  "
          + e.getEmpMgrId() + "  "
          + e.getEmpLeaveAvail());
    }
  }
  /**
   * The main entry point.
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
