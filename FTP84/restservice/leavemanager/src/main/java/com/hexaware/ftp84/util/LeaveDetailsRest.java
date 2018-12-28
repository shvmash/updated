package com.hexaware.ftp84.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import com.hexaware.ftp84.model.LeaveDetails;
import java.text.ParseException;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/leaves")
public class LeaveDetailsRest {

  /**
   * Returns a list of all the employees leaves.
   * @return a list of all the employees leaves.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] employeesleavList() {
    System.out.println("Employees leaves List");
    final LeaveDetails[] leaves = LeaveDetails.listAll();
    return leaves;
  }

  /**
   * Returns a specific employee's leave details.
   * @param lid the leave id of the employee
   * @return the employee leave details
   */
  @GET
  @Path("/leaid/{lid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails leaveListById(@PathParam("lid") final int lid) {
    final LeaveDetails lea = LeaveDetails.listById(lid);
    if (lea == null) {
      throw new NotFoundException("No such leave ID: " + lid);
    }
    return lea;
  }

  /**
   * Returns a history of all the employees leaves.
   * @param i the empId of employee.
   * @return a history of all the employees leaves.
   */
  @GET
  @Path("/leahis/{i}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leavhisList(@PathParam("i") final int i) {
    final LeaveDetails[] his = LeaveDetails.leaveHis(i);
    return his;
  }

/**
   * Returns a pending leaves.
   * @param i the mgrid of employee.
   * @return a pending leaves.
   */
  @GET
  @Path("/leapend/{i}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leavpenList(@PathParam("i") final int i) {
    final LeaveDetails[] pend = LeaveDetails.listPending(i);
    return pend;
  }

/**
   * Returns a result of apply leaves.
   * @param ld leave details.
   * @param empId employee id.
   * @return a pending leaves.
   * @throws ParseException throws.
   */
  @POST
  @Path("/apply/{empId}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final String applyleave(@PathParam("empId") final int empId, final LeaveDetails ld) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String leatype = ld.getLeaveType().toString();
    String result = LeaveDetails.insertLeaveDetails(empId, ld.getLeaveNoOfDays(),
          sdf.format(ld.getStartDate()), sdf.format(ld.getEndDate()), leatype, ld.getLeaveReason());
    return result;
  }


/**
   * Returns a result of leaves.
   * @param ld leave details.
   * @param leaId leave id.
   * @return a approve deny status.
   */
  @POST
  @Path("/appdeny/{leaId}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final String apprdeny(@PathParam("leaId") final int leaId, final LeaveDetails ld) {
    String leavstatus = ld.getLeaveStatus().toString();
    String status = null;
    String result = null;
    if (leavstatus == "APPROVED") {
      status = "APPROVED";
    } else {
      status = "DENIED";
    }
    // try {
    result = LeaveDetails.approveDeny(leaId, status, ld.getMgrComments(), ld.getempId());
    // } catch (ParseException e) {
    //   System.out.println("bhago");
    // }
    return result;
  }
}
