package com.myq.epidemic_sys.setting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.myq.epidemic_sys.setting.entity.Region;
import com.myq.epidemic_sys.setting.model.dto.RegionItemDTO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Author 毛一钦
 * @Date 2022/2/8 16:18
 * @Description
 **/
@Repository
public interface RegionMapper extends BaseMapper<Region> {

    IPage<Region> selectByPage(IPage<Region> obj, @Param("param") Region region);

    List<RegionItemDTO> selectListByStatistics();

    List<Region> selectAll();

    Integer increase(String name);

    Integer reduce(String name);
}
