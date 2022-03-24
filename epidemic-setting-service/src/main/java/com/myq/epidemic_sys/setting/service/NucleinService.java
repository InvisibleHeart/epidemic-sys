package com.myq.epidemic_sys.setting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myq.epidemic_sys.common.model.ResponseVO;
import com.myq.epidemic_sys.setting.entity.Nuclein;
import com.myq.epidemic_sys.setting.model.dto.NucleinDTO;
import com.myq.epidemic_sys.setting.model.dto.NucleinPageDTO;


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
