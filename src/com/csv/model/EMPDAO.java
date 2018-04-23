package com.csv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EMPDAO implements EMP_interface{

	private static final String GET_ALL_STMT = "SELECT * FROM emp2";
	
	@Override
	public List<EmpVO> getAll(Connection conn) {

		List<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO empVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				empVO = new EmpVO();
				empVO.setEmpno(rs.getInt("empno"));
				empVO.setEname(rs.getString("ename"));
				empVO.setJob(rs.getString("job"));
				empVO.setHiredate(rs.getDate("hiredate"));
				empVO.setSal(rs.getInt("sal"));
				empVO.setComm(rs.getInt("comm"));
				empVO.setDeptno(rs.getInt("deptno"));

				list.add(empVO);

			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return list;
	}

}
