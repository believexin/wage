-- ----------------------------
-- Table structure for t_aty_cfgid
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_cfgid`;
CREATE TABLE `t_aty_cfgid` (
  `C_Key` varchar(100) NOT NULL COMMENT '配置项Key',
  `N_Value` decimal(17,2) NOT NULL default '0.00' COMMENT '配置值',
  `N_FldLength` tinyint(4) NOT NULL default '16' COMMENT '字段长度',
  PRIMARY KEY  (`C_Key`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='ID配置表';

-- ----------------------------
-- Records of t_aty_cfgid
-- ----------------------------

-- ----------------------------
-- Table structure for t_aty_code
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_code`;
CREATE TABLE `t_aty_code` (
  `C_PID` varchar(50) NOT NULL default '0' COMMENT '代码类型编号',
  `C_Code` varchar(50) NOT NULL COMMENT '代码',
  `C_Name` varchar(300) NOT NULL COMMENT '代码名称',
  `N_KWH` tinyint(4) NOT NULL default '2' COMMENT '可否维护',
  `C_LevelInfo` varchar(300) default NULL COMMENT '分级信息',
  `N_Valid` tinyint(4) NOT NULL default '1' COMMENT '是否有效',
  `N_Order` smallint(6) NOT NULL default '1' COMMENT '显示顺序',
  `C_Dmjp` varchar(300) default NULL COMMENT '代码简拼',
  PRIMARY KEY  (`C_PID`,`C_Code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='代码表';

-- ----------------------------
-- Records of t_aty_code
-- ----------------------------
INSERT INTO `t_aty_code` VALUES ('800', '1', '控件相关', '1', null, '1', '1', 'kjxg');
INSERT INTO `t_aty_code` VALUES ('800', '2', '解析相关', '1', null, '1', '2', 'jxxg');
INSERT INTO `t_aty_code` VALUES ('800', '3', '插件相关', '1', null, '1', '3', 'cjxg');
INSERT INTO `t_aty_code` VALUES ('800', '4', '系统相关', '1', null, '1', '4', 'xtxg');
INSERT INTO `t_aty_code` VALUES ('800', '5', '用户手册', '1', null, '1', '5', 'yhsc');
INSERT INTO `t_aty_code` VALUES ('800', '6', '支持任务', '1', null, '1', '6', 'zcrw');
INSERT INTO `t_aty_code` VALUES ('800', '7', 'Artery4', '1', null, '1', '7', 'artery4');
INSERT INTO `t_aty_code` VALUES ('801', '1', '2', '1', null, '1', '1', 'artery20');
INSERT INTO `t_aty_code` VALUES ('801', '2', '2.5', '1', null, '1', '2', 'artery25');
INSERT INTO `t_aty_code` VALUES ('801', '3', '3', '1', null, '1', '3', 'artery30');
INSERT INTO `t_aty_code` VALUES ('801', '4', '4.1', '1', null, '1', '4', 'artery41');
INSERT INTO `t_aty_code` VALUES ('802', '1', '普通', '1', null, '1', '1', 'pt');
INSERT INTO `t_aty_code` VALUES ('802', '2', '重要', '1', null, '1', '2', 'zy');
INSERT INTO `t_aty_code` VALUES ('802', '3', '紧急', '1', null, '1', '3', 'jj');
INSERT INTO `t_aty_code` VALUES ('803', '1', '解决', '1', null, '1', '1', 'jj');
INSERT INTO `t_aty_code` VALUES ('803', '2', '问题需要再描述或处理', '1', null, '1', '2', 'wtxyzmshcl');
INSERT INTO `t_aty_code` VALUES ('803', '3', '问题无法复现', '1', null, '1', '3', 'wtwffx');
INSERT INTO `t_aty_code` VALUES ('803', '4', '非缺陷', '1', null, '1', '4', 'fqx');
INSERT INTO `t_aty_code` VALUES ('803', '5', '重提起：问题再次出现', '1', null, '1', '5', 'ctqwtzccx');
INSERT INTO `t_aty_code` VALUES ('803', '6', '关闭：问题结束', '1', null, '1', '6', 'gbwtjs');
INSERT INTO `t_aty_code` VALUES ('803', '7', '挂起：问题暂不处理', '1', null, '1', '7', 'gqwtzbcl');
INSERT INTO `t_aty_code` VALUES ('804', '1', '错误', '1', null, '1', '1', 'cw');
INSERT INTO `t_aty_code` VALUES ('804', '2', '建议', '1', null, '1', '2', 'jy');
INSERT INTO `t_aty_code` VALUES ('804', '3', '新需求', '1', null, '1', '3', 'xxq');
INSERT INTO `t_aty_code` VALUES ('-1', '1', '是', '1', null, '1', '1', null);
INSERT INTO `t_aty_code` VALUES ('-1', '2', '否', '1', null, '1', '2', null);
INSERT INTO `t_aty_code` VALUES ('-13', '1', '单值', '1', null, '1', '1', null);
INSERT INTO `t_aty_code` VALUES ('-13', '2', '多值', '1', null, '1', '2', null);
INSERT INTO `t_aty_code` VALUES ('-600', '1', '科技', '1', null, '1', '1', null);
INSERT INTO `t_aty_code` VALUES ('-600', '2', '文学', '1', null, '1', '2', null);

-- ----------------------------
-- Table structure for t_aty_codetype
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_codetype`;
CREATE TABLE `t_aty_codetype` (
  `C_ID` varchar(50) NOT NULL COMMENT '代码类型编号',
  `C_Name` varchar(300) NOT NULL COMMENT '代码类型名称',
  `N_Valid` tinyint(4) NOT NULL default '1' COMMENT '是否有效',
  `N_SFKWH` tinyint(4) NOT NULL default '2' COMMENT '是否可维护',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='代码类型表';

-- ----------------------------
-- Records of t_aty_codetype
-- ----------------------------
INSERT INTO `t_aty_codetype` VALUES ('800', '问题分组', '1', '1');
INSERT INTO `t_aty_codetype` VALUES ('801', 'Artery版本', '1', '1');
INSERT INTO `t_aty_codetype` VALUES ('802', '优先级', '1', '1');
INSERT INTO `t_aty_codetype` VALUES ('803', '问题状态', '1', '1');
INSERT INTO `t_aty_codetype` VALUES ('804', '问题类型', '1', '1');
INSERT INTO `t_aty_codetype` VALUES ('-1', '是否', '1', '2');
INSERT INTO `t_aty_codetype` VALUES ('-13', '代码类型', '1', '2');
INSERT INTO `t_aty_codetype` VALUES ('-600', '图书类别', '1', '1');

-- ----------------------------
-- Table structure for t_aty_corp
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_corp`;
CREATE TABLE `t_aty_corp` (
  `C_ID` varchar(50) NOT NULL COMMENT '标识',
  `C_Name` varchar(300) NOT NULL COMMENT '单位名称',
  `C_PID` varchar(300) default NULL COMMENT '父代码',
  `N_Level` tinyint(4) NOT NULL default '4' COMMENT '单位层级',
  `C_GBM` varchar(300) default NULL COMMENT '国标码',
  `C_Alias` varchar(300) default NULL COMMENT '简称',
  `N_Valid` tinyint(4) NOT NULL default '1' COMMENT '是否有效',
  `N_Order` smallint(6) NOT NULL default '1' COMMENT '显示顺序',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='单位表';

-- ----------------------------
-- Records of t_aty_corp
-- ----------------------------

-- ----------------------------
-- Table structure for t_aty_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_dept`;
CREATE TABLE `t_aty_dept` (
  `C_ID` varchar(50) NOT NULL COMMENT '标识',
  `C_Name` varchar(300) NOT NULL COMMENT '部门名称',
  `C_PID` varchar(300) default NULL COMMENT '父代码',
  `C_CORP` varchar(300) default NULL COMMENT '所属单位',
  `C_Alias` varchar(300) default NULL COMMENT '简称',
  `N_Valid` tinyint(4) NOT NULL default '1' COMMENT '是否有效',
  `N_Order` smallint(6) NOT NULL default '1' COMMENT '显示顺序',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of t_aty_dept
-- ----------------------------

-- ----------------------------
-- Table structure for t_aty_dictcustom
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_dictcustom`;
CREATE TABLE `t_aty_dictcustom` (
  `C_ID` varchar(32) NOT NULL COMMENT '标识ID',
  `C_GroupId` varchar(300) NOT NULL COMMENT '院标识',
  `C_TableKey` varchar(300) default NULL COMMENT 'tableKey',
  `C_TableName` varchar(300) default NULL COMMENT 'tableName',
  `C_FieldName` varchar(300) default NULL COMMENT 'fieldName',
  `C_PropName` varchar(300) default NULL COMMENT 'propName',
  `C_Value` varchar(300) default NULL COMMENT '个性化值',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='数据字典个性化';

-- ----------------------------
-- Records of t_aty_dictcustom
-- ----------------------------

-- ----------------------------
-- Table structure for t_aty_planexeclog
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_planexeclog`;
CREATE TABLE `t_aty_planexeclog` (
  `C_ID` varchar(32) NOT NULL COMMENT '标识ID',
  `C_PlanID` varchar(32) default NULL COMMENT '计划ID',
  `N_LogType` tinyint(4) default NULL COMMENT '日志类别',
  `D_Time` datetime default NULL COMMENT '时间',
  `C_LogInfo` varchar(300) default NULL COMMENT '日志信息',
  `C_LogException` text COMMENT '异常信息',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='计划执行日志表';

-- ----------------------------
-- Records of t_aty_planexeclog
-- ----------------------------

-- ----------------------------
-- Table structure for t_aty_right
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_right`;
CREATE TABLE `t_aty_right` (
  `C_RightKey` varchar(150) NOT NULL COMMENT '权限字',
  `C_Name` varchar(300) NOT NULL COMMENT '权限名称',
  `C_Descript` varchar(300) default NULL COMMENT '描述',
  `N_Order` int(11) default NULL COMMENT '显示顺序',
  PRIMARY KEY  (`C_RightKey`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_aty_right
-- ----------------------------
INSERT INTO `t_aty_right` VALUES ('artery', '系统权限', '1', null);
INSERT INTO `t_aty_right` VALUES ('artery.console', '控制台管理', '2', null);

-- ----------------------------
-- Table structure for t_aty_role
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_role`;
CREATE TABLE `t_aty_role` (
  `C_ID` varchar(50) NOT NULL COMMENT 'ID',
  `C_Name` varchar(300) NOT NULL COMMENT '角色名称',
  `C_Descript` varchar(300) default NULL COMMENT '描述',
  `N_XTGY` tinyint(4) default '2' COMMENT '系统固有',
  `N_Valid` tinyint(4) default '1' COMMENT '是否有效',
  `N_Order` smallint(6) default '1' COMMENT '显示顺序',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_aty_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_aty_role_right
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_role_right`;
CREATE TABLE `t_aty_role_right` (
  `C_ID` varchar(32) NOT NULL COMMENT 'ID',
  `C_RoleID` varchar(300) NOT NULL COMMENT '角色ID',
  `C_RightKey` varchar(300) NOT NULL COMMENT '权限字',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='角色-权限关系表';

-- ----------------------------
-- Records of t_aty_role_right
-- ----------------------------

-- ----------------------------
-- Table structure for t_aty_user
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_user`;
CREATE TABLE `t_aty_user` (
  `C_ID` varchar(50) NOT NULL COMMENT '帐号ID',
  `C_LoginID` varchar(300) NOT NULL COMMENT '登录标识',
  `C_Name` varchar(300) NOT NULL COMMENT '姓名',
  `C_Password` varchar(32) NOT NULL default 'D41D8CD98F00B204E9800998ECF8427E' COMMENT '密码',
  `C_Mail` varchar(300) default NULL COMMENT '电子邮件',
  `C_IP` varchar(300) default NULL COMMENT 'IP',
  `C_XMJP` varchar(300) default NULL COMMENT '姓名简拼',
  `C_CORP` varchar(300) default NULL COMMENT '所在单位',
  `C_DEPT` varchar(300) default NULL COMMENT '所在部门',
  `N_Valid` tinyint(4) NOT NULL default '1' COMMENT '是否有效',
  `N_Order` smallint(6) NOT NULL default '1' COMMENT '显示顺序',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='帐户表';

-- ----------------------------
-- Records of t_aty_user
-- ----------------------------
INSERT INTO `t_aty_user` VALUES ('0', 'admin1', '超级管理员', 'D41D8CD98F00B204E9800998ECF8428E', '', '', 'admin1', '', '', '1', '2');
INSERT INTO `t_aty_user` VALUES ('1', 'admin2', '超级管理员', 'D41D8CD98F00B204E9800998ECF8429E', '', '', 'admin2', '', '', '1', '3');
INSERT INTO `t_aty_user` VALUES ('2', 'admin3', '超级管理员', 'D41D8CD98F00B204E9800998ECF8430E', '', '', 'admin3', '', '', '1', '4');
INSERT INTO `t_aty_user` VALUES ('3', 'admin4', '超级管理员', 'D41D8CD98F00B204E9800998ECF8431E', '', '', 'admin4', '', '', '1', '5');
INSERT INTO `t_aty_user` VALUES ('4', 'admin5', '超级管理员', 'D41D8CD98F00B204E9800998ECF8432E', '', '', 'admin5', '', '', '1', '6');

-- ----------------------------
-- Table structure for t_aty_user_right
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_user_right`;
CREATE TABLE `t_aty_user_right` (
  `C_ID` varchar(32) NOT NULL COMMENT 'ID',
  `C_UserID` varchar(300) NOT NULL COMMENT '帐号ID',
  `N_Type` tinyint(4) NOT NULL default '1' COMMENT '类型',
  `C_RoleID` varchar(300) default NULL COMMENT '角色ID',
  `C_RightKey` varchar(300) default NULL COMMENT '权限字',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='帐号-权限关系表';

-- ----------------------------
-- Records of t_aty_user_right
-- ----------------------------

-- ----------------------------
-- Table structure for t_aty_writ
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_writ`;
CREATE TABLE `t_aty_writ` (
  `C_ID` varchar(32) NOT NULL COMMENT '标识ID',
  `C_TID` varchar(32) NOT NULL COMMENT '模板ID',
  `C_Name` varchar(300) default NULL COMMENT '文书名称',
  `N_Version` tinyint(4) default NULL COMMENT '版本',
  `I_Writ` longblob COMMENT '文书内容',
  `C_WritHTML` text COMMENT 'HTML内容',
  `D_UpdateTime` datetime default NULL COMMENT '修改时间',
  `C_RYID` varchar(300) default NULL COMMENT '更新人',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='文书表';

-- ----------------------------
-- Records of t_aty_writ
-- ----------------------------

-- ----------------------------
-- Table structure for t_aty_writlog
-- ----------------------------
DROP TABLE IF EXISTS `t_aty_writlog`;
CREATE TABLE `t_aty_writlog` (
  `C_ID` varchar(32) NOT NULL COMMENT '标识ID',
  `C_WritID` varchar(32) NOT NULL COMMENT '文书ID',
  `C_Name` varchar(300) default NULL COMMENT '文书名称',
  `N_Version` tinyint(4) default NULL COMMENT '版本',
  `I_Writ` longblob COMMENT '文书内容',
  `C_WritHTML` longblob COMMENT 'HTML内容',
  `D_UpdateTime` datetime default NULL COMMENT '修改时间',
  `C_RYID` varchar(300) default NULL COMMENT '更新人',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='文书历史表';

-- ----------------------------
-- Records of t_aty_writlog
-- ----------------------------

-- ----------------------------
-- Table structure for t_eg_book
-- ----------------------------
DROP TABLE IF EXISTS `t_eg_book`;
CREATE TABLE `t_eg_book` (
  `C_ID` varchar(32) NOT NULL COMMENT 'uuid',
  `C_NAME` varchar(300) NOT NULL COMMENT '图书名称',
  `C_AUTH` varchar(300) default NULL COMMENT '作者',
  `C_PUBLISHER` varchar(300) default NULL COMMENT '出版社',
  `F_PRICE` decimal(6,2) default NULL COMMENT '单价',
  `D_PUBLISHER` datetime default NULL COMMENT '出版日期',
  `D_BUY` datetime default NULL COMMENT '购买日期',
  `C_LIBRARYID` varchar(32) NOT NULL COMMENT '图书室id',
  `C_ISBN` varchar(300) default NULL COMMENT 'ISBN',
  `C_VERSION` varchar(300) default NULL COMMENT '第几版',
  `I_PHOTO` longblob COMMENT '图书封面',
  `T_ABSTRACT` text COMMENT '摘要',
  `N_VALID` tinyint(4) default '1' COMMENT '是否有效',
  `T_INVALIDREASON` text COMMENT '删除此图书的原因',
  `N_TYPE` int(11) default NULL COMMENT '类别',
  `I_ATTACH` longblob COMMENT '附件',
  `D_BOOKING` datetime default NULL COMMENT '预订时间',
  `N_BOOKINGUSERID` decimal(17,2) default NULL COMMENT '预订人',
  `N_LENDUSERID` decimal(17,2) default NULL COMMENT '借出用户',
  `D_LEND` datetime default NULL COMMENT '借出人',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='图书表';

-- ----------------------------
-- Records of t_eg_book
-- ----------------------------
INSERT INTO `t_eg_book` VALUES ('1000000000004127', '论语别裁', '南怀瑾', '复旦大学出版社', '42.00', '2007-07-05 12:00:00', '2008-04-16 12:00:00', '19F540A7EDF8D7CCAF162B14E6A05966', '9787309032437', null, null, '内容简介\r\n由孔子的弟子及其后学编集的《论语》，是一部记载孔子言语行事的重要儒家经典。自西汉以来，《论语》所表述的孔子学说，迅速扩展，其影响遍及政治、思想、文化、教育、伦理道德等各个领域，成为中国传统文化的一大标识。有关《论语》的章句注流也累代不绝。台湾著名学者南怀瑾先生以渊博的学识，旁征博引，拈提古今而撰成的《论语别裁》，就是关于《论语》的讲演录。书中对《论语》二十篇的每一段原文，都作了详细而又生动的讲述。不仅有篇章结构、段落联结上的提示，而且有原文义旨以及所涉人文掌故的阐发。尤为新颖的是，作者将对原文的串讲撮编为一个个历史故事，蕴意深邃而妙趣横生，这在众多的《论语》章疏中是别具一格的。原书由台湾老古文化事业公司于1976年5月出版，迄至1988年，已印了十八版。为弘扬海峡两岸同源的中国文化，兹征得作者和原出版单位同意，将《论语别裁》第十八版改排出版，以供研究。\r\n我们要了解传统文化，首先必须要了解儒家的学术思想。要讲儒家的思想，首先便要研究孔孟的学术。要讲孔子的思想学术，必须先要了解《论语》。比照现代世界上的国际间文化潮流，对于自己民族、国家和历史，确定今后应该要走的路线和方向。因此若能使一般陷于现代社会心理病态的人们，在我们讲的文字言语以外去体会，能够求得一个解脱的答案，建立一种卓然不拔，矗立于风雨艰危中的人生目的和精神，这便是我所要馨香祷祝的了。', '1', null, '1', null, null, null, null, null);
INSERT INTO `t_eg_book` VALUES ('1000000000004128', '国学拾遗', '林语堂', '陕西师范大学出版社', '27.00', '2008-01-08 12:00:00', '2008-07-07 12:00:00', 'B31E784BD0C115FF2FF7157007843A75', '9787561343340', null, null, '内容简介\r\n一个人彻悟的程度，恰等于他所受痛苦的深度。\r\n《国学拾遗》包括儒家：仁者爱人、道家：大道无形和佛家：无生无灭三部分。\r\n“仁”，或真人性，在道德感的形式上，是以人的内心和外在的宇宙的道德相和谐为基础。当这个“真义”实现时，便“天地位焉，万物育焉”。这就是儒家的哲学基础。\r\n道家哲学和儒家哲学的涵义，一个代表消极的人生观，一个代表积极的人生观，那么，我相信这两种哲学不仅是中国人有之，而也是人类天性所固有的东西。\r\n我们大家都是生就一半道家主义，一半儒家主义。\r\n道家与儒家，不过是中国人灵魂的两面。一种属于活动的、有为的、相信的一面；一种是属于静观的、怀疑的、惊异的，使生活笼罩着一种如梦性质的一面。这样是很好的。\r\n佛教教导人生是一个生死轮回的圆圈，我们现在为我们前生所做的接受惩罚，我们将来我们现在所做的接受惩罚。这个圆圈是痛苦的和一个永不休止、应接不暇的幻影。人要逃脱这个圆圈才能获得拯救。', '1', null, '1', null, null, null, null, null);
INSERT INTO `t_eg_book` VALUES ('1000000000004129', '读库0802', '张立宪', '新星出版社', '33.00', '2008-01-05 12:00:00', '2008-07-07 12:00:00', 'B31E784BD0C115FF2FF7157007843A75', '9787802254855', null, null, '目录\r\n耍猴人江湖行\r\n诗人活在福利院\r\n　附：食指诗三首\r\n周有光与张允和举杯齐眉\r\n六十年代清华生活琐忆\r\n邦德，邦邦的\r\n渴望雄起的投影\r\n非洲的碎片\r\n姥姥\r\n《中性》三题\r\nAsk姬十三', '1', null, '1', null, null, null, null, null);
INSERT INTO `t_eg_book` VALUES ('1000000000004130', '求医不如求己', '中里巴人', '中国中医药出版社', '29.00', '2007-01-02 12:00:00', '2008-07-07 12:00:00', '19F540A7EDF8D7CCAF162B14E6A05966', '9787800892080', null, null, '内容简介\r\n求医不如求己2火热销售中，欢迎购买对待自己的身体要像对待自己的孩子一样，疾病就是孩子的恶作剧，这是一种巨大的能量，完全可以转化为成长的动力，但我们总是敌视和恐惧这种能量。一切治疗的最终目的都是为了激发患者的自愈潜能。 \r\n　　很多人觉得只要把经络穴位都熟记于心，汤头方剂都倒背如流，便可治己救人了。岂知学医和看病竟然是两回事儿。就象武术中的花拳绣腿，学它百种套路，一用来搏击实战，倒不如拳击一招来的实惠。所以，学武就要学少林武当真功。学医就要学治病养生心法。有人说，学些总比不学强，其实，那也不见得，不学百无禁忌，倒也潇洒，学完动辄则咎，作茧自缚。\r\n　　　《人体使用手册》作者吴清忠的中医启蒙老师中里巴人，最近推出自己的养生疗疾宝典《求医不如求己》，此书堪称“改变中国人健康生态的第一方案”。\r\n　　中医作为中国的四大国粹之一，国人了解甚少，这非常遗憾。出版这一系列图书是为了让人们对中医这个宝藏多一些了解，并且把这些简易实用的养生疗疾方法运用到自己的生活中，用中医打造健康。书中介绍的中医养生功法简单易行且功效显著、立竿见影，一上市即受到读者的追捧。', '1', null, '1', null, null, null, null, null);
INSERT INTO `t_eg_book` VALUES ('1000000000004131', '如果爱', '冯远往，梁丹妮', '长江文艺出版社', '22.00', '2008-01-06 12:00:00', '2008-07-07 12:00:00', '5B7F41EAE19AC0F8BBA1A7758A45F6E9', '9787535436726', null, null, '内容简介\r\n日子是要一天天过的，过，就是一寸一寸地走。\r\n守着相爱的人，做着心爱的事，就是幸福。\r\n爱情是我们一人伸出一只手，托起的一只极其精美的瓷瓶……\r\n人到中年，我们走过了痛苦的历练，却对表演事业痴心不改。', '1', null, '1', null, null, null, null, null);
INSERT INTO `t_eg_book` VALUES ('1000000000004132', '明若晓溪（全3册）', '明晓溪', '长江文艺出版社', '56.00', '2005-10-08 12:00:00', '2007-07-11 12:00:00', 'B31E784BD0C115FF2FF7157007843A75', '20192534', null, null, '内容简介\r\n明若晓溪：水晶般透明\r\n　　偶像时代的卡通体小说，水晶般清澈闪烁的爱情，两个至情不渝的男人，放弃谁都万般不舍，看过后，你是喜欢冰多些，还是澈多些呢？\r\n　　活力四射的女生明晓溪在进入学院的第一天，就惹到了三个超级麻烦的美少年，当她将醉酒的冰救回公寓后，却被校报传为惊天绯闻，引来了冰的“未婚妻”的愤怒和挑畔，冰命令晓溪做自己的女朋友，并搬入她的公寓开始了所谓的“同居”生活……\r\n　　明若晓溪II：冬日最灿烂的阳光\r\n　　圣诞晚餐，晓溪和澈无意中接吻了，冰非常在意。冰的父亲过世，家族发生很多变故，他的性格逐渐阴郁冰冷起来。晓溪用所有的力量来帮助他，两人的感情越来越深。澈一直默默地鼓励支持晓溪，一种微妙的感情暗暗产生。在一次危险中，澈为了保护晓溪而身受重伤…… \r\n本书是《明若晓溪》之二《冬日最灿烂的阳光》，圣诞晚餐，晓溪和澈无意中接吻了，冰非常在意。冰的父亲过世，家族发生很多变故，他的性格逐渐阴郁冰冷起来。晓溪用所有的力量来帮助他，两人的感情越来越深。澈一直默默地鼓励支持晓溪，一种微妙的感情暗暗产生。在一次危险中，澈为了保护晓溪而身受重伤……\r\n　　本书是《明若晓溪》之三《无往而不胜的童话》，晓溪与冰之间的距离越来越大，她决定分手，冰陷入痛苦中。澈的右臂受伤严重，晓溪为了给他治好病而学习针灸。她终于知道了澈对自己深挚的爱意，并且为之感动。澈的右臂痊愈时，为晓溪举办了一场音乐会。冰却在极度的绝望和痛苦中，吐血晕倒在他和晓溪昔日的公寓里。晓溪应该何去何从……', '1', null, '1', null, null, null, null, null);
INSERT INTO `t_eg_book` VALUES ('1000000000004133', '草样年华', '孙睿', '远方出版社', '19.59', '2004-01-13 12:00:00', '2005-01-12 12:00:00', '19F540A7EDF8D7CCAF162B14E6A05966', '9787805959177', null, null, '内容简介\r\n本书是一部描写大学生活的长篇爱情小说，以邱飞和周舟的爱情生活为主线，塑造了大学生邱飞、杨阳等个性鲜明的人物，在学校里，他们都是所谓不务正业的“坏”学生，无心学习，整天琢磨着逃避考试、偷窥女生宿舍、谈恋爱、玩乐队、喝酒、打架等等，为读者展开了一幅活灵活现的大学生活众生相。但他们实际上又是充满理想和热情的青春少年，他们渴望找到灵魂的出口，热爱文学和音乐，内心充满了善良和对未来的期待，只是与大学校园死板、程序化的环境格格不入，这才导致了他们的愤世嫉俗，以微弱的“坏”来与周围的环境相抗争。直到最后才猛然惊醒，为自己青春的面目全非和支离破碎而备觉荒凉，在此情可待成追忆时，才知道爱情和生活的可贵。\r\n　　作者孙睿，刚从大学毕业，其鲜活生动的文笔，幽默诙谐的文风，深得京味文学的精髓。常常使人在怅然若失之余又忍俊不止。图书策划人沈浩波认为，与郭敬明，何员外等青春作者相比，孙睿的文学准备更为充分，作为一个北京孩子，他完全继承了京味作家幽默洒脱的文风，他的小说有着王朔式的幽默，却没有王朔的油滑；有着王小波式的睿智，却没有王小波的炫耀；有着石康式的浑不吝，却不像石康那样一味地颓靡。 \r\n本书被某权威媒体评为“中国十大青春小说”之一。', '1', null, '1', null, null, null, null, null);
INSERT INTO `t_eg_book` VALUES ('1000000000004134', '梦回大清终结篇', '金子', '朝华出版社', '22.00', '2007-02-01 12:00:00', '2008-07-07 12:00:00', 'B31E784BD0C115FF2FF7157007843A75', '9787505414488', null, null, '内容简介\r\n劫后重生的茗薇自主更名为兆佳氏·鱼宁，可是更换了名字是否就能改变命运呢？失却了十三福晋身份的她还会遭遇怎样的命运起伏？与四爷和十三爷的纠葛又会出现何样的结局？\r\n　　作者以充满京味的语言，在看似平淡的开篇中，一步步打开小说情节，一个个人物也次第面出，让读者伴着清新幽默的语句慢慢置身其中，在恢宏、曲折、精彩绝伦的情节中手不释卷、如醉如痴。', '1', null, '1', null, null, null, null, null);
INSERT INTO `t_eg_book` VALUES ('1000000000004135', '武则天正传', '林语堂', '陕西师范大学出版社', '20.00', '2006-01-09 12:00:00', '2007-02-15 12:00:00', 'B31E784BD0C115FF2FF7157007843A75', '9787561336007', null, null, '内容简介\r\n武则天这个女人活了八十二岁，权倾中国达半个世纪之久。生活对她而言就如同游戏一样，她有比普通人更强烈的欲望，以至于秽闻不断；争权夺势的游戏，她玩得津津有味，她玩出的不像是一般妇人统治下的正常历史，更像一出梦呓般异想天开的荒唐戏。她决心要做一个有史以来最有威权最伟大的女人。她最后终归失败了，但绝不是她的过错；她武姓家庭中没有一个人有她一半的智慧、一半的个性、一半的政治才能。我们有太多的理由去关心这个女人，也会乐意去看一看那样历史，去看她怎样从一个才人变成一代女皇……', '1', null, '1', null, null, null, null, null);
INSERT INTO `t_eg_book` VALUES ('1000000000004136', '士兵突击', '兰晓龙', '花山文艺', '32.00', '2007-02-01 12:00:00', '2008-07-07 12:00:00', 'B31E784BD0C115FF2FF7157007843A75', '9787806739600', null, null, '内容简介\r\n这真的不是一部小说，它是哲学、是人生，是我们成长的历史。每一位读者都能在许三多身上找到自己的一些影子。许多三像是两个人，可根子里的他还是让你佩服、让你回味，甚至是他的“傻”，也足以让你去喜欢。你会觉得：“一本好书，能教会你怎样做人！”\r\n　　金戈铁马，斗志男儿，士兵的精神世界丰富和冷峻；一个有着性格缺点的普通农村孩子，他单纯而执着，在军人的世界里跌打滚爬。因为他的笨，让全人受累；因为他的认真，让全连队为之感动；因为他的执着，让全营战士为之骄傲。\r\n　　虽然他的家乡祖屋在爆炸声中变成一堆瓦砾，却无法阻止他坚毅的军人步伐；善良的怜悯，并未使他忘记军人的职责，枪杀毒犯……他在种种困厄和磨难中百炼成钢。\r\n　　他的名字叫——许三多。', '1', null, '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for t_eg_classcode
-- ----------------------------
DROP TABLE IF EXISTS `t_eg_classcode`;
CREATE TABLE `t_eg_classcode` (
  `N_ID` int(11) NOT NULL COMMENT 'id',
  `N_PID` int(11) NOT NULL default '0' COMMENT '父id',
  `C_Name` varchar(300) NOT NULL COMMENT '名称',
  `C_FBDM` varchar(300) default NULL COMMENT '法标代码',
  `N_SFYAYXJ` tinyint(4) NOT NULL default '0' COMMENT '是否有案由细节',
  `N_Type` smallint(6) default NULL COMMENT '类型',
  `N_Order` smallint(6) default '1' COMMENT '显示顺序',
  `N_Valid` tinyint(4) NOT NULL default '1' COMMENT '是否有效',
  `N_CanDeath` tinyint(4) NOT NULL default '1' COMMENT '能否判死刑',
  PRIMARY KEY  (`N_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='分级代码表';


-- ----------------------------
-- Table structure for t_eg_history
-- ----------------------------
DROP TABLE IF EXISTS `t_eg_history`;
CREATE TABLE `t_eg_history` (
  `C_ID` varchar(32) NOT NULL COMMENT 'uuid',
  `C_BOOKID` varchar(32) NOT NULL COMMENT '图书id',
  `D_LEND` datetime NOT NULL COMMENT '借出日期',
  `D_RETURN` datetime default NULL COMMENT '归还日期',
  `N_USER` decimal(17,2) NOT NULL COMMENT '借阅人id',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='借阅历史表';

-- ----------------------------
-- Records of t_eg_history
-- ----------------------------

-- ----------------------------
-- Table structure for t_eg_libadmin
-- ----------------------------
DROP TABLE IF EXISTS `t_eg_libadmin`;
CREATE TABLE `t_eg_libadmin` (
  `C_ID` varchar(32) NOT NULL COMMENT 'UUID',
  `C_LIBRARYID` varchar(32) NOT NULL COMMENT '图书室id',
  `N_USERID` decimal(17,2) NOT NULL COMMENT '用户id',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='图书室管理员表';

-- ----------------------------
-- Records of t_eg_libadmin
-- ----------------------------
INSERT INTO `t_eg_libadmin` VALUES ('6c3e4ad17527cadff0f1b206d38e5ccb', '5B7F41EAE19AC0F8BBA1A7758A45F6E9', '-1.00');
INSERT INTO `t_eg_libadmin` VALUES ('926f0c6a1be3925b50c4278a432a23c6', 'B31E784BD0C115FF2FF7157007843A75', '-1.00');
INSERT INTO `t_eg_libadmin` VALUES ('a755cde9b34b72370dec0a540d6f67b7', '19F540A7EDF8D7CCAF162B14E6A05966', '-1.00');

-- ----------------------------
-- Table structure for t_eg_library
-- ----------------------------
DROP TABLE IF EXISTS `t_eg_library`;
CREATE TABLE `t_eg_library` (
  `C_ID` varchar(32) NOT NULL COMMENT '图书室id',
  `C_NAME` varchar(300) NOT NULL COMMENT '图书室名称',
  `N_VALID` tinyint(4) default NULL COMMENT '是否有效',
  PRIMARY KEY  (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='图书室表';

-- ----------------------------
-- Records of t_eg_library
-- ----------------------------
INSERT INTO `t_eg_library` VALUES ('19F540A7EDF8D7CCAF162B14E6A05966', '第二图书室', '1');
INSERT INTO `t_eg_library` VALUES ('5B7F41EAE19AC0F8BBA1A7758A45F6E9', '第三图书室', '1');
INSERT INTO `t_eg_library` VALUES ('B31E784BD0C115FF2FF7157007843A75', '第一图书室', '1');
