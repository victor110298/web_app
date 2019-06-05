package webapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webapp.dto.User;
import webapp.entity.UserEntity;
import webapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "users")
@PreAuthorize("hasAnyRole('ADMIN')")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        service.createOne(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        service.updateOne(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return service.findAll();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long id, User user) {
        if (service.findOneById(id) != null) {
            service.deleteOneById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {

        User user = (User) service.findOneById(id);
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
