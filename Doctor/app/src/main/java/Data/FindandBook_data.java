package Data;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.ListItem;

/**
 * Created by juhi bhatnagar on 3/7/2017.
 */
public class FindandBook_data {
    private static List<Book> book=new ArrayList<>();
    public static List<Book>getData()
    {
        return book;
    }
    static
    {
        book.add(new Book("Doctors",11));
        book.add(new Book("Dentists",12));
        book.add(new Book("Ayurvedic Doctors",13));
        book.add(new Book("Homeopathic Doctors",14));
        book.add(new Book("Therapists & Nutritionists",15));

    }
}
