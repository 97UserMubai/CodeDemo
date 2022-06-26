package es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Student {
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

}
