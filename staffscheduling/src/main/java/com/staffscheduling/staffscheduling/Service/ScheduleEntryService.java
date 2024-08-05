
package com.staffscheduling.staffscheduling.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staffscheduling.staffscheduling.model.ScheduleEntry;
import com.staffscheduling.staffscheduling.Repostiory.ScheduleEntryRepository;
//import com.staffscheduling.staffscheduling.Service.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleEntryService {

    @Autowired
    private ScheduleEntryRepository scheduleEntryRepository;

    public List<ScheduleEntry> getAllEntries() {
        return scheduleEntryRepository.findAll();
    }

    public Optional<ScheduleEntry> getEntryById(Long id) {
        return scheduleEntryRepository.findById(id);
    }

    public ScheduleEntry createEntry(ScheduleEntry entry) {
        return scheduleEntryRepository.save(entry);
    }

    public ScheduleEntry updateEntry(Long id, ScheduleEntry entryDetails) {
        ScheduleEntry entry = scheduleEntryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule entry not found with id " + id));
        entry.setName(entryDetails.getName());
        entry.setStaffid(entryDetails.getStaffid());
        entry.setStartTime(entryDetails.getStartTime());
        entry.setEndTime(entryDetails.getEndTime());
        entry.setScheduleClass(entryDetails.getScheduleClass());
        return scheduleEntryRepository.save(entry);
    }

    public void deleteEntry(Long id) {
        ScheduleEntry entry = scheduleEntryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule entry not found with id " + id));
        scheduleEntryRepository.delete(entry);
    }
}
