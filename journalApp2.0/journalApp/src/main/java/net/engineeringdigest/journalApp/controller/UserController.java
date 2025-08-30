package net.engineeringdigest.journalApp.controller;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public List<User> getAll(){
        return userService.getAll();
    }

//    @GetMapping("/get")
//    public ResponseEntity<?> getAll(){
//        List<User> all=userService.getAll();
//        if(all != null && all.isEmpty()){
//            return new ResponseEntity<>(all, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @PostMapping("/post")
    public boolean createUser(@RequestBody User user){
        log.info("{}",user);
        userService.saveEntry(user);
        return true;
    }

//    @PostMapping("/post")
//    public ResponseEntity<?> createUser(@RequestBody User user){
//        try{
//            userService.saveEntry(user);
//            return new ResponseEntity<>(user,HttpStatus.OK);
//        }catch (Exception ex){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


//    @PutMapping("/put")
//    public User updateUser(@RequestBody User user){
//        User userInDb= userService.findByUserName(user.getUsername());
//        if(userInDb != null){
//            userInDb.setUsername(userInDb.getUsername());
//            userInDb.setPassword(userInDb.getPassword());
//            userService.saveEntry(userInDb);
//        }
//        return userInDb;
//    }

    @PutMapping("/put/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName){
        User userInDB=userService.findByUserName(userName);
        if (userInDB != null){
            userInDB.setUsername(userInDB.getUsername());
            userInDB.setPassword(userInDB.getPassword());
            userService.saveEntry(userInDB);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
