package com.ibs.timesheet.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ibs.timesheet.model.TimesheetEntry;

public interface TmsEntiresRepo  extends MongoRepository<TimesheetEntry,String>{
	//@Query("{ 'date' :{'$lt' : ?0} }")
	@Query("{ 'date' :{'$gt' : ?0, '$lt' : ?1} }")
	List<TimesheetEntry> findTmsEntiresByDateBetween(Date from, Date to);
}
