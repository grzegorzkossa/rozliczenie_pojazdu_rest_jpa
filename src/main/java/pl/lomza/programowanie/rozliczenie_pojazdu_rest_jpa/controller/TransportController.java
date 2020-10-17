package pl.lomza.programowanie.rozliczenie_pojazdu_rest_jpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.lomza.programowanie.rozliczenie_pojazdu_rest_jpa.common.Refuel;
import pl.lomza.programowanie.rozliczenie_pojazdu_rest_jpa.common.Ride;
import pl.lomza.programowanie.rozliczenie_pojazdu_rest_jpa.common.Settlement;
import pl.lomza.programowanie.rozliczenie_pojazdu_rest_jpa.repository.TransportRepository;

import javax.persistence.Transient;
import java.util.List;

@RestController
public class TransportController {
    private final static Logger log = LoggerFactory.getLogger(TransportController.class);
    private TransportRepository transportRepository;

    @Autowired
    public TransportController(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    @GetMapping("/")
    public String getTest() {
        return "Działa JPA";
    }

    @GetMapping("/vehicle/{vehicleId}/rides")
    public List<Ride> getRides(@PathVariable("vehicleId") long vehicleId) {
        log.info("Wyświetlamy listę przejazdów");
        List<Ride> rides = transportRepository.findByVehicleId(vehicleId);
        rides.forEach(ride -> getGenerateRide(ride));
        return rides;
    }
    @GetMapping("vehicle/{vehicleId}/ride/{rideId}")
    public Ride getRide(@PathVariable("vehicleId") long vehicleId, @PathVariable("rideId") long rideId) {
        log.info("Wyświetlamy przejazd");
        Ride ride = transportRepository.findByVehicleIdAndId(vehicleId, rideId);
        getGenerateRide(ride);
        return ride;
    }

    private void getGenerateRide(Ride ride) {
        List<Settlement> settlements = ride.getSettlements();
        double fuel = 0.0;
        double price = 0.0;
        if(!settlements.isEmpty()) {
            for (Settlement settlement : settlements) {
                fuel = fuel + settlement.getFuel();
                if(settlement.getRefuel()!=null)
                price = settlement.getRefuel().getPrice();
            }
        }
        ride.setFuel(fuel);
        ride.setPrice(price);
        ride.setCurrency(fuel * price);
    }
}
