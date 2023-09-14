package cs544;

import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class CustomWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
        rootContext.register(Config.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        FilterRegistration.Dynamic openInView =
                servletContext.addFilter("OpenInView", new OpenEntityManagerInViewFilter());
        openInView.addMappingForUrlPatterns(null, true, "/*");

    }
}
