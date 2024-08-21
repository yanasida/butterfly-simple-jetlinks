package com.butterfly.simple.jetlinks.dashboard.web.response;

import com.butterfly.simple.jetlinks.dashboard.metadata.DashboardObject;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ObjectInfo {

    private String id;

    private String name;


    public static ObjectInfo of(DashboardObject object){
        ObjectInfo objectInfo=new ObjectInfo();
        objectInfo.setName(object.getDefinition().getName());
        objectInfo.setId(object.getDefinition().getId());

        return objectInfo;
    }

}
