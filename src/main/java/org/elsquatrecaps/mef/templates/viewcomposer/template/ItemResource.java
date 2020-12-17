package org.elsquatrecaps.mef.templates.viewcomposer.template;

public class ItemResource {
    private String url;
    private String text;

    public ItemResource(String url, String text) {
        this.init(url, text);
    }
    
    public void init(String url, String text) {
        this.url = url;
        this.text = text;
    }
    
    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }    
}
