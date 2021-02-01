/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.elsquatrecaps.mef.templates.viewcomposer.template;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 *
 * @author josep
 */
public class MefNavConfigData implements Serializable{
    private VideoResource video;
    private String learningProposalName;
    private String summary;
    private String infoText;
    private final List<ItemResource> relatedResources;

    public MefNavConfigData() {
        this.relatedResources = new ArrayList<>();
    }

    @PersistenceConstructor
    protected MefNavConfigData(VideoResource video, String learningProposalName, String summary, String infoText, List<ItemResource> relatedResources) {
        this.relatedResources = relatedResources;
        this.video = video;
        this.learningProposalName = learningProposalName;
        this.summary = summary;
        this.infoText = infoText;
    }
    
    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoUrl) {
        this.infoText = infoUrl;
    }

    public List<ItemResource> getRelatedResources() {
        return relatedResources;
    }

    public ItemResource getRelatedResource(int pos) {
        return relatedResources.get(pos);
    }

    public void addRelatedResource(ItemResource resource) {
        relatedResources.add(resource);
    }
    
    public boolean hasInfoText(){
        return infoText!=null && !infoText.isEmpty();                
    }

    public boolean hasSummary(){
        return summary!=null && !summary.isEmpty();                
    }

    public boolean hasExplanatoryVideo(){
        return video!=null;                
    }

    public VideoResource getVideo() {
        return video;
    }

    public void setVideo(VideoResource video) {
        this.video = video;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return the learningProposalName
     */
    public String getLearningProposalName() {
        return learningProposalName;
    }

    /**
     * @param learningProposalName the learningProposalName to set
     */
    public void setLearningProposalName(String learningProposalName) {
        this.learningProposalName = learningProposalName;
    }
}
