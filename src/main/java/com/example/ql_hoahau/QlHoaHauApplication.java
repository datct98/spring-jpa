package com.example.ql_hoahau;

import com.example.ql_hoahau.model.MissQueen;
import com.example.ql_hoahau.repository.MissQueenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// implements cmdRunner - để override run()
@SpringBootApplication
public class QlHoaHauApplication implements CommandLineRunner {
    @Autowired
    private MissQueenRepo missQueenRepo;


    public static void main(String[] args) {
        SpringApplication.run(QlHoaHauApplication.class, args);
    }

    // thêm dữ liệu vào db khi db dc tạo ra
    @Override
    public void run(String... args) throws Exception {
        MissQueen missQueen = new MissQueen();
//        .......
        missQueenRepo.save(missQueen);

    }
}
