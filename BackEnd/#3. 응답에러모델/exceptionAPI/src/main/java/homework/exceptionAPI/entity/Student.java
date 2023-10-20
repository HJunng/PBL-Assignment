package homework.exceptionAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Getter, Setter, ... 다 포함해주는 애노테이션.
@AllArgsConstructor // 생성자 만들어주는 애노테이션.
public class Student implements Comparable<Student>{
    private String name;
    private int grade;

    @Override
    public int compareTo(Student o) {
        // 현재 객체의 grade가 더 크면, 양수를 return.
        return this.grade - o.getGrade(); // 오름차순 정렬.
    }
}
