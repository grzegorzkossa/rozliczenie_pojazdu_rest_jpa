package pl.lomza.programowanie.rozliczenie_pojazdu_rest_jpa.common;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Settlement")
public class Settlement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "idVehicle")
    private long vehicleId;
    @Column(name = "idRide")
    private long rideId;
    @Column(name = "idRefuel")
    private long refuelId;
    private LocalDate createDate;
    private double fuel;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRefuel", referencedColumnName = "id", insertable = false, updatable = false)
    private Refuel refuel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public long getRideId() {
        return rideId;
    }

    public void setRideId(long rideId) {
        this.rideId = rideId;
    }

    public long getRefuelId() {
        return refuelId;
    }

    public void setRefuelId(long refuelId) {
        this.refuelId = refuelId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public Refuel getRefuel() {
        return refuel;
    }

    public void setRefuel(Refuel refuel) {
        this.refuel = refuel;
    }
}
