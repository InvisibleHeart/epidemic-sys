package com.myq.epidemic.setting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myq.epidemic.setting.entity.Nuclein;
import com.myq.epidemic.setting.model.dto.NucleinDTO;
import com.myq.epidemic.setting.model.dto.NucleinPageDTO;
import com.myq.epidemic.common.model.ResponseVO;


/**
 * (Nuclein)表服务接口
 *
 * @author makejava
 * @since 2022-02-08 16:12:42
 */
public interface NucleinService extends IService<Nuclein> {

    ResponseVO selectOne(String param);

    /**
     * @Author 毛一钦
     * @Date 2022/2/28 17:46
     * @Description selectByPage
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO selectByPage(NucleinPageDTO dto);

    ResponseVO insertOne(NucleinDTO dto);

    ResponseVO updateOne(NucleinDTO dto);

    ResponseVO deleteOne(String param);

}
