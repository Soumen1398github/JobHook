package com.jobportal.api;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.ApplicantDTO;
import com.jobportal.dto.Application;
import com.jobportal.dto.JobDTO;
import com.jobportal.dto.ResponseDTO;
import com.jobportal.exception.JobPortalException;
import com.jobportal.service.JobService;

import jakarta.validation.Valid;

@RestController
@Validated
@CrossOrigin
@RequestMapping("/jobs")
public class JobAPI {
	@Autowired
	private JobService jobService;
	
	@PostMapping(value = "/post")
	public ResponseEntity<JobDTO> postJob(@RequestBody @Valid JobDTO jobDTO) throws JobPortalException {
	    return new ResponseEntity<>(jobService.postJob(jobDTO), HttpStatus.CREATED);
	}
	@GetMapping(value = "/getAll")
    public ResponseEntity<List<JobDTO>> getAllJobs() throws JobPortalException {
	    return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
	}
	@GetMapping(value = "/get/{id}")
    public ResponseEntity<JobDTO> getJob(@PathVariable Long id) throws JobPortalException {
	    return new ResponseEntity<>(jobService.getJob(id), HttpStatus.OK);
	}
	@PostMapping(value = "/apply/{id}")
	public ResponseEntity<ResponseDTO> applyJob(@PathVariable Long id, @RequestBody  ApplicantDTO applicantDTO) throws JobPortalException {
		jobService.applyJob(id,applicantDTO);
	    return new ResponseEntity<>(new ResponseDTO("Applied Successfully"),HttpStatus.OK);
	}
	@GetMapping(value = "/postedBy/{id}")
    public ResponseEntity<List<JobDTO>> getJobsPostedBy(@PathVariable Long id) throws JobPortalException {
	    return new ResponseEntity<>(jobService.getJobsPostedBy(id), HttpStatus.OK);
	}
	@PostMapping(value = "/changeAppStatus")
	public ResponseEntity<ResponseDTO> changeAppStatus(@RequestBody Application application) throws JobPortalException {
		jobService.changeAppStatus(application);
	    return new ResponseEntity<>(new ResponseDTO("Application Status Changed Successfully"),HttpStatus.OK);
	}

}
