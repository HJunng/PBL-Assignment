package homework.exceptionAPI.repository;

import homework.exceptionAPI.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository // ComponentScan 대상으로 넣기 위해서!
public class StudentRepository { // 데이터에 있는 걸 가져와서 붙이는 역할.

    // students
    Set<Student> studentSet = new HashSet<>();

    //이름과 성적을 입력받아 저장 -> 서비스 단계에서 만들어서 던져주는 형식.
    public void add(Student student){
        studentSet.add(student);
    }

    // 입력된 성적의 오름차순으로 조회.
    public List<Student> getAll(){
        return studentSet.stream().sorted().collect(Collectors.toList());
    }
}
