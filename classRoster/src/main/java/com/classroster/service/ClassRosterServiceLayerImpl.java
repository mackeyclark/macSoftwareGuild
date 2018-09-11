/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classroster.service;

import com.classroster.dao.ClassRosterAuditDao;
import com.classroster.dao.ClassRosterDao;
import com.classroster.dao.ClassRosterPersistenceException;
import com.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author macam
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer{
    
    private ClassRosterAuditDao auditDao;
    
    ClassRosterDao dao;
    
    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao){
        this.dao = dao;
        this.auditDao = auditDao;
        
    }

    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException {
        
        // First check to see if there is alreay a student 
        // associated with the given student's id
        // If so, we're all done here - 
        // throw a ClassRosterDuplicateIdException
        if(dao.getStudent(student.getStudentID()) != null){
            throw new ClassRosterDuplicateIdException("ERROR: Could not create Student. Student ID " + student.getStudentID() + " Already exists");
            
        }
        
        // Now validate all the fields on the given Student object.  
        // This method will throw an
        // exception if any of the validation rules are violated.
        validateStudentData(student);
        
        // We passed all our business rules checks so go ahead 
        // and persist the Student object
        dao.addStudent(student.getStudentID(), student);
        
        // The student was successfully created, now write to the audit log
//        auditDao.writeAuditEntry("Student " + student.getStudentID() + " CREATED");
        
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
        
    }

    @Override
    public Student getStudent(String studentID) throws ClassRosterPersistenceException {
        return dao.getStudent(studentID);
        
    }

    @Override
    public Student removeStudent(String studentID) throws ClassRosterPersistenceException {
        Student removeStudent = dao.removeStudent(studentID);
        //write to the audit log
//        auditDao.writeAuditEntry("Student " + studentID + " REMOVED");
        return dao.removeStudent(studentID);
        
    }
    
    private void validateStudentData(Student student) throws ClassRosterDataValidationException{
        
        if(student.getFirstName() == null || student.getFirstName().trim().length() == 0 || student.getLastName() == null || student.getLastName().trim().length() == 0 || student.getCohort() == null || student.getCohort().trim().length() == 0) {
            
            throw new ClassRosterDataValidationException("ERROR: All fields [First Name, Last Name, Cohort] are required!");
            
        }
        
    }
    
}
