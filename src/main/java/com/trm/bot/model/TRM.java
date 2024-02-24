package com.trm.bot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TRM {
    private int year;
    private int month;
    private int day;
    private Float currentExchange;
}
