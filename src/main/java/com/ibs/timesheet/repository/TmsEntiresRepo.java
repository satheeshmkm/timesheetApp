package com.ibs.timesheet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibs.timesheet.model.TimesheetEntry;

public interface TmsEntiresRepo  extends MongoRepository<TimesheetEntry,String>{

}
