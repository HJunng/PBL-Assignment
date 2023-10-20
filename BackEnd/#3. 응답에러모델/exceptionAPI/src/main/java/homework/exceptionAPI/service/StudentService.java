package homework.exceptionAPI.service;

import homework.exceptionAPI.entity.Student;
import homework.exceptionAPI.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Bean으로 컨테이너에 등록.
@RequiredArgsConstructor // 생성자 자동 생성.
public class StudentService {
    // Repository를 주입해야 한다.
    // 어떻게? 1.생성자주입 2. 필드주입 3.세터주입
    private final StudentRepository studentRepository;

    public Student addStudent(String name, int grade){
        // 이름이랑 성적을 입력받아서 저장
        Student student = new Student(name, grade);
        studentRepository.add(student);

        return student;
    }

    // 전체 성적 조회
    public List<Student> getAll(){
        return studentRepository.getAll();
    }
}
