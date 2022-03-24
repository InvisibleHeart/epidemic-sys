//package com.myq.epidemic.controller;
//
//import com.xbb.epidemic.common.RespResult;
//import com.xbb.epidemic.constant.PathConstant;
//import com.xbb.epidemic.util.FileUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//
//@RestController
//public class UploadFileController {
//
//    private static final int FILE_SIZE_MAX = 20 * 1024 * 1024;    // 文件大小限制
//
//    /**
//     * 文件上传
//     */
//    @RequestMapping(value = "/uploadImgFile", produces = "application/json;charset=UTF-8")
//    public RespResult fileUpload(@RequestParam("file") MultipartFile multipartFile) {
//        RespResult respResult = new RespResult();
//        if (multipartFile != null) {
//            String suffix = FileUtils.fileSuffix(multipartFile.getOriginalFilename()); // 文件名后缀
//            String tmpFileName = FileUtils.createTmpFileName(suffix); // 生成保证不重复的临时文件名
//
//            if (multipartFile.getSize() > FILE_SIZE_MAX) {
//                respResult.error("上传失败：文件限制20MB");
//                return respResult;
//            }
//
//            File tmpFile = new File(PathConstant.FILE_STORAGE_ROOT, tmpFileName);
//
//            try {
//                multipartFile.transferTo(tmpFile); // 写入项目存储位置
//                respResult.success("/images/" + tmpFileName);
//            } catch (IOException e) {
//                respResult.error("上传失败：" + e.getMessage());
//                e.printStackTrace();
//            }
//        }
//        return respResult;
//    }
//
//}
