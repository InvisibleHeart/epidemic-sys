package com.myq.epidemic.setting.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author 毛一钦
 * @Date 2022/3/8 14:03
 **/
@Slf4j
@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {
    /**
     * 在pojo中添加了 新增更新的注解,但是必须在数据库的字段中完成赋值的操作
     * 所以 必须明确 新增更新时操作的是那个字段,以及值是多少
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 起始版本 3.3.3(推荐)
        this.strictInsertFill(metaObject, "tCreateTime", () -> LocalDateTime.now(), LocalDateTime.class);
        this.strictInsertFill(metaObject, "tUpdateTime", () -> LocalDateTime.now(), LocalDateTime.class);
        /*this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "updateTime", () -> LocalDateTime.now(), LocalDateTime.class);*/
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        /*this.strictUpdateFill(metaObject, "updateTime", () -> LocalDateTime.now(), LocalDateTime.class);*/
        this.setFieldValByName("tUpdateTime", LocalDateTime.now(), metaObject);
    }
}
