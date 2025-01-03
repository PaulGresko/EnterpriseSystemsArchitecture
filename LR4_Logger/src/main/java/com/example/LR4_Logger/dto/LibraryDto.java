package com.example.LR4_Logger.dto;

import com.example.LR4_Logger.dto.base.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LibraryDto implements BaseDto {

    private String name;

    private String address;

}
