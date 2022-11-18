package nexacro.nexacrotest1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    //view Resolver 경로 설정
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp", ".jsp");
    }

    //루트("/") 접속 시 index 페이지로 포워딩
    @Override
    @Order(Ordered.HIGHEST_PRECEDENCE + 1)
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }

    //Web Resource 경로 설정
    @Override
    @Order(Ordered.HIGHEST_PRECEDENCE + 2)
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/_resource_/**").addResourceLocations("classpath:/static/testProject/_resource_/");
        registry.addResourceHandler("/FrameBase/**").addResourceLocations("classpath:/static/testProject/FrameBase/");
        registry.addResourceHandler("/nexacrolib/**").addResourceLocations("classpath:/static/testProject/nexacrolib/");
        registry.addResourceHandler("/*.json").addResourceLocations("classpath:/static/testProject/");
        registry.addResourceHandler("/*.html").addResourceLocations("classpath:/static/testProject/");
        registry.addResourceHandler("/*.js").addResourceLocations("classpath:/static/testProject/");
    }

    //메시지 소스 생성
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();

        //메시지 프로퍼티 파일 위치/이름 지정
        source.setBasename("classpath:/messages/message");
        //기본 인코딩을 지정한다.
        source.setDefaultEncoding("UTF-8");
        //프로퍼티 파일의 변경을 감지할 시간 간격 지정
        source.setCacheSeconds(60);
        //없는 메시지일 경우 예외 발생 시키는 대신 코드를 기본 메시지로 설정
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

    //변경된 언어 정보를 기억할 로케일 리졸버 생성(세션에 저장하는 방식 사용)
    @Bean
    public SessionLocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    //언어 변경을 위한 인터셉터 생성
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
