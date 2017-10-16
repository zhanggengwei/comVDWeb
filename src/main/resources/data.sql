#USE base;

# create  table if not EXISTS Message_Table
# (
#   message_Id INT  AUTO_INCREMENT PRIMARY KEY ,
#   messageContent TEXT,
#   source_Url TEXT,
#   senderID TEXT,
#   receiveId TEXT,
#   sendTimeInterval TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#   contactID text not NULL ,
#   deleteMessage BOOLEAN,
#   messageRecalled BOOLEAN,
#   messageStatus INT,
#   messageType TEXT,
#   tipMessage TEXT,
#   senderIDUserInfo TEXT)AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#
#
# CREATE TABLE if NOT EXISTS Conversation_Table
# (
#   contactID VARCHAR(10) NOT NULL ,
#   isTop BLOB,
#   isDistrub BLOB,
#   deleteStaus BLOB,
#   userId INT,
#   PRIMARY KEY(contactID,userId)
# );
#
# CREATE TABLE  if NOT EXISTS Contact_Group
# (
#     contactID VARCHAR(10) NOT NULL ,
#     name  TEXT,
#     imageUrl TEXT,
#     isMaster BOOLEAN,
#     userId INT ,
#     PRIMARY KEY(contactID,userId)
# )
# #SHOW TABLES ;
# # 好友列表
#
# # SELECT * FROM User_Info;
# #
# CREATE TABLE IF NOT EXISTS User_Info
# (
#    userID int AUTO_INCREMENT,
#    phone VARCHAR(15) UNIQUE NOT NULL,
#    updateAt TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
#    passWord VARCHAR(20) NOT NULL,
#    avatarUrl TEXT,
#    eamil TEXT,
#    registerTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#    weChatOpenId VARCHAR(30) UNIQUE,
#    birthday TIMESTAMP DEFAULT  CURRENT_TIMESTAMP,
#    region VARCHAR(5),
#    name VARCHAR(15),
#    PRIMARY KEY (userID)
# )AUTO_INCREMENT = 60000 DEFAULT CHARSET=utf8;
#create DATABASE base;

#DROP  table User_Info;

#DROP DATABASE base;
#SHOW DATABASES ;
SHOW  TABLES;
