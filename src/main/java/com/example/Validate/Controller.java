package com.example.Validate;

import com.example.Validate.dto.UserDto;
import com.example.Validate.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    UserService userService;
    @Autowired
    private Validator validator;

    // STYLE 1
    @PostMapping("/postUser")
    public ResponseEntity<String> postUser(@Valid @RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    // STYLE 2
    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(
                            fieldError -> fieldError.getField(),
                            fieldError -> fieldError.getDefaultMessage()
                    ));
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.ok("User created successfully!");
    }


    // STYLE 3 (Not work)
//    public ResponseEntity<?> saveUser(UserDto userDto){
//        // Validate the DTO
//        BindingResult bindingResult = new BeanPropertyBindingResult(userDto, "userDto");
//        validator.validate(userDto, bindingResult);
//
//
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errors = bindingResult.getFieldErrors()
//                    .stream()
//                    .collect(Collectors.toMap(
//                            fieldError -> fieldError.getField(),
//                            fieldError -> fieldError.getDefaultMessage()
//                    ));
//            return ResponseEntity.badRequest().body(errors);
//        }
//
//        return ResponseEntity.ok("User created successfully!");
//    }




    @PostMapping("/test")
    public ResponseEntity<?> test(@Valid @RequestBody UserDto userDto){
        userService.createUser(null);
        return ResponseEntity.ok("User created successfully!");
    }
}
