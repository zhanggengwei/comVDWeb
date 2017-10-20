 
use base;

CREATE TABLE if not EXISTS MESSAGE_TABLE
(
   message_Id INT AUTO_INCREMENT primary key,
   messageContent TEXT,
   source_Url TEXT,
   senderID INT,
   receiveId INT,
   sendTimeInterval TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   contactID varchar(30) not NULL ,
   messageType TEXT,
   senderIDUserInfo TEXT)AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- drop table MESSAGE_STATUS_TABLE;
CREATE TABLE  if NOT  EXISTS MESSAGE_STATUS_TABLE
(
    message_status INT,
    userId INT,
    messageID INT not null,
    idDelete BOOL,
    recalled BOOL,
    reaclled_uid INT,
    PRIMARY KEY(messageID)
);
-- 
--  drop table CONVERSATION_TABLE;
-- 
 CREATE TABLE if NOT EXISTS CONVERSATION_TABLE
 (
   contactID VARCHAR(30) NOT NULL ,
   isTop BLOB,
   isDistrub BLOB,
   deleteStaus BLOB,
   userId INT,
   lastMessageId INT,
   PRIMARY KEY(contactID)
 );
--  
--  -- drop table CONVERSATION_LIST_TABLE;
 create table if not exists CONVERSATION_LIST_TABLE
 (
     uid varchar(30),
     contactId varchar(30),
     primary key(uid,contactId)
 );
--  
--  drop table CONTACT_GROUP_TABLE;
--  
 CREATE TABLE  if NOT EXISTS CONTACT_GROUP_TABLE
 (
     contactID VARCHAR(30) NOT NULL ,
     name  TEXT,
     imageUrl TEXT,
     createUId INT,
     masterUId  INT,
	 create_time timestamp,
     update_Time timestamp default CURRENT_TIMESTAMP,
     PRIMARY KEY(contactID)
);
-- 
-- drop table CONTACT_GROUP_MEMBER_TABLE;
-- 
CREATE TABLE  if NOT EXISTS CONTACT_GROUP_MEMBER_TABLE
(
    contactID VARCHAR(30) NOT NULL,
    uid INT,
    idDelete BOOLEAN,
    update_At TIMESTAMP default CURRENT_TIMESTAMP,
    PRIMARY KEY(contactID,uid)
);
-- drop table USER_INFO_TABLE;
CREATE TABLE IF NOT EXISTS USER_INFO_TABLE
 (
    userId int AUTO_INCREMENT,
    phone VARCHAR(35) UNIQUE NOT NULL,
    updateAt TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    passWord VARCHAR(30) NOT NULL,
    avatarUrl TEXT,
    eamil TEXT,
    registerTime long,
    birthday long,
    region VARCHAR(5),
    name VARCHAR(15),
    sex  INT(1),
    PRIMARY KEY (userId)
   )AUTO_INCREMENT = 60000 DEFAULT CHARSET=utf8;
--    
-- 
--  drop table USER_INFO_FAVIOUTE_IMAGE_TABLE;
 create TABLE USER_INFO_FAVIOUTE_IMAGE_TABLE
 (
     userId int not null,
     imageId int auto_increment primary key,
     idDelete BOOL,
     sourceUrl text not null
 );
--  
--  drop table USER_INFO_TOKEN_TABLE;
--  
 create table USER_INFO_Auth
 (
     token varchar(30),
     weChatOpenId varchar(30),
     userId  INT primary key,
     expire_time TIMESTAMP,
     create_time TIMESTAMP default CURRENT_TIMESTAMP
 );
--  drop table FRIENDLIST_TABLE;
 create table if not EXISTS FRIENDLIST_TABLE
 (
     userId INT not null,
     f_userId INT not null,
     f_nickName VARCHAR(30),
     update_At TIMESTAMP default CURRENT_TIMESTAMP,
     isDelete BOOL,
     primary key(userId,f_userId)
 );
--  drop table SMS_CODE_TABLE;
 create table if not EXISTS  SMS_CODE_TABLE
 (
     phone INT primary key,
     smsCode VARCHAR(6) NOT NULL ,
     expire_time long,
     updateAt TIMESTAMP default current_timestamp,
     smsCodeType INT
 );
 
 create table if not exists SMS_TEMPLATE_TABLE
 (
     smsCodeType INT primary key,
	 smsTemplate text,
     updateAt  TIMESTAMP default current_timestamp
 );
 
