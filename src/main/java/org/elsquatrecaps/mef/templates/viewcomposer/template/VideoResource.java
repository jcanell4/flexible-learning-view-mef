/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.elsquatrecaps.mef.templates.viewcomposer.template;

import org.springframework.data.annotation.PersistenceConstructor;

/**
 *
 * @author josep
 */
public class VideoResource extends ItemResource{
    private Integer width =null;
    private Integer height =null;
    
    public VideoResource(String url, String text) {
        super(url, text);
    }

    @PersistenceConstructor
    public VideoResource(String url, String text, Integer width, Integer height) {
        super(url, text);
        this.width = width;
        this.height=height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
    
    
    
    
    
}
