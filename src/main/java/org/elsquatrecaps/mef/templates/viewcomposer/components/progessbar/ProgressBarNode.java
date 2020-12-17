/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.elsquatrecaps.mef.templates.viewcomposer.components.progessbar;

/**
 *
 * @author josep
 */
public class ProgressBarNode {
    private ProgressBarState state=ProgressBarState.DONE;
    private String id;
    private String name;

    public ProgressBarNode(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProgressBarNode(int id, String name) {
        this.setId(id);
        this.name = name;
    }

    public ProgressBarNode(char id, String name) {
        this.setId(id);
        this.name = name;
    }

    public ProgressBarNode(int id, String name, ProgressBarState state) {
        this.setId(id);
        this.name = name;
        this.state = state;
    }

    public ProgressBarNode(char id, String name, ProgressBarState state) {
        this.setId(id);
        this.name = name;
        this.state = state;
    }

    public ProgressBarNode(String id, String name, ProgressBarState state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public ProgressBarNode() {
    }
    
    

    public boolean isDone(){
        return state==ProgressBarState.DONE;
    }

    public boolean isActive(){
        return state==ProgressBarState.ACTIVE;
    }

    public ProgressBarState getState() {
        return state;
    }

    public void setState(ProgressBarState state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public final void setId(char id) {
        this.id = String.valueOf(id);
    }

    public final void setId(int id) {
        this.id = String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
