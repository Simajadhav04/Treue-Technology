package org.onlinebookstore.com.onlinebookstore.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

   @Serial
    private static final long serialVersionUID = 5891162962888146932L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

    private Date createdDate = new Date();
}
