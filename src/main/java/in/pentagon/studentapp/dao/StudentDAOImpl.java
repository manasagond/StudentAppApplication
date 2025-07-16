package in.pentagon.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.pentagon.studentapp.Connenction.Connector;
import in.pentagon.studentapp.dto.Student;

public class StudentDAOImpl implements StudentDAO {
	Connection con;
	PreparedStatement ps;
	String querry="INSERT INTO STUDENT VALUES(0,?,?,?,?,?,?,SYSDATE())";
	String querry1="SELECT * FROM STUDENT WHERE MAIL=? AND PASSWORD=?";
	String query = "UPDATE STUDENT SET NAME = ?, PHONE = ?, BRANCH = ?, LOCATION = ? ,MAIL = ?,password=? WHERE ID=?";
	String querry2="UPDATE STUDENT SET PASSWORD=? WHERE MAIL=?";
	public StudentDAOImpl() {
		this.con=Connector.requestConnection();
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean insertStudent(Student s) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			ps=con.prepareStatement(querry);
			ps.setString(1, s.getName());
			ps.setLong(2,s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setString(6, s.getPassword());

			i=ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;
		}

	}

	@Override
	public boolean updateStudent(Student s) {
		// TODO Auto-generated method stub
		int i = 0;

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getBranch());
			ps.setString(4, s.getLoc());
			ps.setString(5, s.getMail());
			ps.setString(6, s.getPassword());
			ps.setInt(7, s.getId());
			i=ps.executeUpdate();



		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		int j=0;
		String querry="DELETE FROM STUDENT WHERE ID=?";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(querry);
			ps.setInt(1, id);
			 j=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(j>0) {
			return true;
		}
		
		else {
			return false;
		}
	}

	@Override
	public Student getStudent(String mail, String password) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		Student s=null;
		try {
			ps=con.prepareStatement(querry1);
			ps.setString(1, mail);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(s!=null) {
			return s;
		}
		else {
			return null;
		}

	}

	@Override
	public Student getStudent(long phone, String mail) {
		// TODO Auto-generated method stub
		Student s=null;
		String querry="SELECT *FROM STUDENT WHERE PHONE=? AND MAIL=?";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(querry);
			ps.setLong(1, phone);
			ps.setString(2, mail);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return s;
	}

	@Override
	public ArrayList<Student> getStudent(Student s) {
		// TODO Auto-generated method s
		PreparedStatement ps=null;
		ArrayList<Student> studentList = new ArrayList<Student>();
		String querry="SELECT * FROM STUDENT";
		try {
			ps=con.prepareStatement(querry);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt("id")!=1) {
					s=new Student();
					//s=new Student();
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setPhone(rs.getLong("phone"));
					s.setMail(rs.getString("mail"));
					s.setBranch(rs.getString("branch"));
					s.setLoc(rs.getString("location"));
					s.setPassword(rs.getString("password"));
					s.setDate(rs.getString("date"));
					studentList.add(s);
				}
			}}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(studentList!=null) {
			return studentList;
		}

		else {
			return null;
		}
	}
	@Override
	public ArrayList<Student> getStudent(String name) {
		// TODO Auto-generated method stub
		ArrayList<Student> students=new ArrayList<Student>();
		String querry="SELECT *FROM STUDENT WHERE NAME=?";
		PreparedStatement ps=null;
		Student s=null;
		try {
			ps=con.prepareStatement(querry);
			
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				//s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}

}
