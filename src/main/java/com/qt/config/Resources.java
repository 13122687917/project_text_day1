package com.qt.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "resources")
public class Resources {
    private String imagesServer;

    private String emailServer;

    public String getImagesServer() {
        return imagesServer;
    }

    public void setImagesServer(String imagesServer) {
        this.imagesServer = imagesServer;
    }

    public String getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(String emailServer) {
        this.emailServer = emailServer;
    }
}
