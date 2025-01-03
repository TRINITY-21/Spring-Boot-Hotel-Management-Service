package com.gradle_hotel.gradel_hotel.repository;

import com.gradle_hotel.gradel_hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    // queries to use for the search feature
    @Query("SELECT DISTINCT r.type FROM Room r")
    List<String> findDistinctRoomTypes();

    //get room available for bookings on a specific date
//    @Query("SELECT r FROM Room r WHERE r.type LIKE %:type% AND r.id NOT IN (SELECT bk.room.id FROM Booking bk WHERE" +
//            "(bk.checkInDate <= :checkOutDate) AND (bk.checkOutDate >= :checkInDate))")
//    List<Room> findAvailableRoomsByDatesAndTypes(LocalDate checkInDate, LocalDate checkOutDate, String type);


    @Query("SELECT r FROM Room r WHERE r.type LIKE %:type% AND r.id NOT IN " +
            "(SELECT bk.room.id FROM Booking bk WHERE (bk.checkInDate <= :checkOutDate) " +
            "AND (bk.checkOutDate >= :checkInDate))")
    List<Room> findAvailableRoomsByDatesAndTypes(@Param("checkInDate") LocalDate checkInDate,
                                                 @Param("checkOutDate") LocalDate checkOutDate,
                                                 @Param("type") String type);



    @Query("SELECT r FROM Room r WHERE r.id NOT IN (SELECT b.room.id FROM Booking b)")
    List<Room> getAllAvailableRooms();
}
