package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {


    @InjectMocks
    private CalculatorController calculatorController;
    static Double num1;
    static Double num2;
    static Double num3;
    static Double num4;
    @BeforeEach
    void init(){
        System.out.println("Before Each");
        num1=3.5;
        num2=3.5;
        num3=3.5;
        num4=3.5;

    }

    @BeforeAll
    static void beforeAll()
    {
        System.out.println("Before All");
        num1=3.5;
        num2=3.5;
        num3=3.5;
        num4=3.5;


    }
    @AfterAll
    static void afterAll()
    {
        System.out.println("After All");

        num1=null;
        num2=null;
        num3=null;
        num4=null;

    }
    @AfterEach
    void destroy()
    {
        System.out.println("After Each");
        num1=null;
        num2=null;
        num3=null;
        num4=null;


    }
    @Test
    @DisplayName("Test addition Success Scenario")
    void  testAddFunction_Success()
    {
        System.out.println("Test Addition Success Sceneraio");
       Double result= calculatorController.add(num1,num2);
//       expected is 7.0
//        Always perform Assertion add success
        Assertions.assertEquals(7.0,result);

    }
    @Test
    @Disabled

    @DisplayName("Test addition Faileure Scenario")
    void  testAddFunction_Faileure()
    {
        System.out.println("Test Addition Faileure Sceneraio");

        Double result= calculatorController.add(num1-0.5,num2);
//       Deliberately give wrong expected is 7.0
//        Always perform Assertion add success
        Assertions.assertNotEquals(7.0,result);

    }

    @Test
    @DisplayName("Test subtraction Faileure Scenario")

    public void testSubtraction()
    {
        System.out.println("Test Addition Faileure Sceneraio");

        Double result= calculatorController.subtract(num1+2,num2);
//       Deliberately give wrong expected is 7.0
//        Always perform Assertion add success
        Assertions.assertEquals(1.0,result);

    }

    @Test
    @DisplayName("Test Multiplication")
    void getMultiply()
    {
        CalculatorDTO calculatorDTO=new CalculatorDTO();
        calculatorDTO.setNum1(num1);
        calculatorDTO.setNum2(num2);
        calculatorDTO.setNum3(num3);
        calculatorDTO.setNum4(num4);
        ResponseEntity<Double>responseEntity= calculatorController.multiply(calculatorDTO);
        assertEquals(150.0625,responseEntity.getBody());
        assertEquals(HttpStatus.CREATED.value(),responseEntity.getStatusCodeValue(),"Expecting the Status Code CREATED");
    }
}
