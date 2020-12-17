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
public enum ProgressBarState {
    TODO(""),
    ACTIVE("active"),
    DONE("done");
    
    private final String value;
     
    private ProgressBarState(String displayValue) {
        this.value = displayValue;
    }
     
    public String getValue() {
        return value;
    }
}
