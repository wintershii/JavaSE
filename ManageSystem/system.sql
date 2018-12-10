/**
  创建学生信息表
 */

create table stuIfo (
  userId char(8) not null,
  pwd varchar(20) default null,
  stuName varchar(30) default null,
  phone char(11) default null,
  major varchar(30) default null ,
  classroom int(4) default null ,
  serial int(2) default null ,
  entranceTime date default null,
  primary key (userId)
);

/**
  创建学生成绩信息表
 */
 create table stuGrade (
   userId char(8) not null,
   math int(3) default null,
   english int(3) default null,
   cProgram int(3) default null,
   sum int(3) default null,
   point double default null,
   foreign key (userId) references stuIfo(userId)
 );

/**
  创建教师信息表
 */

create table teachInfo (
  teachId char(8) not null,
  pwd varchar(20) default null,
  teachName varchar(30) default null,
  phone char(11) default null,
  major varchar(30) default null ,
  subject varchar(30) default null,
  primary key (teachId)
);

/**
  创建管理员信息表
 */

create table mangeInfo (
  manageId char(4) not null,
  pwd varchar(20) default null ,
  manageName varchar(30) default null ,
  phone char(11) default null,
  primary key (manageId)
);