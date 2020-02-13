package prut.demo_2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import prut.demo_2.entity.User;
import prut.demo_2.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vasyl savitskyy on 20.11.2019.
 */
@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "save")
    public ModelAndView saveUser(@RequestParam("name") String name) {
        Map<String, Object> model = new HashMap<>();
        User user = new User();
        user.setName(name);
        user = userService.save(user);

        model.put("user_id", user.getId());
        model.put("user_name", user.getName());

        return new ModelAndView("info", model);
    }

    @GetMapping(value = "getAll")
    public @ResponseBody
    ResponseEntity getAll(){
        Map <String, Object> map = new HashMap<>();
        List<User> users = userService.getAll();
        map.put("count", users.size());
        map.put("list", users);

        return ResponseEntity.ok(map);
    }

}
