package jdbcStudent;

import java.util.List;

public interface DAO {

	List<Student> selectList();

	int insert(Student s);

	Student selectStudent(int sno);

	int update(Student s);

	int delete(int sno);

}
