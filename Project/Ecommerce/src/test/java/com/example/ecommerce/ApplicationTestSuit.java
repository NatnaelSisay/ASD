package com.example.ecommerce;

import com.example.ecommerce.controllers.TestProductController;
import com.example.ecommerce.services.TestProductService;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({
        TestProductController.class,
        TestProductService.class
})
@Suite
public class ApplicationTestSuit {
}
