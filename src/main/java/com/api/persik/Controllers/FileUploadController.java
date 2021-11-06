package com.api.persik.Controllers;

import com.alibaba.fastjson.JSONObject;
import com.api.persik.Interfaces.FileManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/upload")
public class FileUploadController {
    private final FileManager fileManager;

    public FileUploadController(FileManager fileManager){
        this.fileManager = fileManager;
    }

    @PostMapping("/image")
    public JSONObject image(@RequestParam(name = "upload")CommonsMultipartFile file){
        System.out.println(file);
        JSONObject json = new JSONObject();
        if(file == null || file.isEmpty()){
            json.put("uploaded",false);
            json.put("url","");
            return json;
        }
        if(StringUtils.isBlank(file.getOriginalFilename()) || !isAllow(file.getOriginalFilename())){
            json.put("uploaded",false);
            json.put("url","");
            return json;
        }
        String url = fileManager.upload(file);
        if (StringUtils.isBlank(url)){
            json.put("uploaded",false);
            json.put("url","");
            return json;
        } else {
            json.put("uploaded",true);
            json.put("url",url);
            return json;
        }
    }

    @PostMapping("/image-base-64")
    public JSONObject imageBase64(@RequestParam(name = "upload") String value){
        System.out.println(value);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", "soemthing url");
        return jsonObject;
    }

    private boolean isAllow(String fileName){
        String[] allowFiles = {".gif",".png",".jpg",".jpeg",".bpm",".svg"};
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        List<String> suffixList = Arrays.stream(allowFiles).collect(Collectors.toList());
        return suffixList.contains(suffix);
    }
}
