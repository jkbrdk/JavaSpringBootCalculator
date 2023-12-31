package cz.itnetwork.spring.controllers;

import cz.itnetwork.spring.models.CalculatorDTO;
import cz.itnetwork.spring.models.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("calculator")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    @GetMapping
    public String renderCalculator(@ModelAttribute CalculatorDTO calculatorDTO) {
        return "calculator";
    }

    @PostMapping
    public String calculate(@ModelAttribute CalculatorDTO calculatorDTO, Model model) {
        float result = calculatorService.calculate(calculatorDTO);
        model.addAttribute("result", result);
        return "result";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException() {
        return "invalid-form";
    }
}