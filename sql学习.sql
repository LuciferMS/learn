/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : learn

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2019-08-15 17:18:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classNum` int(11) NOT NULL,
  `className` varchar(255) NOT NULL,
  PRIMARY KEY (`classNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '计算机网络');
INSERT INTO `class` VALUES ('2', '操作系统');
INSERT INTO `class` VALUES ('4', '数学分析');
INSERT INTO `class` VALUES ('5', '高等代数');
INSERT INTO `class` VALUES ('6', '解析几何');

/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : learn

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2019-08-15 17:18:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ref
-- ----------------------------
DROP TABLE IF EXISTS `ref`;
CREATE TABLE `ref` (
  `classNum` int(11) NOT NULL,
  `studetId` varchar(11) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `classId` (`classNum`),
  KEY `studentId` (`studetId`),
  CONSTRAINT `classId` FOREIGN KEY (`classNum`) REFERENCES `class` (`classNum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `studentId` FOREIGN KEY (`studetId`) REFERENCES `student` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ref
-- ----------------------------
INSERT INTO `ref` VALUES ('1', 'Elliot', '1');
INSERT INTO `ref` VALUES ('1', 'Shayla1', '2');
INSERT INTO `ref` VALUES ('2', 'Shayla2', '3');

/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : learn

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2019-08-15 17:18:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL,
  `refId` int(11) NOT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `refId` (`refId`),
  CONSTRAINT `refId` FOREIGN KEY (`refId`) REFERENCES `ref` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '1', '80');
INSERT INTO `score` VALUES ('2', '2', '88');
INSERT INTO `score` VALUES ('3', '3', null);

/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : learn

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2019-08-15 17:18:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('Elliot', '11111', '111');
INSERT INTO `student` VALUES ('Shayla', 'qqqqq', '11');
INSERT INTO `student` VALUES ('Shayla1', 'qqqqq', '11');
INSERT INTO `student` VALUES ('Shayla2', 'qqqqq', '11');
INSERT INTO `student` VALUES ('Shayla3', 'qqqqq', '20');
INSERT INTO `student` VALUES ('Shayla4', 'qqqqq', '2');
INSERT INTO `student` VALUES ('Shayla5', 'qqqqq', '6');
INSERT INTO `student` VALUES ('Shayla6', 'qqqqq', '7');
INSERT INTO `student` VALUES ('Shayla7', 'qqqqq', '8');




#DISTINCT
SELECT DISTINCT password, age FROM student ;
#DESC 降序
SELECT * FROM student ORDER BY age DESC;
#ASC 升序 默认的
SELECT * FROM student ORDER BY age ASC;

SELECT * FROM student ORDER BY age , password;

SELECT * FROM student ORDER BY age , password DESC;
#LIMIT
SELECT * FROM student LIMIT 1, 1;
#LIKE
SELECT * FROM student WHERE `password` LIKE '%q%';
#NOT LIKE
SELECT * FROM student WHERE `password` NOT like '%q%';
#通配符
SELECT * FROM student WHERE `password` LIKE '_q%';
#IN
SELECT * FROM student WHERE `password` IN ('qqqqq', '1111');
#BETWEEN....AND...
SELECT * FROM student WHERE age BETWEEN 1 AND 10;
#NOT....BETWEEN....AND...
SELECT * FROM student WHERE age NOT BETWEEN 1 AND 10;
#BETWEEN....AND...IN
SELECT * FROM student WHERE (age BETWEEN 1 AND 10) AND age NOT IN (2, 6);
#AS
SELECT age AS student_age FROM student;
#笛卡尔积
SELECT * FROM student s, class c;
#LEFT JOIN 
SELECT s.name, c.className FROM student s LEFT JOIN class c on s.`name` IN (SELECT r.studetId FROM ref r WHERE r.classNum = c.classNum);
#INNER JOIN 
SELECT s.name, c.className FROM student s INNER JOIN class c on s.`name` IN (SELECT r.studetId FROM ref r WHERE r.classNum = c.classNum);
#RIGHT JOIN 
SELECT s.name, c.className FROM student s RIGHT JOIN class c on s.`name` IN (SELECT r.studetId FROM ref r WHERE r.classNum = c.classNum);
#FULL JOIN 
SELECT s.name, c.className FROM student s FULL JOIN class c on s.`name` IN (SELECT r.studetId FROM ref r WHERE r.classNum = c.classNum);

SELECT 1 = NULL;

SELECT NULL = NULL;

SELECT * FROM score WHERE score IS NULL;

SELECT * FROM score WHERE score IS NOT NULL;

SELECT AVG(score) FROM score;

SELECT AVG(score) FROM score WHERE score IS NOT NULL;

SELECT COUNT(*) FROM score;
#GROUP BY
SELECT classNum, SUM(id) as Id FROM ref GROUP BY classNum;
#GROUP BY...HAVING
SELECT classNum, SUM(id) as Id FROM ref GROUP BY classNum HAVING classNum > 1;




