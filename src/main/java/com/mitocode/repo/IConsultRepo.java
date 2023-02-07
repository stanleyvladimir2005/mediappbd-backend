package com.mitocode.repo;

import java.time.LocalDateTime;
import java.util.List;

import com.mitocode.model.Consult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsultRepo extends IGenericRepo <Consult, Integer> {

 @Query("from Consult c where c.patient.dui =:dui or LOWER(c.patient.firstName) like %:fullName% or LOWER(c.patient.lastName) like %:fullName%")
 List<Consult> search(@Param("dui")String dui, @Param("fullName") String fullName);

 @Query("from Consult c where c.consultDate between :date1 and :date2")
 List<Consult> searchByDates(@Param("date1") LocalDateTime date1, @Param("date2") LocalDateTime date2);

 @Query(value = "select * from fn_list()", nativeQuery = true)
 List<Object[]> callProcedureOrFunction();
}