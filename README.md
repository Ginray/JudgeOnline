### 1、功能：

用JAVA+MySQL+Python脚本实现了OJ的基本功能，包括实现编译、运行、评判、VirtualJudge的功能。



### 2、主要界面：



2.1 首页

​	![index](.\img\index.png)

2.1 题目列表

![problem_list](.\img\problem_list.png)



2.2 题目界面![problem](.\img\problem.png)

2.3 提交题目界面

![problem_submit](.\img\problem_submit.png)



2. 4提交状态界面

![status](.\img\status.png)



### 3、数据库



/*

数据库生成sql语句：

Source Database       : zjgsu_oj

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-02-22 18:40:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem` (
  `problem_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '',
  `description` text,
  `input` text,
  `output` text,
  `sample_input` text,
  `sample_output` text,
  `spj` char(1) NOT NULL DEFAULT '0',
  `hint` text,
  `source` varchar(100) DEFAULT NULL,
  `in_date` datetime DEFAULT NULL,
  `time_limit` int(11) NOT NULL DEFAULT '0',
  `memory_limit` int(11) NOT NULL DEFAULT '0',
  `defunct` char(1) NOT NULL DEFAULT 'N',
  `accepted` int(11) DEFAULT '0',
  `submit` int(11) DEFAULT '0',
  `solved` int(11) DEFAULT '0',
  PRIMARY KEY (`problem_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1118 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for solution
-- ----------------------------
DROP TABLE IF EXISTS `solution`;
CREATE TABLE `solution` (
  `problem_id` int(11) NOT NULL,
  `input` text,
  `output` text,
  PRIMARY KEY (`problem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for submitstate
-- ----------------------------
DROP TABLE IF EXISTS `submitstate`;
CREATE TABLE `submitstate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `problem_id` int(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  `state` varchar(20) DEFAULT NULL,
  `codeType` char(10) DEFAULT 'java',
  `memory` varchar(20) DEFAULT NULL,
  `runtime` varchar(20) DEFAULT NULL,
  `submitDate` date NOT NULL,
  `codeLength` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `submit` int(20) unsigned zerofill DEFAULT '00000000000000000000',
  `accept` int(20) unsigned zerofill DEFAULT '00000000000000000000',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;





### 4、Python Script

problem_spider 用于爬取hdu的题目 ，运行方式： python problem_spider.py。

可修改要爬取题目的题号,文件中的参数为problem_id。



submit_code 用于向hdu提交题目，运行方式： python submit_code.py。

输入参数为problem_id、language、code。将会自动登录我的账号用于提交、并返回提交状态。



### 5、其他

该项目有很多不足的地方，将会继续更新下去。

有什么建议请发送至邮箱 ginray0215@gmail.com，谢谢大家。



