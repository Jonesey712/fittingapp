package com.monique.controllers;


import com.monique.models.forms.EmployeeData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("employeesearch")
public class EmpSearchController {
    @RequestMapping(value="")
    public String empSearch(Model model) {
        model.addAttribute("columns", EmpListController.columnChoices);
        return "search";
    }

    @RequestMapping(value="results")
    public String empResults(@RequestParam String empSearch, @RequestParam String empSearchType, Model model) {
        ArrayList<HashMap<String, String>> employee;

        if (empSearchType.equals("all") || empSearch.equals("")) {
            employee = EmployeeData.findByColumnAndValue(empSearch);
        } else {
            employee = EmployeeData.findByColumnAndValue(empSearchType, empSearch);
        }
        model.addAttribute("column", EmpListController.columnChoices);
        model.addAttribute("employee", employee);
        return "search";
    }
}
