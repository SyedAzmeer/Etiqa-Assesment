

CREATE TABLE `student` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ref_student_course` (
  `course_id` int NOT NULL,
  `course_name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO crudstudent.ref_student_course (course_id,course_name) values (1,'Science Stream');
INSERT INTO crudstudent.ref_student_course (course_id,course_name) values (2,'Account Stream');
INSERT INTO crudstudent.ref_student_course (course_id,course_name) values (3,'Art Stream');
INSERT INTO crudstudent.ref_student_course (course_id,course_name) values (4,'Economy Stream');

INSERT INTO crudstudent.student (address,age,course_id,name) values ("Klang",21,2,"Zaquan Adha");
INSERT INTO crudstudent.student (address,age,course_id,name) values ("Taman Kebun",19,3,"Aidil Zafuan");
INSERT INTO crudstudent.student (address,age,course_id,name) values ("Taman Botani",21,3,"Syahril Aris");
INSERT INTO crudstudent.student (address,age,course_id,name) values ("Taman Kelawar",21,2,"Bergson Fernandes");


SELECT * FROM crudstudent.student;

SELECT * FROM crudstudent.ref_student_course;