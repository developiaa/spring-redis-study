package study.developia.ecommerce.service;


import study.developia.ecommerce.vo.Keyword;
import study.developia.ecommerce.vo.Product;
import study.developia.ecommerce.vo.ProductGrp;

import java.util.Set;

public interface LowestPriceService {
    Set GetZsetValue(String key);

    Set GetZsetValueWithStatus(String key) throws Exception;

    Set GetZsetValueWithSpecificException(String key) throws Exception;

    int SetNewProduct(Product newProduct);

    int SetNewProductGrp(ProductGrp newProductGrp);

    int SetNewProductGrpToKeyword(String keyword, String prodGrpId, double score);

    Keyword GetLowestPriceProductByKeyword(String keyword);
}
