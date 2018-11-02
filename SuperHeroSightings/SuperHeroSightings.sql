drop database if exists superherosightings;


create database if not exists SuperHeroSightings;

use SuperHeroSightings;

create table if not exists `Superhumans` (
`HeroId` int(11) not null auto_increment,
`Name` varchar(50) not null,
`Description` varchar(100),
primary key (`HeroId`)
) engine=InnoDB default charset=latin1 auto_increment=1;

create table if not exists `Organizations` (
`OrganizationId` int(11) not null auto_increment,
`Name` varchar(35) not null,
`Description` varchar(100),
`Address` varchar(50),
`Phone` varchar(15),
`Email` varchar(50),
primary key (`OrganizationId`)
) engine=InnoDB default charset=latin1 auto_increment=1;

create table if not exists `SuperhumansOrganizations` (
`HeroId` int(11) not null,
`OrganizationId` int(11) not null,
foreign key (`HeroId`) references `Superhumans` (`HeroId`),
foreign key (`OrganizationId`) references `Organizations` (`OrganizationId`)
) engine=InnoDB default charset=latin1 auto_increment=1;

create table if not exists `Powers` (
`PowerId` int(11) not null auto_increment,
`name` varchar(20) not null,
`Description` varchar(100) not null,
primary key (`PowerId`)
) engine=InnoDB default charset=latin1 auto_increment=1;

create table if not exists `SuperhumansPowers` (
`HeroId` int(11) not null,
`PowerId` int(11) not null,
foreign key (`HeroId`) references `Superhumans` (`HeroId`),
foreign key (`PowerId`) references `Powers` (`PowerId`)
) engine=InnoDB default charset=latin1 auto_increment=1;

create table if not exists `Locations` (
`LocationId` int(11) not null auto_increment,
`Name` varchar(30) not null,
`Description` varchar(100),
`Address` varchar(50),
`Latitude` varchar(10
) not null,
`Longitude` varchar(10) not null,
primary key (`LocationId`)
) engine=InnoDB default charset=latin1 auto_increment=1;

create table if not exists `Sightings` (
`SightingId` int(11) not null auto_increment,
`Date` datetime not null,
`HeroId` int(11) not null,
`LocationId` int(11) not null,
primary key (`SightingId`),
foreign key (`HeroId`) references `Superhumans` (`HeroId`),
foreign key (`LocationId`) references `Locations` (`LocationId`)
) engine=InnoDB default charset=latin1 auto_increment=1;