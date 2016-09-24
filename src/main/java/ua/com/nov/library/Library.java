package ua.com.nov.library;

class Issue {
    private String name;
    private int countPages;

    public Issue(String name, int countPages) {
        this.name = name;
        this.countPages = countPages;
    }

    public String toPrint() {
        return "Issue{" +
                "name=" + name +
                ",countPages=" + countPages +
                "}";
    }

    public int getCountPages() {
        return countPages;
    }

    public String getName(){
        return name;
    }

}

class Journal extends Issue {
    private String yearJournal;
    private String numberJournal;

    public Journal(String nameJournal, int countPages, String yearJournal, String numberJournal) {
        super(nameJournal, countPages);
        this.yearJournal = yearJournal;
        this.numberJournal = numberJournal;
    }

    @Override
    public String toPrint() {
        return "Journal{" +
                "name=" + getName() +
                ",countPages=" + getCountPages() +
                ",year=" + yearJournal +
                ",number=" + numberJournal +
                "}";
    }
}

class Book extends Issue {

    private String authorBook;

    public Book(String name, int countPages, String authorBook) {
        super(name, countPages);
        this.authorBook = authorBook;
    }

    @Override
    public String toPrint() {
        return "Book{" +
                "name=" + getName() +
                ",countPages=" + getCountPages() +
                ",author=" + authorBook +
                "}";
    }
}

public class Library {

    public String printCatalog(Issue[] catalog) {
        String result = "";
        for (Issue issue : catalog) {
            result += issue.toPrint();
        }
        return result;
    }

    public String getIssueWithCountPagesMoreN(Issue[] catalog, int barrierCountPages) {
        String result = "";
        for (Issue issue : catalog) {
            if (issue.getCountPages() > barrierCountPages)
            result += issue.toPrint();
        }
        return result;
    }

    public static void main(String[] args) {
        int countPages = 100;

        String testNameIssue = "TestNameIssue";

        String testNameBook = "TestNameBook";
        String testAuthorBook = "TestBookAuthor";

        String testNameJournal = "TestNameJournal";
        String testYearJournal = "TestYearJournal";
        String testNumberJournal = "TestNumberJournal";


        String expectedPrintCatalog = "Issue{name=TestNameIssue,countPages=100}" +
                "Book{name=TestNameBook,countPages=100,author=TestBookAuthor}" +
                "Journal{name=TestNameJournal,countPages=100,year=TestYearJournal,number=TestNumberJournal}";

        Library library = new Library();

        Issue[] arrayIssue = new Issue[3];

        arrayIssue[0] = new Issue(testNameIssue, countPages);
        arrayIssue[1] = new Book(testNameBook, countPages, testAuthorBook);
        arrayIssue[2] = new Journal(testNameJournal, countPages, testYearJournal, testNumberJournal);

        String actualPrintCatalog = library.printCatalog(arrayIssue);

        //check
        if (actualPrintCatalog == null)
            throw new AssertionError("Result cannot be null");

        if (actualPrintCatalog.equals(expectedPrintCatalog))
            System.out.print("OK");
        else
            throw new AssertionError("Expected " + expectedPrintCatalog + " but found " + actualPrintCatalog);


    }
}
 