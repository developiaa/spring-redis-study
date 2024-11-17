package study.developia.ecommerce.vo;

import lombok.Data;
import java.util.List;

@Data
public class Keyword {

    private String keyword; // 유아용품 - 하기스 기저귀(FPG0001), A사 딸랑이(FPG0002)

    private List<ProductGrp> productGrpList; // [{"FPG0001",[{d1fc1031-da1c-40da-9cd1-e9fef3f2a336. 25000}, {}...]}, "FPG0002"}

}
