package com.butterfly.simple.jetlinks.dashboard.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class DashboardMeasurementResponse {

    private String group;

    private Object data;


}
