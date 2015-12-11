package com.ibs.timesheet.service;

import java.util.List;
import com.ibs.timesheet.model.TimesheetEntry;

public interface TmsService {

	public List<TimesheetEntry> submitTimesheet(List<TimesheetEntry> tmsEntries);

	public List<TimesheetEntry> listTimesheet(String startDate, String endDate);

	public List<TimesheetEntry> updateTimesheet(List<TimesheetEntry> tmsEntries);

}
