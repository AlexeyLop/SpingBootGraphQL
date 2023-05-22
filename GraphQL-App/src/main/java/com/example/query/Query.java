package com.example.query;

import com.example.request.SampleRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
	@Autowired
	StudentService studentService;

	public String firstQuery () {
		return "First Query";
	}

	public String secondQuery () {
		return "Second Query";
	}


	// query{
	//  fullName(sampleRequest: {firstName: "Bob", lastName: "Smith"})
	//}

	// {
	//  "data": {
	//    "fullName": "Bob Smith"
	//  }
	//}
	public String fullName(SampleRequest sampleRequest) {
		return sampleRequest.getFirstName() + " " + sampleRequest.getLastName();
	}


	// query{
	//  student(id: 2) {
	//    firstName
	//    lastName
	//    email
	//
	//  }
	//}
	public StudentResponse getStudent (long id) {
		return new StudentResponse(studentService.getStudentById(id));
	}


	//	public String fullName (String firstName,  String lastName) {
	//		return firstName + " " + lastName;
	//	}
	// in order to improve and have JSON input we will use SampleRequest class

	// query{
	//  fullName(firstName: "Bob", lastName: "Smith")
	//}

	// {
	//  "data": {
	//    "fullName": "Bob Smith"
	//  }
	//}
}
