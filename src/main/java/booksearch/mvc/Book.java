
package booksearch.mvc;

public class Book {
    private String bookname;
    private double bookprice;
    private String sub;
    private int bid;
    
    public Book(){
        
    }
    public Book(int bid, String bookname, String sub,double bookprice) {
        this.bookname = bookname;
        this.bookprice = bookprice;
        this.sub = sub;
        this.bid = bid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public double getBookprice() {
        return bookprice;
    }

    public void setBookprice(double bookprice) {
        this.bookprice = bookprice;
    }
    public String getSubject(){
        return sub;
    }
    public int getBid(){
        return bid;
    }
    public void setBid(int bid){
        this.bid=bid;
    }
    public void setSubject(String sub){
        this.sub=sub;
    }
	@Override
	public String toString() {
		return "Book [bookname=" + bookname + ", bookprice=" + bookprice + ", sub=" + sub + ", bid=" + bid + "]";
	}
    
}
