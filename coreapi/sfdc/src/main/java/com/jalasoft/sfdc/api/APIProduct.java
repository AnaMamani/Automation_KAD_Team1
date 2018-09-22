package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Product;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;
/**
 * API Product class.
 *
 * @author Denis Camacho.
 * @since 9/21/2018
 */
public class APIProduct {
    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final Product product;
    private Product productApi;
    protected Map<String, Object> fieldsMap;

    /**
     *
     * @param product
     */
    public APIProduct(Product product) {
        this.product = product;
        fieldsMap = covertEntityToMap();
        productApi =new Product();
    }

    /**
     * <p>This method converts the </p>
     *
     * @return
     */
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(PRODUCT_NAME, product.getProductName());
        map.put(PRODUCT_CODE, product.getProductCode());
        map.put(PRODUCT_DESCRIPTION, product.getProductDescription());
        map.put(PRODUCT_FAMILY, product.getFamily());
        map.put(PRODUCT_ACTIVE, product.getActive());
        return map;
    }

    /**
     *
     * @return
     */
    public Product getProductValuesByAPI() { //ToDo define what aee you going to return
        response = APIManager.getInstance().get(SLASH.concat(SOBJECTS).concat(SLASH).concat(PRODUCT).
                concat(SLASH).concat(product.getId()));
        productApi.setProductName(response.jsonPath().get(PRODUCT_NAME).toString());
        productApi.setProductCode(response.jsonPath().get(PRODUCT_CODE).toString());
        productApi.setProductDescription(response.jsonPath().get(PRODUCT_DESCRIPTION).toString());
        productApi.setActive(response.jsonPath().get(PRODUCT_ACTIVE));

        return productApi;
    }

    /**
     *
     */
    public void createProductByAPI() {
        response = apiManager.post(PRODUCT, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        product.setId(response.jsonPath().get(ID).toString());
    }

    /**
     *
     */
    public void deleteProductByAPI() {
        response = apiManager.delete(PRODUCT, product.getId());
        System.out.println("Query response delete: " + response.asString());
    }
}
