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
	public List<TimesheetEntry> listTimesheet(String startDate, String endDate) {
		List<TimesheetEntry> tmsEnties = null;
		if (!StringUtils.isEmpty(startDate) && !StringUtils.isEmpty(startDate)) {
			Date sDate = TimesheetUtil.toDate(startDate);
			Date eDate = TimesheetUtil.toDate(endDate);
			tmsEnties = entiresRepo.findTmsEntiresByDateBetween(sDate, eDate);
		} else {
			tmsEnties = entiresRepo.findAll();
		}
		return tmsEnties;
	}

	@Override
	public List<TimesheetEntry> updateTimesheet(List<TimesheetEntry> tmsEntries) {
		List<TimesheetEntry> updatedTmsEnties = new ArrayList<TimesheetEntry>();
		for (TimesheetEntry entry : tmsEntries) {
			entry.setApprovalStatus("Submitted for Approval");
			updatedTmsEnties.add(entry);
		}
		return entiresRepo.save(updatedTmsEnties);
	}

}
