package com.tendydeveloper.book.service.entity.writer;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Writer {
    private int id;
    private String name;
    private Date dob;
    private Date dod;
    private String birthCountry;
    private String birthLocation;
    private String biography;
    private String address;
}
