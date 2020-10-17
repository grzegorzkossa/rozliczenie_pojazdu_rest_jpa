package pl.lomza.programowanie.rozliczenie_pojazdu_rest_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lomza.programowanie.rozliczenie_pojazdu_rest_jpa.common.Ride;

import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByVehicleId(long vehicleId);
    Ride findByVehicleIdAndId(long vehicleId, long rideId);
}
