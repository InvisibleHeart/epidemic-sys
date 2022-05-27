/*
 Navicat Premium Data Transfer

 Source Server         : 毕业设计nacos
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : 139.196.55.213:3306
 Source Schema         : nacos_config

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 27/05/2022 10:56:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `effect` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_schema` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (5, 'epidemic-setting-service-test.yaml', 'DEFAULT_GROUP', 'server:\n  port: 9096\n\n  #---------------数据库连接配置--------------\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    type: com.alibaba.druid.pool.DruidDataSource\n    #serverTimezone=UTC 设置数据库时区,MySQL默认安装时是使用的美国时区\n    url: jdbc:mysql://139.196.55.213:3306/epidemic_sys?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true\n    username: maoyq\n    password: myq123\n    #自动往数据库建表\n    #    schema:\n    #      - classpath:department.sql\n\n    initialSize: 5\n    minIdle: 5\n    maxActive: 20\n    maxWait: 60000\n    timeBetweenEvictionRunsMillis: 60000\n    minEvictableIdleTimeMillis: 300000\n    validationQuery: SELECT 1 FROM DUAL\n    testWhileIdle: true\n    testOnBorrow: false\n    testOnReturn: false\n    poolPreparedStatements: true\n    #   配置监控统计拦截的filters，去掉后监控界面sql无法统计，\'wall\'用于防火墙\n    filters: stat,wall,log4j\n    maxPoolPreparedStatementPerConnectionSize: 20\n    useGlobalDataSourceStat: true\n    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500\n  ##### 缓存  ####\n  cache:\n    type: redis\n  ######## redis #########\n  redis:\n    database: 0\n    password: myq123\n    port: 6379\n    host: 139.196.55.213\n    \n    jedis:\n      pool:\n        max-active: 200\n        # 连接池最大阻塞等待时间（使用负值表示没有限制） 表示连接池的链接拿完了 现在去申请需要等待的时间\n        max-wait: -1\n        # 连接池中的最大空闲连接\n        max-idle: 10\n        # 连接池中的最小空闲连接\n        min-idle: 0\n      # 连接超时时间（毫秒） 去链接redis服务端\n      timeout: 6000\n  \n  data:\n    mongodb:\n#      uri: mongodb://admin:myq123@139.196.55.213:27017/epidemic_sys\n      host: 139.196.55.213\n      port: 27017\n      database: epidemic_sys\n      username: admin\n      password: myq123\n\n\n# Mybatis-Plus 配置\nmybatis-plus:\n  mapper-locations: classpath:/mapper/*Mapper.xml\n  typeAliasesPackage: com.myq.epidemic.setting.entity\n  #typeEnumsPackage: com.fendo.mybatis.plus.entity.enums\n  #  global-config:\n  #    id-type: 2\n  #    field-strategy: 2\n  #    db-column-underline: true\n  #    refresh-mapper: true\n  #    #capital-mode: true\n  #    #key-generator: com.baomidou.springboot.xxx\n  #    logic-delete-value: 0\n  #    logic-not-delete-value: 1\n  #    sql-injector: com.baomidou.mybatisplus.mapper.LogicSqlInjector\n  #    #meta-object-handler: com.baomidou.springboot.xxx\n  #    #sql-injector: com.baomidou.springboot.xxx\n  # configuration:\n  #    map-underscore-to-camel-case: true\n  #    cache-enabled: false\n  global-config:\n    id-type: 0  #0:数据库ID自增   1:用户输入id  2:全局唯一id(IdWorker)  3:全局唯一ID(uuid)\n    db-column-underline: false\n    refresh-mapper: true\n    # db-config:\n    #   logic-delete-field: flag # 全局逻辑删除的实体字段名(since 3.3.0,配置后可以忽略不配置步骤2)\n    #   logic-delete-value: 1 # 逻辑已删除值(默认为 1)\n    #   logic-not-delete-value: 0 # 逻辑未删除值(默认为 0)\n  configuration:\n    map-underscore-to-camel-case: true\n    cache-enabled: true #配置的缓存的全局开关\n    lazyLoadingEnabled: true #延时加载的开关\n    multipleResultSetsEnabled: true #开启的话，延时加载一个属性时会加载该对象全部属性，否则按需加载属性\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl #打印sql语句,调试用\n\n###############\n#   多线程配置\n#############\nexecutor:\n  CorePoolSize: 8\n  MaxPoolSize: 8\n  QueueCapacity: 200\n  KeepAliveSeconds: 3000\n  ThreadNamePrefix: callybxWork -\n  taskCallSize: 10\n', '9990e7d667f2145096e2782b0911ce2e', '2022-02-08 03:25:50', '2022-05-10 16:09:32', 'nacos', '183.228.46.115', '', '', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (6, 'epidemic-gateway-test.yaml', 'DEFAULT_GROUP', 'server:\n  port: 9090\nspring:\n  cloud:\n    gateway:\n      routes:\n        - id: epidemic-setting-service # 路由的id,没有规定规则但要求唯一,建议配合服务名\n            #匹配后提供服务的路由地址\n         # uri: http://127.0.0.1:9092\n          uri: lb://epidemic-setting-service\n          predicates:\n            - Path=/setting/** # 断言，路径相匹配的进行路由\n          filters:\n            # 去除的路径前缀的个数(strip)\n            - StripPrefix=1\n        - id: epidemic-modular-forecast # 路由的id,没有规定规则但要求唯一,建议配合服务名\n            #匹配后提供服务的路由地址\n         # uri: http://127.0.0.1:9092\n          uri: lb://epidemic-modular-forecast\n          predicates:\n            - Path=/utils/** # 断言，路径相匹配的进行路由\n          filters:\n            # 去除的路径前缀的个数(strip)\n            - StripPrefix=1\n      discovery:\n        locator:\n          enabled: true\n      globalcors:\n        cors-configurations:    # 全局的跨网域处理\n          \'[/**]\':\n            allowCredentials: true\n            allowedOriginPatterns: \"*\"      # 允许哪些网站的跨网域请求\n            allowedHeaders: \"*\"             # 允许请求中携带的头信息\n            allowedMethods:\n              - \"OPTIONS\"\n              - \"GET\"\n              - \"POST\"\n              - \"PUT\"\n              - \"DELETE\"\n            maxAge: 36000                      \n        add-to-simple-url-handler-mapping: true', '6f7bcba28af29f972416b5aaa3b02a83', '2022-02-08 03:27:57', '2022-04-25 13:00:44', 'nacos', '117.147.44.128', '', '', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (11, 'epidemic-modular-forecast-test.yaml', 'DEFAULT_GROUP', 'server:\n  port: 9999\n\n##### feign ####\nfeign:\n  client:\n    config:\n      default:\n        connectTimeout: 7000\n        readTimeout: 7000', '8a5db15c7f5fadf5666dafce2e673a60', '2022-03-18 04:46:23', '2022-03-23 01:24:09', 'nacos', '219.137.112.36', '', '', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (15, 'epidemic-front-test.yaml', 'DEFAULT_GROUP', '#   端口\r\nserver.port=9000\r\n\r\nspring.freemarker.template-loader-path=classpath:/templates/\r\nspring.freemarker.charset=utf-8\r\nspring.freemarker.cache=false\r\nspring.freemarker.expose-request-attributes=true\r\nspring.freemarker.expose-session-attributes=true\r\nspring.freemarker.expose-spring-macro-helpers=true\r\nspring.freemarker.suffix=.ftl\r\n\r\nspring.jackson.date-format=yyyy-MM-dd\r\nspring.jackson.time-zone=GMT+8\r\n\r\ndebug=true\r\nlogging.level.com.myq.epidemic.mapper=debug\r\nlogging.level.org.springframework.boot.autoconfigure=error\r\n\r\n', '3cb7eba5d32c47464b7b86f14e95d06f', '2022-05-14 15:11:46', '2022-05-14 15:11:46', 'nacos', '183.228.47.13', '', '', NULL, NULL, NULL, 'properties', NULL);
INSERT INTO `config_info` VALUES (16, 'epidemic-front-test.properties', 'DEFAULT_GROUP', '#   端口\r\nserver.port=9000\r\n\r\nspring.freemarker.template-loader-path=classpath:/templates/\r\nspring.freemarker.charset=utf-8\r\nspring.freemarker.cache=false\r\nspring.freemarker.expose-request-attributes=true\r\nspring.freemarker.expose-session-attributes=true\r\nspring.freemarker.expose-spring-macro-helpers=true\r\nspring.freemarker.suffix=.ftl\r\n\r\nspring.jackson.date-format=yyyy-MM-dd\r\nspring.jackson.time-zone=GMT+8\r\n\r\ndebug=true\r\nlogging.level.com.myq.epidemic.mapper=debug\r\nlogging.level.org.springframework.boot.autoconfigure=error\r\n\r\n', '3cb7eba5d32c47464b7b86f14e95d06f', '2022-05-14 15:12:39', '2022-05-14 15:12:39', NULL, '183.228.47.13', '', '', NULL, NULL, NULL, 'properties', NULL);

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime(0) NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id`, `group_id`, `tenant_id`, `datum_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '增加租户字段' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_beta' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id`, `group_id`, `tenant_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_tag' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `tag_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`) USING BTREE,
  UNIQUE INDEX `uk_configtagrelation_configidtag`(`id`, `tag_name`, `tag_type`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_tag_relation' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info`  (
  `id` bigint(64) UNSIGNED NOT NULL,
  `nid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `op_type` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `idx_gmt_create`(`gmt_create`) USING BTREE,
  INDEX `idx_gmt_modified`(`gmt_modified`) USING BTREE,
  INDEX `idx_did`(`data_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '多租户改造' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
INSERT INTO `his_config_info` VALUES (5, 20, 'epidemic-setting-service-test.yaml', 'DEFAULT_GROUP', '', 'server:\n  port: 9096\n\n  #---------------数据库连接配置--------------\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    type: com.alibaba.druid.pool.DruidDataSource\n    #serverTimezone=UTC 设置数据库时区,MySQL默认安装时是使用的美国时区\n    url: jdbc:mysql://139.196.55.213:3306/epidemic_sys?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true\n    username: maoyq\n    password: myq123\n    #自动往数据库建表\n    #    schema:\n    #      - classpath:department.sql\n\n    initialSize: 5\n    minIdle: 5\n    maxActive: 20\n    maxWait: 60000\n    timeBetweenEvictionRunsMillis: 60000\n    minEvictableIdleTimeMillis: 300000\n    validationQuery: SELECT 1 FROM DUAL\n    testWhileIdle: true\n    testOnBorrow: false\n    testOnReturn: false\n    poolPreparedStatements: true\n    #   配置监控统计拦截的filters，去掉后监控界面sql无法统计，\'wall\'用于防火墙\n    filters: stat,wall,log4j\n    maxPoolPreparedStatementPerConnectionSize: 20\n    useGlobalDataSourceStat: true\n    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500\n  ##### 缓存  ####\n  cache:\n    type: redis\n  ######## redis #########\n  redis:\n    database: 0\n    password: myq123\n    port: 6379\n    host: 139.196.55.213\n    \n    jedis:\n      pool:\n        max-active: 200\n        # 连接池最大阻塞等待时间（使用负值表示没有限制） 表示连接池的链接拿完了 现在去申请需要等待的时间\n        max-wait: -1\n        # 连接池中的最大空闲连接\n        max-idle: 10\n        # 连接池中的最小空闲连接\n        min-idle: 0\n      # 连接超时时间（毫秒） 去链接redis服务端\n      timeout: 6000\n\n\n# Mybatis-Plus 配置\nmybatis-plus:\n  mapper-locations: classpath:/mapper/*Mapper.xml\n  typeAliasesPackage: com.myq.epidemic_sys.setting.entity\n  #typeEnumsPackage: com.fendo.mybatis.plus.entity.enums\n  #  global-config:\n  #    id-type: 2\n  #    field-strategy: 2\n  #    db-column-underline: true\n  #    refresh-mapper: true\n  #    #capital-mode: true\n  #    #key-generator: com.baomidou.springboot.xxx\n  #    logic-delete-value: 0\n  #    logic-not-delete-value: 1\n  #    sql-injector: com.baomidou.mybatisplus.mapper.LogicSqlInjector\n  #    #meta-object-handler: com.baomidou.springboot.xxx\n  #    #sql-injector: com.baomidou.springboot.xxx\n  # configuration:\n  #    map-underscore-to-camel-case: true\n  #    cache-enabled: false\n  global-config:\n    id-type: 0  #0:数据库ID自增   1:用户输入id  2:全局唯一id(IdWorker)  3:全局唯一ID(uuid)\n    db-column-underline: false\n    refresh-mapper: true\n    # db-config:\n    #   logic-delete-field: flag # 全局逻辑删除的实体字段名(since 3.3.0,配置后可以忽略不配置步骤2)\n    #   logic-delete-value: 1 # 逻辑已删除值(默认为 1)\n    #   logic-not-delete-value: 0 # 逻辑未删除值(默认为 0)\n  configuration:\n    map-underscore-to-camel-case: true\n    cache-enabled: true #配置的缓存的全局开关\n    lazyLoadingEnabled: true #延时加载的开关\n    multipleResultSetsEnabled: true #开启的话，延时加载一个属性时会加载该对象全部属性，否则按需加载属性\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl #打印sql语句,调试用\n\n###############\n#   多线程配置\n#############\nexecutor:\n  CorePoolSize: 8\n  MaxPoolSize: 8\n  QueueCapacity: 200\n  KeepAliveSeconds: 3000\n  ThreadNamePrefix: callybxWork -\n  taskCallSize: 10\n', '1a1c2db73efa2c45088cb919211d0155', '2022-05-04 23:31:59', '2022-05-04 15:32:00', 'nacos', '117.147.44.251', 'U', '');
INSERT INTO `his_config_info` VALUES (5, 21, 'epidemic-setting-service-test.yaml', 'DEFAULT_GROUP', '', 'server:\n  port: 9096\n\n  #---------------数据库连接配置--------------\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    type: com.alibaba.druid.pool.DruidDataSource\n    #serverTimezone=UTC 设置数据库时区,MySQL默认安装时是使用的美国时区\n    url: jdbc:mysql://139.196.55.213:3306/epidemic_sys?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true\n    username: maoyq\n    password: myq123\n    #自动往数据库建表\n    #    schema:\n    #      - classpath:department.sql\n\n    initialSize: 5\n    minIdle: 5\n    maxActive: 20\n    maxWait: 60000\n    timeBetweenEvictionRunsMillis: 60000\n    minEvictableIdleTimeMillis: 300000\n    validationQuery: SELECT 1 FROM DUAL\n    testWhileIdle: true\n    testOnBorrow: false\n    testOnReturn: false\n    poolPreparedStatements: true\n    #   配置监控统计拦截的filters，去掉后监控界面sql无法统计，\'wall\'用于防火墙\n    filters: stat,wall,log4j\n    maxPoolPreparedStatementPerConnectionSize: 20\n    useGlobalDataSourceStat: true\n    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500\n  ##### 缓存  ####\n  cache:\n    type: redis\n  ######## redis #########\n  redis:\n    database: 0\n    password: myq123\n    port: 6379\n    host: 139.196.55.213\n    \n    jedis:\n      pool:\n        max-active: 200\n        # 连接池最大阻塞等待时间（使用负值表示没有限制） 表示连接池的链接拿完了 现在去申请需要等待的时间\n        max-wait: -1\n        # 连接池中的最大空闲连接\n        max-idle: 10\n        # 连接池中的最小空闲连接\n        min-idle: 0\n      # 连接超时时间（毫秒） 去链接redis服务端\n      timeout: 6000\n  \n  data:\n    mongodb:\n#      uri: mongodb://admin:myq123@139.196.55.213:27017/epidemic_sys\n      host: 139.196.55.213\n      port: 27017\n      database: epidemic_sys\n      username: admin\n      password: myq123\n\n\n# Mybatis-Plus 配置\nmybatis-plus:\n  mapper-locations: classpath:/mapper/*Mapper.xml\n  typeAliasesPackage: com.myq.epidemic_sys.setting.entity\n  #typeEnumsPackage: com.fendo.mybatis.plus.entity.enums\n  #  global-config:\n  #    id-type: 2\n  #    field-strategy: 2\n  #    db-column-underline: true\n  #    refresh-mapper: true\n  #    #capital-mode: true\n  #    #key-generator: com.baomidou.springboot.xxx\n  #    logic-delete-value: 0\n  #    logic-not-delete-value: 1\n  #    sql-injector: com.baomidou.mybatisplus.mapper.LogicSqlInjector\n  #    #meta-object-handler: com.baomidou.springboot.xxx\n  #    #sql-injector: com.baomidou.springboot.xxx\n  # configuration:\n  #    map-underscore-to-camel-case: true\n  #    cache-enabled: false\n  global-config:\n    id-type: 0  #0:数据库ID自增   1:用户输入id  2:全局唯一id(IdWorker)  3:全局唯一ID(uuid)\n    db-column-underline: false\n    refresh-mapper: true\n    # db-config:\n    #   logic-delete-field: flag # 全局逻辑删除的实体字段名(since 3.3.0,配置后可以忽略不配置步骤2)\n    #   logic-delete-value: 1 # 逻辑已删除值(默认为 1)\n    #   logic-not-delete-value: 0 # 逻辑未删除值(默认为 0)\n  configuration:\n    map-underscore-to-camel-case: true\n    cache-enabled: true #配置的缓存的全局开关\n    lazyLoadingEnabled: true #延时加载的开关\n    multipleResultSetsEnabled: true #开启的话，延时加载一个属性时会加载该对象全部属性，否则按需加载属性\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl #打印sql语句,调试用\n\n###############\n#   多线程配置\n#############\nexecutor:\n  CorePoolSize: 8\n  MaxPoolSize: 8\n  QueueCapacity: 200\n  KeepAliveSeconds: 3000\n  ThreadNamePrefix: callybxWork -\n  taskCallSize: 10\n', '4a098ba5d131e4468709a5c24c13fdf1', '2022-05-11 00:09:32', '2022-05-10 16:09:32', 'nacos', '183.228.46.115', 'U', '');
INSERT INTO `his_config_info` VALUES (0, 22, 'epidemic-front-test.yaml', 'DEFAULT_GROUP', '', '#   端口\r\nserver.port=9000\r\n\r\nspring.freemarker.template-loader-path=classpath:/templates/\r\nspring.freemarker.charset=utf-8\r\nspring.freemarker.cache=false\r\nspring.freemarker.expose-request-attributes=true\r\nspring.freemarker.expose-session-attributes=true\r\nspring.freemarker.expose-spring-macro-helpers=true\r\nspring.freemarker.suffix=.ftl\r\n\r\nspring.jackson.date-format=yyyy-MM-dd\r\nspring.jackson.time-zone=GMT+8\r\n\r\ndebug=true\r\nlogging.level.com.myq.epidemic.mapper=debug\r\nlogging.level.org.springframework.boot.autoconfigure=error\r\n\r\n', '3cb7eba5d32c47464b7b86f14e95d06f', '2022-05-14 23:11:46', '2022-05-14 15:11:46', 'nacos', '183.228.47.13', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 23, 'epidemic-front-test.properties', 'DEFAULT_GROUP', '', '#   端口\r\nserver.port=9000\r\n\r\nspring.freemarker.template-loader-path=classpath:/templates/\r\nspring.freemarker.charset=utf-8\r\nspring.freemarker.cache=false\r\nspring.freemarker.expose-request-attributes=true\r\nspring.freemarker.expose-session-attributes=true\r\nspring.freemarker.expose-spring-macro-helpers=true\r\nspring.freemarker.suffix=.ftl\r\n\r\nspring.jackson.date-format=yyyy-MM-dd\r\nspring.jackson.time-zone=GMT+8\r\n\r\ndebug=true\r\nlogging.level.com.myq.epidemic.mapper=debug\r\nlogging.level.org.springframework.boot.autoconfigure=error\r\n\r\n', '3cb7eba5d32c47464b7b86f14e95d06f', '2022-05-14 23:12:39', '2022-05-14 15:12:39', NULL, '183.228.47.13', 'I', '');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `action` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE INDEX `uk_role_permission`(`role`, `resource`, `action`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE INDEX `idx_user_role`(`username`, `role`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '租户容量信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp`, `tenant_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'tenant_info' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
