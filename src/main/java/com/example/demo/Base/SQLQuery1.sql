create database Med
use Med
create table Specialty
(IdSpecialty int PRIMARY KEY AUTO_INCREMENT, SpecialtyName varchar(50) UNIQUE NOT NULL);
insert Specialty (SpecialtyName) value
('Врач-терапевт участковый');
create table Doctor
(IdDoctor int PRIMARY KEY AUTO_INCREMENT,FIOVrach varchar (1000) NOT NULL, Specialty int NOT NULL,Foreign key (Specialty) references Specialty(IdSpecialty),WorkExperience float NOT NULL);
insert Doctor (FIOVrach,Specialty,WorkExperience) value 
('Макаров Михаил Дмитриевич', '1','2.5');
create table Patient
(IdPatient int PRIMARY KEY AUTO_INCREMENT,InsurancePolicyNumber varchar(16) NOT NULL,MedicalBookNumber varchar(7) NOT NULL,FIO varchar(150) NOT NULL,PlaceOfResidence varchar(200) NOT NULL,DateOfBirth date NOT NULL);
insert Patient (InsurancePolicyNumber,MedicalBookNumber,FIO,PlaceOfResidence,DateOfBirth) value
('123456789123456','1234567','Пациент1','Место жительства 1','20.01.2005');

create table Status(IdStatus int PRIMARY KEY AUTO_INCREMENT,Name varchar(20)UNIQUE NOT NULL
);
insert Status (Name) value('Лечение');
create table Diagnosis
(IdDiagnosis int PRIMARY KEY AUTO_INCREMENT,Patient int NOT NULL,Foreign key (Patient) references Patient(IdPatient),DateOfApplication date NOT NULL,Disease varchar(1000)NOT NULL ,Treatment varchar(1000) NOT NULL,Doctor int NOT NULL,Foreign key (Doctor) references Doctor(IdDoctor),Complaints varchar(300) NOT NULL,Improvement varchar(300) NOT NULL,Status int NOT NULL,Foreign key (Status) references Status(IDStatus));
insert Diagnosis (Patient,DateOfApplication,Disease,Treatment,Doctor,Complaints,Improvement,Status) value
('1','13.11.2023','атопический дерматит','супрастин','1','насморк и боль в горле','нет','1');

