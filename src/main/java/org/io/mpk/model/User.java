package org.io.mpk.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

    private Long userId;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private Integer cardNumber;
    private String ccv;
    private LocalDateTime cardExpireDate;
    private List<Ticket> tickets = new ArrayList<>();

    public User() {
    }

    public User(Long userId, String name, String surname, String username, String password, String email, Integer cardNumber, String ccv, LocalDateTime cardExpireDate) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.cardNumber = cardNumber;
        this.ccv = ccv;
        this.cardExpireDate = cardExpireDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public LocalDateTime getCardExpireDate() {
        return cardExpireDate;
    }

    public void setCardExpireDate(LocalDateTime cardExpireDate) {
        this.cardExpireDate = cardExpireDate;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }
}
