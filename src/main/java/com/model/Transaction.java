package com.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "transactions")
@RequiredArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaction_id;

    private String type; // e.g., "credit", "debit"

    private Double amount; // Amount of the transaction

    private User payee; // ID of the user involved in the transaction

    private User payer; // ID of the expense associated with the transaction

    private boolean isSettled = false; // To handle soft deletion or deactivation

}
