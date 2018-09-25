package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Product;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Iterator;
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
    public boolean isProductSaved() {
        String totalSize = (apiManager.getQuery(PRODUCT, removeFields(fieldsMap)).jsonPath().get(TOTAL_SIZE)).toString();
        System.out.println("*******response of query: " + apiManager.getQuery(PRODUCT, removeFields(fieldsMap)).asString());
        System.out.println("total size: " + totalSize);
        if (totalSize != null) {
            return Integer.parseInt(totalSize) > 0;
        }
        return false;
    }
    private Map<String, Object> removeFields(Map<String, Object> fieldsMap) {
        Map<String,Object> map = new HashMap<>();
        Iterator it =  fieldsMap.keySet().iterator();
        while(it.hasNext()){
            String key = it.next().toString();
            map.put(key,fieldsMap.get(key));
        }
        map.remove(PRODUCT_NAME);
        map.remove(PRODUCT_CODE);
        map.remove(PRODUCT_DESCRIPTION);
        map.remove(PRODUCT_ACTIVE);
        return map;
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
    public Response deleteProductByAPI() {
        response = apiManager.delete(PRODUCT, product.getId());
        System.out.println("Query response delete: " + response.asString());
        return response;
    }
}
