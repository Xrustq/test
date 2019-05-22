package task4;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class Book {
    private String name;
    private int page;
    private List<Author> authors;

    public Book(String name, int page, List<Author> authors) {
        this.name = name;
        this.page = page;
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
