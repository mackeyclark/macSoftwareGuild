/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.library.dao;

import com.sg.library.model.Author;
import com.sg.library.model.Book;
import com.sg.library.model.Publisher;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author macam
 */
public class LibraryDaoTest {
    
    LibraryDao dao;
    
    public LibraryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        dao = ctx.getBean("libraryDao", LibraryDao.class);
        
        // delete all books
        List<Book> books = dao.getAllBooks();
        for(Book currentBook : books) {
            dao.deleteBook(currentBook.getBookId());
        }
        
        // delete all authors
        List<Author> authors = dao.getAllAuthors();
        for(Author currentAuthor : authors) {
            dao.deleteAuthor(currentAuthor.getAuthorId());
        }
        
        // delete all publishers
        List<Publisher> publishers = dao.getAllPublishers();
        for(Publisher currentPublisher : publishers) {
            dao.deletePublisher(currentPublisher.getPublisherId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addAuthor method, of class LibraryDao.
     */
    @Test
    public void testAddGetAuthor() {
        Author author = new Author();
        author.setFirstName("Author");
        author.setLastName("Test");
        author.setStreet("123 Main Street");
        author.setCity("Author Town");
        author.setState("PA");
        author.setZip("55442");
        author.setPhone("867-5309");
        
        dao.addAuthor(author);
        
        Author fromDao = dao.getAuthorById(author.getAuthorId());
        assertEquals(fromDao, author);
    }

    /**
     * Test of deleteAuthor method, of class LibraryDao.
     */
    @Test
    public void testDeleteAuthor() {
        Author author = new Author();
        author.setFirstName("Author");
        author.setLastName("Test");
        author.setStreet("123 Main Street");
        author.setCity("Author Town");
        author.setState("PA");
        author.setZip("55442");
        author.setPhone("867-5309");
        
        dao.addAuthor(author);
        
        Author fromDao = dao.getAuthorById(author.getAuthorId());
        assertEquals(fromDao, author);
        dao.deleteAuthor(author.getAuthorId());
        assertNull(dao.getAuthorById(author.getAuthorId()));
    }
    /**
     * Test of addBook method, of class LibraryDao.
     */
    @Test
    public void testAddGetBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Pub One");
        publisher.setStreet("123 Main Street");
        publisher.setCity("Publisher City");
        publisher.setState("OH");
        publisher.setZip("44123");
        publisher.setPhone("555-1213");
        
        dao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("Author");
        author.setLastName("Test");
        author.setStreet("123 Main Street");
        author.setCity("Author Town");
        author.setState("PA");
        author.setZip("55442");
        author.setPhone("867-5309");
        
        dao.addAuthor(author);

        Book b = new Book();
        b.setIsbn("12345");
        b.setTitle("Test Book");
        b.setPrice(new BigDecimal("12.34"));
        b.setPublishDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));
        b.setPublisher(publisher);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        b.setAuthors(authors);
        
        dao.addBook(b);
        
        Book fromDao = dao.getBookById(b.getBookId());
        
        assertEquals(fromDao, b);
    }

    /**
     * Test of deleteBook method, of class LibraryDao.
     */
    @Test
    public void testDeleteBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Pub One");
        publisher.setStreet("123 Main Street");
        publisher.setCity("Publisher City");
        publisher.setState("OH");
        publisher.setZip("44123");
        publisher.setPhone("555-1213");
        
        dao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("Author");
        author.setLastName("Test");
        author.setStreet("123 Main Street");
        author.setCity("Author Town");
        author.setState("PA");
        author.setZip("55442");
        author.setPhone("867-5309");
        
        dao.addAuthor(author);

        Book b = new Book();
        b.setIsbn("12345");
        b.setTitle("Test Book");
        b.setPrice(new BigDecimal("12.34"));
        b.setPublishDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));
        b.setPublisher(publisher);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        b.setAuthors(authors);
        
        dao.addBook(b);
        
        Book fromDao = dao.getBookById(b.getBookId());
        
        assertEquals(fromDao, b);
        dao.deleteBook(b.getBookId());
        assertNull(dao.getBookById(b.getBookId()));
    }
    /**
     * Test of addPublisher method, of class LibraryDao.
     */
    @Test
    public void testAddGetPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Pub One");
        publisher.setStreet("123 Main Street");
        publisher.setCity("Publisher City");
        publisher.setState("OH");
        publisher.setZip("44123");
        publisher.setPhone("555-1213");
        
        dao.addPublisher(publisher);
        
        Publisher fromDao = dao.getPublisherById(publisher.getPublisherId());
        
        assertEquals(fromDao, publisher);
    }

    /**
     * Test of deletePublisher method, of class LibraryDao.
     */
    @Test
    public void testDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Pub One");
        publisher.setStreet("123 Main Street");
        publisher.setCity("Publisher City");
        publisher.setState("OH");
        publisher.setZip("44123");
        publisher.setPhone("555-1213");
        
        dao.addPublisher(publisher);
        
        Publisher fromDao = dao.getPublisherById(publisher.getPublisherId());
        assertEquals(fromDao, publisher);
        dao.deletePublisher(publisher.getPublisherId());
        assertNull(dao.getPublisherById(publisher.getPublisherId()));
        
    }

}
