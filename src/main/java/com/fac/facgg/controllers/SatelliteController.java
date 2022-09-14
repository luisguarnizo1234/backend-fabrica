package com.fac.facgg.controllers;

import com.fac.facgg.dtos.DataDto;
import com.fac.facgg.dtos.DateDto;
import com.fac.facgg.dtos.HomeDto;
import com.fac.facgg.dtos.SatelliteDto;
import com.fac.facgg.entities.Satellite;
import com.fac.facgg.repository.SatelliteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/satellites")
@CrossOrigin
public class SatelliteController {

    private Logger logger = LoggerFactory.getLogger(SatelliteController.class);

    @Autowired
    private SatelliteRepository satelliteRepository;

    @GetMapping()
    public ResponseEntity<?> getAllDataByNode() {
        return new ResponseEntity(satelliteRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{node}")
    public ResponseEntity<?> getAllDataByNode(@PathVariable Integer node) {
        List<Satellite> satellites = satelliteRepository.findSatelliteByParamNodeOrderByTsAsc(node);
        /*
        for (Satellite satellite:satellites) {
            logger.info(String.valueOf(satellite.getTs()));
            Timestamp ts = new Timestamp(Long.valueOf(satellite.getTs()));
            Date date=new Date(ts.getTime());
            satellite.setDate(date);
        }
         */
        return new ResponseEntity(satellites, HttpStatus.OK);
    }

    @GetMapping("/{node}/{name}")
    public ResponseEntity<?> getAllDataByNodeAndName(@PathVariable Integer node, @PathVariable String name) {
        List<Satellite> satellites = satelliteRepository.findSatelliteByParamNodeAndParamNameOrderByTsDesc(node, name);
        SatelliteDto satelliteDto = new SatelliteDto();
        List<String> dateDtos = new ArrayList<>();
        List<Double> dataDtos = new ArrayList<>();

        for (Satellite satellite : satellites) {
            Date date = new Date(satellite.getTs() );
            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
            String stringDate = DateFor.format(date);
            dateDtos.add(stringDate);
            //logger.info(stringDate);
            dataDtos.add(satellite.getVal());
        }
        satelliteDto.setData(dataDtos);
        satelliteDto.setDates(dateDtos);


        return new ResponseEntity(satelliteDto, HttpStatus.OK);
    }

    @GetMapping("/{node}/{name}/{index}")
    public ResponseEntity<?> getAllDataByNodeAndNameAndIndex(@PathVariable Integer node, @PathVariable String name, @PathVariable Integer index) {
        List<Satellite> satellites = satelliteRepository.findSatelliteByParamNodeAndParamNameAndParamIndexOrderByTsDesc(node, name, index);
        SatelliteDto satelliteDto = new SatelliteDto();
        List<String> dateDtos = new ArrayList<>();
        List<Double> dataDtos = new ArrayList<>();

        //
        //logger.info(satellites.stream().findFirst().get().toString());

        for (Satellite satellite : satellites) {
            Date date = new Date(satellite.getTs() * 1000);
            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
            String stringDate = DateFor.format(date);
            dateDtos.add(stringDate);
            //logger.info(stringDate);
            dataDtos.add(satellite.getVal());
        }

        satelliteDto.setData(dataDtos);
        satelliteDto.setDates(dateDtos);

        return new ResponseEntity(satelliteDto, HttpStatus.OK);
    }

    //========================
    @GetMapping("/one/{node}/{name}/{index}")
    public ResponseEntity<?> findFirsDataByNodeAndNameAndIndex(@PathVariable Integer node, @PathVariable String name, @PathVariable Integer index) {
        List<Satellite> satellites = satelliteRepository.findSatelliteByParamNodeAndParamNameAndParamIndexOrderByTsDesc(node, name, index);
        SatelliteDto satelliteDto = new SatelliteDto();
        List<String> dateDtos = new ArrayList<>();
        List<Double> dataDtos = new ArrayList<>();

        //logger.info(satellites.stream().findFirst().get().toString());

        return new ResponseEntity(satellites.stream().findFirst().get(), HttpStatus.OK);
    }

    @GetMapping("/one/{node}/{name}")
    public ResponseEntity<?> findFirsDataByNodeAndName(@PathVariable Integer node, @PathVariable String name) {
        List<Satellite> satellites = satelliteRepository.findSatelliteByParamNodeAndParamNameOrderByTsDesc(node, name);
        SatelliteDto satelliteDto = new SatelliteDto();
        List<String> dateDtos = new ArrayList<>();
        List<Double> dataDtos = new ArrayList<>();

        //logger.info(satellites.stream().findFirst().get().toString());

        return new ResponseEntity(satellites.stream().findFirst().get(), HttpStatus.OK);
    }

    //=======================
    @GetMapping("/{node}/{name}/{startDate}/{endDate}")
    public ResponseEntity<?> getAllDataByNodeAndName(@PathVariable Integer node, @PathVariable String name,
                                                     @PathVariable Long startDate, @PathVariable Long endDate) {
        List<Satellite> satellites = satelliteRepository.findSatelliteByParamNodeAndParamNameAndTsBetweenOrderByTsAsc(node, name, startDate, endDate);
        SatelliteDto satelliteDto = new SatelliteDto();
        List<String> dateDtos = new ArrayList<>();
        List<Double> dataDtos = new ArrayList<>();

        for (Satellite satellite : satellites) {
            Date date = new Date(satellite.getTs());
            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
            String stringDate = DateFor.format(date);
            dateDtos.add(stringDate);
            //logger.info(stringDate);
            dataDtos.add(satellite.getVal());
        }
        satelliteDto.setData(dataDtos);
        satelliteDto.setDates(dateDtos);


        return new ResponseEntity(satelliteDto, HttpStatus.OK);
    }

    @GetMapping("/{node}/{name}/{index}/{startDate}/{endDate}")
    public ResponseEntity<?> getAllDataByNodeAndName(@PathVariable Integer node, @PathVariable String name, @PathVariable Integer index,
                                                     @PathVariable Long startDate, @PathVariable Long endDate) {
        List<Satellite> satellites = satelliteRepository.
                findSatelliteByParamNodeAndParamNameAndParamIndexAndTsBetweenOrderByTsAsc(node, name, index, startDate, endDate);
        SatelliteDto satelliteDto = new SatelliteDto();
        List<String> dateDtos = new ArrayList<>();
        List<Double> dataDtos = new ArrayList<>();

        for (Satellite satellite : satellites) {
            Date date = new Date(satellite.getTs() * 1000);
            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
            String stringDate = DateFor.format(date);
            dateDtos.add(stringDate);
            //logger.info(stringDate);
            dataDtos.add(satellite.getVal());
        }
        satelliteDto.setData(dataDtos);
        satelliteDto.setDates(dateDtos);


        return new ResponseEntity(satelliteDto, HttpStatus.OK);
    }

    @GetMapping("/last/{node}")
    public ResponseEntity<?> getLastDataByNode(@PathVariable Integer node) {
        HomeDto homeDto = HomeDto.builder()
                .rxBytes(satelliteRepository.findTopByParamNodeAndParamNameOrderByTsDesc(5, "tot_rx_count").getVal())
                .txBytes(satelliteRepository.findTopByParamNodeAndParamNameOrderByTsDesc(5, "tot_tx_count" ).getVal())
                .rssi(satelliteRepository.findTopByParamNodeAndParamNameOrderByTsDesc(5, "last_rssi" ).getVal())
                .rfError(satelliteRepository.findTopByParamNodeAndParamNameOrderByTsDesc(5, "bgnd_rssi" ).getVal())
                .backgroundRssi(satelliteRepository.findTopByParamNodeAndParamNameOrderByTsDesc(5, "last_rferr" ).getVal())


                .bostCount(satelliteRepository.findTopByParamNodeAndParamNameOrderByTsDesc(5, "boot_count" ).getVal())
                .tempPa(satelliteRepository.findTopByParamNodeAndParamNameOrderByTsDesc(5, "temp_pa" ).getVal())

                .tempBrd(satelliteRepository.findTopByParamNodeAndParamNameOrderByTsDesc(5, "temp_brd" ).getVal())
                .cause(satelliteRepository.findTopByParamNodeAndParamNameOrderByTsDesc(5, "boot_cause" ).getVal())
                .lastContact(satelliteRepository.findTopByParamNodeAndParamNameOrderByTsDesc(5, "last_contact" ).getVal())
                .build();
        return new ResponseEntity(homeDto, HttpStatus.OK);
    }


}
