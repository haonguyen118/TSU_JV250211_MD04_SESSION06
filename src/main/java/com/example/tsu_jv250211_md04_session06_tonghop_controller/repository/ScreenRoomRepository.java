package com.example.tsu_jv250211_md04_session06_tonghop_controller.repository;

import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.ScreenRoom;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScreenRoomRepository {
    public List<ScreenRoom> getScreenRooms() {
        Connection connection = null;
        CallableStatement callSt = null;
        List<ScreenRoom> screenRooms = null;
        try {
            connection = ConnectionDB.getConnection();
            callSt = connection.prepareCall("{call find_all_screen_room()}");
            ResultSet resultSet = callSt.executeQuery();
            screenRooms = new ArrayList<ScreenRoom>();
            while (resultSet.next()) {
                ScreenRoom screenRoom = new ScreenRoom();
                screenRoom.setId(Long.valueOf(resultSet.getLong("id")));
                screenRoom.setScreenRoomName(resultSet.getString("screenRoomName"));
                screenRoom.setTotalSeat(Integer.valueOf(resultSet.getInt("totalSeat")));
                screenRooms.add(screenRoom);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection,callSt);
        }
        return screenRooms;
    }
    public ScreenRoom getScreenRoomById(Long id) {
        Connection connection = null;
        CallableStatement callSt = null;
        ScreenRoom screenRoom = null;
        try {
            connection = ConnectionDB.getConnection();
            callSt = connection.prepareCall("{call find_sreen_room_by_id(?)}");
            callSt.setLong(1, id);
            ResultSet resultSet = callSt.executeQuery();
            if (resultSet.next()) {
                screenRoom = new ScreenRoom();
                screenRoom.setId(Long.valueOf(resultSet.getLong("id")));
                screenRoom.setScreenRoomName(resultSet.getString("screen_room_name"));
                screenRoom.setTotalSeat(Integer.valueOf(resultSet.getInt("total_seat")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callSt);
        }
        return screenRoom;
    }
}
