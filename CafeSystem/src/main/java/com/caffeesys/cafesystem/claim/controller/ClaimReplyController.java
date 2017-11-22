package com.caffeesys.cafesystem.claim.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.claim.service.ClaimReplyVO;
import com.caffeesys.cafesystem.claim.service.ClaimReplyService;

@Controller
@RequestMapping("/replies")
public class ClaimReplyController {

	private static final Logger logger = LoggerFactory.getLogger(ClaimReplyController.class);

	@Autowired
	private ClaimReplyService claimReplyService;

	@RequestMapping(value = "/insertReply", method = RequestMethod.POST)
	public ResponseEntity<String> insertClaimReply(@RequestBody ClaimReplyVO claimReply) {
		logger.debug("[ClaimReplyController.java/insertClaimReply.method] Loading Complete");
		logger.debug("[ClaimReplyController.java/insertClaimReply.method] claimReply param : " + claimReply);
		ResponseEntity<String> entity = null;
		try {
			claimReplyService.insertClaimReply(claimReply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/all/{customerClaimCode}", method = RequestMethod.GET)
	public ResponseEntity<List<ClaimReplyVO>> listClaimReply(@PathVariable("customerClaimCode") Integer customerClaimCode) {
		logger.debug("[ClaimReplyController.java/listClaimReply.method] Loading Complete");
		logger.debug("[ClaimReplyController.java/listClaimReply.method] customerClaimCode param : " + customerClaimCode);
		ResponseEntity<List<ClaimReplyVO>> entity = null;
		try {
			entity = new ResponseEntity<List<ClaimReplyVO>>(claimReplyService.selectClaimReply(customerClaimCode), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ClaimReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/{claimReplyCode}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> updateClaimReply(@PathVariable("claimReplyCode") Integer claimReplyCode, @RequestBody ClaimReplyVO claimReply) {
		logger.debug("[ClaimReplyController.java/updateClaimReply.method] Loading Complete");
		logger.debug("[ClaimReplyController.java/updateClaimReply.method] claimReplyCode param : " + claimReplyCode);
		ResponseEntity<String> entity = null;
		try {
			claimReply.setClaimReplyCode(claimReplyCode);
			claimReplyService.updateClaimReply(claimReply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/{claimReplyCode}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteClaimReply(@PathVariable("claimReplyCode") Integer claimReplyCode) {
		logger.debug("[ClaimReplyController.java/deleteClaimReply.method] Loading Complete");
		logger.debug("[ClaimReplyController.java/deleteClaimReply.method] claimReplyCode param : " + claimReplyCode);
	  ResponseEntity<String> entity = null;
	  try {
		  claimReplyService.deleteClaimReply(claimReplyCode);
	    entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	  } catch (Exception e) {
	    e.printStackTrace();
	    entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	  }
	 
	  return entity;
	}
	
}
