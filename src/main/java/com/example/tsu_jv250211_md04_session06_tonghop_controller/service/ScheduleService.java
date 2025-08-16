package com.example.tsu_jv250211_md04_session06_tonghop_controller.service;

import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Schedule;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public List<Schedule> getSchedules() {
        return scheduleRepository.getSchedules();
    }
    public Schedule getScheduleById(Long id) {
        return scheduleRepository.getScheduleById(id);
    }
    public boolean addSchedule(Schedule schedule) {
        return scheduleRepository.addSchedule(schedule);
    }
    public boolean updateSchedule(Schedule schedule) {
        return scheduleRepository.updateSchedule(schedule);
    }
    public boolean deleteSchedule(Long id) {
        return scheduleRepository.deleteSchedule(id);
    }
}
