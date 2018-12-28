package com.hexaware.ftp84.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp84.model.LeaveDetails;
import com.hexaware.ftp84.model.LeaveStatus;
import com.hexaware.ftp84.model.LeaveType;
/**
 * Mapper class to map from result set to employee object.
 */
public class LeaveMapper implements ResultSetMapper<LeaveDetails> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final LeaveDetails map(final int idx, final ResultSet rs,
        final      StatementContext ctx) throws SQLException {
    String s1 = rs.getString("LEA_STATUS");
    LeaveStatus ls1 = LeaveStatus.valueOf(s1);

    String s2 = rs.getString("LEA_LEAVETYPE");
    LeaveType lt1 = LeaveType.valueOf(s2);
    /**
     * @return LeaveDetails
     */
    return new LeaveDetails(rs.getInt("EMP_ID"),
              rs.getInt("LEA_ID"),
              rs.getInt("LEA_NOOFDAYS"),
              rs.getDate("LEA_STARTDATE"),
              rs.getDate("LEA_ENDDATE"),
              rs.getString("LEA_REASON"),
              rs.getDate("LEA_APPLIEDON"),
              rs.getString("LEA_MGRCOMMENTS"),
              ls1, lt1);


  }
}
