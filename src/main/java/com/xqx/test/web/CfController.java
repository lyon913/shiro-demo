package com.xqx.test.web;

import com.xqx.test.model.Cfdj;
import com.xqx.test.model.Sjcl;
import com.xqx.test.service.CfdjService;
import com.xqx.test.service.SjService;
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
@RequestMapping("/cf")
public class CfController {
    @Autowired
    private CfdjService cf;

    @RequestMapping(value = "/search.json", method = RequestMethod.POST)
    public @ResponseBody List<Cfdj> search(@RequestParam String ywh, @RequestParam(required = false) String bdcqzh){

        return cf.search(ywh,bdcqzh);
    }

}
