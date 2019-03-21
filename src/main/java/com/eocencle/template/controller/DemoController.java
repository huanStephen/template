package com.eocencle.template.controller;

import com.eocencle.template.vo.Result;
import com.eocencle.template.entity.DemoEntity;
import com.eocencle.template.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: shizh26250
 * @Date: 2018/12/1 09:55
 * @Description:
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @Value("${main.page}")
    private String page;

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String index() {
        return this.page;
    }

    @RequestMapping("/enter")
    @ResponseBody
    public Result<DemoEntity> enter(Integer id) {
        Result<DemoEntity> result = new Result<>(Result.STATUS_SUCCESSED);

        if (null == id || 0 == id) {
            result.setStatus(Result.STATUS_FAILED);
            result.setMsg("id 不能为空或0");
            return result;
        }

        result.setData(this.demoService.getDemo(id));
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result<Boolean> update() throws Exception {
        Result<Boolean> result = new Result<>(Result.STATUS_SUCCESSED);

        this.demoService.updateDemo();

        result.setData(true);
        return result;
    }

}
