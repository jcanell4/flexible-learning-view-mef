

//function __getUrl(url){
//    var lpId = $("meta[name='id']").attr("content");
//    if(lpId){
//        url += url.includes('?')?('&lp_id='+lpId):('?lp_id='+lpId);
//    }
//    return url;
//}

function __buildProp(url, method, data, complete, onError, dataType){
    var prop = {
        url : url,
        type: method
    };
    if($.isFunction(data)){
        complete = data;
        data = undefined;
    }
    if(data){                    
        prop.data=data;
    }
    if(complete){
        prop.complete=complete;
    }
    if(onError){
        prop.error = onError;
    }
    if(dataType){
        prop.dataType = dataType;
    }
    return prop;
}

//function getAjaxObject(){
//    
//    
//    var ajaxObject = {
//        load:function(selector, url, method, data, complete, onError){
//            var _loadWithError = function( /*String*/ responseText, /*String*/ textStatus, /*jqXHR*/ jqXHR ){
//                if(jqXHR.status>=400){
//                    onError({responseJSON:{error:""+ jqXHR.status + " HTTP Error", message:jqXHR.statusText}} );
//                }else{
//                    complete(responseText, textStatus, jqXHR);
//                }
//            };
//            var ret;
//            if((typeof method!=="string")
//                    || !["GET", "POST"].includes(method.toUpperCase())){
//                complete = data;
//                data = method; 
//                method = "GET";
//            }
//            if(method.toUpperCase()==="GET"){
//                ret = $(selector).load(__getUrl(url), data, _loadWithError);
//            }else{
//                var prop = __buildProp(url, method, data, complete, onError);
//                ret = $.ajax(prop).done(function(response){
//                    $(selector).html(response);
//                });
//            }
//            return ret;
//        },
//        requestResponseRest:function(url, method, data, responseRest){
//            this.requestRest(url, method, data, responseRest.onResponse.bind(responseRest), responseRest.onError.bind(responseRest));
//            
//        },
//        requestRest:function(url, method, data, complete, onError){
//            var ret;
//            if((typeof method!=="string")
//                    || !["GET", "POST"].includes(method.toUpperCase())){
//                complete = data;
//                data = method; 
//                method = "GET";
//            }
//            var prop = __buildProp(url, method, data, undefined, undefined, "json");
//            ret = $.ajax(prop).done(function(data){
//                if(Array.isArray(data)){
//                    for(var value of data){
//                        complete(value);
//                    }
//                }else{
//                    complete(data);
//                }
//            }).fail(function(jhttp, st, thr){
//                onError(thr);
//            });
//            return ret;   
//        },
//        request:function(url, method, data, complete, onError){
//            var ret;
//            if((typeof method!=="string")
//                    || !["GET", "POST"].includes(method.toUpperCase())){
//                complete = data;
//                data = method; 
//                method = "GET";
//            }
//            var prop = __buildProp(url, method, data, complete, onError);
//            ret = $.ajax(prop);
//            return ret;        
//        }
//    };
//    return ajaxObject;
//}

class Request{
    set extraQuery(extraquery){
        this._extraquery=extraquery;
    }
    
    get extraQuery(){
        return this._extraquery;
    }
    
    set callableObject(callableObject){
        this._callableObject = callableObject;
    }
    
    get callableObject(){
        if(this._callableObject==undefined){
            this._callableObject={};
        }
        return this._callableObject;
    }

    set processorDictionary(dict){
        this._processorDictionary = dict;
    }
    
    get processorDictionary(){
        if(this._processorDictionary==undefined){
            this._processorDictionary={};
        }
        return this._processorDictionary;
    }
    
    _getUrl(url){
        var sep = "?";
        if(url.includes("?")){
            sep = "&";
        }
        return url+sep+this.extraQuery;
    }

    onResponse(jsonResponse, textStatus, jqXHR){ //
        if(jsonResponse.onReciveCallable){
            if(jsonResponse.onReciveCallable.params){
                this.callableObject[jsonResponse.onReciveCallable.name](jsonResponse.onReciveCallable.params, this.localParamForCallback);
            }else{
                this.callableObject[jsonResponse.onReciveCallable.name](this.localParamForCallback);
            }
        }
        if(jsonResponse.onReciveProcessor){
            if(jsonResponse.onReciveProcessor.response){
                this.processorDictionary[jsonResponse.onReciveProcessor.name].run(jsonResponse.onReciveProcessor.response);
            }else{
                this.processorDictionary[jsonResponse.onReciveProcessor.name].run();
            }
        }
        
    }
    
    onError(error){
        throw error;
    }
    
    load(selector, url, method, data, complete, onError){
        var ret;
        if((typeof method!=="string")
                || !["GET", "POST"].includes(method.toUpperCase())){
            complete = data;
            data = method; 
            method = "GET";
        }
        if(!complete){
            complete = this.onResponse.bind(this);
        }
        if(!onError){
            onError = this.onError.bind(this);
        }
        var _loadWithError = function( /*String*/ responseText, /*String*/ textStatus, /*jqXHR*/ jqXHR ){
            if(jqXHR.status>=400){
                onError({responseJSON:{error:""+ jqXHR.status + " HTTP Error", message:jqXHR.statusText}} );
            }else{
                complete(responseText, textStatus, jqXHR);
            }
        };
        if(method.toUpperCase()==="GET"){
            ret = $(selector).load(this._getUrl(url), data, _loadWithError);
        }else{
            var prop = __buildProp(this._getUrl(url), method, data, complete, onError);
            ret = $.ajax(prop).done(function(response){
                $(selector).html(response);
            });
        }
        return ret;
    }
        
    requestRest(url, method, data, complete, onError){
        var ret;
        if((typeof method!=="string")
                || !["GET", "POST"].includes(method.toUpperCase())){
            onError = complete;
            complete = data;
            data = method; 
            method = "GET";
        }
        if(!complete){
            complete = this.onResponse.bind(this);
        }
        if(!onError){
            onError = this.onError.bind(this);
        }
        var prop = __buildProp(this._getUrl(url), method, data, undefined, undefined, "json");
        ret = $.ajax(prop).done(function(data){
            if(Array.isArray(data)){
                for(var value of data){
                    complete(value);
                }
            }else{
                complete(data);
            }
        }).fail(function(jhttp, st, thr){
            onError(thr);
        });
        return ret;   
    }
    
    request(url, method, data, complete, onError){
        var ret;
        if((typeof method!=="string")
                || !["GET", "POST"].includes(method.toUpperCase())){
            complete = data;
            data = method; 
            method = "GET";
        }
        if(!complete){
            complete = this.onResponse.bind(this);
        }
        if(!onError){
            onError = this.onError.bind(this);
        }
        var prop = __buildProp(this._getUrl(url), method, data, complete, onError);
        ret = $.ajax(prop);
        return ret;        
    }    

}

class ResponseProcessor{
    constructor(type){
        this.type = type;
    }
    
    run(responseJson){
        this.process(responseJson);
        
    }
    process(responseJson){
        throw new Error('You have to implement the method process!');
    }
}

class StatefulResponseProcessor extends ResponseProcessor{
    constructor(type, externalStatefulStorage){
        super(type);
        this.statefulStorage = {"local":{}, "global":{}};
        if(externalStatefulStorage){
            this.statefulStorage['global'] = externalStatefulStorage;
        }
    }
    
    run(responseJson){
        super.run(responseJson);
        this.updateStateFromResponse(responseJson);
        
    }
    process(responseJson){
        throw new Error('You have to implement the method process!');
    }
    
    updateStateFromResponse(responseJson){
        throw new Error('You have to implement the method setState!');
    }
    
    getState(id){
        var ret;
        
        if(id && (typeof id === 'string' || id instanceof String)){
                ret = this.___getState(id, this.statefulStorage.local);
                if(ret==null){
                    ret = this.___getState(id, this.statefulStorage.global);
                }
        }else{
            ret = Object.assing({},this.statefulStorage.global,this.statefulStorage.local);
        }
        return ret;
    }
    
    ___getState(id, storage){
        var ret = null;
        var aId = id.split(/\.(.+)/);
        if(id in storage){
            ret = storage[id]
            if(aId.length>1){
                ret = this._getState(aId[1], ret);
            }
        }
        return ret;
    }
    
    _setState(id, value, type){
        if(!type || type !="local") { type = "global";}
        if(id && (typeof id === 'string' || id instanceof String)){
                this.___setState(id, value, this.statefulStorage[type]);
        }
    }

    ___setState(id, value, storage){
        var strg = storage;
        var aId = id.split(".");
        var until = aId.length-1;
        for(var ind=0; ind<until; ind++){
            if(!strg[aId[ind]]==undefined){
                strg[aId[ind]]={};
            }
            strg = strg[aId[ind]];
        }
        strg[aId[until]]=value;
    }
    
}

var requestObject = new Request();

export {requestObject as default, Request, ResponseProcessor, StatefulResponseProcessor};

