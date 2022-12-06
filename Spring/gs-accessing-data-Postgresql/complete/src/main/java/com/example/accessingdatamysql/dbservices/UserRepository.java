package com.example.accessingdatamysql.dbservices;

import org.springframework.data.repository.CrudRepository;
import com.example.accessingdatamysql.domainobject.Erabiltzailea;

public interface UserRepository extends CrudRepository<Erabiltzailea, Integer> {

}
