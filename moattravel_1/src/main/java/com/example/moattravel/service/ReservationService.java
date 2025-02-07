package com.example.moattravel.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.moattravel.entity.House;
import com.example.moattravel.entity.Reservation;
import com.example.moattravel.entity.User;
import com.example.moattravel.form.ReservationRegisterForm;
import com.example.moattravel.repository.HouseRepository;
import com.example.moattravel.repository.ReservationRepository;
import com.example.moattravel.repository.UserRepository;

@Service

public class ReservationService {
	
	private final ReservationRepository reservationRepository;
	private final HouseRepository houseRepository;
	private final UserRepository userRepository;
	
	public ReservationService (ReservationRepository reservationRepository,HouseRepository houseRepository,UserRepository userRepository) {
		this.reservationRepository = reservationRepository;
		this.houseRepository = houseRepository;
		this.userRepository = userRepository;
	}
	
	@Transactional
	public void create(ReservationRegisterForm reservationRegisterForm) {
		Reservation reservation = new Reservation();
		
		House house = houseRepository.getReferenceById(reservationRegisterForm.getHouseId());
		User user = userRepository.getReferenceById(reservationRegisterForm.getUserId());
		LocalDate checkinDate = LocalDate.parse(reservationRegisterForm.getCheckinDate());
		LocalDate checkoutDate = LocalDate.parse(reservationRegisterForm.getCheckoutDate());
		
		reservation.setHouse(house);
		reservation.setUser(user);
		reservation.setCheckinDate(checkinDate);
		reservation.setCheckoutDate(checkoutDate);
		
		reservation.setNumberOfPeople(reservationRegisterForm.getNumberOfPeople());
		reservation.setAmount(reservationRegisterForm.getAmount());
		reservationRepository.save(reservation);
	}
	
	public boolean isWithinCapacity(Integer numberofPeople, Integer capacity) {
		return numberofPeople <= capacity;
	}
	
	public Integer calculateAmount(LocalDate checkinDate, LocalDate checkoutDate, Integer price) {
		long numberOfNights = ChronoUnit.DAYS.between(checkinDate, checkoutDate);
		
		int amount = price * (int) numberOfNights;
		
		return amount;
	}

}
