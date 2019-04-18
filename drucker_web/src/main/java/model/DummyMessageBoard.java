package model;

import java.util.ArrayList;
import java.util.Date;

public class DummyMessageBoard {
    ArrayList<Post> posts;

    public DummyMessageBoard() {
        posts = new ArrayList<>();

        ArrayList<Message> comments1 = new ArrayList<>();
        comments1.add(new Message("Spring is a framework that helps you to \"wire\" different components together. It is most useful in cases where you have a lot of components and you might decide to combine them in different ways, or wish to make it easy to swap out one component for another depending on different settings or environments.", "Felix Zhang", new Date(), 12));
        comments1.add(new Message("Design your objects so that they rely on an outside force to supply them with what they need, with the expectation that these dependencies are always injected before anybody asks them to start doing their usual jobs", "Phill Boldman", new Date(), 13));
        posts.add(new Post("What is Spring Framework?", "So, I'm starting a brand-new project in Java, and am considering using Spring. Why am I considering Spring? Because lots of people tell me I should use Spring! Seriously, any time I've tried to get people to explain what exactly Spring is or what it does, they can never give me a straight answer. I've checked the intros on the SpringSource site, and they're either really complicated or really tutorial-focused, and none of them give me a good idea of why I should be using it, or how it will make my life easier. Sometimes people throw around the term \"dependency injection\", which just confuses me even more, because I think I have a different understanding of what that term means.\n" +
                "\n" +
                "Anyway, here's a little about my background and my app :\n" +
                "\n" +
                "Been developing in Java for a while, doing back-end web development. Yes, I do a ton of unit testing. To facilitate this, I typically make (at least) two versions of a method : one that uses instance variables, and one that only uses variables that are passed in to the method. The one that uses instance variables calls the other one, supplying the instance variables. When it comes time to unit test, I use Mockito to mock up the objects and then make calls to the method that doesn't use instance variables. This is what I've always understood \"dependency injection\" to be.\n" +
                "\n" +
                "My app is pretty simple, from a CS perspective. Small project, 1-2 developers to start with. Mostly CRUD-type operations with a a bunch of search thrown in. Basically a bunch of RESTful web services, plus a web front-end and then eventually some mobile clients. I'm thinking of doing the front-end in straight HTML/CSS/JS/JQuery, so no real plans to use JSP. Using Hibernate as an ORM, and Jersey to implement the webservices.\n" +
                "\n" +
                "I've already started coding, and am really eager to get a demo out there that I can shop around and see if anyone wants to invest. So obviously time is of the essence. I understand Spring has quite the learning curve, plus it looks like it necessitates a whole bunch of XML configuration, which I typically try to avoid like the plague. But if it can make my life easier and (especially) if make it can make development and testing faster, I'm willing to bite the bullet and learn Spring.\n" +
                "\n" +
                "So please. Educate me. Should I use Spring? Why or why not?", "Mark Zuck", new Date(), 1, comments1));

        ArrayList<Message> comments2 = new ArrayList<>();
        comments2.add(new Message("Spring is a framework that helps you to \"wire\" different components together. It is most useful in cases where you have a lot of components and you might decide to combine them in different ways, or wish to make it easy to swap out one component for another depending on different settings or environments.", "Felix Zhang", new Date(), 14));
        comments2.add(new Message("Design your objects so that they rely on an outside force to supply them with what they need, with the expectation that these dependencies are always injected before anybody asks them to start doing their usual jobs", "Phill Boldman", new Date(), 15));
        posts.add(new Post("Spring Framework Is The Best", "First, what is dependency injection?\n" +
                "\n" +
                "Simple. You have a class, it has a private field (set to null) and you declare a public setter that provides the value for that field. In other words, the dependency of the class (the field) is being injected by an external class (via the setter). That's it. Nothing magical.\n" +
                "\n" +
                "Second, Spring can be used without XML (or very little)\n" +
                "\n" +
                "If you dive in with Spring 3.0.5.GA or higher then you can use the dependency injection support from JDK6+. This means that you can wire up dependencies using the @Component and @Resource annotations.", "Mark Zuck", new Date(), 3, comments2));

        posts.add(new Post("Give Spring Framework a shot!", "First of all, your understanding of dependency injection is not fundamentally wrong, but quite different from what most people mean when they use the term. What you describe is a rather strange and unconventional way to achieve testability. I'd advise you to move away from it, as other developers will be rather puzzled by that kind of code.\n" +
                "\n" +
                "Dependency injection as it's generally understood (and implemented by Spring) means that the dependencies a class has (e.g. a JDBC Datasource) are not fetched by the class itself, but \"injected\" by a container when the instance is created. So you don't have have two versions of every method that uses the Datasource; instead, you have one dependency injection configuration where the \"real\" Datasource is injected and one where a mock is injected. Or, if the injection happens via the constructor or a getter, test code can do the injection explicitly.\n" +
                "\n" +
                "Second, Spring is not just dependency injection, though that's its core functionality. It also provides declarative transactions, job scheduling, authentication, and a bunch of other functionality (including a fully-fledged MVC web framework) that you may need. There are other frameworks that provide the same functionality, but other than Spring, only Java EE has them all integrated.", "Mark Zuck", new Date(), 4, comments2));

    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public Post getPost(int pid) {
        for (Post post: posts) {
            if (post.getId() == pid) {
                return post;
            }
        }
        return null;
    }
}
