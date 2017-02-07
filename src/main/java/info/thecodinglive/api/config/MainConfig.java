package info.thecodinglive.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * Created by yun_dev1 on 2017-02-07.
 */
@Configuration
@Import(value = {DBConfig.class, ServiceConfig.class, EhCacheConfig.class})
public class MainConfig {
    private static final Logger LOG = LoggerFactory.getLogger(MainConfig.class);

    @Autowired
    private Environment env;

    @PostConstruct
    public void initApp() {
        LOG.info("스프링 프로파일 체크");
        if (env.getActiveProfiles().length == 0) {
            LOG.info("기본 프로파일로 실행");
        } else {
            for (String profile : env.getActiveProfiles()) {
                LOG.info("Detected Spring profile: {}", profile);
            }
        }
    }
}
