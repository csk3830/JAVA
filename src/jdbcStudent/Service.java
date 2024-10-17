package jdbcStudent;

import java.util.List;

public interface Service {

	int insert(Student s);

	List<Student> getList();

	Student getStudent(int sno);

	int update(Student s);

	int delete(int sno);

}
