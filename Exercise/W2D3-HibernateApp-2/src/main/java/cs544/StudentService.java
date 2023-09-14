package cs544;

import jakarta.persistence.EntityManager;

public class StudentService {
	private StudentDAO studentdao;
private static final EntityManager em=EntityManagerHelper.getCurrent();
	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		em.getTransaction().begin();
		Student student= studentdao.load(studentid);
		student.getCourselist();
		em.getTransaction().commit();
		//em.close(); /*** Closing entitymanager throws exception in view ****/
		return student;
	}
}
