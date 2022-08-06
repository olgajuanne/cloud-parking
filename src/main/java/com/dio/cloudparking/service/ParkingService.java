package com.dio.cloudparking.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import com.dio.cloudparking.exception.ParkingNotFoundException;
import com.dio.cloudparking.model.Parking;
import com.dio.cloudparking.repository.ParkingRepository;

@Service
public class ParkingService {

  private static Map<String, Parking> parkingMap = new HashMap();//


    static {
  
        var id = getUUID();
        var id1 = getUUID();
        var id2 = getUUID();
        Parking parking = new Parking(id, "DMS-1111", "SC", "CELTA", "PRETO");
        Parking parking1 = new Parking(id1, "WAS-1234", "SP", "VW GOL", "VERMELHO");
        Parking parking2 = new Parking(id2, "STR-2211", "PR", "VW JETTA", "VERDE");
        parkingMap.put(id, parking);

        parkingMap.put(id1, parking1);
        parkingMap.put(id2, parking2);
    }//
  
    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
       this.parkingRepository = parkingRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Parking> findAll(){
        //return parkingRepository.findAll();
        return parkingMap.values().stream().collect(Collectors.toList());//
    }

    private static String getUUID() {
      return UUID.randomUUID().toString().replace("-", "");
  }

    @Transactional(readOnly = true)
    public Parking findById(String id) {
      return parkingMap.get(id); //
       // return parkingRepository.findById(id).orElseThrow(() -> 
        //  new ParkingNotFoundException(id));
    }

    @Transactional
    public Parking create(Parking parkingCreate) {
      String uuid = getUUID();
      parkingCreate.setId(uuid);
      parkingCreate.setEntryDate(LocalDateTime.now());
      parkingMap.put(uuid, parkingCreate); //
      parkingRepository.save(parkingCreate);
      return parkingCreate;
    }

    @Transactional
    public void delete(String id) {
        findById(id);
        parkingRepository.deleteById(id);
    }

    @Transactional
    public Parking update(String id, Parking parkingCreate) {
      Parking parking = findById(id);
      parking.setColor(parkingCreate.getColor());
      parking.setState(parkingCreate.getState());
      parking.setModel(parkingCreate.getModel());
      parking.setLicense(parkingCreate.getLicense());
      parkingRepository.save(parking);
      return parking;
    }

    @Transactional
    public Parking checkOut(String id) {
        Parking parking = findById(id);
        parking.setExitDate(LocalDateTime.now());
        parking.setBill(ParkingCheckOut.getBill(parking));
        parkingRepository.save(parking);
        return parking;
    }

}
