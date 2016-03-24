package com.whr.activiti.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PrintController {
	
	@RequestMapping("/print/{bkey}")
	public String printPreview(Model m) throws JsonProcessingException {
		
		Map<String,String> data = new HashMap<String,String>();
		data.put("QLR", "昆明新奇星科技有限公司");
		data.put("GYQK", "单独所有");
		data.put("ZL", "云南省昆明市五华区人民中路42号右弼大厦4楼A1");
		data.put("BDCDYH", "532628101103GB21004F00010001");
		data.put("QLLX", "国有建设用地使用权/房屋所有权");
		data.put("QLXZ", "国有建设用地出让/市场化商品房");
		data.put("YT", "城镇住宅用地/住宅");
		data.put("MJ", "共有宗地面积：1234.56㎡/\r房屋建筑面积123.27㎡");
		data.put("SYQX", "土地使用期限：2000年1月1日-2069年12月31日");
		data.put("QLQTQK", "分摊土地使用权面积：15.93㎡\r"
						+ "房屋结构：钢混\r"
						+ "专有建筑面积：102.14㎡\r"
						+ "分摊建筑面积：11.13㎡\r"
						+ "建筑物总层数：22层\r"
						+ "房屋所在层：11层\r"
						+ "房屋竣工时间：2001年12月1日\r");
		data.put("FJ","    该房屋属于赵某某和钱某某共同共有。");
		
		data.put("A","云");
		data.put("B","2016");
		data.put("C","富宁县");
		data.put("D","0000001");
		
		data.put("barcode", "此处写入条码内容");
		
		ObjectMapper om = new ObjectMapper();
		m.addAttribute("data", data);
		m.addAttribute("data_json", om.writeValueAsString(data));
		return "print/preview";
	}

}
