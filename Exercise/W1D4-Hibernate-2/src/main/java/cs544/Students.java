package cs544;

import java.sql.*;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "cs544.Students")
@Table(name = "students")
public class Students {

  public Students(Integer id, String name, String email, String password) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  @Id
  @Column(name = "\"id\"", nullable = false)
  private Integer id;
  @Column(name = "\"name\"", nullable = true)
  private String name;
  @Column(name = "\"email\"", nullable = true)
  private String email;
  @Column(name = "\"password\"", nullable = true)
  private String password;

  public Students() {

  }
}