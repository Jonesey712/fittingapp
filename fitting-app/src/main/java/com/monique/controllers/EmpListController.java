package com.monique.controllers;


import com.monique.models.forms.EmployeeData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value= "emplist")
public class EmpListController {

    static HashMap<String, String> columnChoices = new HashMap<>();

    public EmpListController() {
        columnChoices.put("employee id", "Employee ID");
        columnChoices.put("last name", "Last Name");
        columnChoices.put("first name", "First Name");
        columnChoices.put("job", "Job");
        columnChoices.put("allowance", "Allowance");
        columnChoices.put("color", "Color");
        columnChoices.put("all", "All");
    }

    @RequestMapping(value = "")
    public String empList(Model model) {
        model.addAttribute("columns", columnChoices);

        return "empList";
    }

    @RequestMapping(value = "values")
    public String listColumnValues(Model model, @RequestParam String column) {
        if (column.equals("all")) {
            ArrayList<HashMap<String, String>> employees = EmployeeData.findAll();
            model.addAttribute("title", "All Employees");
            model.addAttribute("employees", employees);

            return "list-employees";
        } else {
            model.addAttribute("title", "All " + columnChoices.get(column) + " Values");
            model.addAttribute("column", column);
            //model.addAttribute("items", items);

            return "list-column";
        }
    }

    @RequestMapping(value = "employees")
    public String ListEmployeesByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        ArrayList<HashMap<String, String>> employees = EmployeeData.findByColumnAndValue(column, value);
        model.addAttribute("title", "Employees with " + columnChoices.get(column) + ": " + value);
        model.addAttribute("employees", employees);

        return "list-employees";
    }
}
