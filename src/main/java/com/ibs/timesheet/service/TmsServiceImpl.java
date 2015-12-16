package com.ibs.timesheet.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ibs.timesheet.model.TimesheetEntry;
import com.ibs.timesheet.repository.TmsEntiresRepo;
import com.ibs.timesheet.util.TimesheetUtil;

@Service
public class TmsServiceImpl implements TmsService {

	TmsEntiresRepo entiresRepo;

	@Inject
	public void setEntiresRepo(TmsEntiresRepo entiresRepo) {
		this.entiresRepo = entiresRepo;
	}

	@Override
	public List<TimesheetEntry> submitTimesheet(List<TimesheetEntry> tmsEntries) {
		List<TimesheetEntry> tmsEntryLst = entiresRepo.save(tmsEntries);
		return tmsEntryLst;
	}

@Override
public List<TimesheetEntry> listTimesheet(String startDate, String endDate, String type) {
	List<TimesheetEntry> tmsEnties = null;
	Date sDate = null;
	Date eDate = null;
	if (!StringUtils.isEmpty(startDate)) {
		System.out.println("startDate"+startDate);
		sDate = TimesheetUtil.toDate(startDate);
	}
	if (!StringUtils.isEmpty(endDate)) {
		System.out.println("endDate"+endDate);
		eDate = TimesheetUtil.toDate(endDate);
	}
	String status = null;
	if("admin".equalsIgnoreCase(type)){
		status ="submitted";
	}
	if (sDate != null && eDate != null && !StringUtils.isEmpty(status)) {
		System.out.println("findTmsEntiresBetweenDateByType Executed with sDate=" + sDate + " eDate=" + eDate + "status=" + status);
		tmsEnties = entiresRepo.findTmsEntiresBetweenDateByType(sDate, eDate, status);
	} else if (sDate != null && eDate != null) {
		System.out.println("findTmsEntiresByDateBetween Executed with sDate=" + sDate + " eDate=" + eDate);
		tmsEnties = entiresRepo.findTmsEntiresByDateBetween(sDate, eDate);
	} else if (!StringUtils.isEmpty(status)) {
		System.out.println("findTmsEntiresByType Executed with status=" + status);
		tmsEnties = entiresRepo.findTmsEntiresByType(status);
	} else {
		System.out.println("findAll");
		tmsEnties = entiresRepo.findAll();
	}
	return tmsEnties;
}

	@Override
	public List<TimesheetEntry> updateTimesheet(List<TimesheetEntry> tmsEntries) {
		List<TimesheetEntry> updatedTmsEnties = new ArrayList<TimesheetEntry>();
		for (TimesheetEntry entry : tmsEntries) {
			TimesheetEntry entry2 = entiresRepo.findOne(entry.getId());
			entry2.setApprovalStatus("submitted");
			updatedTmsEnties.add(entry2);
		}
		return entiresRepo.save(updatedTmsEnties);
	}

@Override
public List<TimesheetEntry> acceptOrRejectTimesheet(List<TimesheetEntry> tmsEntries) {
	List<TimesheetEntry> updatedTmsEnties = new ArrayList<TimesheetEntry>();
	for (TimesheetEntry entry : tmsEntries) {
		TimesheetEntry entry2 = entiresRepo.findOne(entry.getId());
		entry2.setApprovalStatus(entry.getApprovalStatus());
		updatedTmsEnties.add(entry2);
	}
	return entiresRepo.save(updatedTmsEnties);
}

}
