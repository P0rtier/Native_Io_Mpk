package org.io.mpk.model;

public class Ticket {
    private TicketType ticketType;
    private TicketType ticketTypeRoute;
    private Double ticketPrice;

    public Ticket() {
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public TicketType getTicketTypeRoute() {
        return ticketTypeRoute;
    }

    public void setTicketTypeRoute(TicketType ticketTypeRoute) {
        this.ticketTypeRoute = ticketTypeRoute;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public enum TicketType{
        ULGOWY,NORMALNY,PRZEJAZD_CZASOWY,PRZEJAZD_JEDNORAZOWY
    }

}
