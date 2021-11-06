package com.api.persik.Services;

import com.api.persik.Interfaces.FileManager;
import com.api.persik.Utils.Consts;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service(value = "fileManager")
public class FileManagerService implements FileManager {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    @Override
    public String upload(CommonsMultipartFile multipartFile) {
        String storageRoot = Consts.FILE_STORAGE_ROOT+ File.separator+"images";
        String path = "";
        String suffix = Objects.requireNonNull(multipartFile.getOriginalFilename())
                .substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        String fileName = SIMPLE_DATE_FORMAT.format(new Date())+"-"
                + UUID.randomUUID().toString().replaceAll("-","").toLowerCase()
                + suffix;
        System.out.println("filename: "+ fileName);
        File file = new File(storageRoot+File.separator+fileName);
        System.out.println("directory: "+ storageRoot+File.separator+fileName);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(file);
            path = "/"+fileName;
        }catch (IOException e){
            e.printStackTrace();
        }
        return path;
    }

    @Override
    public boolean remove(String url) {
        String path = Consts.FILE_STORAGE_ROOT+ File.separator+"images"+url;
        File file = new File(path);
        if(file.exists() && file.isFile()){
            return file.delete();
        }
        return false;
    }

    @Override
    public void remove(Collection<String> urls) {
        if(!CollectionUtils.isEmpty(urls)){
            urls.stream().allMatch(this::remove);
        }
    }
}
