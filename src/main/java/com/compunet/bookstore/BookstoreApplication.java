package com.compunet.bookstore;

import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.services.IBookService;
import com.compunet.bookstore.services.impl.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class    BookstoreApplication {
    // private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) throws ParseException {

        ConfigurableApplicationContext context = SpringApplication.run(BookstoreApplication.class, args);
        IBookService service = context.getBean("bookService", BookService.class);

        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

        // burned models
        service.save(new Book("To Kill a Mockingbird", date1, "Harper Lee"));
        service.save(new Book( "1984", date1, "George Orwell"));
        service.save(new Book( "The Great Gatsby", date1, "F. Scott Fitzgerald"));
    }

}
