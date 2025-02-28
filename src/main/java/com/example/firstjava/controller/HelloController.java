package com.example.firstjava.controller;

import com.example.firstjava.dto.UserMessageDto;
import com.example.firstjava.dto.UserMessageRequestDto;
import com.example.firstjava.service.HelloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping()
    public String sayHello() {
        return helloService.sayHello();
    }

    @PostMapping("/msg_path_variable/{text}")
    public String saveMsgPathVariable(@PathVariable(name = "text") String userText) {
        return helloService.saveMsg(userText);
    }

    @PostMapping("/msg_request_param")
    public String saveMsgRequestParam(@RequestParam(name = "text") String text) {
        return helloService.saveMsg(text);
    }

    @PostMapping("/mgs_request_body")
    public ResponseEntity<UserMessageRequestDto> saveMsgRequestBody(@RequestBody UserMessageDto userMessageDto) {
        return ResponseEntity.status(HttpStatus.OK).body(helloService.saveMsg(userMessageDto));
    }

    @GetMapping("/getMsg/{id}")
    public String getMsg(@PathVariable(name = "id") long id) {
        return helloService.getMsg(id);
    }
}
