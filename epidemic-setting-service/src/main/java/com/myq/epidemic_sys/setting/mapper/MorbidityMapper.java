package com.myq.epidemic_sys.setting.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.myq.epidemic_sys.setting.entity.Morbidity;
import org.apache.ibatis.annotations.Param;


/**
 * @Author 毛一钦
 * @Date 2022/2/8 16:48
 * @Description
 **/
public interface MorbidityMapper extends BaseMapper<Morbidity> {

    IPage<Morbidity> selectByPage(IPage<Morbidity> obj, @Param("param") Morbidity morbidity);

}
