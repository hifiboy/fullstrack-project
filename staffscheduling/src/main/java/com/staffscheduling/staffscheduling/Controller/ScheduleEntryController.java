package com.staffscheduling.staffscheduling.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.staffscheduling.staffscheduling.model.ScheduleEntry;
import com.staffscheduling.staffscheduling.Service.ScheduleEntryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/scheduleEntries")
public class ScheduleEntryController {

    @Autowired
    private ScheduleEntryService scheduleEntryService;

    @GetMapping
    public List<ScheduleEntry> getAllEntries() {
        return scheduleEntryService.getAllEntries();
    }

    @GetMapping("/{id}")
    public Optional<ScheduleEntry> getEntryById(@PathVariable Long id) {
        return scheduleEntryService.getEntryById(id);
    }

    @PostMapping
    public ScheduleEntry createEntry(@RequestBody ScheduleEntry entry) {
        return scheduleEntryService.createEntry(entry);
    }

    @PutMapping("/{id}")
    public ScheduleEntry updateEntry(@PathVariable Long id, @RequestBody ScheduleEntry entryDetails) {
        return scheduleEntryService.updateEntry(id, entryDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        scheduleEntryService.deleteEntry(id);
    }
}
