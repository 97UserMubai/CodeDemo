package es.repositories;

import es.entity.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Classname StudentRepository
 * @Description 类似于mapper层的接口
 * @Date 2021/5/24 9:58
 * @Created by mubai
 */
public interface StudentRepository extends ElasticsearchRepository<Student, String> {

    /**
     * 通过学生名称查询指定的学生对象
     *
     * @param name 学生姓名
     * @return Student
     */
    Student findByName(String name);

    /**
     * 通过学生年纪进行学生集合的批量查询
     *
     * @param age 学生年纪
     * @return List<Student>
     */
    List<Student> findByAge(Integer age);

    /**
     * 通过主键id查询学生实体
     *
     * @param id 主键Id
     * @return Student
     */
    Student findStudentById(Long id);
}
