package com.myq.epidemic.setting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myq.epidemic.setting.entity.Region;
import com.myq.epidemic.setting.mapper.RegionMapper;
import com.myq.epidemic.setting.model.dto.RegionDTO;
import com.myq.epidemic.setting.model.dto.RegionItemDTO;
import com.myq.epidemic.setting.model.dto.RegionPageDTO;
import com.myq.epidemic.setting.model.vo.RegionIndexVO;
import com.myq.epidemic.setting.model.vo.RegionPageVO;
import com.myq.epidemic.setting.service.RegionService;
import com.myq.epidemic.common.enums.PageResponseEnum;
import com.myq.epidemic.common.model.ResponseVO;
import com.myq.epidemic.common.utils.StringUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;


/**
 * (Region)表服务实现类
 *
 * @author makejava
 * @since 2022-02-08 16:14:15
 */
@Service("regionService")
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {

    /**
     * @Author 毛一钦
     * @Date 2022/2/22 19:44
     * @Description queryAll
     * @param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    @Cacheable(value = "region")
    public ResponseVO queryAll() {
        List<Region> regionList = this.baseMapper.selectList(null);
        return ResponseVO.success(regionList);
    }

    @Override
    @Cacheable(value = "region", key = "#param")
    public ResponseVO selectPage(RegionPageDTO param) {
        IPage<Region> page = new Page<>(param.getCurrent(), param.getSize(), param.getTotal());
        Region region = new Region();
        try {
            region.setName(param.getName());
        } catch (Exception e) {
            StringUtil.errorToString(e);
        }
        page = this.baseMapper.selectByPage(page, region);
        RegionPageVO vo = new RegionPageVO();
        try {
            vo.setSize(page.getSize())
                    .setCurrent(page.getCurrent())
                    .setPage(page.getPages())
                    .setTotal(page.getTotal())
                    .setRecords(page.getRecords());
        } catch (Exception e) {
            StringUtil.errorToString(e);
        }
        return ResponseVO.success(vo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = {"region", "regionStatistics"}, allEntries = true, beforeInvocation = true)
    public ResponseVO insertOne(RegionDTO dto) {
        QueryWrapper<Region> wrapper = new QueryWrapper<>();
        wrapper.eq("name", dto.getName());
        Region selectOne = this.baseMapper.selectOne(wrapper);

        try {
            if (selectOne != null) {
                return ResponseVO.newInstance(PageResponseEnum.PAGE_ERR, "数据重复录入", null);
            }
            dto.setRegionCount(0);
            this.baseMapper.insert(dto);
            return ResponseVO.success(null);
        } catch (Exception e) {
            StringUtil.errorToString(e);
            //  事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return ResponseVO.error();
    }

    @Override
    @CacheEvict(value = {"region", "regionStatistics"}, allEntries = true, beforeInvocation = true)
    public ResponseVO updateOne(RegionDTO dto) {
        QueryWrapper<Region> wrapper = new QueryWrapper<>();
        wrapper.eq("id", dto.getId());
        this.baseMapper.update(dto, wrapper);
        return ResponseVO.success(null);
    }

    @Override
    @CacheEvict(value = {"region", "regionStatistics"}, allEntries = true, beforeInvocation = true)
    public ResponseVO deleteOne(String param) {
        QueryWrapper<Region> wrapper = new QueryWrapper<>();
        wrapper.eq("id", param);
        this.baseMapper.delete(wrapper);
        return ResponseVO.success(null);
    }

    @Override
    public ResponseVO indexOne() {
        RegionIndexVO vo = new RegionIndexVO();
        List<RegionItemDTO> regionItemDTOS = this.baseMapper.selectListByStatistics();
        List<Region> regionsDTOS = this.baseMapper.selectAll();
        vo.setRegionItemList(regionItemDTOS);
        vo.setRegionList(regionsDTOS);
        return ResponseVO.success(vo);
    }

    @Override
    public void increase(String name) {
        QueryWrapper<Region> regionQueryWrapper = new QueryWrapper<>();
        regionQueryWrapper.eq("name", name);
        Region region = this.baseMapper.selectOne(regionQueryWrapper);

        if (region != null) {
            this.baseMapper.increase(name);
        } else {
            Region dto = new Region();
            dto.setName(name);
            this.getBaseMapper().insert(dto);
        }
    }


}
