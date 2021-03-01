/* 
 * Copyright 2021 Grup de millora MetFlex.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import {ResponseProcessor, StatefulResponseProcessor} from './ajax.js';

class SetStateValue extends StatefulResponseProcessor{
    constructor(storage){
        super("SetStateValue", storage);
    }

    process(response){}
    
    updateStateFromResponse(response){
        this._setStorage(response.key, response.value, response.type)
    }
}

class ShowAlert extends ResponseProcessor{
    constructor(dialogNodeId){
        super("ShowAlert");
        this.dialogNodeId = dialogNodeId;       
    }
    
    get selectorNodeId(){
        return this._selectorNodeId;
    }
    
    set selectorNodeId(selectorNodeId){
        this.dialogNodeId = selectorNodeId;
    }
    
    get dialogNodeId(){
        return this._dialogNodeId;
    }
    
    set dialogNodeId(dialogNodeId){
        if(dialogNodeId.charAt(0)=="#"){
            this._selectorNodeId=dialogNodeId;
            this._dialogNodeId=dialogNodeId.substring(1);
        }else{
            this._selectorNodeId = "#"+dialogNodeId;
            this._dialogNodeId = dialogNodeId;
        }
    }
    
    process(response){
        if(this.selectorNodeId){
//            $(this.selectorNodeId).attr('title', response.title);
            $(this.selectorNodeId).html(response.message);
            $(this.selectorNodeId).dialog('option', 'title', response.title);
            $(this.selectorNodeId).dialog("open");
        }else{
            alert(response.title+"<br><br>"+response.message);
        }
    }
}

export {ResponseProcessor as default, StatefulResponseProcessor, SetStateValue, ShowAlert};


