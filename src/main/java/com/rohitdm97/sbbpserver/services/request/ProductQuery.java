package com.rohitdm97.sbbpserver.services.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductQuery {

    private String word;

    private int pageIdx;

    private int pageSize;

}
