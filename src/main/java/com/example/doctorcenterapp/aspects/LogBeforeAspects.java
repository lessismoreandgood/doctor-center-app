package com.example.doctorcenterapp.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

@Aspect
@Slf4j
@Component
public class LogBeforeAspects {

    @Before("@within(LogBefore) || @annotation(LogBefore)")
    public void logUserInfoBeforeRequest() {
        try {
            ServletRequestAttributes attributes
                    = Optional.ofNullable((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .orElseThrow(() -> new NoSuchElementException("ServletRequestAttributes is null"));
            HttpServletRequest request = Optional.ofNullable(attributes.getRequest())
                    .orElseThrow(() -> new NoSuchElementException("HttpServletRequest is null"));
            if (Optional.ofNullable(request).isPresent()) {

            }
        } catch (Exception e) {
            log.error("Error an user request log, logUserInfoBeforeRequest: ", e.getMessage(), e);
        }
    }
}
