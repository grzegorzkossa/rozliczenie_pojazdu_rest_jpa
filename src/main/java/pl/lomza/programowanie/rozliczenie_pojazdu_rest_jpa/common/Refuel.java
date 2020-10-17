package pl.lomza.programowanie.rozliczenie_pojazdu_rest_jpa.common;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Refuel")
public class Refuel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "idVehicle")
    private long vehicleId;
    @Column(name = "idRide")
    private long rideId;
    private LocalDate createDate;
    private LocalDate refuelDate;
    private String name;
    private int counterBefore;
    private int counterAfter;
    private int km;
    private double refuel;
    private double price;
    private double value;
    private double fuelNorm;

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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getRefuelDate() {
        return refuelDate;
    }

    public void setRefuelDate(LocalDate refuelDate) {
        this.refuelDate = refuelDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounterBefore() {
        return counterBefore;
    }

    public void setCounterBefore(int counterBefore) {
        this.counterBefore = counterBefore;
    }

    public int getCounterAfter() {
        return counterAfter;
    }

    public void setCounterAfter(int counterAfter) {
        this.counterAfter = counterAfter;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public double getRefuel() {
        return refuel;
    }

    public void setRefuel(double refuel) {
        this.refuel = refuel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getFuelNorm() {
        return fuelNorm;
    }

    public void setFuelNorm(double fuelNorm) {
        this.fuelNorm = fuelNorm;
    }
}
