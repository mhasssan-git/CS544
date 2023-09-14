package cs544;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.*;

public class StudentDAO {

	private Collection<Student> studentlist = new ArrayList<Student>();
	private static final EntityManager em= EntityManagerHelper.getCurrent();
	public StudentDAO() {
	}

	public Student load(long studentid) {
		EntityGraph<Student> graph=em.createEntityGraph(Student.class);
		graph.addSubgraph("courselist");
		Map<String, Object> properties=new HashMap<>();
		properties.put("javax.persistence.fetchgraph",graph);
		return em.find(Student.class,studentid,properties);
	}
}
