package com.myq.epidemic.setting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myq.epidemic.setting.entity.Nuclein;
import com.myq.epidemic.setting.mapper.NucleinMapper;
import com.myq.epidemic.setting.model.dto.NucleinDTO;
import com.myq.epidemic.setting.model.dto.NucleinPageDTO;
import com.myq.epidemic.setting.model.vo.NucleinPageVO;
import com.myq.epidemic.setting.service.NucleinService;
import com.myq.epidemic.common.model.ResponseVO;
import com.myq.epidemic.common.utils.StringUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * (Nuclein)表服务实现类
 *
 * @author makejava
 * @since 2022-02-08 16:12:42
 */
@Service("nucleinService")
public class NucleinServiceImpl extends ServiceImpl<NucleinMapper, Nuclein> implements NucleinService {

    @Override
    public ResponseVO selectOne(String param) {
        Nuclein nuclein = this.baseMapper.selectByIdNuclein(param);
        return ResponseVO.success(nuclein);
    }

    @Override
    @Cacheable(value = "nuclein")
    public ResponseVO selectByPage(NucleinPageDTO dto) {
        IPage<Nuclein> page = new Page<>(dto.getCurrent(), dto.getSize(), dto.getTotal());
        Nuclein nuclein = new Nuclein();
        try {
            nuclein.setPatientId(dto.getPatientId());
            nuclein.setNucleinDate(dto.getNucleinDate());
            nuclein.setResult(dto.getResult());
            nuclein.setRemarks(dto.getRemarks());
        } catch (Exception e) {
            StringUtil.errorToString(e);
        }
        page = this.baseMapper.selectByPage(page, nuclein);
        NucleinPageVO vo = new NucleinPageVO();
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

    @Override
    @CacheEvict(value = "nuclein", allEntries = true, beforeInvocation = true)
    public ResponseVO insertOne(NucleinDTO dto) {
        Nuclein nuclein = new Nuclein();
        try {
            nuclein.setNucleinDate(dto.getNucleinDate());
            nuclein.setResult(dto.getResult());
            nuclein.setRemarks(dto.getRemarks());
            nuclein.setPatientId(dto.getPatientId());
        } catch (Exception e) {
            StringUtil.errorToString(e);
        }
        this.baseMapper.insert(nuclein);
        return ResponseVO.success(null);
    }

    @Override
    @CacheEvict(value = "nuclein", allEntries = true, beforeInvocation = true)
    public ResponseVO updateOne(NucleinDTO dto) {
        QueryWrapper<Nuclein> nucleinQueryWrapper = new QueryWrapper<>();
        nucleinQueryWrapper.eq("id", dto.getId());
        this.baseMapper.update(dto, nucleinQueryWrapper);
        // this.baseMapper.updateById(dto);
        return ResponseVO.success(null);
    }

    @Override
    @CacheEvict(value = "nuclein", allEntries = true, beforeInvocation = true)
    public ResponseVO deleteOne(String param) {
        QueryWrapper<Nuclein> wrapper = new QueryWrapper<>();
        wrapper.eq("id", param);
        this.baseMapper.delete(wrapper);
        return ResponseVO.success(null);
    }


}
