package edu.utvt.teacher;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import edu.utvt.teacher.persistence.common.StatusType;
import edu.utvt.teacher.persistence.entities.Teacher;
import edu.utvt.teacher.persistence.repositories.TeacherRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "edu.utvt.attendance.persistence.repositories")
@EntityScan(basePackages = "edu.utvt.teacher.persistence.entities")
public class TeacherRestApiApplication implements CommandLineRunner {

    @Autowired
    private TeacherRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(TeacherRestApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Teacher> teachers = new ArrayList<>(Arrays.asList(
            new Teacher("1", "Jorge", "Almeida Montiel", "jorge.almeida@gmail.com", StatusType.ON, convertToDate(1980, 5, 15), new Date(System.currentTimeMillis())),
            new Teacher("2", "Yanet", "Hernandez", "yanet.hernandez@gmail.com", StatusType.ON, convertToDate(1985, 8, 20), new Date(System.currentTimeMillis())),
            new Teacher("3", "Roberto Vinicio", "Camacho Mendoza", "roberto.camacho@gmail.com", StatusType.ON, convertToDate(1975, 10, 25), new Date(System.currentTimeMillis())),
            new Teacher("4", "Miguel Antonio", "Islas Martinez", "miguel.islas@gmail.com", StatusType.ON, convertToDate(1990, 2, 10), new Date(System.currentTimeMillis())),
            new Teacher("5", "Alma", "Rito", "Alma.rito@gmail.com", StatusType.ON, convertToDate(1988, 12, 30), new Date(System.currentTimeMillis())),
            new Teacher("6", "Florencio", "Barrera Gutierrez", "florencio.barrera@gmail.com", StatusType.ON, convertToDate(1979, 7, 5), new Date(System.currentTimeMillis()))
        ));

        repository.saveAll(teachers);
    }

    private Date convertToDate(int year, int month, int day) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return Date.valueOf(localDate);
    }
}