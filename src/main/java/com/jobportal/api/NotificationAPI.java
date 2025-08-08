package com.jobportal.api;

import java.util.List;
import com.jobportal.service.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.ResponseDTO;
import com.jobportal.entity.Notification;
import com.jobportal.exception.JobPortalException;
import com.jobportal.service.NotificationService;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/notification")
public class NotificationAPI {

    private final NotificationServiceImpl notificationService_1;
	
	@Autowired
	private NotificationService notificationService;

    NotificationAPI(NotificationServiceImpl notificationService_1) {
        this.notificationService_1 = notificationService_1;
    }
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<List<Notification>>getNotifications(@PathVariable Long userId){
		return new ResponseEntity<>(notificationService.getUnreadNotifications(userId),HttpStatus.OK);
	}
	
	@PutMapping("/read/{id}")
	public ResponseEntity<ResponseDTO>readNotifications(@PathVariable Long id) throws JobPortalException{
		notificationService.readNotifications(id);
		return new ResponseEntity<>(new ResponseDTO("Success"),HttpStatus.OK);
	}
	

}
