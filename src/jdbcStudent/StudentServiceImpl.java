package jdbcStudent;

import java.util.List;

public class StudentServiceImpl implements Service{
	
	private DAO dao;
	public StudentServiceImpl() {
		dao = new StudentDAOImpl();
	}
	

	@Override
	public int insert(Student s) {
		System.out.println("학생등록 ServiceImpl success!!");
		return dao.insert(s);
	}

	@Override
	public List<Student> getList() {
		System.out.println("학생리스트 ServiceImpl success!!");
		return dao.selectList();
	}


	@Override
	public Student getStudent(int sno) {
		System.out.println("학생검색 ServiceImpl success!!");
		return dao.selectStudent(sno);
	}


	@Override
	public int update(Student s) {
		System.out.println("내정보수정 ServiceImpl success!!");
		return dao.update(s);
	}


	@Override
	public int delete(int sno) {
		System.out.println("학생삭제 ServiceImpl success!!");
		return dao.delete(sno);
	}
	
	

}
