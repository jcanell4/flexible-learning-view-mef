/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.elsquatrecaps.mef.templates.viewcomposer.components.codeeditor;

/**
 * Code editor interactive tool 
 * @author josep
 */
public class CodeEditor extends Editor{
    public String mode = null;

    public CodeEditor() {        
    }

    public CodeEditor(String mode){
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
    
    public void setMode(String mode){
        this.mode = mode;
    }
}
