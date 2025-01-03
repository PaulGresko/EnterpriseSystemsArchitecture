package com.example.LR3_Rest.dto;

import com.example.LR3_Rest.dto.base.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LibraryDto implements BaseDto {

    private String name;

    private String address;

}
