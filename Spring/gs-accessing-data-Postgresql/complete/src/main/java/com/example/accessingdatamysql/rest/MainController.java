package com.example.accessingdatamysql.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.accessingdatamysql.dbservices.UserRepository;
import com.example.accessingdatamysql.domainobject.Erabiltzailea;

import javax.validation.*;

@RestController
@RequestMapping("/demo")
// @CrossOrigin(origins = "*")
public class MainController {
  @Autowired
  private UserRepository userRepository;

  @PostMapping(path = "/add")
  public String addNewUser(@RequestParam String name, @RequestParam String email) {
    Erabiltzailea n = new Erabiltzailea();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping(path = "/all")
  public Iterable<Erabiltzailea> getAllUsers() {
    return userRepository.findAll();
  }

  @PutMapping(path = "/update/{userId}")
  public ResponseEntity<?> updateUser(@Valid @RequestBody Erabiltzailea user, @PathVariable int userId) {
    try {
      user.setId(userId);
      userRepository.save(user);

      return ResponseEntity.ok().build();

    } catch (Exception ex) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity deleteUserById(@PathVariable int userId) {
    try {
      userRepository.deleteById(userId);
      return ResponseEntity.ok().build();
    } catch (Exception ex) {
      System.out.println("Errorea " + userId + " userra ezabatzerakoan. ");
      return ResponseEntity.notFound().build();
    }
  }

}
