package com.tendydeveloper.book.service.entity.user;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private int id;
    private String email;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
}
