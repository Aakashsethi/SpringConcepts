package com.NoshVersion01.controller;

import com.NoshVersion01.modeOrDto.CalculatorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/calculator")
public class CalculatorController {
    @GetMapping("/add")
    //http://localhost:8080/api/v2/calculator/add?num1=2.5&num2=2.45
    public Double add(@RequestParam("num1") Double num1 ,@RequestParam("num2") Double num2){
        return num1+num2;
    }
    @GetMapping("/sub/{num1}/{num2}")
    public Double Sub(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2){
        Double result = null;
        if(num1>num2){
            result = num1 - num2;
        }else {
            result = num2 - num1;
        }
        return result;
    }

    @PostMapping("/mul")
    public ResponseEntity multiply(@RequestBody CalculatorDto calculatorDto){
        Double result = null;
        result = calculatorDto.getNum1() * calculatorDto.getNum2() * calculatorDto.getNum3();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }

}
