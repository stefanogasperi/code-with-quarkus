package com.gas.edu.qdbs.model.dto.top;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class ResponseListDTO<T> {
    private List<T> items;
    private List<Long> orderedIdList;

}
