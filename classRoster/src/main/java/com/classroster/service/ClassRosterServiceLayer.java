/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classroster.service;

import com.classroster.dao.ClassRosterPersistenceException;
import com.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author macam
 */
public interface ClassRosterServiceLayer {
    
    void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException;
    
    List<Student> getAllStudents() throws ClassRosterPersistenceException;
    
    Student getStudent(String studentID) throws ClassRosterPersistenceException;
    
    Student removeStudent(String studentID) throws ClassRosterPersistenceException;
    
}
