package com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "expenses")
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expense_id;

    private String description;

    private Double amount;

    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL)
    private List<Payer> payers;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL)
    private List<Split> splits;

    private LocalDateTime createdAt = LocalDateTime.now();

}
