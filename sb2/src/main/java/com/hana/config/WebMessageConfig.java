package com.hana.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.SimpleLocaleContext;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.i18n.LocaleContextResolver;

import java.util.Locale;

@Configuration
public class WebMessageConfig implements ApplicationContextAware {

    ApplicationContext context;

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages/message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        this.context = context;
    }
}

// 사용자가 사용하는 브라우져의 사용 언어 확인
@Configuration
class LocaleResolve implements LocaleContextResolver {

    @Override
    public LocaleContext resolveLocaleContext(ServerWebExchange exchange) {
        //String language = exchange.getRequest().getHeaders().getFirst("Accept-Language");
        String language = exchange.getRequest().getQueryParams().getFirst("lang");
        Locale targetLocale = Locale.getDefault();
        if (language != null && !language.isEmpty()) {
            targetLocale = Locale.forLanguageTag(language);
        }
        return new SimpleLocaleContext(targetLocale);
    }

    @Override
    public void setLocaleContext(ServerWebExchange exchange, LocaleContext localeContext) {
        throw new UnsupportedOperationException("Not Supported");
    }

}

// 언어펙 적용
@Configuration
class MessageByLocale {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private LocaleResolve localeResolver;

    public String getMessage(String code, ServerWebExchange exchange) {
        LocaleContext localeContext = localeResolver.resolveLocaleContext(exchange);
        return messageSource.getMessage(code, null, localeContext.getLocale());
    }
}
