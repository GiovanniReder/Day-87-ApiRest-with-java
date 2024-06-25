package giovanni.springwebapi.entities;

import giovanni.springwebapi.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* METODI CRUD
GET     http://localhost:3001/users
POST    http://localhost:3001/users+(body)
GET     http://localhost:3001/users/{userId}
PUT     http://localhost:3001/users/{userId} (+body)
DELETE  http://localhost:3001/users/{userId}
* */


@RestController
@RequestMapping("/users")
public class UsersController {
@Autowired
private UsersService usersService;
  //  GET     http://localhost:3001/users
@GetMapping
 private   List<User> getAllUsers(){
    return this.usersService.getUserList();
}

//POST    http://localhost:3001/users+(body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
private User saveUser(@RequestBody User body){
        return this.usersService.saveUser(body);
    }


// GET     http://localhost:3001/users/{userId}
    @GetMapping("/{userId}")
    private User findUserById(@PathVariable int userId){

        return this.usersService.findById(userId);
    }

// PUT     http://localhost:3001/users/{userId} (+body)
@PutMapping("/{userId}")
    private User findUserByIdAndUpdate(@PathVariable int userId , @RequestBody User body){
    return this.usersService.findByIdAndUpdate(userId , body);
}


//  DELETE  http://localhost:3001/users/{userId}
@DeleteMapping("/{userId}")
@ResponseStatus(HttpStatus.NO_CONTENT)
    private void findByIdAndDelete(@PathVariable int userId){
    this.usersService.findByIdAndDelete(userId);
}}


