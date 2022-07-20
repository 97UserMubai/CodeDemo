package es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * @Classname Student
 * @Description 学生测试实体
 * @Date 2021/5/24 9:59
 * @Created by mubai
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparator<Student> {
    private Long id;
    private Integer age;
    private String name;
    private String key;

    public static Function<Student, String> havingKey = student -> student.getAge() + student.getKey();

    public static BinaryOperator<Student> minAgeBy = (student, student2) -> {
        if (student.getAge() > student2.getAge()) {
            return student;
        } else {
            return student2;
        }
    };

    @Override
    public int compare(Student o1, Student o2) {
        //实现Comparator接口的必须有三个返回值，1，0，-1
        return o1.getAge() > o2.getAge() ? 1 : (o1.getId().equals(o2.getId()) ? 0 : -1);
    }
}
