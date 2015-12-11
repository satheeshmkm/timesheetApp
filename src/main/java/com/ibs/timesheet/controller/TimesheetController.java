package com.ibs.timesheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibs.timesheet.model.TimesheetEntry;
import com.ibs.timesheet.service.TmsService;

@RestController
public class TimesheetController {
	
	//@Autowired
	TmsService tmsService;
	
	@RequestMapping(value = "/submitTimesheet" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "content-type=application/x-www-form-urlencoded")
    public ResponseEntity<List<TimesheetEntry>> submitTimesheet(@RequestBody List<TimesheetEntry> tmsEntries){
		tmsService.submitTimesheet(tmsEntries);
		return null;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TimesheetEntry>> getTimesheet(@RequestParam String startDate, @RequestParam String endDate) {
		//
		tmsService.listTimesheet(startDate, endDate);
		//
        return null;
    }
	
	@RequestMapping(value = "/updateTimesheet" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "content-type=application/x-www-form-urlencoded")
    public ResponseEntity<List<TimesheetEntry>> updateTimesheet(@RequestBody List<TimesheetEntry> tmsEntries){
		//
		tmsService.updateTimesheet(tmsEntries);
		//
		return null;
	}

}
