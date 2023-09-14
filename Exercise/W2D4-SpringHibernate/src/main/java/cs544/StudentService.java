package cs544;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StudentService {
	@Resource

	private StudentDAO studentDAO;

	public StudentService() {
		studentDAO = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		return studentDAO.load(studentid);
	}
}
