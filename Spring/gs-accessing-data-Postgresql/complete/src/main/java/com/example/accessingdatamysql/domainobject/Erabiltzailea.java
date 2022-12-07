package com.example.accessingdatamysql.domainobject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity // This tells Hibernate to make a table out of this class
public class Erabiltzailea {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "Name")
  private String name;

  @Column(name = "Email")
  private String email;

  @OneToMany( cascade = CascadeType.ALL, mappedBy = "erabiltzaile" )
  private List<Session> sessions = new ArrayList<>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
