package com.example.ql_hoahau;

import com.example.ql_hoahau.model.Clasz;
import com.example.ql_hoahau.model.MissQueen;
import com.example.ql_hoahau.model.Teacher;
import com.example.ql_hoahau.repository.ClassRepository;
import com.example.ql_hoahau.repository.MissQueenRepo;
import com.example.ql_hoahau.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

// implements cmdRunner - để override run()
@SpringBootApplication
public class QlHoaHauApplication implements CommandLineRunner {
    @Autowired
    private MissQueenRepo missQueenRepo;
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private TeacherRepository teacherRepository;


    public static void main(String[] args) {
        SpringApplication.run(QlHoaHauApplication.class, args);
    }

    // thêm dữ liệu vào db khi db dc tạo ra
    @Override
    public void run(String... args) throws Exception {
        MissQueen missQueen = new MissQueen();
//        .......
        missQueenRepo.save(missQueen);

// lưu teacher trước vì @jointable có Clasz
        Teacher teacher = new Teacher();
        teacher.setName("Dat 3");
        teacher.setAccountNum("1234");

        teacherRepository.save(teacher);

        Clasz clasz = new Clasz();
        clasz.setName("java14");
        clasz.setTeachers(Set.of(teacher));
        clasz.setStatus("open");
        classRepository.save(clasz);

    }
}
