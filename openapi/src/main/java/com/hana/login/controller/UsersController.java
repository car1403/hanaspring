package com.hana.login.controller;


import com.hana.common.dto.Response;
import com.hana.common.util.Helper;
import com.hana.login.dto.request.UserRequestDto;
import com.hana.login.service.UsersService;
import com.hana.security.jwt.JwtTokenProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/login/")
@RestController
@Tag(name = "Login Open API", description = "사용자 등록 및 로그인 아웃 처리")
public class UsersController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UsersService usersService;
    private final Response response;
    @Operation(summary = "회원가입", description = "이메일 비번 입력 <br> token 리턴 ")
    // GET 일때
//    @Parameter(name = "email", description = "이메일 입력", )
//    @Parameter(name = "password", description = "비빌번호 입력")
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Validated @RequestBody UserRequestDto.SignUp signUp, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }

        return usersService.signUp(signUp);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login( UserRequestDto.Login login, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return usersService.login(login);
    }

    @PostMapping("/reissue")
    public ResponseEntity<?> reissue( UserRequestDto.Reissue reissue, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return usersService.reissue(reissue);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout( UserRequestDto.Logout logout, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return usersService.logout(logout);
    }
}
