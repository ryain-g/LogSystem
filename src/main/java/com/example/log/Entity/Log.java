package com.example.log.Entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

//configure this class as Entity
@Entity
// create table log in subscriber database with attribute table columns
@Table(name = "log")
public class Log {

    //define the next attribute as id
    @Id
    //make the database  generate the id value automatically
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "User_Id", nullable = false, length = 500)
    private Long userId;

    //define the attribute as column in the table
    @Column(name = "User_Name", nullable = false, length = 500)
    private String userName;

    @Column(name = "User_Email", nullable = false, length = 500)
    private String userEmail;

    @Column(name = "User_Balance", nullable = false, length = 500)
    private Double userBalance;

    @Column(name = "date", nullable = false, length = 500)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date currentDate;

    @Column(name = "Transaction_type", nullable = false, length = 500)
    private String transactionType;

    @Column(name = "Transaction_Amount", nullable = false, length = 500)
    private double transactionAmount;

// create the set and get methods to enable  access to the attribute


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    // create the toString method to  return a string representation of the objects.
    @Override
    public String toString() {
        return "Users{" +
                "userId=" + id +
                ", UserName='" + userName + '\'' +
                ", email='" + userEmail + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", transactionType=" + transactionType +
                ", UserBalance=" + userBalance+
                '}';
    }
}