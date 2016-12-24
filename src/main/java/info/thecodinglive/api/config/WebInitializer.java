package info.thecodinglive.api.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{


	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{DBConfig.class, EhCacheConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class, RestConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
