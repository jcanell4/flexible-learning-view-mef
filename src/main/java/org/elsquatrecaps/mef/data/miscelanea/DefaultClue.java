package org.elsquatrecaps.mef.data.miscelanea;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;



/**
 * DefaultClue type feedback element
 * @author josep
 */
@Document
public class DefaultClue implements Clue {
    private String id;
    private String content;

    public DefaultClue() {
        this("0000", "");
    }

    public DefaultClue(String id) {
        this(id, "");
    }


    @PersistenceConstructor
    public DefaultClue(String id, String content) {
        this.id = id;
        this.content = content;
    }
    
    /**
     * @return the content
     */
    @Override
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getId() {
        return id;
    }
    
    
    
}
