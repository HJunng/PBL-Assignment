package homework.exceptionAPI.controller;

import homework.exceptionAPI.entity.Student;
import homework.exceptionAPI.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 더 예쁘고 편하게 사용가능함.
@RequiredArgsConstructor // 생성자 주입.
public class StudentController {
    private final StudentService studentService;

    // 이름과 성적을 입력받아 저장
    @PostMapping("/student")
    public void add(@RequestParam("name") String name, @RequestParam("grade") int grade){ // form 타입으로 받아올 때 사용

    }


    @GetMapping("/student")
    public void getAll(){
        //TODO
    }
}
