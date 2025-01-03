package com.example.LR4_Logger.dto;

import com.example.LR4_Logger.dto.base.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class BookDto implements BaseDto {

    private String title;

    private String description;

    private Long libraryId;

}
