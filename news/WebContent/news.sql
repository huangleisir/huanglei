-- MySQL dump 10.13  Distrib 5.5.27, for Win32 (x86)
--
-- Host: localhost    Database: news
-- ------------------------------------------------------
-- Server version	5.5.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `content` mediumtext NOT NULL COMMENT '内容',
  `author` varchar(30) NOT NULL COMMENT '作者',
  `wonderful` varchar(200) NOT NULL COMMENT '精彩内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `class_id` varchar(32) NOT NULL COMMENT '分类ID',
  `click_num` int(11) NOT NULL DEFAULT '0' COMMENT '点击量',
  `reply_num` int(11) NOT NULL DEFAULT '0' COMMENT '回复量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES ('10','空间被破高清艳图流出，EVE大天使成受害者','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 14:02:14','1',1,1),('11','美女耀人眼！《如龙4》夜店女郎Rio写真','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 14:02:14','1',0,1),('12','盘点至今令人怀念的十大儿童游戏','afafafafafafafafafadfadafafa','bao','1111','2012-12-28 14:02:14','1',11,1),('13','质量不等於销量 十大商业效果极差的游戏','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 14:12:09','1',7,1),('14','美学生为玩游戏集体生病 老师无奈改课','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 14:11:07','1',4,2),('15','这是一种挑战 高端网页游戏盘点','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 14:11:15','2',2,1),('16','爱得起买不起 最贵游戏周边','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:57:41','1',0,1),('17','《洛奇英雄传》引擎老旧外挂开发泛滥','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:54:32','1',0,1),('18','《TERA》新版本“毁灭的魔兽”初见成效','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:54:32','1',0,1),('19','《剑灵》不惧与暗黑3撞车 期待正面交锋','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:54:32','1',0,1),('2','游戏嫩模MizzZee丁字内衣喷血写真','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:54:32','1',3,1),('20','周韦彤性感写真集合，性感激情倾情绽放','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:54:33','1',0,1),('21','惊艳游戏美女模特展傲人身姿','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:57:41','1',0,1),('22','网游美女自拍惊艳美图','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:57:41','1',0,1),('23','妖姬宅游戏美女刘子璇演绎《贵妇》','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:57:41','1',0,1),('24','EA最贵游戏星球大战开发投入费用超七亿','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:57:41','1',0,1),('25','《上古世纪》全新地图“虎脊山脉”视频欣赏','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:57:41','1',0,1),('26','外媒曝光COD新作使命召唤：精英或为网络版','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:57:42','1',0,1),('27','《上古世纪》即将三测 “战场系统”揭秘','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:57:42','1',0,1),('28','《众神与英雄》任务向导和财产系统的更新','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:57:42','1',0,1),('29','《暗黑3》新经济系统揭秘 物价高涨金币难得','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:57:42','1',0,1),('3','以《愤怒的小鸟》之名，盘点六大愤怒游戏','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 13:57:42','1',3,1),('31','萌动可爱 《艾尔之光》美女玩家COS蕾娜爱莎','affafafafafafa','bao','test','2012-12-22 14:00:26','1',10,0),('32','巩新亮全新写真秀傲人身材 迷人身段引人遐想','affafafafafafa','bao','test','2012-12-22 14:00:26','1',5,0),('33','美国海军创作游戏 训练抗击索马里海盗','affafafafafafa','bao','test','2012-12-22 14:00:26','1',3,0),('34','抵不住的制服诱惑 美女护士COS给力展示','affafafafafafa','bao','test','2012-12-22 14:00:26','1',1,0),('35','海量精美DotA英雄系列壁纸不容错过','affafafafafafa','bao','test','2012-12-22 14:00:26','1',1,0),('36','重装机兵3代言人爆乳女星杉原杏璃喷血写真','affafafafafafa','bao','test','2012-12-22 14:00:26','1',16,0),('37','游戏美眉家中私照(图) 乖巧中的性感','affafafafafafa','bao','test','2012-12-22 14:00:26','1',1,0),('38','酥胸半露 网络美女孟茜拍摄时尚大片','affafafafafafa','bao','test','2012-12-22 14:00:26','1',1,0),('39','“波”涛滚滚 日本超萌游戏美少女赏','affafafafafafa','bao','test','2012-12-22 14:00:26','1',1,0),('4','洛克人之父杭州签售 被当地房价吓倒','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 14:00:26','1',1,1),('42','九城救命稻草《火瀑》新PVP宣传视频','affafafafafafa','bao','test','2012-12-22 14:00:26','1',1,0),('43','台湾游戏电竞节目美女主持写真','affafafafafafa','bao','test','2012-12-22 14:00:26','1',1,0),('44','《星球大战》肉搏种族 西斯武士视频','affafafafafafa','bao','test','2012-12-22 14:00:26','1',1,0),('45','小姐你的大腿太粗 《剑灵》性感人物','affafafafafafa','bao','test','2012-12-22 14:00:26','1',1,0),('46','《暗黑破坏神3》高级怪将增死亡特效','affafafafafafa','bao','test','2012-12-22 14:00:26','1',1,0),('47','《虐杀原型2》等大作参展2011美国E3','affafafafafafa','bao','test','2012-12-22 14:00:26','1',1,0),('48','网游派系恩仇录（二）从金山走出的人','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 12:08:48','1',0,1),('5','yesky强力推荐 同方钢铁侠K41H仅售3999','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 14:00:27','1',0,1),('6','杨幂大尺度《男人装》 酥胸半裸香臀毕露','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 14:00:27','1',0,1),('7','《洛奇英雄传》美服更新 增加新副本','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 14:02:14','1',0,1),('8','《裂隙》全新副本“熔岩之心”公开','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 14:02:14','1',0,1),('9','《神秘世界》剧情延续无终结 避免单调重复','afafafafafafafafafadfadafafa','bao','1111','2012-12-22 14:02:14','1',0,1),('E0686D18FFA8587A0000BA0B0A2235E7','标题:','内容:','记者:','主要内容:','2012-12-28 07:32:10','1',1,0),('E06E8A38FFA8587A007AE29E79A14C91','xxx','xxxxx','xxxxx','xxxx','2012-12-28 07:35:31','1',1,0),('E070EEC5FFA8587A0044A70E0657B1C0','ttt','tttt','tt','ttt','2012-12-28 07:36:35','1',0,0),('E0740F00FFA8587A01BF194F02EF5975','ttttt','ttttt','ttt','ttt','2012-12-28 07:40:00','1',0,0),('E074311FFFA8587A01A6092590E48E81','yyy','yyyy','yyy','yyyyy','2012-12-28 07:40:09','5',3,0),('E0E58227FFA8587A0014A6F874F85307','郭声琨任公安部部长 孟建柱不再兼任','中新网12月28日电 十一届全国人大常委会第三十次会议刚刚经过表决决定，免去孟建柱兼任的公安部部长职务，任命郭声琨为公安部部长。\n\n郭声琨简历\n\n汉族，1954年10月生，江西兴国人，1974年12月加入中国共产党，1973年8月参加工作，北京科技大学经济管理学院管理科学与工程专业毕业，在职研究生学历，管理学博士，教授级高级工程师。\n\n1973-1977年 江西省兴国县插队知青\n\n1977-1979年 江西冶金学院矿业系选矿专业学习\n\n1979-1985年 冶金部画眉坳钨矿机选车间技术员、工段长、党支部书记，生产副主任、行政副主任、主任\n\n1985-1990年 中国有色金属工业总公司画眉坳钨矿矿长\n\n1990-1992年 中国有色金属工业总公司画眉坳钨矿矿长兼贵溪银矿建设指挥部总指挥、党委书记\n\n1992-1993年 中国有色金属工业总公司贵溪银矿矿长、党委书记\n\n1993-1997年 中国有色金属工业南昌公司经理、党组书记\n\n(其间：1994-1996年 中南工业大学管理工程系管理工程专业研究生课程在职学习，获硕士学位；1995-1996年 中央党校一年制中青年干部培训班学习)\n\n1997-1998年 中国有色金属工业总公司副总经理、党组成员\n\n1998-1999年 国家有色金属工业局党组成员\n\n1999-2000年 国家有色金属工业局副局长、党组成员\n\n2000-2001年 国有重点大型企业监事会主席，中国铝业公司筹备组组长\n\n2001-2004年 中国铝业公司总经理、党组书记，兼中铝股份有限公司董事长、总裁\n\n2004-2007年 广西壮族自治区党委副书记，自治区人民政府副主席、党组副书记\n\n(2003-2007年北京科技大学经济管理学院博士研究生班管理科学与工程专业在职学习，获管理学博士学位)\n\n2007年11月-2008年1月 广西壮族自治区党委书记\n\n2008年1月- 广西壮族自治区党委书记(至2012年12月)，广西壮族自治区人大常委会主任','时政新闻中国新闻网','     十一届全国人大常委会第三十次会议刚刚经过表决决定，免去孟建柱兼任的公安部部长职务，任命郭声琨为公安部部长。       十一届全国人大常委会第三十次会议刚刚经过表决决定，免去孟建柱兼任的公安部部长职务，任命郭声琨为公安部部长。','2012-12-28 09:49:11','1',44,0),('E1A5C44BFFA8006401C187CE08A5AC12','冯梦莹','冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹','冯梦莹','冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹','2012-12-28 13:13:55','1',5,0),('E1C6C9C9FFA80064005DF6F6BF4E08AF','afa','<ul><li><u><b>fafaf</b></u>				   \n				  </li></ul>','fasfaf','afafa','2012-12-28 13:49:59','1',0,0),('E1C880CFFFA800640150B282D041AF19','十二届全国人大一次会议将选举国家主席','<p style=\"TEXT-INDENT: 2em\">【龙虎网报道】（记者 于倩）记者今天17:35从江苏广电总台办公室了解到，由于干露露撒泼事件而被停播近一个月的江苏教育电视台将被并入江苏广电总台，并将于明日(12月29日)正式更名为“江苏教育频道”后复播，主管单位也从江苏省教育厅变更为江苏广电。</p><p style=\"TEXT-INDENT: 2em\">记者从江苏教育<strike><u><b><i>电视台工作人员处获悉，该台也接到了12月29日开播的通知，具体情况并不了解。据江苏广电办公室工作人员透露，目前“江苏教育频道”将由办公室主任刘旭东 (<a class=\"a-tips-Article-QQ\" href=\"http://t.qq.com/adong888#pref=qqcom.keyword\" target=\"_blank\">微博</a>)主管。</i></b></u></strike><br /></p><p style=\"TEXT-INDENT: 2em\">事件回顾</p><p style=\"TEXT-INDENT: 2em\">广电总局叫停《棒棒棒》 禁丑闻劣迹者发声出镜</p><p style=\"TEXT-INDENT: 2em\">11\n月24日，干露露母女三人受邀录制江苏教育电视台综艺节目《棒棒棒》，三人现场放泼撒野、大曝粗口。11月28日，国家广播电影电视总局官方网站贴出公\n告，宣布停播江苏教育电视台节目《棒棒棒》，原因在于江苏教育电视台违反《广播电视管理条例》，罔顾媒体社会责任，为丑恶言行提供展示舞台，造成恶劣社会\n影响，广电总局将依据有关法规，给予严肃处理，并要求严禁丑闻劣迹者发生出镜。</p><p style=\"TEXT-INDENT: 2em\">事后，广电总局给予江苏教育电视台自2012年11月30日零时起停播整顿的处理。</p><p style=\"TEXT-INDENT: 2em\">江苏教育电视台概况</p>江\n苏教育电视台创办于1996年12月20日，停播前拥有《江苏教育新闻》、《成长》、《服务到家》、《新闻地理》、《黄金剧场》、《语林漫步》、《苏商》\n等栏目和节目，2002年，参与投资兴建民办全日制高校——应天职业技术学院，在校生规模已近6000人。2006年5月1日，一个全新的数字频道江苏招\n考频道顺利开播。<br />xxxxxxxxxxxxxxxxxxxxxxxx<p style=\"TEXT-INDENT: 2em\"> </p>','时政新闻财经网','【十二届全国人大一次会议明年3月5日开 将选举国家主席、副主席等】全国人大常委会决定，十二届全国人大一次会议于明年3月5日召开。会议将选举十二届全国人大常委会委员长、副委员长、秘书长、委员，选举中华人民共和国主席、副主席，决定国务院总理人选等; 听取审议国务院机构改革方案。','2012-12-28 13:51:52','1',10,2),('E1CB6191FFA80064006FEF4D35D9DC53','国防部：军队严密监控日战机','<p style=\"TEXT-INDENT: 2em\">【龙虎网报道】（记者 于倩）记者今天17:35从江苏广电总台办公室了解到，由于干露露撒泼事件而被停播近一个月的江苏教育电视台将被并入江苏广电总台，并将于明日(12月29日)正式更名为“江苏教育频道”后复播，主管单位也从江苏省教育厅变更为江苏广电。</p><p style=\"TEXT-INDENT: 2em\">记者从江苏教育电视台工作人员处获悉，该台也接到了12月29日开播的通知，具体情况并不了解。据江苏广电办公室工作人员透露，目前“江苏教育频道”将由办公室主任刘旭东 (<a class=\"a-tips-Article-QQ\" href=\"http://t.qq.com/adong888#pref=qqcom.keyword\" target=\"_blank\">微博</a>)主管。</p><p style=\"TEXT-INDENT: 2em\">事件回顾</p><p style=\"TEXT-INDENT: 2em\">广电总局叫停《棒棒棒》 禁丑闻劣迹者发声出镜</p><p style=\"TEXT-INDENT: 2em\">11\n月24日，干露露母女三人受邀录制江苏教育电视台综艺节目《棒棒棒》，三人现场放泼撒野、大曝粗口。11月28日，国家广播电影电视总局官方网站贴出公\n告，宣布停播江苏教育电视台节目《棒棒棒》，原因在于江苏教育电视台违反《广播电视管理条例》，罔顾媒体社会责任，为丑恶言行提供展示舞台，造成恶劣社会\n影响，广电总局将依据有关法规，给予严肃处理，并要求严禁丑闻劣迹者发生出镜。</p><p style=\"TEXT-INDENT: 2em\">事后，广电总局给予江苏教育电视台自2012年11月30日零时起停播整顿的处理。</p><p style=\"TEXT-INDENT: 2em\"><b>江苏教育电视台概况</b></p>江\n苏教育电视台创办于1996年12月20日，停播前拥有《江苏教育新闻》、《成长》、《服务到家》、《新闻地理》、《黄金剧场》、《语林漫步》、《苏商》\n等栏目和节目，2002年，参与投资兴建民办全日制高校——应天职业技术学院，在校生规模已近6000人。2006年5月1日，一个全新的数字频道江苏招\n考频道顺利开播。','中华网','【龙虎网报道】（记者 于倩）记者今天17:35从江苏广电总台办公室了解到，由于干露露撒泼事件而被停播近一个月的江苏教育电视台将被并入江苏广电总台，并将于明日(12月29日)正式更名为“江苏教育频道”后复播，主管单位也从江苏省教育厅变更为江苏广电。','2012-12-28 13:55:00','1',1,0),('E1CF85AFFFA8006401241A2DCDA22AE9','全国人大常委会关于加强网络信息保护决定','<p style=\"TEXT-INDENT: 2em\">新华社北京12月28日电 <b>全国人民代表大会常务委员会关于加强网络信息保护的决定</b></p><p style=\"TEXT-INDENT: 2em\">（2012年12月28日第十一届全国人民代表大会常务委员会第三十次会议通过）</p><p style=\"TEXT-INDENT: 2em\">为了保护网络信息安全，保障公民、法人和其他组织的合法权益，维护国家安全和社会公共利益，特作如下决定：</p><p style=\"TEXT-INDENT: 2em\">一、国家保护能够识别公民个人身份和涉及公民个人隐私的电子信息。</p><p style=\"TEXT-INDENT: 2em\">任何组织和个人不得窃取或者以其他非法方式获取公民个人电子信息，不得出售或者非法向他人提供公民个人电子信息。</p><p style=\"TEXT-INDENT: 2em\">二、网络服务提供者和其他企业事业单位在业务活动中收集、使用公民个人电子信息，应当遵循合法、正当、必要的原则，明示收集、使用信息的目的、方式和范围，并经被收集者同意，不得违反法律、法规的规定和双方的约定收集、使用信息。</p><p style=\"TEXT-INDENT: 2em\">网络服务提供者和其他企业事业单位收集、使用公民个人电子信息，应当公开其收集、使用规则。</p><p style=\"TEXT-INDENT: 2em\">三、网络服务提供者和其他企业事业单位及其工作人员对在业务活动中收集的公民个人电子信息必须严格保密，不得泄露、篡改、毁损，不得出售或者非法向他人提供。</p><p style=\"TEXT-INDENT: 2em\">四、网络服务提供者和其他企业事业单位应当采取技术措施和其他必要措施，确保信息安全，防止在业务活动中收集的公民个人电子信息泄露、毁损、丢失。在发生或者可能发生信息泄露、毁损、丢失的情况时，应当立即采取补救措施。</p><p style=\"TEXT-INDENT: 2em\">五、网络服务提供者应当加强对其用户发布的信息的管理，发现法律、法规禁止发布或者传输的信息的，应当立即停止传输该信息，采取消除等处置措施，保存有关记录，并向有关主管部门报告。</p><p style=\"TEXT-INDENT: 2em\">六、网络服务提供者为用户办理网站接入服务，办理固定电话、移动电话等入网手续，或者为用户提供信息发布服务，应当在与用户签订协议或者确认提供服务时，要求用户提供真实身份信息。</p><p style=\"TEXT-INDENT: 2em\">七、任何组织和个人未经电子信息接收者同意或者请求，或者电子信息接收者明确表示拒绝的，不得向其固定电话、移动电话或者个人电子邮箱发送商业性电子信息。</p><p style=\"TEXT-INDENT: 2em\">八、公民发现泄露个人身份、散布个人隐私等侵害其合法权益的网络信息，或者受到商业性电子信息侵扰的，有权要求网络服务提供者删除有关信息或者采取其他必要措施予以制止。</p><p style=\"TEXT-INDENT: 2em\">九、任何组织和个人对窃取或者以其他非法方式获取、出售或者非法向他人提供公民个人电子信息的违法犯罪行为以及其他网络信息违法犯罪行为，有权向有关主管部门举报、控告；接到举报、控告的部门应当依法及时处理。被侵权人可以依法提起诉讼。</p><p style=\"TEXT-INDENT: 2em\">十、\n有关主管部门应当在各自职权范围内依法履行职责，采取技术措施和其他必要措施，防范、制止和查处窃取或者以其他非法方式获取、出售或者非法向他人提供公民\n个人电子信息的违法犯罪行为以及其他网络信息违法犯罪行为。有关主管部门依法履行职责时，网络服务提供者应当予以配合，提供技术支持。</p><p style=\"TEXT-INDENT: 2em\">国家机关及其工作人员对在履行职责中知悉的公民个人电子信息应当予以保密，不得泄露、篡改、毁损，不得出售或者非法向他人提供。</p><p style=\"TEXT-INDENT: 2em\">十\n一、对有违反本决定行为的，依法给予警告、罚款、没收违法所得、吊销许可证或者取消备案、关闭网站、禁止有关责任人员从事网络服务业务等处罚，记入社会信\n用档案并予以公布；构成违反治安管理行为的，依法给予治安管理处罚。构成犯罪的，依法追究刑事责任。侵害他人民事权益的，依法承担民事责任。</p><p style=\"TEXT-INDENT: 2em\">十二、本决定自公布之日起施行。</p>','时政新闻新华网','新华社北京12月28日电 全国人民代表大会常务委员会关于加强网络信息保护的决定','2012-12-28 13:59:31','10',9,0),('E506B603FFA800640132BFB472D11556','ffxxxxxxxxxx','<br _moz_editor_bogus_node=\"TRUE\" />','ff','fff','2012-12-29 04:58:40','1',2,0),('E513D479FFA8006401B7B48BA0C7CBEA','fff','fff','fff','fff','2012-12-29 05:13:00','1',1,0);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reply` (
  `id` varchar(32) NOT NULL,
  `news_id` varchar(32) NOT NULL COMMENT '新闻ID',
  `reply` varchar(2000) NOT NULL COMMENT '回复',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '回复时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES ('E4BB970EFFA80064017B63CEAFBFF158','E1A5C44BFFA8006401C187CE08A5AC12','莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯','1','2012-12-29 03:36:37'),('E4BBAECCFFA80064015759C5329AB4A6','E1A5C44BFFA8006401C187CE08A5AC12','莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯梦莹冯','1','2012-12-29 03:36:43'),('E515D1FEFFA8006400F70CE1D79FEA94','E1C880CFFFA800640150B282D041AF19','    fffsfss','2','2012-12-29 05:15:10'),('E515FA56FFA80064012B52D3497A751A','E1C880CFFFA800640150B282D041AF19','vvsfs','2','2012-12-29 05:15:20');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT '登录帐号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `sex` varchar(1) NOT NULL COMMENT '性别(0男，1女)',
  `age` int(11) NOT NULL COMMENT '年龄',
  `email` varchar(30) NOT NULL COMMENT '邮箱',
  `flag` varchar(1) NOT NULL COMMENT '权限标识',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','1','admin123','1',20,'5907@qq.com','1','2012-12-28 06:33:39'),('2','admin','admin123','1',20,'5907@qq.com','0','2012-12-28 06:20:21'),('E04B10BDFFA8587A018E40F2B89B376B','2','admin123','0',1,'111@qq.com111@qq.com','1','2012-12-28 06:55:14'),('E04D1B62FFA8587A008FC146C8E7DFF6','小白','admin123','0',1,'222@qq.com','1','2012-12-28 06:57:27');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-12-29 21:59:21
