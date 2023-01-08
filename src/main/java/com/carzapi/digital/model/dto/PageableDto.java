package com.carzapi.digital.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PageableDto<T> {
    public List<T> data;
    public Boolean hasNext;
    public Boolean hasPrevious;
    public Integer totalPages;
    public Long totalElements;
}
