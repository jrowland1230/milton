package com.milton.resourceserver.util;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class ResourceUtil {

    public static final String STRING_EMPTY = "";

    public static String getResourceAsString(String resourcePath) {

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        var resource = resourceLoader.getResource(resourcePath);

        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            //log.error("Unable to read resource:{}", resourcePath, e);
            return STRING_EMPTY;
        }
    }
}
