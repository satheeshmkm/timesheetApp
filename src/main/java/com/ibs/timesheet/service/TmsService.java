package com.ibs.timesheet.service;

import java.util.Date;
import java.util.List;
import com.ibs.timesheet.model.TimesheetEntry;

public interface TmsService {

	public List<TimesheetEntry> submitTimesheet(List<TimesheetEntry> tmsEntries);

	public List<TimesheetEntry> listTimesheet(String startDate, String endDate, String type);

	public List<TimesheetEntry> updateTimesheet(List<TimesheetEntry> tmsEntries);
	public List<TimesheetEntry> acceptOrRejectTimesheet(List<TimesheetEntry> tmsEntries);

}
