import java.util.*;
class Book
{
    String author;
    int price;
    Book(String author,int price)
    {
        this.author=author;
        this.price=price;
    }
    protected void Details()
    {
        System.out.println("author name:"+author);
        System.out.println("Price:"+price);
    }

}
class Story extends Book
{
    String title;
    int tpage;
    Story(String title,int tpage,String author,int price)
    {
        super(author,price);
        this.title=title;
        this.tpage=tpage;
    }
    public void Details()
    {
        System.out.println("*************************");
        System.out.println("Book Info");
        System.out.println("Title:"+title);
        System.out.println("Pages:"+tpage);
        super.Details();
        System.out.println("*************************");
    }
}
class Subject extends Book
{
    String sub_name;
    int tpage;
    Subject(String sub_name,int tpage,String author,int price)
    {
        super(author, price);
        this.sub_name=sub_name;
        this.tpage=tpage;
    }
    public void Details()
    {
        System.out.println("*************************");
        System.out.println("Subject"+sub_name);
        System.out.println("page"+tpage);
        super.Details();
        System.out.println("**************************");
    }
}

class Library {
    List<Book> lib=new ArrayList<>();
    public void AddBook(Book b)
    {
        lib.add(b);
        System.out.println("*****************");
        System.out.println("Added succesfully");
        System.out.println("*****************");
    }
    public void RemoveBook(String bname)
    {
        for(int i=0;i<lib.size();i++)
        {
            if(lib.get(i) instanceof Story)
            {
                Story s=(Story)lib.get(i);
                if(s.title.equals(bname))
                {
                    lib.remove(i);
                    System.out.println("*****************");
                    System.out.println("removed");
                    System.out.println("*****************");
                }
            }
            else{
                Subject s=(Subject)lib.get(i);
                if(s.sub_name.equals(bname))
                {
                    lib.remove(i);
                    System.out.println("*****************");
                    System.out.println("removed");
                    System.out.println("*****************");
                }
            }
        }
    }
    public int TotalPrice()
    {
        int res=0;
        for(Book b:lib)
        {
            res+=b.price;
        }
        return res;
    }
    public  List<Book> SortBook()
    {
        for(int j=0;j<lib.size();j++)
        {

        
            for(int i=0;i<lib.size()-1;i++)
            {
                if(lib.get(i).price<lib.get(i+1).price)
                {
                    Book temp=lib.get(i);
                    lib.set(i, lib.get(i+1));
                    lib.set(i+1,temp);
                }
             }
                 
        }
        return lib;
    }
    public void SearchBook(String bname)
    {
        for(int i=0;i<lib.size();i++)
            {
                if(lib.get(i) instanceof Story)
                {
                    Story b=(Story)lib.get(i);
                    if(b.title.equals(bname))
                    {
                        b.Details();
                    }
                    
                }
                else{
                        Subject a=(Subject)lib.get(i);
                        if(a.sub_name.equals(bname))
                        {
                            a.Details();
                            
                        }
                    }

            }
        
    }
    public void Display()
    {
        int i=1;
        for(Book l:lib)
        {
            if(l instanceof Story)
            {
                Story s=(Story)l;
                System.out.println("Book no:"+i);
                i++;
                s.Details();
            }
            else{
                Subject s=(Subject)l;
                System.out.println("Book no:"+i);
                i++;
                l.Details();
            }
            
        }
        return;
    }

}
public class LibraryManagement
{
    
    public static void main(String[] args) {
        Library ref=new Library();
        Scanner in=new Scanner(System.in);
        int i=0;
        while(true)
        {
            System.out.println("*****************");
            System.out.println("1.Add Book:");
            System.out.println("2.RemoveBook:");
            System.out.println("3.TotalPrice:");
            System.out.println("4.SortBooks:");
            System.out.println("5.SearchBooks:");
            System.out.println("6.Display All Books:");
            System.out.println("7.Exit:");
            System.out.println("*****************");
            System.out.print("enter your choice:");
            i=in.nextInt();
            
            if(i==1)
            {

                int j=0;
                System.out.println("*****************");
                System.out.println("1.Story Book:");
                System.out.println("2.Subject Book:");
                System.out.println("*****************");
                System.out.print("enter your choice:");
                j=in.nextInt();
                Book a=null;
                if(j==1)
                {
                    System.out.println("Book Details:");
                    System.out.println("Book Name:");
                    in.nextLine();
                    String bname=in.nextLine();
                    System.out.println("Pages:");
                    int pag=in.nextInt();
                    System.out.println("Author:");
                    in.nextLine();
                    String auth=in.nextLine();
                    System.out.println("Price:");
                    int pri=in.nextInt();
                    a=new Story(bname,pag,auth,pri);
                }
                if(j==2)
                {
                    System.out.println("Book Details:");
                    System.out.println("Book Name:");
                    in.nextLine();
                    String bname=in.nextLine();
                    System.out.println("Pages:");
                    int pag=in.nextInt();
                    System.out.println("Author:");
                    in.nextLine();
                    String auth=in.nextLine();
                    System.out.println("Price:");
                    int pri=in.nextInt();
                    a=new Subject(bname,pag,auth,pri);
                }
                
                ref.AddBook(a);
                

            }
            else if(i==2)
            {
                System.out.println("Book name:");
                in.nextLine();
                String a=in.nextLine();
                ref.RemoveBook(a);

            }
            else if(i==3)
            {
                System.out.println("*****************");
                System.out.println("Total price:"+ref.TotalPrice());
                System.out.println("*****************");
            }
            else if(i==4)
            {
                System.out.println("*****************");
                System.out.println("Before Sorting:");
                ref.Display();
                ref.SortBook();
                System.out.println("After Sorting:");
                ref.Display();
                System.out.println("*****************");
            }
            else if(i==5)
            {
                System.out.println("Book Name:");
                in.nextLine();
                String s=in.nextLine();
                ref.SearchBook(s);


            }
            else if(i==6)
            {
                ref.Display();
            }
            else{
                break;
            }

            
        }
        in.close();
    }
}
