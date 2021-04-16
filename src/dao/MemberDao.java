package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

public class MemberDao {
	
	private static MemberDao dao = new MemberDao();
	
	private MemberDao() {
		DBConnection.initConnection();
	}

	public static MemberDao getInstance() {
		return dao;	//싱글톤 사용
	}
	
	
	public boolean addMember(MemberDto dto) {
		
		String sql = " INSERT INTO EMPLOYEE(EMPID, NAME, AGE, BIRTH, PHONENUM, SALARY, DEPTID) "
				+ 	 " VALUES(EMP_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?) "; 
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
		conn = DBConnection.getConnection();
		System.out.println(dto.toString());
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, dto.getName());
		psmt.setInt(2, dto.getAge());
		psmt.setString(3, dto.getBirth());
		psmt.setString(4, dto.getPhoneNum());
		psmt.setInt(5, dto.getSalary());
		psmt.setString(6, dto.getDeptID());
		
		count = psmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("addMember fail");
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		return count > 0 ? true:false;
		
	}
	
	
	public boolean deleteMember(int empID) {
			
		String sql = " DELETE FROM EMPLOYEE "
				+	 " WHERE EMPID=? "; 
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
		conn = DBConnection.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, empID);
		
		count = psmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deleteMember fail");
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		return count > 0 ? true:false;
	}
	
	
	
	public MemberDto getMember(int empID) {
		
		String sql = " SELECT * FROM EMPLOYEE "
				+ 	 " WHERE EMPID=? ";
		
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		MemberDto dto = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empID);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDto(rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7));
			}
			
			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("getMember fail");
			} finally {
				DBClose.close(conn, psmt, rs);
			}
			
			return dto;
	}
	
	
	
	public boolean updateMember(MemberDto dto) {
		
		String sql = " UPDATE EMPLOYEE "
				+	 " SET "
				+ 	 " NAME=?, AGE=?, BIRTH=?, PHONENUM=?, SALARY=?, DEPTID=? "
				+ 	 " WHERE EMPID=? "; 
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
		conn = DBConnection.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, dto.getName());
		psmt.setInt(2, dto.getAge());
		psmt.setString(3, dto.getBirth());
		psmt.setString(4, dto.getPhoneNum());
		psmt.setInt(5, dto.getSalary());
		psmt.setString(6, dto.getDeptID());
		psmt.setInt(7, dto.getEmpID());
		
		count = psmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateMember fail");
		} finally {
			DBClose.close(conn, psmt, null);
		}
		
		return count > 0 ? true:false;
	}
	
	
	public List<MemberDto> getAllMember() {
		String sql = " SELECT * "
				+    " FROM EMPLOYEE "
				+    " ORDER BY EMPID ASC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MemberDto dto = new MemberDto(rs.getInt(1),
												rs.getString(2),
												rs.getInt(3),
												rs.getString(4),
												rs.getString(5),
												rs.getInt(6),
												rs.getString(7));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("getBbsList fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return list;		
	}
	
	
	
	
	

}
