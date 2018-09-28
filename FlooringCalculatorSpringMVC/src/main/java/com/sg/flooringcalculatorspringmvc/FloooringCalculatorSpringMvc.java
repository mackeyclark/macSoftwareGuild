/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringcalculatorspringmvc;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author macam
 */
@Controller
public class FloooringCalculatorSpringMvc {
    @RequestMapping(value="/calculateFloor", method=RequestMethod.POST)
    public String returnValues(HttpServletRequest request, Map<String, Object> model) {
        String lengthInput = request.getParameter("length");
        String widthInput = request.getParameter("width");
        String costInput = request.getParameter("materialCost");
        
        double length = Double.parseDouble(lengthInput);
        double width = Double.parseDouble(widthInput);
        double materialCost = Double.parseDouble(costInput);
        
        double area = length * width;
        double areaCost = area * materialCost;
        
        double totalHours = area / 20;
        totalHours = Math.ceil(totalHours * 4) / 4;
        double totalHourlyCost = totalHours * 86;
        double total = areaCost + totalHourlyCost;
        
        model.put("area", area);
        model.put("totalHours", totalHours);
        model.put("total", total);
        return "result";
    }
}
