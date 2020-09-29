package com.ksu.dam.repository;

import com.ksu.dam.entity.CwlogsStream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DamRespository extends JpaRepository<CwlogsStream,Integer> {

    List<CwlogsStream> findByAtype(String atype) ;
    List<CwlogsStream> findAll();
    List<CwlogsStream> findByActiveIndicatorAndAtypeAndError(@Param("active_indicator") String active_indicator,
                                                               @Param("atype") String atype,
                                                               @Param("error") String error );

    List<CwlogsStream> findByActiveIndicator(@Param("active_indicator") String active_indicator);

//    @Modifying
//    @Query("UPDATE cw_logs_stream c SET c.active_indicator = 'N' where c.active_indicator='Y' ")
//    int updateActiveIndicator();

}
