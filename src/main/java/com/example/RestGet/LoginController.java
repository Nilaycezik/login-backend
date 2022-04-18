package com.example.RestGet;

import com.example.RestGet.model.UserDTO;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "login")
public class LoginController {

    @GetMapping
    public String read(@RequestBody UserDTO userDTO){
        if (userDTO.getEmail().equals("nilaycezik@gmail.com") && userDTO.getpass().equals("1234")) {
            String email= userDTO.getEmail();
            return "Hosgeldiniz"+email;
        }
        else{
            return "Yetkili email ve şifre giriniz...";
        }
    }


    @PostMapping
    public Boolean login(@RequestBody UserDTO userDTO) {
        if (userDTO.getEmail().equals("nilaycezik@gmail.com") && userDTO.getpass().equals("1234")) {
            return true;
        } else {
            return false;
        }
    }
}