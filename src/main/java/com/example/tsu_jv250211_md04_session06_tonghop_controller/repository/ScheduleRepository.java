package com.example.tsu_jv250211_md04_session06_tonghop_controller.repository;

import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Schedule;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleRepository {
    public List<Schedule> getSchedules() {
        Connection connection = null;
        CallableStatement callSt = null;
        List<Schedule> schedules = null;
        try {
            connection = ConnectionDB.getConnection();
            callSt = connection.prepareCall("{call findAllSchedules()}");
            ResultSet resultSet = callSt.executeQuery();
            schedules = new ArrayList<>();
            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getLong("id"));
                schedule.setMovieTitle(resultSet.getString("movie_title"));
                schedule.setShowTime(resultSet.getDate("show_time"));
                schedule.setScreenRoomId(resultSet.getLong("screen_room_id"));
                schedule.setAvailableSeat(Integer.parseInt(resultSet.getString("available_seats")));
                schedule.setFormat(resultSet.getString("format"));
                schedules.add(schedule);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callSt);
        }
        return schedules;
    }

    public Schedule getScheduleById(Long id) {
        Connection connection = null;
        CallableStatement callSt = null;
        Schedule schedule = null;
        try {
            connection = ConnectionDB.getConnection();
            callSt = connection.prepareCall("{call find_schedule_by_id(?)}");
            callSt.setLong(1, id);
            ResultSet resultSet = callSt.executeQuery();
            if (resultSet.next()) {
                schedule = new Schedule();
                schedule.setId(resultSet.getLong("id"));
                schedule.setMovieTitle(resultSet.getString("movie_title"));
                schedule.setShowTime(resultSet.getDate("show_time"));
                schedule.setScreenRoomId(resultSet.getLong("screen_room_id"));
                schedule.setAvailableSeat(Integer.parseInt(resultSet.getString("available_seats")));
                schedule.setFormat(resultSet.getString("format"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callSt);
        }
        return schedule;
    }

    public Boolean addSchedule(Schedule schedule) {
        Connection connection = null;
        CallableStatement callSt = null;
        Boolean result = false;
        try {
            connection = ConnectionDB.getConnection();
            callSt = connection.prepareCall("{call add_schedule(?,?,?,?,?)}");
            callSt.setString(1, schedule.getMovieTitle());
            callSt.setDate(2, new Date(schedule.getShowTime().getTime()));
            callSt.setLong(3, schedule.getScreenRoomId());
            callSt.setLong(4, schedule.getAvailableSeat());
            callSt.setString(5, schedule.getFormat());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callSt);
        }
        return result;
    }

    public Boolean updateSchedule(Schedule schedule) {
        Connection connection = null;
        CallableStatement callSt = null;
        Boolean result = false;
        try {
            connection = ConnectionDB.getConnection();
            callSt = connection.prepareCall("{call update_schedule(?,?,?,?,?,?)}");
            callSt.setLong(1, schedule.getId());
            callSt.setString(2, schedule.getMovieTitle());
            callSt.setDate(3, new Date(schedule.getShowTime().getTime()));

            callSt.setLong(4, schedule.getScreenRoomId());
            callSt.setLong(5, schedule.getAvailableSeat());
            callSt.setString(6, schedule.getFormat());
            callSt.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callSt);
        }
        return result;
    }

    public Boolean deleteSchedule(Long id) {
        Connection connection = null;
        CallableStatement callSt = null;
        Boolean result = false;
        try {
            connection = ConnectionDB.getConnection();
            callSt = connection.prepareCall("{call delete_schedule(?)}");
            callSt.setLong(1, id);
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callSt);
        }
        return result;

    }
}
