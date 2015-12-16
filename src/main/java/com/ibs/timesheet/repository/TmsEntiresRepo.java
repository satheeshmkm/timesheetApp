package com.ibs.timesheet.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibs.timesheet.model.TimesheetEntry;

@Repository
public interface TmsEntiresRepo  extends MongoRepository<TimesheetEntry,String>{
	@Query("{ 'date' :{'$gt' : ?0, '$lt' : ?1} }")
	List<TimesheetEntry> findTmsEntiresByDateBetween(Date from, Date to);

	@Query("{ 'date' :{'$gt' : ?0, '$lt' : ?1} ,'approvalStatus':?2}")
	List<TimesheetEntry> findTmsEntiresBetweenDateByType(Date from, Date to, String status);

	@Query("{ 'approvalStatus':?0}")
	List<TimesheetEntry> findTmsEntiresByType(String status);
}
