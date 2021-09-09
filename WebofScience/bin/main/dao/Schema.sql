/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sayyed
 * Created: 21 Aug,2021
 */
create table Role (
 Role_id int auto_increment,
 name varchar(50) not null unique,
 constraint Role_PK Primary key (Role_Id)
);

insert into Role Values (null, 'Contributor');
insert into Role Values (null, 'Verifier');
insert into Role Values (null, 'Lead Verifier');
insert into Role Values (null, 'Admin');

create table User (
 User_Id int auto_increment,
 Username varchar(50) not null unique,
 Password varchar(50) not null,
 Fname varchar(50) not null,
 Lname varchar(50) not null,
 Email varchar(50) not null,
 DOB date not null,
 Gender varchar(50) not null,
 Department Varchar(50) not null,
 Institute Varchar(50) not null,
 Field_Of_Research Varchar(100) not null,
 RoleId int,
 DeptId int,
 constraint User_PK Primary key (User_Id),
 constraint User_Role_FK Foreign key (RoleId) references Role(Role_Id)
);

create table Article(
 Article_Id int auto_increment,
 File BLOB not null,
 Title Varchar(150) not null,
 Abstract Varchar(8000) not null,
 Keyword Varchar(100) not null,
 Author Varchar(100) not null,
 Verified Boolean not null,
 Published Boolean not null,
 Flags int,
 Cited_count int,
 Contributed_By Int,
 Verified_By Int,
 constraint Article_PK Primary key (Article_Id),
 constraint Article_Cont_FK Foreign key (Contributed_By) references User(User_Id),
 constraint Article_Veri_FK Foreign key (Verified_By) references User(User_Id)
);

create table History(
 History_Id int auto_increment,
 UserId int,
 Keyword varchar(50) not null,
 Date date,
 constraint History_PK Primary key (History_Id),
 constraint History_FK Foreign key (UserId) references User(User_Id)
);

create table Bookmark (
 Bookmark_Id int auto_increment,
 UserId int,
 ArticleId int,
 Date date,
 constraint Bookmark_Pk Primary key (Bookmark_Id),
 constraint Bookmark_User_Fk Foreign key (UserId) references User(User_Id),
 constraint Bookmark_Art_Fk Foreign key (ArticleId) references Article(Article_Id)
);

