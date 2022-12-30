package org.sid.Account_service.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Driver {
    @Id
    @NonNull
    private String id;
    private Date createdAt;
    private String name;
    private int ages;
    private String email;
    private String phoneNumber;
    private String licenseNumber;
}
