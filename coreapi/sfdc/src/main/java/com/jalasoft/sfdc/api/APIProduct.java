package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Product;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;

public class APIProduct {
    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final Product product;
    private Product product1;
    protected Map<String, Object> fieldsMap;

    public APIProduct(Product product) {
        this.product = product;
        fieldsMap = covertEntityToMap();
        product1=new Product();
    }

    /**
     * <p>This method converts the </p>
     *
     * @return
     */
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("Product Name", product.getProductName());
        map.put("Product Code", product.getProductCode());
        map.put("Product Description", product.getProductDescription());
        map.put("Product Family", product.getFamily());
        map.put("Active", product.getActive());
        return map;
    }

    public Product getProductValuesByAPI() { //ToDo define what aee you going to return
        response = APIManager.getInstance().get("/sobjects/Product2/" + product.getId());
        product1.setProductName(response.jsonPath().get("Name").toString());
        product1.setProductCode(response.jsonPath().get("ProductCode").toString());
        product1.setProductDescription(response.jsonPath().get("Description").toString());
        return product1;


    }

    public void createProductByAPI() {
        response = apiManager.post(PRODUCT, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        product.setId(response.jsonPath().get(ID).toString());
    }

    public void deleteProductByAPI() {
        response = apiManager.delete(PRODUCT, product.getId());
        System.out.println("Query response delete: " + response.asString());
    }
}
