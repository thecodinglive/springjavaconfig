package info.thecodinglive.api.config;

import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by yun_dev1 on 2017-02-07.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {
        "info.thecodinglive.api.common.components",
        "info.thecodinglive.api.service"
},
        useDefaultFilters = false,
        includeFilters = {
                @Filter({Service.class, Component.class })}
)
public class ServiceConfig {
}
