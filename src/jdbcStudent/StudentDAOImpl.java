package jdbcStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.DatabaseConnection;

public class StudentDAOImpl implements DAO {

	private Connection conn;
	private PreparedStatement pst;
	private String query;

	public StudentDAOImpl() {
		// DB Connection class 생성(싱글톤) 연결
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}

	@Override
	public Student selectStudent(int sno) {
		System.out.println("student DAOImpl success!!");
		query = "select * from student where sno = ?";

		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, sno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Student s = new Student(rs.getInt("sno"), rs.getString("sname"), rs.getString("birth"),
						rs.getString("phone"), rs.getString("address"), rs.getString("regdate"));
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Student> selectList() {
		System.out.println("list DAOImpl success!!");
		query = "select * from student order by sno desc";
		List<Student> list = new ArrayList<Student>();

		try {
			pst = conn.prepareStatement(query);
			// executeQuery(); ResultSet으로 리턴
			ResultSet rs = pst.executeQuery();

			// ResultSet을 List로 변환
			while (rs.next()) {
				// 생성자에 두 개의 인자를 전달하여 생성
				list.add(new Student(rs.getInt("sno"), rs.getString("sname")));
			}
			return list;

		} catch (SQLException e) {
			System.out.println("list error");
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int insert(Student s) {
		System.out.println("insert DAOImpl success!!");
		query = "insert into student(sname, birth, phone, address) values (?, ?, ?, ?)";

		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, s.getSname());
			pst.setString(2, s.getBirth());
			pst.setString(3, s.getPhone());
			pst.setString(4, s.getAddress());

			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert error");
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(Student s) {
		System.out.println("insert DAOImpl success!!");
		query = "update student set phone=?, address=?, regdate=now() where sno=?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, s.getPhone());
			pst.setString(2, s.getAddress());
			pst.setInt(3, s.getSno());
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("update error");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(int sno) {
		System.out.println("delete DAOImpl success!!");
		query = "delete from student where sno=?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, sno);
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("delete error");
			e.printStackTrace();
		}
		
		return 0;
	}

}
