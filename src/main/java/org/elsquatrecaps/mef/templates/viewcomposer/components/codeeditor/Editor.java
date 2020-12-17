/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.elsquatrecaps.mef.templates.viewcomposer.components.codeeditor;

/**
 * Editor type interactive tool 
 * @author josep
 */
public class Editor {
    private String defaultText;
    private int fontsize;

    /**
     * @return the fontsize
     */
    public int getFontsize() {
        return fontsize;
    }

    /**
     * @param fontsize the fontsize to set
     */
    public void setFontsize(int fontsize) {
        this.fontsize = fontsize;
    }

    /**
     * @return the defaultText
     */
    public String getDefaultText() {
        return defaultText;
    }

    /**
     * @param defaultText the defaultText to set
     */
    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }
    
}
