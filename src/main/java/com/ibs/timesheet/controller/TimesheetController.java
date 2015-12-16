package com.ibs.timesheet.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibs.timesheet.model.TimesheetEntry;
import com.ibs.timesheet.service.TmsService;

@RestController
public class TimesheetController {

	TmsService tmsService;

	@Inject
	public void setTmsService(TmsService tmsService) {
		this.tmsService = tmsService;
	}

	@RequestMapping(value = "/saveTimesheet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, headers = "content-type=application/x-www-form-urlencoded")
	public ResponseEntity<List<TimesheetEntry>> submitTimesheet(
			//@RequestBody Object tmsEntries
			@RequestBody List<TimesheetEntry> tmsEntries) {
		System.out.println("InputJSON-->" + tmsEntries.toString());
		//List<TimesheetEntry> tmsEntries = null;//
		List<TimesheetEntry> tmsEntryLst = null;
		if (!CollectionUtils.isEmpty(tmsEntries)) {
			tmsEntryLst = tmsService.submitTimesheet(tmsEntries);
		}
		if (!CollectionUtils.isEmpty(tmsEntryLst)) {
			return new ResponseEntity<List<TimesheetEntry>>(tmsEntryLst,
					HttpStatus.OK);
		} else {
			return new ResponseEntity<List<TimesheetEntry>>(tmsEntryLst,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/listTimesheet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TimesheetEntry>> getTimesheet(
			@RequestParam String startDate, @RequestParam String endDate, @RequestParam String type) {
		List<TimesheetEntry> tmsEntryLst = tmsService.listTimesheet(startDate,
				endDate,type);
		if (!CollectionUtils.isEmpty(tmsEntryLst)) {
			return new ResponseEntity<List<TimesheetEntry>>(tmsEntryLst,
					HttpStatus.OK);
		} else {
			return new ResponseEntity<List<TimesheetEntry>>(tmsEntryLst,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/submitForApproval", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, headers = "content-type=application/x-www-form-urlencoded")
	public ResponseEntity<List<TimesheetEntry>> updateTimesheet(
			@RequestBody List<TimesheetEntry> tmsEntries) {
		List<TimesheetEntry> tmsEntryLst = tmsService
				.updateTimesheet(tmsEntries);
		if (!CollectionUtils.isEmpty(tmsEntryLst)) {
			return new ResponseEntity<List<TimesheetEntry>>(tmsEntryLst,
					HttpStatus.OK);
		} else {
			return new ResponseEntity<List<TimesheetEntry>>(tmsEntryLst,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

@RequestMapping(value = "/acceptOrReject", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, headers = "content-type=application/x-www-form-urlencoded")
public ResponseEntity<List<TimesheetEntry>> acceptOrRejectTimesheet(
		                                                           @RequestBody List<TimesheetEntry> tmsEntries) {
	List<TimesheetEntry> tmsEntryLst = tmsService
			                                   .acceptOrRejectTimesheet(tmsEntries);
	if (!CollectionUtils.isEmpty(tmsEntryLst)) {
		return new ResponseEntity<List<TimesheetEntry>>(tmsEntryLst,
				                                               HttpStatus.OK);
	} else {
		return new ResponseEntity<List<TimesheetEntry>>(tmsEntryLst,
				                                               HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

}
