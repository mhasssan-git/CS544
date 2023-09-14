package cs544;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.*;
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class StudentDAO {
   @PersistenceContext
    private EntityManager em ;
    public Student load(long studentid) {

        //EntityGraph<Student> graph = em.createEntityGraph(Student.class);
        //graph.addAttributeNodes("courselist");
        //Map<String, Object> hints = new HashMap<String,Object>();
        //hints.put("javax.persistence.fetchgraph", graph);
        return em.find(Student.class, studentid);
    }
}
