package lab.back_board.controller;

import java.util.List;

import lab.back_board.entity.User;
import lab.back_board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    //전체 조회
    @GetMapping("")
    public ResponseEntity<List<User>> getAllusers(){
        List<User> users = null;
        try {
            users = userService.getAllUsers();

        } catch(Exception e) {
            e.getMessage();
        }

        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    //한 명 조회
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String userId){
        User user = null;
        try{
            user = userService.getUserById(userId);
        } catch (Exception e){
            e.getMessage();
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<User> addUser(@RequestBody User user){

        try {
            userService.updateUser(user);
//            System.out.println(users);
        } catch(Exception e) {
            e.getMessage();
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") String userId){
        User users = null;
        try {
            userService.updateUser(user);
        } catch(Exception e) {
            e.getMessage();
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
