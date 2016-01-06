-- 프로젝트 테이블 생성
drop table student;
create table student (
  sno     int auto_increment,
  name    varchar(20) not null,  
  email   varchar(20) not null,  
  tel    varchar(20),  
  cid    varchar(20),  
  constraint student_pk primary key (sno) 
);  

insert into student(name,email,tel,cid) values('aaaa','aaa@test.com','1111','01');
insert into student(name,email,tel,cid) values('bbbb','bbb@test.com','1112','02');
insert into student(name,email,tel,cid) values('cccc','ccc@test.com','1113','03');
insert into student(name,email,tel,cid) values('dddd','ddd@test.com','1114','04');
SELECT * FROM java76db.student;CREATE TABLE `student` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `cid` varchar(20) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT '1111',
  `photo` varchar(50) DEFAULT 'default.png',
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8;
