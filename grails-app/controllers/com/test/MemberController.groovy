package com.test

import grails.rest.RestfulController
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

class MemberController extends RestfulController<Member> {

	static responseFormats = ['json', 'xml']
	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	MemberController() {
		super(Member)
	}

	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond Member.list(params), [status: OK]
	}

	@Transactional
	def save(Member memberInstance) {
		if (memberInstance == null) {
			render status: NOT_FOUND
			return
		}

		memberInstance.validate()
		if (memberInstance.hasErrors()) {
			render status: NOT_ACCEPTABLE
			return
		}

		memberInstance.save flush: true
		respond memberInstance, [status: CREATED]
	}

	@Transactional
	def update(Member memberInstance) {
		if (memberInstance == null) {
			render status: NOT_FOUND
			return
		}

		memberInstance.validate()
		if (memberInstance.hasErrors()) {
			render status: NOT_ACCEPTABLE
			return
		}

		memberInstance.save flush: true
		respond memberInstance, [status: OK]
	}

	@Transactional
	def delete(Member memberInstance) {

		if (memberInstance == null) {
			render status: NOT_FOUND
			return
		}

		memberInstance.delete flush: true
		render status: NO_CONTENT
	}
}
