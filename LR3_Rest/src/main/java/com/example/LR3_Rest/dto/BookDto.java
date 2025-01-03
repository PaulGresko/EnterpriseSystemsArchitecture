package com.example.LR3_Rest.dto;

import com.example.LR3_Rest.dto.base.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class BookDto implements BaseDto {

    private String title;

    private String description;

    private Long libraryId;

}
