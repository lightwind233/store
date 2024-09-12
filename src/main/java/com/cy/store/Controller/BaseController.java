package com.cy.store.Controller;
import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
public class BaseController {
    public static final int OK = 200;

    @ExceptionHandler(ServiceException.class) //表示此方法可以处理所有类型异常，返回值为返回给前端的JSON
    public JsonResult<Void> handleException(Throwable e) {
            JsonResult<Void> result = new JsonResult<>(e);
            if (e instanceof UsernameDuplicatedException) {
                result.setState(4000);
                result.setMessage("用户名被占用");
            }else if(e instanceof UsernameNotFoundException){
                result.setState(5001);
                result.setMessage("该用户未注册");
            }else if(e instanceof PasswordNotMatchException){
                result.setState(5002);
                result.setMessage("用户密码错误");
            }else if(e instanceof InsertException){
                result.setState(5000);
                result.setMessage("注册时产生未知异常");
            }
            return result;

    }
}
