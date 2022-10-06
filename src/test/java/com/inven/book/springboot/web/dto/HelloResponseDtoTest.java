package com.inven.book.springboot.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() throws Exception {
        // given
        String name = "test";
        int amount = 10000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo("test");
        assertThat(dto.getAmount()).isEqualTo(10000);
    }
}