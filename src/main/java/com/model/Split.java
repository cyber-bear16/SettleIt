package com.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "splits")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Split {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long split_id;

    private String type; // e.g., "equal", "percentage", "fixed"

    private Double amount_owed; // Amount to be split

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // User receiving the split

    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense; // Expense associated with the split

    private boolean isSettled = false; // To handle soft deletion or deactivation

}
