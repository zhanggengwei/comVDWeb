USE base;

DROP TABLE MESSAGE_TABLE;

CREATE TABLE if not EXISTS MESSAGE_TABLE
(
   message_Id INT  AUTO_INCREMENT PRIMARY KEY ,
   messageContent TEXT,
   source_Url TEXT,
   senderID TEXT,
   receiveId TEXT,
   sendTimeInterval TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   contactID text not NULL ,
   messageType TEXT,
   senderIDUserInfo TEXT)AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE  if NOT  EXISTS MESSAGE_STATUS_TABLE
{
    message_status INT,
    userId INT,
    messageID INT,
    delete BOOL,
    recalled BOOL,
    reaclled_uid INT,
    PRIMARY KEY(messageID)
}

 CREATE TABLE if NOT EXISTS CONVERSATION_TABLE
 (
   contactID VARCHAR(10) NOT NULL ,
   isTop BLOB,
   isDistrub BLOB,
   deleteStaus BLOB,
   userId INT,
   PRIMARY KEY(contactID,userId)
 );

 CREATE TABLE  if NOT EXISTS CONTACT_GROUP_TABLE
 (
     contactID VARCHAR(10) NOT NULL ,
     name  TEXT,
     imageUrl TEXT,
     createUId Text,
     masterUId  Text,
     PRIMARY KEY(contactID,userId)
     create_time
     update_Time
)

CREATE TABLE  if NOT EXISTS CONTACT_GROUP_MEMBER_TABLE
(
    contactID VARCHAR(30) NOT NULL PRIMARY KEY,
    uid VARCHAR(30) NOT NULL,
    del BOOLEAN,
    update_At TIMESTAMP CURRENT_TIMESTAMP,
    PRIMARY KEY(contactID,uid)
)

CREATE TABLE IF NOT EXISTS USER_INFO_TABLE
 (
    userID int AUTO_INCREMENT,
    phone VARCHAR(15) UNIQUE NOT NULL,
    updateAt TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    passWord VARCHAR(20) NOT NULL,
    avatarUrl TEXT,
    eamil TEXT,
    registerTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    weChatOpenId VARCHAR(30) UNIQUE,
    birthday TIMESTAMP DEFAULT  CURRENT_TIMESTAMP,
    region VARCHAR(5),
    name VARCHAR(15),
    PRIMARY KEY (userID)
   )AUTO_INCREMENT = 60000 DEFAULT CHARSET=utf8;

 create TABLE USER_INFO_FAVIOUTE_IMAGE_TABLE
 (
     userId int PRIMARY KEY,
     imageId int,
     delete BOOL,
     sourceUrl text,
 )

 create table USER_INFO_TOKEN_TABLE
 (
     token varchar(30),
     uid  INT,
     expire_time TIMESTAMP  CURRENT_TIMESTAMP,
     create_time TIMESTAMP  CURRENT_TIMESTAMP
 )
 create table if not EXISTS FRIENDLIST_TABLE
 (
     uid INT,
     f_uid INT,
     f_nickName VARCHAR(30),
     update_At TIMESTAMP CURRENT_TIMESTAMP,
     DELETE BOOL
 )

 create table if not EXISTS  SMS_CODE_TABLE
 (
     uid INT,
     smsCode VARCHAR(6) NOT NULL ,
     expire_time TIMESTAMP,
     create_time TIMESTAMP CURRENT_TIMESTAMP,
     type INT,

 )


#create DATABASE base;

#DROP  table User_Info;

#DROP DATABASE base;
#SHOW DATABASES ;
SHOW  TABLES;
/*
   token
   userId
   expire_time 过期时间
   primary key(token,userId)
   create_token_Time
*/
/*
   sms Code
   code
   expire_time
   token
   uid
   type
   primary key(uid,type,token)
   create_Time
*/

/*
   SMS_MESSAGE_TABLE

   SMS_TYPE,
   SMS_MESSAGE
   primary key(SMS_TYPE)

*/

/*
   User_Info
   uid
   login_Time
   register_Time
   update_At
   name
   nickname
   passWord
   phone
   email
*/

/*
  好友列表
  Friend_List
  uid friendId delete name update_At
*/
