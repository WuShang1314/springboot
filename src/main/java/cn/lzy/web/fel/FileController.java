package cn.lzy.web.fel;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Component
/**
 * @BelongsProject: untitled1
 * @BelongsPackage: cn.lzy.web.fel
 * @ClassName FileController
 * @Author: huangjinfu
 * @CreateTime: 2023-09-18  16:34
 * @Description: TODO
 * @Version: 1.0
 */
public class FileController {
    @GetMapping("/toUpload")
    public String toUpload(){
        return "upload";
    }
    @PostMapping("/uploadFile")
        public String uploadFile(MultipartFile[] fileUpload, Model model){
        model.addAllAttributes("uploadStautus","上传成功!");
        for (MultipartFile file : fileUpload){
            String
        }
    }
}
