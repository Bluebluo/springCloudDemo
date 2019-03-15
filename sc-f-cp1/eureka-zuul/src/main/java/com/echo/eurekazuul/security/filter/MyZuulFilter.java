package com.echo.eurekazuul.security.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyZuulFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(MyZuulFilter.class);

    @Override
    public boolean shouldFilter() {
        //逻辑判断是否要过滤,true表示永远过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>>> %s", request.getRequestURL().toString(), request.getMethod()));
        Object token = request.getParameter("AUTHORIZATION");
        if(token == null){
            logger.warn("token is null");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try{
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){

            }
            return null;
        }
        logger.info("ok");
        return null;
    }

    @Override
    public String filterType() {
        //pre路由前,routing时,error错误,post后
        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤顺序
        return 0;
    }
}
