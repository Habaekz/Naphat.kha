package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/add") // Map ONLY POST Requests
    public String addNewUser (@RequestParam String username, @RequestParam String password, @RequestParam String role, @RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setId(Integer.parseInt(username.substring(1)));
        n.setName(name);
        n.setEmail(email);
        n.setUsername(username);
        n.setPassword(password);
        n.setRole(role);
        userRepository.save(n);

        return "index";
    }

    @RequestMapping(value = "/login_complete", method = RequestMethod.GET)
    public String createUser(@RequestParam String username, @RequestParam String password, @RequestParam String role, Model model) {
        Optional<User> user = userRepository.findById(Integer.parseInt(username.substring(1)));
        if(user.isEmpty()) {
            return "greeting";
        }
        if(user.get().getPassword().equals(password) && user.get().getRole().equals(role))
        {
            model.addAttribute("name", user.get().getName());
            model.addAttribute("name2", user.get().getName());
            model.addAttribute("email", user.get().getEmail());
            model.addAttribute("role", user.get().getRole());
            model.addAttribute("username", user.get().getUsername());
            model.addAttribute("password", user.get().getPassword());
            return "login_finish";
        }
        return "greeting";
    }

    @GetMapping("/forgotPass/id")
    public String greeting2(@RequestParam String username, Model model) {
        Optional<User> user = userRepository.findById(Integer.parseInt(username.substring(1)));
       if(user.isEmpty())
       {
           return "forgetPass_passDoesntExist";
       }
       var usern = "** Your username is "+user.get().getUsername()+" **";
       var pass = "** Your password is "+user.get().getPassword()+" **";
        model.addAttribute("username", usern);
       model.addAttribute("password", pass);
       return "forgetPass_finish";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

//    @GetMapping("/index")
//    public String greeting(
//            @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        return "greeting";
//    }

    @GetMapping("/forgotPass")
    public String forgotPass(Model model) {
        return "forgotPass";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        return "signup";
    }
}
