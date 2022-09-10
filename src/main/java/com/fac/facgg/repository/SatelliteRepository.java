package com.fac.facgg.repository;

import com.fac.facgg.entities.Satellite;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SatelliteRepository extends MongoRepository<Satellite, String> {

    public Satellite findTopByParamNodeAndParamNameAndParamIndexOrderByTsAsc(Integer node, String name, Integer index);

    public Satellite findTopByParamNodeAndParamNameOrderByTsDesc(Integer node, String name);

    public List<Satellite> findSatelliteByParamNodeOrderByTsAsc(Integer node);

    public List<Satellite> findSatelliteByParamNodeAndParamNameOrderByTsDesc(Integer node, String name);

    public List<Satellite> findSatelliteByParamNodeAndParamNameAndParamIndexOrderByTsDesc(Integer node, String name, Integer index);

    public List<Satellite> findSatelliteByParamNodeAndParamNameAndTsBetweenOrderByTsAsc(Integer node, String name, Long startDate, Long endDate);

    public List<Satellite> findSatelliteByParamNodeAndParamNameAndParamIndexAndTsBetweenOrderByTsAsc(Integer node, String name, Integer index, Long startDate, Long endDate);


}
