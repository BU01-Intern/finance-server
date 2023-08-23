package org.example.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.annotation.CreatedDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String accountNumber;

    private String type;

    private Boolean isDistributed;

    private Integer status;

    @CreatedDate
    @Column(name = "created_time", nullable = false, insertable = false)
    private LocalDateTime createdTime;

    private Boolean isDeleted = false;
}
