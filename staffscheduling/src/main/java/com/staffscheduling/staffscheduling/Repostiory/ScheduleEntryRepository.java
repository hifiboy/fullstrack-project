

package com.staffscheduling.staffscheduling.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.staffscheduling.staffscheduling.model.ScheduleEntry;

public interface ScheduleEntryRepository extends JpaRepository<ScheduleEntry, Long> {
}
