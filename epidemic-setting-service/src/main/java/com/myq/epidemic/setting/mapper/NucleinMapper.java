package com.myq.epidemic.setting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.myq.epidemic.setting.entity.Nuclein;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @Author 毛一钦
 * @Date 2022/2/8 16:47
 * @Description
 **/
@Repository
public interface NucleinMapper extends BaseMapper<Nuclein> {

    IPage<Nuclein> selectByPage(IPage<Nuclein> obj, @Param("param") Nuclein nuclein);

    Nuclein selectByIdNuclein(@Param("param") String id);

}
