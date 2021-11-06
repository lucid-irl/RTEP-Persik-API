package com.api.persik.Interfaces;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Collection;

public interface FileManager {
    String upload(CommonsMultipartFile multipartFile);
    boolean remove(String url);
    void remove(Collection<String> urls);
}
