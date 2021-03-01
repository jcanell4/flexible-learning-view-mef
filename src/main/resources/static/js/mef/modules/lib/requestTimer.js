import requestObject from './ajax.js'
import LibTemplate from './GlobalLibTemplate.js'

function getRequestTimersManager(){
    var requestTimersManager = {
        timers: [],

        setTimer: function(id, time, url, method, dataObject, getDataToSend, localParamForCallback, requestObject){
            var ret;
            if(time instanceof RequestTimerClass){
                ret = time;                
            }else{
                ret = new RequestTimerClass(time, url, method, dataObject, getDataToSend, localParamForCallback, requestObject);
            }
            this.timers[id] = ret;
            return ret;
        },
        setTimerAndRun: function(id, time, url, method, dataObject, getDataToSend, localParamForCallback, requestObject){
            var ret = this.setTimer(id, time, url, method, dataObject, getDataToSend, localParamForCallback, requestObject);
            ret.run();
            return ret;
        },
        getTimer:function(id){
            return this.timers[id];
        }        
    };
    return requestTimersManager;
}

class TimerDataConfig{
    constructor(time, url, dataObject, method){
        this.time = time;
        this.url = url;
        this.requestMethod = method;
    }
    
    setTime(time){
        this.time = time;
        return this;
    }
    
    setUrl(url){
        this.url = url;
        return this;
    }
    
    setRequestMethod(method){
        this.requestMethod = method;
        return this;
    }
    
    setGetDataToSend(getDataToSend){
        this.getDataToSend = getDataToSend;
        return this;
    }
    
}

class RequestTimerClass{
    constructor(time, url, method, dataObject, getDataToSend, localParamForCallback, requestObject){
        this.time = time;
        this.url = url;
        this._setDataObject(dataObject, getDataToSend);
        this.requestMethod=method;
        this.localParamForCallback=localParamForCallback;
        if(requestObject){
            if(typeof requestObject === 'string'){
                this.requestObject = LibTemplate.utils.getProperty(LibTemplate, requestObject);
            }else{
                this.requestObject = requestObject;
            }
        }else{
            this.requestObject = LibTemplate.getHttpLib();
        }
    }

    _setDataObject(dataObject, getDataToSend, stringOnly){
        if(typeof dataObject === 'string'){
            this.dataElement = document.getElementById(dataObject);
            if(!this.dataElement){
                this.dataObject = LibTemplate.utils.getProperty(LibTemplate, dataObject);
                this._setGetDataTosend(getDataToSend);
            }   
        }else if(!stringOnly && dataObject instanceof Element){
            this.dataElement = dataObject;
        }else if(!stringOnly){
            this.dataObject=dataObject;
            this._setGetDataToSend(getDataToSend);
        }            
    }
    
    _setGetDataTosend(getDataToSend){
        if(getDataToSend){
            this.getDataToSend = getDataToSend;
        }else if(this.dataObject && typeof this.dataObject["getDataToSend"] === 'function'){
            this.getDataToSend = "getDataToSend";
        }
    }

    set(timerDataConfig){
        if(timerDataConfig.dataObject){
            this._setDataObject(timerDataConfig.dataObject, timerDataConfig.getDataToSend, true);
        }else if(timerDataConfig.getDataToSend){
            this.getDataToSend = timerDataConfig.getDataToSend;
        }
        this.time = timerDataConfig.time;
        if(timerDataConfig.url){
            this.url = timerDataConfig.url;
        }
        if(timerDataConfig.requestMethod){
            this.requestMethod=timerDataConfig.requestMethod;
        }
    }

    run(){
        this.handler = setTimeout(this.request.bind(this), this.time);
    }

    restart(){
        this.stop();
        this.run();
    }

    stop(){
        clearTimeout(this.handler);
    }
    
    onResponse(jsonResponse){
        this.stop();
        this.requestObject.onResponse(jsonResponse);
        if(jsonResponse.nextTimer){
            this.set(jsonResponse.nextTimer);
            this.run();
        }
    }
    
    onError(e){
        this.stop();
        this.requestObject.onError(e);
    }

    request(){
//        var self = this;
        var data = undefined;
        if(this.dataElement){
            data = $(this.dataElement).serialize();
        }else if(this.dataObject){
            data = this.dataObject[this.getDataToSend]();
        }
        this.requestObject.requestRest(this.url, this.requestMethod, data, this.onResponse.bind(this), this.onError.bind(this));
    }
}

export {RequestTimerClass as default, getRequestTimersManager, TimerDataConfig};


