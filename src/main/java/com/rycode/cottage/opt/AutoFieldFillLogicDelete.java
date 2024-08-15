package com.rycode.cottage.opt;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
 
import java.util.Date;

/**
 * @author ry
 * &#064;class  mybatisPlus属性自动填充，对应的实体类字段上需要加：@TableField(fill = FieldFill.INSERT_UPDATE)
 */
@Slf4j
@Component
public class AutoFieldFillLogicDelete implements MetaObjectHandler {
 
    @Override
    public void insertFill(MetaObject metaObject) {

    }
 
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("自动填充删除时间");
        this.setFieldValByName("deleted_at",new Date(),metaObject);
    }
}