package com.ibs.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.timesheet.model.TimesheetEntry;
import com.ibs.timesheet.repository.TmsEntiresRepo;

@Service
public class TmsServiceImpl implements TmsService{
	
	@Autowired
	TmsEntiresRepo entiresRepo;

	@Override
	public List<TimesheetEntry> submitTimesheet(List<TimesheetEntry> tmsEntries) {
		entiresRepo.save(tmsEntries);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimesheetEntry> listTimesheet(String startDate, String endDate) {
		List<TimesheetEntry> entries =null;
		// Wrtite the logic to find out entries based on start date & end date
		for(TimesheetEntry entry:entries){
			//entiresRepo.fetch();
			
		}
		
		// TODO return the list of entries updated
		return null;
	}

	@Override
	public List<TimesheetEntry> updateTimesheet(List<TimesheetEntry> tmsEntries) {
		// Wrtite the logic to find out entries based on passed TimesheetEntry list
				for(TimesheetEntry entry:tmsEntries){
					//entiresRepo.update();
				}
		// TODO Auto-generated method stub
		return null;
	} 
	

}
