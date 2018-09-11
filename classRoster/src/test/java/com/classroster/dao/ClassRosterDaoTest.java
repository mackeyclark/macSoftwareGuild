/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classroster.dao;

import com.classroster.dto.Student;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author macam
 */
public class ClassRosterDaoTest {
    
    private ClassRosterDao dao = new ClassRosterDaoFileImpl();
    
    public ClassRosterDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        List<Student>studentList = dao.getAllStudents();
        for (Student student : studentList){
            dao.removeStudent(student.getStudentID());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addStudent method, of class ClassRosterDao.
     */
    @Test
    public void testAddGetStudent() throws Exception {
        Student student = new Student("0001");
        student.setFirstName("Frank");
        student.setLastName("Schmidt");
        student.setCohort("Aug-2020");
        
        dao.addStudent(student.getStudentID(), student);
        
        Student fromDao = dao.getStudent(student.getStudentID());
        
        assertEquals(student, fromDao);
    }

    /**
     * Test of getAllStudents method, of class ClassRosterDao.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        Student student1 = new Student("0001");
        student1.setFirstName("Jerome");
        student1.setLastName("Barker");
        student1.setCohort("April-Java-2008");
        
        dao.addStudent(student1.getStudentID(), student1);
        
        Student student2 = new Student("0002");
        student2.setFirstName("Madi");
        student2.setLastName("Gronz");
        student2.setCohort("June-Java-2009");
        
        dao.addStudent(student2.getStudentID(), student2);
        
        assertEquals(2, dao.getAllStudents().size());
    }

    /**
     * Test of removeStudent method, of class ClassRosterDao.
     */
    @Test
    public void testRemoveStudent() throws Exception {
        Student student1 = new Student("0001");
        student1.setFirstName("Jerome");
        student1.setLastName("Barker");
        student1.setCohort("April-Java-2008");
        
        dao.addStudent(student1.getStudentID(), student1);
        
        Student student2 = new Student("0002");
        student2.setFirstName("Madi");
        student2.setLastName("Gronz");
        student2.setCohort("June-Java-2009");
        
        dao.addStudent(student2.getStudentID(), student2);
        
        dao.removeStudent(student1.getStudentID());
        assertEquals(1, dao.getAllStudents().size());
        assertNull(dao.getStudent(student1.getStudentID()));
        
        dao.removeStudent(student2.getStudentID());
        assertEquals(0, dao.getAllStudents().size());
        assertNull(dao.getStudent(student2.getStudentID()));
    }

}
