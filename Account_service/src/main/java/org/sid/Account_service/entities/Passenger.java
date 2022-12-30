package org.sid.Account_service.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Passenger {
    @Id
    @NonNull
    private String id;
    private Date createdAt;
    private String name;
    private int ages;
    private String email;
    private String phoneNumber;
}
