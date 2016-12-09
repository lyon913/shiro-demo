package com.xqx.web;

import com.xqx.model.Sjcl;
import com.xqx.service.SjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Lyon on 2016/10/19.
 */
@Controller
@RequestMapping("/sj")
public class SjController {
    @Autowired
    private SjService sj;

    @RequestMapping(value = "/data.json", method = RequestMethod.POST)
    public @ResponseBody List<Sjcl> getSjclList(@RequestParam  String ywh, @RequestParam String djsx){
        return sj.getSjcl(ywh,djsx);
    }

    @RequestMapping(value = "/autoComplete.json", method = RequestMethod.POST)
    public @ResponseBody List<Sjcl> autoComplete(@RequestParam("q")  String key){
        if(key == null || key.length() < 1) {
            return sj.autoComplete(key);
        }
        return null;
    }

}
