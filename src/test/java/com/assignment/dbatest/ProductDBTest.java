package com.assignment.dbatest;

import com.assignment.dba.ProductDB;
import com.assignment.exceptions.NoProductWithIDException;
import com.assignment.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductDBTest {
    static ProductDB db;
    @BeforeAll
    static void setup(){
        db = ProductDB.getInstance();
        Product productA = new Product("A",20);
        Product productB = new Product("B",75);
        db.addProduct(productA);
        db.addProduct(productB);
    }
    @Test
    public void testProductPresent() throws NoProductWithIDException {
        assertEquals(db.getProductById("A").getProductID(),"A","Returned same product");
    }

    @Test
    public void testProductNotPresent() throws NoProductWithIDException {
        Exception exception = assertThrows(NoProductWithIDException.class,
                () ->{db.getProductById("C");});
        assertNotNull(exception);
    }
}