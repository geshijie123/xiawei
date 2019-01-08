package com.xw.controller.testController;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.Assert;
import com.baomidou.mybatisplus.extension.api.R;
import com.xw.utils.ErrorCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController extends ApiController {


    /**
     * 测试通用 Api Controller 逻辑
     */
    @GetMapping("/testAPI")
    public R<Object> testError(String test) {
//        非空判断 null判断
//        Assert.notNull(ErrorCode.TEST, test);

//         小于0 return失败
//        Assert.geZero(-10,ErrorCode.TEST);

        return success(1);
    }

    @RequestMapping("/demo")
    public R demo(String aaa){


//        return success(232323);
//        return failed("233");
        Assert.isTrue(false,ErrorCode.DOT_LOGIN);
        return failed("233");
    }

}
