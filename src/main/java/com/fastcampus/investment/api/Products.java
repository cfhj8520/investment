package com.fastcampus.investment.api;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Products {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private long total_investing_amount;

    @Column(nullable = false)
    private LocalDateTime started_at;

    @Column(nullable = false)
    private LocalDateTime finished_at;
}
