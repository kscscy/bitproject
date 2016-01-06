-- 프로젝트 테이블 생성
drop table project;
create table project (
  pno     int auto_increment,
  title   varchar(100) not null,  
  sdt     datetime not null,
  edt     datetime not null,
  member  varchar(20),
  constraint project_pk primary key (pno) 
);  

insert into project(title,sdt,edt) values('aaaa','2015-1-1','2015-2-2');
insert into project(title,sdt,edt) values('bbbb','2015-2-2','2015-3-3');
insert into project(title,sdt,edt) values('cccc','2015-3-1','2015-4-5');
insert into project(title,sdt,edt) values('dddd','2015-4-1','2015-5-5');
