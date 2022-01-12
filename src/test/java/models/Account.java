package models;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Account {
    String accountName;
    String webSite;
    String type;
    String description;
    String phone;
    String employees;
    String industry;


}

