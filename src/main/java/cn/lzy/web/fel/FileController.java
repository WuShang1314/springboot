package cn.lzy.web.fel;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @BelongsProject: untitled1
 * @BelongsPackage: cn.lzy.web.fel
 * @ClassName FileController
 * @Author: huangjinfu
 * @CreateTime: 2023-09-18  16:34
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
public class FileController {
    /*@GetMapping("/toDownload")
    public String toDownload(){
        return "download";
    }*/

    @GetMapping("/toUpload")
    public String toUpload(){

        return "upload";
    }

    @PostMapping("/uploadFile")
        public String uploadFile(MultipartFile[] fileUpload, Model model){
        model.addAttribute("uploadStatus","上传成功!");
        for (MultipartFile file : fileUpload){
            String fileName=file.getOriginalFilename();
            fileName= UUID.randomUUID()+"_"+fileName;
            String dirPath="D:/file/";
            File filePath=new File(dirPath);
            if (!filePath.exists()){
                filePath.mkdirs();
            }
            try {
                file.transferTo(new File(dirPath+fileName));
            }catch (Exception e){
                e.printStackTrace();
                model.addAttribute("uploadStatus","上传失败: "+e.getMessage());
            }
        }
        return "upload";
    }

    //下载
    @GetMapping("/toDownload")
    public String toDownload(){
        return "download";
    }
    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,String filename)throws Exception{
        String dirPath= "D:/file/";
        File file=new File(dirPath + File.separator + filename);
        HttpHeaders headers=new HttpHeaders();
        filename=getFilename(request,filename);
        headers.setContentDispositionFormData("attachment",filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try{
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage().getBytes(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    private  String getFilename(HttpServletRequest request, String filename)
            throws Exception{
        String[] IEBrowserKeywORDS={"MSIE","Trident","Edge"};
        String userAgent=request.getHeader("User-Agent");
        for (String KeyWord : IEBrowserKeywORDS){
            if (userAgent.contains(KeyWord)){
                return URLEncoder.encode(filename,"UTF-8").replace("+","");
            }
        }
        return new String(filename.getBytes("Utf-8"),"ISO-8859-1");
    }
}



