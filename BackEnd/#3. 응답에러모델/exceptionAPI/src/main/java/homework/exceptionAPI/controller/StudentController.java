package homework.exceptionAPI.controller;

import homework.exceptionAPI.entity.ApiResponse;
import homework.exceptionAPI.entity.ErrorCode;
import homework.exceptionAPI.entity.Student;
import homework.exceptionAPI.exception.CustomException;
import homework.exceptionAPI.exception.InputRestriction;
import homework.exceptionAPI.service.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

@RestController // 더 예쁘고 편하게 사용가능함.
@RequiredArgsConstructor // 생성자 주입.
public class StudentController {
    private final StudentService studentService;

    // 이름과 성적을 입력받아 저장
    @PostMapping("/student")
    public ApiResponse add(@RequestParam("name") String name, @RequestParam("grade") int grade) { // form 타입으로 받아올 때 사용
        if(grade>=6){
            throw new CustomException(ErrorCode.BAD, "grade는 6이상을 입력할 수 없습니다.", new InputRestriction(6));
        }
        return makeResponse(studentService.addStudent(name, grade));
    }

    // 전체 성적 조회
    @GetMapping("/students")
    public ApiResponse<Student> getAll() {
        return makeResponse(studentService.getAll());
    }

    // 특정 성적을 입력 받아, 해당 성적의 학생들을 조회
    @GetMapping("/students/{grade}")
    public ApiResponse getGradeStudent(@PathVariable("grade") int grade){
        return makeResponse(studentService.getGradeStudent(grade));
    }

    /**
     * public ApiResponse<T> makeResponse(t result) 하면 빨간줄
     * public <T> ApiResponse<T> makeResponse 해야 함.
     */
    public <T> ApiResponse<T> makeResponse(List<T> result) {
        return new ApiResponse<>(result);
    }

    public <T> ApiResponse<T> makeResponse(T result) {
        return makeResponse(Collections.singletonList(result));
    }

    @ExceptionHandler(CustomException.class)
    public ApiResponse customExceptionHandler(HttpServletResponse response, CustomException customException){
//        response.setStatus(customException.getErrorCode().getHttpStatus());
        return new ApiResponse<>(customException.getErrorCode().getCode(),
                customException.getData());
    }
}
