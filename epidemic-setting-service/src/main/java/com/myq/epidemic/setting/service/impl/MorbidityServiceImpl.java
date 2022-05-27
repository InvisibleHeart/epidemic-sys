package com.myq.epidemic.setting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myq.epidemic.setting.service.MorbidityService;
import com.myq.epidemic.setting.entity.Morbidity;
import com.myq.epidemic.setting.mapper.MorbidityMapper;
import com.myq.epidemic.setting.model.dto.MorbidityDTO;
import com.myq.epidemic.setting.model.dto.MorbidityPageDTO;
import com.myq.epidemic.setting.model.vo.MorbidityPageVO;
import com.myq.epidemic.common.model.ResponseVO;
import com.myq.epidemic.common.utils.StringUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;
import java.util.Date;

/**
 * (Morbidity)表服务实现类
 *
 * @author makejava
 * @since 2022-02-08 16:11:55
 */
@Service("morbidityService")
public class MorbidityServiceImpl extends ServiceImpl<MorbidityMapper, Morbidity> implements MorbidityService {

    /**
     * @Author 毛一钦
     * @Date 2022/2/21 17:24
     * @Description selectByPage
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    @Cacheable(value = "morbidity")
    public ResponseVO selectByPage(MorbidityPageDTO dto) {
        IPage<Morbidity> page = new Page(dto.getCurrent(), dto.getSize(), dto.getTotal());
        Morbidity morbidity = new Morbidity();
        try {
            morbidity.setPatientId(Integer.valueOf(dto.getPatientId()));
            morbidity.setRemarks(dto.getRemarks());
            morbidity.setSituationCon(dto.getSituationCon());
            morbidity.setCreatDate(dto.getCreatDate());
        } catch (Exception e) {
            StringUtil.errorToString(e);
        }
        page = this.baseMapper.selectByPage(page, morbidity);
        MorbidityPageVO vo = new MorbidityPageVO();
        try {
            vo.setCurrent(page.getCurrent())
                    .setPage(page.getPages())
                    .setSize(page.getSize())
                    .setTotal(page.getTotal())
                    .setRecords(page.getRecords());
        } catch (Exception e) {
            StringUtil.errorToString(e);
        }
        return ResponseVO.success(vo);
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/28 22:26
     * @Description insertOne
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    @CacheEvict(value = "morbidity", allEntries = true, beforeInvocation = true)
    public ResponseVO insertOne(MorbidityDTO dto) {
        dto.setCreatDate(new Date());
        this.baseMapper.insert(dto);
        return ResponseVO.success(null);
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/28 22:26
     * @Description updateOne
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    @CacheEvict(value = "morbidity", allEntries = true, beforeInvocation = true)
    public ResponseVO updateOne(MorbidityDTO dto) {
        QueryWrapper<Morbidity> morbidityQueryWrapper = new QueryWrapper<>();
        morbidityQueryWrapper.eq("id", dto.getId());
        this.baseMapper.update(dto, morbidityQueryWrapper);
        return ResponseVO.success(null);
    }

    /**
     * @Author 毛一钦
     * @Date 2022/3/3 17:23
     * @Description deleteOne
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    @CacheEvict(value = "morbidity", allEntries = true, beforeInvocation = true)
    public ResponseVO deleteOne(String param) {
        QueryWrapper<Morbidity> morbidityQueryWrapper = new QueryWrapper<>();
        morbidityQueryWrapper.eq("id", param);
        this.baseMapper.delete(morbidityQueryWrapper);
        return ResponseVO.success(null);
    }
}
