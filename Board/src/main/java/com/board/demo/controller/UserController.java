package com.board.demo.controller;

import com.board.demo.service.UserService;
import com.board.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/user")  // URL 경로 구조화
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    // Login 을 위한 HTML 파일 내려주기
    @GetMapping("/")
    public String Home() {
        return "index";
    }

    @GetMapping("/joinUser")
    public String createMemberForm() {
        return "joinUser";
    }
    @PostMapping("/joinUser")
    public String userJoin(@ModelAttribute UserDto userDto){
        userService.join(userDto);
        // 회원가입 성공 시 보여줄 페이지 또는 redirect 경로
        return "index";
    }

    @GetMapping("/loginUser")
    public String loginUser() {
        return "loginUser";  // Thymeleaf를 사용할 경우, loginUser.html 템플릿을 반환합니다.
    }

    @DeleteMapping("/drop")
    public void userDrop() {

    }
}
